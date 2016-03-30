<%--
  Created by IntelliJ IDEA.
  User: avatarion
  Date: 3/30/16
  Time: 10:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form role="form" action="/new_event" method="post" class="col-md-3  pull-right">
    <fieldset>
        <legend>NEW EVENT</legend>

        <div class="form-group">
            <label for="name">Event name:</label>
            <input type="text" class="form-control" id="name" name="name">
        </div>

        <div class="form-group">
            <label for="discript">Discription:</label>
            <input type="text" class="form-control" id="discript" name="discript">
        </div>

        <div class="form-group">
            <label for="image">URL-image:</label>
            <input type="url" class="form-control" id="image" name="image">
        </div>

        <div class="form-group">
            <label for="date">Date:</label>
            <input type="datetime-local" class="form-control" id="date" name="date">
        </div>

        <button type="submit" class="btn btn-success pull-right">Add</button>
    </fieldset>
</form>
