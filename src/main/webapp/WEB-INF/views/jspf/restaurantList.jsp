<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<spring:url value="/resources/core/css/hello.css" var="coreCss"/>
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss"/>
<div style=" margin-top: 30px;">
    <jsp:include page="/WEB-INF/views/jspf/eventDetails.jsp"/>
</div>
<div class="col-md-offset-1 col-sm-offset-1 col-md-8 col-sm-8">
    <div class="panel-group col-md-offset-1 col-sm-offset-1 col-md-11 col-sm-11" id="accordion" role="tablist" aria-multiselectable="true">
        <div ng-repeat="restaurant in restaurants" class="panel panel-default"   style="  margin-top: 15px;">
            <div style="height: 120px;background-color: white; border: 1px solid #BBB4B4;background-color: #F5F5F5">

                <div class=" col-md-4">
                        <h3>
                            <a href="/restaurant_{{restaurant.id}}" style="font-size: 25px;">
                            {{restaurant.name}}
                            </a>
                        </h3>
                </div>

                <div class="col-md-offset-4 col-md-4">
                    <h2 style="font-size: 15px;"  class="col-md-offset-4">
                        Participants:
                    </h2>
                </div>

                <br/>
                <div class="row"></div>


                <div ng-if="restaurant.link" class="col-md-4">
                    <a href="{{restaurant.link}}" target="_blank" style="font-size: 13px;">
                        Web-site
                    </a>
                </div>
                <br/>
                <div ng-if="restaurant.phone" class="col-md-4 pull-left" style="font-size: 13px;">
                    Phone: {{restaurant.phone}}
                </div>
            </div>

        </div>
    </div>
</div>

