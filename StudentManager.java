package Java_practical;
import java.util.*;
import java.util.logging.*;

    class StudentManager<T> 
    {
        private List<Student> students;
    
        public StudentManager() 
        {
            students = new ArrayList<Student>();
        }

        public void remove(Student student) 
        {
            students.remove(student);
            Logger.getLogger("StudentManager").log(Level.INFO, "Student removed: " + student.toString());
        }
    
        public void add(Student student) 
        {
            students.add(student);
            Logger.getLogger("StudentManager").log(Level.INFO, "new student: " + student.toString());
        }
    
        public List<Student> getAll() 
        {
            return students;
        }
    
        public List<Student> search(String keyword) 
        {
            List<Student> result = new ArrayList<Student>();
            for (Student student : students) 
            {
                String inter = student.Infos();
                if (inter.contains(keyword)) 
                {
                    result.add(student);
                }
            }
            return result;
        }
    }
    