package com.finalproject.assetmanagement.service;

import com.finalproject.assetmanagement.entity.Manager;
import com.finalproject.assetmanagement.model.response.ManagerRequest;

import java.util.List;

public interface ManagerService {
    ManagerRequest createNewAdmin(com.finalproject.assetmanagement.model.request.ManagerRequest request);
    Manager getAdminById(String id);
    List<ManagerRequest> getAllAdmin();// parameter diisi jika menggunakan seaching

    ManagerRequest updateAdmin(com.finalproject.assetmanagement.model.request.ManagerRequest request);

    void deleteAdminById(String id);

}
