
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>

<html>

    <head>
        <meta charset="UTF-8">

        <style>

            .failed {
                color: red;
            }

        </style>

    </head>

    <body>
        <form:form action="${pageContext.request.contextPath}/authenticateTheUser"
        method="POST"> <!-- Post do ścieżki którą mamy w config
         robimy to w taglib form, ponieważ wtedy mamy support dla Spring Defenses
         aby logi form dla Spring działał musimy wrzucić standardowe nazwy
         -username
         -password
         -->

         <!--  Sprawdzamy czy jest parametr error -->
         <c:if test="${param.error != null}">
            <i class="failed">
                Password or username is invalid.
            </i>
            <br>
         </c:if>

            Login: <input type="text" name="username" />
            <br>
            Password: <input type="password" name="password" />
            <br>
            <input type="submit" value="Login" />


        </form:form>
    </body>

</html>