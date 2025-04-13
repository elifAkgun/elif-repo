package code.elif.dao.impl;

import code.elif.dao.CamblyDao;
import code.elif.dao.impl.rowMapper.CamblyRowMapper;
import code.elif.model.Cambly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("camblyDaoComp")
public class CamblyDaoImpl implements CamblyDao {

    private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<Cambly> getAllCamblys() {
        System.out.println();
        return jdbcTemplate.query("SELECT * FROM cambly", new CamblyRowMapper());
    }

    @Override
    public Boolean createCambly(Cambly cambly) {
        Object[] args = {cambly.getCorrection(), cambly.getMistake(), cambly.getLessonId(), cambly.getDate()};
        return jdbcTemplate.update("INSERT INTO cambly (mistake, correction, lesson_id, date) VALUES (?,?,?,?)", args) == 1;
    }

    @Override
    public Cambly getCambly(Integer id) {
        String sql = "SELECT * FROM cambly WHERE id=?";
        Object[] args = new Object[]{id};
        Cambly cambly = jdbcTemplate.queryForObject(sql, new CamblyRowMapper(), args);
        return cambly;
    }

    public void deleteCambly(Integer id) {
        String sql = "DELETE FROM cambly WHERE id=?";
        Object[] args = new Object[]{id};
        jdbcTemplate.update(sql, args);
    }

    @Override
    public Cambly updateCambly(Cambly cambly) {
        Object[] args = {cambly.getMistake(), cambly.getCorrection(), cambly.getLessonId(), cambly.getDate(), cambly.getId()};
        jdbcTemplate.update("UPDATE cambly SET mistake=?, correction=?, lesson_id=?, date=? WHERE id=?", args);
        return cambly;
    }

    @Override
    public List<Cambly> searchCamblys(String word) {
        String sql = "SELECT * FROM cambly where correction like :word or mistake like :word";
        Map<String, Object> params = new HashMap<>();
        params.put("word", "%" + word + "%");
        return namedParameterJdbcTemplate.query(sql, params, new CamblyRowMapper());
    }
}
