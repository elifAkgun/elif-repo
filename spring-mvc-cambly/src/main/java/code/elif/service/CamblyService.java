package code.elif.service;

import code.elif.model.Cambly;

import java.util.List;

public interface CamblyService {
    public List<Cambly> getAllCamblys();

    public Boolean createCambly(Cambly Cambly);

    public Cambly getCambly(Integer id);

    public void deleteCambly(Integer id);

    public Cambly updateCambly(Cambly Cambly);

    List<Cambly> searchCamblys(String theSearchName);
}
