package com.finalproject.assetmanagement.service.implementation;

import com.finalproject.assetmanagement.entity.Manager;
import com.finalproject.assetmanagement.model.response.ManagerRequest;
import com.finalproject.assetmanagement.repository.ManagerRepository;
import com.finalproject.assetmanagement.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ManagerServiceImplementation implements ManagerService {
private final ManagerRepository managerRepository;
    @Transactional(rollbackOn = Exception.class)
    @Override
    public ManagerRequest createNewAdmin(com.finalproject.assetmanagement.model.request.ManagerRequest request) {
            Manager manager = Manager.builder()
                    .username(request.getUsername())
                    .password(request.getPassword())
                    .email(request.getEmail())
                    .mobilePhone(request.getMobilePhone())
                    .build();
            managerRepository.save(manager);
        return adminResponse(manager);

    }

    @Override
    public Manager getAdminById(String id) {
        return managerRepository.findById(id).get();
    }

    @Override
    public List<ManagerRequest> getAllAdmin() {
        List<Manager> managers = managerRepository.findAll();
        List<ManagerRequest> managerRequest = managers.stream()
                .map(manager -> adminResponse(manager)).collect(Collectors.toList());

        return managerRequest;
    }

    @Override
    public ManagerRequest updateAdmin(com.finalproject.assetmanagement.model.request.ManagerRequest request) {
        Manager manager = getAdminById(request.getId());
        if (Objects.nonNull(manager)){
            manager.setId(request.getId());
            manager.setEmail(request.getEmail());
            manager.setUsername(request.getUsername());
            manager.setPassword(request.getPassword());
            manager.setMobilePhone(request.getMobilePhone());
            managerRepository.save(manager);

            return adminResponse(manager);
        }
        return null;
    }

    @Override
    public void deleteAdminById(String id) {
        managerRepository.deleteById(id);
    }
    private static ManagerRequest adminResponse(Manager manager) {
        return ManagerRequest.builder()
                .id(manager.getId())
                .username(manager.getUsername())
                .password(manager.getPassword())
                .email(manager.getEmail())
                .mobilePhone(manager.getMobilePhone())
                .build();
    }
}
