import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import { Room } from '../room/room.component';
import { Subject } from 'rxjs';
@Injectable({
  providedIn: 'root'
  
})
export class HotelService {
  dataTemp = new Subject<string>();
  public API = '//localhost:8080';
  private serviceUrl = '//localhost:8080/rooms';
  constructor(private http: HttpClient) { }
  getHotelNameEng():Observable<any>{
    return this.http.get(this.API + '/hotels');
  }
  getRoomStatus():Observable<any>{
    return this.http.get(this.API + '/roomstatuses');
  }
  getRoomType():Observable<any>{
    return this.http.get(this.API + '/roomtypes');
  }
  getRoom():Observable<Room[]>{
    return this.http.get<Room[]>(this.serviceUrl);
  }
}
