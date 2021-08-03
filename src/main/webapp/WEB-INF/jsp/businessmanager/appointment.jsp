<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>

    <title>预约客户登记 </title>
</head>
<body>
<!-- Main Content -->
<div class="page-wrapper">
    <div class="container-fluid">
        <!-- Row -->
        <div class="row">
            <div class="col-sm-12">
                    <%--<div class="panel-heading">
                        <div class="pull-left">
                            <ol class="breadcrumb">
                                <li><a href="${ctx}/index">首页</a></li>
                                <li class="active">预约客户登记</li>
                            </ol>
                        </div>
                        <div class="clearfix"></div>
                    </div>--%>
                        <div class="panel-body" >
                            <div class="table-responsive">
                                <table id="footable_appointment" class="table" data-paging="true" data-filtering="true" data-sorting="true">
                                </table>
                            </div>
                        </div>
            </div>
        </div>
        <!-- /Row -->
    </div>
</div>
<script >
    $(function () {
        var appointmentTitle = [
            {"name":"id","title":"ID",visible:false,},
            {"name":"name","title":"姓名"},
            {"name":"tell","title":"电话"},
            {"name":"sex","title":"性别"},
            {"name":"number","title":"人数"},
            {"name":"cometime","title":"预计参访时间"}
        ];
        //启动footable
        var ft = FooTable.init('#footable_appointment',{
            "columns": appointmentTitle,
            "rows": $.get("${ctx}/businessmanager/selectListAppointment?storeId="+'<%=session.getAttribute("storeId")%>'),
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
                            message:$('<div></div>').load('${ctx}/template/businessmanager/appointment.jsp'),//加载弹出页面
                            size : BootstrapDialog.SIZE_WIDE,//弹出框大小。
                            onhide:function(){
                                $that.removeAttr("disabled");
                            },
                            buttons : [{
                                id: 'btn-form-submit',
                                label: '提交',
                                icon: 'fa fa-check-circle',
                                cssClass: 'btn-primary',
                                action: function(){
                                    var json = {
                                        'name':$('#name').val(),
                                        'tell':$('#tell').val(),
                                        'sex':$('#sex').val(),
                                        'number':$('#number').val(),
                                        'cometime':$('#cometime').val(),
                                        'storeId':'<%=session.getAttribute("storeId")%>',
                                    };

                                    $("#myform").bootstrapValidator({
                                        live: 'disabled',//验证时机，enabled是内容有变化就验证（默认），disabled和submitted是提交再验证
                                        excluded: [':disabled', ':hidden', ':not(:visible)'],//排除无需验证的控件，比如被禁用的或者被隐藏的
                                        submitButtons: '#btn-test',//指定提交按钮，如果验证失败则变成disabled，但我没试成功，反而加了这句话非submit按钮也会提交到action指定页面
                                        message: '通用的验证失败消息',//好像从来没出现过
                                        feedbackIcons: {//根据验证结果显示的各种图标
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
                                            number:{
                                                validators: {
                                                    notEmpty: {
                                                        message: '人数不能为空！'
                                                    },
                                                }
                                            }
                                        }
                                    });
                                    var bootstrapValidator = $("#myform").data('bootstrapValidator');
                                    bootstrapValidator.validate();
                                    if(bootstrapValidator.isValid()){
                                        $.post("${ctx}/businessmanager/addAppointment",json).
                                        done(function(data){getCode(data)}).
                                        fail(function(data){getCode(data)});
                                    }
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
                        message:$('<div></div>').load('${ctx}/template/businessmanager/appointment.jsp'),//加载弹出页面
                        size : BootstrapDialog.SIZE_WIDE,//弹出框大小。
                        //数据回显
                        onshown: function(dialogRef){
                            $('#id').val(values.id);
                            $('#name').val(values.name);
                            $('#tell').val(values.tell);
                            $('#sex').val(values.sex);
                            $('#number').val(values.number);
                            $('#cometime').val(values.cometime);
                        },
                        buttons : [{
                            id: 'btn-form-submit',
                            label: '提交',
                            icon: 'fa fa-check-circle',
                            cssClass: 'btn-primary',
                            action: function(){
                                var json = {
                                    'id':$('#id').val(),
                                    'name':$('#name').val(),
                                    'tell':$('#tell').val(),
                                    'sex':$('#sex').val(),
                                    'number':$('#number').val(),
                                    'cometime':$('#cometime').val(),
                                    'storeId':'<%=session.getAttribute("storeId")%>',
                                };
                                $.post("${ctx}/businessmanager/updateAppointment",json).
                                done(function(data){getCode(data)}).
                                fail(function(data){getCode(data)});
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
                    myConfirm("${ctx}/businessmanager/deleteAppointment",row);
                }
            }
        });
        uid = 10;
    });
</script>
</body>
</html>
