package code.elif.dao.impl.rowMapper;

import code.elif.model.Organization;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrganizationRowMapper implements RowMapper<Organization>  {


    public Organization mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Organization organization = new Organization();
        organization.setId(resultSet.getInt("id"));
        organization.setCompanyName(resultSet.getString("company_name"));
        organization.setEmployeeCount(resultSet.getInt("employee_count"));
        organization.setPostalCode(resultSet.getString("postal_code"));
        organization.setYearOfIncorporation(resultSet.getInt("year_of_incorporation"));
        organization.setSlogan(resultSet.getString("slogan"));

        return organization;
    }
}
