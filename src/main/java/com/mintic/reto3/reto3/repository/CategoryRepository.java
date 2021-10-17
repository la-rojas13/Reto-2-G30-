package com.mintic.reto3.reto3.repository;

import java.util.List;
import java.util.Optional;

import com.mintic.reto3.reto3.model.Category;
import com.mintic.reto3.reto3.repository.CRUD.CategoryCrud;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepository {

    @Autowired
    private CategoryCrud categoryCrud;

    public List<Category> getAll(){
        return (List<Category>)categoryCrud.findAll();
    }

    public Optional<Category>getCategory(int id){
        return categoryCrud.findById(id);
    }
    
    public Category save(Category category){
        return categoryCrud.save(category);
    }
}
