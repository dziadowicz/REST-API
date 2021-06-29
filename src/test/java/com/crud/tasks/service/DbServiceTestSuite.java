package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DbServiceTestSuite {

    @InjectMocks
    private DbService dbService;

    @Mock
    TaskRepository repository;

    @Test
    public void dbServiceSaveTaskTest() {

        //Given
        Task task  = new Task(0L, "test", "test");
        when(repository.save(task)).thenReturn(task);

        //When
        Task savedTask = dbService.saveTask(task);

        //Then
        verify(repository, times(1)).save(task);
        assertEquals(task, savedTask);
    }

    @Test
    public void dbServiceGetAllTasksTest() {

        //Given
        Task task  = new Task(0L, "test", "test");
        List<Task> tasks = new ArrayList<>();
        tasks.add(task);
        when(repository.findAll()).thenReturn(tasks);

        //When
        List<Task> resultTasks = dbService.getAllTasks();

        //Then
        verify(repository, times(1)).findAll();
        assertEquals(tasks, resultTasks);
    }

    @Test
    public void dbServiceFindByIdTest() {

        //Given
        Task task  = new Task(0L, "test", "test");
        when(repository.findById(0L)).thenReturn(Optional.of(task));

        //When
        Task savedTask = dbService.getTaskById(0L).get();

        //Then
        verify(repository, times(1)).findById(0L);
        assertEquals(task, savedTask);
    }

    @Test
    public void dbServiceDeleteTaskTest() {

        //Given

        //When
        dbService.deleteTask(0L);

        //Then
        verify(repository, times(1)).deleteById(0L);
    }
}