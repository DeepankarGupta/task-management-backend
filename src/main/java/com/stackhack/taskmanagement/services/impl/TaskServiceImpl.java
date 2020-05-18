package com.stackhack.taskmanagement.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackhack.taskmanagement.models.entity.Task;
import com.stackhack.taskmanagement.models.request.TaskRequest;
import com.stackhack.taskmanagement.models.response.TaskResponse;
import com.stackhack.taskmanagement.repositories.TaskRepository;
import com.stackhack.taskmanagement.services.TaskService;
import com.stackhack.taskmanagement.utils.TaskUtil;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository repo;
	
	@Autowired
	private TaskUtil utility;
	
	@Override
	public List<TaskResponse> getAllTask() {
		return repo.findAll().stream().map(utility::convertToResponse)
				.collect(Collectors.toList());
	}

	@Override
	public TaskResponse getTaskById(Long id) {
		TaskResponse taskResponse = utility.convertToResponse(repo.findById(id).get());
		return taskResponse;
	}

	@Override
	public String createTask(TaskRequest taskRequest) {
		Task task = utility.convertToEntity(taskRequest);
		repo.save(task);
		return "created";
	}

	@Override
	public String modifyTask(TaskRequest taskRequest) {
		Task task = utility.convertToEntity(taskRequest);
		repo.save(task);
		return "updated";
	}

	@Override
	public String deleteTaskById(Long id) {
		repo.deleteById(id);
		return "deleted";
	}

}
