package com.mintic.reto3.reto3.repository.CRUD;

import com.mintic.reto3.reto3.model.AdminUser;




import org.springframework.data.repository.CrudRepository;

public interface AdminUserCrud extends CrudRepository <AdminUser,Integer> {
    
}
