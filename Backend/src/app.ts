import express, {Application, Request, Response} from 'express'
import bodyParser, { urlencoded } from 'body-parser'
import * as db from './db'

const app = express()
const port = 9000

app.use(bodyParser.json())
app.use(bodyParser.urlencoded({ extended: true }))

app.post('/add-fridge', async (req: Request, res: Response) => {
	const fridgeId = await db.addFridge()
	res.json({fridgeId})
})

app.post('/check-fridge', async (req: Request, res: Response) => {
	const { fridgeId } = req.body
	if (await db.checkFridge(fridgeId)) res.send()
	else res.status(400).send()
})

app.post('/get-fridge', async (req: Request, res: Response) => {
	const { fridgeId } = req.body
	const f = await db.getFridge(fridgeId)
	if (f) res.send(f)
	else res.status(400).send()
})

app.post('/add-product', async (req: Request, res: Response) => {
	const product = req.body
	if (!product) return res.status(400).send()

	const productId = await db.addProduct(product)
	if (!productId) return res.status(400).send()

	res.send({productId})
})

app.post('/delete-product', async (req: Request, res: Response) => {
	const productId = req.body
	const result = await db.deleteProduct(productId)
	if (result) res.send()
	else res.status(400).send()
})

app.post('/update-product', async (req: Request, res: Response) => {
	const product = req.body
	if (await db.updateProduct(product)) res.send()
	else res.status(400).send()
})

app.listen(port, () => {
	console.log(`App listening at http://localhost:${port}`)
})
