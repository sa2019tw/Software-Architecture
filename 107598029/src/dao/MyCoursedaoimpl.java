package dao;

import model.Course;
import dbconn.DbConn;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyCoursedaoimpl implements CourseDaoInterface {
    public List<Course> readallcourse() throws SQLException {
        List<Course> list = new ArrayList<Course>();
        String sql = "SELECT * FROM coursesys";
        conn = DbConn.getConnection(DbConn.SA);
        state = conn.createStatement();
        rs = state.executeQuery(sql);
        while(rs.next()){
            Course c = new Course(
                rs.getInt("courseid"),
                rs.getString("coursename"),
                rs.getString("courselevel"),
                rs.getInt("courseprice"),
                rs.getString("coursedescription"),
                rs.getString("precautions"),
                rs.getString("remarks")
            );
            list.add(c);
        }
        rs.close();
        state.close();
        conn.close();
        return list;
    }

    public Course getcourseinfo(Integer id) throws SQLException{
        String sql = "SELECT * FROM coursesys WHERE courseid=" + id;
        conn = DbConn.getConnection(DbConn.SA);
        state = conn.createStatement();
        rs = state.executeQuery(sql);
        pstate = null;
        Course course = null;
        try {
            while(rs.next()){
                course = new Course(
                    rs.getInt("courseid"),
                    rs.getString("coursename"),
                    rs.getString("courselevel"),
                    rs.getInt("courseprice"),
                    rs.getString("coursedescription"),
                    rs.getString("precautions"),
                    rs.getString("remarks")
                );
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        state.close();
        conn.close();
        return course;
    }

    public void creatcourse(Course c) throws SQLException{
        String sql = "INSERT INTO sa.coursesys (coursename, courselevel, courseprice, coursedescription, precautions, remarks) VALUES (?, ?, ?, ?, ?, ?)";
        conn = DbConn.getConnection(DbConn.SA);
        pstate = null;
        try{
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, c.getName());
            pstate.setString(2, c.getLevel());
            pstate.setInt(3, c.getPrice());
            pstate.setString(4, c.getDescription());
            pstate.setString(5, c.getPrecautions());
            pstate.setString(6, c.getRemarks());
            pstate.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updatecourse(Course c) throws SQLException{
        String sql ="UPDATE sa.coursesys " +
                    "SET coursename=?, courselevel=?, courseprice=?, coursedescription=?, precautions=?, remarks=? " +
                    "WHERE courseid=?";
        conn = DbConn.getConnection(DbConn.SA);
        pstate = null;
        try{
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, c.getName());
            pstate.setString(2, c.getLevel());
            pstate.setInt(3, c.getPrice());
            pstate.setString(4, c.getDescription());
            pstate.setString(5, c.getPrecautions());
            pstate.setString(6, c.getRemarks());
            pstate.setInt(7, c.getId());
            pstate.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deletecourse(Integer id) throws SQLException{
        String sql ="DELETE FROM sa.coursesys " +
                "WHERE courseid=?";
        conn = DbConn.getConnection(DbConn.SA);
        pstate = null;
        try{
            pstate = conn.prepareStatement(sql);
            pstate.setInt(1, id);
            pstate.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
        conn.close();
    }

    public List<Course> findcourse(String cname) throws SQLException {
        List<Course> list = new ArrayList<Course>();
        String sql = "SELECT * FROM sa.coursesys WHERE coursename LIKE " + "'%" +  cname + "%'";

        conn = DbConn.getConnection(DbConn.SA);
        state = conn.createStatement();
        rs = state.executeQuery(sql);
        while(rs.next()){
            Course c = new Course(
                    rs.getInt("courseid"),
                    rs.getString("coursename"),
                    rs.getString("courselevel"),
                    rs.getInt("courseprice"),
                    rs.getString("coursedescription"),
                    rs.getString("precautions"),
                    rs.getString("remarks")
            );
            list.add(c);
        }
        rs.close();
        state.close();
        conn.close();
        return list;
    }

    private PreparedStatement pstate;
    private Connection conn;
    private Statement state;
    private ResultSet rs;
}
