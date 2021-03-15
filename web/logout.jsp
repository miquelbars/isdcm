<%
session.removeAttribute("user");
session.invalidate(); //destroy session
response.sendRedirect("login.jsp");
%>
