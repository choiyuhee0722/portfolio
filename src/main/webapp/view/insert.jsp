<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="master/header.jsp"/>

<section>
<div class="container">
	<p class="title">회원가입</p>
	<form action="/insert" method="post" name="frm">
			<table width="600px">
				<tr>
					<td>아이디</td>
					<td><input type = "text"  name="user_id" id="user_id" ></td>
				</tr>
				
				<tr>
					<td>비밀번호</td>
					<td><input type="password" id="user_password" name="user_password"></td>
				</tr>
				
				<tr>
					<td>이름</td>
					<td><input type="text" id="user_name" name="user_name"></td>
				</tr>
				
				<tr>
						<td>학과</td>
						<td><select id="user_major" name="user_major ">
								<option value="0">학과선텍</option>
						
								<option value="1">마케팅경영과</option>
			
								<option value="2">베이커리카페과</option>
		
								<option value="3">패션산업디자인과</option>
								
								<option value="4">앱서비스과</option>
							</select>
						</td>				
				</tr>
    				<td colspan="2" align="center">
    				<input type="submit" value="가입하기" onclick="return checkForm()">
    				<input type="reset" value="취소" onclick="return checkForm()">
    				</td>
    			</tr>
			</table>	
	</form>
</div>
</section>


<script>
	function checkForm() {
		if(document.frm.id.value.trim() == ""){
			alert('아이디가 입력되지 않았습니다!');
			document.frm.id.focus();
			retuen false;
		}
		if(document.frm.password.value.trim() == ""){
			alert('비밀번호가 입력되지 않았습니다!');
			document.frm.password.focus();
			retuen false;
		}
		if(document.frm.name.value.trim() == ""){
			alert('성명이 입력되지 않았습니다!');
			document.frm.name.focus();
			retuen false;
		}
		if(document.frm.user_major.value == 0){
			alert('학과가 선택되지 않았습니다!');
			document.frm.user_major.focus();
			retuen false;
		}
		document.frm.submit();
		}
</script>
<jsp:include page ="master/footer.jsp"/>