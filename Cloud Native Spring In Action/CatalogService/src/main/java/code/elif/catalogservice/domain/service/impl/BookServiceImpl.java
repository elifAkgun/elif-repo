package code.elif.catalogservice.domain.service.impl;

import code.elif.catalogservice.domain.entitiy.Book;
import code.elif.catalogservice.domain.exception.BookAlreadyExistsException;
import code.elif.catalogservice.domain.exception.BookNotFoundException;
import code.elif.catalogservice.domain.repository.BookRepository;
import code.elif.catalogservice.domain.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public Iterable<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book createBook(Book book) {
        if (bookRepository.existsByIsbn(book.isbn())) {
            throw new BookAlreadyExistsException(book.isbn());
        }
        return bookRepository.save(book);
    }



    @Override
    public Book getBooksByISBN(String isbn) {
        return bookRepository.findByIsbn(isbn).orElseThrow(() -> new BookNotFoundException(isbn));
    }

    @Override
    public Book updateBookByISBN(String isbn, Book book) {
        return bookRepository.findByIsbn(isbn)
                .map(existingBook -> {
                    var bookToUpdate = new Book(existingBook.isbn(),
                            book.title(),
                            book.author(),
                            book.price());
                    return bookRepository.save(bookToUpdate);
                })
                .orElseGet(() -> createBook(book));
    }

    @Override
    public Boolean deleteBookByISBN(String isbn) {
       bookRepository.deleteByIsbn(isbn);
       return true;
    }
}
