package com.example.lab.web;

import com.example.lab.model.Book;
import com.example.lab.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/books")
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    private List<Book> findAll() {
        return this.bookService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return this.bookService.findById(id)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

//    //String name, Category category, Long authorId, Integer availableCopies
//    @PostMapping("/add")
//    public ResponseEntity<Book> save(@RequestParam String name,
//                                     @RequestParam Category category,
//                                     @RequestParam Long authorId,
//                                     @RequestParam Integer availableCopies) {
//        return this.bookService.create(name, category, authorId, availableCopies);
//    }
//
//    @PutMapping("/edit/{id}")
//    public ResponseEntity<Book> save(@PathVariable Long id, @RequestBody ProductDto productDto) {
//        return this.bookService.update(id, productDto)
//                .map(product -> ResponseEntity.ok().body(product))
//                .orElseGet(() -> ResponseEntity.badRequest().build());
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity deleteById(@PathVariable Long id) {
//        this.bookService.delete(id);
//        if(this.bookService.findById(id).isEmpty()) return ResponseEntity.ok().build();
//        return ResponseEntity.badRequest().build();
//    }
}
