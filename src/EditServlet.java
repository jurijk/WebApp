import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/edit")
public class EditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //после редактирования карточки студента обновляем информацию в БД
        try {
            int id_student = Integer.parseInt(request.getParameter("id_student"));
            String first_second_name = request.getParameter("first_second_name");
            int id_class = Integer.parseInt(request.getParameter("id_class"));
            int year_receipt = Integer.parseInt(request.getParameter("year_receipt"));
            Student student = new Student(id_student, first_second_name, id_class, year_receipt);

            StudentDB.update(student);
            response.sendRedirect("/start");//переадресация на выполнение сервлета IndexServlet по URL
                                                // localhost:8080/start для вывода обновленного списка

        }catch(Exception ex) { getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response); }
    }

        //вызов метода doGet осуществляется с помощью передачи параметра id  в строке
        // HTTP запроса -> localhost:8080/edit?id=5 ->  (поиск студента в БД с id=5)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            System.out.println("Мы в методе doGet");
            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println("Параметр id = " + id);
            Student student = StudentDB.selectOne(id);
            System.out.println("Из БД полученна карточка с id = " + id);
            if(student!=null) {
                request.setAttribute("student", student);
                getServletContext().getRequestDispatcher("/edit.jsp").forward(request, response);
            }
            else {
                getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
            }
        }
        catch(Exception ex) { getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response); }
    }
}
