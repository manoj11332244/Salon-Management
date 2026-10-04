package com.salon.service.impl;

import com.salon.dto.SalonDTO;
import com.salon.modal.Category;
import com.salon.repository.CategoryRepository;
import com.salon.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Service
@RequiredArgsConstructor
@RequestMapping("/api/categories")
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(Category category, SalonDTO salonDTO) {
        Category newCategory = new Category();
        newCategory.setName(category.getName());
        newCategory.setSalonId(salonDTO.getId());
        newCategory.setImage(category.getImage());
        return categoryRepository.save(newCategory);
    }

    @Override
    public Set<Category> getAllCategoryBySalon(Long id) {
        return categoryRepository.findBySalonId(id);
    }

    @Override
    public Category getCategoryBySalonId(Long id) throws Exception {
        Category category=categoryRepository.findById(id).orElse(null);
        if(category==null){
            throw new Exception("category not exist with id "+ id);
        }
        return category;
    }

    @Override
    public void deleteCategoryById(Long id, Long salonId) throws Exception {
      Category category= getCategoryBySalonId(id);
       if(!category.getSalonId().equals(salonId)){
           throw new Exception("you don't have permission to delete this category");
       }
        categoryRepository.deleteById(id);
    }

}
