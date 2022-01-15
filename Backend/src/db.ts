import { v4 as uuid } from 'uuid'
import fs from 'fs'

export type Id = String

export interface Product {
	productId: Id
	fridgeId: Id
	name: String
	opened?: Boolean
	image: String // base64 encoded
	addDate: Number // unix timestamp
	expDate: Number // unix timestamp
}

export interface Fridge {
	fridgeId: String
	products: Product[]
}

interface Db {
	fridge: Fridge[]
}

const db: Db = JSON.parse(fs.readFileSync('./db.json').toString())

const unique = () => uuid().slice(0, 6)
const save = () => new Promise(resolve => fs.writeFile('./db.json', JSON.stringify(db, null, 2), resolve))

export const addFridge = async (): Promise<Id> => {
    const id = unique()
	const fridge: Fridge = {
		fridgeId: id,
		products: []
	}
	
	db.fridge.push(fridge)
    console.log({fridge})
	save()

    return id
}

export const checkFridge = async (fridgeId: Id): Promise<boolean> => {
	const f = db.fridge.find(f => f.fridgeId == fridgeId)
	return f ? true : false
}

export const getFridge = async (fridgeId: Id): Promise<undefined | Fridge> => {
	const f = db.fridge.find(f => f.fridgeId == fridgeId)
	return f
}

export const addProduct = async (p: Product): Promise<undefined | Id> => {
	const f = db.fridge.find(f => f.fridgeId == p.fridgeId)
	if (!f) return
	
	const productId = unique()
	f.products.push({...p, productId})
	save()

	return productId
}

export const updateProduct = async (p: Product) => {
	const fridge = db.fridge.find(x => x.fridgeId == p.fridgeId)
	if (!fridge) return false

	const i = fridge.products.findIndex(x => x.productId == p.productId && x.fridgeId == p.fridgeId)

	if (i == -1) return false
	fridge.products[i] = {...fridge.products[i], ...p}
	save()

	return true
}

export const deleteProduct = async (p: Product) => {
	const fridge = db.fridge.find(x => x.fridgeId == p.fridgeId)
	if (!fridge) return false

	const i = fridge.products.findIndex(x => x.productId == p.productId && x.fridgeId == p.fridgeId)

	if (i == -1) return false
	fridge.products.splice(i, 1)
	save()

	return true
}