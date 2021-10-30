package Acount;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Course.course;
import dbutil.DBUtil;
@WebServlet("/acountEdit")
public class acountEditServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public acountEditServlet() {
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

		String id=request.getParameter("id");
		String sql= "select * from acount where id = '"+ id+"'";
		    ResultSet  result =DBUtil.query(sql); 
				       try {
						while(result.next()){
						   String username=result.getString("username");
						   String password=result.getString("password");
						   String admin=result.getString("admin");
						   String tel=result.getString("tel");  
						   acount acount=new acount(id,username,password,admin,tel);
						   request.setAttribute("acount",acount);
						   request.getRequestDispatcher("acountEdit.jsp").forward(request,response);
						   DBUtil.close(); 
							   }	    
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
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
	    String id=request.getParameter("id");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String admin=request.getParameter("admin");
		String tel=request.getParameter("tel");
		String sql= "update acount set username='"+ username+"',password='"+ password+"',admin='"+ admin+"',tel='"+ tel+"' where id = '"+ id+"'";
		int re=DBUtil.update(sql);
			if(re==1){
		response.sendRedirect("acount");
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
