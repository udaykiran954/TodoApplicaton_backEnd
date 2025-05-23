package com.TodoApplication.TodoApplication;
import jakarta.persistence.*;
@Entity
@Table(name = "todos") // Renamed table to match the entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String title;

    private boolean completed;

    // No-args constructor (required by JPA)
    public Todo() {
    }

    // All-args constructor
    public Todo(Long id, String description, String title, boolean completed) {
        this.id = id;
        this.description = description;
        this.title = title;
        this.completed = completed;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}

