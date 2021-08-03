<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>电话追踪记录 </title>
    <style>
        .question{
            margin-right: 600px;
        }
    </style>
</head>

<body>

<!-- Main Content -->
<div class="page-wrapper">
    <div class="container-fluid">

        <!-- Row -->
        <div class="row">
            <div class="col-sm-12">
               <%-- <div class="panel-heading">
                    <div class="pull-left">
                        <ol class="breadcrumb">
                            <li><a href="${ctx}/index">首页</a></li>
                            <li class="active">电话追踪记录</li>
                        </ol>
                    </div>
                    <div class="clearfix"></div>
                </div>--%>

                        <div class="panel-body">
                            <div class="table-responsive">
                                <table id="phonetabList" class="table" data-paging="true" data-paging="true"
                                       data-filtering="true" data-sorting="true">
                                </table>

                            </div>
                        </div>
                </div>
            </div>
        </div>
        <!-- /Row -->

    </div>


<script >
    $(function () {
        var phoneTitle = [
            {"name":"id","title":"ID","breakpoints":"xs sm",visible:false},
            {"name":"name","title":"来电人姓名"},
            {"name":"tell","title":"电话", visible:false},
            {"name":"forwhom","title":"替谁询问"},
            {"name":"way","title":"得知途径"},
            {"name":"takeTime","title":"建立时间"},
            {"name":"updateTime","title":"操作时间","visible":false},
            {"name":"isRegistration","title":"是否追踪"},
            {"name":"callcontent","title":"沟通内容",visible:false},
            {"name":"times","title":"沟通次数",visible:false},
            {"name":"detail","title":"操作"},
            {"name":"personnel","title":"沟通人",visible:false},
            {"name":"note","title":"备注",visible:false},
        ];
        function detail(values) {
            var dialog = BootstrapDialog.show({
                type : BootstrapDialog.TYPE_DEFAULT,
                title : "<span style=\"color: #ab8ce4\"><i></i>查看一条数据</span>",
                closable: false,
                draggable: true,
                cssClass: 'api-blacklist-form-add',
                message:$('<div></div>').load('${ctx}/template/businessmanager/phonefollowdetail.jsp'),//加载弹出页面
                size : BootstrapDialog.SIZE_WIDE,//弹出框大小。
                //数据回显
                onshown: function(dialogRef){
                    $('#id').val(values.id);
                    $('#name').val(values.name);
                    $('#tell').val(values.tell);
                    $('#forwhom').val(values.forwhom);
                    $('#way').val(values.way);
                    $('#takeTime').val(values.takeTime);
                    $('#updateTime').val(values.updateTime);
                    $('#isRegistration').val(values.isRegistration);
                    $('#personnel').val(values.personnel);
                    $('#callcontent').val(values.callcontent);
                    $('#times').val(values.times);
                    $('#note').val(values.note);
                    $('#phoform').find('input,textarea,select').attr("disabled","disabled");
                },
                buttons : [{
                    label : '关闭',
                    icon: 'fa fa-close',
                    action : function(dialogItself) {
                        dialogItself.close();
                    }
                } ]
            });
        }
        window.detail = detail;
        //启动footable
        var ft = FooTable.init('#phonetabList',{
            "columns": phoneTitle,
            "rows": $.get("${ctx}/businessmanager/selectListCallrecordBySoreId?storeId="+'<%=session.getAttribute("storeId")%>',function (data) {
                $(data).each(function () {
                    this.detail = "<button class='btn btn-primary btn-sm' onclick='detail("+JSON.stringify(this)+")'>查看详情</button>"
                })
            }),
            //功能操作
            editing: {
                enabled: true,
                addRow: function(){
                    //新增模态框
                    var $that = $(this);
                    var dialog = BootstrapDialog.show({
                        type : BootstrapDialog.TYPE_DEFAULT,
                        title : "<span style=\"color: #ab8ce4\"><i></i>新增一条数据</span>",
                        closable: false,
                        draggable: true,
                        cssClass: 'api-blacklist-form-add',
                        message:$('<div></div>').load('${ctx}/template/businessmanager/phonefollowAndAppointment.jsp'),//加载弹出页面
                        size : BootstrapDialog.SIZE_WIDE,//弹出框大小。
                        onhide:function(){
                            $that.removeAttr("disabled");
                        },
                        onshown:function () {
                            $("#appointbtn").click(function () {
                               $("#appoint").show();
                            })
                            $("#reappointbtn").click(function () {
                                $("#appoint").hide();
                            })
                        },
                        buttons : [
                            {
                                label : '常见问题',
                                cssClass: 'question',
                                action : function(dialogItself) {
                                    var dialog = BootstrapDialog.show({
                                        type : BootstrapDialog.TYPE_DEFAULT,
                                        title : "<span style=\"color: #ab8ce4\"><i></i>常见问题</span>",
                                        closable: false,
                                        draggable: true,
                                        cssClass: 'api-blacklist-form-add',
                                        message:$('<div></div>').load('${ctx}/template/businessmanager/forPhone.jsp'),//加载弹出页面
                                        size : BootstrapDialog.SIZE_WIDE,//弹出框大小。
                                        onhide:function(){
                                            $that.removeAttr("disabled");
                                        },
                                        onshown:function () {
                                            $.get('${ctx}/businessmanager/selectAllQuestion',{'storeId':'<%=session.getAttribute("storeId")%>'},function (data) {
                                                if(data==null){
                                                    $("#tbody").append("<tr>空</tr>");
                                                }else {
                                                    $(data).each(function () {
                                                        $("#tbody").append("<tr><td width='400px'>"+this.detail+"</td><td width='400px'>"+this.answer+"</td></tr>");
                                                    })
                                                }
                                            })
                                        },
                                        buttons : [{
                                            label : '关闭',
                                            icon: 'fa fa-close',
                                            action : function(dialogItself) {
                                                dialogItself.close();
                                            }
                                        } ]
                                    });
                                }
                            },{
                            id: 'btn-form-submit',
                            label: '提交',
                            icon: 'fa fa-check-circle',
                            cssClass: 'btn-primary',
                            action: function(){
                                var json = {
                                   /* 'id': $('#id').val(),*/
                                    'name': $('#name').val(),
                                    'tell': $('#tell').val(),
                                    'forwhom': $('#forwhom').val(),
                                    'way': $('#way').val(),
                                    'takeTime': $('#takeTime').val(),
                                    'updateTime': $('#updateTime').val(),
                                    'isRegistration': $('#isRegistration').val(),
                                    'note': $('#note').val(),
                                    'personnel':$('#personnel').val(),
                                    'times':$('#times').val(),
                                    'callcontent':$('#callcontent').val(),
                                    'storeId':'<%=session.getAttribute("storeId")%>'
                                };
                                $("#phoform").bootstrapValidator({
                                    live: 'disabled',
                                    excluded: [':disabled', ':hidden', ':not(:visible)'],
                                    submitButtons: '#btn-test',
                                    message: '通用的验证失败消息',
                                    feedbackIcons: {
                                        valid: 'glyphicon glyphicon-ok',
                                        invalid: 'glyphicon glyphicon-remove',
                                        validating: 'glyphicon glyphicon-refresh'
                                    },
                                    fields: {
                                        name: {
                                            validators: {
                                                notEmpty: {
                                                    message: '用户名不能为空'
                                                },
                                            }
                                        },
                                        tell: {
                                            validators: {
                                                notEmpty: {
                                                    message: '手机号不能为空！'
                                                },
                                                regexp : {
                                                    regexp: /^1[0-9]{10}$/,
                                                    message: '手机号格式不正确！'
                                                },
                                            }
                                        },
                                        times:{
                                            validators:{
                                                notEmpty:{
                                                    message:'不能为空'
                                                },
                                                numeric:{
                                                    message:'只能为数字'
                                                }
                                            }
                                        }
                                    }
                                });
                                var bootstrapValidator = $("#phoform").data('bootstrapValidator');
                                bootstrapValidator.validate();
                                if(bootstrapValidator.isValid()){
                                    $.post("${ctx}/businessmanager/addCallrecord",json).
                                    done(function(data){getCode(data)}).
                                    fail(function(data){getCode(data)});
                                    if($("#appoint").is(":visible")){
                                        $.post("${ctx}/businessmanager/addAppointment",{
                                            'name':$('#name').val(),
                                            'tell':$('#tell').val(),
                                            'sex':$('#sex').val(),
                                            'number':$('#number').val(),
                                            'cometime':$('#cometime').val(),
                                            'storeId':'<%=session.getAttribute("storeId")%>',
                                        }).
                                        done(function(data){getCode(data)}).
                                        fail(function(data){getCode(data)});
                                    }
                                }
                            }
                        },{
                            label : '关闭',
                            icon: 'fa fa-close',
                            action : function(dialogItself) {
                                dialogItself.close();
                            }
                        }]
                    });
                },
                //这里是修改时绑定数据
                editRow: function(row){
                    var values = row.val();
                    var $that = $(this);
                    //失效
                    $that.attr("disabled","disabled");
                    // 调用add方法
                    var dialog = BootstrapDialog.show({
                        type : BootstrapDialog.TYPE_DEFAULT,
                        title : "<span style=\"color: #ab8ce4\"><i></i>修改一条数据</span>",
                        closable: false,
                        draggable: true,
                        cssClass: 'api-blacklist-form-add',
                        message:$('<div></div>').load('${ctx}/template/businessmanager/phonefollow.jsp'),//加载弹出页面
                        size : BootstrapDialog.SIZE_WIDE,//弹出框大小。
                        //数据回显
                        onshown: function(dialogRef){
                            $('#id').val(values.id);
                            $('#name').val(values.name);
                            $('#tell').val(values.tell);
                            $('#forwhom').val(values.forwhom);
                            $('#way').val(values.way);
                            $('#takeTime').val(values.takeTime);
                            $('#updateTime').val(values.updateTime);
                            $('#isRegistration').val(values.isRegistration);
                            $('#personnel').val(values.personnel);
                            $('#callcontent').val(values.callcontent);
                            $('#times').val(values.times);
                            $('#note').val(values.note);

                        },
                        buttons : [{
                            id: 'btn-form-submit',
                            label: '提交',
                            icon: 'fa fa-check-circle',
                            cssClass: 'btn-primary',
                            action: function(){
                                var json = {
                                    'id': $('#id').val(),
                                    'name': $('#name').val(),
                                    'tell': $('#tell').val(),
                                    'forwhom': $('#forwhom').val(),
                                    'way': $('#way').val(),
                                    'takeTime': $('#takeTime').val(),
                                    'updateTime': $('#updateTime').val(),
                                    'isRegistration': $('#isRegistration').val(),
                                    'note': $('#note').val(),
                                    'personnel':$('#personnel').val(),
                                    'times':$('#times').val(),
                                    'callcontent':$('#callcontent').val(),
                                    'storeId':'<%=session.getAttribute("storeId")%>'
                                };
                                $("#phoform").bootstrapValidator({
                                    live: 'disabled',
                                    excluded: [':disabled', ':hidden', ':not(:visible)'],
                                    submitButtons: '#btn-test',
                                    message: '通用的验证失败消息',
                                    feedbackIcons: {
                                        valid: 'glyphicon glyphicon-ok',
                                        invalid: 'glyphicon glyphicon-remove',
                                        validating: 'glyphicon glyphicon-refresh'
                                    },
                                    fields: {
                                        name: {
                                            validators: {
                                                notEmpty: {
                                                    message: '用户名不能为空'
                                                },
                                            }
                                        },
                                        tell: {
                                            validators: {
                                                notEmpty: {
                                                    message: '手机号不能为空！'
                                                },
                                                regexp : {
                                                    regexp: /^1[0-9]{10}$/,
                                                    message: '手机号格式不正确！'
                                                },
                                            }
                                        },
                                        times:{
                                            validators:{
                                                notEmpty:{
                                                    message:'不能为空'
                                                },
                                                numeric:{
                                                    message:'只能为数字'
                                                }
                                            }
                                        }
                                    }
                                });
                                var bootstrapValidator = $("#phoform").data('bootstrapValidator');
                                bootstrapValidator.validate();
                                if(bootstrapValidator.isValid()){
                                $.post("${ctx}/businessmanager/updateCallrecord",json).
                                done(function(data){getCode(data)}).
                                fail(function(data){getCode(data)});}
                            }
                        },{
                            label : '关闭',
                            icon: 'fa fa-close',
                            action : function(dialogItself) {
                                dialogItself.close();
                            }
                        } ]
                    });
                },
                //删除操作
                deleteRow: function(row){
                    myConfirm("${ctx}/businessmanager/deleteCallrecord",row);
                }
            }
        });

        uid = 10;

    });


</script>


</body>

</html>