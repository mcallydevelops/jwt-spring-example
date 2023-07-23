package com.mcallydevelops;

import java.util.UUID;

public class Book extends DataRecord {
    private final String name;
    private final String author;
    public Book(UUID id, String name, String author) {
        super(id);
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public static Book fromRequest(Book request) {
        return new Book(UUID.randomUUID(), request.getName(), request.getAuthor());
    }
}
