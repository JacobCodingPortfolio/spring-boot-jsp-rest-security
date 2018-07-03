<html>
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

   <!-- Spring security tags -->
   <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

   <head>
   </head>
   <body>
       <h1>Hello World!</h1>

       <h2>Uzytkownik zalogowany:</h2>
       Username: <sec:authentication property="principal.username" /><br>
       Roles: <sec:authentication property="principal.authorities" /><br>


        <hr>
        <!-- Add link to leaders -->
            <a href="${pageContext.request.contextPath}/leaders">Leader Ship Meeting</a>
            (Only for manager)
        <hr>
        <!-- Add link to admins -->
            <a href="${pageContext.request.contextPath}/systems">Admin control</a>
            (Only for Admins)
        <hr>
        <br>
       <!-- Add a logout button -->
       <form:form action="${pageContext.request.contextPath}/logout"
                            method="POST">
           <input type="submit" value="Logout" />
       </form:form>
   </body>
</html>