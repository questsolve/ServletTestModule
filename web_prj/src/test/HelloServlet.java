package test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.corba.se.spi.protocol.ForwardException;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

/**
 * Servlet implementation class HelloServlet
 */

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("kid");
		String kpw = request.getParameter("kpw");
		System.out.println(id+" , "+kpw);
		
		System.out.println("GETURL");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		HttpSession session = request.getSession(true);
//		session.setAttribute("Hello", "java");
//		
//		Cookie cookie = new Cookie("coo", "kie");
//		response.addCookie(cookie);
		
		
		String kid = request.getParameter("kid");
		String kpw = request.getParameter("kpw");
		String kgen= request.getParameter("kgen");
		String[] khiabit=request.getParameterValues("khiabit");
		
		String kvirus= request.getParameter("kvirus");
		File file = new File(request.getParameter("kfile"));
		String filename = request.getParameter("kfile");
		String ktel= request.getParameter("ktel");
		String kintro=request.getParameter("kintro");
		
		/*
		for (int i = 0; i < khiabit.length; i++) {
			System.out.println(khiabit[i]);
		}
		*/
		System.out.println(kid +" : "+kpw);
		System.out.println(kgen);
		
		System.out.println(kvirus);
		System.out.println(ktel);
		System.out.println(kintro);
		System.out.println(file.getAbsolutePath());
		System.out.println(filename);
		
		String name = "홍길동";
		String grade = "a";
		ArrayList<String> list = new ArrayList<String>();
		list.add("홍길동0");
		list.add("홍길동1");
		list.add("홍길동2");
		list.add("홍길동3");
		list.add("홍길동4");
		list.add("홍길동5");
		
		
		request.setAttribute("klist", list);
		request.setAttribute("kname", name);
		request.setAttribute("kugd", grade);
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendRedirect(request.getContextPath()+"/user_main.jsp?kname="+name+"&kugd="+grade);
		
//		RequestDispatcher rd =request.getRequestDispatcher("user_main2.jsp");
//		rd.forward(request, response);
//		
		
	}

}
