<div ng-controller="orderList">
   <div >
   <h3>Your order</h3>
   <table class="table">
      <tr>
         <th>name</th>
         <th>price</th>
         <th>amount</th>
         <th>total</th>
         <th>restaurant</th>
      </tr>
      <tr ng-repeat="item in myOrders.myOrderList">
         <td>{{item.item.name}}</td>
         <td>{{item.item.price|currency}}</td>
         <td> <span>{{item.count}}</span> </td>

         <td>{{item.count * item.item.price}}</td>
         <td>{{item.restaurant.name}}</td>

      </tr>
      <tr>
         <td></td>
         <td></td>
         <td>Total</td>
         <td>{{getTotal()}}</td>
      </tr>
   </table>
</div>
</div>