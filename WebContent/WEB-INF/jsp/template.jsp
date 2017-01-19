<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/template.css" type="text/css" /> 
    <title><tiles:getAsString name="title"/></title>
  </head>
  <body>
  	<div class="styleTemplate">
			<table>
      	<tr>
        	<td colspan="2">
        		<center>
          		<tiles:insertAttribute name="header" />
          	</center>	
        	</td>
      	</tr>
      	<tr>
        	<td style="height: 100%;width:20%">
          	<tiles:insertAttribute name="menu" />
        	</td>
        	<td>
        		<tiles:insertAttribute name="body" />
        	</td>
      	</tr>
      	<tr>
        	<td colspan="2">
        		<center>
          		<tiles:insertAttribute name="footer" />
          	</center>
        	</td>
      	</tr>
    	</table>
    </div>
  </body>
</html>