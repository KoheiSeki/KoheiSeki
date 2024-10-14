package com.example.todo.service.task;

import com.example.todo.controller.task.TaskDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskService {
    public List<TaskDTO> find() {
        TaskDTO task1 = new TaskDTO(1L, "Spring Bootを学ぶ", "ToDoアプリケーションを作ってみる", "ToDO");
        TaskDTO task2 = new TaskDTO(2L, "Spring Securityを学ぶ", "ログイン機能を作ってみる", "ToDO");
        return  List.of(task1, task2);
    }
}
