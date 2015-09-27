

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class Reg extends HttpServlet 
{
      Connection con;
      PreparedStatement ps;
      ResultSet rs;
      public void init(ServletConfig config)throws ServletException
      { 
            try 
               {
                        Class.forName("com.mysql.jdbc.Driver");
                        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234"); 
               } 
                  catch (ClassNotFoundException e)
                     {
                        System.out.println(e);
                     } 
                  catch (SQLException e) 
                     {
                        System.out.println(e);
                     }
      }
      protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
      {
            doPost(request, response);
      }
      protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
      {
            response.setContentType("text/html");
            PrintWriter pw=response.getWriter();
            String username=request.getParameter("Name");
            String EmailId=request.getParameter("Email-Id");
            String password=request.getParameter("password");
            
            HttpSession session=request.getSession();
            session.setAttribute("user", username);
            session.setAttribute("email", EmailId);
            
            pw.println("<html><body>");
            try 
            {
                  ps=con.prepareStatement("insert into traveller values(?,?,?)");
                  ps.setString(1, username);
                  ps.setString(2, EmailId);
                  ps.setString(3, password);
                  ps.executeUpdate();
                  
                System.out.println("inserted");
                RequestDispatcher rq=request.getRequestDispatcher("/welcome.jsp");
                rq.forward(request, response);
            }
            catch (SQLException e) 
                  {
                  e.printStackTrace();
                  }
      }
} 
