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
            <a class="navbar-brand" href="/app">Events</a>
        </div>
        <div  ng-controller="eventController" ng-if="eventId">
            <a  class=" navbar-brand" href="app#/events/{{event.id}}">
             /   &nbsp &nbsp{{eventName}}
            </a>
        </div>
     <%--   <div ng-controller="eventController" ng-if="currentRestaurant" >
            <a  class=" navbar-brand" href="{{'#/'+ eventId}}/{{restaurant.id}}">
            /   &nbsp &nbsp{{restaurantName}}
            </a>
        </div>--%>
        <div class="navbar-header pull-right" style=" right: 10px;">
            <label class="navbar-brand" style="font-size: 14px;">

            </label>
            <label class="myNavbar" style="font-size: 14px;">
                {{user.data.name}} {{' '+user.data.familyName}} ({{user.data.email}})
            <a href="/logout"> logout</a>
            </label>

        </div>
    </div>
</nav>

