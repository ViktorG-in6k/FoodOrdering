<style>
    .myNavbar{
        float: left;
        padding: 15px 15px;
        font-size: 18px;
        line-height: 20px;
        height: 50px;
    }
</style>

<nav class="navbar navbar-default navbar-fixed-top" ng-controller="navbarCtrl">
    <div class="container-fluid">
        <div class="navbar-header">
            <div class="myNavbar">
                Food Ordering</div>
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
            <label class="navbar-brand" style="font-size: 14px;">

            </label>
            <label class="myNavbar" style="font-size: 14px;">
                {{user.data.name}}({{user.data.email}})
            <a href="/logout"> logout</a>
            </label>

        </div>
    </div>
</nav>

