package code.elif.springBootUnitTestExamples.integration;

import code.elif.springBootUnitTestExamples.model.CamblyDTO;
import code.elif.springBootUnitTestExamples.repository.CamblyRepository;
import code.elif.springBootUnitTestExamples.repository.model.Cambly;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static code.elif.springBootUnitTestExamples.helper.CamblyDataHelper.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CamblyControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CamblyRepository camblyRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setup(){
        camblyRepository.deleteAll();
    }

    // JUnit test for post cambly
    @DisplayName("given cambly object create cambly and return")
    @Test
    public void givenCamblyObject_whenCreateCamblyCalled_thenReturnSavedCambly() throws Exception {
        // given- precondition or setup
        CamblyDTO cambly = CamblyDTO.builder()
                .correction(CORRECTION1)
                .date(DATE)
                .mistake(MISTAKE1)
                .lessonId(LESSON_1).build();

        // when - action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(post("/cambly")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cambly)));

        // then - verify the output
        response.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.correction",
                        CoreMatchers.is(cambly.getCorrection())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.date",
                        CoreMatchers.is(cambly.getDate().toString())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.mistake",
                        CoreMatchers.is(cambly.getMistake())));
    }

    // JUnit test for get all camblies
    @DisplayName("Get all camblies")
    @Test
    public void givenListOfCamblies_whenCalledGetAllCamblies_thenReturnAllCamblies() throws Exception {
        // given- precondition or setup
        List<Cambly> camblyList = List.of(Cambly.builder()
                        .correction(CORRECTION1)
                        .date(DATE)
                        .mistake(MISTAKE1)
                        .lessonId(LESSON_1).build(),
                Cambly.builder()
                        .correction(CORRECTION2)
                        .date(DATE)
                        .mistake(MISTAKE2)
                        .lessonId(LESSON_2).build());

        camblyRepository.saveAll(camblyList);

        // when - action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(get("/cambly"));

        // then - verify the output
        response.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", CoreMatchers.is(camblyList.size())));
    }

    // JUnit test for
    @DisplayName("Get Cambly By Id - positive scenario")
    @Test
    public void givenCamblyObject_whenCallGetCamblyById_thenReturnCamblyObject() throws Exception {
        // given- precondition or setup

        Cambly cambly = Cambly.builder()
                .correction(CORRECTION1)
                .date(DATE)
                .mistake(MISTAKE1)
                .lessonId(LESSON_1).build();

        Cambly savedCambly = camblyRepository.save(cambly);

        // when - action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(get("/cambly/{id}", savedCambly.getId()));

        // then - verify the output
        response.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.correction", CoreMatchers.is(CORRECTION1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.mistake", CoreMatchers.is(MISTAKE1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.date", CoreMatchers.is(DATE.toString())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lessonId", CoreMatchers.is(LESSON_1)));
    }

    // JUnit test for
    @DisplayName("Get Cambly By Id - negative scenario")
    @Test
    public void givenCamblyId_whenGetCamblyCalled_thenReturnCamblyObject() throws Exception {
        // given- precondition or setup
        Long camblyId = 10L;

        // when - action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(get("/cambly/{id}", camblyId));

        // then - verify the output
        response.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status()
                        .isNotFound());
    }

    // JUnit test for
    @DisplayName("Update Cambly - positive scenario")
    @Test
    public void givenCambly_whenUpdateCamblyCalled_thenReturnUpdatedCambly() throws Exception {
        // given- precondition or setup
        Cambly cambly = Cambly.builder()
                .correction(CORRECTION1)
                .date(DATE)
                .mistake(MISTAKE1)
                .lessonId(LESSON_1).build();

        Cambly savedCambly = camblyRepository.save(cambly);

        CamblyDTO updatedCambly = CamblyDTO.builder()
                .correction(CORRECTION2)
                .mistake(MISTAKE2)
                .lessonId(LESSON_1)
                .date(DATE)
                .build();

        // when - action or the behaviour that we are going test

        ResultActions response = mockMvc.perform(put("/cambly/{id}", savedCambly.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedCambly)));

        // then - verify the output
        response.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.correction",
                        CoreMatchers.is(CORRECTION2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.mistake",
                        CoreMatchers.is(MISTAKE2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lessonId",
                        CoreMatchers.is(LESSON_1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.date",
                        CoreMatchers.is(DATE.toString())));
    }

    // JUnit test for
    @DisplayName("Update Cambly By Id - negative scenario")
    @Test
    public void givenInvalidCamblyId_whenUpdateCamblyCalled_thenReturnNotFound() throws Exception {
        // given- precondition or setup
        Long camblyId = 10L;

        CamblyDTO updatedCambly = CamblyDTO.builder()
                .correction(CORRECTION2)
                .mistake(MISTAKE2)
                .lessonId(LESSON_1)
                .date(DATE)
                .build();

        // when - action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(put("/cambly/{id}", camblyId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedCambly)));

        // then - verify the output
        response.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status()
                        .isNotFound());
    }

    // JUnit test for
    @DisplayName("delete cambly - positive scenario")
    @Test
    public void givenCamblyId_whenCalledDeleteCambly_thenDeleteCambly() throws Exception {
        // given- precondition or setup
        Cambly cambly = Cambly.builder()
                .correction(CORRECTION1)
                .date(DATE)
                .mistake(MISTAKE1)
                .lessonId(LESSON_1).build();

        Cambly savedCambly = camblyRepository.save(cambly);

        // when - action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(delete("/cambly/{id}", savedCambly.getId()));

        // then - verify the output
        response.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @DisplayName("delete cambly - negative scenario - if cambly not found")
    @Test
    public void givenInvalidCamblyId_whenCalledDeleteCambly_thenReturnNotFound() throws Exception {
        // given- precondition or setup
        Long camblyId = 10L;

        // when - action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(delete("/cambly/{id}", camblyId));

        // then - verify the output
        response.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());

    }

}
