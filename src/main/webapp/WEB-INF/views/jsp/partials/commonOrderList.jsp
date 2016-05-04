<div style=" margin-top: 30px;">
    <div>
        <div class="well pull-left event-well" >
            <div class="col-md-6" style="font-size: 25px;">
                {{event.name}}
            </div>
            <div class="col-md-offset-10 event-date" >
                <div class="col-md-offset-4">
                    <i class="glyphicon glyphicon-calendar" aria-hidden="true"></i>
                    {{event.date.dayOfMonth}} {{event.date.month | limitTo: 3}}
                    {{event.date.hour}}:{{event.date.minute}}
                </div>
            </div>
            <br/>
            <div class="row"></div>
            <div class="col-md-6 event" style="font-size: 15px;" >Created by {{event.user.email}}</div>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
    <div class="col-md-12"><p class="text-center">Order list</p></div>
        <div class="col-sm-12">{{restaurant.name}}  phone:{{restaurant.phone}}</div>
    </div>
    <div>
        <div>
     <%--       <ul class="nav nav-tabs nav-justified" style="margin-top: 10px">
                <li role="presentation" ng-class="myItems" ng-click="myItems = 'active'; allItems = ''" ><a >My items</a></li>
                <li role="presentation" ng-class="allItems" ng-click="allItems = 'active'; myItems = ''"><a >All items</a></li>
            </ul>--%>
            <table class="table">
                <tr>
                    <th>Name</th>
                    <th>Amount</th>
                    <th>Price</th>
                    <th></th>
                </tr>
                <tr ng-repeat="item in myOrders.myOrderList | orderBy:'restaurant.name'">
                    <td>{{item.item.name}}</td>
                    <td>
                        <div>
                            <a style="margin-right: 5px;" href=""><i style="color:green"
                                                                     ng-click="removeOneItemFromOrder(eventId,item.item.id)"
                                                                     class="fa fa-minus" aria-hidden="true"></i></a>
                            <span style="">{{item.count}}</span>
                            <a href="" ng-click="addToOrder(eventId, item.item.id)" style="margin-left: 5px;">
                                <i style="color:green" class="fa fa-plus" aria-hidden="true"></i></a>
                        </div>
                    </td>
                    <td>{{item.count * item.item.price|currency:"&#8372"}}</td>
                    <td><a href="" ng-click="removeFromOrder(eventId,item.item.id)"><i style="color:red"
                                                                                       class="fa fa-times"
                                                                                       aria-hidden="true"></i></a></td>
                </tr>
                <tr>
                    <td>Total</td>
                    <td></td>
                    <td>{{getTotal() |currency:"&#8372"}}</td>
                </tr>
            </table>
        </div>
</div>
</div>
