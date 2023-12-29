import { Component , OnInit , ElementRef, ViewChild, AfterViewInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient, HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'eventmanagement';

  constructor(private modalService: NgbModal, private router: Router){}


  public open(modal: any): void {
    this.modalService.open(modal);
  }

  directlogin(): void {

    this.router.navigate(['/loginpage']);
    
  }

}
