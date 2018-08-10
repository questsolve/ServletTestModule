package com.kosmo.member.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Action;

import com.kosmo.member.MemberVO;
import com.kosmo.member.service.MemberService;
import com.kosmo.member.service.impl.MemberServiceImpl;

import oracle.net.aso.s;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MemberService memberService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberServlet() {

		super();
		System.out.println(this.getClass().getSimpleName()+" generated");

	}



	@Override

	public void init() throws ServletException {

		memberService = new MemberServiceImpl();

		super.init();
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String info = request.getParameter("info");

		if(info.equals("join")) {
			insert(request, response);
		}else if(info.equals("login")) {
			login(request,response);
		}else if(info.equals("view")) {
			showUpdateView(request, response);
		}else if(info.equals("update")) {
			updateUserInfo(request, response);
		}else if(info.equals("delete")) {
			delete(request,response);
		}


	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		System.out.println(vo.getId());
		vo.setPw(request.getParameter("pw"));
		System.out.println(vo.getPw());
		vo.setName(request.getParameter("name"));
		System.out.println(vo.getName());

		if(!(request.getParameter("regdate")==null || request.getParameter("regdate").equals(""))) {
			String[] temp = request.getParameter("regdate").split("/");
			StringBuffer sb = new StringBuffer();
			sb.append(temp[2]).append("/").append(temp[0]).append("/").append(temp[1]);
			vo.setRegdate(sb.toString());
		}else {
			vo.setRegdate(null);
		}

		int result =memberService.insertMember(vo);

		response.sendRedirect(request.getContextPath()+"/memberview/welcome.jsp?count="+result);

	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPw(pw);
		vo = memberService.login(vo);
		System.out.println(vo);
		if(vo.getName()!=null) {
			if(vo.getRoll().equals("u")) {

				session.setAttribute("SK_vo", vo);
				
				response.sendRedirect(request.getContextPath()+"/memberview/user_main.jsp?flag=log");
			}else if(vo.getRoll().equals("a")) {
				session.setAttribute("SK_vo", vo);
				List<MemberVO> list = memberService.listMember();
				request.setAttribute("userList", list);
				request.setAttribute("flag", "admin");
				request.getRequestDispatcher(request.getContextPath()+"/memberview/admin_main.jsp").forward(request, response);
				//response.sendRedirect(request.getContextPath()+"/memberview/admin_main.jsp");

			}
		}else {
			response.sendRedirect(request.getContextPath()+"/memberview/error.jsp");
		}

	}

	public void showUpdateView(HttpServletRequest request,HttpServletResponse response) {
		try {
			HttpSession session = request.getSession(true);
			MemberVO vo = (MemberVO)session.getAttribute("SK_vo");
			vo = memberService.select(vo.getMemberSeq());
			request.setAttribute("updateUser", vo);
			request.getRequestDispatcher(request.getContextPath()+"/memberview/member_update.jsp").forward(request, response);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}

	}

	public void updateUserInfo(HttpServletRequest request,HttpServletResponse response) {

		try {
			HttpSession session = request.getSession(true);

			String pw = request.getParameter("pw");
			System.out.println(pw);
			
			String name = request.getParameter("name");
			System.out.println(name);
			MemberVO vo = (MemberVO)session.getAttribute("SK_vo"); 

			vo.setPw(pw);
			vo.setName(name);
			int result = memberService.update(vo);
			System.out.println(result);
			request.setAttribute("vo", vo);
			request.setAttribute("flag", "update");
			request.getRequestDispatcher(request.getContextPath()+"/memberview/user_main.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void delete(HttpServletRequest request,HttpServletResponse response) {
		
	}
	
	public void logout(HttpServletRequest request,HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			session.invalidate();
			session.setMaxInactiveInterval(0);
			response.sendRedirect("/memberview/member_login.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
