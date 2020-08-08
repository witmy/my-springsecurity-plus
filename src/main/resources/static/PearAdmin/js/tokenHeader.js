/*! jQuery v2.1.1 | (c) 2005, 2014 jQuery Foundation, Inc. | jquery.org/license */
$.ajaxSetup({
    cache : false,
    headers : {
        "Authorization" : localStorage.getItem("token")
    },
    error : function(result) {
        var code = result.code
        var msg = result.message

        if (code == 400) {
            layer.msg(message);
        } else if (code == 401) {
            localStorage.removeItem("token");
            location.href = '/login.html';
        } else if (code == 403) {
            console.log("未授权:" + msg);
            layer.msg('未授权');
        } else if (code == 500) {
            layer.msg('系统错误：' + msg);
        }
    }
});
