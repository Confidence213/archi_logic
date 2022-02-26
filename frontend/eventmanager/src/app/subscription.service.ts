import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, Subject, of } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';

import { Subscription } from './subscription';

@Injectable({
  providedIn: 'root'
})
export class SubscriptionService {

  private notifier = new Subject<any>();

  private url = 'http://localhost:8080/subscriptions';
  
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(private http: HttpClient) { }

  sendUpdate(message: string) {
    this.notifier.next(message);
  }

  getUpdate(): Observable<any> {
      return this.notifier.asObservable();
  }

  getSubscriptionList(): Observable<Subscription[]> {
    return this.http.get<Subscription[]>(this.url, this.httpOptions).pipe(
      tap(_ => this.log(`fetched subscription list`)),
      catchError(this.handleError<Subscription[]>(`getSubscriptionList`))
    );
  }

  getSubscription(ticketNumber: number): Observable<Subscription> {
    const url = `${this.url}/${ticketNumber}`;
    return this.http.get<Subscription>(url, this.httpOptions).pipe(
      tap(_ => this.log(`fetched subscription ticketNumber=${ticketNumber}`)),
      catchError(this.handleError<Subscription>(`getSubscription ticketNumber=${ticketNumber}`))
    );
  }

  addSubscription(subscription: Subscription): Observable<Subscription> {
    return this.http.post<Subscription>(this.url, subscription, this.httpOptions).pipe(
      tap((newSubscription: Subscription) => this.log(`added subscription ticketNumber=${newSubscription.ticketNumber}`)),
      catchError(err => {
        switch (err.status) {
          case 404:
            err.message = "Given user and/or event does not exist.";
            break;
          case 400:
            err.message = "A subscription with the same ID already exists.";
            break;
          default:
            err.message = "An error occured.";
        }
        console.error(err.message, err);
        throw err;
      })
    );
  }

  updateSubscription(subscription: Subscription): Observable<any> {
    return this.http.put(this.url, subscription, this.httpOptions).pipe(
      tap(_ => this.log(`updated subscription ticketNumber=${subscription.ticketNumber}`)),
      catchError(this.handleError<any>('updateSubscription'))
    );
  }

  deleteSubscription(ticketNumber: number): Observable<Subscription> {
    const url = `${this.url}/${ticketNumber}`;
    return this.http.delete<Subscription>(url, this.httpOptions).pipe(
      tap(_ => this.log(`deleted subscription ticketNumber=${ticketNumber}`)),
      catchError(this.handleError<Subscription>('deleteSubscription'))
    );
  }

  private log(message: string) {
    console.log(`SubscriptionService: ${message}`);
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);  
      return of(result as T);
    };
  }

}
