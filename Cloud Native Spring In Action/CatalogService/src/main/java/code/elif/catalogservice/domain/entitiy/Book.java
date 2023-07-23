package code.elif.catalogservice.domain.entitiy;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;

/**
 * The domain model is implemented as a record, an immutable object.
 * @param isbn : Uniquely identifies a book
 * @param title
 * @param author
 * @param price
 */
public record Book(
        String isbn,
        String title,
        String author,
        BigDecimal price
) {
}