package ru.morev.education.service;

import ru.morev.education.entity.TodoList;
import ru.morev.education.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository repository;

    public TodoList createTodoList(TodoList todoList) {
        return repository.save(todoList);
    }

    public List<TodoList> getAllTodoLists() {
        return repository.findAll();
    }
}
