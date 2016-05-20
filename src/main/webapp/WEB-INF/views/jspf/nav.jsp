<nav class="navbar navbar-default  navbar-fixed-top" ng-controller="navbarCtrl">
    <div class="container-fluid">
            <a class="navbar-brand" href="#">Food Ordering</a>

            <div class="navbar-header">
                <a class="navbar-brand" href="/app">Events</a>
            </div>
            <div  ng-controller="eventController" ng-if="eventId">
                <ol class="breadcrumb pull-left">
                    <li><a  href="#">Home</a></li>
                    <li><a  href="#">Library</a></li>
                    <li  class="active">Data</li>
                </ol>
            </div>

            <ul class="nav navbar-nav navbar-right hidden-xs">
                <li> <label class="current-user"> {{user.data.name}} {{' '+user.data.familyName}} ({{user.data.email}})</label></li>
                <li><a href="/logout"><label> logout</label></a></li>
            </ul>
        </div>

</nav>
