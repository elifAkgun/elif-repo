package code.elif.catalogservice.domain.service;

import code.elif.catalogservice.domain.entitiy.Book;
import code.elif.catalogservice.domain.exception.BookAlreadyExistsException;
import code.elif.catalogservice.domain.exception.BookNotFoundException;

public interface BookService {
    Iterable<Book> getBooks();

    Book createBook(Book book);

    Book getBooksByISBN(String isbn);

    Book updateBookByISBN(String isbn, Book book);

    Boolean deleteBookByISBN(String isbn);
}
