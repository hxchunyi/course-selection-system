package servlet;

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
import javax.servlet.http.HttpSession;

import utils.score;
import Student.Student;
import dbutil.DBUtil;
@WebServlet("/searchScore")
public class searchScoreServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public searchScoreServlet() {
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
        response.sendRedirect("searchScore.jsp");
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
		 request.setCharacterEncoding("UTF-8");
		//×éºÏ²éÑ¯
		String seaName =request.getParameter("seaName");
		String seaSemester =request.getParameter("seaSemester");
		
		
		String _sql="";
//		System.out.print(_sql+"+++++++++++++++++++++++++++++++++++");
		if(seaName != null&&seaName!=""){
			_sql += "and course.name like '%"+seaName+"%'";
		};
		if(seaSemester != null&&seaSemester!=""){
			
			_sql += "and course.semester = '"+seaSemester+"'";
		};
//		System.out.println(seaId);

    

        ArrayList<score> Info = new ArrayList<score>();
String sid = (String)request.getSession().getAttribute("cname");
//System.out.print("+++++++++++"+_sql+"+++++++++++");
String sql ="select course.name,sc.score,course.semester from course,sc where course.id=sc.cid and sc.sid ='"+sid+"'  "+_sql+"";
ResultSet result=DBUtil.query(sql);
try {
	while(result.next()){
		String id ="0";
		String cname = result.getString("course.name");
		String cscore = result.getString("sc.score");
		String csemester = result.getString("course.semester");
		score sc=new score(id,cname,cscore,csemester);
		Info.add(sc);
		
	}
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
request.setAttribute("Info", Info);
request.getRequestDispatcher("searchScore.jsp").forward(request,response);	
DBUtil.close();

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
