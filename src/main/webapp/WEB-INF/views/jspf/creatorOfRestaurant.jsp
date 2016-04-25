<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="col-md-4 col-lg-4" >
    <div style="position: fixed">
        <div class="col-md-9">
            <form role="form" action="/new_restaurant"  method="post">
                <fieldset>
                    <script src="/resources/core/js/jquery-2.1.4.min.js"></script>
                    <script>
                        $(document).ready(function () {
                            $("#slide").click(function () {
                                $("#s").slideToggle();
                            });
                        });
                    </script>
                    <button class="btn col-md-offset-10 btn-success pull-right" id="slide">Create new restaurant</button>
                    <div id="s" style="display: none">
                        <div class="form-group">
                            <label for="name">Restaurant name:</label>
                            <input type="text" class="form-control" id="name" name="name" required>
                        </div>
                        <div class="form-group">
                            <label for="discript">Discription:</label>
                        <textarea class="form-control text-area" rows="10" id="discript" name="discript"
                                  style="resize: vertical"></textarea>
                        </div>
                        <div class="form-group">
                            <label for="image">URL-image:</label>
                            <input type="url" class="form-control" id="image" name="image">
                        </div>
                        <input hidden type="text" name="eventId" value="{{eventId}}">
                        <button type="submit" class="btn btn-success pull-right">Add</button>
                    </div>
                </fieldset>
            </form>
        </div>
        <div class="col-md-9">
            <div style="margin-top: 10px">
            <jsp:include page="/WEB-INF/views/jspf/eventOrderList.jsp" flush="true" />
            </div>
        </div>
    </div>
</div>

