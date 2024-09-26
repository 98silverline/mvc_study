package com.phone.model.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.phone.model.dto.Member;
import com.phone.model.dto.Phone;
import com.phone.model.service.PhoneService;
import com.phone.model.service.PhoneServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/phone")
public class PhoneController extends HttpServlet {
	private PhoneService service = new PhoneServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		
		try {
			switch (act) {
			case "list": {
				list(request, response);
				break;
			}
			case "detail":{
				detail(request, response);
				break;
			}
			case "mvAdd":{
				System.out.println("추가 화면 이동 요청 수신");
				request.getRequestDispatcher("/add.jsp").forward(request, response);
				break;
			}
			case "add":{
				add(request, response);
				break;
			}
			case "delete":{
				delete(request, response);
				break;
			}
			case "mvUpdate":{
				mvUpdate(request, response);
				break;
			}
			case "update":{
				update(request, response);
				break;
			}
			case "mvLogin":{
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				break;
			}
			case "login":{
//				login(request, response);
				loginCookie(request, response);
				break;
			}
			case "logout":{
				logout(request, response);
				break;
			}
			default : {
				response.getWriter().append("act parameter Error");
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().append("Error");
		}
	}

	private void loginCookie(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		//1. 요청 파라미터 추출 및 가공
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		Member loginInfo = new Member(id, password, null);
		System.out.println("로그인 정보 : "+loginInfo);
		
		//2. DB에서 유저정보 조회
		Member userInfo = service.login(loginInfo);
		System.out.println("유저 조회 정보 : "+userInfo);
		
		if(userInfo==null) {
			response.getWriter().append("failed");
			return;
		}
		//3. 세션에 유저정보 저장
		HttpSession session = request.getSession();
		session.setAttribute("user", userInfo);
		
		/*=======아이디 저장 관련======*/
		String saveid = request.getParameter("saveid");
		System.out.println("아이디 저장여부 정보 :"+saveid);
		
		Cookie cookie = new Cookie("userId", id);
		if(saveid!=null) cookie.setMaxAge(60*60*3);
		else cookie.setMaxAge(0);
		response.addCookie(cookie);
		/*=======아이디 저장 관련======*/
		
		//4. 메인화면 반환
		response.sendRedirect("/simple_phone");
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//1. 세션 삭제
		request.getSession().invalidate();
		
		//2. 메인화면 반환
		System.out.println("request.getContextPath():"+request.getContextPath());
		response.sendRedirect(request.getContextPath());
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		//1. 요청 파라미터 추출 및 가공
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		Member loginInfo = new Member(id, password, null);
		System.out.println("로그인 정보 : "+loginInfo);
		
		//2. DB에서 유저정보 조회
		Member userInfo = service.login(loginInfo);
		System.out.println("유저 조회 정보 : "+userInfo);
		
		if(userInfo==null) {
			response.getWriter().append("failed");
			return;
		}
		//3. 세션에 유저정보 저장
		HttpSession session = request.getSession();
		session.setAttribute("user", userInfo);
		
		//4. 메인화면 반환
		response.sendRedirect("/simple_phone");
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		//1. 요청파라미터 추출 및 가공
		int serialNumber = Integer.parseInt(request.getParameter("serial_number"));
		String model = request.getParameter("model");
		int price= Integer.parseInt(request.getParameter("price"));
		String description = request.getParameter("description");
		Phone phone = new Phone(serialNumber, model, price, description);
		System.out.println("수정할 데이터 : "+phone);
		
		//2. DB에서 수정
		int cnt = service.update(phone);
		System.out.println("수정된 행의 개수:"+cnt);
		
		//3. 상세조회화면 반환
		response.sendRedirect("/simple_phone/phone?act=detail&serial_number="+serialNumber);
	}

	private void mvUpdate(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		//1. 요청 파라미터 추출
		int serialNumber = Integer.parseInt(request.getParameter("serial_number"));
		System.out.println("수정할 시리얼 넘버: "+serialNumber);
		
		//2. DB에서 수정할 정보 조회
		Phone phone = service.getUpdateInfo(serialNumber);
		System.out.println("수정할 휴대폰 정보 :"+phone);
		
		//3. 수정 페이지 반환
		request.setAttribute("phone", phone);
		request.getRequestDispatcher("/update.jsp").forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		//1. 요청 파라미터 추출
		int serialNumber = Integer.parseInt(request.getParameter("serial_number"));
		System.out.println("삭제할 시리얼 넘버:"+serialNumber);
		
		//2. DB에서 삭제
		int cnt = service.deleteBySerialNumber(serialNumber);
		System.out.println("삭제된 행 개수 : "+cnt);
		
		//3. 목록 조회 화면 반환
		response.sendRedirect("/simple_phone/phone?act=list");
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		//1. 요청 파라미터 추출 및 가공
		String model = request.getParameter("model");
		int price= Integer.parseInt(request.getParameter("price"));
		String description = request.getParameter("description");
		Phone phone = new Phone(0, model, price, description);
		System.out.println("추가할 데이터 : "+phone);
		
		//2. DB에 추가
		int cnt = service.add(phone);
		System.out.println("추가된 행 개수:"+cnt);
		
		//3. 전체 조회화면 반환
		response.sendRedirect("/simple_phone/phone?act=list");
	}

	private void detail(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		//1. 요청 파라미터 추출
		int serialNumber = Integer.parseInt(request.getParameter("serial_number"));
		System.out.println("상세조회 SN:"+serialNumber);
		
		//2. 상세 데이터 조회
		Phone phone = service.findBySerialNumber(serialNumber);
		System.out.println("상세조회 데이터 : "+phone);
		
		//3. 상세 페이지 HTML 반환
		request.setAttribute("phone", phone);
		request.getRequestDispatcher("/detail.jsp").forward(request, response);
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		//서비스 메소드 호출
		List<Phone> list = service.selectAll();
		System.out.println("조회한 목록"+list);
		
		//View 반환
		request.setAttribute("list", list);
		request.getRequestDispatcher("/list.jsp").forward(request, response);;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
