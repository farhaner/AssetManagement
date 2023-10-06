package com.finalproject.assetmanagement.service;

import com.finalproject.assetmanagement.entity.Branch;
import com.finalproject.assetmanagement.entity.Employee;
import com.finalproject.assetmanagement.model.request.AdminRequest;
import com.finalproject.assetmanagement.model.request.EmployeeRequest;
import com.finalproject.assetmanagement.model.response.AdminResponse;
import com.finalproject.assetmanagement.model.response.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
    Employee create(Employee employee);
    Employee getById(String id);
    List<Employee> getAll();
    Employee update(Employee employee);
    void deleteById(String id);


    EmployeeResponse createNewEmployee(EmployeeRequest request);
    EmployeeResponse getEmployeeById(String  request);
    List<EmployeeResponse> getAllEmployee(); // parameter diisi jika menggunakan seaching
    EmployeeResponse updateEmployee(EmployeeRequest request);
    EmployeeResponse deleteEmployee(String id);

}
