import { HttpClient, HttpHeaders,HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { environment } from '../../../../../environments/environment';
import { Product } from '../../../../shared/models/product';
import { catchError } from 'rxjs/internal/operators/catchError';
import { deal } from 'src/app/shared/models/deal';


@Injectable({
  providedIn: 'root'
})
export class SellerDealAddService {

  private headers=new HttpHeaders({'Content-Type':'application/json'});
  constructor(private http: HttpClient) { }

  addToDeal(dealToAdd:deal): Observable<String> {
    let url: string= environment.dealAPI+ '/addDeal';
     return this.http.post<String>(url, dealToAdd,{ headers: this.headers, responseType: 'text' as 'json' })
      .pipe(catchError(this.handleError));
  }
  getDealsForPage(emailId:String):Observable<Product[]>{

    const url=environment.dealAPI+ '/productsForDealPage/'+emailId+'/';
    return this.http.get<Product[]>(url)
    .pipe(catchError(this.handleError));
  }
 removeFromAddPage(emailId:String,productId):Observable<String>{
  const url: string= environment.dealAPI+ '/removeFromAddDeal/'+emailId+'/'+productId;
  return this.http.post<String>(url,productId,{ headers: this.headers, responseType: 'text' as 'json' })
   .pipe(catchError(this.handleError));
 }
  
  private handleError(err: HttpErrorResponse) {
    console.log(err)
    let errMsg: string = '';
    if (err.error instanceof Error) {
      errMsg = err.error.message;
      console.log(errMsg)
    }
       else if(err.status==406 )
      errMsg=" Invalid Date_Time Format! Try again";

    else if (typeof err.error === 'string') {
      errMsg = JSON.parse(err.error).message
    }
    else {
      if (err.status == 0) {
        errMsg = "A connection to back end can not be established.";
      } 
      else {
        errMsg = err.error.message;
      }
    }
    return throwError(errMsg);
  }
}