package com.finalproject.assetmanagement.controller;

import com.finalproject.assetmanagement.entity.Admin;
import com.finalproject.assetmanagement.entity.Branch;
import com.finalproject.assetmanagement.service.AdminService;
import com.finalproject.assetmanagement.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/admin")
public class AdminController {

    private final AdminService adminService;

    @PostMapping
    public Admin create(@RequestBody Admin admin){
        return adminService.create(admin);
    }

    @GetMapping(value = "/{id}")
    public Admin getById(@PathVariable String id){
        return adminService.getById(id);
    }

    @GetMapping
    public List<Admin> getAll(){
        return adminService.getAll();
    }

    @PutMapping
    public Admin update(@RequestBody Admin admin){
        return adminService.update(admin);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable String id){
        adminService.deleteById(id);
    }
}
