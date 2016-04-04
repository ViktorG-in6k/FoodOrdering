<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container" style="margin-top: 250px">
    <div class="row">
        <div class="col-md-5 col-md-offset-4">
            <div class="well">
                <form action="/events" method="post">
                    <div class="input-group">
                        <input class="btn btn-lg" name="email" id="email" type="email" placeholder="Your Email"
                               required>
                        <button class="btn btn-success btn-lg" type="submit">Sing in</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

