<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="col-sm-9 col-md-9 col-xs-9 " ng-controller="eventController">
    <div ng-repeat="event in events | orderBy:['date.year','date.month','date.dayOfMonth']">
        <div style="height: 100px;background-color: white; border: 1px solid #BBB4B4;background-color: #F5F5F5">
            <div class="row">
                <div class="col-md-12" style="height: 12px"></div>
            </div>
            <div class="row">

                <div class=" col-xs-1 col-md-1"></div>
                <div class="col-md-7 col-xs-7">
                    <a href="/events/event_{{event.id}}#/{{event.id}}" style="font-size: 25px;">{{event.name}}</a>
                </div>
                <div class="col-md-4 col-xs-4">
                    <p style="font-size: 20px;">
                        {{event.date.dayOfMonth}}
                        {{event.date.month | limitTo: 3}} 2016
                        20:20
                    </p>

                </div>

            </div>
            <div class="row">
                <div class="col-md-1 col-xs-1"></div>
                <div class="col-md-4 col-xs-4">
                    <p style="color: black">Created by user@example.com</p>
                </div>
            </div>
        </div>
        <div style="height: 15px"></div>
    </div>
</div>


<div class="col-sm-3 col-md-3 col-xs-3">
    <form role="form" ng-controller="DatepickerPopupDemoCtrl"
          ng-submit="createEvent(name,phone,data.dateDropDownInput)" method="post"
          style="">
        <div id="s">
            <div class="form-group">
                <input ng-model="name" type="text" class="form-control" id="name" placeholder="Event title" name="name"
                       required>
            </div>
            <div>
                <p class="input-group">
                    <input type="text" class="form-control" uib-datepicker-popup="{{format}}" ng-model="dt"
                           is-open="popup1.opened" datepicker-options="dateOptions" ng-required="true"
                           close-text="Close"
                           alt-input-formats="altInputFormats"/>

          <span class="input-group-btn">
            <button type="button" class="btn btn-default" ng-click="open1()"><i
                    class="glyphicon glyphicon-calendar"></i></button>
          </span>
                </p>

            </div>
            <button type="submit" class="btn btn-success pull-right">Add event</button>
        </div>

    </form>
</div>

