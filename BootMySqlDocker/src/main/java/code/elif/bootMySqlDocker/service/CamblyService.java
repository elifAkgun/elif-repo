package code.elif.bootMySqlDocker.service;

import code.elif.bootMySqlDocker.model.Cambly;
import code.elif.bootMySqlDocker.repository.CamblyDTO;
import code.elif.bootMySqlDocker.repository.CamblyRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CamblyService {
    private final CamblyRepository camblyRepository;

    @Autowired
    public CamblyService(CamblyRepository camblyRepository) {
        this.camblyRepository = camblyRepository;
    }

    public List<Cambly> getAll() {
        List<CamblyDTO> all = camblyRepository.findAll();
        ModelMapper modelMapper = new ModelMapper();
        List<Cambly> camblyList = all
                .stream()
                .map(user -> modelMapper.map(user, Cambly.class))
                .collect(Collectors.toList());
        return camblyList;
    }
}
