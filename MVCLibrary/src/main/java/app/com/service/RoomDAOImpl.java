package app.com.service;

import app.com.model.Room;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Micoh F Alvarez on 8/9/2017.
 */
public class RoomDAOImpl implements RoomDAO {

    private JdbcTemplate temp;

    public RoomDAOImpl(DataSource dataSource) {
        temp = new JdbcTemplate(dataSource);
    }

    public List<Room> getAllRooms(){

        String sql = "SELECT * FROM " + Room.TABLE_NAME;

        List<Room> r = temp.query(sql,new RowMapper<Room>() {
            @Override
            public Room mapRow(ResultSet rs, int rowNum) throws SQLException {
                // TODO Auto-generated method stub
                Room r = new Room();

                r.setFloor(rs.getInt(Room.COLUMN_FLOOR));

                return r;
            }
        });

        return r;
    }
}
