<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container" style="margin-top: 250px">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="well">
                <form action="/app" method="post">
                    <div class="input-group col-md-12">
                        <input class="btn btn-lg col-md-8  " name="email" id="email" type="email" placeholder="Your Email"
                               required>

                        <%--<input type="hidden"--%>
                               <%--name="${_csrf.parameterName}"--%>
                               <%--value="${_csrf.token}"/>--%>
                        <button class="btn btn-success col-md-offset-1 col-md-3 btn-lg" type="hidden"
                                name="${_csrf.parameterName}"
                                value="${_csrf.token}">Sing in</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

