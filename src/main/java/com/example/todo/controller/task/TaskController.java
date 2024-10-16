package com.example.todo.controller.task;

import com.example.todo.service.task.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.stream.Stream;

@Controller
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/tasks")
    public String list(Model model){
        Stream<TaskDTO> taskList = taskService.find()//List<TaskEntity> -> List<TaskDTO>
                .stream()
                .map(TaskDTO::toDTO);

        model.addAttribute("taskList", taskList);
        return "/tasks/list";
    }

    @GetMapping("/tasks/{id}")
    public String showDetail(@PathVariable("id") long taskId, Model model){
        //taskId->taskEntityを取得する
        var taskEntity = taskService.findById(taskId)
                .orElseThrow(() -> new IllegalArgumentException("Task not found: id =" + taskId));
        model.addAttribute("task", TaskDTO.toDTO(taskEntity));
        //戻り値は、htmlのファイル名
        return "/tasks/detail";
    }
}
