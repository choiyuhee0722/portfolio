<%@page import="vo.GeulVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="master/header.jsp"/>

<section>
<div class="container">
	<p class="title">게시물 수정</p>
	<% GeulVO geul = (GeulVO)request.getAttribute("geul"); %>
	<form action="/update" method="post" name="frm">
			<table width="600px">
				<tr>
					<td>게시물번호</td>
					<td><input type = "number" value="${geul.geul_num}" name="geul_num" id="geul_num" readonly="readonly"></td>
				</tr>
				
				<tr>
					<td>아이디</td>
					<td><input type="text" value="${geul.geul_id}" id="geul_id" name="geul_id" readonly="readonly"></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" value="${geul.geul_content}" id="geul_content" name="geul_content"></td>
				</tr>
				<tr>
					<td>입력날짜</td>
					<td><input type="text" value="${geul.start_date}" id="start_date" name="start_date" readonly="readonly"></td>
				</tr>
				<tr>
					<td>수정날짜</td>
					<td><input type="text" value="${geul.modify_date}" id="modify_date" name="modify_date"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="submit" value="수정" onclick="return checkForm()">
					<input type="button" value="목록" onclick="location.href ='/list'">
				</tr>
				
			</table>	
	</form>
</div>
</section>


<script>
	function checkForm() {
		if(document.frm.geul_num.value.trim() == ""){
			alert('게시물번호가 입력되지 않았습니다!');
			document.frm.geul_num.focus();
			retuen false;
		}
		if(document.frm.geul_id.value.trim() == ""){
			alert('아이디가 입력되지 않았습니다!');
			document.frm.geul_id.focus();
			retuen false;
		}
		if(document.frm.geul_content.value.trim() == ""){
			alert('제목이 입력되지 않았습니다!');
			document.frm.geul_content.focus();
			retuen false;
		}
		if(document.frm.modify_date.value == 0){
			alert('수정시간이 입력되지 않았습니다!');
			document.frm.modify_date.focus();
			retuen false;
		}
		document.frm.submit();
		}
</script>
<jsp:include page ="master/footer.jsp"/>