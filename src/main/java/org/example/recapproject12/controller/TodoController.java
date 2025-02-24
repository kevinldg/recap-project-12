package org.example.recapproject12.controller;

import org.example.recapproject12.dto.UpdateTodoDTO;
import org.example.recapproject12.model.Todo;
import org.example.recapproject12.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.findAllTodos();
    }

    @GetMapping("{id}")
    public Todo getTodoById(@PathVariable String id) {
        return todoService.findTodoById(id);
    }

    @PostMapping
    public Todo addTodo(@RequestBody Todo todo) {
        return todoService.addTodo(todo);
    }

    @PutMapping("{id}")
    public Todo updateTodo(@RequestBody UpdateTodoDTO todo, @PathVariable String id) {
        return todoService.updateTodo(todo, id);
    }

    @DeleteMapping("{id}")
    public void deleteTodo(@PathVariable String id) {
        todoService.deleteTodo(id);
    }
}
