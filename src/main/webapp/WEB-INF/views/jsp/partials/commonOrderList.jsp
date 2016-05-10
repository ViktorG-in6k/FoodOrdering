<div style=" margin-top: 30px;">
    <div>
        <div class="well pull-left event-well" >
            <div class="col-md-6" style="font-size: 25px;">
                {{event.name}}
            </div>
            <div class="col-md-offset-10 event-date" >
                <div class="col-md-offset-4">
                    {{event.date.dayOfMonth}} {{event.date.month | limitTo: 3}}
                    {{event.date.hour|toMinute}}:{{event.date.minute|toMinute}}
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
    <div class="col-md-12"><h1 class="text-center">Order list</h1></div>
        <div>
            <div class="col-md-12" style="margin-bottom: 5px">
            <h1 style="display: inline">{{restaurant.name}}</h1> <h3  style=" display: inline;padding-left: 100px"><i class="fa fa-phone" aria-hidden="true"></i> {{restaurant.phone}}</h3>
            </div>
        </div>
    </div>
    <div>
        <div>
            <table class="table table-bordered table-responsive">
                <tr>
                    <th>Name</th>
                    <th>Amount</th>
                    <th>Price</th>
                    <th>Cost</th>
                </tr>
                <tr ng-repeat="item in myOrders.orderList | orderBy:'restaurant.name'">
                    <td>{{item.item.name}}</td>
                    <td>
                        <div>
                            <span style="">{{item.count}}</span>
                        </div>
                    </td>
                    <td>{{item.item.price|currency:"&#8372"}}</td>

                    <td>
                    {{item.count * item.item.price|currency:"&#8372"}}
                    </td>
                </tr>
                <tr>
                    <td>Total</td>
                    <td></td>
                    <td></td>
                    <td><div class="">{{getTotal() |currency:"&#8372"}} </div> </td>
                </tr>
            </table>
        </div>
</div>
</div>
