package code.elif.springBootUnitTestExamples.service;

import code.elif.springBootUnitTestExamples.model.CamblyDTO;
import code.elif.springBootUnitTestExamples.repository.CamblyRepository;
import code.elif.springBootUnitTestExamples.repository.model.Cambly;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CamblyService {

    private final CamblyRepository camblyRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public List<CamblyDTO> getAll() {
        List<Cambly> all = camblyRepository.findAll();
        ModelMapper modelMapper = new ModelMapper();
        List<CamblyDTO> camblyDTOList = all
                .stream()
                .map(user -> modelMapper.map(user, CamblyDTO.class))
                .collect(Collectors.toList());
        return camblyDTOList;
    }

    public CamblyDTO saveCambly(CamblyDTO camblyDTO) {
        Cambly existingCambly = camblyRepository.findByMistakeAndAndCorrectionWithIndexParameter(
                camblyDTO.getMistake(),
                camblyDTO.getCorrection());

        if (existingCambly != null)
            throw new DuplicateRecordException();

        Cambly cambly = modelMapper.map(camblyDTO, Cambly.class);
        camblyRepository.save(cambly);

        return modelMapper.map(cambly, CamblyDTO.class);
    }

    public CamblyDTO getCamblyById(Long id) {
        return modelMapper.map(camblyRepository.findById(id), CamblyDTO.class) ;

    }
}

