package com.mahtab.todoapp.controllers;

import com.mahtab.todoapp.models.Todo;
import com.mahtab.todoapp.services.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> getTodos() {
        return todoService.findAllTodos();
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo newTodo) {
        return todoService.createTodo(newTodo);
    }

    @GetMapping("/{id}")
    public Todo getTodo(@PathVariable Long id) {
        return todoService.findTodo(id);
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo body) {
        return todoService.updateTodo(id, body);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }
}
