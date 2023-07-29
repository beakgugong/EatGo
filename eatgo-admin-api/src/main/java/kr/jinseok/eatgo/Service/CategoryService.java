package kr.jinseok.eatgo.Service;

import kr.jinseok.eatgo.domain.Category;
import kr.jinseok.eatgo.domain.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getCategories(){
        List<Category> categories = categoryRepository.findAll() ;
        return categories;
    }
    public Category addCategory(String name) {
        Category add = Category.builder().name(name).build();

        return add;
    }
}
