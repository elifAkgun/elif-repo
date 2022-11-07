package code.elif.springBootUnitTestExamples.repository;

import code.elif.springBootUnitTestExamples.repository.model.Cambly;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class CamblyRepositoryTest {

    public static final String MISTAKE = "MISTAKE";
    public static final String CORRECTION = "CORRECTION";
    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private CamblyRepository camblyRepository;

    @Test
    void injectedComponentsAreNotNull() {
        assertThat(dataSource).isNotNull();
        assertThat(jdbcTemplate).isNotNull();
        assertThat(entityManager).isNotNull();
        assertThat(camblyRepository).isNotNull();
    }

    @DisplayName("CamblyDTO Save operation")
    @Test
    void givenCamblyObject_whenSave_ThenIdOfSavedCamblyIsNotNullAndGraterThanZero() {
        //given - precondition or setup
        Cambly cambly = Cambly.builder().lessonId(1)
                .mistake(MISTAKE).correction(CORRECTION)
                .date(LocalDate.of(2020, 12, 12))
                .build();

        // when - action or the behaviour that we are going test
        camblyRepository.save(cambly);

        // then - verify the output
        assertThat(cambly.getId()).isNotNull();
        assertThat(cambly.getId()).isGreaterThan(0);
    }

    @DisplayName("Get FindAll Camblies Operation")
    @Test
    void givenSavedCambly_whenFindAll_ThenReturnSavedCambly() {
        //given - precondition or setup
        Cambly cambly = Cambly.builder().lessonId(1)
                .mistake(MISTAKE).correction(CORRECTION)
                .date(LocalDate.of(2020, 12, 12))
                .build();
        camblyRepository.save(cambly);

        // when - action or the behaviour that we are going test
        List<Cambly> all = camblyRepository.findAll();

        // then - verify the output
        assertThat(all).hasSize(1);
    }

    // JUnit test for
    @DisplayName("Cambly FindByID Operation")
    @Test
    public void givenCamblyObject_whenFindById_thenGetSavedObject() {
        // given- precondition or setup
        Cambly cambly = Cambly.builder().lessonId(1)
                .mistake(MISTAKE).correction(CORRECTION)
                .date(LocalDate.of(2020, 12, 12))
                .build();
        camblyRepository.save(cambly);
        // when - action or the behaviour that we are going test
        Optional<Cambly> camblyRepositoryById =
                camblyRepository.findById(cambly.getId());
        // then - verify the output
        assertThat(camblyRepositoryById).isNotNull();
        assertThat(camblyRepositoryById.get().getId())
                .isEqualTo(cambly.getId());

    }

    // JUnit test for
    @DisplayName("FindByMistakeContains Operation")
    @Test
    public void givenCamblyObject_whenFindByMistakeContainingCalled_thenReturnContainingCamblies() {
        // given- precondition or setup
        Cambly cambly = Cambly.builder().lessonId(1)
                .mistake(MISTAKE).correction(CORRECTION)
                .date(LocalDate.of(2020, 12, 12))
                .build();
        camblyRepository.save(cambly);

        Cambly cambly2 = Cambly.builder().lessonId(1)
                .mistake("MILK").correction(CORRECTION)
                .date(LocalDate.of(2020, 12, 12))
                .build();
        camblyRepository.save(cambly);


        // when - action or the behaviour that we are going test
        List<Cambly> camblyRepositoryByMistakeContaining =
                camblyRepository.findByMistakeContaining("MIS");

        // then - verify the output
        assertThat(camblyRepositoryByMistakeContaining.size())
                .isEqualTo(1);
    }

    // JUnit test for
    @DisplayName("Update Operations for CamblyDTO - Saved Only Once")
    @Test
    public void givenCamblyObject_whenUpdated_thenCheckObjectSavedOnce() {
        // given- precondition or setup
        Cambly cambly = Cambly.builder().lessonId(1)
                .mistake(MISTAKE).correction(CORRECTION)
                .date(LocalDate.of(2020, 12, 12))
                .build();
        camblyRepository.save(cambly);

        // when - action or the behaviour that we are going test
        cambly.setMistake("MILK");
        camblyRepository.save(cambly);

        // then - verify the output
        List<Cambly> camblyRepositoryAll = camblyRepository.findAll();
        assertThat(camblyRepositoryAll.size()).isEqualTo(1);
    }

    @DisplayName("Update Operations for CamblyDTO - Update Fields")
    @Test
    public void givenCamblyObject_whenUpdated_thenReturnUpdatedObject() {
        // given- precondition or setup
        Cambly cambly = Cambly.builder().lessonId(1)
                .mistake(MISTAKE).correction(CORRECTION)
                .date(LocalDate.of(2020, 12, 12))
                .build();
        camblyRepository.save(cambly);

        // when - action or the behaviour that we are going test
        String updatedMistake = "MILK";
        cambly.setMistake(updatedMistake);
        camblyRepository.save(cambly);

        // then - verify the output
        Optional<Cambly> camblyRepositoryAll =
                camblyRepository.findById(cambly.getId());
        assertThat(camblyRepositoryAll.get().getMistake())
                .isEqualTo(updatedMistake);
    }

    // JUnit test for
    @DisplayName("Delete Operations")
    @Test
    public void givenCamblyObject_whenDeleteExecuted_thenRemoveCambly() {
        // given- precondition or setup
        Cambly cambly = Cambly.builder().lessonId(1)
                .mistake(MISTAKE).correction(CORRECTION)
                .date(LocalDate.of(2020, 12, 12))
                .build();
        camblyRepository.save(cambly);

        // when - action or the behaviour that we are going test
        camblyRepository.delete(cambly);
        Optional<Cambly> camblyRepositoryById =
                camblyRepository.findById(cambly.getId());

        // then - verify the output
        assertThat(camblyRepositoryById).isEmpty();
    }

    // JUnit test for
    @DisplayName("Custom Query Test Operation")
    @Test
    public void givenCamblyObject_whenFindByMistakeAndAndCorrectionWithCustomQuery_thenReturnFilteredResult() {
        // given- precondition or setup
        Cambly cambly = Cambly.builder().lessonId(1)
                .mistake(MISTAKE).correction(CORRECTION)
                .date(LocalDate.of(2020, 12, 12))
                .build();
        camblyRepository.save(cambly);

        // when - action or the behaviour that we are going test
        Cambly result =
                camblyRepository.findByMistakeAndAndCorrectionWithIndexParameter(
                        MISTAKE, CORRECTION);

        // then - verify the output
        assertThat(result.getMistake()).isEqualTo(MISTAKE);
    }

    @DisplayName("Custom Query Test Operation")
    @Test
    public void givenCamblyObject_whenFindByMistakeAndAndCorrectionWithCustomQueryNamedParameter_thenReturnFilteredResult() {
        // given- precondition or setup
        Cambly cambly = Cambly.builder().lessonId(1)
                .mistake(MISTAKE).correction(CORRECTION)
                .date(LocalDate.of(2020, 12, 12))
                .build();
        camblyRepository.save(cambly);

        // when - action or the behaviour that we are going test
        Cambly result =
                camblyRepository.findByMistakeAndAndCorrectionWithNamedParameter(
                        MISTAKE, CORRECTION);

        // then - verify the output
        assertThat(result.getMistake()).isEqualTo(MISTAKE);
    }

    @DisplayName("Custom Query Test Operation")
    @Test
    public void givenCamblyObject_whenFindByMistakeAndAndCorrectionWithNativeSQL_thenReturnFilteredResult() {
        // given- precondition or setup
        Cambly cambly = Cambly.builder().lessonId(1)
                .mistake(MISTAKE).correction(CORRECTION)
                .date(LocalDate.of(2020, 12, 12))
                .build();
        camblyRepository.save(cambly);

        // when - action or the behaviour that we are going test
        Cambly result =
                camblyRepository.findByMistakeAndAndCorrectionWithNativeSQLWithIndexParameter(
                        MISTAKE, CORRECTION);

        // then - verify the output
        assertThat(result.getMistake()).isEqualTo(MISTAKE);
    }


    @DisplayName("Custom Query Test Operation")
    @Test
    public void givenCamblyObject_whenFindByMistakeAndAndCorrectionWithNativeSQLNamedParameter_thenReturnFilteredResult() {
        // given- precondition or setup
        Cambly cambly = Cambly.builder().lessonId(1)
                .mistake(MISTAKE).correction(CORRECTION)
                .date(LocalDate.of(2020, 12, 12))
                .build();
        camblyRepository.save(cambly);

        // when - action or the behaviour that we are going test
        Cambly result =
                camblyRepository.findByMistakeAndAndCorrectionWithNativeSQLWithNamedParameter(
                        MISTAKE, CORRECTION);

        // then - verify the output
        assertThat(result.getMistake()).isEqualTo(MISTAKE);
    }

    @DisplayName("Custom Query Test Operation")
    @Test
    public void givenNonExistCambly_whenFindByMistakeAndAndCorrectionWithNativeSQLNamedParameter_thenReturnNull() {
        // given- precondition or setup

        // when - action or the behaviour that we are going test
        Cambly result =
                camblyRepository.findByMistakeAndAndCorrectionWithNativeSQLWithNamedParameter(
                        MISTAKE, CORRECTION);

        // then - verify the output
        assertThat(result).isEqualTo(null);
    }

}