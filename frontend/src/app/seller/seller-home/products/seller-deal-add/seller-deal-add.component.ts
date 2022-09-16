import { Component, Input, OnInit } from '@angular/core';
import { SellerDealAddService } from './seller-deal-add.service';
import { Product } from '../../../../shared/models/product';
import {deal} from '../../../../shared/models/deal';
import { Seller } from '../../../../shared/models/seller';
import { formatDate, getLocaleDateTimeFormat } from '@angular/common';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-seller-deal-add',
  templateUrl: './seller-deal-add.component.html'
//  styleUrls: ['./seller-deal-add.component.css']
})
export class SellerDealAddComponent implements OnInit {
  dealToAdd:any
  message:String="";
  msg:String="";
  errorMessage: string = "";
  dealAddForm:FormGroup
  seller: Seller
  p:Number=1
  count:Number=10
  @Input()
 // productList:deal[]
  productList: Product[]
  productDetails:Product
  dealList:deal[]
  addNewDeal:deal
  addDealClick:Boolean
  displayProduct:Boolean
  

  ngOnInit()
   {
     this.addNewDeal=new deal();
    this.seller = JSON.parse(sessionStorage.getItem("seller"));
   //this.productList = JSON.parse(sessionStorage.getItem("sellerProducts"));
     this.SellerDealAddService.getDealsForPage(this.seller.emailId).subscribe(
       response=>{
         this.productList=response
       },
       error =>this.errorMessage=<any>error
     )
    this.displayProduct = true
    this.addDealClick=false
    
    this.createForm()
  }

  constructor(private fb: FormBuilder,private SellerDealAddService:SellerDealAddService) { }
  
   showDealForm(product:Product)
  {
    this.productDetails=new Product

    this.productDetails=product
    this.addDealClick = true
    this.displayProduct = false
  }

createForm()
{
 this.dealAddForm=this.fb.group({
   dealStart:["",Validators.required],
   dealEnd:["",Validators.required],
   dealDiscount:["",[Validators.required,Validators.min(1),Validators.max(99)]]
 });
 
}
 
  addDealDetails()
  {
  
     this.message=null;
     let dealToAdd:deal=this.dealAddForm.value as deal;
     dealToAdd.product=this.productDetails;
     dealToAdd.sellerEmailId=this.seller.emailId;
     this.SellerDealAddService.addToDeal(this.dealAddForm.value).subscribe(response=>{
     
      this.message = response
      this.errorMessage=""
      let dealID:number
      dealID = +(this.message.split(":")[1])
      dealToAdd.dealId=dealID

      this.SellerDealAddService.removeFromAddPage(this.seller.emailId,this.productDetails.productId).subscribe( response=>{
        this.msg=response
       },
       error => this.errorMessage = <any>error)
        

            if(this.message!='')
            {
              setTimeout(() => {
                this.dealAddForm.reset();
               window.location.reload(true)
               }, 4000);
      
            }
       },
    
       error =>{this.errorMessage=  error
        
        setTimeout(() => {
          this.dealAddForm.reset();
          window.location.reload(true)
         }, 4000); 
      });
      
}

reload()
{
  this.message="";
  this.errorMessage="";
  this.addDealClick=false
  this.dealAddForm.reset();
}
}

