<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form role="form" action="/new_event" method="post" class="col-md-3  pull-right">
    <fieldset>
        <legend>NEW EVENT</legend>
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
        <div class="form-group">
            <label for="date">Date:</label>
            <input type="datetime-local" class="form-control" id="date" name="date" required>
        </div>
        <button type="submit" class="btn btn-success pull-right">Add</button>
    </fieldset>
</form>
