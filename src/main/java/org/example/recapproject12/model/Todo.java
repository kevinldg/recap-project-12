package org.example.recapproject12.model;

import org.example.recapproject12.enums.TodoStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "todo")
public record Todo(
        @Id String id,
        String description,
        TodoStatus status
) {}
