package Course;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Student.Student;
import dbutil.DBUtil;
@WebServlet("/courevise")
public class reviseServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public reviseServlet() {
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
		String sql= "select * from course where id = '"+ id+"'";
		    ResultSet  result =DBUtil.query(sql); 
				       try {
						while(result.next()){
						   String name=result.getString("name");
						   String introduce=result.getString("introduce");
						   String hour=result.getString("courese_hour");
						   String credit=result.getString("credit");
						   String semester=result.getString("semester");
						  
						   course cour=new course(id,name,introduce,hour,credit,semester);
						   request.setAttribute("cour",cour);
						   request.getRequestDispatcher("couRevise.jsp").forward(request,response);
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
		String introduce=request.getParameter("introduce");
		String hour=request.getParameter("hour");
		String credit=request.getParameter("credit");
		String semester=request.getParameter("semester");
		String sql= "update course set introduce='"+ introduce+"',courese_hour='"+ hour+"',credit='"+ credit+"',semester='"+ semester+"' where id = '"+ id+"'";
		int re=DBUtil.update(sql);
	
			if(re==1){
		response.sendRedirect("course");
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
