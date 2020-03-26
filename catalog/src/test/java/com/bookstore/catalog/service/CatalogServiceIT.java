package com.bookstore.catalog.service;

import com.bookstore.catalog.model.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
@DisplayName("CatalogService Integration Test")
public class CatalogServiceIT {

    @Autowired
    private CatalogService catalogService;

    @Test
    @DisplayName("Add Book")
    public void addBook() throws BookAlreadyExistsException {
        Book book = new Book();
        book.setTitle("Spring in Action");
        book.setIsbn("1617294942");
        book.setAuthors("Craig Walls");
        book.setPrice(new BigDecimal("66.95"));

        catalogService.addBook(book);
    }

    @Test
    @DisplayName("Find Book by ISBN 9781484228074")
    public void findBook() throws BookNotFoundException {
        Book book = catalogService.findBook("9781484228074");

        assertNotNull(book);
        assertEquals("dpunkt", book.getPublisher());
    }

    @Test
    @DisplayName("Find Book with unknown ISBN. Should throw BookNotFoundException")
    public void findBookThrowsBookNotFoundException() {
        assertThrows(BookNotFoundException.class, () -> {
            catalogService.findBook("8787");
        });
    }

    @Test
    @DisplayName("Search for Books with keywords 'Spring Boot'")
    public void searchBooks() {
        List<Book> books = catalogService.searchBooks("Spring Boot");

        assertEquals(1, books.size());
        assertEquals("Michael Simons", books.get(0).getAuthors());
    }
}
