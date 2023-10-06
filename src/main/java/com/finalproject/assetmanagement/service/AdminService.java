package com.finalproject.assetmanagement.service;

import com.finalproject.assetmanagement.entity.Admin;
import com.finalproject.assetmanagement.entity.Branch;
import com.finalproject.assetmanagement.model.request.AdminRequest;
import com.finalproject.assetmanagement.model.response.AdminResponse;

import java.util.List;

public interface AdminService {
    Admin create(Admin admin);
    Admin getById(String id);
    List<Admin> getAll();
    Admin update(Admin admin);
    void deleteById(String id);

}
