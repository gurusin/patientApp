import {UnitOfMeasure} from "./unit-of-measure";
import {ProductType} from "./product-type";

export class Itemproduct {

  itemId: number;
  productType: ProductType;
  itemDescription:string;
  unitOfMeasure:UnitOfMeasure;
  minOrderLevel:number;
  quantity:number;
  unitPrice:number;

  constructor(){
    this.productType = new ProductType();
    this.unitOfMeasure = new UnitOfMeasure();
  }
}
