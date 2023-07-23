package code.elif.catalogservice.domain.service.impl;

import code.elif.catalogservice.domain.entitiy.Book;
import code.elif.catalogservice.domain.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {


    @Override
    public List<Book> getBooks() {
        return null;
    }

    @Override
    public Boolean createBook(Book book) {
        return null;
    }

    @Override
    public Book getBooksByISBN(String isbn) {
        return null;
    }

    @Override
    public Book updateBookByISBN(String isbn, Book book) {
        return null;
    }

    @Override
    public Boolean deleteBookByISBN(String isbn) {
        return null;
    }
}
