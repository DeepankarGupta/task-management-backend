package com.stackhack.taskmanagement.restcontrollers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackhack.taskmanagement.models.request.TaskRequest;
import com.stackhack.taskmanagement.models.response.TaskResponse;
import com.stackhack.taskmanagement.services.impl.TaskServiceImpl;

@RestController
@RequestMapping("/task")
public class TaskController {
	
	@Autowired
	private TaskServiceImpl taskService;
	
	@GetMapping
	public ResponseEntity<List<TaskResponse>> getAllTask() {
		return new ResponseEntity<List<TaskResponse>>(taskService.getAllTask(), HttpStatus.OK);
	}

	@GetMapping("/{taskId}")
	public TaskResponse getTask(@PathVariable Long taskId) {
		return taskService.getTaskById(taskId);
	}

	@PostMapping
	public ResponseEntity<String> addTask(@Valid @RequestBody TaskRequest taskRequest) {
		return new ResponseEntity<String>(taskService.createTask(taskRequest), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateTask(@Valid @RequestBody TaskRequest taskRequest) {
		return new ResponseEntity<String>(taskService.modifyTask(taskRequest), HttpStatus.CREATED);
	}
	

}
