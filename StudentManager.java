package Java_practical;
import java.util.*;
import java.util.logging.*;

    class StudentManager<student> 
    {
        private List<student> students;
    
        public StudentManager() 
        {
            students = new ArrayList<student>();
        }

        public void remove(student student) 
        {
            students.remove(student);
            Logger.getLogger("StudentManager").log(Level.INFO, "Student removed: " + student.toString());
        }
    
        public void add(student student) 
        {
            students.add(student);
            Logger.getLogger("StudentManager").log(Level.INFO, "new student: " + student.toString());
        }
    
        public List<student> getAll() 
        {
            return students;
        }
    
        public List<student> search(String keyword) 
        {
            List<student> result = new ArrayList<student>();
            for (student student : students) {
                if (student.toString().contains(keyword)) 
                {
                    result.add(student);
                }
            }
            return result;
        }
    }
    