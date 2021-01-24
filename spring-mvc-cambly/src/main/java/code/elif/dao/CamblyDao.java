package code.elif.dao;

import code.elif.model.Cambly;

import javax.sql.DataSource;
import java.util.List;

public interface CamblyDao {

    public void setDataSource(DataSource dataSource);

    public List<Cambly> getAllCamblys();

    public Boolean createCambly(Cambly Cambly);

    public Cambly getCambly(Integer id);

    public void deleteCambly(Integer id);

    public Cambly updateCambly(Cambly Cambly);

    List<Cambly> searchCamblys(String theSearchName);
}
