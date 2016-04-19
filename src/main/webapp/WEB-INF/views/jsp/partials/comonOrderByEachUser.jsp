<div ng-controller="commonOrderByEachUserCtrl" class="container">
    <div class="row">
        <div class="col-md-7">

            <div>
                <h3>Common order</h3>
                <div ng-repeat="orderList in OrderDTOList">
                <table class="table">
                    <tr>
                        {{orderList.userMail}}
                    </tr>
                    <tr>
                        <th>Restaurant</th>
                        <th>Name</th>
                        <th>Amount</th>
                        <th>Price</th>
                        <th>Ordered</th>

                    </tr>

                    <tr ng-repeat="item in orderList.myOrderList">
                        <td>{{item.restaurant.name}}</td>
                        <td>{{item.item.name}}</td>
                        <td><div>
                            <a href=""><i class="fa fa-minus" aria-hidden="true"></i></a>
                            <span style="padding-left: 5px;padding-right: 5px;width: 20px">{{item.count}}</span>
                            <a href="" ng-click="addToOrder(eventId,item.item.id)" style="margin-left: 5px;"><i class="fa fa-plus" aria-hidden="true"></i></a>
                        </div>
                        </td>

                        <td>{{item.count * item.item.price|currency:"UAH"}}</td>
                        <td><input ng-click="changeOrderItemStatus(id,item.item.id,true)" ng-checked="{{item.ordered != false}}" ng-disabled="{{item.ordered != false}}" type="checkbox"></td>
                    </tr>

                    <tr>
                        <td></td>
                        <td></td>
                        <td>Total</td>
                        <td>{{getTotal() | currency:"UAH"}}</td>
                    </tr>
                </table>
                </div>
            </div>
        </div>
    </div>

</div>