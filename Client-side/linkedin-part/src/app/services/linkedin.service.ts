import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LinkedinService {
  constructor(private http: HttpClient) { }
  // get data by Id from rest api
  getDataById(id: string): Observable<any> {
    return this.http.get('http://localhost:8090/api/candidate/id/' + id);
  }

  // get data by username from Rest api
  getDataByUserName(userName: string): Observable<any> {
    return this.http.get('http://localhost:8090/api/candidate/username/' + userName);
  }
   // send data to Rest api
  postData(token: string, userName: string): Observable<any> {
    const httpOptions = {
          headers: new HttpHeaders({
            Authorization: token,
          })
        };
    return this.http.post('http://localhost:8090/api/candidate', userName, httpOptions);
  }
}
