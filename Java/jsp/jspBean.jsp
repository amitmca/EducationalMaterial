<% @page language="java" import="java.sql.*" %>

<jsp:useBean id="sample" class="myexample.bean" scope="page">
	<jsp:setProperty name="sample" property="*" />
</jsp:useBean>

<% sample.select() %>