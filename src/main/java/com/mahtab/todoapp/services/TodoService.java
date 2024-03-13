package com.mahtab.todoapp.services;

import com.mahtab.todoapp.models.Todo;
import com.mahtab.todoapp.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public List<Todo> findAllTodos() {
        return (List<Todo>) todoRepository.findAll();
    }

    public Todo findTodo(Long id) {
        return todoRepository.findById(id).orElse(null);
    }

    public Todo updateTodo(Long id, Todo todo) {
        final Todo existingTodo = findTodo(id);
        if (existingTodo == null) {
            return null;
        }
        todo.setId(id);
        return todoRepository.save(todo);
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}
