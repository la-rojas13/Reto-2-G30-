package com.mintic.reto3.reto3.repository.CRUD;

import com.mintic.reto3.reto3.model.Category;



import org.springframework.data.repository.CrudRepository;

public interface CategoryCrud extends CrudRepository <Category,Integer> {
    
}
