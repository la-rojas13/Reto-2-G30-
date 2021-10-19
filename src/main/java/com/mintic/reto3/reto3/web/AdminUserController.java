package com.mintic.reto3.reto3.web;

import java.util.List;
import java.util.Optional;

import com.mintic.reto3.reto3.model.AdminUser;
import com.mintic.reto3.reto3.service.AdminUserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/Admin")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    @GetMapping("/all")
    public List<AdminUser> getCategories() {
        return adminUserService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<AdminUser> getAdminUser(@PathVariable("id") int id) {
        return adminUserService.getAdminUser(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public AdminUser save(@RequestBody AdminUser adminUser) {
        return adminUserService.save(adminUser);
    }
}
