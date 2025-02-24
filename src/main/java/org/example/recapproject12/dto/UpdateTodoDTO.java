package org.example.recapproject12.dto;

import org.example.recapproject12.enums.TodoStatus;

public record UpdateTodoDTO(String description, TodoStatus status) {}
