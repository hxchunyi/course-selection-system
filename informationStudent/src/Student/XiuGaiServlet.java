package Student;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dbutil.DBUtil;
@WebServlet("/xiugai")
@MultipartConfig
public class XiuGaiServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public XiuGaiServlet() {
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
		
		String avatarSrc=request.getParameter("avatar");
		
		String sql= "select * from student where id = '"+ id+"'";
		ResultSet result=DBUtil.query(sql);
	     try {
			if(result.next()){
			String name=result.getString("name");
			String sex=result.getString("sex");
			String birthday=result.getString("birthday");
			String nat=result.getString("native");
		   String  pss=result.getString("politic_status");
		   String avatar=result.getString("avatar");
		   DBUtil.close(); 
		   Student st=new Student(id,name,sex,birthday,nat,pss,avatar);
		   request.setAttribute("st", st);
		   request.setAttribute("avatarSrc", avatarSrc);
		   request.getRequestDispatcher("stuEdit.jsp").forward(request, response);
			}
			 else{
		  println("1");
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			 
	      
	}

	private void println(String string) {
		// TODO Auto-generated method stub
		
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
	    String imgName = request.getParameter("imgName");
	    String avaSrc =imgName;
	    Part file =request.getPart("file");
	    if(file!=null){
	    	 String servletPath =request.getServletContext().getRealPath("static/images/");
			  String avatarName = file.getHeader("content-disposition").split("\"")[3];
			  file.write(servletPath+avatarName);
			avaSrc ="static/images/"+avatarName;
	    }
	
		    String id = request.getParameter("id");
		    String name=request.getParameter("username");
			String sex=request.getParameter("sex");
			String birthday=request.getParameter("birthday");
			String nat=request.getParameter("native");
			String pss=request.getParameter("ps");
			String sql= "update student set name='"+ name+"',sex='"+ sex+"',birthday='"+ birthday+"',native='"+ nat+"',politic_status='"+pss+"' ,avatar='"+avaSrc+"' where id = '"+ id+"'";
			int re=DBUtil.update(sql);
				if(re==1){
			response.sendRedirect("student");
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
