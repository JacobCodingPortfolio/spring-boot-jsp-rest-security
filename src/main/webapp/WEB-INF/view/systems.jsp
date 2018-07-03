<html>
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

   <!-- Spring security tags -->
   <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

   <head>
   </head>
   <body>
        <h1>Hello w leaders JSP!</h1>
        <h1>Secret systems information!</h1>
        <a href="${pageContext.request.contextPath}/">Back to home page</a>
   </body>
</html>