<%@page import="vo.GeulVO"%>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="master/header.jsp"/>

<section>
	<div class="container">
		<p class="title">게시물 목록</p>
		
<%
		

			ArrayList<GeulVO> list = (ArrayList<GeulVO>)request.getAttribute("list");
		System.out.println("list :  "+list);
			if(!list.isEmpty()){
		%>		
		<table>
			<tr>
				<td>글번호</td>
				<td>아이디</td>
				<td>제목</td>
				<td>입력날짜</td>
				<td>수정날짜</td>
				<td>삭제</td>
			</tr>
<%

		for(GeulVO geul : list){
		request.setAttribute("geul", geul);
%>			
				<tr>
						<td><a href="/update?geul_num=${geul.geul_num}">${geul.geul_num}</a></td>
						<td>${geul.geul_id}</td>
						<td>${geul.geul_content}</td>
						<td>${geul.start_date}</td>
						<td>${geul.modify_date}</td>
						<td><a href="/delete?geul_num=${geul.geul_num}">삭제</a></td>
				</tr>
<% 					
		}
%>	
		</table>
<%
	}else{
%>		
	<p style="text-align: center">등록된 참가자 정보가 없습니다.</p>
<% 	
	}
%>		

	</div>
</section>

<jsp:include page="master/footer.jsp"/>
