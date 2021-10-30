package Student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbutil.DBUtil;
@WebServlet("/denglu")
public class DengluServlet extends HttpServlet {

	private ServletRequest session;

	/**
	 * Constructor of the object.
	 */
	public DengluServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("WEB-INF/denglu.jsp").forward(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    	request.setCharacterEncoding("utf-8");
		    	String id = request.getParameter("idd");
		    	String username = request.getParameter("usern");
		    	String password = request.getParameter("passw");
		    	
		    	String sql= "select * from acount where username='"+ username +"' and password= '"+ password +"' " ;
				ResultSet ss=DBUtil.query(sql);
				try {
				if (ss.next())	{
				  HttpSession session=request.getSession();
				  session.setAttribute("cname", username);
			      response.sendRedirect("student");
				}
				else{
				print("’À∫≈ªÚ√‹¬Î¥ÌŒÛ");
				}
				
			DBUtil.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
		    	
	

	private void setAttribute(String string, String username) {
		// TODO Auto-generated method stub
		
	}

	private void print(String string) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
