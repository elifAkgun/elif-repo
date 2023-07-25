package code.elif.catalogservice.domain.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BookAlreadyExistsException extends RuntimeException {
    public BookAlreadyExistsException(String isbn) {
        super("A book with ISBN " + isbn + " already exists.");
    }
}
