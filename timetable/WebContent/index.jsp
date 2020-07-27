<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="timetable.Tablebean"%>
<%@page import="timetable.db.tableDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>7강의실 시간표</title>
</head>
<body>
<%
  request.setCharacterEncoding("UTF-8");
  tableDAO tdao = new tableDAO(); 
  Tablebean tb = tdao.getData();
//  if( tb != null){
%>
<h2>timetable</h2>
<table border="1">
	<tr>
    <td></td>
		<td><%=tb.getMon_dd()%>  <%=tb.getWeekday()%></td>
	</tr>
	<tr>
		<td>오전</td>
	    <td><%=tb.getSubam()%></td>
	</tr>
	<tr>
		<td>오후</td>
	    <td><%=tb.getSubpm()%></td>
	</tr>
</table>
<%
//}
%>
</body>
</html>