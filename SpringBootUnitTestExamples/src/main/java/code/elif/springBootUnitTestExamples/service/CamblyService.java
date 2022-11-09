package code.elif.springBootUnitTestExamples.service;

import code.elif.springBootUnitTestExamples.model.CamblyDTO;

import java.util.List;
import java.util.Optional;

public interface CamblyService {

    List<CamblyDTO> getAll();

    Optional<CamblyDTO> saveCambly(CamblyDTO camblyDTO);

    Optional<CamblyDTO> getCamblyById(Long id);

    Optional<CamblyDTO> update(CamblyDTO camblyDTO);

    void delete(Long id);
}
