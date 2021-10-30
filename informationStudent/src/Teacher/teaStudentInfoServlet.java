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

import Student.Student;
import dbutil.DBUtil;
@WebServlet("/teaStudentServlet")
public class teaStudentInfoServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public teaStudentInfoServlet() {
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
		//得到tid
		String tid =(String)request.getSession().getAttribute("cname");
		
		//组合查询
		String seaId =request.getParameter("seaId");
		String seaName =request.getParameter("seaName");
		String seaCourse =request.getParameter("seaCourse");
		
		
		String _sql="";
//		System.out.print(_sql+"+++++++++++++++++++++++++++++++++++");
		System.out.println(seaId==null);
		if(seaId != null&&seaId!=""){
			_sql += "and student.id like '"+seaId+"'";
		};
		if(seaName != null&&seaName!=""){
			_sql += "and student.name like '%"+seaName+"%'";
		};
//		System.out.println(seaId);
//		System.out.println(seaName);
//		System.out.println(seaNat);
       if(seaCourse != null&&seaCourse!=""){
			_sql += "and course.name like '"+seaCourse+"'";
		};
		//查询有多少条数据
				String sqlSum= "select count(course.name) as idCount from teacher,course,sc,student where teacher.cid=course.id and course.id=sc.cid and sc.sid =student.id and teacher.tid ='"+tid+"'  "+_sql+"  ";
				int totalCount=0;
				ResultSet  rs=DBUtil.query(sqlSum);
					try {
						while(rs.next()){
							totalCount=rs.getInt("idCount");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		//当前页码
		Integer pageNo=0;
		String  pageNu =request.getParameter("pageNo");
		if(pageNu==null){
			 pageNo=1;
		}else{
			 pageNo =Integer.parseInt(pageNu);
		}
		
		int pageSize =12;

	//总页数
		Integer totalPage=totalCount/pageSize;
	if(totalCount%pageSize!=0 || totalPage==0){
		totalPage=totalPage+1;
	}
	//下一页
	Integer nextPage =0;
	if(nextPage<totalPage){
		nextPage=pageNo+1;
	}else{
		nextPage=pageNo;
	}
	//上一页
	Integer prePage =0;
	if(pageNo>1){
		prePage=pageNo-1;
	}else{
		prePage=pageNo;
	}
	//判断收尾页
	boolean isFirstPage =false;
	if(pageNo>1){
		isFirstPage =false;
	}else{
		isFirstPage =true;
	}
	boolean isLastPage =false;
	if(pageNo<totalPage){
		isLastPage =false;
	}else{
		isLastPage =true;
	}
		//
		
		String sql=" select student.*,course.name from teacher,course,sc,student where teacher.cid=course.id and course.id=sc.cid and sc.sid =student.id and teacher.tid ='"+tid+"' "+_sql+" limit "+(pageNo-1)*pageSize+","+pageSize+"";
		ResultSet result =DBUtil.query(sql);
		ArrayList<Student> LisL = new ArrayList<Student>();
		try {
			while(result.next()){
				  String id=result.getString("student.id");
				   String name=result.getString("student.name");
				   String sex=result.getString("student.sex");
				   String birthday=result.getString("student.birthday");
				   String nat=result.getString("student.native");
				   String ps=result.getString("student.politic_status");
				   String avatar=result.getString("course.name");
				   Student st=new Student(id,name,sex,birthday,nat,ps,avatar);
				  LisL.add(st);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  DBUtil.close();
		  request.setAttribute("totalCount", totalCount); 
		  request.setAttribute("pageNo", pageNo); 
		  request.setAttribute("pageSize", pageSize); 
		  request.setAttribute("totalPage", totalPage); 
		  request.setAttribute("nextPage", nextPage); 
		  request.setAttribute("prePage", prePage); 
		  
		  request.setAttribute("isFirstPage", isFirstPage); 
		  request.setAttribute("isLastPage", isLastPage); 
		  //回写查询数据
		  request.setAttribute("seaName", seaName); 
		  request.setAttribute("seaCourse", seaCourse);
		  
		  
       request.setAttribute("LisL", LisL);   
	     request.getRequestDispatcher("teacherManageStu.jsp").forward(request,response);	
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
