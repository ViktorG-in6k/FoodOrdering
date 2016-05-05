<style scoped>
    input[type=number]::-webkit-inner-spin-button,
    input[type=number]::-webkit-outer-spin-button {
        -webkit-appearance: none;
        margin: 0;
    }
</style>

<div style=" margin-top: 30px;">
    <div>
        <div class="well pull-left" style="height: 120px; width: 100%">
            <div class="col-md-6" style="font-size: 25px;">
                {{restaurant.name}}<br>

                <a ng-if="restaurant.link" href="{{restaurant.link}}" target="_blank" style="font-size: 13px"><i
                        class="fa fa-link" aria-hidden="true"></i> {{ restaurant.link}}</a>
                <p style="font-size: 13px"><i class="fa fa-phone" aria-hidden="true"></i> {{restaurant.phone}}</p>
            </div>
            <br/>
        </div>
    </div>
</div>

<div class="container">
    <div class="col-md-8 col-sm-8">
        <div class="panel-group col-md-offset-1 col-sm-offset-1 col-md-11 col-sm-11" id="accordion" role="tablist"
             aria-multiselectable="true">
            <table class="table ">
                <thead>
                <tr>
                    <th>name</th>
                    <th>price</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="item in restaurant.itemList | orderBy: 'name'">
                    <td>
                        <div>{{item.name}}</div>
                    </td>
                    <td>
                        <div>{{item.price | currency:"&#8372"}}</div>
                    </td>
                    <td style="width: 25%">

                        <div ng-controller="orderList">
                            <div ng-repeat="itemInOrder in myOrders.orderList" style="display: inline;">
                                <div ng-if="item.id == itemInOrder.item.id" style="display: inline;margin-left: -35px;">
                                    <a href="">
                                        <i style="color:green"
                                           ng-click="removeOneItemFromOrder(eventId, item.id)"
                                           class="fa fa-minus" aria-hidden="true">
                                        </i>
                                    </a>
                                    <span style="">
                                        <input style="width: 40px;margin: 0 8px;height: 24px;" min="1" type="number"
                                               ng-blur="updateNumberItemToOrder( eventId, item.id,itemInOrder.count)"
                                               ng-init="count=itemInOrder.count" ng-model="itemInOrder.count"/>
                                    </span>
                                </div>
                            </div>
                            <div style=" display: inline">
                                <a href="" ng-click="addOneItemToOrder(item.id,eventId)">
                                    <i style="color:green" class="fa fa-plus" aria-hidden="true"></i></a>
                            </div>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div class="col-md-3">
        <form style=" margin-top: 15px;" role="form" ng-controller="createItem" ng-submit="createItem(name,price)">
            <fieldset>
                <div class="form-group">
                    <input type="text*" placeholder="name*" class="form-control" ng-model="name" id="name" name="name"
                           required>
                </div>
                <div class="form-group">
                    <input placeholder="price*" type="text" class="form-control" ng-model="price" id="price"
                           name="price"
                           required>
                </div>
                <input hidden type="text" name="restaurantId" value="{{restaurantId}}">
                <button type="submit" class="btn btn-success pull-right">Add item</button>
            </fieldset>
        </form>
        <div ng-controller="orderList">
            <div>
                <ul class="nav nav-tabs nav-justified" style="margin-top: 10px">
                    <li role="presentation" ng-class="myItems" ng-click="myItems = 'active'; allItems = ''"><a>My
                        items</a></li>
                    <li role="presentation" ng-class="allItems" ng-click="allItems = 'active'; myItems = ''"><a>All
                        items</a></li>
                </ul>
                <table class="table">
                    <tr>
                        <th>Name</th>
                        <th>Amount</th>
                        <th>Price</th>
                        <th></th>
                    </tr>
                    <tr ng-repeat="item in myOrders.orderList | orderBy:'restaurant.name'">
                        <td>{{item.item.name}}</td>
                        <td>
                            <div>
                                <a style="margin-right: 5px;" href=""><i style="color:green"
                                                                         ng-click="removeOneItemFromOrder(eventId,item.item.id)"
                                                                         class="fa fa-minus" aria-hidden="true"></i></a>
                                <span style="">{{item.count}}</span>
                                <a href="" ng-click="addOneItemToOrder(item.item.id,eventId)" style="margin-left: 5px;">
                                    <i style="color:green" class="fa fa-plus" aria-hidden="true"></i></a>
                            </div>
                        </td>
                        <td>{{item.count * item.item.price|currency:"&#8372"}}</td>
                        <td><a href="" ng-click="removeFromOrder(eventId,item.item.id)"><i style="color:red"
                                                                                           class="fa fa-times"
                                                                                           aria-hidden="true"></i></a>
                        </td>
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
</div>


