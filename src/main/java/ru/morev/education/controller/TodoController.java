package ru.morev.education.controller;

import ru.morev.education.entity.TodoList;
import ru.morev.education.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService service;

    @PostMapping
    public ResponseEntity<TodoList> createTodo(@RequestBody TodoList todoList) {
        return ResponseEntity.ok(service.createTodoList(todoList));
    }

    @GetMapping
    public ResponseEntity<List<TodoList>> getTodos() {
        return ResponseEntity.ok(service.getAllTodoLists());
    }
}
