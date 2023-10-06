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
    public Branch create(Branch store) {
        return branchRepository.save(store);
    }

    @Override
    public Branch getById(String id) {
        return branchRepository.findById(id).get();
    }

    @Override
    public List<Branch> getAll() {
        return branchRepository.findAll();
    }

    @Override
    public Branch update(Branch store) {
        Branch currentBranch = getById(store.getId());
        if (currentBranch != null){
            return branchRepository.save(store);
        }
        return null;
    }

    @Override
    public void deleteById(String id) {
        branchRepository.deleteById(id);
    }
}
