import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from "@angular/common/http";
import { Observable, throwError } from 'rxjs';
import {deal} from 'src/app/shared/models/deal';
import { environment} from 'src/environments/environment';
import { catchError } from 'rxjs/internal/operators/catchError';


@Injectable({
  providedIn: 'root'
})
export class SellerTodaysDealService {
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });
  constructor(private http: HttpClient) { }

  getDeal(sellerEmailId:String): Observable<deal[]> {
    const url = environment.dealAPI + '/displayDeal'+'/'+sellerEmailId+'/';
    return this.http.get<deal[]>(url)
      .pipe(catchError(this.handleError));

  }

  removeDeal(dealId:Number): Observable<Number> {
    const url = environment.dealAPI+ '/removeDeal'+'/'+dealId+'/';
    //console.log(JSON.stringify(dealId))
    return this.http.post<Number>(url,dealId)
      .pipe(catchError(this.handleError));

  }
   
  private handleError(err: HttpErrorResponse) {
    console.log(err)
    let errMsg:string='';
    if (err.error instanceof Error) {   
        errMsg=err.error.message;
        console.log(errMsg)
    }
     else if(typeof err.error === 'string'){
        errMsg=JSON.parse(err.error).message
    }
    else {
       if(err.status==0){ 
           errMsg="A connection to back end can not be established.";
       }else{
           errMsg=err.error.message;
       }
     }
        return throwError(errMsg);
}
}

