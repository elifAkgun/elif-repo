package code.elif.springBootUnitTestExamples.controller;

import code.elif.springBootUnitTestExamples.model.CamblyDTO;
import code.elif.springBootUnitTestExamples.service.CamblyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cambly")
public class CamblyController {

    private final CamblyService camblyService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<CamblyDTO> create(@RequestBody CamblyDTO camblyDTO) {
        Optional<CamblyDTO> saveCambly = camblyService.saveCambly(camblyDTO);
        return saveCambly.map(
                ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<CamblyDTO> getAllCamblies() {
        return camblyService.getAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<CamblyDTO> getCamblyById(@PathVariable("id") Long camblyId) {
        Optional<CamblyDTO> camblyById = camblyService.getCamblyById(camblyId);
        return camblyById.map(
                ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CamblyDTO> updateCambly(@PathVariable("id") Long camblyId, @RequestBody CamblyDTO camblyDTO) {
        return camblyService.getCamblyById(camblyId)
                .map(savedCambly -> {
                    savedCambly.setMistake(camblyDTO.getMistake());
                    savedCambly.setCorrection(camblyDTO.getCorrection());
                    savedCambly.setDate(camblyDTO.getDate());
                    savedCambly.setLessonId(camblyDTO.getLessonId());
                    camblyService.update(savedCambly);

                    return new ResponseEntity<>(savedCambly, HttpStatus.OK);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCambly(@PathVariable("id") Long camblyId) {

        return camblyService.getCamblyById(camblyId)
                .map((camblyDTO) -> {
                    camblyService.delete(camblyDTO.getId());
                    return new ResponseEntity("Cambly deleted successfully", HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity("Cambly not found", HttpStatus.NOT_FOUND));
    }
}
