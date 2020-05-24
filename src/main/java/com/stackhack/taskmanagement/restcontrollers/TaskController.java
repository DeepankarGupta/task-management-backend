package com.stackhack.taskmanagement.restcontrollers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stackhack.taskmanagement.enums.TaskPriority;
import com.stackhack.taskmanagement.enums.TaskStatus;
import com.stackhack.taskmanagement.models.request.NewTaskRequest;
import com.stackhack.taskmanagement.models.request.TaskRequest;
import com.stackhack.taskmanagement.models.response.CustomResponse;
import com.stackhack.taskmanagement.models.response.TaskResponse;
import com.stackhack.taskmanagement.services.impl.TaskServiceImpl;

@RestController
@RequestMapping("api/tasks")
public class TaskController {
	
	@Autowired
	private TaskServiceImpl taskService;
	
	@GetMapping
	public ResponseEntity<CustomResponse<List<TaskResponse>>> getAllTask(@RequestParam(value = "status",required = false) TaskStatus status,
																		 @RequestParam(required = false) Long categoryId,
																		 @RequestParam(required = false) TaskPriority priority,
																		 @RequestParam(required = false) String name,
																		 Pageable pageable) {
		List<TaskResponse> taskList = taskService.getAllTask(status, categoryId, priority, name, pageable);
		String message = "Success";
		if(taskList.isEmpty()) {
			message = "No Records Found!!";
		}
		CustomResponse<List<TaskResponse>> response = new CustomResponse<List<TaskResponse>>(message, HttpStatus.OK, taskList, null);
		return new ResponseEntity<CustomResponse<List<TaskResponse>>>(response, response.getHttpStatus());
	}

	@GetMapping("/{taskId}")
	public ResponseEntity<CustomResponse<TaskResponse>> getTask(@PathVariable Long taskId) {
		TaskResponse taskResponse = taskService.getTaskById(taskId);
		CustomResponse<TaskResponse> response = new CustomResponse<TaskResponse>("Success", HttpStatus.OK, taskResponse, null);
		return new ResponseEntity<CustomResponse<TaskResponse>>(response, response.getHttpStatus());
	}

	@PostMapping
	public ResponseEntity<CustomResponse<Long>> addTask(@Valid @RequestBody NewTaskRequest taskRequest) {
		Long taskId = taskService.createTask(taskRequest);
		CustomResponse<Long> response = new CustomResponse<Long>("Task created succesfully", HttpStatus.CREATED, taskId, null);
		return new ResponseEntity<CustomResponse<Long>>(response, response.getHttpStatus());
	}

	@PutMapping("/{taskId}")
	public ResponseEntity<CustomResponse<TaskResponse>> updateTask(@Valid @RequestBody TaskRequest taskRequest) {
		TaskResponse taskResponse = taskService.modifyTask(taskRequest);
		CustomResponse<TaskResponse> response = new CustomResponse<TaskResponse>("Task updated succesfully", HttpStatus.OK, taskResponse, null);
		return new ResponseEntity<CustomResponse<TaskResponse>>(response, response.getHttpStatus());
	}
}
