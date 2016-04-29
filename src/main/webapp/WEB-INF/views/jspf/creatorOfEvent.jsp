<form role="form" ng-controller="CreteTheEventController"
      ng-submit="createEvent(name,phone,data.dateDropDownInput)" method="post" class="col-md-3  pull-right"
      style="position: fixed; right: 10px; ">
    <fieldset>
        <script src="/resources/core/js/jquery-2.1.4.min.js"></script>
       
        <button class="btn col-md-offset-10 btn-success pull-right" id="slide">Create new event</button>
        <div id="s" style="display: none">

            <div class="form-group">
                <label for="name">Event name:</label>
                <input ng-model="name" type="text" class="form-control" id="name" name="name" required>
            </div>

            <div class="form-group">
                <label for="discription">Description:</label>
                <textarea ng-model="phone" class="form-control text-area" rows="10" id="discription"
                          name="discript"
                          style="resize: vertical"></textarea>
            </div>

            <div class="dropdown">
                <label for="dropdown2">Date:</label>
                <a class="dropdown-toggle" id="dropdown2" role="button" data-toggle="dropdown" data-target="#" href="#">
                    <div class="input-group">
                        <input type="text" class="form-control" data-ng-model="data.dateDropDownInput">
                        <span class="input-group-addon">
                        <i class="glyphicon glyphicon-calendar"></i>
                        </span>
                    </div>
                </a>
                <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
                    <datetimepicker data-ng-model="data.dateDropDownInput"
                                    data-datetimepicker-config="{ dropdownSelector: '#dropdown2' }">
                    </datetimepicker>
                </ul>
                {{data.dateDropDownInput | date:'yyyy-MM-dd HH:mm'}}
            </div>

            <script type="text/javascript"
                    src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/js/bootstrap.min.js">
            </script>
            <script type="text/javascript"
                    src="/resources/js/bootstrap-datetimepicker.min.js">
            </script>
           
            <br/><br/>
            <button type="submit" class="btn btn-success pull-right">Add</button>
        </div>
    </fieldset>
</form>

