package com.stackhack.taskmanagement.services;

import java.util.List;

import com.stackhack.taskmanagement.models.request.TaskRequest;
import com.stackhack.taskmanagement.models.response.TaskResponse;

public interface TaskService {

	public List<TaskResponse> getAllTask();

	public TaskResponse getTaskById(Long id);

	public Long createTask(TaskRequest taskRequest);

	public TaskResponse modifyTask(TaskRequest taskRequest);

	public TaskResponse deleteTaskById(Long id);

}
