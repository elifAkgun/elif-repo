package code.elif.service.impl;

import code.elif.dao.impl.CamblyDaoImpl;
import code.elif.model.Cambly;
import code.elif.service.CamblyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;


@Service
public class CamblyServiceImpl implements CamblyService {

    public static final String FILE_PATH = "/Volumes/Elements/elif";
    private final CamblyDaoImpl camblyDaoImpl;

    private static final Logger logger = LoggerFactory.getLogger(CamblyServiceImpl.class);

    public CamblyServiceImpl(CamblyDaoImpl camblyDaoImpl) {
        this.camblyDaoImpl = camblyDaoImpl;
    }

    public static void main(String[] args) {
        File file = new File(FILE_PATH);
        String[] directories = file.list((current, name) -> new File(current, name).isDirectory());

        assert directories != null;
        for (String dir : directories) {
            if (dir.contains("ocker")) logger.info(dir);
        }
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
