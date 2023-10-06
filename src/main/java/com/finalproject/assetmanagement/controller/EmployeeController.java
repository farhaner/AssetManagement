package com.finalproject.assetmanagement.controller;

import com.finalproject.assetmanagement.entity.Employee;
import com.finalproject.assetmanagement.model.request.EmployeeRequest;
import com.finalproject.assetmanagement.model.response.CommonResponse;
import com.finalproject.assetmanagement.model.response.EmployeeResponse;
import com.finalproject.assetmanagement.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    // Tanpa relasi

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

    // Dengan relasi
    // note : URL method relasi dan tanpa relasi masih sama, harus diubah

    @PostMapping
    public ResponseEntity<?> createNewEmployee(@RequestBody EmployeeRequest employee) {
        EmployeeResponse employeeResponse = employeeService.createNewEmployee(employee);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(CommonResponse.<EmployeeResponse>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Successfully create new employee")
                        .data(employeeResponse)
                        .build());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable String id) {
        EmployeeResponse employeeResponse = employeeService.getEmployeeById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(CommonResponse.<EmployeeResponse>builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Successfully get customer by id")
                        .data(employeeResponse)
                        .build());
    }

    @GetMapping
    public ResponseEntity<?> getAllEmployee() {
        List<EmployeeResponse> employeeResponse = employeeService.getAllEmployee();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(CommonResponse.builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Successfully get all customer")
                        .data(employeeResponse)
                        .build());
    }


    @PutMapping
    public ResponseEntity<?> updateEmployee(@RequestBody EmployeeRequest employee) {
        EmployeeResponse employeeResponse = employeeService.updateEmployee(employee);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(CommonResponse.<EmployeeResponse>builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Successfully update customer")
                        .data(employeeResponse)
                        .build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable String id) {
        employeeService.deleteEmployee(id);
        Employee employee = new Employee();
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(CommonResponse.<String>builder()
                        .statusCode(HttpStatus.NO_CONTENT.value())
                        .message("Successfully delete customer")
                        .data(String.valueOf(employee))
                        .build());
    }
}
