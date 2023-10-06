package com.finalproject.assetmanagement.controller;

import com.finalproject.assetmanagement.entity.Branch;
import com.finalproject.assetmanagement.entity.Employee;
import com.finalproject.assetmanagement.service.BranchService;
import com.finalproject.assetmanagement.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/branch")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public Employee create(@RequestBody Employee employee){
        return employeeService.create(employee);
    }

    @GetMapping(value = "/{id}")
    public Employee getById(@PathVariable String id){
        return employeeService.getById(id);
    }

    @GetMapping
    public List<Employee> getAll(){
        return employeeService.getAll();
    }

    @PutMapping
    public Employee update(@RequestBody Employee employee){
        return employeeService.update(employee);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable String id){
        employeeService.deleteById(id);
    }
}
