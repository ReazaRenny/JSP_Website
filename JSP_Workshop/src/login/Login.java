package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;


/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		try {
			Class.forName("org.mariadb.jdbc.Driver"); // Load the driver
			Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/travelexperts", "root", ""); // log in to connection with path, username and password
			PreparedStatement stmt = conn.prepareStatement("select password from Customers where userid=?");
			HttpSession session2 = request.getSession(true);
			String id = request.getParameter( "userid" );
			session2.setAttribute( "id", id );
			stmt.setString(1, id);
			
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) // 
			{
				if(rs.getString(1).equals(request.getParameter("password")))
				{
					
					response.sendRedirect("listPackages.jsp");
					
				}
				else 
				{
					conn.close();
					HttpSession session = request.getSession();
					session.setAttribute("message", "error error error");
					response.sendRedirect("loginform.jsp");
				}
			}
			else 
			{
				conn.close();
				HttpSession session = request.getSession();
				session.setAttribute("message", "error error error");
				response.sendRedirect("loginform.jsp");
			}
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			out.println("Class Not Found");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.print("SQL Exception");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
