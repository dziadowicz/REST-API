package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskMapperTestSuite {

    TaskMapper taskMapper = new TaskMapper();

    @Test
    public void mapToTaskTest() {
        //Given
        TaskDto taskDto = new TaskDto(0L, "name", "content");

        //When
        Task task = taskMapper.mapToTask(taskDto);

        //Then
        assertEquals(Task.class, task.getClass());
        assertEquals(0, task.getId());
    }

    @Test
    public void mapToTaskDtoTest() {
        //Given
        Task task = new Task(0L, "name", "content");

        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);

        //Then
        assertEquals(TaskDto.class, taskDto.getClass());
        assertEquals(0, task.getId());
    }

    @Test
    public void mapToTaskDtoListTest() {
        //Given
        Task task = new Task(0L, "name", "content");
        Task task1 = new Task(1L, "name1", "content1");
        List<Task> tasks = new ArrayList<>();
        tasks.add(task);
        tasks.add(task1);

        //When
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(tasks);

        //Then
        assertEquals(2, taskDtoList.size());
        assertEquals(0, taskDtoList.get(0).getId());
    }

}
