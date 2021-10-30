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

import dbutil.DBUtil;
@WebServlet("/courseOfTeacher")
public class courseOfTeacherServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public courseOfTeacherServlet() {
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
		 request.setCharacterEncoding("UTF-8");
              String sql = "select  * from course";
              ResultSet result = DBUtil.query(sql);
              ArrayList<course> LisL = new ArrayList<course>();
              try {
				while(result.next()){
					String id=result.getString("id");
					   String name=result.getString("name");
					   String introduce=result.getString("introduce");
					   String hour=result.getString("courese_hour");
					   String credit=result.getString("credit");
					   String semester=result.getString("semester");
					   course cour=new course(id,name,introduce,hour,credit,semester);
					   LisL.add(cour);
				  }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
              request.setAttribute("LisL", LisL);   
			     request.getRequestDispatcher("courseOfTeacher.jsp").forward(request,response);
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
		
		//
		
        String sql1 = "select  * from course";
        ResultSet result = DBUtil.query(sql1);
        ArrayList<course> LisL = new ArrayList<course>();
        try {
			while(result.next()){
				String id=result.getString("id");
				   String name=result.getString("name");
				   String introduce=result.getString("introduce");
				   String hour=result.getString("courese_hour");
				   String credit=result.getString("credit");
				   String semester=result.getString("semester");
				   course cour=new course(id,name,introduce,hour,credit,semester);
				   LisL.add(cour);
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        request.setAttribute("LisL", LisL); 
		//
                   String tid = request.getParameter("tid");
                   String tname = request.getParameter("tname");
                   String cid = request.getParameter("cid");
                   String grade = request.getParameter("grade");
                   String flag="ok";
                   String sql="insert into teacher values ('"+tid+"','"+cid+"','"+grade+"','"+tname+"') ";
                   int i=DBUtil.update(sql);
                   if(i==1){
                	   request.setAttribute("flag", flag);
                	   request.getRequestDispatcher("courseOfTeacher.jsp").forward(request, response);
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
