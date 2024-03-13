package com.mahtab.todoapp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Entity
@Table(name = "todos")
public class Todo implements Serializable {
    @Id
    @GeneratedValue
    @Setter
    private Long id;

    @Getter
    @Setter
    private String title;

    @Column(nullable = true)
    @Getter
    @Setter
    private String description;

    @Column(nullable = true, columnDefinition = "boolean default false")
    @Getter
    @Setter
    private boolean done;

    public Todo() {};

    @Override
    public String toString(){
        return String.format("TodoItem {id=%d, title='%s', description='%s', done='%s'",
                id, title, description, done);
    }
}
