package com.finalproject.assetmanagement.service.implementation;

import com.finalproject.assetmanagement.entity.Admin;
import com.finalproject.assetmanagement.model.request.AdminRequest;
import com.finalproject.assetmanagement.model.response.AdminResponse;
import com.finalproject.assetmanagement.repository.AdminRepository;
import com.finalproject.assetmanagement.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminServiceImplementation implements AdminService {
private final AdminRepository adminRepository;
    @Transactional(rollbackOn = Exception.class)
    @Override
    public AdminResponse createNewAdmin(AdminRequest request) {
            Admin admin = Admin.builder()
                    .username(request.getUsername())
                    .password(request.getPassword())
                    .email(request.getEmail())
                    .mobilePhone(request.getMobilePhone())
                    .build();
            adminRepository.save(admin);
        return adminResponse(admin);

    }

    @Override
    public Admin getAdminById(String id) {
        return adminRepository.findById(id).get();
    }

    @Override
    public List<AdminResponse> getAllAdmin() {
        List<Admin> admins = adminRepository.findAll();
        List<AdminResponse> adminResponse = admins.stream()
                .map(admin -> adminResponse(admin)).collect(Collectors.toList());

        return adminResponse;
    }

    @Override
    public AdminResponse updateAdmin(AdminRequest request) {
        Admin admin = getAdminById(request.getId());
        if (Objects.nonNull(admin)){
            admin.setId(request.getId());
            admin.setEmail(request.getEmail());
            admin.setUsername(request.getUsername());
            admin.setPassword(request.getPassword());
            admin.setMobilePhone(request.getMobilePhone());
            adminRepository.save(admin);

            return adminResponse(admin);
        }
        return null;
    }

    @Override
    public void deleteAdminById(String id) {
        adminRepository.deleteById(id);
    }
    private static AdminResponse adminResponse(Admin admin) {
        return AdminResponse.builder()
                .id(admin.getId())
                .username(admin.getUsername())
                .password(admin.getPassword())
                .email(admin.getEmail())
                .mobilePhone(admin.getMobilePhone())
                .build();
    }
}
