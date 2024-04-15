package controller;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.UserService;
import vo.GeulVO;

public class ListController implements Controller{
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServerException, IOException {
		UserService service = new UserService();
		ArrayList<GeulVO> list = service.List();
		System.out.println("리스트 컨트롤러에서 리스트값 : " + list);
		
		req.setAttribute("list", list);
		
		return "list";
	}
}
