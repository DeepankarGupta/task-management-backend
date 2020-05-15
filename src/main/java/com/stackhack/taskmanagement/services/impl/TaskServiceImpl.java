package com.stackhack.taskmanagement.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.stackhack.taskmanagement.models.entity.Task;
import com.stackhack.taskmanagement.repositories.TaskRepository;
import com.stackhack.taskmanagement.services.TaskService;

public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository repo;
	
	@Override
	public List<Task> getAllTask() {
		return repo.findAll();
	}

	@Override
	public Task getTaskById(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public String createTask(Task task) {
		repo.save(task);
		return "created";
	}

	@Override
	public String modifyTask(Task task) {
		repo.save(task);
		return "updated";
	}

	@Override
	public String deleteTaskById(Long id) {
		repo.deleteById(id);
		return "deleted";
	}

}
