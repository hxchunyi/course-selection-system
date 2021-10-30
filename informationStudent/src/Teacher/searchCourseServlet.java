package Teacher;

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

import Course.course;
import dbutil.DBUtil;
@WebServlet("/teacherSearchCourse")
public class searchCourseServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public searchCourseServlet() {
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
              String tid =(String)request.getSession().getAttribute("cname");
              ArrayList<course> LisL = new ArrayList<course>();
      	    String sql= "select course.*,teacher.grade from course,teacher where  teacher.cid=course.id and teacher.tid = '"+tid+"'";
      	    ResultSet  result =DBUtil.query(sql); 
      			       try {
      					while(result.next()){
      					   String id=result.getString("course.id");
      					   String name=result.getString("course.name");
      					   String introduce=result.getString("teacher.grade");
      					   String hour=result.getString("course.courese_hour");
      					   String credit=result.getString("course.credit");
      					   String semester=result.getString("course.semester");
      					   course cour=new course(id,name,introduce,hour,credit,semester);
      						  LisL.add(cour);
      						   }
      					} catch (SQLException e) {
      						// TODO Auto-generated catch block
      						e.printStackTrace();
      					}
      						  DBUtil.close();
      						request.setAttribute("LisL", LisL);
      						
   					     request.getRequestDispatcher("teacherSearchCourse.jsp").forward(request,response);

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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
