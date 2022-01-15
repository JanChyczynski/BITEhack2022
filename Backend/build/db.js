"use strict";
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
exports.deleteProduct = exports.updateProduct = exports.addProduct = exports.getFridge = exports.checkFridge = exports.addFridge = void 0;
const uuid_1 = require("uuid");
const fs_1 = __importDefault(require("fs"));
const db = JSON.parse(fs_1.default.readFileSync('./db.json').toString());
const unique = () => (0, uuid_1.v4)().slice(0, 6);
const save = () => new Promise(resolve => fs_1.default.writeFile('./db.json', JSON.stringify(db, null, 2), resolve));
const addFridge = () => __awaiter(void 0, void 0, void 0, function* () {
    const id = unique();
    const fridge = {
        fridgeId: id,
        products: []
    };
    db.fridge.push(fridge);
    console.log({ fridge });
    save();
    return id;
});
exports.addFridge = addFridge;
const checkFridge = (fridgeId) => __awaiter(void 0, void 0, void 0, function* () {
    const f = db.fridge.find(f => f.fridgeId == fridgeId);
    return f ? true : false;
});
exports.checkFridge = checkFridge;
const getFridge = (fridgeId) => __awaiter(void 0, void 0, void 0, function* () {
    const f = db.fridge.find(f => f.fridgeId == fridgeId);
    return f;
});
exports.getFridge = getFridge;
const addProduct = (p) => __awaiter(void 0, void 0, void 0, function* () {
    const f = db.fridge.find(f => f.fridgeId == p.fridgeId);
    if (!f)
        return;
    const productId = unique();
    f.products.push(Object.assign(Object.assign({}, p), { productId }));
    save();
    return productId;
});
exports.addProduct = addProduct;
const updateProduct = (p) => __awaiter(void 0, void 0, void 0, function* () {
    const fridge = db.fridge.find(x => x.fridgeId == p.fridgeId);
    if (!fridge)
        return false;
    const i = fridge.products.findIndex(x => x.productId == p.productId && x.fridgeId == p.fridgeId);
    if (i == -1)
        return false;
    fridge.products[i] = Object.assign(Object.assign({}, fridge.products[i]), p);
    save();
    return true;
});
exports.updateProduct = updateProduct;
const deleteProduct = (p) => __awaiter(void 0, void 0, void 0, function* () {
    console.log(p);
    const fridge = db.fridge.find(x => x.fridgeId == p.fridgeId);
    if (!fridge)
        return false;
    const i = fridge.products.findIndex(x => x.productId == p.productId && x.fridgeId == p.fridgeId);
    if (i == -1)
        return false;
    fridge.products.splice(i, 1);
    save();
    return true;
});
exports.deleteProduct = deleteProduct;
