package org.example.recapproject12.service;

import lombok.RequiredArgsConstructor;
import org.example.recapproject12.dto.UpdateTodoDTO;
import org.example.recapproject12.model.Todo;
import org.example.recapproject12.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public List<Todo> findAllTodos() {
        return todoRepository.findAll();
    }

    public Todo findTodoById(String id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Todo with id: " + id + " not found!"));
    }

    public Todo addTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo updateTodo(UpdateTodoDTO todo, String id) {
        Todo todoToUpdate = new Todo(id, todo.description(), todo.status());
        return todoRepository.save(todoToUpdate);
    }

    public void deleteTodo(String id) {
        todoRepository.deleteById(id);
    }
}
