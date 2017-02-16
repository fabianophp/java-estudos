<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/jsp/header.jsp" %>

    <c:if test="${empty sessionScope.login}" > 
        <form method="POST" action="<%=request.getContextPath()%>/Controller?command=LoginServlet" onsubmit="return validate();">
            <label>Login</label><br>
            <input type="text" name="login" class="form-control"  required placeholder="Preencha este campo."><br>
            <label>Password</label><br>
            <input type="password" name="senha" class="form-control"  required placeholder="Preencha este campo."><br>
            <input type="submit" class="btn btn-primary" value="Login">
        </form>
    </c:if>  



</div><!-- /.container -->
<%@include file="/WEB-INF/jsp/footer.jsp" %>