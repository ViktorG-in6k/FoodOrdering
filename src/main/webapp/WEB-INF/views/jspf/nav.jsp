<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-default top-banner-title-font">
    <div class="container-fluid">

        <div class="navbar-header">
            <a class="navbar-brand" href="#">Food ordering</a>
        </div>


        <form role="form">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a class="navbar-brand" href="/sing_out">
                        <c:if test="${not empty userMail}">
                            Hello  ${userMail}
                        </c:if>
                    </a>
                    <label class="navbar-brand">
                        <c:if test="${empty userMail}">
                            Welcome!
                        </c:if>
                    </label>
                </li>
            </ul>
        </form>

    </div>
</nav>