package com.finalproject.assetmanagement.controller;

import com.finalproject.assetmanagement.entity.Branch;
import com.finalproject.assetmanagement.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/branch")
public class BranchController {

    private final BranchService branchService;

    @PostMapping
    public Branch createNewBranch(@RequestBody Branch branch){
        return branchService.create(branch);
    }

    @GetMapping(value = "/{id}")
    public Branch getBranchById(@PathVariable String id){
        return branchService.getById(id);
    }

    @GetMapping
    public List<Branch> getAllBranch(){
        return branchService.getAll();
    }

    @PutMapping
    public Branch updateBranch(@RequestBody Branch branch){
        return branchService.update(branch);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteStore(@PathVariable String id){
        branchService.deleteById(id);
    }
}
