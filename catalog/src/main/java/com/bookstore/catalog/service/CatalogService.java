package com.bookstore.catalog.service;

import com.bookstore.catalog.model.Book;
import com.bookstore.catalog.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.bookstore.catalog.repository.BookSpecifications.contains;

@Service
public class CatalogService {

    private BookRepository bookRepository;

    public CatalogService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional(rollbackFor = BookAlreadyExistsException.class)
    public void addBook(Book book) throws BookAlreadyExistsException {
        if (bookRepository.findByIsbn(book.getIsbn()).isPresent()) {
            throw new BookAlreadyExistsException();
        }

        bookRepository.saveAndFlush(book);
    }

    public Book findBook(String isbn) throws BookNotFoundException {
        Optional<Book> book = bookRepository.findByIsbn(isbn);

        return book.orElseThrow(BookNotFoundException::new);
    }

    public List<Book> searchBooks(String keywords) {
        return bookRepository.findAll(contains(keywords));
    }

}
