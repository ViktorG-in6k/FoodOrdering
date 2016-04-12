<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" media="screen"
      href="http://tarruda.github.com/bootstrap-datetimepicker/assets/css/bootstrap-datetimepicker.min.css">

<%--<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.3/angular.min.js"></script>--%>
<%--<script src="/resources/js/app.js"></script>--%>

<form role="form" action="/new_event" method="post" class="col-md-3  pull-right">
    <fieldset>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script>
            $(document).ready(function () {
                $("#slide").click(function () {
                    $("#s").slideToggle();
                });
            });
        </script>


        <legend class="button" id="slide">NEW EVENT</legend>
        <div id="s" style="display: none">

            <div class="form-group">
            <label for="name">Event name:</label>
            <input type="text" class="form-control" id="name" name="name" required>
        </div>
        <div class="form-group">
            <label for="discript">Discription:</label>
            <textarea  class="form-control text-area" rows="10"  id="discript" name="discript" style="resize: vertical"></textarea>
        </div>
        <div class="form-group">
            <label for="image">URL-image:</label>
            <input type="url" class="form-control" id="image" name="image">
        </div>

            <div id="datetimepicker" class="form-group  input-append date">
                <label for="cal">Date:</label>
                <input id="cal" class="col-md-11" type="text" name="date" required>
            <span class="add-on">
                <i data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
            </span>

            </div>
            <script type="text/javascript"
                    src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.8.3/jquery.min.js">
            </script>
            <script type="text/javascript"
                    src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/js/bootstrap.min.js">
            </script>
            <script type="text/javascript"
                    src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.min.js">
            </script>
            <script type="text/javascript"
                    src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.pt-BR.js">
            </script>
            <script type="text/javascript">
                $('#datetimepicker').datetimepicker({
                    format: 'dd/MM/yyyy hh:mm',
                    language: 'en-EN'
                });
            </script>
            <%--<div ng-app="ui.bootstrap.datetimepicker" class="dropdown">--%>
            <%--<a class="dropdown-toggle" id="dropdown2" role="button" data-toggle="dropdown" data-target="#" href="#">--%>
            <%--<div class="input-group"><input type="text" class="form-control" data-ng-model="data.dateDropDownInput"><span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>--%>
            <%--</div>--%>
            <%--</a>--%>
            <%--<ul class="dropdown-item" role="item" aria-labelledby="dLabel">--%>
            <%--<datetimepicker data-ng-model="data.dateDropDownInput" data-datetimepicker-config="{ dropdownSelector: '#dropdown2' }"/>--%>
            <%--</ul>--%>
            <%--</div>--%>

        <button type="submit" class="btn btn-success pull-right">Add</button>
        </div>
    </fieldset>
</form>

