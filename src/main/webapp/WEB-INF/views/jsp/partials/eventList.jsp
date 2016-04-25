<div class="col-md-9 " ng-controller="eventController">
    <div>

        <div ng-repeat="event in events | orderBy:['date.year','date.month','date.dayOfMonth']">
            <%--<div class="col-sm-5 col-md-5 col-lg-4" style="margin-bottom: 30px">--%>
            <%--<div class="post">--%>
            <%--<div class="post-img-content"--%>
            <%--style="height: 215px; width: 315px; background-image: url('http://cdn.fabulousblogging.com/wp-content/uploads/2012/10/fabric_plaid2.jpg?bcbabf')">--%>
            <%--<img class="pull-left col-md-12" src=""/>--%>

            <%--<form class="post-title" role="form" action="/addResponsibleUser" method="post" >--%>
            <%--<a href="/events/event_{{event.id}}#/{{event.id}}">--%>
            <%--<b style="text-decoration: underline; background-color: rgba(0, 0, 0, 0.58);" class="text-info col-md-6">{{event.name}}</b>--%>

            <%--</a>--%>

            <%--<b style="background-color: rgba(0, 0, 0, 0.58);"><i class="glyphicon glyphicon-calendar" aria-hidden="true"></i> {{event.date.dayOfWeek |--%>
            <%--limitTo: 3}} {{event.date.dayOfMonth}} {{event.date.month | limitTo: 3}}--%>
            <%--{{event.date.year}} </b>--%>

            <%--<br>--%>
            <%--<b style="background-color: rgba(0, 0, 0, 0.58);"><i class="glyphicon glyphicon-time" aria-hidden="true"></i>--%>
            <%--{{event.date.hour}}:{{event.date.minute}}</b><br/>--%>
            <%--<div ng-if="event.user == null">--%>
            <%--<b style="background-color: rgba(0, 0, 0, 0.58);"><input type="hidden" value="{{event.id}}" name="eventId">--%>
            <%--<button type="submit" class="btn btn-success pull-right">Take responsibility--%>
            <%--</button>--%>
            <%--</b>--%>

            <%--</div>--%>

            <%--<div ng-if="event.user != null">--%>
            <%--<b style="background-color: rgba(0, 0, 0, 0.58);"> {{event.user.email}}--%>
            <%--<a href="#/commonOrder/{{event.id}}">--%>
            <%--<button ng-if=" event.user.email == event.sessionUser.email" type="button" class="btn btn-success ">Order</button>--%>
            <%--</a>--%>
            <%--</b>--%>
            <%--</div>--%>
            <%--</form>--%>
            <%--</div>--%>
            <%--</div>--%>
            <%--</div>--%>
            <div class="well col-md-11 pull-left">

                <form action="">

                    <img src="{{event.imageURL}}" class="img-thumbnail col-md-3 pull-left">

                    <label class="text-info col-md-7"
                           style="font-size: 19px; color: #000000;">
                        <a href="/events/event_{{event.id}}#/{{event.id}}">{{event.name}}</a></label>

                    <label class="pull-right">
                        time
                        {{event.date.dayOfWeek |
                        limitTo: 3}} {{event.date.dayOfMonth}} {{event.date.month | limitTo: 3}}
                        {{event.date.hour}}:{{event.date.minute}}

                    </label>
                    <div class="col-md-9 ">

                        {{event.description}}

                    </div>
                    <div class="col-md-12">
                        <a class="btn btn-primary col-md-offset-6 col-md-3"
                           href="">Check to see</a>

                        <div ng-if="event.user == null" class="col-md-offset-1 col-md-2">
                            <input type="hidden" value="{{event.id}}"  name="eventId">
                            <button type="submit" class="btn btn-success pull-right">Take responsibility
                            </button>

                        </div>

                        <div ng-if="event.user != null" class="col-md-offset-1 col-md-2">
                            {{event.user.email}}
                            <a href="#/commonOrder/{{event.id}}">
                                <button ng-if=" event.user.email == event.sessionUser.email" type="button"
                                        class="btn btn-success ">Order
                                </button>
                            </a>

                        </div>
                    </div>

                </form>
            </div>
        </div>
    </div>
</div>