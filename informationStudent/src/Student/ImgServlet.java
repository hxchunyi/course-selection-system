package Student;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/img")
public class ImgServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ImgServlet() {
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
		BufferedImage image = new BufferedImage(100, 35, BufferedImage.TYPE_INT_RGB);
		// �õ�ͼƬ
		Graphics g = image.getGraphics();
		g.setColor(new Color(200,200,200));
		g.fillRect(0,0,100,35);
		Random rd  = new Random();
		int randNum = rd.nextInt(8999)+1000;
		String randStr = String.valueOf(randNum);
		HttpSession session = request.getSession();
		session.setAttribute("randStr",randStr);
		g.setColor(Color.black);
		g.setFont(new Font("΢���ź�",Font.PLAIN,32));
		g.drawString(randStr,10,30);
		for(int i = 0; i < 100; i++)
		{
			int x = rd.nextInt(100);
			int y = rd.nextInt(35);
			g.drawOval(x,y, 1,1);
		}
		
		ImageIO.write(image,"JPEG",response.getOutputStream());	
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

	String code=request.getParameter("code");
	HttpSession session = request.getSession();
	String or_code=(String)session.getAttribute("randStr");
	if(code.equals(or_code)){
		response.getWriter().print(true);
	}
	else{
		response.getWriter().print(false);
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
