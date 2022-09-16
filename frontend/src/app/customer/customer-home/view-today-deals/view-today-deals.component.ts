import { Component, OnInit } from '@angular/core';
import { deal } from 'src/app/shared/models/deal';
import { ViewTodayDealsService } from './view-today-deals.service';
import { CustomerSharedService } from '../customer-shared-service';
import { Router, ActivatedRoute } from '@angular/router';
import { Product } from 'src/app/shared/models/product';

@Component({
  selector: 'app-view-today-deals',
  templateUrl: './view-today-deals.component.html',
  styleUrls: ['./view-today-deals.component.css']
})
export class ViewTodayDealsComponent implements OnInit {
  successMessage: string;
  errorMessage: string;
  dealList :deal[];
  dealListToDisplay : deal[]=[];
  displayProduct : Product;
  currentDate:Date=new Date();
  result: number;
  display: Boolean=false;
  p:number=1;
  count:number=10;
  constructor(private viewTodayDealsService:ViewTodayDealsService,
   private sharedService:CustomerSharedService,
   private router:Router,
   private route:ActivatedRoute ) { }

  ngOnInit() {
    this.displayProduct=null;
    this.getTodayDeals();
  }
  getTodayDeals()
  {
    
    this.viewTodayDealsService.getTodayDeals().subscribe(deals=>
      {
        this.dealList=deals;
        this.dealListToDisplay=this.dealList;
      });

  }
  viewProductDetails(product:Product)
  {
    this.displayProduct=product;
    this.display=true;
    console.log(product); 
    this.displayProduct.brand=product.brand;
    this.displayProduct.description=product.description;
  
    
   } 
}