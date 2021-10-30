package Course;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dbutil.DBUtil;
@WebServlet("/couadd")
public class addServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public addServlet() {
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
		request.getRequestDispatcher("add.jsp").forward(request, response);
		
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
		  String id= request.getParameter("id");
		  String name= request.getParameter("coursename");
		   String introduce= request.getParameter("introduce");
		  String hour= request.getParameter("hour");
		  String credit= request.getParameter("credit");
		  String semester= request.getParameter("semester");
		    if(id!=null && name!=null && introduce!=null && hour!=null && credit!=null){ 
		    	String sql="insert into course values ('"+ id +"','"+ name+"','"+introduce +"','"+ hour+"','"+credit+"','"+semester+"')";
		    	int re=DBUtil.update(sql);
					if(re==1){
					response.sendRedirect("course");
					}else{
						response.sendRedirect("add.jsp");	
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
