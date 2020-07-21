<!DOCTYPE html>
<%@pagecontentType="text/html;charset=UTF-8" %>
<bean:define id="ctx" value="<%=request.getContextPath() %>"/>
<%@page import="com.company.example.springbootdemo.entity.LoginVO" %>
<%@page import="com.company.example.springbootdemo.util.CommonConstant" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>用户列表查询</title>

    <link rel="stylesheet" type="text/css" href="${ctx}/company/assets/css/dpl.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/company/assets/css/bui.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/company/assets/css/main.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/company/assets/css/toastr.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/company/assets/css/page-min.css"/>
    <script type="text/javascript" src="${ctx}/company/assets/js/jquery-1.8.1.min.js"></script>
    <script type="text/javascript" src="${ctx}/company/assets/js/bootstrap.js"></script>
    <script type="text/javascript" src="${ctx}/company/assets/js/bui-min.js"></script>
    <script type="text/javascript" src="${ctx}/company/assets/js/toastr.js"></script>
    <script type="text/javascript" src="${ctx}/company/assets/js/jquery.twbsPagination.js"></script>
    <script type="text/javascript" src="${ctx}/company/assets/js/netsign.js"></script>
    <style type="text/css">
        html {
            /*overflow-x: scroll;*/
            overflow-y: scroll;
        }

        body {
            font-family: "Microsoft YaHei";
            width: 1209px;
        }

        .controls .input-small {
            font-family: "Microsoft YaHei";
        }

        .controls .input-small option {
            font-family: "Microsoft YaHei";
        }

        html {
            overflow-y: scroll;
        }

        .reslist {
            margin: 10px 20px;
        }

        .table-bordered th {
            text-align: center;
        }

        .table-bordered td {
            text-align: center;
        }

        .btnSearchStyle {
            color: #ffffff;
            background-color: #6cb5f4;
            border-color: #54a9f2;
        }

        .btnSearchStyle:hover {
            color: #ffffff;
            background-color: #3d9df0;
            border-color: #1b8cee
        }

        .btnSearchStyle:active {
            background-image: none;
        }

        .tableBtn {
            border: 1px solid #3d9df0;
            border-radius: 5px;
            color: #3d9df0;
            background-color: #ffffff;
            font-size: 12px;
        }

        .tableBtn:hover {
            color: #ffffff;
            background-color: #3d9df0;
            border-color: #ffffff
        }
    </style>
</head>
<%
    LoginVO user = (LoginVO) request.getSession(false).getAttribute(CommonConstant.SESSION_USER);
%>
<body>
<hr>
<div class="row detail-row">
    <div class="span84">
        <form id="searchForm" class="form-horizontal" tabindex="0" style="outline: none;" method="post"
              action='<c:url value="/companymanager/searchoutcomeinfomation"/>'>
            <input type="hidden" id="noUkey" value="${noUkey}"/>
            <input type="hidden" name="ukey" id="ukey" value=""/>
            <input type="hidden" name="plain" id="plain" value=""/>
            <input type="hidden" value="${_csrf.token}" name="${_csrf.parameterName}"/>
            <input type="hidden" name="errMsg" id="errMsg" value="${errMsg}"/>
            <input type="hidden" name="notUserdetail" id="notUserdetail" value="${notUserdetail}"/>
            <div class="row">
                <div class="control-group span15">
                    <label class="control-labels">成果名称：</label>
                    <div class="controls">
                        <input type="text" name="userId" id="searchName" class="control-text input-smlength"
                               value="${conditionUserId}" data-rules="{maxlength:20}"/>
                    </div>
                </div>
                <div class="form-actions span4">
                    <button id="btnSearch" type="button" class="searchBtn btnSearchStyle button button-primary">搜 索
                    </button>
                    <button type="reset" style="margin-left: 10px" class="button button-primary btnSearchStyle">重置
                    </button>
                </div>
            </div>
        </form>

        <form id="upSearchForm" method="post" action='<c:url value="/searchSubRegionDetail"/>'>
            <input type="hidden" id="uptUserId" name="uptUserId"/>
            <input type="hidden" name="ukey" id="upSearchIdKey" value=""/>
            <input type="hidden" name="plain" id="upSearchIdPlain" value=""/>
        </form>
        <form id="showSearchForm" method="post" action='<c:url value="/searchSubRegionDetail"/>'>
            <input type="hidden" id="showUserId" name="showUserId"/>
            <input type="hidden" name="ukey" id="showSearchIdKey" value=""/>
            <input type="hidden" name="plain" id="showSearchIdPlain" value=""/>
        </form>

    </div>
