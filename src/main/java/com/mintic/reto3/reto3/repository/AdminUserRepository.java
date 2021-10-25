package com.mintic.reto3.reto3.repository;

import java.util.List;
import java.util.Optional;

import com.mintic.reto3.reto3.model.AdminUser;
import com.mintic.reto3.reto3.repository.CRUD.AdminUserCrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminUserRepository {

    @Autowired
    private AdminUserCrud adminUserCrud;

    public List<AdminUser> getAll(){
        return (List<AdminUser>)adminUserCrud.findAll();
    }

    public Optional<AdminUser>getAdminUser(int id){
        return adminUserCrud.findById(id);
    }
    
    public AdminUser save(AdminUser adminUser){
        return adminUserCrud.save(adminUser);
    }

    public void delete(AdminUser adminUser) {
        adminUserCrud.delete(adminUser);
    }
}
