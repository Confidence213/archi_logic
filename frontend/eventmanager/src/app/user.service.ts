import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, Subject, of } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';

import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private notifier = new Subject<any>();
  
  private url = 'http://localhost:8080/users';
  
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

  getUserList(): Observable<User[]> {
    return this.http.get<User[]>(this.url, this.httpOptions).pipe(
      tap(_ => this.log(`fetched user list`)),
      catchError(this.handleError<User[]>(`getUserList`))
    );
  }

  getUser(username: string): Observable<User> {
    const url = `${this.url}/${username}`;
    return this.http.get<User>(url, this.httpOptions).pipe(
      tap(_ => this.log(`fetched user username=${username}`)),
      catchError(this.handleError<User>(`getUser username=${username}`))
    );
  }

  addUser(user: User): Observable<User> {
    return this.http.post<User>(this.url, user, this.httpOptions).pipe(
      tap((newUser: User) => this.log(`added user username=${newUser.username}`)),
      catchError(this.handleError<User>('addUser'))
    );
  }

  updateUser(user: User): Observable<any> {
    return this.http.put(this.url, user, this.httpOptions).pipe(
      tap(_ => this.log(`updated user username=${user.username}`)),
      catchError(this.handleError<any>('updateUser'))
    );
  }

  deleteUser(username: string): Observable<User> {
    const url = `${this.url}/${username}`;
    return this.http.delete<User>(url, this.httpOptions).pipe(
      tap(_ => this.log(`deleted user username=${username}`)),
      catchError(this.handleError<User>('deleteUser'))
    );
  }

  private log(message: string) {
    console.log(`UserService: ${message}`);
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);  
      return of(result as T);
    };
  }

}
