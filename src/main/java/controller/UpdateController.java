package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.UserService;
import vo.GeulVO;



public class UpdateController implements Controller{
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp){
		System.out.println("req.getMethod : "+req.getMethod());
		if(req.getMethod().equals("POST")) {
			return processUpdateService(req,resp);
		}else if(req.getMethod().equals("GET")){
			return processInsertView(req,resp);
		}		
		return "redirect::/";
	}
	
	private String processUpdateService(HttpServletRequest req, HttpServletResponse resp) {
		int geul_num = Integer.parseInt(req.getParameter("geul_num"));
		String geul_id = req.getParameter("geul_id");
		String geul_content  = req.getParameter("geul_content");
		String start_date  = req.getParameter("start_date");
		String modify_date  = req.getParameter("modify_date ");
		
		GeulVO geul = new GeulVO();
		geul.setGeul_num(geul_num);
		geul.setGeul_id(geul_id);
		geul.setGeul_content(geul_content);
		geul.setStart_date(start_date);
		geul.setModify_date(modify_date);
		
		UserService service = new UserService();
		int  n = 0;	
		try {
			n = service.geulUpdate(geul);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(n>0) {
			return "redirect::list"; 
		}else {
			return "update";
		}
	}
	private String processInsertView(HttpServletRequest req, HttpServletResponse resp) {
		
		Integer geul_num = Integer.parseInt(req.getParameter("geul_num"));
		System.out.println("geul_num"+geul_num);
		UserService service = new UserService();
		GeulVO geul = service.getGeul(geul_num);
		req.setAttribute("geul", geul);
		
		return "update";
}
}