</div>

<hr>

<div class="span24 doc-content reslist">

    <table cellspacing="0" class="table table-bordered txtCenter">
        <thead>
        <tr>
            <th> 成果名称</th>
            <th> 所属领域</th>
            <th> 合作方式</th>
            <th> 交易价格</th>
            <th> 应用行业</th>
            <th> 成熟度</th>
            <th> 操 作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="subuser" items="${userList}">
            <tr>
                <td>${subuser.creatorUserId}</td>
                <td>${subuser.userId}</td>
                <td>${subuser.userName}</td>
                <td>${subuser.department}</td>
                <td>${subuser.userTypeStr}</td>
                <td>${subuser.userStatusStr}</td>
                <td>
                    <button id="btn_upd" type="button" class=" tableBtn" onclick="btn_upd('${subuser.userId}')">
                        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>申请评价
                    </button>
                        <%--<button id="btn_showDetail" style="margin-left: 6px" class="tableBtn" type="button"--%>
                        <%--onclick="btn_showDetail('${subuser.userId}')">--%>
                        <%--<i class="glyphicon glyphicon-remove"></i> 查 看--%>
                        <%--</button>--%>
                </td>
            </tr>
        </c:forEach>
        </tbody>
        <tbody id="nomess">
        <tr>
            <td colspan="11" style="text-align: center;"><font color="red"><Strong>无消息！</Strong></font></td>
        </tr>
        </tbody>
    </table>
</div>
</body>
<script type="text/javascript">

    function btn_upd(data) {
        $('#uptUserId').val(data);
        $('#upSearchForm').submit();

    }

    function btn_showDetail(data) {
        $('#showUserId').val(data);
        $('#showSearchForm').submit();
    };

    <%------------------消息提示区域--------------------%>

    <%-----------消息提示JS----------%>
    $(function () {
        toastr.options = {
            "closeButton": true, //是否显示关闭按钮
            "debug": false, //是否使用debug模式
            "positionClass": "toast-center-center",//弹出窗的位置
            "showDuration": "300",//显示的动画时间
            "hideDuration": "1000",//消失的动画时间
            "timeOut": "5000", //展现时间
            "extendedTimeOut": "1000",//加长展示时间
            "showEasing": "swing",//显示时的动画缓冲方式
            "hideEasing": "linear",//消失时的动画缓冲方式
            "showMethod": "fadeIn",//显示时的动画方式
            "hideMethod": "fadeOut" //消失时的动画方式
        };

    })
    <%------------------------------%>
    BUI.use('bui/form', function (Form) {
        var form = new Form.HForm({
            srcNode: '#searchForm'
        });
        form.render();
    });


    if ($("#noval").val() != '') {
        $("#nomess").hide();
    } else {
        $("#nomess").show();
    }

    if ($("#npage").val() != '' && $("#tpage").val() != '' && $("#tpage").val() != 0) {

        $("#showalp").show();
    }


    $(function () {
        var errMsg = $("#errMsg").val();
        if (errMsg != "" && errMsg == "未查询到用户信息") {
            toastr.error("当前查询条件未查询到用户信息!");
        } else if (errMsg != "" && errMsg == "查询子用户异常,请重试或联系系统管理员") {
            toastr.error("查询子用户异常,请重试或联系系统管理员!");
        }
    });
    $(function () {
        var notUserdetail = $("#notUserdetail").val();
        if (notUserdetail != "" && notUserdetail == "未查询到该用户详情") {
            toastr.error("未查询到当前用户的详情信息!");
        }
    });

</script>

</html>
