package database;

import entity.Course;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JsonMapper {

    public List<Course> mappingToCourse(ResultSet rs) throws SQLException {
        List<Course> result = new ArrayList<Course>();
        while(rs.next()) {
            result.add(mapper(rs));
        }
        return result;
    }

    private Course mapper(ResultSet rs) throws SQLException {
        return new Course(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("targetCluster"),
                        rs.getInt("price"),
                        rs.getString("courseNotice"),
                        rs.getString("notes"));
    }


}
