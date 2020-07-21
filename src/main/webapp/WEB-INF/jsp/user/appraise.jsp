<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/3
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@pagecontentType="text/html;charset=UTF-8" %>
<bean:define id="ctx" value="<%=request.getContextPath() %>"/>
<%@page import="com.travelsky.blackpsg.user.UserVo" %>
<%@page import="com.travelsky.blackpsg.web.util.CommonConstants" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ResourceBundle" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>用户列表查询</title>

    <link rel="stylesheet" type="text/css" href="${ctx}/assets/css/dpl.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/assets/css/bui.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/assets/css/main.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/assets/css/toastr.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/assets/css/page-min.css"/>
    <script type="text/javascript" src="${ctx}/assets/js/jquery-1.8.1.min.js"></script>
    <script type="text/javascript" src="${ctx}/assets/js/bootstrap.js"></script>
    <script type="text/javascript" src="${ctx}/assets/js/bui-min.js"></script>
    <script type="text/javascript" src="${ctx}/assets/js/toastr.js"></script>
    <script type="text/javascript" src="${ctx}/assets/js/jquery.twbsPagination.js"></script>
    <script type="text/javascript" src="${ctx}/assets/js/netsign.js"></script>
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
    UserVo user = (UserVo) request.getSession(false).getAttribute(CommonConstants.SESSIONUSERVALUE);
    List<UserVo> reslist = (List<UserVo>) request.getAttribute("reslist");
%>
<%ResourceBundle res = ResourceBundle.getBundle("udisk_application"); %>
<%String infoSecNetSignStatus = res.getString("InfoSecNetSignStatus");%>
<body>
<hr>
<div class="row detail-row">
    <div class="span84">
        <form id="searchForm" class="form-horizontal" tabindex="0" style="outline: none;" method="post"
              action='<c:url value="/showSubUserOfRegion"/>'>
            <input type="hidden" id="noUkey" value="${noUkey}"/>
            <input type="hidden" name="ukey" id="ukey" value=""/>
            <input type="hidden" name="plain" id="plain" value=""/>
            <input type="hidden" value="${_csrf.token}" name="${_csrf.parameterName}"/>
            <input type="hidden" name="errMsg" id="errMsg" value="${errMsg}"/>
            <input type="hidden" name="notUserdetail" id="notUserdetail" value="${notUserdetail}"/>
            <div class="row">
                <div class="control-group span7">
                    <label class="control-labels">用户名：</label>
                    <div class="controls">
                        <input type="text" name="userId" id="searchName" class="control-text input-smlength"
                               value="${conditionUserId}" data-rules="{maxlength:20}"/>
                    </div>
                </div>
                <div class="control-group span7">
                    <label class="control-labels">姓名：</label>
                    <div class="controls">
                        <input type="text" name="userName" id="searchUserName" class="control-text input-smlength"
                               value="${conditionUserName}" data-rules="{maxlength:20}"/>
                    </div>
                </div>
                <div class="control-group span6">
                    <label class="control-labels">用户状态：</label>
                    <div class="controls">
                        <select name="userStatus" class="input-smalls" id="fl">
                            <option value="" <c:if test="${conditionUserStatus==''}">selected="selected"</c:if>>全部
                            </option>
                            <option value="1" <c:if test="${conditionUserStatus==1}">selected="selected"</c:if>>启用
                            </option>
                            <option value="0" <c:if test="${conditionUserStatus==0}">selected="selected"</c:if>>禁用
                            </option>
                        </select>
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
            <th> 创建者</th>
            <th> 用户名</th>
            <th> 用户姓名</th>
            <th> 所属部门</th>
            <th> 用户类型</th>
            <th> 用户状态</th>
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
                        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>修 改
                    </button>
                    <button id="btn_showDetail" style="margin-left: 6px" class="tableBtn" type="button"
                            onclick="btn_showDetail('${subuser.userId}')">
                        <i class="glyphicon glyphicon-remove"></i> 查 看
                    </button>
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
<%-- 判断用户浏览器，下载不同类型插件（IE32、IE64、火狐） ↓--%>
<%if (infoSecNetSignStatus.equals("open")) {%>
<%
    String userAgent = request.getHeader("User-Agent").toUpperCase();
    //先判断用户是否需要U盾认证
    if (userAgent.indexOf("FIREFOX") >= 0 || userAgent.indexOf("CHROME") >= 0
            || userAgent.indexOf("Firefox") >= 0 || userAgent.indexOf("Chrome") >= 0) {
%>
<embed id="InfoSecNetSign1" type="application/infosec-netsign-plugin" width="0" height="0"/>
<%
} else if (userAgent.indexOf("x64") >= 0) {
%>
<OBJECT id="InfoSecNetSign1" codeBase="/mhjdefend/netsign/NetSign20_64.cab#version=2,0,59,2"
        data=data:application/x-oleobject;base64,xDi5s5BBN0+M8KkrCpHMdwADAACyHgAA/wIAAA==
        classid=clsid:AA6BA3FC-3428-4443-B7AB-D2A85AF20250 width="0" height="0">
</OBJECT>
<%
} else {
%>
<OBJECT id="InfoSecNetSign1" codeBase="/mhjdefend/netsign/NetSign20.cab#version=2,0,59,2"
        classid=clsid:B3B938C4-4190-4F37-8CF0-A92B0A91CC77 width="0" height="0">
</OBJECT>
<%
    }

%>
<%}%>
</body>
<script type="text/javascript">

    function btn_upd(data) {
//        console.log(data)
        $('#uptUserId').val(data);
        <%if(infoSecNetSignStatus.equals("open")){%>
        var usignstr = buttonAttachedSign_onclick('abc');
        $("#upSearchIdKey").val(usignstr);
        <%}else{%>
        $("#upSearchIdKey").val("-10005");
        <%}%>
        $("#upSearchIdPlain").val('abc');
        $('#upSearchForm').submit();

    }

    function btn_showDetail(data) {
//        console.log(data)
        $('#showUserId').val(data);
        <%if(infoSecNetSignStatus.equals("open")){%>
        var usignstr = buttonAttachedSign_onclick('abc');
        $("#upSearchIdKey").val(usignstr);
        <%}else{%>
        $("#upSearchIdKey").val("-10005");
        <%}%>
        $("#upSearchIdPlain").val('abc');
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

    function uk() {
        //开始验证U盾信息流程
        <%if(infoSecNetSignStatus.equals("open")){%>
        var usignstr = buttonAttachedSign_onclick('abc');
        $("#ukey").val(usignstr);
        <%}else{%>
        $("#ukey").val('-10005');
        <%}%>
        $("#plain").val('abc');
    }

    $('.searchBtn').click(function () {
        uk();
        $('#searchForm').submit();
    });

    $(function () {
        var noUkey = $("#noUkey").val();
        if (noUkey != "" && noUkey == "没有检测到U盾，或者U盾验证失败!") {
            toastr.error("没有检测到U盾，或者U盾验证失败!");
        }
    });


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
