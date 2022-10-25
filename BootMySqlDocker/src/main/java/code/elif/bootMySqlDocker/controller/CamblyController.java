package code.elif.bootMySqlDocker.controller;

import code.elif.bootMySqlDocker.repository.CamblyDTO;
import code.elif.bootMySqlDocker.repository.CamblyRepository;
import org.apache.tomcat.util.http.fileupload.util.Streams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@RestController
public class CamblyController {

    private final CamblyRepository camblyRepository;

    @Autowired
    public CamblyController(CamblyRepository camblyRepository) {
        this.camblyRepository = camblyRepository;
    }

    @GetMapping("/cambly")
    public List<CamblyDTO> index(){
        return camblyRepository.findAll();
    }


    public static void main(String[] args) {
        File file = new File("/Volumes/Elements/elif");
        String[] directories = file.list((current, name)
                -> new File(current, name).isDirectory());
        Stream.of(directories).forEach(l->

                System.out.println(l));
    }
}
