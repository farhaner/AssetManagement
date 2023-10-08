package com.finalproject.assetmanagement.service;

import com.finalproject.assetmanagement.entity.Admin;
import com.finalproject.assetmanagement.entity.Employee;
import com.finalproject.assetmanagement.model.request.AdminRequest;
import com.finalproject.assetmanagement.model.request.EmployeeRequest;
import com.finalproject.assetmanagement.model.response.AdminResponse;
import com.finalproject.assetmanagement.model.response.EmployeeResponse;

import java.util.List;

public interface AdminService {
    AdminResponse createNewAdmin(AdminRequest request);
    Admin getAdminById(String id);
    List<AdminResponse> getAllAdmin();// parameter diisi jika menggunakan seaching

    AdminResponse updateAdmin(AdminRequest request);

    void deleteAdminById(String id);

}
