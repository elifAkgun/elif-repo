package code.elif.catalogservice.domain.controller;

import code.elif.catalogservice.domain.entitiy.Book;
import code.elif.catalogservice.domain.service.BookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<Iterable<Book>> getBooks() {
        var books = bookService.getBooks();
        return ResponseEntity.ok(books);
    }

    @PostMapping
    public ResponseEntity<String> createBook(@Valid @RequestBody Book book) {
        Book createdBook = bookService.createBook(book);
        return createdBook != null ? ResponseEntity.created(URI.create("/books/" + book.isbn())).build()
                : ResponseEntity.badRequest().build();
    }

    @GetMapping(path = "/{isbn}")
    public ResponseEntity<Book> getBooksByISBN(@PathVariable("isbn") String isbn) {
        Book book = bookService.getBooksByISBN(isbn);
        return ResponseEntity.ok(book);
    }

    @PutMapping(path = "/{isbn}")
    public ResponseEntity<Book> updateBookByISBN(@PathVariable("isbn") String isbn,@Valid @RequestBody Book book) {
        book = bookService.updateBookByISBN(isbn, book);
        return ResponseEntity.ok(book);
    }

    @DeleteMapping(path = "/{isbn}")
    public ResponseEntity<String> deleteBookByISBN(@PathVariable("isbn") String isbn) {
        Boolean success = bookService.deleteBookByISBN(isbn);
        return success ? ResponseEntity.noContent().build() : ResponseEntity.badRequest().build();
    }
}
