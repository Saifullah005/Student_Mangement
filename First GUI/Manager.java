import java.util.ArrayList;

public class Manager {
    ArrayList<Student> s = new ArrayList<>();
    
    public void addStudent(Student st){
        s.add(st);
    }

    public String display(){
        String studentsRecord = "";
        for(Student st : s){
            studentsRecord += st.toString();
        }
        return studentsRecord;
    }
}
