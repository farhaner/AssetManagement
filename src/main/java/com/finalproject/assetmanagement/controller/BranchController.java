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
        return branchService.createBranch(branch);
    }

    @GetMapping(value = "/{id}")
    public Branch getBranchById(@PathVariable String id){
        return branchService.getBranchById(id);
    }

    @GetMapping
    public List<Branch> getAllBranch(){
        return branchService.getAllBranch();
    }

    @PutMapping
    public Branch updateBranch(@RequestBody Branch branch){
        return branchService.updateBranch(branch);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteBranch(@PathVariable String id){
        branchService.deleteBranchById(id);
    }
}
