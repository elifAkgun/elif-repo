package code.elif.springBootUnitTestExamples.service.impl;

import code.elif.springBootUnitTestExamples.model.CamblyDTO;
import code.elif.springBootUnitTestExamples.repository.CamblyRepository;
import code.elif.springBootUnitTestExamples.repository.model.Cambly;
import code.elif.springBootUnitTestExamples.service.CamblyService;
import code.elif.springBootUnitTestExamples.service.exception.DuplicateRecordException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CamblyServiceImpl implements CamblyService {

    private final CamblyRepository camblyRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<CamblyDTO> getAll() {
        List<Cambly> all = camblyRepository.findAll();
        ModelMapper modelMapper = new ModelMapper();
        List<CamblyDTO> camblyDTOList = all
                .stream()
                .map(user -> modelMapper.map(user, CamblyDTO.class))
                .collect(Collectors.toList());
        return camblyDTOList;
    }

    @Override
    public Optional<CamblyDTO> saveCambly(CamblyDTO camblyDTO) {
        Cambly existingCambly = camblyRepository.findByMistakeAndAndCorrectionWithIndexParameter(
                camblyDTO.getMistake(),
                camblyDTO.getCorrection());

        if (existingCambly != null)
            throw new DuplicateRecordException();

        Cambly cambly = modelMapper.map(camblyDTO, Cambly.class);
        Cambly savedCambly = camblyRepository.save(cambly);
        return Optional.of(modelMapper.map(savedCambly, CamblyDTO.class));
    }

    @Override
    public Optional<CamblyDTO> getCamblyById(Long id) {
        return camblyRepository.findById(id).map(cambly ->
                        Optional.of(modelMapper.map(cambly, CamblyDTO.class))
                .orElseGet(() -> CamblyDTO.builder().build()));
    }


    @Override
    public Optional<CamblyDTO> update(CamblyDTO camblyDTO) {
        Cambly cambly = modelMapper.map(camblyDTO, Cambly.class);
        camblyRepository.save(cambly);
        return Optional.of(modelMapper.map(cambly, CamblyDTO.class));
    }

    @Override
    public void delete(Long id) {
        camblyRepository.deleteById(id);
    }
}

