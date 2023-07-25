package code.elif.catalogservice.domain.controller;

import code.elif.catalogservice.domain.entitiy.Book;
import code.elif.catalogservice.domain.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;

@WebMvcTest
class BookControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Autowired
    private ObjectMapper objectMapper;


    // JUnit test for getBooks
    @Test
    public void givenBooksListForService_whenGetBooksCalled_thenReturnExactBooks() throws Exception {
        // given- precondition or setup
        given(bookService.getBooks())
                .willReturn(List.of(
                        new Book("123", "Asd", "asd", BigDecimal.ONE),
                        new Book("456", "Qwe", "qwe", BigDecimal.TEN)
                ));

        // when - action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(get("/books")
                .contentType(APPLICATION_JSON));

        // then - verify the output
        response.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].isbn", CoreMatchers.is("123")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", CoreMatchers.is(2)));

    }

    // JUnit test for createBook
    @Test
    public void givenBook_whenCrateBookCalled_thenReturn200ForSuccessfulOperation() throws Exception {
        // given- precondition or setup
        Book book = new Book("123", "Asd", "asd", BigDecimal.ONE);
        when(bookService.createBook(book)).thenReturn(book);

        // when - action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(request(HttpMethod.POST, "/books")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book))
        );

        // then - verify the output
        response.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    // JUnit test for createBook -
    @Test
    public void givenBook_whenCrateBookCalled_thenReturn400ForFailedOperation() throws Exception {
        // given- precondition or setup
        Book book = new Book("123", "Asd", "asd", BigDecimal.ONE);
        when(bookService.createBook(book)).thenReturn(null);

        // when - action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(request(HttpMethod.POST, "/books"));

        // then - verify the output
        response.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    // JUnit test for getBooks
    @Test
    public void givenBooksListForService_whenGetBooksByISBNCalled_thenReturnExactBooks() throws Exception {
        // given- precondition or setup
        given(bookService.getBooksByISBN("123"))
                .willReturn(new Book("123", "Asd", "asd", BigDecimal.ONE));

        // when - action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(get("/books/123")
                .contentType(APPLICATION_JSON));

        // then - verify the output
        response.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.isbn", CoreMatchers.is("123")));
    }

    @Test
    public void givenBook_whenUpdateBookByISBNCalled_thenReturn200ForSuccessfulOperation() throws Exception {
        // given- precondition or setup
        Book book = new Book("123", "Asd", "asd", BigDecimal.ONE);
        when(bookService.updateBookByISBN("123", book)).thenReturn(book);

        // when - action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(request(HttpMethod.PUT, "/books/123")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book))
        );

        // then - verify the output
        response.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    public void givenBook_whenDeleteBookByISBNCalled_thenReturn200ForSuccessfulOperation() throws Exception {
        // given- precondition or setup
        Book book = new Book("123", "Asd", "asd", BigDecimal.ONE);
        when(bookService.deleteBookByISBN("123")).thenReturn(true);

        // when - action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(request(HttpMethod.DELETE, "/books/123")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book))
        );

        // then - verify the output
        response.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

}