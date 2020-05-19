package com.stackhack.taskmanagement.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackhack.taskmanagement.exceptions.ResourceNotFoundException;
import com.stackhack.taskmanagement.models.request.CategoryRequest;
import com.stackhack.taskmanagement.models.request.NewCategoryRequest;
import com.stackhack.taskmanagement.models.response.CategoryResponse;
import com.stackhack.taskmanagement.models.response.CustomResponse;
import com.stackhack.taskmanagement.services.CategoryService;

@RestController
@RequestMapping("api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping
	public ResponseEntity<CustomResponse<Long>> createCategory(@RequestBody NewCategoryRequest newCategoryRequest) {
		Long categoryId = categoryService.createCategory(newCategoryRequest);
		CustomResponse<Long> response = new CustomResponse<Long>("Category created successfully", HttpStatus.CREATED, categoryId, null);
		return new ResponseEntity<CustomResponse<Long>>(response, response.getHttpStatus());
	}
	
	@PutMapping
	public ResponseEntity<CustomResponse<CategoryResponse>> editCategory(@RequestBody CategoryRequest categoryRequest) {
		CategoryResponse categoryResposne = categoryService.editCategory(categoryRequest);
		CustomResponse<CategoryResponse> response = new CustomResponse<CategoryResponse>("Category edited successfully", HttpStatus.OK, categoryResposne, null);
		return new ResponseEntity<CustomResponse<CategoryResponse>>(response, response.getHttpStatus());
	}
	
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<CustomResponse<Long>> deleteCategory(@PathVariable Long categoryId) {
		Long id = categoryService.deleteCategory(categoryId);
		CustomResponse<Long> response = new CustomResponse<Long>("Category deleted successfully", HttpStatus.OK, id, null);
		return new ResponseEntity<CustomResponse<Long>>(response, response.getHttpStatus());	
	}
	
	@GetMapping("/{categoryId}")
	public ResponseEntity<CustomResponse<CategoryResponse>> getCategoryById(@PathVariable Long categoryId) {
		CategoryResponse categoryResposne = categoryService.getCategoryById(categoryId);
		CustomResponse<CategoryResponse> response = new CustomResponse<CategoryResponse>("", HttpStatus.OK, categoryResposne, null);
		return new ResponseEntity<CustomResponse<CategoryResponse>>(response, response.getHttpStatus());
	}
	
	@GetMapping
	public ResponseEntity<CustomResponse<List<CategoryResponse>>> getCategoryList() {
		List<CategoryResponse> categoryResponseList = categoryService.getCategoryList();
		CustomResponse<List<CategoryResponse>> response = new CustomResponse<List<CategoryResponse>>("", HttpStatus.OK, categoryResponseList, null);
		return new ResponseEntity<CustomResponse<List<CategoryResponse>>>(response, response.getHttpStatus());			
	}
}
