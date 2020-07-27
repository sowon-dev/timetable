<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.util.ArrayList"%>
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
<h2>timetable</h2>
<table border="1">
<%
  request.setCharacterEncoding("UTF-8");
  tableDAO tdao = new tableDAO(); 
  ArrayList tblist = tdao.getData();
  for(int i=0;i<tblist.size(); i++){
	  Tablebean tb = (Tablebean) tblist.get(i);
%>
	<tr>
    <th></th>
		<th><%=tb.getMon_dd()%>  <%=tb.getWeekday()%></th>
	</tr>
	<tr>
		<th>오전</th>
	    <td><%=tb.getSubam()%></td>
	</tr>
	<tr>
		<th>오후</th>
	    <td><%=tb.getSubpm()%></td>
	</tr>
<%
}
%>
</table>
</body>
</html>