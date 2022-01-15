"use strict";
var __createBinding = (this && this.__createBinding) || (Object.create ? (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    Object.defineProperty(o, k2, { enumerable: true, get: function() { return m[k]; } });
}) : (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    o[k2] = m[k];
}));
var __setModuleDefault = (this && this.__setModuleDefault) || (Object.create ? (function(o, v) {
    Object.defineProperty(o, "default", { enumerable: true, value: v });
}) : function(o, v) {
    o["default"] = v;
});
var __importStar = (this && this.__importStar) || function (mod) {
    if (mod && mod.__esModule) return mod;
    var result = {};
    if (mod != null) for (var k in mod) if (k !== "default" && Object.prototype.hasOwnProperty.call(mod, k)) __createBinding(result, mod, k);
    __setModuleDefault(result, mod);
    return result;
};
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const express_1 = __importDefault(require("express"));
const body_parser_1 = __importDefault(require("body-parser"));
const db = __importStar(require("./db"));
const app = (0, express_1.default)();
const port = 9000;
app.use(body_parser_1.default.json());
app.use(body_parser_1.default.urlencoded({ extended: true }));
app.post('/add-fridge', (req, res) => __awaiter(void 0, void 0, void 0, function* () {
    const id = yield db.addFridge();
    res.json(id);
}));
app.post('/check-fridge', (req, res) => __awaiter(void 0, void 0, void 0, function* () {
    const { fridgeId } = req.body;
    if (yield db.checkFridge(fridgeId))
        res.send();
    else
        res.status(400).send();
}));
app.post('/get-fridge', (req, res) => __awaiter(void 0, void 0, void 0, function* () {
    const { fridgeId } = req.body;
    const f = yield db.getFridge(fridgeId);
    if (f)
        res.send(f);
    else
        res.status(400).send();
}));
app.post('/add-product', (req, res) => __awaiter(void 0, void 0, void 0, function* () {
    const product = req.body;
    if (!product)
        return res.status(400).send();
    const productId = yield db.addProduct(product);
    if (!productId)
        return res.status(400).send();
    res.send({ productId });
}));
app.post('/delete-product', (req, res) => __awaiter(void 0, void 0, void 0, function* () {
    const productId = req.body;
    const result = yield db.deleteProduct(productId);
    if (result)
        res.send();
    else
        res.status(500).send();
}));
app.post('/update-product', (req, res) => __awaiter(void 0, void 0, void 0, function* () {
    const product = req.body;
    if (yield db.updateProduct(product))
        res.send();
    else
        res.status(400).send();
}));
app.listen(port, () => {
    console.log(`App listening at http://localhost:${port}`);
});
