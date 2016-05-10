<nav class="navbar navbar-default navbar-fixed-top" ng-controller="navbarCtrl">
    <div class="container-fluid">
        <div class="navbar-header">
            <div class="navbar-brand">Food Ordering</div>
        </div>
        <div class="navbar-header">
            <a class="navbar-brand" href="/events">Events</a>
        </div>
        <div  ng-controller="eventController" ng-if="eventId">
            <a  class=" navbar-brand" href="/events/event_{{event.id}}#/{{event.id}}">
             /   &nbsp &nbsp{{event.name}}
            </a>
        </div>
        <div ng-controller="eventController" ng-if="currentRestaurant" >
            <a  class=" navbar-brand" href="{{'#/'+ eventId}}/{{restaurant.id}}">
            /   &nbsp &nbsp{{restaurant.name}}
            </a>
        </div>
        <div class="navbar-header pull-right" style=" right: 10px;">
            <label class="navbar-brand">
                Welcome!
            </label>
            <label class="navbar-brand">
            <a href="/logout">logout</a>
            </label>

        </div>
    </div>
</nav>

