package code.elif.springBootUnitTestExamples.controller;

import code.elif.springBootUnitTestExamples.model.CamblyDTO;
import code.elif.springBootUnitTestExamples.service.CamblyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.Optional;

import static code.elif.springBootUnitTestExamples.helper.CamblyDataHelper.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest
class CamblyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CamblyService camblyService;

    @Autowired
    private ObjectMapper objectMapper;


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

        given(camblyService.saveCambly(any(CamblyDTO.class)))
                .willAnswer((invocation) -> Optional.of(invocation.getArgument(0)));

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
        List<CamblyDTO> camblyDTOList = List.of(CamblyDTO.builder()
                        .id(10L)
                        .correction(CORRECTION1)
                        .date(DATE)
                        .mistake(MISTAKE1)
                        .lessonId(LESSON_1).build(),
                CamblyDTO.builder()
                        .id(10L)
                        .correction(CORRECTION1)
                        .date(DATE)
                        .mistake(MISTAKE1)
                        .lessonId(LESSON_1).build());

        given(camblyService.getAll())
                .willReturn(camblyDTOList);

        // when - action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(get("/cambly"));

        // then - verify the output
        response.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", CoreMatchers.is(camblyDTOList.size())));
    }

    // JUnit test for
    @DisplayName("Get Cambly By Id - positive scenario")
    @Test
    public void givenCamblyObject_whenCallGetCamblyById_thenReturnCamblyObject() throws Exception {
        // given- precondition or setup
        Long camblyId = 10L;
        CamblyDTO camblyDTO = CamblyDTO.builder()
                .id(10L)
                .correction(CORRECTION1)
                .date(DATE)
                .mistake(MISTAKE1)
                .lessonId(LESSON_1).build();

        given(camblyService.getCamblyById(anyLong()))
                .willReturn(Optional.ofNullable(camblyDTO));

        // when - action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(get("/cambly/{id}", camblyId));

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

        given(camblyService.getCamblyById(anyLong())).willReturn(Optional.empty());

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
        Long camblyId = 10L;
        CamblyDTO savedCambly = CamblyDTO.builder()
                .correction(CORRECTION1)
                .date(DATE)
                .mistake(MISTAKE1)
                .lessonId(LESSON_1).build();

        given(camblyService.getCamblyById(camblyId))
                .willReturn(Optional.of(savedCambly));

        CamblyDTO updatedCambly = CamblyDTO.builder()
                .correction(CORRECTION2)
                .mistake(MISTAKE2)
                .lessonId(LESSON_1)
                .date(DATE)
                .build();

        given(camblyService.update(any(CamblyDTO.class)))
                .willAnswer((invocation -> Optional.of(invocation.getArgument(0))));

        // when - action or the behaviour that we are going test

        ResultActions response = mockMvc.perform(put("/cambly/{id}", camblyId)
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

        verify(camblyService, times(1)).update(any(CamblyDTO.class));
    }

    // JUnit test for
    @DisplayName("Get Cambly By Id - negative scenario")
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
        given(camblyService.getCamblyById(anyLong())).willReturn(Optional.empty());

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
        Long camblyId = 10L;
        CamblyDTO camblyDTO = CamblyDTO.builder()
                .id(camblyId)
                .correction(CORRECTION2)
                .mistake(MISTAKE2)
                .lessonId(LESSON_1)
                .date(DATE)
                .build();

        given(camblyService.getCamblyById(camblyId))
                .willReturn(Optional.of(camblyDTO));

        // when - action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(delete("/cambly/{id}", camblyId));

        // then - verify the output
        response.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(camblyService, times(1)).delete(camblyId);
    }

    @DisplayName("delete cambly - negative scenario - if cambly not found")
    @Test
    public void givenInvalidCamblyId_whenCalledDeleteCambly_thenReturnNotFound() throws Exception {
        // given- precondition or setup
        Long camblyId = 10L;
        given(camblyService.getCamblyById(camblyId))
                .willReturn(Optional.empty());

        // when - action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(delete("/cambly/{id}", camblyId));

        // then - verify the output
        response.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());

        verify(camblyService, times(0)).delete(camblyId);
    }
}