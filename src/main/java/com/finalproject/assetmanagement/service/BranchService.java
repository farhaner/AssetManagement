package com.finalproject.assetmanagement.service;

import com.finalproject.assetmanagement.model.request.CreateBranchRequest;
import com.finalproject.assetmanagement.model.request.UpdateBranchRequest;
import com.finalproject.assetmanagement.model.response.BranchResponse;

import java.util.List;

public interface BranchService {
    BranchResponse createBranch(CreateBranchRequest branch);
    BranchResponse getBranchById(String id);
    List<BranchResponse> getAllBranch();
    BranchResponse updateBranch(UpdateBranchRequest branch);
    void deleteBranchById(String id);

}
