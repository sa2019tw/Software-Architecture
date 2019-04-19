package main.Repository;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.entity.Course;

public class InText implements ICourseDao {
    private  List<Course> list = new ArrayList<>();
    static Scanner Keyin;
    public InText() throws IOException {
        read();
    }
    @Override
    public void add(Course c) throws IOException {
        list.add(c);
        save(list);
    }

    @Override
    public List<Course> show() {
        for(int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i).getCourseName());
        }
        return  list;
    }

    @Override
    public void edit(Course course) throws IOException{

        for(int i=0;i<list.size();i++)
        {
            if(list.get(i).getCourseName().equals(course.getCourseName()))
            {
                list.get(i).setCourseDescription(course.getCourseDescription());
                list.get(i).setApplicableObject(course.getApplicableObject());
                list.get(i).setPrecautions(course.getPrecautions());
                list.get(i).setPrice(course.getPrice());
                list.get(i).setRemark(course.getRemark());
                save(list);

            }
            else
            {
                System.out.println("in else");
            }
        }

    }

    @Override
    public void delete(Course course) throws IOException {
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i).getCourseName().equals(course.getCourseName()))
            {
                list.remove(i);
                save(list);
            }
        }

    }
    public void read() throws IOException {
        String inData;
        String file_R= "HW2/src/main/database.txt";
        File fileID=new File(file_R);
        if(fileID.exists())
        {
            BufferedReader data=new BufferedReader(new FileReader(fileID));
            while((inData=data.readLine())!=null)
            {
                Scanner s=new Scanner(inData).useDelimiter(",");
                String a="123";
                Course c=new Course();
                c.setCourseName(s.next());
                c.setCourseDescription(s.next());
                c.setApplicableObject(s.next());
                c.setPrice(Integer.parseInt(s.next()));
                c.setPrecautions(s.next());
                c.setRemark(s.next());
                list.add(c);
            }
            data.close();
        }
        else
        {
            System.out.print("nothing mach file");
        }

    }
    public void save(List<Course> list) throws IOException {
        String file_R="HW2/src/main/database.txt";
        BufferedWriter outData=new BufferedWriter(new FileWriter(file_R));
        Keyin=new Scanner(System.in);

        for(int i=0;i<list.size();i++)
        {
            outData.write(list.get(i).getCourseName()+',');
            outData.write(list.get(i).getCourseDescription()+',');
            outData.write(list.get(i).getApplicableObject()+',');
            outData.write(Integer.toString(list.get(i).getPrice())+',');
            outData.write(list.get(i).getPrecautions()+',');
            outData.write(list.get(i).getRemark()+'\n');
        }
        outData.close();
    }


}
