import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet(urlPatterns = "/create")
public class CreateServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        try{
            String first_second_name = request.getParameter("first_second_name");
            int id_class = Integer.parseInt(request.getParameter("id_class"));
            int year_receipt = Integer.parseInt(request.getParameter("year_receipt"));
            Student student = new Student(first_second_name, id_class, year_receipt);
            StudentDB.insert(student);
            response.sendRedirect("/start");//переадресация на выполнение сервлета IndexServlet по URL localhost:8080/start для вывода обновленного списка

        }catch (Exception ex){
            getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);//при ошибке заполнения возвращается форма для заполнения
            }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
    }
}
