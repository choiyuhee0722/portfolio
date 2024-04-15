<%@page import="dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="master/header.jsp"/>
<%
	UserDao dao = new UserDao();
	int geul_num = dao.getMaxGeul_num();
%>

<section>
<div class="container">
	<p class="title">게시물 등록</p>
	<form action="/geulinsert" method="post" name="frm">
			<table width="600px">
			<tr>
					<td>글번호(자동생성)</td>
					<td><input type = "text"  name="geul_num" id="geul_num" value="<%= geul_num %>" readonly="readonly"></td>
				</tr>
				<tr>
					<td>아이디</td>
					<td><input type = "text"  name="geul_id" id="geul_id" ></td>
				</tr>
				
				<tr>
					<td>제목</td>
					<td><input type="text" id="geul_content" name="geul_content"></td>
				</tr>
				
				<tr>
					<td>내용</td>
					<td><input type="text" id="geul_post" name="geul_post"></td>
				</tr>
				
				<tr>
					<td>등록날짜</td>
					<td><input type="text" id="start_date" name="start_date"></td>
				</tr>
				
    				<td colspan="2" align="center">
    				<input type="submit" value="등록하기" onclick="return checkForm()">
    				<input type="reset" value="취소" onclick="return checkForm()">
    				</td>
    			</tr>
			</table>	
	</form>
</div>
</section>


<script>
	function checkForm() {
		if(document.frm.geul_id.value.trim() == ""){
			alert('아이디가 입력되지 않았습니다!');
			document.frm.geul_id.focus();
			retuen false;
		}
		if(document.frm.geul_post.value.trim() == ""){
			alert('내용이 입력되지 않았습니다!');
			document.frm.geul_post.focus();
			retuen false;
		}
		if(document.frm.geul_content.value.trim() == ""){
			alert('내용이 입력되지 않았습니다!');
			document.frm.geul_content.focus();
			retuen false;
		}
		if(document.frm.start_date.value == 0){
			alert('등록날짜가 입력되지 않았습니다!');
			document.frm.start_date.focus();
			retuen false;
		}
		document.frm.submit();
		}
</script>
<jsp:include page ="master/footer.jsp"/>