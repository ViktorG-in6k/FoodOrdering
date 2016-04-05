<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container" style="margin-top: 250px">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="well">
                <form action="/events" method="post">
                    <div class="input-group col-md-12">
                        <input class="btn btn-lg col-md-8  " name="email" id="email" type="email" placeholder="Your Email"
                               required>
                        <button class="btn btn-success col-md-offset-1 col-md-3 btn-lg" type="submit">Sing in</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

