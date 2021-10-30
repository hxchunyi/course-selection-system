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
import javax.servlet.http.HttpSession;

import Acount.acount;
import Student.Student;
import dbutil.DBUtil;
@WebServlet("/stuManage")
public class studentManageServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public studentManageServlet() {
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
		 String cname =request.getParameter("coursename");
              String cid =request.getParameter("cid");
               String sql ="select student.id,student.name,score from sc,student where sc.sid=student.id and sc.cid ='"+cid+"'";
            ResultSet rs= DBUtil.query(sql);
            ArrayList<acount> LisL = new ArrayList<acount>();
            try {
				while(rs.next()){
					String	studentId=rs.getString("student.id");
				String	studentName=rs.getString("student.name");
				String	score=rs.getString("score");
				String	t="";
				String s="";
				acount ac=new acount(studentId,studentName,score,t,s);
				LisL.add(ac);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            HttpSession session=request.getSession();
  		  session.setAttribute("courseName", cname);
            request.setAttribute("cid", cid);
		request.setAttribute("LisL", LisL);
	request.getRequestDispatcher("stuAddScore.jsp").forward(request, response);
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

        String cid =request.getParameter("cid");
        String sql ="select student.id,student.name,score from sc,student where sc.sid=student.id and sc.cid ='"+cid+"'";
     ResultSet rs= DBUtil.query(sql);
     ArrayList<acount> LisL = new ArrayList<acount>();
     try {
			while(rs.next()){
				String	studentId=rs.getString("student.id");
			String	studentName=rs.getString("student.name");
			String	score=rs.getString("score");
			String	t="";
			String s="";
			acount ac=new acount(studentId,studentName,score,t,s);
			LisL.add(ac);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     request.setAttribute("cid", cid);
	request.setAttribute("LisL", LisL);
request.getRequestDispatcher("stuAddScore.jsp").forward(request, response);
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
