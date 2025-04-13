package code.elif.dao.impl.rowMapper;

import code.elif.model.Cambly;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CamblyRowMapper implements RowMapper<Cambly> {

    @Override
    public Cambly mapRow(ResultSet resultSet, int i) throws SQLException {
        Cambly cambly = new Cambly();
        cambly.setId(resultSet.getInt("id"));
        cambly.setLessonId(resultSet.getInt("lesson_id"));
        cambly.setCorrection(resultSet.getString("correction"));
        cambly.setMistake(resultSet.getString("mistake"));
        cambly.setDate(resultSet.getDate("date").toLocalDate());
        return cambly;
    }
}
