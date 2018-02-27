<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${empty login}">
|<a href="login.jsp">Login</a>|
|<a href="newAccount.jsp">Register</a>|

</c:if>
<c:if test="${not empty login}">
|<a href="ServletLab?action=logout">Logout</a>|
|<a href="ServletLab?action=list">List Accounts</a>|

</c:if>



|<a href="ServletLab?action=about">About</a>|
<hr/>