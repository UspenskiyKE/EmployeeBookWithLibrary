package com.flightofdream.EmployeeBook;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RequestMapping("/employee")
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService=employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("fname") String firstName, @RequestParam("lname") String lastName, @RequestParam("dep") String department, @RequestParam("sal") double salary) {
        Employee d=null;
        d=employeeService.addEmployee(firstName, lastName, department,salary);
        return d;
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("fname") String firstName, @RequestParam("lname") String lastName){
        Employee d=null;
        d=employeeService.removeEmployee(firstName,lastName);
        return d;
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("fname") String firstName, @RequestParam("lname") String lastName) {
        Employee d=null;
        d=employeeService.findEmployee(firstName,lastName);
        return d;
    }
    @GetMapping("/list")
    public void showEmployeeList(){

    }
    //Новые методы контроллера
    @GetMapping("/departments/max-salary")
    public  Employee departmentMaxSalaryEmployee(@RequestParam("dep") String departmentName) {
        return employeeService.departmentMaxSalaryEmployee(departmentName);
    }
    @GetMapping("/departments/min-salary")
    public  Employee departmentMinSalaryEmployee(@RequestParam("dep") String departmentName) {
        return employeeService.departmentMaxSalaryEmployee(departmentName);
    }
    @GetMapping("/departments/dep")
    public ArrayList<Employee> departmentEmployees(@RequestParam("dep") String departmentName) {
        return employeeService.departmentEmployees(departmentName);
    }
    @GetMapping("/departments/alldeps")
    public void showEmployeesForDepartments() {
        employeeService.showEmployeesForDepartments();
    }

}
