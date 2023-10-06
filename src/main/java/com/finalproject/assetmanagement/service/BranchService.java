package com.finalproject.assetmanagement.service;

import com.finalproject.assetmanagement.entity.Branch;

import java.util.List;

public interface BranchService {
    Branch createBranch(Branch store);
    Branch getBranchById(String id);
    List<Branch> getAllBranch();
    Branch updateBranch(Branch store);
    void deleteBranchById(String id);
}
