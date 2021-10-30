package Student;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.management.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.soap.AddressingFeature.Responses;

import com.mysql.fabric.Response;
import com.mysql.jdbc.StringUtils;

import dbutil.DBUtil;
@WebServlet("/student")
public class StudentServlet extends HttpServlet {
	/**
	 * Constructor of the object.
	 */
	public StudentServlet() {
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
		String seaId =request.getParameter("seaId");
		String seaName =request.getParameter("seaName");
		String seaNat =request.getParameter("seaNat");
		
		
		String _sql="";
//		System.out.print(_sql+"+++++++++++++++++++++++++++++++++++");
		System.out.println(seaId==null);
		if(seaId != null&&seaId!=""){
			_sql += "and id like '"+seaId+"'";
		};
		if(seaName != null&&seaName!=""){
			_sql += "and name like '%"+seaName+"%'";
		};
//		System.out.println(seaId);
//		System.out.println(seaName);
//		System.out.println(seaNat);
       if(seaNat != null&&seaNat!=""){
			_sql += "and politic_status like '"+seaNat+"'";
		};
		
		System.out.print(_sql);
		//查询有多少条数据
		String sqlSum= "select count(*) as idCount from student where 1=1 "+_sql+"  ";
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
			
			int pageSize =8;
	
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
		
		
		    ArrayList<Student> LisL = new ArrayList<Student>();
		    String sql= "select * from student where 1=1 "+_sql+" limit "+(pageNo-1)*pageSize+","+pageSize+"";
		    ResultSet  result =DBUtil.query(sql); 
				       try {
						while(result.next()){
						   String id=result.getString("id");
						   String name=result.getString("name");
						   String sex=result.getString("sex");
						   String birthday=result.getString("birthday");
						   String nat=result.getString("native");
						   String ps=result.getString("politic_status");
						   String avatar=result.getString("avatar");
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
						  
				       request.setAttribute("LisL", LisL);   
					     request.getRequestDispatcher("studentAll.jsp").forward(request,response);	
                     }

		    
	

	private Integer getIntParameter(HttpServletRequest request, String string) {
		// TODO Auto-generated method stub
		return null;
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
