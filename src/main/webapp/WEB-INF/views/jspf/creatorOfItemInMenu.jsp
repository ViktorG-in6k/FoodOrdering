<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form role="form" action="/new_item" method="post" class="col-md-3  pull-right">
    <fieldset>
        <legend>NEW ITEM</legend>
        <div class="form-group">
            <label for="name">Item name:</label>
            <input type="text" class="form-control" id="name" name="name" required>
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
            <label for="price">Price:</label>
            <input type="text" class="form-control" id="price" name="price" required>
        </div>
        <button type="submit" class="btn btn-success pull-right">Add</button>
    </fieldset>
</form>
