function User() {
    this.name = "name";
}

angular.factory("name", function () {
    var obj = {};
    obj.name = "name";
    return obj;
});

angular.service("name", function User() {
    this.name = "name";
});