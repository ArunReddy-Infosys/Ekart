
import { Injectable } from '@angular/core';
import { deal } from 'src/app/shared/models/deal';
import { HttpClient, HttpHeaders, HttpErrorResponse } from "@angular/common/http";
import { Observable,throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { catchError } from 'rxjs/internal/operators/catchError';

@Injectable({
  providedIn: 'root'
})
export class ViewTodayDealsService {

  constructor(private http: HttpClient) { }
  getTodayDeals(): Observable<deal[]>{
    let url=environment.CustomerProductAPI + "/getDeal";
    return this.http.get<deal[]>(url)
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
