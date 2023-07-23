package code.elif.catalogservice.domain.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest
class SampleControllerTest {

    public static final String TEXT_PLAIN_CHARSET_UTF_8 = "text/plain;charset=UTF-8";
    @Autowired
    MockMvc mockMvc;

    // JUnit test for greeting
    @DisplayName("According to the given name return the greeting message")
    @Test
    public void givenName_whenGreetingControllerCalled_thenReturnGreetingMessage() throws Exception {
        // given- precondition or setup
        String name = "Elif";

        // when - action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(get("/greeting/" + name)
                .contentType(TEXT_PLAIN_CHARSET_UTF_8));

        // then - verify the output

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(TEXT_PLAIN_CHARSET_UTF_8))
                .andExpect(MockMvcResultMatchers.content().string("Hello Elif"));
    }

}