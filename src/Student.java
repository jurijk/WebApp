
import java.io.Serializable;

public class Student implements Serializable{

    private static final long serialVersionUID = 1L;

    private int id_student;
    private String first_second_name;
    private int id_class;
    private int year_receipt;

    public Student(){}

    public Student(String first_second_name, int id_class, int year_receipt) {
        this.first_second_name = first_second_name;
        this.id_class = id_class;
        this.year_receipt = year_receipt;
    }

    public Student(int id_student, String first_second_name, int id_class, int year_receipt) {
        this.id_student = id_student;
        this.first_second_name = first_second_name;
        this.id_class = id_class;
        this.year_receipt = year_receipt;
    }

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public String getFirst_second_name() {
        return first_second_name;
    }

    public void setFirst_second_name(String first_second_name) {
        this.first_second_name = first_second_name;
    }

    public int getId_class() {
        return id_class;
    }

    public void setId_class(int id_class) {
        this.id_class = id_class;
    }

    public int getYear_receipt() {
        return year_receipt;
    }

    public void setYear_receipt(int year_receipt) {
        this.year_receipt = year_receipt;
    }
}
