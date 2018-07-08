<html>
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

   <!-- Spring security tags -->
   <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

   <head>
   </head>
   <body>
        <h1>Nie masz dostepu do danej strony...</h1>
        <a href="${pageContext.request.contextPath}/">Back to home page</a>
   </body>
</html>