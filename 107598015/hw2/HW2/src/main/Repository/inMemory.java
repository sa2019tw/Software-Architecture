package main.Repository;
import main.entity.Course;
import java.util.ArrayList;
import java.util.List;

public class inMemory implements ICourseDao{
    private static List<Course> list = new ArrayList<>();
    public void add(Course c)
    {
        list.add(c);
    }
    public List<Course> show()
    {
        System.out.println("total size="+list.size());
        for(int i=0;i<list.size();i++)
        {
            System.out.println("num"+i+"="+list.get(i).getCourseName());
            System.out.println("num"+i+"="+list.get(i).getPrice());
        }
        return  list;
    }
    public void edit(Course course)
    {

        for(int i=0;i<list.size();i++)
        {
           if(list.get(i).getCourseName().equals(course.getCourseName()))
           {
               System.out.println("in");
               System.out.println("edit:"+list.get(i).getCourseName());
               list.get(i).setCourseDescription(course.getCourseDescription());
               list.get(i).setApplicableObject(course.getApplicableObject());
               list.get(i).setPrecautions(course.getPrecautions());
               list.get(i).setPrice(course.getPrice());
               list.get(i).setRemark(course.getRemark());
           }
           else
            {
                System.out.println("in else");
            }
        }

    }
    public void delete(Course course)
    {
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i).getCourseName().equals(course.getCourseName()))
            {
                list.remove(i);
            }
        }
    }
}
