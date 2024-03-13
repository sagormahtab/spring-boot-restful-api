package com.mahtab.todoapp.config;

import com.mahtab.todoapp.models.Todo;
import com.mahtab.todoapp.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TodoSeeder implements CommandLineRunner {
    @Autowired
    private TodoRepository todoRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Todo> todos = (List<Todo>) todoRepository.findAll();
        if (todos.isEmpty()) {
            Todo todo1 = new Todo();
            todo1.setTitle("Brush");
            todo1.setDescription("Brush your teeth");
            todoRepository.save(todo1);
        }
    }
}
