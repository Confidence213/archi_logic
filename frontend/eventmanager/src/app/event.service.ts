import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, Subject, of } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';

import { Event } from './event';

@Injectable({
  providedIn: 'root'
})
export class EventService {

  private notifier = new Subject<any>();

  private url = 'http://localhost:8080/events';
  
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

  getEventList(): Observable<Event[]> {
    return this.http.get<Event[]>(this.url, this.httpOptions).pipe(
      tap(_ => this.log(`fetched event list`)),
      catchError(this.handleError<Event[]>(`getEventList`))
    );
  }

  getEvent(id: number): Observable<Event> {
    const url = `${this.url}/${id}`;
    return this.http.get<Event>(url, this.httpOptions).pipe(
      tap(_ => this.log(`fetched event id=${id}`)),
      catchError(this.handleError<Event>(`getEvent id=${id}`))
    );
  }

  addEvent(event: Event): Observable<Event> {
    return this.http.post<Event>(this.url, event, this.httpOptions).pipe(
      tap((newEvent: Event) => this.log(`added event id=${newEvent.id}`)),
      catchError(err => {
        switch (err.status) {
          case 400:
            err.message = "An event with the same ID already exists.";
            break;
          default:
            err.message = "An error occured.";
        }
        console.error(err.message, err);
        throw err;
      })
    );
  }

  updateEvent(event: Event): Observable<any> {
    return this.http.put(this.url, event, this.httpOptions).pipe(
      tap(_ => this.log(`updated event id=${event.id}`)),
      catchError(this.handleError<any>('updateEvent'))
    );
  }

  deleteEvent(id: number): Observable<Event> {
    const url = `${this.url}/${id}`;
    return this.http.delete<Event>(url, this.httpOptions).pipe(
      tap(_ => this.log(`deleted event id=${id}`)),
      catchError(this.handleError<Event>('deleteEvent'))
    );
  }

  private log(message: string) {
    console.log(`EventService: ${message}`);
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);  
      return of(result as T);
    };
  }

}