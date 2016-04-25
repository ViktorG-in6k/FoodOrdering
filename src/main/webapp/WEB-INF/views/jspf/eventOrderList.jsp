<div ng-controller="orderList">
    <div>
        <h3 class="text-center">Your order</h3>
        <table class="table">
            <tr>
                <th>Restaurant</th>
                <th>Name</th>
                <th>Amount</th>
                <th>Price</th>
                <th></th>
            </tr>
            <tr ng-repeat="item in myOrders.myOrderList | orderBy:'restaurant.name'">
                <td>{{item.restaurant.name}}</td>
                <td>{{item.item.name}}</td>
                <td>
                    <div>
                        <a style="margin-right: 5px;" href=""><i  style="color:green" ng-click="removeOneItemFromOrder(eventId,item.item.id)" class="fa fa-minus" aria-hidden="true"></i></a>
                    <span style="">{{item.count}}</span>
                    <a href="" ng-click="addToOrder(eventId,item.item.id)" style="margin-left: 5px;">
                        <i  style="color:green"  class="fa fa-plus" aria-hidden="true"></i></a>
                </div>
                </td>

                <td>{{item.count * item.item.price|currency:"&#8372"}}</td>

                <td><a href="" ng-click="removeFromOrder(eventId,item.item.id)"><i style="color:red"   class="fa fa-times" aria-hidden="true"></i></a></td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td>Total</td>

                <td>{{getTotal() |currency:"&#8372"}}</td>

            </tr>
        </table>
    </div>
</div>