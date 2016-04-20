<div ng-controller="commonOrderByEachUserCtrl" class="container">
    <a href="#/commonOrder/{{id}}">
        <button type="button" class="btn btn-success ">Common</button>
    </a>
    <div class="row">
        <div class="col-md-7">
            <div>
                <h3>Common order by users</h3>
                <div ng-repeat="orderDTO in array">
                    <table class="table">
                        <tr>
                            {{orderDTO.userMail}}
                        </tr>
                        <tr>
                            <th>Restaurant</th>
                            <th>Name</th>
                            <th>Amount</th>
                            <th>Price</th>
                            <th>Ordered</th>
                        </tr>
                        <tr ng-repeat="myOrder in orderDTO.orderDTOList.myOrderList">
                            <td>{{myOrder.restaurant.name}}</td>
                            <td>{{myOrder.item.name}}</td>
                            <td>{{myOrder.count}}</td>
                            <td>{{myOrder.item.price*myOrder.count |currency:"UAH"}}</td>
                            <td>{{myOrder.ordered}}</td>
                            <td>{{myOrderList.count * item.price|currency:"UAH"}}</td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
