package code.elif.service.impl;

import code.elif.dao.impl.CamblyDaoImpl;
import code.elif.model.Cambly;
import code.elif.service.CamblyService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


@Service
public class CamblyServiceImpl implements CamblyService {

    private final CamblyDaoImpl camblyDaoImpl;

    public CamblyServiceImpl(CamblyDaoImpl camblyDaoImpl) {
        this.camblyDaoImpl = camblyDaoImpl;
    }

    public static void main(String[] args) {
        File file = new File("/Volumes/Elements/elif");
        String[] directories = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File current, String name) {
                return new File(current, name).isDirectory();
            }
        });

        Stream.of(directories).forEach((dir) -> {
            if (dir.contains("ocker")) System.out.println(dir);
        });
    }

    @Override
    public List<Cambly> getAllCamblys() {
        return camblyDaoImpl.getAllCamblys();
    }

    @Override
    public Boolean createCambly(Cambly cambly) {
        return camblyDaoImpl.createCambly(cambly);
    }

    @Override
    public Cambly getCambly(Integer id) {
        return camblyDaoImpl.getCambly(id);
    }

    @Override
    public void deleteCambly(Integer camblyId) {
        camblyDaoImpl.deleteCambly(camblyId);
    }

    @Override
    public Cambly updateCambly(Cambly cambly) {
        return camblyDaoImpl.updateCambly(cambly);
    }

    @Override
    public List<Cambly> searchCamblys(String theSearchName) {
        return camblyDaoImpl.searchCamblys(theSearchName);
    }


}
