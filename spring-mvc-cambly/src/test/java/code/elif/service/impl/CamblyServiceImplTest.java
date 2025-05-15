package code.elif.service.impl;

import code.elif.dao.impl.CamblyDaoImpl;
import code.elif.model.Cambly;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
 class CamblyServiceImplTest {

    @Mock
    CamblyDaoImpl camblyDao;

    @InjectMocks
    CamblyServiceImpl camblyService;

    private Cambly cambly;
    private List<Cambly> camblies;

    @BeforeEach
     void initVariable() {
        cambly = new Cambly("Helo", "Hello", 1, LocalDate.now());
        camblies = Arrays.asList(cambly);
    }

    @Test
     void getAllCamblys() {
        when(camblyDao.getAllCamblys()).thenReturn(camblies);
        Assertions.assertEquals(camblies, camblyService.getAllCamblys());
    }

    @Test
     void createCambly() {
        when(camblyDao.createCambly(cambly)).thenReturn(true);
        Assertions.assertEquals(true, camblyService.createCambly(cambly));
    }

    @Test
     void getCambly() {
        when(camblyDao.searchCamblys("Hello")).thenReturn(camblies);
        Assertions.assertEquals(camblies, camblyService.searchCamblys("Hello"));
    }

    @Test
     void deleteCambly() {
        camblyService.deleteCambly(1);
        verify(camblyDao).deleteCambly(1);
    }

    @Test
     void updateCambly() {
        cambly.setId(1);
        Cambly updatedCambly = new Cambly("Aple", "Apple", 100, LocalDate.now());
        updatedCambly.setLessonId(10);

        when(camblyDao.updateCambly(cambly)).thenReturn(updatedCambly);

        Assertions.assertEquals(updatedCambly, camblyService.updateCambly(cambly));

        verify(camblyDao).updateCambly(cambly);

    }

}