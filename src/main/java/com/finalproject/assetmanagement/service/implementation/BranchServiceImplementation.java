package com.finalproject.assetmanagement.service.implementation;

import com.finalproject.assetmanagement.entity.Branch;
import com.finalproject.assetmanagement.repository.BranchRepository;
import com.finalproject.assetmanagement.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class BranchServiceImplementation implements BranchService {

    private final BranchRepository branchRepository;
    @Override
    public Branch createBranch(Branch store) {
        return branchRepository.save(store);
    }

    @Override
    public Branch getBranchById(String id) {
        return branchRepository.findById(id).get();
    }

    @Override
    public List<Branch> getAllBranch() {
        return branchRepository.findAll();
    }

    @Override
    public Branch updateBranch(Branch branch) {
        Branch currentBranch = getBranchById(branch.getId());
        if (currentBranch != null){
            return branchRepository.save(branch);
        }
        return null;
    }

    @Override
    public void deleteBranchById(String id) {
        branchRepository.deleteById(id);
    }
}
