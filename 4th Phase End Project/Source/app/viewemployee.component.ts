import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeserviceService } from '../employeeservice.service';
import { HttpClient, HttpClientModule } from '@angular/common/http';


@Component({
  selector: 'app-viewemployee',
  templateUrl: './viewemployee.component.html',
  styleUrl: './viewemployee.component.css'
})

export class ViewemployeeComponent implements OnInit {

  employees: any[]=[];
  employee: any;
  isEditing = false;
  originalEmployee: any;
  id=0

  constructor( private route: ActivatedRoute, private router: Router, private employeeService: EmployeeserviceService, private http:HttpClient ) {}
  
  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.employeeService.getEmployeeById(this.id).subscribe(data=>this.employee=data)
}

deleteEmployee(): void {
  if (this.employee) {
  this.employeeService.deletEmployee(this.employee.id).subscribe(() => {
  this.router.navigate(['/eventemployees']);
  });
  }
}

}

