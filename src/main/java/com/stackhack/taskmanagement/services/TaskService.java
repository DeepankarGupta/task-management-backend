package com.stackhack.taskmanagement.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.stackhack.taskmanagement.enums.TaskPriority;
import com.stackhack.taskmanagement.enums.TaskStatus;
import com.stackhack.taskmanagement.models.request.NewTaskRequest;
import com.stackhack.taskmanagement.models.request.TaskRequest;
import com.stackhack.taskmanagement.models.response.TaskResponse;

public interface TaskService {

	public List<TaskResponse> getAllTask(TaskStatus status, Long categoryId, TaskPriority priority, String name, Pageable pageable);

	public TaskResponse getTaskById(Long id);

	public Long createTask(NewTaskRequest taskRequest);

	public TaskResponse modifyTask(TaskRequest taskRequest);

	public TaskResponse deleteTaskById(Long id);

}
