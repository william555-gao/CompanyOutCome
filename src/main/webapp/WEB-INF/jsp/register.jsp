<!DOCTYPE html>
<%@pagecontentType="text/html;charset=UTF-8" %>
<bean:define id="ctx" value="<%=request.getContextPath() %>"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<!DOCTYPE HTML>
<head>
    <title>新用户注册</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/company/assets/css/dpl.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/company/assets/css/bui.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/company/assets/css/page-min.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/company/assets/css/main.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/company/assets/css/toastr.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/company/assets/css/bootstrap-select.min.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/company/assets/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/company/assets/css/signin.css"/>
    <script type="text/javascript" src="${ctx}/company/assets/js/jquery-1.8.1.min.js"></script>
    <script type="text/javascript" src="${ctx}/company/assets/js/bootstrap-select.min.js"></script>
    <script type="text/javascript" src="${ctx}/company/assets/js/bootstrap.js"></script>
    <script type="text/javascript" src="${ctx}/company/assets/js/bui-min.js"></script>
    <script type="text/javascript" src="${ctx}/company/assets/js/config-min.js"></script>
    <script type="text/javascript" src="${ctx}/company/assets/js/toastr.js"></script>
    <script type="text/javascript" src="${ctx}/company/assets/js/jquery.twbsPagination.js"></script>
    <script type="text/javascript" src="${ctx}/company/assets/js/netsign.js"></script>
    <script type="text/javascript" src="${ctx}/company/assets/js/aes.js"></script>
    <!-- 如果不使用页面内部跳转，则下面 script 标签不需要,同时不需要引入 common/page -->
