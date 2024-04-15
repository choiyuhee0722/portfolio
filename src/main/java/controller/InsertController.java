package controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.UserService;
import vo.UserVO;



public class InsertController implements Controller{
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println(req.getMethod());
		
		if(req.getMethod().equals("POST")) {
			return  processInsertService(req, resp);
		}else if (req.getMethod().equals("GET")) {
			
			return "insert";
		}
		return "redirect::/";
	}
	
	private String processInsertService(HttpServletRequest req, HttpServletResponse resp) {
		String user_id = req.getParameter("user_id");
		String user_password = req.getParameter("user_password");
		String user_name = req.getParameter("user_name");
		String user_major = req.getParameter("user_major");
		
		
		UserVO user = new UserVO();
		user.setUser_id(user_id);
		user.setUser_password(user_password);
		user.setUser_name(user_name);
		user.setUser_major(user_major);
		
		
		
		UserService service = new UserService();
		int n = 0;
		try {
			service.userInsert(user);
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return "redirect::/list";
	
		
	}
	private String processInsertView(HttpServletRequest req, HttpServletResponse resp){
		
		
		return "insert";
	}
}
