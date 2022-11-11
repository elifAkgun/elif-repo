package code.elif.springBootUnitTestExamples.service;

import code.elif.springBootUnitTestExamples.model.CamblyDTO;
import code.elif.springBootUnitTestExamples.repository.CamblyRepository;
import code.elif.springBootUnitTestExamples.repository.model.Cambly;
import code.elif.springBootUnitTestExamples.service.exception.DuplicateRecordException;
import code.elif.springBootUnitTestExamples.service.impl.CamblyServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static code.elif.springBootUnitTestExamples.helper.CamblyDataHelper.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CamblyServiceImplTest {

    @InjectMocks
    CamblyServiceImpl camblyService;

    @Mock
    CamblyRepository camblyRepository;


    @DisplayName("CamblyServiceImpl test for saveCambly operation")
    @Test
    public void givenCamblyObject_whenSaveCambly_thenReturnSavedCambly() {
        // given- precondition or setup
        given(camblyRepository.save(any(Cambly.class)))
                .willReturn(Cambly.builder()
                        .id(10L)
                        .correction(CORRECTION1)
                        .date(DATE)
                        .lessonId(LESSON_1)
                        .mistake(MISTAKE1).build());
        // when - action or the behaviour that we are going test

        CamblyDTO camblyDTO = CamblyDTO.builder()
                .correction(CORRECTION1)
                .date(DATE)
                .lessonId(LESSON_1)
                .mistake(MISTAKE1).build();

        CamblyDTO savedCambly = camblyService.saveCambly(camblyDTO).get();
        // then - verify the output
        assertThat(savedCambly.getId()).isPositive();
    }

    @DisplayName("saveCambly : throw exception when existing cambly")
    @Test
    public void givenCamblyObjectExist_whenSaveCambly_thenThrowException() {
        // given- precondition or setup
        given(camblyRepository.findByMistakeAndAndCorrectionWithIndexParameter(MISTAKE1, CORRECTION1))
                .willReturn(Cambly.builder()
                        .correction(CORRECTION1)
                        .date(DATE)
                        .lessonId(LESSON_1)
                        .mistake(MISTAKE1).build());

        CamblyDTO camblyDTO = CamblyDTO.builder()
                .correction(CORRECTION1)
                .date(DATE)
                .lessonId(LESSON_1)
                .mistake(MISTAKE1).build();

        // when - action or the behaviour that we are going test
        assertThatThrownBy(() -> camblyService.saveCambly(camblyDTO))
                .isInstanceOf(DuplicateRecordException.class);

        // then - verify the output
        verify(camblyRepository, never()).save(any());
    }

    // JUnit test for
    @DisplayName("GetAllCamblies - positive scenario")
    @Test
    public void givenCamblyList_whenGetAllCambliesCall_thenReturnCamblyList() {
        // given- precondition or setup
        given(camblyRepository.findAll()).
                willReturn(
                        List.of(Cambly.builder()
                                        .correction(CORRECTION1)
                                        .date(DATE)
                                        .lessonId(LESSON_1)
                                        .mistake(MISTAKE1).build(),
                                Cambly.builder()
                                        .correction(CORRECTION2)
                                        .date(DATE)
                                        .lessonId(LESSON_2)
                                        .mistake(MISTAKE2).build()));

        // when - action or the behaviour that we are going test
        List<CamblyDTO> camblyList = camblyService.getAll();

        // then - verify the output
        assertThat(camblyList).hasSize(2);
    }

    // JUnit test for
    @DisplayName("GetAllCamblies - negative scenario")
    @Test
    public void givenEmptyList_whenGetAllCambliesCall_thenReturnEmptyList() {
        // given- precondition or setup
        given(camblyRepository.findAll()).
                willReturn(Collections.EMPTY_LIST);

        // when - action or the behaviour that we are going test
        List<CamblyDTO> camblyList = camblyService.getAll();

        // then - verify the output
        assertThat(camblyList).isEmpty();
        assertThat(camblyList).hasSize(0);
    }

    // JUnit test for
    @DisplayName("Get Cambly Object with Id")
    @Test
    public void givenCamblyId_whenGetCamblyCalled_thenReturnCambly() {
        // given- precondition or setup
        given(camblyRepository.findById(anyLong())).
                willReturn(java.util.Optional.ofNullable(Cambly.builder()
                        .correction(CORRECTION1)
                        .date(DATE)
                        .lessonId(LESSON_1)
                        .mistake(MISTAKE1).build()));

        // when - action or the behaviour that we are going test
        CamblyDTO camblyDTO = camblyService.getCamblyById(anyLong()).get();

        // then - verify the output
        assertThat(camblyDTO).isNotNull();
        assertThat(camblyDTO.getCorrection()).isEqualTo(CORRECTION1);
    }

    // JUnit test for
    @DisplayName("With Given values update cambly")
    @Test
    public void givenCamblyObject_whenUpdated_thenReturnUpdatedCambly() {
        // given- precondition or setup
        Cambly cambly = Cambly.builder()
                .id(10L)
                .correction(CORRECTION2)
                .mistake(MISTAKE2)
                .date(DATE)
                .lessonId(LESSON_1).build();

        given(camblyRepository.save(cambly)).willReturn(cambly);

        // when - action or the behaviour that we are going test
        CamblyDTO camblyDTO = CamblyDTO.builder()
                .id(10L)
                .correction(CORRECTION1)
                .date(DATE)
                .mistake(MISTAKE1)
                .lessonId(LESSON_1).build();

        camblyDTO.setMistake(MISTAKE2);
        camblyDTO.setCorrection(CORRECTION2);

        CamblyDTO updatedCambly = camblyService.update(camblyDTO).get();

        // then - verify the output
        assertThat(updatedCambly.getId()).isEqualTo(10L);
        assertThat(updatedCambly.getMistake()).isEqualTo(MISTAKE2);
        assertThat(updatedCambly.getCorrection()).isEqualTo(CORRECTION2);
    }

    // JUnit test for
    @DisplayName("Delete cambly with id")
    @Test
    public void givenCamblyId_whenDeleteCalled_thenRemoveRepository() {
        // given- precondition or setup
        willDoNothing().given(camblyRepository).deleteById(anyLong());

        // when - action or the behavior that we are going test
        camblyService.delete(1L);

        // then - verify the output
        verify(camblyRepository,times(1)).deleteById(1L);
    }
}