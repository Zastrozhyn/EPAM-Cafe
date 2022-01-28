<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${Locale}"/>
<fmt:setBundle basename="message"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><fmt:message key="Order" /></title>
</head>
<body>
	<c:forEach var="elem" items="${orders}" varStatus="status">
		<c:out value="${status.count}" />
		<c:out value="${elem.name}" />
		<c:out value="${elem.price}" />
		<br>
	<form method="GET" action="<c:url value="/controller"/>">
		 	<input type="hidden" name="command" value="delete_from_order">
		 	<input type="hidden" name="dishId" value="${elem.id}">
		 	<p><input type="submit" value="<fmt:message key="Delete" />" ></p>
		 </form>
	</c:forEach>
	<fmt:message key="Total" /> ${total_cost}
	<br>
	<fmt:message key="Discount" /> ${user.account.status.discount} %
	<form method="GET" action="<c:url value="/controller"/>">
		<input type="hidden" name="command" value="confirm_order">
		<input type="hidden" name="userId" value="${sessionScope.user.login}">
		<br/>
		<br/>
		<fmt:message key="Description" /><input name="description" required>
		<br/>
		<br/>
		<fmt:message key="Payment_type" />
		<br>
		<input type="radio" name="type" value="cash" required> <fmt:message key="Cash" /> <br>  
		<input type="radio" name="type" value="credit_card"> <fmt:message key="Credit_card" /> <br>  
		<input type="radio" name="type" value="account"> <fmt:message key="Account" /> <br> 
		<br/>
		<br/>
		<fmt:message key="Time" /><input name="time" type="time" required>
		<br/>
		<br/>  
		<p><input type="submit"></p>
	</form>
	<a href="${pageContext.request.contextPath}/jsp/mainPage.jsp"><fmt:message key="Main_page" /></a>
	<h3>${message}</h3>
</body>
</html>