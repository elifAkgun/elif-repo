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
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@ExtendWith(MockitoExtension.class)
public class CamblyControllerTest {


    @Mock
    CamblyServiceImpl camblyService;

    @InjectMocks
    CamblyController controller;

    private Cambly cambly;
    private List<Cambly> camblies;

    @BeforeEach
    public void initVariable() {
        cambly = new Cambly("Helo", "Hello", 1, LocalDate.now());
        camblies = Arrays.asList(cambly);
    }

    @Test
    public void listCambly_checkViewName() throws Exception {

        MockMvc mockMvc = standaloneSetup(controller)
                .build();

        MvcResult mvcResult = mockMvc.perform(get("/cambly/list")
                .accept(APPLICATION_JSON)).andReturn();

        Assertions.assertEquals("list-cambly",
                mvcResult.getModelAndView().getViewName());

    }

    @Test
    public void listCambly_checkModelAttribute_hasCamblyList() throws Exception {
        MockMvc mockMvc = standaloneSetup(controller)
                .build();

        MvcResult mvcResult = mockMvc.perform(get("/cambly/list")
                .accept(APPLICATION_JSON)).andReturn();

        Assertions.assertEquals(true,mvcResult.getModelAndView().getModel().containsKey("camblyList"));
    }


    @Test
    public void listCambly_checkModel_camblyList() throws Exception {
        when(camblyService.getAllCamblys())
                .thenReturn(camblies);

        MockMvc mockMvc = standaloneSetup(controller)
                .build();

        MvcResult mvcResult = mockMvc.perform(get("/cambly/list")
                .accept(APPLICATION_JSON)).andReturn();

        Assertions.assertEquals(camblies,mvcResult.getModelAndView().getModel().get("camblyList"));

        verify(camblyService).getAllCamblys();

    }

    @Test
    public void addCambly() {
    }

    @Test
    public void saveCambly() {
    }

    @Test
    public void testSaveCambly() {
    }

    @Test
    public void deleteCambly() {
    }

    @Test
    public void searchCamblys() {
    }
}