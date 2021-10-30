package Student;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dbutil.DBUtil;
@MultipartConfig
@WebServlet("/tianjia")
public class TianjiaServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public TianjiaServlet() {
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

request.getRequestDispatcher("WEB-INF/tianjia.jsp").forward(request, response);
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
		  String name= request.getParameter("username");
		   String sex= request.getParameter("sex");
		  String birthday= request.getParameter("birthday");
		  String nat= request.getParameter("native");
		  String ps= request.getParameter("ps");
		  String avatar= request.getParameter("avatar");
		  Part file =request.getPart("file");
		  String servletPath =request.getServletContext().getRealPath("static/images/");
		  String avatarName = file.getHeader("content-disposition").split("\"")[3];
		  file.write(servletPath+avatarName);
		  
		    if(id!=null && name!=null && birthday!=null && nat!=null && ps!=null){ 
		    	String sql="insert into student values ('"+ id +"','"+ name+"','"+sex +"','"+ birthday+"','"+nat+"','"+ps+"','static/images/"+avatarName+"')";
		    	int re=DBUtil.update(sql);
					if(re==1){
					response.sendRedirect("student");
					}
					
		    }
		    else{
				response.sendRedirect("stuAdd.jsp");
			}  
	}

	private void printl(String string) {
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
