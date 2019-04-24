package dao;

import model.Course;
import dbcon.DBCon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MySQLCourseDao implements CourseDao {
    private final Connection dbcon = DBCon.getConnection(DBCon.Course);
    private Course getCourseDB(Course course,ResultSet rs) throws SQLException {
        course.setID(rs.getInt("ID"));
        course.setName(rs.getString("name"));
        course.setPrice(rs.getInt("price"));
        course.setNumberOfPeople(rs.getInt("number"));
        course.setNote(rs.getString("note"));
        course.setRemark(rs.getString("remark"));
        course.setSuitable(rs.getString("suitable"));
        course.setDescription(rs.getString("description"));
        return course;
    }
    public MySQLCourseDao() throws Exception { }

    public List<Course> getCourseAll() throws SQLException {
        List<Course> courseAll = new ArrayList<>();
        String sql = "select * from coursebase";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = dbcon.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Course course = new Course();
                courseAll.add(getCourseDB(course,rs));
            }
            return courseAll;
        } catch (SQLException e) {
            System.out.println("fail");
            e.printStackTrace();
        } finally {
            DBCon.closeAll(dbcon, stmt, rs);
        }
        return null;
    }

    public Course selectCourse(int ID) throws SQLException {
        String sql = "select * from coursebase where ID = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Course course = new Course();
        try {
            stmt = dbcon.prepareStatement(sql);
            stmt.setInt(1,ID);
            rs = stmt.executeQuery();
            while (rs.next()) {
               course = getCourseDB(course,rs);
            }
            return course;
        } catch (SQLException e) {
            System.out.println("fail");
            e.printStackTrace();
        } finally {
            DBCon.closeAll(dbcon, stmt, rs);
        }
        return course;
    }

    public void insertCourse(Course course) throws SQLException{
        String sql = "insert into coursebase(price,number,name,note,remark,suitable,description) values(?,?,?,?,?,?,?)";
        PreparedStatement stmt = null;
        int i = 1;
        try{
            stmt = dbcon.prepareStatement(sql);
            stmt.setInt(i++,course.getPrice());
            stmt.setInt(i++,course.getNumberOfPeople());
            stmt.setString(i++,course.getName());
            stmt.setString(i++,course.getNote());
            stmt.setString(i++,course.getRemark());
            stmt.setString(i++,course.getSuitable());
            stmt.setString(i++,course.getDescription());
            stmt.execute();
        }catch (SQLException e){
            System.out.println("fail");
            e.printStackTrace();
        }finally {
            DBCon.closeAll(dbcon,stmt,null);
        }
    }

    public void deleteCourse(int ID) throws SQLException{
        String sql = "DELETE FROM coursebase WHERE ID = ?";
        PreparedStatement stmt = null;
        try{
            stmt = dbcon.prepareStatement(sql);
            stmt.setInt(1,ID);
            stmt.execute();
        }catch (SQLException e){
            System.out.println("fail");
            e.printStackTrace();
        }finally {
            DBCon.closeAll(dbcon,stmt,null);
        }
    }

    public void updateCourse(Course course) throws SQLException{
        String sql = "update coursebase set price = ? ,number = ? ,name = ? ,note = ? ,remark = ? ,suitable = ? ,description = ?  where ID = ?";
        PreparedStatement stmt = null;
        int i = 1;
        try{
            stmt = dbcon.prepareStatement(sql);
            stmt.setInt(i++,course.getPrice());
            stmt.setInt(i++,course.getNumberOfPeople());
            stmt.setString(i++,course.getName());
            stmt.setString(i++,course.getNote());
            stmt.setString(i++,course.getRemark());
            stmt.setString(i++,course.getSuitable());
            stmt.setString(i++,course.getDescription());
            stmt.setInt(i++,course.getID());
            stmt.execute();
        }catch (SQLException e){
            System.out.println("fail");
            e.printStackTrace();
        }finally {
            DBCon.closeAll(dbcon,stmt,null);
        }

    }
}
