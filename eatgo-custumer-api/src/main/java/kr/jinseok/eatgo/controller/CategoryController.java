package kr.jinseok.eatgo.controller;

import kr.jinseok.eatgo.Service.CategoryService;
import kr.jinseok.eatgo.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/category")
    public List<Category> list(){
        List<Category> categories = categoryService.getCategories();

        return categories;
    }

}
