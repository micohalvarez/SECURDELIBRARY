package app.com.service;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by Micoh F Alvarez on 8/9/2017.
 */
public class ResourceDAOImpl implements ResourceDAO {

    private JdbcTemplate temp;

    public ResourceDAOImpl(DataSource dataSource) {
        temp = new JdbcTemplate(dataSource);
    }
}
