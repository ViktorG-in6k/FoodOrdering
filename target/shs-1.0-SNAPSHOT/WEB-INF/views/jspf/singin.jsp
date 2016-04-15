<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.3/angular.min.js"></script>
<script src="/resources/js/singin.js"></script>


<div  class="container" style="margin-top: 250px">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="well">
                <form  action="/events" method="post">

                    <div  class="input-group col-md-12">

                        <input class="btn btn-lg col-md-8" style="text-align: left" name="email" id="email"

                               placeholder="Your Email" required>

                        <button class="btn btn-success col-md-offset-1 col-md-3 btn-lg" type="hidden"
                                name="${_csrf.parameterName}"
                                value="${_csrf.token}">Sing In
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

