import { Component, OnInit  } from '@angular/core';
import { EmployeeserviceService } from '../employeeservice.service'

@Component({
  selector: 'app-eventemployees',
  templateUrl: './eventemployees.component.html',
  styleUrl: './eventemployees.component.css'
})
export class EventemployeesComponent {

  employees: any[]=[];
  id=""
  first_name=""
  last_name=""
  email=""

  constructor(private employeeservice: EmployeeserviceService){}

  ngOnInit(): void {
    this.getEmployees();
  }

  getEmployees(): void{
    this.employeeservice.getEmployees().subscribe(data=>{this.employees=data});
  }
}