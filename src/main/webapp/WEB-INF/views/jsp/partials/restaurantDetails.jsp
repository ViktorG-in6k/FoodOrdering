<div style=" margin-top: 30px;">
    <div>
        <div class="well pull-left" style="height: 120px; width: 100%">
            <div class="col-md-6" style="font-size: 25px;">
                {{restaurant.name}}
            </div>

            <br/>
            <div class="row"></div>

        </div>
    </div>
</div>
<div class="col-md-offset-1 col-sm-offset-1 col-md-8 col-sm-8">
    <div class="panel-group col-md-offset-1 col-sm-offset-1 col-md-11 col-sm-11" id="accordion" role="tablist"
         aria-multiselectable="true">
        <table class="table">
            <thead>
            <tr>
                <th>name</th>
                <th>price</th>
            </tr>
            </thead>
            <tbody ng-repeat="item in restaurant.itemList | orderBy: 'name'">
            <tr>
                <td>{{item.name}}</td>
                <td>{{item.price | currency:"&#8372"}}</td>
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
</form>



