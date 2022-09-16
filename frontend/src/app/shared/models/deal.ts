import { Variable } from '@angular/compiler/src/render3/r3_ast';
import { Product } from './product'

export class deal{
    successMessage:String;
    errorMessage:String;
dealId:Number;
dealDiscount:Number;
dealStart:String;
dealEnd:String;
sellerEmailId:String;
product:Product;
dealStatus:String;
dealResult:Boolean;

}