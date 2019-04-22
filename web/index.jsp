<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Visit Counter</title>
</head>
<body>
<h1>Visit Counter</h1>

<p>Visits in your session:
  <%=
request.getAttribute("VisitOneSession")
%>
</p>
<p>Numbers of visits global <%=
application.getAttribute("VisitGlobal")
%>
</p>


</body>
</html>