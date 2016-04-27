<div class="col-md-9 " ng-controller="eventController">
    <div>

        <div ng-repeat="event in events | orderBy:['date.year','date.month','date.dayOfMonth']">
            <div class="well col-md-9 pull-left">
                <form action="">
                    <label class="text-info col-md-7"
                           style="font-size: 19px; color: #000000;"><a href="/events/event_{{event.id}}#/{{event.id}}">
                        {{event.name}}
                    </a></label>
                </form>
            </div>
        </div>
    </div>
</div>