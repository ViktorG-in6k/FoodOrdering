<nav class="navbar navbar-default navbar-fixed-top" ng-controller="navbarCtrl">
    <div class="container-fluid">
        <div class="navbar-header">
            <div class="navbar-brand">Food ordering</div>
        </div>
        <div class="navbar-header">
            <a class="navbar-brand" href="/events">Events</a>
        </div>
        <div ng-controller="eventController" ng-if="eventId" class="navbar-header navbar-brand">
            /&nbsp &nbsp{{event.name}}
        </div>
        <div class="navbar-header pull-right" style=" right: 10px;">
            <label class="navbar-brand">
                Welcome!
            </label>
        </div>
    </div>
</nav>

