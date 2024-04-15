package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.UserService;

public class DeleteController implements Controller{
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int geul_num = Integer.parseInt(req.getParameter("geul_num"));
		
		System.out.println(geul_num);
		UserService service = new UserService();
		int n = service.geulDelete(geul_num);
		System.out.println("n : "+n);
		return "redirect::/list";
	}
}
