<div class="col-md-9 " ng-controller="eventController">
    <div>
        <div ng-repeat="event in events | orderBy:['date.year','date.month','date.dayOfMonth']">
            <div class="well col-md-9 pull-left">
                <form action="">
                    <img src="" class="img-thumbnail col-md-3 pull-left">
                    <label class="text-info col-md-7"
                           style="font-size: 19px; color: #000000;"> {{event.name}}</label>
                    <label class="pull-right">
                        time
                        {{event.date.dayOfWeek |
                        limitTo: 3}} {{event.date.dayOfMonth}} {{event.date.month | limitTo: 3}}
                        {{event.date.hour}}:{{event.date.minute}}
                    </label>
                    <div class="col-md-9 ">
                        {{event.description}}
                    </div>
                    <a class="btn btn-primary col-md-offset-7 col-md-2 "
                       href="">Get
                        order</a>
                    <a class="btn btn-primary col-md-offset-10 col-md-2   "
                       href="">Participate</a>
                </form>
            </div>
        </div>
    </div>
</div>