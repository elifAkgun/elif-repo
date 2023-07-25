package code.elif.catalogservice.domain.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String isbn) {
        super("The book with ISBN " + isbn + " was not found.");
    }
}
