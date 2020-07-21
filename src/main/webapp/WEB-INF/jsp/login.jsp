<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@pagecontentType="text/html;charset=UTF-8" %>
<bean:define id="ctx" value="<%=request.getContextPath() %>"/>
<%@page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Company</title>

    <script type="text/javascript" src="${ctx}/company/assets/js/jquery-1.8.1.min.js"></script>
    <script type="text/javascript" src="${ctx}/company/assets/js/toastr.js"></script>
    <script type="text/javascript" src="${ctx}/company/assets/js/netsign.js"></script>
    <link rel="stylesheet" href="${ctx}/company/assets/css/bootstrap-login.css"/>
    <link rel="stylesheet" href="${ctx}/company/assets/css/signin.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/company/assets/css/toastr.css"/>


</head>
<style>
    body {
        font-family: "Microsoft YaHei";
    }
</style>

<body>

<div class="container">

    <div class="" id="login-wrapper">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div id="logo-login">
                    <h1 style="font-size:22px">
                        Company Outcome System
                    </h1>
                </div>
            </div>

        </div>

        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="account-box">
                    <div class="form form-horizontal">
                        <form role="form" id="logForm" method="post" action='<c:url value="/usermanager/login"/>'>
                            <input type="hidden" value="${vcError}" id="vcerror"/>
                            <input type="hidden" value="${userEmpty}" id="userEmpty"/>
                            <input type="hidden" value="${emptyVC}" id="emptyvc"/>
                            <input type="hidden" value="${passwordFaild}" id="passwordFaild"/>
                            <div class="form-group">
                                <div class="col-xs-12  ">
                                    <div class="input-group">
                                        <span class="input-group-addon"><span
                                                class="glyphicon glyphicon-user"></span></span>
                                        <input type="text" id="loginName" name="loginName" class="form-control"
                                               placeholder="phone/email"/>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-xs-12  ">
                                    <div class="input-group">
                                        <span class="input-group-addon"><span
                                                class="glyphicon glyphicon-lock"></span></span>
                                        <input type="password" id="password" name="password" class="form-control"
                                               placeholder="password"/>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group ">
                                <div class="col-xs-7">
                                    <div class="input-group">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-pencil"></span></span>
                                        <input type="text" id="verifyCode" name="verifyCode" class="form-control"
                                               placeholder="security code"/>
                                    </div>
                                </div>
                                <div>
                                    <label>
                                        <img id="imgObj" alt="验证码" src="/company/code"/>
                                        <span id="switchValidateCodeSpan" class="requestIMG"><a>change</a></span>
                                    </label>
                                </div>
                            </div>
                            <div class="checkbox pull-left">
                                <label><a href="/company/forward/registerjsp">To register</a></label>
                            </div>
                    </div>
                    <button class="btn btn btn-primary pull-right logbtn" type="button">
                        LOGIN
                    </button>
                    </form>
                    <a class="forgotLnk" href="index.html"></a>
                    <div class="row-block">
                        <div class="row">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>


</body>
<script type="text/javascript">

    $(function () {
        $(this).keydown(function (e) {
            var key = window.event ? e.keyCode : e.which;
            if (key.toString() == "13") {
                $(".logbtn").click();
            }
        });
    });

    $(function () {
        $(".logbtn").click(function () {
            $("#logForm").submit();
        })
    });


    $(function () {
        $("#switchValidateCodeSpan").click(function () {
            var imgSrc = $("#imgObj");
            var src = imgSrc.attr("src");
            imgSrc.attr("src", chgUrl(src));
        });
    });

    //时间戳
    //为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳
    function chgUrl(url) {
        var timestamp = (new Date()).valueOf();
        url = url.substring(0, 17);
        if ((url.indexOf("&") >= 0)) {
            url = url + "×tamp=" + timestamp;
        } else {
            url = url + "?timestamp=" + timestamp;
        }
        return url;
    }

    <%---------------提示框JS-----------------------%>
    $(function () {
        //参数设置，若用默认值可以省略以下面代
        toastr.options = {
            "closeButton": true, //是否显示关闭按钮
            "debug": false, //是否使用debug模式
            "positionClass": "toast-center-bottom",//弹出窗的位置
            "showDuration": "300",//显示的动画时间
            "hideDuration": "1000",//消失的动画时间
            "timeOut": "5000", //展现时间
            "extendedTimeOut": "1000",//加长展示时间
            "showEasing": "swing",//显示时的动画缓冲方式
            "hideEasing": "linear",//消失时的动画缓冲方式
            "showMethod": "fadeIn",//显示时的动画方式
            "hideMethod": "fadeOut" //消失时的动画方式
        };

    });

    $(function () {
        var emptyvc = $("#emptyvc").val();
        if (emptyvc != "") {
            toastr.error(emptyvc);
        }
    });

    $(function () {
        var vcmsg = $("#vcerror").val();
        if (vcmsg != "") {
            toastr.error(vcmsg);
        }
    });

    $(function () {
        var empty = $("#userEmpty").val();
        if (empty != "") {
            toastr.error(empty);
        }
    });


    $(function () {
        var passwordFaild = $("#passwordFaild").val();
        if (passwordFaild != "") {
            toastr.error(passwordFaild);
        }
    });
</script>
</html>
