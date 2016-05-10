<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div ng-controller="eventController">
    <div class="col-sm-9 col-md-9 col-xs-9 ">
        <div ng-if="events.length == 0">
            <div style="height: 100px;border: 1px solid #BBB4B4;background-color: #F5F5F5">
            </div>
        </div>
        <div ng-repeat="event in events | orderBy:['date.year','date.monthValue','date.dayOfMonth','date.hour','date.minute']">
            <div style="height: 100px;border: 1px solid #BBB4B4;background-color: #F5F5F5">
                <div class="row">
                    <div class="col-md-12" style="height: 12px"></div>
                </div>
                <div class="row">
                    <div class="col-md-7 col-xs-5" style="margin-left: 4%">
                        <a href="/events/event_{{event.id}}#/{{event.id}}" style="font-size: 25px;">{{event.name}}</a>
                    </div>
                    <div class="col-md-5 col-xs-7 pull-right">
                        <p style="font-size: 25px;padding-left: 140px;margin-top: -36px;">
                            {{event.date.dayOfMonth}}
                            {{event.date.month | limitTo: 3 | lowercase | capitalize}}  {{event.date.hour|toMinute}}:{{event.date.minute|toMinute}}</p><br>
                        </p>
                        <p style="font-size: 25px; padding-left: 142px;margin-top: -9px;">

                    </div>
                    <div class="col-md-4 col-xs-4" style="margin-left: 4%">
                        <p style="color: black">created by user@example.com</p>
                    </div>
                </div>
                <div class="row">
                </div>
            </div>
            <div style="height: 15px"></div>
        </div>
    </div>
    <div class="col-sm-3 col-md-3 col-xs-3 pull-right" ng-controller="createEventController">
        <form role="form" ng-submit="createEvent(name,date)">
            <div>
                <div class="form-group">
                    <input ng-model="name" type="text" class="form-control" id="name" placeholder="Event title"
                           name="name" required>
                </div>
                <div class="form-group">
                    <input kendo-date-time-picker ng-model="str" k-ng-model="date"
                           style="width: 100%;height: 27px;margin-bottom: 1px;"
                           k-options="dateTimePickerConfig" placeholder="  Event date"/>
                </div>
                <button type="submit" class="btn btn-success pull-right">Add event</button>
            </div>
        </form>
    </div>
</div>
