import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeserviceService } from '../employeeservice.service';
import { HttpClient, HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-updateemployee',
  templateUrl: './updateemployee.component.html',
  styleUrl: './updateemployee.component.css'
})
export class UpdateemployeeComponent {

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

updateemployee(): void {
    if (this.employee) {
      this.employeeService.updateEmployee(this.employee.id,
      this.employee).subscribe(updatedEmployee => {
        this.employee = updatedEmployee;
        this.originalEmployee = { ...updatedEmployee }; 
        this.isEditing = false;
        this.router.navigate(['/eventemployees']);
    });
  }
}
}
