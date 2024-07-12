import { Component, OnInit } from '@angular/core';
import { IpService } from 'src/app/ip.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  myIp: string | undefined;
  ipDetails: string | undefined;

  constructor(private ipService: IpService) { }

  showMyIp(): void {
    this.ipService.getMyIp().subscribe(data => {
      this.myIp = data;
    });
  }

  showIpDetails(ip: string): void {
    this.ipService.getIpDetails(ip).subscribe(data => {
      this.ipDetails = data;
    });
  }

}
