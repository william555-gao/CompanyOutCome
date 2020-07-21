<!DOCTYPE html>
<%@pagecontentType="text/html;charset=UTF-8" %>
<bean:define id="ctx" value="<%=request.getContextPath() %>"/>
<%@page import="com.company.example.springbootdemo.entity.LoginVO" %>
<%@page import="com.company.example.springbootdemo.util.CommonConstant" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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

    .bui-dialog .bui-ext-close-x {
        display: none;
    }
</style>
<%
    LoginVO user = (LoginVO) request.getSession(false).getAttribute(CommonConstant.SESSION_USER);
%>

<body>
<div class="demo-content" id="addUserBody">
    <div class="row">
        <div class="span24 doc-content">
            <form class="form-horizontal well" id="add_Form" method="post"
                  action='<c:url value="/companymanager/savecompanyoutcomeinformation"/>'>
                <input type="hidden" id="loginNameSpan" value=""/>
                <input type="hidden" id="nodate" value="${nodate}"/>
                <input type="hidden" id="noUkey" value="${noUkey}"/>
                <input type="hidden" id="reachTheLimit" value="${reachTheLimit}"/>
                <input type="hidden" name="ukey" id="ukey" value=""/>
                <input type="hidden" name="plain" id="plain" value=""/>
                <input type="hidden" value="${_csrf.token}" name="${_csrf.parameterName}"/>
                <input type="hidden" name="orgAirports" id="orgAirports" value=""/>
                <input type="hidden" name="dstAirports" id="dstAirports" value=""/>
                <input type="hidden" name="javaStime" id="javaStime"
                       value=""/>
                <input type="hidden" id="javaSdata"
                       value=""/>
                <input type="hidden" name="javaEtime" id="javaEtime"
                       value=""/>
                <input type="hidden" name="validNum" id="validNum" value="${validNum}"/>
                <input type="hidden" name="validMsgNum" id="validMsgNum" value="${validMsgNum}"/>
                <input type="hidden" id="subSearchNum" value="${validNum + userDetail.numberSearch}"/>
                <input type="hidden" name="saveSuccess" id="saveSuccess" value="${saveSuccess}"/>
                <input type="hidden" name="saveUNSuccess" id="saveUNSuccess" value="${saveUNSuccess}"/>
                <input type="hidden" id="getAirData" value=""/>
                <input type="hidden" id="dstAirData" value=""/>
                <div class="row">
                    <div class="control-group span12">
                        <label class="control-label">成果名称：</label>
                        <div class="controls">
                            <input name="outcomeName" id="outcomeName" maxlength="20" style="width: 200px"
                                   autocomplete="off"
                                   value="" type="text" onkeyup="checkUserName()"
                                   class="input-normal control-text">
                            <span id="outcomeSpan" style="color: red">*</span>
                        </div>
                    </div>
                    <div class="control-group span12">
                        <label class="control-label">交易价格：</label>
                        <div class="controls">
                            <input name="trandsactionPrice" id="trandsactionPrice" style="width: 200px" maxlength="16"
                                   autocomplete="off"
                                   value="" onkeyup="checkPosition()" type="text"
                                   class="input-normal control-text">
                            <span id="priceSpan" style="color: red">*</span>
                        </div>
                    </div>
                    <div class="control-group span12">
                        <label class="control-label">成熟度：</label>
                        <div class="controls">
                            <input name="maturity" maxlength="20" style="width: 200px" id="maturity"
                                   onkeyup="depaidIptMethod()" value="${addUserOfRegionForm.addDepartCode}" type="text"
                                   class="input-normal control-text">
                            <span id="maturitySpan" style="color: red">*</span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="control-group span12">
                        <label class="control-label">高新技术领域：</label>
                        <div class="controls" id="domainDiv">
                            <select class="input-middle" name="domain" id="domain">
                                <option value="">--请选择--</option>
                                <c:forEach items="${technosphereList}" var="technosphere">
                                    <option value="${technosphere.technosphereName}">${technosphere.technosphereName}</option>
                                </c:forEach>
                            </select>
                            <span id="domainSpan" style="color: red">*</span>
                        </div>
                    </div>
                    <div class="control-group span12">
                        <label class="control-label">合作方式：</label>
                        <div class="controls" id="cooperationDiv">
                            <select class="input-middle" name="cooperation" id="cooperation">
                                <option value="">--请选择--</option>
                                <option value="企业合作网络">企业合作网络</option>
                                <option value="战略联盟">战略联盟</option>
                                <option value="供需链管理">供需链管理</option>
                                <option value="企业集团">企业集团</option>
                                <option value="业务外包">业务外包</option>
                                <option value="虚拟企业">虚拟企业</option>
                            </select>
                            <span id="cooperationSpan" style="color: red">*</span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="control-group span12">
                        <label class="control-label">应用行业：</label>
                        <div class="controls" id="useTypeDiv">
                            <select class="input-middle" name="useType" id="useType">
                                <option value="">--请选择--</option>
                                <c:forEach items="${industryList}" var="industry">
                                    <option value="${industry.industryName}">${industry.industryName}</option>
                                </c:forEach>
                            </select>
                            <span id="useTypeSpan" style="color: red">*</span>
                        </div>
                    </div>
                </div>
                <%--按钮--%>
                <div class="row" style="margin-bottom: 50px">
                    <div class="form-actions offset3">
                        <button type="button" class="button button-primary addFormSub">提交</button>
                        <button type="reset" class="button resdown " onclick="addFormReset()">重置</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    var array = [];
    var arr = [];
    var checkArr = [];
    var psdArr = [];
    var airportArr = "";
    var changeFlag = false;
    var airportList = "";
    var airportAndCnName = {};
    <%
        String aiports =(String) request.getAttribute("airportJson");
   %>
    $(function () {
        toastr.options = {
            "closeButton": true, //是否显示关闭按钮
            "debug": false, //是否使用debug模式
            "positionClass": "toast-center-center",//弹出窗的位置
            "showDuration": "3000",//显示的动画时间
            "hideDuration": "1000",//消失的动画时间
            "timeOut": "5000", //展现时间
            "extendedTimeOut": "1000",//加长展示时间
            "showEasing": "swing",//显示时的动画缓冲方式
            "hideEasing": "linear",//消失时的动画缓冲方式
            "showMethod": "fadeIn",//显示时的动画方式
            "hideMethod": "fadeOut" //消失时的动画方式
        };
        $("input[type='text']").each(function (i) {
            array[i] = $(this).val();
        });
        $('select').each(function (i) {
            arr[i] = $(this).val();
        });
        $("input[type='checkbox']").each(function (i) {
            checkArr[i] = $(this).is(':checked');
        });
        $("input[type='password']").each(function (i) {
            psdArr[i] = $(this).val();
        });
    });

    BUI.use('common/page'); //页面链接跳转
    BUI.use('bui/form', function (Form) {
        var form = new Form.HForm({
            srcNode: '#add_Form'
        });
        form.render();
    });

    function addFormReset() {
        console.log('重置')
        $("input[type='text']").each(function (i) {
            $(this).val(array[i]);
        });
        $('select').each(function (i) {
            $(this).val(arr[i]);
        });
        $("input[type='checkbox']").each(function (i) {
            if (checkArr[i]) {
                $(this).attr("checked", "checked");
            } else {
                $(this).removeAttr("checked");
            }

        });
        $("input[type='password']").each(function (i) {
            $(this).val(psdArr[i]);
        });
        $('#addAirStart,.selectpicker').selectpicker('val', arr[3]);
        $('#addAirStart,.selectpicker').selectpicker('refresh');
        $('#addAirEnd,.selectpicker').selectpicker('val', arr[4]);
        $('#addAirEnd,.selectpicker').selectpicker('refresh');
        $("#addDataTotal").attr("readonly", "readonly");
        $("#airportCode").html("");
        $("#airportCode").append(airportList);
        checkPasswordStrength();
    }

    BUI.use('bui/overlay', function (Overlay) {
        function showMsg(msg) {
            BUI.Message.Alert(msg, 'warning');
        };
        var dialog = new Overlay.Dialog({
            title: '消息提示！',
            width: 300,
            height: 200,
            mask: false,
            buttons: [
                {
                    text: '确定',
                    elCls: 'button button-primary',
                    handler: function () {
//                        top.topManager.setPageTitle("用户新建>用户管理");
                        if (top.topManager) {
//                            top.topManager.closePage('main-menu');
                            top.topManager.openPage({
                                id: '52',
                                isClose: true
                            });
                        }
                        this.close();

                    }
                }
            ],

            bodyContent: '<p>已达到用户创建上限！</p>'
        });
        var saveSucclog = new Overlay.Dialog({
            title: '消息提示！',
            width: 300,
            height: 200,
            mask: false,
            buttons: [
                {
                    text: '确定',
                    elCls: 'button button-primary',
                    handler: function () {
                        if (top.topManager) {
                            top.topManager.openPage({
                                id: '52',
                                isClose: true
                            });
                        }
                        this.close();
                    }
                }
            ],

            bodyContent: '<p>创建用户成功！</p>'
        });
        var saveFaillog = new Overlay.Dialog({
            title: '消息提示！',
            width: 300,
            height: 200,
            mask: false,
            buttons: [
                {
                    text: '确定',
                    elCls: 'button button-primary',
                    handler: function () {
                        if (top.topManager) {
                            top.topManager.openPage({
                                id: '52',
                                isClose: true
                            });
                        }
                        this.close();

                    }
                }
            ],
            bodyContent: '<p>创建用户失败,请重试或联系系统管理员！</p>'
        });
        var reachTheLimit = $("#reachTheLimit").val();
        var saveSuccess = $("#saveSuccess").val();
        var saveUNSuccess = $("#saveUNSuccess").val();
        if (reachTheLimit != "" && reachTheLimit == "已达到用户创建上限") {
            dialog.show();
            $('#addUserBody').hide()
        } else if (reachTheLimit != "" && reachTheLimit == "获取区域用户异常,请联系系统管理员") {
            toastr.error("获取区域用户已创建子用户数量异常,请联系系统管理员!");
        } else if (reachTheLimit != "" && reachTheLimit == "当前区域用户未查询到,请重试或联系系统管理员") {
            toastr.error("未获取到当前区域用户相关信息,请联系系统管理员!");
        } else if (saveSuccess != "" && saveSuccess == "创建用户成功") {
            $('#addUserBody').hide();
            saveSucclog.show();
        } else if (saveUNSuccess != "" && saveUNSuccess == "创建用户失败") {
            saveFaillog.show();
        } else if (saveUNSuccess != "" && saveUNSuccess == "创建用户异常,请重试或联系系统管理员") {
            toastr.error("创建数据用户异常,请重试或联系系统管理员!");
        }
    });
    javaSdata = $('#javaSdata').val();
    var mxdate = $("#javaEtime").val();
    BUI.use('bui/calendar', function (Calendar) {
        var datepicker = new Calendar.DatePicker({
            trigger: '#edate',
            minDate: javaSdata,
            maxDate: mxdate,
            autoRender: true
        });
    });
    var startAirIptFlag = true;
    var endAirIptFlag = true;
    $(function () {
        var getAirData = $("#getAirData").val();
        var dstAirData = $("#dstAirData").val();
        if (getAirData == '') {
            $('#addAirStart').replaceWith('<input id="addAirStart" onkeyup="checkStartAirPort()" onblur="checkRepeatStartAirport()" style="width: 200px; text-transform: uppercase;" type="text" class="input-normal control-text"> ')
            $("#getAirSpan").replaceWith('<span id="getAirSpan" style="color: red"></span>');
        }
        if (dstAirData == '') {
            $('#addAirEnd').replaceWith('<input id="addAirEnd"  onkeyup="checkEndAirPort()" onblur="checkRepeatEndAirport()" style="width: 200px; text-transform: uppercase;"  type="text" class="input-normal control-text"> ')
            $("#endAirSpan").replaceWith(' <span id="endAirSpan" style="color: red"></span>');
        }
        var validMsgNum = $("#validMsgNum").val();
        $("#validMsgNumSpan").text("剩余数据量:" + validMsgNum);
        var validNum = $("#validNum").val();
        $("#validNumSpan").text("次/月 剩余查询次数:" + validNum);
        $(".selectpicker").selectpicker({
            noneSelectedText: '请选择机场'
        });
        airportArr = $("#airportDiv").html();
        airportList = $("#airportCode").html();
        var air = <%=aiports %>;
        for (var key in air) {
            var List = air[key];
            airportAndCnName[List.code] = List.cnName;
        }
    });


    //用户名验证
    var userNameFlag = false;

    function checkUserName() {
        var reg = /(^[a-zA-Z]{1,20}$)|(^[\u4e00-\u9fa5]{1,10}$)/;
        if (reg.test($("#userName").val())) {
            $("#userNameTemp").remove();
            userNameFlag = true;
        } else {
            $("#userNameTemp").remove();
            $("#userNameSpan").after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="userNameTemp"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请输入姓名不超过20位的字母或不超过10位的汉字！</em></span></span> ');
        }
    }

    //所属部门验证
    var departFlag = false;

    function checkDepartment() {
        var reg = /^[0-9a-zA-Z\u4e00-\u9fa5]+$/;
        if (reg.test($("#department").val())) {
            $("#departTemp").remove();
            departFlag = true;
        } else {
            $("#departTemp").remove();
            $("#departSpan").after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="departTemp"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请输入少于30位的字母，汉字或数字的部门名称！</em></span></span> ');
        }
    }

    //邮箱验证
    var emailFlag = false;

    function checkEmail() {
        var reg = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
        if (reg.test($("#email").val())) {
            $("#emailTemp").remove();
            emailFlag = true;
        } else {
            $("#emailTemp").remove();
            $("#emailSpan").after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="emailTemp"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请正确输入邮箱信息！</em></span></span> ');
        }
    }

    //职位验证
    var positionFlag = false;

    function checkPosition() {
        var reg = /^[0-9a-zA-Z\u4e00-\u9fa5]+$/;
        if (reg.test($("#position").val())) {
            $("#positionTemp").remove();
            positionFlag = true;
        } else {
            $("#positionTemp").remove();
            $("#positionSpan").after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="positionTemp"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请输入少于16位的字母,数字或汉字的职位名称！</em></span></span> ');
        }
    }

    //电话号码验证
    var phoneFlag = false;

    function checkPhone() {
        var reg = /^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\d{8}$/;
        if (reg.test($("#phone").val())) {
            $("#phoneTemp").remove();
            phoneFlag = true;
        } else {
            $("#phoneTemp").remove();
            $("#phoneSpan").after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="phoneTemp"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请输入正确的电话！</em></span></span> ');
        }
    }

    //密码验证
    var passOneFlag = false;

    function checkPassWord() {
        var reg = /^[0-9a-zA-Z]+$/;
        if (reg.test($("#addPassOne").val())) {
            $("#passOneTemp").remove();
            passOneFlag = true;
            checkPasswordStrength();
        } else {
            $("#passOneTemp").remove();
            $("#passOneSpan").after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="passOneTemp"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请输入少于12位的字母或数字的密码!</em></span></span> ');
        }
    }

    var passwordFlag = true;

    function checkPasswordStrength() {
        var pwd = $("#addPassOne").val();
        var Mcolor, Wcolor, Scolor, Color_Html;
        var m = 0;
        //匹配数字
        if (/\d+/.test(pwd)) {
            m++;
        }
        ;
        //匹配字母
        if (/[A-Za-z]+/.test(pwd)) {
            m++;
        }
        ;
        //匹配字母和数字的长度
        if (pwd.length > 10) {
            m++;
        }
        ;

        if (pwd.length <= 6) {
            m = 1;
        }
        if (pwd.length <= 0) {
            m = 0;
        }
        switch (m) {
            case 1:
                Wcolor = "pwd pwd_Weak_c";
                Mcolor = "pwd pwd_c";
                Scolor = "pwd pwd_c pwd_c_r";
                Color_Html = "弱";
                passwordFlag = false;
                $("#passOneTemp").remove();
                $("#passOneSpan").after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="passOneTemp"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>密码强度过低，请重新输入密码!</em></span></span> ');
                break;
            case 2:
                Wcolor = "pwd pwd_Medium_c";
                Mcolor = "pwd pwd_Medium_c";
                Scolor = "pwd pwd_c pwd_c_r";
                Color_Html = "中";
                passwordFlag = true;
                break;
            case 3:
                Wcolor = "pwd pwd_Strong_c";
                Mcolor = "pwd pwd_Strong_c";
                Scolor = "pwd pwd_Strong_c pwd_Strong_c_r";
                Color_Html = "强";
                passwordFlag = true;
                break;
            default:
                Wcolor = "pwd pwd_c";
                Mcolor = "pwd pwd_c pwd_f";
                Scolor = "pwd pwd_c pwd_c_r";
                Color_Html = "无";
                break;
        }
        document.getElementById('pwd_Weak').className = Wcolor;
        document.getElementById('pwd_Medium').className = Mcolor;
        document.getElementById('pwd_Strong').className = Scolor;
        document.getElementById('pwd_Medium').innerHTML = Color_Html;
    }

    //区域用户没有配置始发机场 对输入的机场进行校验

    function checkStartAirPort() {
        var reg7 = /^[a-zA-Z]{3}$/;
        var orgAirports = $('#addAirStart').val();
        var orgAirportsArr = [];
        orgAirportsArr = orgAirports.split("/");
        var orgAirportsArrLen = orgAirportsArr.length;
        for (var i = 0; i < orgAirportsArrLen; i++) {
            orgAirportsArr[i] = orgAirportsArr[i].toUpperCase();
            if (!reg7.test(orgAirportsArr[i])
                && $('#addAirStart').val() != "") {
                startAirIptFlag = false;
                $('#airStartTemp').remove();
                $("#startAirportTemper").remove();
                $('#getAirSpan').after('<span class="valid-text"><span class="estate error" id="airStartTemp"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请填写正确的机场信息并以/隔开</em></span></span> ');
                break;
            } else {
                startAirIptFlag = true
                $('#airStartTemp').remove();
            }
        }

    }

    //区域用户没有配置到达机场 对输入的机场进行校验

    function checkEndAirPort() {
        var reg7 = /^[a-zA-Z]{3}$/;
        var dstAirports = $('#addAirEnd').val();
        var dstAirportsArr = [];
        dstAirportsArr = dstAirports.split("/");
        var dstAirportsArrLen = dstAirportsArr.length;
        for (var i = 0; i < dstAirportsArrLen; i++) {
            dstAirportsArr[i] = dstAirportsArr[i].toUpperCase();
            if (!reg7.test(dstAirportsArr[i])
                && $('#addAirEnd').val() != "") {
                endAirIptFlag = false
                $('#airEndTemp').remove();
                $("#endAirportTemper").remove();
                $('#endAirSpan').after('<span class="valid-text"><span class="estate error" id="airEndTemp"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请填写正确的机场信息并以/隔开</em></span></span> ');
                break;
            } else {
                endAirIptFlag = true;
                $('#airEndTemp').remove();
            }
        }

    }

    //始发机场重复性校验
    var startAirportFlag = true;

    function checkRepeatStartAirport() {
        var startAirport = $("#addAirStart").val();
        var startAirportArr = startAirport.split("/");
        var startAirportLen = startAirportArr.length;
        var startRepeatFlag = false;
        var airportListArr = [];
        $("#airportCode option").each(function () {
            if ($(this).val() != "") {
                airportListArr.push($(this).val());
            }
        });
        for (var index = 0; index < startAirportLen - 1; index++) {
            for (var nextIndex = index + 1; nextIndex < startAirportLen; nextIndex++) {
                if (startAirportArr[index].toUpperCase() == startAirportArr[nextIndex].toUpperCase()) {
                    startRepeatFlag = true;
                    break;
                }
            }
            if (startRepeatFlag) {
                break;
            }
        }
        if (startRepeatFlag) {
            startAirportFlag = false;
        } else {
            startAirportFlag = true;
            var startReg = /^[a-zA-Z]{3}$/;
            for (var index = 0; index < startAirportLen; index++) {
                if (startAirportArr[index].toUpperCase() != "" && startReg.test(startAirportArr[index].toUpperCase())) {
                    if (airportListArr.indexOf(startAirportArr[index].toUpperCase()) == -1) {
                        $("#airportCode").append("<option  value=" + startAirportArr[index].toUpperCase() + ">" + startAirportArr[index].toUpperCase() + '(' + airportAndCnName[startAirportArr[index].toUpperCase()] + ')' + "</option>");
                    }
                }
            }
        }
        if (!startAirportFlag) {
            $("#startAirportTemper").remove();
            $('#getAirSpan').after('<span class="valid-text"><span class="estate error" id="startAirportTemper"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>输入的起始机场信息含有重复项，请仔细检查！</em></span></span> ');
        } else {
            $("#startAirportTemper").remove();
        }
    }

    //到达机场重复性校验
    var endAirportFlag = true;

    function checkRepeatEndAirport() {
        var endAirport = $("#addAirEnd").val();
        var endAirportArr = endAirport.split("/");
        var endAirportLen = endAirportArr.length;
        var endRepeatFlag = false;
        var airportListArr = [];
        $("#airportCode option").each(function () {
            if ($(this).val() != "") {
                airportListArr.push($(this).val());
            }
        });
        for (var index = 0; index < endAirportLen - 1; index++) {
            for (var nextIndex = index + 1; nextIndex < endAirportLen; nextIndex++) {
                if (endAirportArr[index].toUpperCase() == endAirportArr[nextIndex].toUpperCase()) {
                    endRepeatFlag = true;
                    break;
                }
            }
            if (endRepeatFlag) {
                break;
            }
        }
        if (endRepeatFlag) {
            endAirportFlag = false;
        } else {
            endAirportFlag = true;
            var endReg = /^[a-zA-Z]{3}$/;
            for (var index = 0; index < endAirportLen; index++) {
                if (endAirportArr[index].toUpperCase() != "" && endReg.test(endAirportArr[index].toUpperCase())) {
                    if (airportListArr.indexOf(endAirportArr[index].toUpperCase()) == -1) {
                        $("#airportCode").append("<option  value=" + endAirportArr[index].toUpperCase() + ">" + endAirportArr[index].toUpperCase() + '(' + airportAndCnName[endAirportArr[index].toUpperCase()] + ')' + "</option>");
                    }
                }
            }
        }
        if (!endAirportFlag) {
            $("#endAirportTemper").remove();
            $('#endAirSpan').after('<span class="valid-text"><span class="estate error" id="endAirportTemper"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>输入的到达机场信息含有重复项，请仔细检查！</em></span></span> ');
        } else {
            $("#endAirportTemper").remove();
        }
    }

    //数据总量校验
    var maxNumFlag = true;

    function checkMaxNum() {
        var inputNum = Number($("#addDataTotal").val());
        var maxNum = Number($("#validMsgNum").val());
        var reg = /^\d{1,6}$/;
        if (!reg.test(inputNum)) {
            maxNumFlag = false;
            $("#maxtemper").remove();
            $('#validMsgNumSpan').after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="maxtemper"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>数据总量只能为数字，且最大不超过' + maxNum + '！</em></span></span> ');
        } else {
            if (inputNum > maxNum) {
                maxNumFlag = false;
                $("#maxtemper").remove();
                $('#validMsgNumSpan').after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="maxtemper"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>数据总量只能为数字，且最大不超过' + maxNum + '！</em></span></span> ');
            } else {
                maxNumFlag = true;
                $("#maxtemper").remove();
            }
        }
    }

    function clearTemp() {
        var startAirpots = $("#getAirData").val();
        var endAirpots = $("#dstAirData").val();
        var selectStartAirports = $("#addAirStart").val();
        var selectEndAirports = $("#addAirEnd").val();
        $("#startAirporttemper").remove();
        $("#endAirporttemper").remove();
        var startFlag = false;
        var endFlag = false;
        var startAirportLen = 0;
        var endAirportLen = 0;
        if (!(startAirpots === null || startAirpots == "" || startAirpots.length < 3)) {
            if (selectStartAirports === null || selectStartAirports == "") {
                $("#startAirporttemper").remove();
                $("#getAirSpan").after('<span class="valid-text"><span class="estate error" id="startAirporttemper"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请分配给数据用户始发机场</em></span></span> ');

            } else {
                startFlag = true;
            }
        }
        if (!(endAirpots === null || endAirpots == "" || endAirpots.length < 3)) {
            if (selectEndAirports === null || selectEndAirports == "") {
                $("#endAirporttemper").remove();
                $("#endAirSpan").after('<span class="valid-text"><span class="estate error" id="endAirporttemper"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请分配给数据用户到达机场</em></span></span> ');
            } else {
                endFlag = true;
            }
        }
        var airportListArr = [];
        $("#airportCode option").each(function () {
            if ($(this).val() != "") {
                airportListArr.push($(this).val());
            }
        });
        var startAirportsArray;
        var endAirportsArray;
        var startAirportsArrayLen = 0;
        var endAirportsArrayLen = 0;
        if (!(startAirpots === null || startAirpots == "" || startAirpots.length < 3)) {
            startAirportsArray = $("#addAirStart").val();
        } else {
            startAirportsArray = $("#addAirStart").val().split("/");
        }
        if (startAirportsArray != null) {
            startAirportsArrayLen = startAirportsArray.length;
        }

        if (!(endAirpots === null || endAirpots == "" || endAirpots.length < 3)) {
            endAirportsArray = $("#addAirEnd").val();
        } else {
            endAirportsArray = $("#addAirEnd").val().split("/");
        }
        if (endAirportsArray != null) {
            endAirportsArrayLen = endAirportsArray.length;
        }
        if (!(selectStartAirports === null || selectStartAirports == "")) {
            startAirportLen = startAirportsArray.length;
            for (var index = 0; index < startAirportLen; index++) {
                if (startAirportsArray[index].toUpperCase() != "") {
                    if (airportListArr.indexOf(startAirportsArray[index].toUpperCase()) == -1) {
                        $("#airportCode").append("<option  value=" + startAirportsArray[index].toUpperCase() + ">" + startAirportsArray[index].toUpperCase() + '(' + airportAndCnName[startAirportsArray[index].toUpperCase()] + ')' + "</option>");
                    }
                }
            }
        }
        if (!(selectEndAirports === null || selectEndAirports == "")) {
            endAirportLen = endAirportsArray.length;
            for (var index = 0; index < endAirportLen; index++) {
                if (endAirportsArray[index].toUpperCase() != "") {
                    if (airportListArr.indexOf(endAirportsArray[index].toUpperCase()) == -1) {
                        $("#airportCode").append("<option  value=" + endAirportsArray[index].toUpperCase() + ">" + endAirportsArray[index].toUpperCase() + '(' + airportAndCnName[endAirportsArray[index].toUpperCase()] + ')' + "</option>");
                    }
                }
            }
        }
    }

    var departIdFlag = true;

    function depaidIptMethod() {

        var reg = /^[a-zA-Z]{0,20}$/;
        if (!reg.test($('#departmentId').val())) {
            $('#temper6').remove();
            $('#departmentId').after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="temper6"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请输入少于20位的英文部门代码！</em></span></span> ')
            departIdFlag = false;
        } else {
            departIdFlag = true;
            $('#temper6').remove();
        }
    }

    function checkUserOn() {
        $('#temper1').remove();
        $('#temper2').remove();
    }

    var flag8 = false;

    function checkUserId() {
        var checkId = $("#addLoginName1").val();
        var loginNameSpan = $("#loginNameSpan").val().length;
        strLength = loginNameSpan + checkId.length
        console.log(strLength);
        var reg8 = /^[0-9a-zA-Z]{1,20}$/;
        $('#temper1').remove();
        $('#temper2').remove();
        $('#temper3').remove();
        if (!reg8.test(checkId) || checkId == '' || checkId.length > 20) {
            $('#addLoginName1Span').after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="temper1"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请输入少于20位的英文,数字组成的用户名！</em></span></span> ')
            return false
        }
        if (reg8.test(checkId) && checkId != '' && checkId.length <= 20 && checkId.indexOf(" ") == -1) {
            console.log('校验用户名！')
//            console.log(checkId);
            $.ajax({
                type: 'post',
                url: "/checkUserId",
                data: {
                    'loginName': checkId,
                    'ukey': $("#plain").val(),
                    'plain': $("#ukey").val()
                },
                success: function (data) {
                    console.log(data);
                    if (data.status == 0) {
                        flag8 = true;
                        $('#addLoginName1Span').after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="temper2"><em style="color: #5cb85c">用户名可用。</em></span></span>')
                    } else {
                        $('#addLoginName1Span').after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="temper1"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>用户名重复，请重新输入！</em></span></span> ')
                        flag8 = false;
                    }
                },
                error: function (e) {
                    flag8 = false;
                }
            })
        }
    }

    var flag15 = false;

    function getAirIptMethod() {
        $("#startAirporttemper").remove();
        $("#endAirporttemper").remove();
        var reg7 = /^[a-zA-Z]{3}$/;
//        $('#temper15').remove();
        if ($('#getAirIpt').val() != '') {
//            $('#temper15').remove();
            var getAirports = $('#getAirIpt').val();
            var getAirportsArr = [];
            getAirportsArr = getAirports.split("/");
            var getAirportsArrLen = getAirportsArr.length;
            for (var i = 0; i < getAirportsArrLen; i++) {
                if (!reg7.test(getAirportsArr[i]) && $('#getAirIpt').val() != "") {
                    if (flag15) {
                        $('#getAirSpan').after('<span style="margin-left:120px" class="valid-text"><span class="estate error" id="temper15"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请输入正确的机场信息！</em></span></span> ')
                        flag15 = false;
                        return false
                    }
                } else {
                    flag15 = true;
                    $('#temper15').remove();
                }
            }
        }
    };
    var flag16 = false;

    function endAirIptMethod() {
        var reg7 = /^[a-zA-Z]{3}$/;
//        $('#temper16').remove();
        if ($('#endAirIpt').val() != '') {
//            $('#temper16').remove();
            var endAirports = $('#endAirIpt').val();
            var endAirportsArr = [];
            endAirportsArr = endAirports.split("/");
            var endAirportsArrLen = endAirportsArr.length;
            for (var i = 0; i < endAirportsArrLen; i++) {
                if (!reg7.test(endAirportsArr[i]) && $('#endAirIpt').val() != "") {
                    if (flag16) {
                        $('#endAirSpan').after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="temper16"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请输入正确的机场信息！</em></span></span> ')
                        flag16 = false;
                        return false
                    }
                } else {
                    flag16 = true;
                    $('#temper16').remove();
                }
            }
        }
    }

    $('.addFormSub').click(function () {
        var reg = /^[a-zA-Z]{0,20}$/;
        var reg7 = /^[a-zA-Z]{3}$/;
        var flag6 = true;

        if (!flag8) {
            $("#temper1").remove();
            $('#addLoginName1Span').after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="temper1"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请输入少于20位的英文,数字组成的用户名！</em></span></span> ');
            return false
        }
        if (!userNameFlag) {
            $("#userNameTemp").remove();
            $("#userNameSpan").after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="userNameTemp"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请输入姓名不超过20位的字母或不超过10位的汉字！</em></span></span> ');
        }
        if (!departFlag) {
            $("#departTemp").remove();
            $("#departSpan").after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="departTemp"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请输入少于30位的字母，汉字或数字的部门名称！</em></span></span> ');
        }
        if (!emailFlag) {
            $("#emailTemp").remove();
            $("#emailSpan").after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="emailTemp"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请正确输入邮箱信息！</em></span></span> ');
        }
        if (!positionFlag) {
            $("#positionTemp").remove();
            $("#positionSpan").after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="positionTemp"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请输入少于16位的字母,数字或汉字的职位名称！</em></span></span> ');
        }
        if (!phoneFlag) {
            $("#phoneTemp").remove();
            $("#phoneSpan").after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="phoneTemp"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请输入正确的电话！</em></span></span> ');
        }
        if (!passOneFlag) {
            $("#passOneTemp").remove();
            $("#passOneSpan").after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="passOneTemp"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请输入少于12位的字母或数字的密码!</em></span></span> ');
        }
        if (!passwordFlag) {
            $("#passOneTemp").remove();
            $("#passOneSpan").after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="passOneTemp"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>密码强度过低，请重新输入密码!</em></span></span> ');
        }
        if (!departIdFlag) {
            $('#temper6').remove();
            $('#departmentId').after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="temper6"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请输入少于20位的英文部门代码！</em></span></span> ');
        }
        if (!startAirIptFlag) {
            $('#airStartTemp').remove();
            $('#getAirSpan').after('<span class="valid-text"><span class="estate error" id="airStartTemp"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请填写正确的机场信息并以/隔开</em></span></span> ');
        }
        if (!endAirIptFlag) {
            $('#airEndTemp').remove();
            $('#endAirSpan').after('<span class="valid-text"><span class="estate error" id="airEndTemp"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请填写正确的机场信息并以/隔开</em></span></span> ');
        }
        var maxNum = Number($("#validMsgNum").val());
        if (!maxNumFlag) {
            $("#maxtemper").remove();
            $('#validMsgNumSpan').after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="maxtemper"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>数据总量只能为数字，且最大不超过' + maxNum + '！</em></span></span> ');
        }
        if (!startAirportFlag) {
            $("#startAirportTemper").remove();
            $('#getAirSpan').after('<span class="valid-text"><span class="estate error" id="startAirportTemper"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>输入的起始机场信息含有重复项，请仔细检查！</em></span></span> ');
        }
        if (!endAirportFlag) {
            $("#endAirportTemper").remove();
            $('#endAirSpan').after('<span class="valid-text"><span class="estate error" id="endAirportTemper"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>输入的到达机场信息含有重复项，请仔细检查！</em></span></span> ');
        }
        var subSearchNum = $("#subSearchNum").val();
        var reg = /^[1-9]\d*?$/;
        if ($("input[type='checkbox']:checked").length >= 1) {
            $('#temper2').remove();
            $('#temper3').remove();
            $('#temper4').remove();
            $('#invalidSearchNumtemper').remove();
            if ($("#searchNumDiv input[type='checkbox']:checked").length > 0) {
                if ($("#addSearchTime").val() == "") {
                    $("#validNumSpan").after('<span class="valid-text"><span class="estate error" id="temper2"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>勾选后请填写查询次数！</em></span></span> ')
                    return false
                }
                if (!reg.test($("#addSearchTime").val())) {
                    $("#validNumSpan").after('<span class="valid-text"><span class="estate error" id="temper3"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>查询次数只能为数字，且最大不超过有效次数！</em></span></span> ')
                    return false
                }
                if (Number(subSearchNum) < Number($("#addSearchTime").val())) {
                    $("#validNumSpan").after('<span class="valid-text"><span class="estate error" id="temper4"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>查询次数只能为数字，且最大不超过有效次数！</em></span></span> ')
                    return false
                }
            } else {
                if ($("#addSearchTime").val() != "") {
                    $("#validNumSpan").after('<span class="valid-text"><span class="estate error" id="invalidSearchNumtemper"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请至少勾选订座实时、离港实时、订座历史、离港历史中的一项后填写查询次数！</em></span></span> ')
                    return false
                }
            }

        } else {
            $('#temper2').remove();
            $('#temper3').remove();
            $('#temper4').remove();
            $('#invalidSearchNumtemper').remove();
            $("#validNumSpan").after('<span class="valid-text"><span class="estate error" id="temper4"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请至少勾选一个权限！</em></span></span> ');
            return false;
        }
        if ($('#addModulesSeat').is(':checked') == true || $('#addModulesLeave').is(':checked') == true) {
            if ($("#addDataTotal").val() == 0) {
                $("#maxtemper").remove();
                $("#validMsgNumSpan").after('<span class="valid-text"><span class="estate error" id="maxtemper"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>数据总量次数不能为0 !</em></span></span> ');
                return false;
            } else if ($("#addDataTotal").val() < 0) {
                $("#maxtemper").remove();
                $("#validMsgNumSpan").after('<span class="valid-text"><span class="estate error" id="maxtemper"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>数据总量次数只能为大于0的正整数!</em></span></span> ');
                return false;
            }
        }
        var startAirpots = $("#getAirData").val();
        var endAirpots = $("#dstAirData").val();
        var selectStartAirports;
        var selectEndAirports;
        var selectStartAirportsLen = 0;
        var selectEndAirportsLen = 0;
        if (startAirpots != "") {
            selectStartAirports = $("#addAirStart").val();
        } else {
            selectStartAirports = $("#addAirStart").val().split("/");
        }
        if (!(selectStartAirports === null || selectStartAirports == "")) {
            selectStartAirportsLen = selectStartAirports.length;
        }

        var addAirStartArr = '';
        for (var i = 0; i < selectStartAirportsLen; i++) {
            addAirStartArr = addAirStartArr + selectStartAirports[i] + '/'
        }
        var addAirS = $("input[name^='orgAirports']");
        addAirS.val(addAirStartArr.substring(0, addAirStartArr.length - 1));
        if (endAirpots != "") {
            selectEndAirports = $("#addAirEnd").val();
        } else {
            selectEndAirports = $("#addAirEnd").val().split("/");
        }
        if (!(selectEndAirports === null || selectEndAirports == "")) {
            selectEndAirportsLen = selectEndAirports.length;
        }

        var addAirEndArr = '';
        for (var i = 0; i < selectEndAirportsLen; i++) {
            addAirEndArr = addAirEndArr + selectEndAirports[i] + '/'
        }
        var addAirE = $("input[name^='dstAirports']");
        addAirE.val(addAirEndArr.substring(0, addAirEndArr.length - 1));
        //有效时限验证
        var start = $("#sdate").val();
        var startTime = new Date(start).getTime();
        var end = $("#edate").val();
        var endTime = new Date(end).getTime();
        var timeLimit = 1000 * 60 * 60 * 24 * 30;
        var timeFlag = false;
        if (start > end) {
            $("#timeTemper").remove();
            $("#validTimeSpan").after('<span class="valid-text"><span class="estate error" id="timeTemper"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>起始日期不能大于结束日期</em></span></span> ');
        } else {
            timeFlag = true;
        }
        if (endTime - startTime < timeLimit) {
            $("#timeLimitTemper").remove();
            $("#validTimeSpan").after('<span class="valid-text"><span class="estate error" id="timeLimitTemper"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>结束日期必须大于起始时间一个月</em></span></span> ');
            return;
        } else {
            $("#timeLimitTemper").remove();
        }
        //起始和到达机场校验
        $("#startAirporttemper").remove();
        $("#endAirporttemper").remove();
        var startFlag = true;
        var endFlag = true;
        if (!(startAirpots === null || startAirpots == "")) {
            if (selectStartAirports === null || selectStartAirports == "") {
                startFlag = false;
                $("#getAirSpan").after('<span class="valid-text"><span class="estate error" id="startAirporttemper"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请分配给数据用户始发机场</em></span></span> ');

            } else {
                startFlag = true;
            }
        }
        if (!(endAirpots === null || endAirpots == "")) {
            if (selectEndAirports === null || selectEndAirports == "") {
                endFlag = false;
                $("#endAirSpan").after('<span class="valid-text"><span class="estate error" id="endAirporttemper"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请分配给数据用户到达机场</em></span></span> ');
            } else {
                endFlag = true;
            }
        }
        //用户管辖机场验证
        var airPortFlag = true;
        if ($("#airportCode").val() == "") {
            $("#airPortTemper").remove();
            $("#airPortSpan").after('<span class="valid-text"><span class="estate error" id="airPortTemper"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请选择所属机场!</em></span></span> ');
            airPortFlag = false;
        } else if (selectStartAirports != "" || selectEndAirports != "") {
            var flag = false;
            var airPort = $("#airportCode").val();
            for (var i = 0; i < selectStartAirportsLen; i++) {
                if (selectStartAirports[i] != "") {
                    if (selectStartAirports[i].toUpperCase() == airPort) {
                        flag = true;
                        break;
                    }
                }
            }
            for (var i = 0; i < selectEndAirportsLen; i++) {
                if (selectEndAirports[i] != "") {
                    if (selectEndAirports[i].toUpperCase() == airPort) {
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag) {
                var airPortArray = [];
                for (var i = 0; i < selectStartAirportsLen; i++) {
                    if (airPortArray.indexOf(selectStartAirports[i].toUpperCase()) == -1) {
                        airPortArray.push(selectStartAirports[i].toUpperCase());
                    }
                }
                for (var i = 0; i < selectEndAirportsLen; i++) {
                    if (airPortArray.indexOf(selectEndAirports[i].toUpperCase()) == -1) {
                        airPortArray.push(selectEndAirports[i].toUpperCase());
                    }
                }
                var selectString = '<select class="input-middle" name="airportCode" id="airportCode">';
                selectString += '<option  value="" >--请选择机场--</option>';
                for (var i = 0; i < airPortArray.length; i++) {
                    if (airPortArray[i] != "") {
                        selectString += '<option  value=' + airPortArray[i].toUpperCase() + '>' + airPortArray[i].toUpperCase() + '(' + airportAndCnName[airPortArray[i]] + ')' + '</option>';
                    }
                }
                selectString += '</select>';
                $("#airportCode").replaceWith(selectString);
                $("#airPortTemper").remove();
                $("#airPortSpan").after('<span class="valid-text"><span class="estate error" id="airPortTemper"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>所属机场必须为起始或到达机场中的一个！</em></span></span> ');
                changeFlag = true;
                airPortFlag = false;
            } else {
                airPortFlag = true;
                $("#airPortTemper").remove();
            }
        }
        /*if(startAirpots == "" && endAirpots == ""){
            if(selectStartAirportsLen == 0 && selectEndAirportsLen == 0 ){
                if(changeFlag){
                    $("#airportCode").replaceWith(airportArr);
                }
            }
            //父用户最大权限 子用户创建时填写起始或者到达  但管辖机场不符合 删除起始和到达  再次点击提交
            // 管辖机场列表变为初始化的列表
        }*/
        if (!(flag8 && userNameFlag && departFlag && emailFlag
                && positionFlag && phoneFlag && timeFlag
                && startFlag && endFlag && passOneFlag && departIdFlag
                && startAirIptFlag && endAirIptFlag && maxNumFlag && airPortFlag
                && startAirportFlag && endAirportFlag && passwordFlag)) {
            return false;
        }
        $('#add_Form').submit();
    });

    function check() {
        if ($('#addModulesSeat').is(':checked') == true || $('#addModulesLeave').is(':checked') == true) {
            $("#addDataTotal").val();
            $("#addDataTotal").removeAttr("readonly");
        } else {
            $("#addDataTotal").val(0);
            $("#addDataTotal").attr("readonly", "readonly");
        }
    };
    $('.bui-dialog a.bui-ext-close').remove();


</script>


</html>