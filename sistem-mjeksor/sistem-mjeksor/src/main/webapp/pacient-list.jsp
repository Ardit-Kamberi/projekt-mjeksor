
<%@ page import="java.util.*, com.medicalsystem.model.Pacient" %>
<html>
<body>
<h3>Lista e Pacientëve</h3>
<ul>
<%
List<Pacient> list = (List<Pacient>) request.getAttribute("pacientet");
if (list != null) {
  for (Pacient p : list) {
%>
  <li><%= p.getEmri() %> <%= p.getMbiemri() %> - <%= p.getMosha() %></li>
<%
  }
}
%>
</ul>
<a href="index.jsp">Kthehu</a>
</body>
</html>
