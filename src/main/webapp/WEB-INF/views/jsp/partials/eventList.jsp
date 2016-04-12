<div class="col-md-9 " ng-controller ="eventController">
    <div class="row">

        <div ng-repeat="event in events">

            <div class="col-sm-4 col-md-4">
                <div class="post">
                    <div class="post-img-content">

                        <img class="col-md-offset-1 col-md-10" src="{{event.imageURL}}"/>
                    <span class="post-title">
                       <a href="/events/event_{{event.id}}"> <b class="text-info col-md-7">{{event.name}}</b><br/></a>
                        <b><i class="fa fa-calendar-check-o" aria-hidden="true"></i> Date: 31.10.2016 20:00</b><br/>
                        <b><i class="fa fa-user" aria-hidden="true"></i> Partycipates: 20people</b>
                    </span>
                    </div>
                    <br/>
                    <div class="content">
                        <div class="author">
                            By <b>Bhaumik</b> |
                            <time datetime="2014-01-20">January 20th, 2014</time>
                        </div>

                        <a href="#demo" class="btn btn-info" data-toggle="collapse">Simple collapsible</a>
                        <div id="demo" class="collapse">
                            {{event.description}}
                        </div>

                        <div>
                            <a href="/events/{{event.id}}"
                               class="btn btn-warning btn-sm">Read more</a>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>