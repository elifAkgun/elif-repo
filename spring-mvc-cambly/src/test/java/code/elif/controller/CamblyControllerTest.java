package code.elif.controller;


import code.elif.model.Cambly;
import code.elif.service.impl.CamblyServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@ExtendWith(MockitoExtension.class)
class CamblyControllerTest {


    @Mock
    CamblyServiceImpl camblyService;

    @InjectMocks
    CamblyController controller;

    private List<Cambly> camblies;

    @BeforeEach
     void initVariable() {
        Cambly cambly = new Cambly("Helo", "Hello", 1, LocalDate.now());
        camblies = Collections.singletonList(cambly);
    }

    @Test
     void listCambly_checkViewName() throws Exception {

        MockMvc mockMvc = standaloneSetup(controller)
                .build();

        MvcResult mvcResult = mockMvc.perform(get("/cambly/list")
                .accept(APPLICATION_JSON)).andReturn();

        Assertions.assertEquals("list-cambly",
                Objects.requireNonNull(mvcResult.getModelAndView()).getViewName());

    }

    @Test
     void listCambly_checkModelAttribute_hasCamblyList() throws Exception {
        MockMvc mockMvc = standaloneSetup(controller)
                .build();

        MvcResult mvcResult = mockMvc.perform(get("/cambly/list")
                .accept(APPLICATION_JSON)).andReturn();

        Assertions.assertTrue(Objects.requireNonNull(mvcResult.getModelAndView()).getModel().containsKey("camblyList"));
    }


    @Test
     void listCambly_checkModel_camblyList() throws Exception {
        when(camblyService.getAllCamblys())
                .thenReturn(camblies);

        MockMvc mockMvc = standaloneSetup(controller)
                .build();

        MvcResult mvcResult = mockMvc.perform(get("/cambly/list")
                .accept(APPLICATION_JSON)).andReturn();

        Assertions.assertEquals(camblies, Objects.requireNonNull(mvcResult.getModelAndView()).getModel().get("camblyList"));

        verify(camblyService).getAllCamblys();

    }
}