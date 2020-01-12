
import java.sql.*;
import java.util.ArrayList;

public class StudentDB
{
    private static String USER = "root";//логин доступа к базе
    private static String PASSWORD = "Magnum1783";//пароль доступа к базе
    private static String URL = "jdbc:mysql://localhost:3306/mysql?serverTimezone=Europe/Moscow&useSSL=false";


    public static ArrayList<Student> select()
    {
        ArrayList<Student> students = new ArrayList<Student>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)){
                System.out.println("Получен connection");
                Statement statement = conn.createStatement();
                System.out.println("Получен statement");
                ResultSet resultSet = statement.executeQuery("select * from student.students");
                while(resultSet.next()){

                    int id_student = resultSet.getInt(1);
                    String first_second_name = resultSet.getString(2);
                    int id_class = resultSet.getInt(3);
                    int year_receipt = resultSet.getInt(4);
                    Student student = new Student(id_student,first_second_name,id_class,year_receipt);
                    students.add(student);
                }
            }
        }
        catch(Exception ex){ System.out.println(ex); }
        return students;
    }

    public static int insert(Student student)
    {
     try{
         Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
         try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)){
             String sql = "INSERT INTO student.students (first_second_name, id_class, year_receipt) Values (?, ?, ?)";

             try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                 preparedStatement.setString(1, student.getFirst_second_name());
                 preparedStatement.setInt(2, student.getId_class());
                 preparedStatement.setInt(3, student.getYear_receipt());

                 return  preparedStatement.executeUpdate();
             }
         }
     } catch(Exception ex) { System.out.println(ex); }

        return 0;
    }

    public static int update(Student student)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)){
                String sql = "UPDATE student.students SET first_second_name = ? , id_class  = ?, year_receipt = ?  WHERE id_student = ?" ;

                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, student.getFirst_second_name());
                    preparedStatement.setInt(2, student.getId_class());
                    preparedStatement.setInt(3, student.getYear_receipt());
                    preparedStatement.setInt(4, student.getId_student());

                    return  preparedStatement.executeUpdate();
                }
            }
        }catch(Exception ex) { System.out.println(ex); }

        return 0;
    }

    public static Student selectOne(int id)
    {
        Student student = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)){
                String sql = "SELECT * FROM student.students WHERE id_student=?";//поиск студента по его id

                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();

                    while(resultSet.next()){
                        int id_student = resultSet.getInt(1);
                        String first_second_name = resultSet.getString(2);
                        int id_class = resultSet.getInt(3);
                        int year_receipt = resultSet.getInt(4);
                        student = new Student(id_student,first_second_name,id_class,year_receipt);
                    }
                }
            }
        }catch(Exception ex) { System.out.println(ex); }

        return student;
    }
}
