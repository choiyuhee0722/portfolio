package controller;

import java.io.IOException;
import java.io.ObjectInputFilter.Config;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet{
		String charset = null;
		HashMap<String, Controller> list = null;
		
		private final String prefix = "/view/";
		private final String postfix = ".jsp";
		
		@Override
		public void init(ServletConfig config) throws ServletException {
			charset = config.getInitParameter("charset");
			list = new HashMap<String, Controller>(); //list = hashmap 방식 
			list.put("/", new MainController());
			list.put("/insert", new InsertController()); // HashMap<String (key), Controller(values)>
			list.put("/list", new ListController());
			list.put("/update", new UpdateController());
			list.put("/geulinsert", new GeulInsertController());
			list.put("/delete", new DeleteController());
		}
		
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			req.setCharacterEncoding(charset);
			
			String url = req.getRequestURI();// list라면 /list 가져옴
			String contextPath =req.getContextPath(); // contextPath은 공백
			String path = url.substring(contextPath.length()); //substring() = -부터 - 까지 = contextPath부터 url까지 -> /list
			Controller subController = list.get(path); // /list 가지고 listcontroller 실행 5글자
			
			if(subController == null) { //아무것도 없으면 메인화면 
					resp.sendRedirect("/"); //아무것도 가지지 않고 돌아가기
					return;
			}
			
			String result = subController.execute(req,resp); //memberList
			if(result.indexOf("redirect::") != 0) { //redirect라는 글자를 가지고 있는가? 아니면 -1 
				//일반적인 상황
				RequestDispatcher dispatcher = req.getRequestDispatcher(prefix + result + postfix);
				dispatcher.forward(req, resp); //받아서 이동
			}else {
				//리다이렉트 상황  //가지고 있으면
				String reUrl = result.substring("redirect::".length());
				resp.sendRedirect(reUrl); //아무것도 가지지 않고 돌아가기
			}
		}
		
}
