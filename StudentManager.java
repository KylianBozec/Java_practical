package Java_practical;
import java.util.*;
import java.util.logging.*;

    class StudentManager<T> 
    {
        private List<T> students;
    
        public StudentManager() 
        {
            students = new ArrayList<T>();
        }
    
        public void add(T student) 
        {
            students.add(student);
            Logger.getLogger("StudentManager").log(Level.INFO, "Student added: " + student.toString());
        }
    
        public void remove(T student) 
        {
            students.remove(student);
            Logger.getLogger("StudentManager").log(Level.INFO, "Student removed: " + student.toString());
        }
    
        public List<T> getAll() 
        {
            return students;
        }
    
        public List<T> search(String keyword) 
        {
            List<T> result = new ArrayList<T>();
            for (T student : students) {
                if (student.toString().contains(keyword)) 
                {
                    result.add(student);
                }
            }
            return result;
        }
    }
    