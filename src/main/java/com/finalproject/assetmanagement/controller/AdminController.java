package com.finalproject.assetmanagement.controller;

import com.finalproject.assetmanagement.entity.Admin;
import com.finalproject.assetmanagement.entity.Employee;
import com.finalproject.assetmanagement.model.request.AdminRequest;
import com.finalproject.assetmanagement.model.request.EmployeeRequest;
import com.finalproject.assetmanagement.model.response.AdminResponse;
import com.finalproject.assetmanagement.model.response.CommonResponse;
import com.finalproject.assetmanagement.model.response.EmployeeResponse;
import com.finalproject.assetmanagement.service.AdminService;
import com.finalproject.assetmanagement.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/admin")
public class AdminController {

    private final AdminService adminService;

    @PostMapping
    public ResponseEntity<?> createNewAdmin(@RequestBody AdminRequest request) {
        AdminResponse adminResponse = adminService.createNewAdmin(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(CommonResponse.<AdminResponse>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Successfully create new admin")
                        .data(adminResponse)
                        .build());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getAdminById(@PathVariable String id) {
        Admin admin = adminService.getAdminById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(CommonResponse.<AdminResponse>builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Successfully get admin by id")
                        .data(AdminResponse.builder()
                                .id(admin.getId())
                                .username(admin.getUsername())
                                .email(admin.getEmail())
                                .password(admin.getPassword())
                                .mobilePhone(admin.getMobilePhone())
                                .build())
                        .build());
    }

    @GetMapping
    public ResponseEntity<?> getAllEmployee() {
        List<AdminResponse> admins = adminService.getAllAdmin();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(CommonResponse.builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Successfully get all admins")
                        .data(admins)
                        .build());
    }


    @PutMapping
    public ResponseEntity<?> updateAdmin(@RequestBody AdminRequest request) {
        AdminResponse adminResponse = adminService.updateAdmin(request);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(CommonResponse.<AdminResponse>builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Successfully update admin")
                        .data(adminResponse)
                        .build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteAdmin(@PathVariable String id) {
        adminService.deleteAdminById(id);
        Admin admin = new Admin();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(CommonResponse.<String>builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Successfully delete admin")
                        .build());
    }
}
