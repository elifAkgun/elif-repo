package code.elif.springBootUnitTestExamples.repository;

import code.elif.springBootUnitTestExamples.repository.model.Cambly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CamblyRepository extends JpaRepository<Cambly, Long> {

    List<Cambly> findByMistakeContaining(String mistake);

    @Query("select c from camblyDTO c where c.mistake = ?1 and c.correction=?2")
    Cambly findByMistakeAndAndCorrectionWithIndexParameter(String mistake,
                                                                 String correction);

    @Query("select c from camblyDTO c where c.mistake = :mistake " +
            "and c.correction=:correction")
    Cambly findByMistakeAndAndCorrectionWithNamedParameter(String mistake,
                                                                 String correction);

    @Query(value = "select * from cambly c where c.mistake = ?1 " +
            "and c.correction=?2", nativeQuery = true)
    Cambly findByMistakeAndAndCorrectionWithNativeSQLWithIndexParameter(String mistake,
                                                                              String correction);

    @Query(value = "select * from cambly c where c.mistake = :mistake " +
            "and c.correction=:correction", nativeQuery = true)
    Cambly findByMistakeAndAndCorrectionWithNativeSQLWithNamedParameter(String mistake,
                                                                              String correction);
}
