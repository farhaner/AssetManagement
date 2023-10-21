package com.finalproject.assetmanagement.controller;

import com.finalproject.assetmanagement.entity.Manager;
import com.finalproject.assetmanagement.model.response.ManagerRequest;
import com.finalproject.assetmanagement.model.response.CommonResponse;
import com.finalproject.assetmanagement.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/manager")
public class ManagerController {

    private final ManagerService managerService;

    @PostMapping
    public ResponseEntity<?> createNewAdmin(@RequestBody com.finalproject.assetmanagement.model.request.ManagerRequest request) {
        ManagerRequest managerRequest = managerService.createNewAdmin(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(CommonResponse.<ManagerRequest>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Successfully create new admin")
                        .data(managerRequest)
                        .build());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getAdminById(@PathVariable String id) {
        Manager manager = managerService.getAdminById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(CommonResponse.<ManagerRequest>builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Successfully get admin by id")
                        .data(ManagerRequest.builder()
                                .id(manager.getId())
                                .username(manager.getUsername())
                                .email(manager.getEmail())
                                .password(manager.getPassword())
                                .mobilePhone(manager.getMobilePhone())
                                .build())
                        .build());
    }

    @GetMapping
    public ResponseEntity<?> getAllEmployee() {
        List<ManagerRequest> admins = managerService.getAllAdmin();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(CommonResponse.builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Successfully get all admins")
                        .data(admins)
                        .build());
    }


    @PutMapping
    public ResponseEntity<?> updateAdmin(@RequestBody com.finalproject.assetmanagement.model.request.ManagerRequest request) {
        ManagerRequest managerRequest = managerService.updateAdmin(request);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(CommonResponse.<ManagerRequest>builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Successfully update admin")
                        .data(managerRequest)
                        .build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteAdmin(@PathVariable String id) {
        managerService.deleteAdminById(id);
        Manager manager = new Manager();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(CommonResponse.<String>builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Successfully delete admin")
                        .build());
    }
}
