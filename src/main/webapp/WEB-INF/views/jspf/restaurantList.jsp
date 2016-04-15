<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<spring:url value="/resources/core/css/hello.css" var="coreCss"/>
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss"/>

<div class="col-md-9 pull-left">
    <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">

        <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="headingOne">
                <h4 class="panel-title">
                    <div data-toggle="collapse" data-parent="#accordion" href="#1" aria-expanded="true"
                         aria-controls="collapseOne">
                        <div class="panel-body">
                            <a role="button">
                                <img src="http://america.pink/images/2/8/0/6/7/7/3/en/2-macdonald.jpg" width="120px"
                                     height="120px;" style="float: left">
                                <h1 style="padding-top: 20px;padding-left: 140px;">Yoishi</h1>
                            </a>
                        </div>
                    </div>
                </h4>
            </div>
            <div id="1" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
                <div class="panel-body">
                    <div class="well hvr-float-shadow">
                        <a href="#">
                        <div class="row">
                            <div class="col-lg-9"><h2>Sushi</h2>
                                <p>Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson
                                    ad squid. 3 wolf </p>
                            </div>
                            <div class="col-lg-2"><h3>$ 33</h3></div>
                            <div class="col-lg-1">
                                <h3><i class="fa fa-plus"></i></h3>
                            </div>
                        </div>
                        </a>
                    </div>
                    <div class="well hvr-float-shadow">
                        <a href="#">
                        <div class="row">
                            <div class="col-lg-9"><h2>Sushi</h2>
                                <p>Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson
                                    ad squid. 3 wolf </p>
                            </div>
                            <div class="col-lg-2"><h3>$ 33</h3></div>
                            <div class="col-lg-1">
                                <h3><i class="fa fa-plus"></i></h3>
                            </div>
                        </div>
                        </a>
                    </div>
                    <div class="well hvr-float-shadow">
                        <a href="#">
                        <div class="row">
                            <div class="col-lg-9"><h2>Sushi</h2>
                                <p>Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson
                                    ad squid. 3 wolf </p>
                            </div>
                            <div class="col-lg-2"><h3>$ 33</h3></div>
                            <div class="col-lg-1">
                                <h3><i class="fa fa-plus"></i></h3>
                            </div>
                        </div>
                        </a>
                    </div>
                </div>
            </div>
        </div>


        <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="headingTwo">
                <h4 class="panel-title">
                    <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion"
                       href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                        Collapsible Group Item #2
                    </a>
                </h4>
            </div>
            <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                <div class="panel-body">
                    Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3
                    wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum
                    eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla
                    assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt
                    sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer
                    farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus
                    labore sustainable VHS.
                </div>
            </div>
        </div>

    </div>
</div>


<%--<form action="/events/${restaurant.getId()}">
    <img src="${restaurant.getImageURL()}" class="img-thumbnail pull-left" width="200" height="100">
    <label class="text-info col-md-7"
           style="font-size: 19px; color: #000000;">${restaurant.getName()}</label>

    <div class="col-md-7 text-left">
        ${restaurant.getDescription()}
    </div>
    <a class="btn col-md-offset-10 btn-primary pull-right" style=" background-image: linear-gradient(to bottom,#28B7FF,#3573D0)" href="/events/event_${eventId}/restaurant_${restaurant.getId()}">Go to item</a>
</form>--%>



