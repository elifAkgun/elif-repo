package code.elif.catalogservice.domain.service;

import code.elif.catalogservice.domain.entitiy.Book;

import java.util.List;

public interface BookService {
    List<Book> getBooks();

    Boolean createBook(Book book);

    Book getBooksByISBN(String isbn);

    Book updateBookByISBN(String isbn, Book book);

    Boolean deleteBookByISBN(String isbn);
}
