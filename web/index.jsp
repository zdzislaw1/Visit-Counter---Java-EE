<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Licznik odwiedzin</title>
</head>
<body>
<h1>Licznik odwiedzin</h1>

<p>Ilosc odwiedzin w tej sesji
  <%=
request.getAttribute("VisitOneSession")
%>
</p>
<p>Ilosc odwiedzin w calej aplikacji <%=
application.getAttribute("VisitGlobal")
%>
</p>


</body>
</html>