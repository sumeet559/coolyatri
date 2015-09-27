

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class message extends HttpServlet 
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
            HttpSession session=request.getSession();
            try 
            {
                  ps=con.prepareStatement("select * from coordinates where lat=19 and lon=74");
                 ResultSet rs= ps.executeQuery();
                 System.out.println("inserted");
                 List<String> emailList=new ArrayList<String>();
                 
                 while(rs.next())
                 {
                	 String s3=rs.getString(1);
                	 emailList.add(s3);
                 }
                 for (String string : emailList) {
					System.out.println(string);
				}
            }
            catch (SQLException e) 
                  {
                  e.printStackTrace();
                  }
      }
}
