<div ng-controller="commonOrderCtrl" class="container">
    <a href="#/commonOrderByUsers/{{id}}">
        <button type="button" class="btn btn-success col-md-offset-7">Sort by user</button>
    </a>
    <div class="row">
        <div class="col-md-9">
            <div>
                <h3>Common order</h3>
                <table class="table">
                    <tr>
                        <th>Restaurant</th>
                        <th>Name</th>
                        <th>Amount</th>
                        <th>Price</th>
                        <th>Ordered</th>
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
