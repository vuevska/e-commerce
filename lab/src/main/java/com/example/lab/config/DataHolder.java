package com.example.lab.config;

import com.example.lab.model.Author;
import com.example.lab.model.Country;
import com.example.lab.model.enumerations.Category;
import com.example.lab.service.AuthorService;
import com.example.lab.service.BookService;
import com.example.lab.service.CountryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataHolder {
    private final BookService bookService;
    private final AuthorService authorService;
    private final CountryService countryService;

    public DataHolder(BookService bookService, AuthorService authorService, CountryService countryService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.countryService = countryService;
    }


    @PostConstruct
    public void init() {

        Country country = this.countryService.create("United States", "North America");

        Author author1 = this.authorService.create("Stephen", "King", country);
        Author author2 = this.authorService.create("Hank", "Green", country);

        this.bookService.create("Carrie", Category.FANTASY, author1.getId(), 5);
        this.bookService.create("The Shining", Category.THRILLER, author1.getId(), 5);
        this.bookService.create("The Fault in our Stars", Category.DRAMA, author2.getId(), 5);

    }
}
