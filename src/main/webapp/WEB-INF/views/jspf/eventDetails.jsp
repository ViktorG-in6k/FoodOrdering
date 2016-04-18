<div class="well well-sm">
    <div class="media">
        <a class="pull-left" href="#">
            <img class="media-object" width="160px" height="160px"  src="http://www.ekaterinawalter.com/wp-content/uploads/2016/01/image-2.jpg">
        </a>
        <div class="media-body">
            <h4 class="media-heading">{{event.name}}</h4>
            <p class="text-right" ng-if="event.user != null">Responsible for order : {{event.user.email}}</p>
            <p>{{event.description}}</p>
            <ul class="list-inline list-unstyled">
                <li><span>        <b><i class="glyphicon glyphicon-calendar" aria-hidden="true"></i> {{event.date.dayOfWeek |
                                limitTo: 3}} {{event.date.dayOfMonth}} {{event.date.month | limitTo: 3}}
                                {{event.date.year}} </b>  </span></li>
                <b ><i class="glyphicon glyphicon-time" aria-hidden="true"></i>
                    {{event.date.hour}}:{{event.date.minute}}</b><br/>


            </ul>
        </div>
    </div>
</div>