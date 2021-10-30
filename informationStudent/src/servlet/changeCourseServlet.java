package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.score;
import dbutil.DBUtil;
@WebServlet("/changeCourse")
public class changeCourseServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public changeCourseServlet() {
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
           String sid = (String)request.getSession().getAttribute("cname");
           ArrayList<score> Info = new ArrayList<score>();
           String sql ="select distinct(course.name),teacher.tname,course.credit,sc.cid from course,sc,teacher where course.id=sc.cid and sc.cid=teacher.cid and sc.sid='"+sid+"'";
           ResultSet result=DBUtil.query(sql);
           try {
           	while(result.next()){
           		String id = result.getString("sc.cid");
           		String name = result.getString("course.name");
           		String credit = result.getString("course.credit");
           		String tname = result.getString("teacher.tname");
           		score sc=new score(id,name,tname,credit);
           		Info.add(sc);
           		
           	}
           } catch (SQLException e) {
           	// TODO Auto-generated catch block
           	e.printStackTrace();
           }
           //未选
           ArrayList<score> NoInfo = new ArrayList<score>();
           String sql1 ="select course.id,course.name,course.credit,teacher.tname from course,teacher where course.id=teacher.cid  ";
           ResultSet result1=DBUtil.query(sql1);
           try {
           	while(result1.next()){
           		String id = result1.getString("course.id");
           		String name = result1.getString("course.name");
           		String credit = result1.getString("course.credit");
           		String tname = result1.getString("teacher.tname");
           		score scc=new score(id,name,tname,credit);
           		NoInfo.add(scc);
           		
           	}
           } catch (SQLException e) {
           	// TODO Auto-generated catch block
           	e.printStackTrace();
           }
           //
           request.setAttribute("NoInfo", NoInfo);
           request.setAttribute("Info", Info);
           request.getRequestDispatcher("changeCourse.jsp").forward(request,response);	
           DBUtil.close();
	
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
		
		
		//拿到学生id
		 String sid = (String)request.getSession().getAttribute("cname");
		//删除所有
			String sql1 ="delete * from sc where sid='"+sid+"'";
		 //拿到课程号
          String[] cid =request.getParameterValues("courseId");
          ArrayList<Integer> coureseId =new ArrayList<Integer>();
          for(String string:cid){
        	  coureseId.add(Integer.parseInt(string));
          }
          System.out.print("1111111111111 "+cid[0]);
          //
	for(int i=0;i<coureseId.size();i++){
		String sql = "insert into infor_student.sc  values ('"+sid+"','"+cid[i]+"',null)";
		DBUtil.update(sql);
	}
	response.sendRedirect("changeCourse");
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
