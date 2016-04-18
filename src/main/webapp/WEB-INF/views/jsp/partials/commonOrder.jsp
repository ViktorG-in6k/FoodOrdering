<div ng-controller="commonOrderCtrl" class="container">
    <div class="row">
        <div class="col-md-7">

            <div>
                <h3>Common order</h3>
                <table class="table">
                    <tr>
                        <th>Restaurant</th>
                        <th>Name</th>
                        <th>Amount</th>
                        <th>Price</th>
                        <th></th>
                    </tr>
                    <tr ng-repeat="item in eventOrderList.myOrderList | orderBy:'restaurant.name'">
                        <td>{{item.restaurant.name}}</td>
                        <td>{{item.item.name}}</td>
                        <td><div>
                            <a href=""><i class="fa fa-minus" aria-hidden="true"></i></a>
                            <span style="padding-left: 5px;padding-right: 5px;width: 20px">{{item.count}}</span>
                            <a href="" ng-click="addToOrder(eventId,item.item.id)" style="margin-left: 5px;"><i class="fa fa-plus" aria-hidden="true"></i></a>
                        </div>
                        </td>

                        <td>{{item.count * item.item.price|currency}}</td>

                        <td><i class="fa fa-times" aria-hidden="true"></i></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td>Total</td>
                        <td>{{getTotal() | currency}}</td>

                    </tr>
                </table>
            </div>
        </div>
    </div>

</div>