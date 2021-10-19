package com.mintic.reto3.reto3.service;

import java.util.List;
import java.util.Optional;

import com.mintic.reto3.reto3.model.AdminUser;
import com.mintic.reto3.reto3.repository.AdminUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminUserService {

    @Autowired
    private AdminUserRepository adminUserRepository;

    public List<AdminUser> getAll() {
        return adminUserRepository.getAll();
    }

    public Optional<AdminUser> getAdminUser(int id) {
        return adminUserRepository.getAdminUser(id);
    }

    public AdminUser save(AdminUser AdminUser) {
        if (AdminUser.getId() == null) {
            return adminUserRepository.save(AdminUser);
        } else {
            Optional<AdminUser> consult = adminUserRepository.getAdminUser(AdminUser.getId());
            if (consult.isEmpty()) {
                return adminUserRepository.save(AdminUser);
            } else {
                return AdminUser;
            }
        }
    }
}
