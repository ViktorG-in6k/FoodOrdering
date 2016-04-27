<div>
<div  class="jumbotron">
    <div class="media">
        <div class="media-body">
            <div class="col-md-6">
               {{event.name}}
            </div>
            <div class="pull-right">
                <i class="glyphicon glyphicon-calendar" aria-hidden="true"></i>
                {{event.date.dayOfMonth}} {{event.date.month | limitTo: 3}}
                {{event.date.year}}
            </div>
        </div>
    </div>
</div>
    </div>