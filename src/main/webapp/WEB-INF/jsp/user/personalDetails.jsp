<!DOCTYPE html>
<%@pagecontentType="text/html;charset=UTF-8" %>
<bean:define id="ctx" value="<%=request.getContextPath() %>"/>
<%@page import="com.company.example.springbootdemo.entity.LoginVO" %>
<%@page import="com.company.example.springbootdemo.util.CommonConstant" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<!DOCTYPE HTML>
<head>
    <title> 资源文件结构</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/company/assets/css/dpl.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/company/assets/css/bui.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/company/assets/css/page-min.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/company/assets/css/main.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/company/assets/css/toastr.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/company/assets/css/bootstrap-select.min.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/company/assets/css/bootstrap.css"/>
    <script type="text/javascript" src="${ctx}/company/assets/js/jquery-1.8.1.min.js"></script>
    <script type="text/javascript" src="${ctx}/company/assets/js/bootstrap-select.min.js"></script>
    <script type="text/javascript" src="${ctx}/company/assets/js/bootstrap.js"></script>
    <script type="text/javascript" src="${ctx}/company/assets/js/bui-min.js"></script>
    <script type="text/javascript" src="${ctx}/company/assets/js/config-min.js"></script>
    <script type="text/javascript" src="${ctx}/company/assets/js/toastr.js"></script>
    <script type="text/javascript" src="${ctx}/company/assets/js/jquery.twbsPagination.js"></script>
    <script type="text/javascript" src="${ctx}/company/assets/js/netsign.js"></script>
    <!-- 如果不使用页面内部跳转，则下面 script 标签不需要,同时不需要引入 common/page -->
</head>
<style>
    html {
        /*overflow-x: scroll;*/
        overflow-y: scroll;
    }

    input {
        height: 30px !important;
    }

    .demo-content {
        font-size: 14px;
        font-family: "Microsoft YaHei";
    }

    label.control-label {
        font-size: 14px;
        font-family: "Microsoft YaHei";
        line-height: 100%;
        text-align: center;
        /*padding-top: 0px;*/
    }

    .form-horizontal .control-label {
        padding-top: 0px;
    }

    .control-group {
        margin: 2px 0;
    }

    input.calendar {
        width: 120px;
    }

    table.x-datepicker-inner {
        width: 220px !important;
    }

    .showAStyle {
        display: block;
        margin: auto;
        width: 74px;
        text-decoration: none;
        height: 30px;
        line-height: 30px;
        border-radius: 5px;
        text-align: center;
        font-size: 14px;
        font-family: "Microsoft YaHei";
        color: #ffffff;
        background-color: #6cb5f4;
        border-color: #54a9f2;
    }

    .showAStyle:hover {
        color: #ffffff;
        text-decoration: none;
        background-color: #3d9df0;
        border-color: #1b8cee
    }
</style>
<%
    LoginVO user = (LoginVO) request.getSession(false).getAttribute(CommonConstant.SESSION_USER);
%>
<body>
<div class="demo-content">
    <div class="row">
        <div class="span24 doc-content">
            <form class="form-horizontal well" id="personalDetails_Form" method="post" action=''>
                <%--用户权限--%>
                <div class="row">
                    <div class="row detail-row ">
                        <div class="span8">
                            <label class="control-label">有效时限：</label>
                            <div class="controls">
                            <span class="detail-text">
					        </span>
                            </div>
                        </div>
                        <div class="span24">
                            <label class="control-label">用户权限：</label>
                            <div class="controls">
                                <span class="detail-text"></span>
                            </div>
                        </div>
                    </div>
                    <div class="row detail-row">

                        <div class="span8">
                            <label class="control-label">数据总量：</label>
                            <div class="controls">
                                <span class="detail-text">&nbsp;条</span>
                            </div>
                        </div>
                        <div class="span8">
                            <label class="control-label">查询上限：</label>
                            <div class="controls">
                                <span class="detail-text">&nbsp;次</span>
                            </div>
                        </div>
                        <div class="span8">
                            <label class="control-label">与或关系：</label>
                            <div class="controls">
                            <span class="detail-text">
					</span>
                            </div>
                        </div>
                    </div>

                    <div class="row detail-row">
                        <div class="span24">
                            <label class="control-label">始发机场：</label>
                            <div class="controls">
                                <span class="detail-text"></span>
                            </div>
                        </div>
                    </div>
                    <div class="row detail-row">
                        <div class="span24">
                            <label class="control-label">到达机场：</label>
                            <div class="controls">
                                <span class="detail-text"></span>
                            </div>
                        </div>
                    </div>
                    <div class="row detail-row">
                        <div class="span8">
                            <label class="control-label">订座间隔：</label>
                            <div class="controls">
                                <span class="detail-text">分钟</span>
                            </div>
                        </div>
                        <div class="span8">
                            <label class="control-label">离港间隔：</label>
                            <div class="controls">
                                <span class="detail-text">分钟 </span>
                            </div>
                        </div>
                    </div>
                    <br>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
<script type="text/javascript">

    BUI.use('common/page'); //页面链接跳转
    BUI.use('bui/form', function (Form) {
        var form = new Form.HForm({
            srcNode: '#personalDetails_Form'
        });
        form.render();
    });
</script>


</html>