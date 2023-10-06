package com.finalproject.assetmanagement.service;

import com.finalproject.assetmanagement.entity.Branch;

import java.util.List;

public interface BranchService {
    Branch createBranch(Branch branch);
    Branch getBranchById(String id);
    List<Branch> getAllBranch();
    Branch updateBranch(Branch branch);
    void deleteBranchById(String id);
}
