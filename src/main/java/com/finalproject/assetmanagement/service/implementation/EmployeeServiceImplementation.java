package com.finalproject.assetmanagement.service.implementation;

import com.finalproject.assetmanagement.entity.Asset;
import com.finalproject.assetmanagement.entity.Branch;
import com.finalproject.assetmanagement.entity.Employee;
import com.finalproject.assetmanagement.model.request.EmployeeRequest;
import com.finalproject.assetmanagement.model.response.AssetResponse;
import com.finalproject.assetmanagement.model.response.BranchResponse;
import com.finalproject.assetmanagement.model.response.EmployeeResponse;
import com.finalproject.assetmanagement.repository.EmployeeRepository;
import com.finalproject.assetmanagement.service.AssetService;
import com.finalproject.assetmanagement.service.BranchService;
import com.finalproject.assetmanagement.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImplementation implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final BranchService branchService;
    private final AssetService assetService;

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
        Employee currentEmployee = getById(employee.getId());
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
        Branch branch = branchService.getBranchById(request.getBranchId());
        Asset asset = assetService.getById(request.getAssetId());

        Employee employee = Employee.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .email(request.getEmail())
                .mobilePhone(request.getMobilePhone())
                .assetId(asset)
                .build();
        employeeRepository.saveAndFlush(employee);

        return employeeResponse(employee, branch, asset);
    }

    @Override
    public EmployeeResponse getEmployeeById(String id) {
        return null;
    }

    @Override
    public List<EmployeeResponse> getAllEmployee() {
        return null;
    }

    @Override
    public EmployeeResponse updateEmployee(EmployeeRequest request) {
        return null;
    }

    @Override
    public EmployeeResponse deleteEmployee(String request) {
        return null;
    }
    private static EmployeeResponse employeeResponse(Employee employee, Branch branch, Asset asset) {
        return EmployeeResponse.builder()
                .id(employee.getId())
                .username(employee.getUsername())
                .password(employee.getPassword())
                .email(employee.getEmail())
                .mobilePhone(employee.getMobilePhone())
                .asset(AssetResponse.builder()
                    .id(asset.getId())
                    .assetCode(asset.getAssetCode())
                    .name(asset.getName())
                    .description(asset.getDescription())
                    .branch(BranchResponse.builder()
                            .id(branch.getId())
                            .branchName(branch.getBranchName())
                            .mobilePhone(branch.getMobilePhone())
                            .address(branch.getAddress())
                            .build())
                    .build())
                .build();
    }
}
