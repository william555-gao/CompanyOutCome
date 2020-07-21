<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@pagecontentType="text/html;charset=UTF-8" %>
<bean:define id="ctx" value="<%=request.getContextPath() %>"/>
<%@page import="com.company.example.springbootdemo.entity.LoginVO " %>
<%@page import="com.company.example.springbootdemo.util.CommonConstant " %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

    <title>Company Outcome System</title>

    <link href="${ctx}/company/assets/css/dpl-min.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/company/assets/css/bui-min.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/company/assets/css/main-min.css" rel="stylesheet" type="text/css"/>
</head>
<style>
    html {
        overflow-x: scroll;
        overflow-y: scroll;
    }

    body {
        font-family: "Microsoft YaHei";
    }

</style>
<%
    LoginVO user = (LoginVO) request.getSession(false).getAttribute(CommonConstant.SESSION_USER);
%>

<body>

<div class="header">
    <div class="dl-title">
        <span class="first">Company Outcome System</span>
    </div>
    <div class="dl-log"><i class="icon-user icon-white"></i>welcome:<span
            class="dl-log-user"><%=user != null ? user.getUsername() : "未登陆用户" %></span><a
            href="${ctx}/company/out_ls?m=Public&a=logout" title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
</div>

<div class="content">

    <ul id="J_NavContent" class="dl-tab-conten">

    </ul>
</div>
<script type="text/javascript" src="${ctx}/company/assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="${ctx}/company/assets/js/bui-min.js"></script>
<script type="text/javascript" src="${ctx}/company/assets/js/common/main-min.js"></script>
<script type="text/javascript" src="${ctx}/company/assets/js/config-min.js"></script>
<script type="text/javascript" src="${ctx}/company/assets/js/netsign.js"></script>


<script type="text/javascript">
    BUI.use('common/main', function () {

        var config = [{
            /* homePage:'12', //默认打开的页面 */
            id: 'menu',
            collapsed: false,  //左侧菜单收缩
            menu: [
                <%if(CommonConstant.COMPANY_USER.equals(user.getUsertype())) {%>
                {
                    text: '企业成果',
                    items: [
                        {id: '11', text: '成果信息录入', href: "/company/forward/addcompanyoutcomeinformation"},
                        {id: '12', text: '成果评价申请', href: '/company/forward/companyoutcomepublish'}
                    ]
                },
                <%}%>
                <%if(CommonConstant.MANAGER_USER.equals(user.getUsertype())){%>
                {
                    text: '企业成果审核',
                    items: [
                        {id: '21', text: '审核/上传', href: '/company/forward/check'},
                    ]
                },
                <%}%>
                <%if(CommonConstant.PROFESSOR_USER.equals(user.getUsertype())){%>
                {
                    text: '企业成果评价',
                    items: [
                        {id: '31', text: '评价/上传', href: '/company/forward/appraise'},
                    ]
                },
                <%}%>
                {
                    text: '用户详情展示',
                    items: [
                        {id: '41', text: '个人详情', href: '/company/forward/personalDetails'},
                    ]
                },
            ]
        },

        ];
        new PageUtil.MainPage(
            {
                modulesConfig: config
            });
    });

</script>


</body>
<script type="text/javascript">
    $(document).ready(function () {

        window.history.forward(1);

        //OR

        window.history.forward(-1);

    });


    function myrefresh() {
        window.location.reload();
    }

    setTimeout('myrefresh()', 1740000);
</script>
</html>