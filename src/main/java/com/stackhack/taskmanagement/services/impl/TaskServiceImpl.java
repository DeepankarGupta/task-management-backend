package com.stackhack.taskmanagement.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackhack.taskmanagement.exceptions.ResourceNotFoundException;
import com.stackhack.taskmanagement.models.entity.Category;
import com.stackhack.taskmanagement.models.entity.Task;
import com.stackhack.taskmanagement.models.request.TaskRequest;
import com.stackhack.taskmanagement.models.response.TaskResponse;
import com.stackhack.taskmanagement.repositories.CategoryRepository;
import com.stackhack.taskmanagement.repositories.TaskRepository;
import com.stackhack.taskmanagement.services.TaskService;
import com.stackhack.taskmanagement.utils.TaskUtil;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository repo;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private TaskUtil utility;
	
	@Override
	public List<TaskResponse> getAllTask() {
		return repo.findAll().stream().map(utility::convertToResponse)
				.collect(Collectors.toList());
	}

	@Override
	public TaskResponse getTaskById(Long id) {
		Optional<Task> task = repo.findById(id);
		task.orElseThrow(() -> new ResourceNotFoundException("Task with ID: " + id + " does not exist"));
		TaskResponse taskResponse = utility.convertToResponse(task.get());
		return taskResponse;
	}

	@Override
	public Long createTask(TaskRequest taskRequest) {
		Task task = utility.convertToEntity(taskRequest);
		Optional<Category> category  = categoryRepository.findById(taskRequest.getCategoryId());
		category.orElseThrow(() -> new ResourceNotFoundException("Category with ID: " + taskRequest.getCategoryId() + " does not exist"));
		task.setCategory(category.get());
		task = repo.save(task);
		return task.getId();
	}

	@Override
	public TaskResponse modifyTask(TaskRequest taskRequest) {
		Task task = utility.convertToEntity(taskRequest);
		task = repo.save(task);
		return utility.convertToResponse(task);
	}

	@Override
	public TaskResponse deleteTaskById(Long id) {
		Optional<Task> task = repo.findById(id);
		task.orElseThrow(() -> new ResourceNotFoundException("Task with ID: " + id + " does not exist"));
		repo.deleteById(id);
		return utility.convertToResponse(task.get());
	}

}
