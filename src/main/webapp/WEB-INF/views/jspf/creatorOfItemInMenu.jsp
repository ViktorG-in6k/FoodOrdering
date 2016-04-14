<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form role="form" action="/new_item" method="post" class="col-md-3  pull-right" style="position: fixed; right: 10px; ">
    <fieldset>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script>
            $(document).ready(function () {
                $("#slide").click(function () {
                    $("#s").slideToggle();
                });
            });
        </script>

        <legend class="button" id="slide"><a>New item</a></legend>
        <div id="s" style="display: none">

            <div class="form-group">
                <label for="name">Item name:</label>
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
                <label for="price">Price:</label>
                <input type="text" class="form-control" id="price" name="price" required>
            </div>

            <button type="submit" class="btn btn-success pull-right">Add</button>
        </div>
    </fieldset>
</form>
