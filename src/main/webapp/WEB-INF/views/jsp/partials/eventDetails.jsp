<div style=" margin-top: 30px;">
    <div>
        <div class="well pull-left" style="height: 120px; width: 100%">
            <div class="col-md-6" style="font-size: 25px;">
                {{event.name}}
            </div>
            <div class="col-md-offset-10" style="font-size: 19px;">
                <div class="col-md-offset-4">
                    <i class="glyphicon glyphicon-calendar" aria-hidden="true"></i>
                    {{event.date.dayOfMonth}} {{event.date.month | limitTo: 3}}
                    {{event.date.hour}}:{{event.date.minute}}
                </div>
            </div>
            <br/>
            <div class="row"></div>
            <div class="col-md-6" style="font-size: 15px;" >Created by {{event.user.email}}</div>
        </div>
    </div>


</div>
<div class="col-md-offset-1 col-sm-offset-1 col-md-8 col-sm-8">
    <div class="panel-group col-md-offset-1 col-sm-offset-1 col-md-11 col-sm-11" id="accordion" role="tablist" aria-multiselectable="true">
        <div ng-repeat="restaurant in restaurants | orderBy: 'name'" class="panel panel-default"   style="  margin-top: 15px;">
            <div style="height: 120px;background-color: white; border: 1px solid #BBB4B4;background-color: #F5F5F5">
                <div class=" col-md-4">
                    <h3>
                        <a href="{{'#/'+ eventId}}/{{restaurant.id}}" style="font-size: 25px;">
                            {{restaurant.name}}
                        </a>
                    </h3>
                </div>
                <div class="col-md-offset-4 col-md-4">
                    <h2 style="font-size: 15px;"  class="col-md-offset-4">
                        Participants:
                    </h2>
                </div>
                <br/>
                <div class="row"></div>
                <div ng-if="restaurant.link" class="col-md-4">
                    <a href="{{restaurant.link}}" target="_blank" style="font-size: 13px;">
                        Web-site
                    </a>
                </div>
                <br/>
                <div ng-if="restaurant.phone" class="col-md-4 pull-left" style="font-size: 13px;">
                    Phone: {{restaurant.phone}}
                </div>
            </div>
        </div>
    </div>
</div>


<form style=" margin-top: 15px;" role="form" action="/new_restaurant" method="post" class=" col-md-offset-0 col-md-2">
    <fieldset>
        <div class="form-group">
            <input type="text*" placeholder="name*" class="form-control" id="name" name="name" required>
        </div>
        <div class="form-group">
            <input placeholder="link" type="url" class="form-control" id="link" name="link">
        </div>
        <div class="form-group">
            <input placeholder="phone*" type="text" class="form-control" id="phone" name="phone" required>
        </div>
        <input hidden type="text" name="eventId" value="{{eventId}}">
        <button type="submit" class="btn btn-success pull-right">Add restaurant</button>
    </fieldset>
</form>

