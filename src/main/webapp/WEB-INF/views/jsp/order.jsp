<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Maven + Spring MVC + @JavaConfig</title>

    <spring:url value="/resources/core/css/hello.css" var="coreCss"/>
    <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss"/>

    <link href="${bootstrapCss}" rel="stylesheet"/>
    <link href="${coreCss}" rel="stylesheet"/>
</head>

<jsp:include page="/WEB-INF/views/jspf/nav.jsp" flush="true"/>

<div class="container">
    ${orderList.size()}
    <%--<jsp:include page="/WEB-INF/views/jspf/orderList.jsp" flush="true" />--%>
    <div class="well col-md-9 pull-left">

        <table class="table">
            <thead>
            <tr>
                <th>Item Name</th>
                <th>Price</th>
                <th>Count</th>
                <th>Cost</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${orderList}" var="check">

                <tr>
                    <td>${check.getItem.getName()}</td>
                    <td>${check.getItem.getPrice()}</td>
                    <td>${check.getCount()}</td>
                    <td>${check.getCost()}</td>
                </tr>

            </c:forEach>
            </tbody>

        </table>
    </div>


</div>

<spring:url value="/resources/core/js/bootstrap.js" var="coreJs"/>
<spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapJs"/>
<spring:url value="/resources/core/js/bootstrap.min.js" var="jQuery"/>

<script src="${jQuery}"></script>
<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>

</html>