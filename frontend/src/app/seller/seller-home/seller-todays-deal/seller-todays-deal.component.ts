import { Component, OnInit, Input } from '@angular/core';
import { Seller } from 'src/app/shared/models/seller';
import { Product } from 'src/app/shared/models/product';
import { FormBuilder } from '@angular/forms';

import { deal } from 'src/app/shared/models/deal';
import { SellerTodaysDealService } from './seller-todays-deal.service';


@Component({
  selector: 'app-seller-todays-deal',
  templateUrl: './seller-todays-deal.component.html',
  styleUrls: ['./seller-todays-deal.component.css']
})
export class SellerTodaysDealComponent implements OnInit {
  errorMessage: string = "";
  successMessage: string = "";
  seller: Seller
  product
  productCategoryList: string[]
  @Input()
  productRecieved: Product
  productList: Product[]
  displayProducts: Boolean
  productSortedList: Product[]
  dealsProductCategoryList: string[]
  dealsProductList: deal[] =[]                
  deal: deal;
  display:Boolean=false;
  p:Number =1;
  count: Number = 10;
  constructor(private dealsService:SellerTodaysDealService) { }
 
  ngOnInit() {
       this.seller = JSON.parse(sessionStorage.getItem("seller"));
    this.dealsService.getDeal(this.seller.emailId)
      .subscribe(deals => {
        this.dealsProductList = deals
      }
      , error => {
        this.errorMessage = <any>error
        this.successMessage = "";
      }
      
    )



    this.displayProducts = true
    
    
         
     }

     
     
     Details(product:Product){
      this.product=product;
      this.display=true;
    }
  
     removeDeal(deal:deal) {
    this.deal=deal
    this.dealsService.removeDeal(deal.dealId).subscribe(
      (response) => {
        this.successMessage = "Product in deal removed successfully";
        this.errorMessage = ""
               let newDealList: deal[] = []
        for (let deal1 of this.dealsProductList) {
          if (deal1.dealId!= deal.dealId) {
            newDealList.push(deal1)
          }
        }
         this.dealsProductList = newDealList
       

      }, error => {
        
      
        this.errorMessage = <any>error
        
      }
    )


  }
  }