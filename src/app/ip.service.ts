import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class IpService {

  url = "http://localhost:8080/api"

  constructor(private http: HttpClient) { }

  getIp() {
    return this.http.get(this.url + "/" + "my-ip")
  }

  getMyIp(): Observable<string> {
    return this.http.get(`${this.url}/my-ip`, { responseType: 'text' });
  }

  getIpDetails(ip: string): Observable<string> {
    return this.http.get(`${this.url}/ip-info/${ip}`, { responseType: 'text' });
  }
}
