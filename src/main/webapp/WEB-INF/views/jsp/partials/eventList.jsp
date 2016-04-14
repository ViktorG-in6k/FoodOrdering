<div class="col-md-9 " ng-controller="eventController">

    <div>

        <div ng-repeat="event in events | orderBy:['date.year','date.month','date.dayOfMonth']">


            <div class="col-sm-6 col-md-6" style="margin-bottom: 30px">
                <div class="post">
                    <div class="post-img-content" style="height: 300px; background-image: url('http://www.dogoilpress.com/data/wallpapers/12/FDS_440453.jpg')" >
                        <img class="pull-left col-md-10" src=""/>


                        <form class="post-title" role="form" action="/addResponsibleUser" method="post">
                            <a href="/events/event_{{event.id}}"> <b style="text-decoration: underline"
                                                                     class="text-info col-md-7">{{event.name}}</b><br/></a>
                            <b><i class="glyphicon glyphicon-calendar" aria-hidden="true"></i> {{event.date.dayOfWeek |
                                limitTo: 3}} {{event.date.dayOfMonth}} {{event.date.month | limitTo: 3}}
                                {{event.date.year}} </b><br/>
                            <b><i class="glyphicon glyphicon-time" aria-hidden="true"></i>
                                {{event.date.hour}}:{{event.date.minute}}</b><br/>
                            <div ng-if="event.user == null">
                                <b><input type="hidden" value="{{event.id}}" name="eventId">
                                    <button type="submit" class="btn btn-success pull-right">To take responsibility
                                        {{event.id}}
                                    </button>
                                </b>
                            </div>
                            <div ng-if="event.user != null">
                                <b> {{event.user.email}} </b>
                            </div>
                        </form>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
