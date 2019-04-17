package main.Repository;

import main.entity.Course;
import java.io.IOException;
import java.util.List;

public interface ICourseDao {
     void add(Course c) throws IOException;
     List<Course> show();
     void edit(Course course) throws IOException;
     void delete(Course course) throws IOException;
}
