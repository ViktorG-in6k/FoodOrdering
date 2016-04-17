<div ng-controller="orderList">
   <h3>Your order</h3>
   <table class="table">
      <tr>
         <th>name</th>
         <th>price</th>
         <th>amount</th>
      </tr>
      <tr ng-repeat="item in myOrders.myOrderList">
         <td>{{item.item.name}}</td>
         <td>{{item.item.price}}</td>
         <td>{{item.count}}</td>

      </tr>
   </table>
</div>