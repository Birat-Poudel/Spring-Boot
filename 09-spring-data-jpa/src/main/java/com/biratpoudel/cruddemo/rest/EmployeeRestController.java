package com.biratpoudel.cruddemo.rest;

import com.biratpoudel.cruddemo.entity.Employee;
import com.biratpoudel.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);

        if (employee == null)
            throw new RuntimeException("Employee id not found " + employeeId);

        return employee;
    }

    @PostMapping("/employees")
    public Employee postEmployee(@RequestBody Employee employee) {
        employee.setId(0);

        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee putEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);

        if (employee == null)
            throw new RuntimeException("Employee id not found " + employeeId);

        employeeService.deleteById(employeeId);

        return "Deleted employee id " + employeeId;
    }
}