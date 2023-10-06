package com.finalproject.assetmanagement.service.implementation;

import com.finalproject.assetmanagement.entity.Branch;
import com.finalproject.assetmanagement.entity.Employee;
import com.finalproject.assetmanagement.model.request.EmployeeRequest;
import com.finalproject.assetmanagement.model.response.EmployeeResponse;
import com.finalproject.assetmanagement.repository.BranchRepository;
import com.finalproject.assetmanagement.repository.EmployeeRepository;
import com.finalproject.assetmanagement.service.BranchService;
import com.finalproject.assetmanagement.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImplementation implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    // CRUD tanpa relasi
    @Override
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getById(String id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee update(Employee employee) {
        Employee currentEmployee = getEmployeeById(employee.getId());
        if (currentEmployee != null) {
            return employeeRepository.save(employee);
        }
        return null;
    }

    @Override
    public void deleteById(String id) {
        employeeRepository.deleteById(id);
    }

    // CRUD dengan relasi

    @Override
    public EmployeeResponse createNewEmployee(EmployeeRequest request) {
        return null;
    }

    @Override
    public EmployeeResponse getEmployeeById(EmployeeRequest request) {
        return null;
    }

    @Override
    public EmployeeResponse getAllEmployee(EmployeeRequest request) {
        return null;
    }

    @Override
    public EmployeeResponse updateEmployee(EmployeeRequest request) {
        return null;
    }

    @Override
    public EmployeeResponse deleteEmployee(EmployeeRequest request) {
        return null;
    }
}
