package Acount;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbutil.DBUtil;
@WebServlet("/acountAdd")
public class acountAddServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public acountAddServlet() {
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
		  String username= request.getParameter("username");
		  String password= request.getParameter("password");
		   String admin= request.getParameter("admin");
		  String tel= request.getParameter("tel");
		    if(username!=null && password!=null && admin!=null && tel!=null){ 
		    	String sql="insert into acount(username,password,admin,tel) values ('"+ username +"','"+ password+"','"+admin +"','"+ tel+"')";
		    	int re=DBUtil.update(sql);
					if(re==1){
					response.sendRedirect("acount");
					}else{
						response.sendRedirect("acountAdd.jsp");	
					}
		    }
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
