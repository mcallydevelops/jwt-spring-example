package com.mcallydevelops;

import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping
    public Book createBook(@RequestBody Book request) {
        return bookRepository.save(Book.fromRequest(request));
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable UUID id) {
        return bookRepository.find(id);
    }
}
