package controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.UserService;
import vo.GeulVO;
import vo.UserVO;

public class GeulInsertController implements Controller{
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println(req.getMethod());
		
		if(req.getMethod().equals("POST")) {
			return  processInsertService(req, resp);
		}else if (req.getMethod().equals("GET")) {
			
			return "geulinsert";
		}
		return "redirect::/";
	}
	
	private String processInsertService(HttpServletRequest req, HttpServletResponse resp) {
		String geul_id  = req.getParameter("geul_id");
		String geul_content  = req.getParameter("geul_content");
		String geul_post  = req.getParameter("geul_post");
		String start_date  = req.getParameter("start_date");
		
		
		GeulVO geul = new GeulVO();
		geul.setGeul_id(geul_id);
		geul.setGeul_content(geul_content);
		geul.setGeul_post(geul_post);
		geul.setStart_date(start_date);
		
		
		
		UserService service = new UserService();
		int n = 0;
		try {
			service.geulInsert(geul);
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return "redirect::/list";
	
		
	}
	private String processInsertView(HttpServletRequest req, HttpServletResponse resp){
		
		UserService service = new UserService();
		int geul_num = service.getMaxGeul_num();
		req.setAttribute("geul_num", geul_num);
		return "geulinsert";
	}
}
