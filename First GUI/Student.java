public class Student {
    private int id;
    private double marks;
    private String name;

    public Student(int id , double marks , String name){
        this.id = id; this.marks = marks; this.name = name;
    }

    public String getName(){
        return name;
    }    

    public int getId(){
        return id;
    }

    public double getMarks(){
        return marks;
    }

    @Override
    public String toString(){
        return "Name " + getName() + "\nID " + getId() + "\nMarks" + getMarks() + "\n";
    }
}