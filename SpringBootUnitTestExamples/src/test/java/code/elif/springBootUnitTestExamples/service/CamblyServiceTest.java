package code.elif.springBootUnitTestExamples.service;

import code.elif.springBootUnitTestExamples.model.CamblyDTO;
import code.elif.springBootUnitTestExamples.repository.CamblyRepository;
import code.elif.springBootUnitTestExamples.repository.model.Cambly;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CamblyServiceTest {

    @InjectMocks
    CamblyService camblyService;

    @Mock
    CamblyRepository camblyRepository;

    @Mock
    ModelMapper modelMapper;

    public static final String CORRECTION1 = "CORRECTION1";
    public static final String MISTAKE1 = "MISTAKE1";
    public static final String CORRECTION2 = "CORRECTION2";
    public static final String MISTAKE2 = "MISTAKE2";
    public static final int LESSON_1 = 1;
    public static final int LESSON_2 = 2;
    public static final LocalDate DATE = LocalDate.of(2022, 2, LESSON_1);


    @DisplayName("CamblyService test for saveCambly operation")
    @Test
    public void givenCamblyObject_whenSaveCambly_thenReturnSavedCambly() {
        // given- precondition or setup
        given(camblyRepository.save(any(Cambly.class)))
                .willReturn(Cambly.builder()
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

        CamblyDTO savedCambly = camblyService.saveCambly(camblyDTO);
        // then - verify the output
        assertThat(savedCambly.getCorrection())
                .isEqualTo(CORRECTION1);
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
    public void givenCambly_whenGetCamblyCalled_thenReturnCambly() {
        // given- precondition or setup
        given(camblyRepository.findById(1L)).
                willReturn(java.util.Optional.ofNullable(Cambly.builder()
                        .correction(CORRECTION1)
                        .date(DATE)
                        .lessonId(LESSON_1)
                        .mistake(MISTAKE1).build()));

        // when - action or the behaviour that we are going test
        CamblyDTO camblyDTO = camblyService.getCamblyById(1L);

        // then - verify the output
        assertThat(camblyDTO).isNotNull();
        assertThat(camblyDTO.getCorrection()).isEqualTo(CORRECTION1);

    }
}