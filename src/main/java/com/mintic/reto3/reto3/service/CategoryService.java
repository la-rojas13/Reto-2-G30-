package com.mintic.reto3.reto3.service;

import java.util.List;
import java.util.Optional;

import com.mintic.reto3.reto3.model.Category;
import com.mintic.reto3.reto3.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id) {
        return categoryRepository.getCategory(id);
    }

    public Category save(Category category) {
        if (category.getId() == null) {
            return categoryRepository.save(category);
        } else {
            Optional<Category> consult = categoryRepository.getCategory(category.getId());
            if (consult.isEmpty()) {
                return categoryRepository.save(category);
            } else {
                return category;
            }
        }
    }

    public Category update(Category category) {
        if (category.getId() != null) {
            Optional<Category> consult = categoryRepository.getCategory(category.getId());
            if (!consult.isEmpty()) {
                if (category.getName() != null) {
                    consult.get().setName(category.getName());
                }
                if (category.getDescription() != null) {
                    consult.get().setDescription(category.getDescription());
                }
                return categoryRepository.save(consult.get());
            }
        }
        return category;
    }

    public boolean deleteCategory(int id){
        Optional<Category> consult = categoryRepository.getCategory(id);
            if (!consult.isEmpty()) {
                categoryRepository.delete(consult.get());
                return true;

            }
        return false;
    }
}
