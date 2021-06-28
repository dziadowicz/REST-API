package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class DbServiceTestSuite {

    @InjectMocks
    private DbService dbService;

    @Mock
    TaskRepository repository;

    @Test
    public void dbServiceTest() {

        //Given
        Task task  = new Task(0L, "test", "test");

        //When
        dbService.saveTask(task);
        dbService.getTaskById(0L);
        dbService.getAllTasks();
        dbService.deleteTask(0L);

        //Then
        verify(repository, times(1)).save(task);
        verify(repository, times(1)).findById(0L);
        verify(repository, times(1)).findAll();
        verify(repository, times(1)).deleteById(0L);
    }
}
