package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.DbService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskControllerTestSuite {

    @Autowired
    TaskRepository repository;

    @Test
    public void taskControllerGetTaskTest() {

        TaskController taskController = new TaskController(new DbService(repository), new TaskMapper());

        //Given
        TaskDto taskDto = new TaskDto(9999L, "test", "test");

        //When
        taskController.createTask(taskDto);

        //Then
        try {
            assertEquals(taskDto, taskController.getTask(9999L));
        } catch (Exception e) {

        }

        //Clean
        try {
            taskController.deleteTask(9999L);
        } catch (Exception e) {

        }
    }

    @Test
    public void taskControllerUpdateTaskTest() {

        TaskController taskController = new TaskController(new DbService(repository), new TaskMapper());

        //Given
        TaskDto taskDto = new TaskDto(9999L, "test", "test");
        TaskDto taskDto1 = new TaskDto(9999L, "test1", "test1");

        //When
        taskController.createTask(taskDto);
        taskController.updateTask(taskDto1);

        //Then
        try {
            assertEquals(taskDto1, taskController.getTask(9999L));
        } catch (Exception e) {

        }

        //Clean
        try {
            taskController.deleteTask(9999L);
        } catch (Exception e) {

        }
    }

    @Test
    public void taskControllerGetTasksTest() {

        TaskController taskController = new TaskController(new DbService(repository), new TaskMapper());

        //Given
        TaskDto taskDto = new TaskDto(9999L, "test", "test");

        //When
        taskController.createTask(taskDto);

        //Then
        assertNotEquals(0, taskController.getTasks().size());

        //Clean
        try {
            taskController.deleteTask(9999L);
        } catch (Exception e) {

        }
    }

    @Test
    public void taskControllerDeleteTaskTest() {

        TaskController taskController = new TaskController(new DbService(repository), new TaskMapper());

        //Given
        TaskDto taskDto = new TaskDto(9999L, "test", "test");

        //When
        int tasksNumber = taskController.getTasks().size();
        taskController.createTask(taskDto);
        try {
            taskController.deleteTask(9999L);
        } catch (Exception e) {

        }

        //Then
        assertNotEquals(tasksNumber, taskController.getTasks().size());
    }
}
