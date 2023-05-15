package Java_practical;
import java.time.LocalDate;

public class Student 
{
    private String name;
    
    private String id;
    
    private String email;
    
    private LocalDate Birthdate;

    public Student(String name, String id, String email, LocalDate Birthdate) 
    {
        this.name = name;
        this.id = id;
        this.email = email;
        this.Birthdate = Birthdate;
    }

    public String getName() 
    {
        return name;
    }

    public String getId() 
    {
        return id;
    }

    public String getEmail() 
    {
        return email;
    }

    public LocalDate getBirthdate() 
    {
        return Birthdate;
    }

    public String Infos() 
    {
        return "Name: " + name + ", ID: " + id + ", Email: " + email + ", DOB: " + Birthdate.toString();
    }
}