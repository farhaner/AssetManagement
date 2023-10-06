package com.finalproject.assetmanagement.service;

import com.finalproject.assetmanagement.entity.Branch;

import java.util.List;

public interface BranchService {
    Branch create(Branch store);
    Branch getById(String id);
    List<Branch> getAll();
    Branch update(Branch store);
    void deleteById(String id);
}
