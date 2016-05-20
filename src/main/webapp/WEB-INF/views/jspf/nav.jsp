<nav class="navbar navbar-default  navbar-fixed-top" ng-controller="navbarCtrl">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Food Ordering</a>
        </div>

        <div class="" id="myNavbar">
            <div class="navbar-header">
                <a class="navbar-brand" href="/app">Events</a>
            </div>
            <div  ng-controller="eventController" ng-if="eventId">
                <a  class=" navbar-brand" href="app#/events/{{event.id}}">
                    /   &nbsp &nbsp{{eventName}}
                </a>
            </div>
            <ul class="nav navbar-nav navbar-right">
                <li> <label class="current-user"> {{user.data.name}} {{' '+user.data.familyName}} ({{user.data.email}})</label></li>
                <li><a href="/logout"><label> logout</label></a></li>
            </ul>
        </div>

    </div>
</nav>
