
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:forEach items="${Menu}" var="menu">

    <div class="well col-md-9 pull-left">
        <form >

                <img src="${menu.getImageURL()}" class="img-thumbnail pull-left" width="200" height="100">
                <div class="text-info "><h2> ${menu.getName()}</h2></div>


                <div class="col-md-7 text-left">
                        ${menu.getDescription()}
                </div>

        </form>
    </div>
</c:forEach>