</head>
<style>
    html {
        overflow-x: scroll;
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


<body>
<div class="container" id="addUserBody">
    <div class="row">
        <div class="col-md-4 col-md-offset-4" style="text-align: center;">
            <form class="form-horizontal well" id="add_Form" method="post"
                  action='<c:url value="/usermanage/register"/>' enctype="multipart/form-data">
                <input type="hidden" name="uploadpath" id="uploadpath"/>
                <input type="hidden" name="uploadpath1" id="uploadpath1"/>
                <input type="hidden" name="uploadpath2" id="uploadpath2"/>
                <input type="hidden" name="doesnotselectfile" id="doesnotselectfile" value="${doesnotselectfile}"/>
                <input type="hidden" name="registerUserSucesss" id="registerUserSucesss"
                       value="${registerUserSucesss}"/>
                <input type="hidden" name="registerUserFailed" id="registerUserFailed" value="${registerUserFailed}"/>
                <input type="hidden" name="fileTypeError" id="fileTypeError" value="${fileTypeError}"/>
                <input type="hidden" name="inputParamError" id="inputParamError" value="${inputParamError}"/>
                <input type="hidden" name="transformImageError" id="transformImageError"
                       value="${transformImageError}"/>
                <input type="hidden" name="emptyUserType" id="emptyUserType" value="${emptyUserType}"/>
                <div class="row">
                    <div class="control-group span12">
                        <label class="control-label">用户类型：</label>
                        <div class="controls" id="userTypeDiv">
                            <select class="input-middle" name="userTypeCode" id="userTypeCode"
                                    onchange="changeUserType()">
                                <option value="">--请选择用户类型--</option>
                                <option value="1">企业</option>
                                <option value="2">技术经理人</option>
                                <option value="3">专家</option>
                            </select>
                            <span style="color: red">*</span>
                        </div>
                    </div>
                </div>
                <%--企业--%>
                <div class="control-group span13" id="company">
                    <div class="row">
                        <div class="control-group span14">
                            <label class="control-label">企业名称：</label>
                            <div class="controls">
                                <input name="companyName" id="companyName" maxlength="20" style="width: 200px"
                                       autocomplete="off"
                                       value="" type="text" onkeyup="checkCompanyName()"
                                       class="input-normal control-text">
                                <span id="companynameSpan" style="color: red">*</span>
                            </div>
                        </div>
                        <div class="control-group span14">
                            <label class="control-label">统一信用代码：</label>
                            <div class="controls">
                                <input name="companyCreditCode" id="companyCreditCode" maxlength="20"
                                       style="width: 200px" autocomplete="off"
                                       value="" type="text"
                                       class="input-normal control-text">
                                <span id="companycreditcodeSpan" style="color: red">*</span>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="control-group span12">
                            <label class="control-label">法人：</label>
                            <div class="controls">
                                <input name="companyLegalPerson" id="companyLegalPerson" maxlength="20"
                                       style="width: 200px" autocomplete="off"
                                       value="" type="text" onkeyup="checkUserName()"
                                       class="input-normal control-text">
                                <span id="companylegalpersonSpan" style="color: red">*</span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="control-group span3"></div>
                            <div class="control-group span6">
                                <span style="margin-left:0px" class="valid-text"><em>手机号可作为登录账号</em></span>
                            </div>
                        </div>
                        <div class="control-group span12">
                            <label class="control-label">联系方式：</label>
                            <div class="controls">
                                <input name="companyPhonenNumber" id="companyPhonenNumber" maxlength="20"
                                       style="width: 200px"
                                       autocomplete="off"
                                       value="" type="text" onkeyup="checkPhone()" onblur="checkphonenum()"
                                       class="input-normal control-text">
                                <span id="companyphonenumSpan" style="color: red">*</span>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="control-group span1"></div>
                        <div class="control-group span25">
                            <label class="control-label">营业执照(图片)：</label>
                            <div class="controls">
                                <input type="file" id="uploadfile" name="realpath" class="uploadfile"
                                       style="visibility: hidden; position: absolute;"/>
                                <input type="text" disable="disable" id="showpath" name="filepath"/>
                                <button id="filebtn" type="button" class="button filebtn">浏览</button>
                                <span class="sperr" style="color: red">*</span>
                            </div>
                        </div>
                    </div>
                </div>


                <%--技术经理人或专家--%>
                <div class="row" id="person">
                    <div class="row">
                        <div class="control-group span12">
                            <label class="control-label">姓名：</label>
                            <div class="controls">
                                <input name="staffName" id="staffName" maxlength="20" style="width: 200px"
                                       autocomplete="off"
                                       value="" type="text" onkeyup="checkUserName()"
                                       class="input-normal control-text">
                                <span id="staffnameSpan" style="color: red">*</span>
                            </div>
                        </div>
                        <div class="control-group span12">
                            <label class="control-label">工作单位：</label>
                            <div class="controls">
                                <input name="staffDepartment" id="staffDepartment" style="width: 200px" maxlength="30"
                                       value="" type="text" onkeyup="checkDepartment()"
                                       class="input-normal control-text">
                                <span id="departSpan" style="color: red">*</span>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="control-group span12">
                            <label class="control-label">性别：</label>
                            <div class="controls">
                                <select class="input-middle" name="staffSex" id="staffSex">
                                    <option value="">---请选择---</option>
                                    <option value="1">男</option>
                                    <option value="0">女</option>
                                </select>
                            </div>
                        </div>
                        <div class="control-group span12">
                            <label class="control-label">出生日期：</label>
                            <div class="controls bui-form-group showdate" data-rules="{dateRange:true}">
                                <input type="text" class="calendar" name="staffBirthday" id="staffBirthday"
                                       value="" readonly="readonly"/>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="control-group span3"></div>
                        <div class="control-group span6">
                            <span style="margin-left:0px" class="valid-text"><em>手机号或邮箱号均可作为登录账号</em></span>
                        </div>
                    </div>
                    <div class="row">
                        <div class="control-group span12">
                            <label class="control-label">联系方式：</label>
                            <div class="controls">
                                <input name="staffPhone" id="staffPhone" style="width: 200px" maxlength="25"
                                       autocomplete="off"
                                       value="" onkeydown="checkPhoneOn()" onkeyup="checkPhone()"
                                       onblur="checkphonenum()" type="text"
                                       class="input-normal control-text">
                                <span id="phoneSpan" style="color: red">*</span>
                            </div>
                        </div>
                        <div class="control-group span12">
                            <label class="control-label">邮箱：</label>
                            <div class="controls">
                                <input name="staffemail" maxlength="20" style="width: 200px" id="staffemail"
                                       onkeydown="checkEmailOn()" onkeyup="checkEmail()" onblur="checkemail()" value=""
                                       type="text"
                                       class="input-normal control-text">
                                <span id="emailNumSpan" style="color: red">*</span>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="control-group span12">
                            <label class="control-label">身份证号：</label>
                            <div class="controls">
                                <input id="staffidcard" name="staffidcard"
                                       onkeydown="checkUserOn()" onblur="checkIDCard()"
                                       autocomplete="off"
                                       value=""
                                       style="width: 200px" type="text"
                                       class="input-normal control-text">
                                <span id="staffidcardSpan" style="color: red">*</span>
                            </div>
                        </div>
                        <div class="control-group span12">
                            <label class="control-label">所在地区：</label>
                            <div class="controls">
                                <input name="staffLocation" id="staffLocation" style="width: 200px" maxlength="30"
                                       value="" type="text"
                                       class="input-normal control-text">
                                <span id="" style="color: red">*</span>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="control-group span12">
                            <label class="control-label">擅长领域：</label>
                            <div class="controls">
                                <input name="staffDomain" id="staffDomain" style="width: 200px" maxlength="30"
                                       value="" type="text"
                                       class="input-normal control-text">
                            </div>
                        </div>
                        <div class="control-group span12">
                            <label class="control-label">个人介绍：</label>
                            <div class="controls">
                                <input name="staffDescription" id="staffDescription" style="width: 200px" maxlength="30"
                                       value="" type="text"
                                       class="input-normal control-text">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="control-group span12">
                            <label class="control-label">头像：</label>
                            <div class="controls">
                                <input type="file" id="uploadfile2" name="realpath2" class="uploadfile2"
                                       style="visibility: hidden; position: absolute;"/>
                                <input type="text" disable="disable" id="showpath2" name="filepath"/>
                                <button id="filebtn2" type="button" class="button filebtn2">浏览</button>
                                <span style="color: red">*</span>
                            </div>
                        </div>
                        <div class="control-group span12">
                            <label class="control-label">证书附件：</label>
                            <div class="controls">
                                <input type="file" id="uploadfile1" name="realpath1" class="uploadfile1"
                                       style="visibility: hidden; position: absolute;"/>
                                <input type="text" disable="disable" id="showpath1" name="filepath"/>
                                <button id="filebtn1" type="button" class="button filebtn1">浏览</button>
                                <span style="color: red">*</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="control-group span12">
                        <label class="control-label">密码：</label>
                        <div class="controls">
                            <input id="addPassOne" autocomplete="off" style="width: 200px" type="password"
                                   maxlength="12" onkeyup="checkPassWord()" class="input-normal control-text">
                            <span id="passOneSpan" style="color: red">*</span>
                        </div>
                    </div>
                    <div class="control-group span12">
                        <label class="control-label">确认密码：</label>
                        <div class="controls">
                            <input id="addPassTwo" name="password" value="" maxlength="12"
                                   autocomplete="off" style="width: 200px" type="password"
                                   data-rules="{equalTo:'#addPassOne'}" data-messages="{regexp:'请确认两次密码输入一致！'}"
                                   class="input-normal control-text">
                            <span style="color: red">*</span>
                        </div>
                    </div>
                    <div class="row">
                        <div class="control-group span12">
                            <label class="control-label">密码强度：</label>
                            <div class="controls">
                                <table border="0" cellpadding="0" cellspacing="0">
                                    <tr align="center">
                                        <td id="pwd_Weak" class="pwd pwd_c"></td>
                                        <td id="pwd_Medium" class="pwd pwd_c pwd_f">无</td>
                                        <td id="pwd_Strong" class="pwd pwd_c pwd_c_r"></td>
                                    </tr>
                                </table>
                            </div>
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
    var changeFlag = false;
    var airportList = "";
    var airportAndCnName = {};

    function changeUserType() {
        if ($('#userTypeCode').val() == "") {
            $('#company').hide();
            $('#person').hide();
        } else {
            if ($('#userTypeCode').val() == "1") {
                $('#company').show();
                $('#person').hide();
            } else {
                $('#person').show();
                $('#company').hide();
            }
        }

    }

    //初始化隐藏
    $(function () {
        $('#company').hide();
        $('#person').hide();
    });
    //文件上传
    $('.filebtn').click(function () {
        $('#uploadfile').click();
    })

    $('.uploadfile').change(function () {
        var filePath = $("#uploadfile").val();
        $("#uploadpath").val(filePath);
        var res = filePath.replace(/.*(\/|\\)/, "");
        $("#showpath").val(res);

    });
    $('.filebtn1').click(function () {
        $('#uploadfile1').click();
    })

    $('.uploadfile1').change(function () {
        var filePath = $("#uploadfile1").val();
        $("#uploadpath1").val(filePath);
        var res = filePath.replace(/.*(\/|\\)/, "");
        $("#showpath1").val(res);

    });
    $('.filebtn2').click(function () {
        $('#uploadfile2').click();
    })

    $('.uploadfile2').change(function () {
        var filePath = $("#uploadfile2").val();
        $("#uploadpath2").val(filePath);
        var res = filePath.replace(/.*(\/|\\)/, "");
        $("#showpath2").val(res);

    });

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

        var saveSucclog = new Overlay.Dialog({
            title: '消息提示！',
            width: 300,
            height: 200,
            mask: false,
            buttons: [
                {
                    text: '确定',
                    elCls: 'button button-primary queding',
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

            bodyContent: '<p>用户信息注册成功！</p>'
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

        var registerUserSucesss = $("#registerUserSucesss").val();
        var doesnotselectfile = $("#doesnotselectfile").val();
        var registerUserFailed = $("#registerUserFailed").val();

        var fileTypeError = $("#fileTypeError").val();
        var inputParamError = $("#inputParamError").val();
        var transformImageError = $("#transformImageError").val();
        var emptyUserType = $("#emptyUserType").val();
        if (registerUserSucesss != "") {
            $('#addUserBody').hide();
            saveSucclog.show();
        } else if (registerUserFailed != "") {
            saveFaillog.show();
        } else if (doesnotselectfile != "") {
            toastr.error(doesnotselectfile);
        } else if (fileTypeError != "") {
            toastr.error(doesnotselectfile);
        } else if (inputParamError != "") {
            toastr.error(doesnotselectfile);
        } else if (transformImageError != "") {
            toastr.error(doesnotselectfile);
        } else if (emptyUserType != "") {
            toastr.error(emptyUserType);
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

    //用户名验证
    var userNameFlag = false;
    var userNameFlagCompany = false;

    function checkUserName() {
        var reg = /(^[a-zA-Z]{1,20}$)|(^[\u4e00-\u9fa5]{1,10}$)/;
        if ($('#userTypeCode').val() == "1") {
            if (reg.test($("#companylegalperson").val())) {
                $("#staffnameTemp1").remove();
                userNameFlagCompany = true;
            } else {
                $("#staffnameTemp1").remove();
                $("#companylegalpersonSpan").after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="staffnameTemp1"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请输入法人姓名不超过20位的字母或不超过10位的汉字！</em></span></span> ');
            }
        } else {
            if (reg.test($("#staffname").val())) {
                $("#staffnameTemp").remove();
                userNameFlag = true;
            } else {
                $("#staffnameTemp").remove();
                $("#staffnameSpan").after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="staffnameTemp"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请输入名称不超过20位的字母或不超过10位的汉字！</em></span></span> ');
            }
        }


    }

    var companyNameFlag = false;

    function checkCompanyName() {
        var reg = /(^[a-zA-Z]{1,20}$)|(^[\u4e00-\u9fa5]{1,10}$)/;
        if (reg.test($("#companyname").val())) {
            $("#companyNameTemp").remove();
            companyNameFlag = true;
        } else {
            $("#companyNameTemp").remove();
            $("#companynameSpan").after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="companyNameTemp"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请输入企业名称不超过20位的字母或不超过10位的汉字！</em></span></span> ');
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
            $("#departSpan").after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="departTemp"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请输入少于20位的字母，汉字或数字的部门名称！</em></span></span> ');
        }
    }

    //邮箱验证
    var emailFlag = false;

    function checkEmail() {
        var reg = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
        if (reg.test($("#staffemail").val())) {
            $("#emailTemp").remove();
            emailFlag = true;
        } else {
            $("#emailTemp").remove();
            $("#emailNumSpan").after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="emailTemp"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请正确输入邮箱信息！</em></span></span> ');
        }
    }

    //电话号码验证
    var phoneFlag = false;
    var phoneFlagCompany = false;

    function checkPhone() {
        var reg = /^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\d{8}$/;
        if ($('#userTypeCode').val() == "1") {
            if (reg.test($("#companyphonenum").val())) {
                $("#phoneTemp1").remove();
                phoneFlagCompany = true;
            } else {
                $("#phoneTemp1").remove();
                $("#companyphonenumSpan").after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="phoneTemp1"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请输入正确的电话！</em></span></span> ');
            }
        } else {
            if (reg.test($("#staffphone").val())) {
                $("#phoneTemp").remove();
                phoneFlag = true;
            } else {
                $("#phoneTemp").remove();
                $("#phoneSpan").after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="phoneTemp"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请输入正确的电话！</em></span></span> ');
            }
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

    function checkUserOn() {
        $('#idtemper1').remove();
    }

    function checkPhoneOn() {
        $('#phonetemper1').remove();
        $('#phonetemper2').remove();
    }

    function checkEmailOn() {
        $('#emailtemper1').remove();
        $('#emailtemper2').remove();
    }

    var phonenumflag = false;
    var emailflag = false;
    var idflag = false;

    function checkIDCard() {
        var idnum = $("#staffidcard").val();
        var reg9 = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
        if (!reg9.test(idnum)) {
            $("#idtemper1").remove();
            $('#staffidcardSpan').after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="idtemper1"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请输入正确的身份证号！</em></span></span> ')
            idflag = false;
        } else {
            $("#idtemper1").remove();
            idflag = true;
        }
    }

    function checkphonenum() {
        var reg = /^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\d{8}$/;
        var phonenum;
        if ($('#userTypeCode').val() == "1") {
            phonenum = $("#companyphonenum").val();
        } else {
            phonenum = $("#staffphone").val();
        }

        if (reg.test(phonenum)) {
            console.log('校验手机号')
            $.ajax({
                type: 'post',
                url: "/company/usermanage/checkphonenum",
                data: {
                    'phoneNumber': phonenum,
                },
                success: function (data) {
                    console.log(data);
                    if (data.resultStatusCode == '00000') {
                        phonenumflag = true;
                        if ($('#userTypeCode').val() == "1") {
                            $('#phonetemper2').remove();
                            $('#companyphonenumSpan').after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="phonetemper2"><em style="color: #5cb85c">手机号可用。</em></span></span>')
                        } else {
                            $('#phonetemper2').remove();
                            $('#phoneSpan').after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="phonetemper2"><em style="color: #5cb85c">手机号可用。</em></span></span>')
                        }
                    } else {
                        phonenumflag = false;
                        if ($('#userTypeCode').val() == "1") {
                            $('#phonetemper1').remove();
                            $('#companyphonenumSpan').after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="phonetemper1"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>该手机号已绑定用户！</em></span></span> ')
                        } else {
                            $('#phonetemper1').remove();
                            $('#phoneSpan').after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="phonetemper1"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>该手机号已绑定用户！</em></span></span> ')
                        }
                    }
                },
                error: function (e) {
                    phonenumflag = false;
                }
            })
        }
    }

    function checkemail() {
        var reg = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
        var email = $("#staffemail").val();
        if (reg.test(email)) {
            console.log('校验邮箱！')
            $.ajax({
                type: 'post',
                url: "/company/usermanage/checkemail",
                data: {
                    'email': email,
                },
                success: function (data) {
                    console.log(data);
                    if (data.resultStatusCode == '00000') {
                        emailflag = true;
                        $('#emailNumSpan').after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="emailtemper2"><em style="color: #5cb85c">邮箱可用。</em></span></span>')
                    } else {
                        $('#emailNumSpan').after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="emailtemper1"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>该邮箱账号已绑定用户</em></span></span> ')
                        emailflag = false;
                    }
                },
                error: function (e) {
                    emailflag = false;
                }
            })
        }
    }

    $('.queding').click(
        function () {
            self.location = "/company/hello";
        }
    )
    $('.addFormSub').click(function () {
        if (!phonenumflag) {
            $("#temper1").remove();
            $('#addLoginName1Span').after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="temper1"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请输入少于20位的英文,数字组成的用户名！</em></span></span> ');
            return false
        }
        if (!userNameFlag && $('#userTypeCode').val() != "1") {
            $("#staffnameTemp").remove();
            $("#staffnameSpan").after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="userNameTemp"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请输入姓名不超过20位的字母或不超过10位的汉字！</em></span></span> ');
        }
        if (!userNameFlagCompany) {
            $("#staffnameTemp1").remove();
            $("#companylegalpersonSpan").after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="userNameTemp1"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请输入法人姓名不超过20位的字母或不超过10位的汉字！</em></span></span> ');
        }
        if (!companyNameFlag) {
            $("#companyNameTemp").remove();
            $("#companynameSpan").after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="companyNameTemp"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请输入企业名称不超过20位的字母或不超过10位的汉字！</em></span></span> ');
        }
        if (!departFlag && $('#userTypeCode').val() != "1") {
            $("#departTemp").remove();
            $("#departSpan").after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="departTemp"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请输入少于30位的字母，汉字或数字的部门名称！</em></span></span> ');
        }
        if (!emailFlag && $('#userTypeCode').val() != "1") {
            $("#emailTemp").remove();
            $("#emailNumSpan").after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="emailTemp"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请正确输入邮箱信息！</em></span></span> ');
        }
        if (!phoneFlag && $('#userTypeCode').val() != "1") {
            $("#phoneTemp").remove();
            $("#phoneSpan").after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="phoneTemp"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请输入正确的电话！</em></span></span> ');
        }
        if (!phoneFlagCompany) {
            $("#phoneTemp1").remove();
            $("#companyphonenumSpan").after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="phoneTemp1"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请输入正确的电话！</em></span></span> ');
        }
        if (!passOneFlag) {
            $("#passOneTemp").remove();
            $("#passOneSpan").after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="passOneTemp"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请输入少于12位的字母或数字的密码!</em></span></span> ');
        }
        if (!passwordFlag) {
            $("#passOneTemp").remove();
            $("#passOneSpan").after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="passOneTemp"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>密码强度过低，请重新输入密码!</em></span></span> ');
        }
        if (!idflag && $('#userTypeCode').val() != "1") {
            $("#idtemper1").remove();
            $('#staffidcardSpan').after('<span style="margin-left:0px" class="valid-text"><span class="estate error" id="idtemper1"><span class="x-icon x-icon-mini x-icon-error"> ! </span><em>请输入正确的身份证号！</em></span></span> ')
        }
        if ($('#userTypeCode').val() != "1") {
            if (!(phonenumflag && phoneFlag && emailflag && emailFlag && idflag && userNameFlag && departFlag && passOneFlag && passwordFlag)) {
                return false;
            }
        } else {
            if (!(userNameFlagCompany && companyNameFlag && phoneFlagCompany && phonenumflag && passOneFlag && passwordFlag)) {
                return false;
            }
        }
        $('#add_Form').submit();
    })

    $('.bui-dialog a.bui-ext-close').remove();

</script>


</html>