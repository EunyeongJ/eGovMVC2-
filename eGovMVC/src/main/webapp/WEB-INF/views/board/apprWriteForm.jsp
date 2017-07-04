<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 양식 작성 </title>
</head>
<body>

<table>
	
	<table border="1">
		<tr>	
			<th>내역</th>
			<th>상세내역</th>
			<th>지출구분</th>
			<th>지출일</th>
			<th>지출내용</th>
			<th>지출금액</th>
		</tr>
		
		<tr>
			<!-- 대분류 -->
			<td>				
				<select id="group_cd">
					<c:foreach var="groupCode" items="${groupCode}" varStatus="status">
						<option value="${groupCode[status.index].cd}"> ${groupCode[status.index].cdnm} </option>
					</c:foreach>				
				</select>
			</td>
			
			<!-- 중분류 -->
			<td>				
				<select id="cd">
					<c:foreach var="changeGroupCode" items="${changeGroupCode}" varStatus="status">
					
						<!-- null이 아니면 대분류에서 선택했다. -->
						<c:if test="${changeGroupCode != null}">
							<option value="${changeGroupCode[status.index].cd}"> ${changeGroupCode[status.index].cdnm} </option>
						</c:if>
						
						<!-- null이면 대분류에서 선택한 것이 없다. -->
						<c:if test="${changeGroupCode == null}">
							<option value=""> 중분류 </option>
						</c:if>
						
					</c:foreach>				
				</select>
			</td>
			
			<!-- 지출구분 -->
			<td>
				
			</td>
				
			<!-- 지출일 -->
			<td>
				<input type="text" id="sp_date">
			</td>
				
			<!-- 지출내용 -->
			<td>
				<input type="text" id="sp_cont">
			</td>
			
			<!-- 지출금액 -->
			<td>
				<input type="text" id="sp_pay">
			</td>
		</tr>
		
		
	</table>
	
</table>

</body>
</html>