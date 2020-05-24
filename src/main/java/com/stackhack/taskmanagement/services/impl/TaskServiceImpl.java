package com.stackhack.taskmanagement.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stackhack.taskmanagement.enums.TaskPriority;
import com.stackhack.taskmanagement.enums.TaskStatus;
import com.stackhack.taskmanagement.exceptions.ResourceNotFoundException;
import com.stackhack.taskmanagement.models.entity.Category;
import com.stackhack.taskmanagement.models.entity.Task;
import com.stackhack.taskmanagement.models.request.NewTaskRequest;
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
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<TaskResponse> getAllTask(TaskStatus status, Long categoryId, TaskPriority priority, String name, Pageable pageable) {
		ExampleMatcher matcher = ExampleMatcher.matchingAll().withMatcher("taskName", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
		Task exampleTask = new Task();
		exampleTask.setStatus(status);
		exampleTask.setPriority(priority);
		exampleTask.setTaskName(name);
		if(categoryId != null) {
			Category category = new Category();
			category.setCategoryId(categoryId);
			exampleTask.setCategory(category);
		}
		List<Task> tasks = repo.findAll(Example.of(exampleTask, matcher), pageable).getContent();
		return tasks.stream().map(utility::convertToResponse).collect(Collectors.toList());
	}

	@Override
	public TaskResponse getTaskById(Long id) {
		Optional<Task> task = repo.findById(id);
		task.orElseThrow(() -> new ResourceNotFoundException("Task with ID: " + id + " does not exist"));
		TaskResponse taskResponse = utility.convertToResponse(task.get());
		return taskResponse;
	}

	@Override
	public Long createTask(NewTaskRequest taskRequest) {
		Task task = modelMapper.map(taskRequest, Task.class);
		task.setStatus(TaskStatus.TODO);
		Optional<Category> category  = categoryRepository.findById(taskRequest.getCategoryId());
		category.orElseThrow(() -> new ResourceNotFoundException("Category with ID: " + taskRequest.getCategoryId() + " does not exist"));
		task.setCategory(category.get());
		task = repo.save(task);
		return task.getId();
	}

	@Override
	public TaskResponse modifyTask(TaskRequest taskRequest) {
		Task task = utility.convertToEntity(taskRequest);
		Optional<Category> category  = categoryRepository.findById(taskRequest.getCategoryId());
		category.orElseThrow(() -> new ResourceNotFoundException("Category with ID: " + taskRequest.getCategoryId() + " does not exist"));
		task.setCategory(category.get());
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
