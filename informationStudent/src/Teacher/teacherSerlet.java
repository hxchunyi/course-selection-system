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
@WebServlet("/teacher")
public class teacherSerlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public teacherSerlet() {
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
		//组合查询
		String seaName =request.getParameter("seaName");
		String seaGrade =request.getParameter("seaGrade");
		String seaCname =request.getParameter("seaCname");
		
		
		String _sql="";
//		System.out.print(_sql+"+++++++++++++++++++++++++++++++++++");
		System.out.println(seaName==null);
		if(seaName != null&&seaName!=""){
			_sql += "and teacher.tname like '"+seaName+"'";
		};
		if(seaGrade != null&&seaGrade!=""){
			_sql += "and teacher.grade like '%"+seaGrade+"%'";
		};

       if(seaCname != null&&seaCname!=""){
			_sql += "and course.name like '"+seaCname+"'";
		};
		//查询有多少条数据
		String sqlSum= "select count(*) as idCount  from teacher,course where teacher.cid=course.id  "+_sql+" ";
		int totalCount=0;
		ResultSet  rss=DBUtil.query(sqlSum);
		
			try {
				while(rss.next()){
					totalCount=rss.getInt("idCount");
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
	       String sql= "select teacher.*,course.name,course.id  from teacher,course where teacher.cid=course.id  "+_sql+" limit "+(pageNo-1)*pageSize+","+pageSize+"";
           ResultSet rs=DBUtil.query(sql);
           ArrayList<course> LisL = new ArrayList<course>();
           try {
				while(rs.next()){
					String tid=rs.getString("teacher.tid");
					String tname=rs.getString("teacher.tname");
					String grade=rs.getString("teacher.grade");
					String courseName=rs.getString("course.name");
					String a=rs.getString("course.id");
					String b="";
					course cou = new course(tid,tname,grade,courseName,a,b);
					LisL.add(cou);
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
           request.setAttribute("LisL", LisL);   
		     request.getRequestDispatcher("courseManage.jsp").forward(request,response);
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
