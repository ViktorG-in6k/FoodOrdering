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

