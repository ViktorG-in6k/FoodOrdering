<div style=" margin-top: 30px;">
    <div>
        <div class="well pull-left" style="height: 120px; width: 100%">
            <div class="col-md-6" style="font-size: 25px;">
                {{restaurant.name}}<br>
                <a href="{{restaurant.link}}" target="_blank" style="font-size: 13px">Web-site</a>
                <p style="font-size: 13px">Phone: {{restaurant.phone}}</p>
            </div>
            <br/>

        </div>
    </div>
</div>
<div class="col-md-offset-1 col-sm-offset-1 col-md-8 col-sm-8">
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
            <tbody >
            <tr ng-repeat="item in restaurant.itemList | orderBy: 'name'">
                <td>{{item.name}}</td>
                <td>{{item.price | currency:"&#8372"}}</td>
                <td style="width: 25%">

                        <div ng-controller="orderList">
                            <div ng-repeat="itemInOrder in myOrders.myOrderList" style="display: inline;">
                                <div ng-if="item.id == itemInOrder.item.id" style="display: inline;margin-left: -11px;">
                                    <a  href="">
                                        <i style="color:green"
                                           ng-click="removeOneItemFromOrder(eventId,itemInOrder.item.id)"
                                           class="fa fa-minus" aria-hidden="true">
                                        </i>
                                    </a>
                                    <span style="">
                                        <input style="width: 40px" min="1" type="number" ng-change="changeItem(itemInOrder.count, oldValue, eventId, item.id)" ng-blur="blur(itemInOrder.count, oldValue, eventId, item.id)"  ng-init="oldValue=itemInOrder.count"  ng-model="itemInOrder.count"/>
                                    </span>

                                </div>
                            </div>
                            <div style=" display: inline">
                                <a href="" ng-click="addToOrder(eventId, item.id)" >
                                    <i style="color:green" class="fa fa-plus" aria-hidden="true"></i></a>
                            </div>
                            </div>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<form style=" margin-top: 15px;" role="form" ng-controller="createItem" ng-submit="createItem(name,price)"
      class="col-md-offset-0 col-md-2">
    <fieldset>
        <div class="form-group">
            <input type="text*" placeholder="name*" class="form-control" ng-model="name" id="name" name="name" required>
        </div>
        <div class="form-group">
            <input placeholder="price*" type="text" class="form-control" ng-model="price" id="price" name="price"
                   required>
        </div>
        <input hidden type="text" name="restaurantId" value="{{restaurantId}}">
        <button type="submit" class="btn btn-success pull-right">Add item</button>
    </fieldset>
    <div ng-controller="orderList">
        <div>
            <h3 class="text-center">Your order</h3>
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
</form>



