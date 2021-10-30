package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspsmart.upload.Request;

import Acount.acount;
import dbutil.DBUtil;
@WebServlet("/login")
public class loginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public loginServlet() {
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
               request.getRequestDispatcher("login.jsp").forward(request, response);

		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here

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
	    
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	String sql= "select * from acount where username='"+ username +"' and password= '"+ password +"' " ;
		ResultSet ss=DBUtil.query(sql);
		try {
		if (ss.next())	{
			String id=ss.getString("id");
			String admin=ss.getString("admin");
			String tel=ss.getString("tel");
			acount acountValue= new acount(id,username,password,admin,tel);
		  HttpSession session=request.getSession();
		  session.setAttribute("acountValue", acountValue);
		  session.setAttribute("admin", admin);
		  session.setAttribute("cname", username);
	      response.sendRedirect("index.jsp");
		}
		
		else{
			String Result ="false";
			response.getWriter().print(Result);
		}
	DBUtil.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}

}
