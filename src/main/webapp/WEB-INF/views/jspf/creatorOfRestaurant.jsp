<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form role="form" action="/new_restaurant" method="post" class=" col-md-offset-0 col-md-2">
    <fieldset>
        <div class="form-group">
            <input type="text*" placeholder="name*" class="form-control" id="name" name="name" required>
        </div>
        <div class="form-group">
            <input placeholder="link" type="url" class="form-control" id="link" name="link">
        </div>
        <div class="form-group">
            <input placeholder="phone*" type="text" class="form-control" id="phone" name="phone" required>
        </div>
        <input hidden type="text" name="eventId" value="{{eventId}}">
        <button type="submit" class="btn btn-success pull-right">Add restaurant</button>
    </fieldset>
</form>

