<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <title>生产联络</title>
    <style type="text/css">
        html, body { width: 100%; height: 100%; overflow:hidden;}
        .column { display: inline-block; width: 100%; height: 58%;}
    </style>
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
                            <li class="active">生产联络单</li>
                        </ol>
                    </div>
                    <div class="clearfix"></div>
                </div>--%>
                    <!--生产联络单-->
                    <div id="repairdiv">
                        <div class="panel-body" >
                            <div class="table-wrap">
                                <table id="contacttab" class="table" data-paging="true" data-filtering="true" data-sorting="true" style="width:200%">
                                </table>
                            </div>
                        </div>
                    </div>


                    <!--生产联络单-->
                </div>

        </div>
        <!-- /Row -->
    </div>
</div>

<script>
    $(function () {
        var contacttitleList = [
            {"name": "id", "title": "ID", "breakpoints": "xs sm", visible: false},
            {"name": "name", "title": "妈妈姓名"},
            {"name": "tell", "title": "电话"},
            {"name": "liaison", "title": "联络人"},
            {"name": "liaisontell", "title": "联络人电话"},
            {"name": "relation", "title": "关系"},
            {"name": "babybirth", "title": "生产日期"},
            {"name": "height", "title": "宝宝体重（克）", visible: false},
            {"name": "sex", "title": "宝宝性别", visible: false},
            {"name": "birthindex", "title": "胎数", visible: false},
            {"name": "method", "title": "生产方式", visible: false},
            {"name": "hospital", "title": "生产医院", visible: false},
            {"name": "doctor", "title": "派遣月嫂", visible: false},
            {"name": "intime", "title": "预计入馆时间", visible: false},
            {"name": "callintime", "title": "接获通知时间", visible: false},
            {"name": "sickroom", "title": "在院病房"},
            {"name": "roomNum", "title": "预定会所房间号"},
            {"name": "days", "title": "订房天数", visible: false},
            {"name": "remark", "title": "备注", visible: false},
            {"name": "details", "title": "详情"}

        ];
        //启动模态框
        var $modal = $('#app-editor-modal'),
                $editor = $('#editor'),
                $editorTitle = $('#editor-title')
        //启动footable
        var ft = FooTable.init('#contacttab', {
            "columns": contacttitleList,
            "rows": $.get("${ctx}/businessmanager/selectAllContact?storeId="+'<%=session.getAttribute("storeId")%>', function (data) {
                $(data).each(function () {
                    this.details = "<button id='cx' class='btn btn-primary btn-sm'  onclick='findDetails(" + JSON.stringify(this) + ")'>查看信息</button>";
                });
                //
                return data;
            }),
            //功能操作
            editing: {
                enabled: true,
                addRow: function () {
                    //新增模态框
                    var $that = $(this);
                    var dialog = BootstrapDialog.show({
                        type: BootstrapDialog.TYPE_DEFAULT,
                        title: "<span style=\"color: #ab8ce4\"><i></i>新增一条数据</span>",
                        closable: false,
                        draggable: true,
                        cssClass: 'api-blacklist-form-add',
                        message: $('<div></div>').load('${ctx}/template/businessmanager/contact.jsp'),//加载弹出页面
                        size: BootstrapDialog.SIZE_WIDE,//弹出框大小。
                        onhide: function () {
                            $that.removeAttr("disabled");
                        },
                        buttons: [{
                            id: 'btn-form-submit',
                            label: '提交',
                            icon: 'fa fa-check-circle',
                            cssClass: 'btn-primary',
                            action: function () {
                                var json = {

                                    'id': $('#id').val(),
                                    'name': $('#name').val(),
                                    'tell': $('#tell').val(),
                                    'height': $('#height').val(),
                                    'babybirth': $('#babybirth').val(),
                                    'sex': $('#sex').val(),
                                    'birthindex': $('#birthindex').val(),
                                    'method': $('#method').val(),
                                    'hospital': $('#hospital').val(),
                                    'doctor': $('#doctor').val(),
                                    'intime': $('#intime').val(),
                                    'sickroom': $('#sickroom').val(),
                                    'roomNum': $('#roomNum').val(),
                                    'days': $('#days').val(),
                                    'liaison': $('#liaison').val(),
                                    'liaisontell': $('#liaisontell').val(),
                                    'relation': $('#relation').val(),
                                    'callintime': $('#callintime').val(),
                                    'remark': $('#remark').val(),
                                    'storeId': '<%=session.getAttribute("storeId")%>'

                                };
                                $("#conform").bootstrapValidator({
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
                                var bootstrapValidator = $("#conform").data('bootstrapValidator');
                                bootstrapValidator.validate();
                                if(bootstrapValidator.isValid()){
                                    $.post("${ctx}/businessmanager/addContact", json).
                                    done(function (data) {
                                        getCode(data)
                                    }).
                                    fail(function (data) {
                                        getCode(data)
                                    });
                                }

                            }
                        }, {
                            label: '关闭',
                            icon: 'fa fa-close',
                            action: function (dialogItself) {
                                dialogItself.close();
                            }
                        }]
                    });
                },
                //这里是修改时绑定数据
                editRow: function (row) {
                    var values = row.val();
                    var $that = $(this);

                    $that.attr("disabled", "disabled");
                    // 调用add方法
                    var dialog = BootstrapDialog.show({
                        type: BootstrapDialog.TYPE_DEFAULT,
                        title: "<span style=\"color: #ab8ce4\"><i></i>修改一条数据</span>",
                        closable: false,
                        draggable: true,
                        cssClass: 'api-blacklist-form-add',
                        message: $('<div></div>').load('${ctx}/template/businessmanager/contact.jsp'),//加载弹出页面
                        size: BootstrapDialog.SIZE_WIDE,//弹出框大小。
                        //数据回显
                        onshown: function (dialogRef) {
                            $('#id').val(values.id);
                            $('#name').val(values.name);
                            $('#tell').val(values.tell);
                            $('#height').val(values.height);
                            $('#babybirth').val(values.babybirth);
                            $('#sex').val(values.sex);
                            $('#birthindex').val(values.birthindex);
                            $('#method').val(values.method);
                            $('#hospital').val(values.hospital);
                            $('#doctor').val(values.doctor);
                            $('#intime').val(values.intime);
                            $('#sickroom').val(values.sickroom);
                            $('#roomNum').val(values.roomNum);
                            $('#days').val(values.days);
                            $('#liaison').val(values.liaison);
                            $('#liaisontell').val(values.liaisontell);
                            $('#relation').val(values.relation);
                            $('#callintime').val(values.callintime);
                            $('#remark').val(values.remark);
                        },
                        buttons: [{
                            id: 'btn-form-submit',
                            label: '提交',
                            icon: 'fa fa-check-circle',
                            cssClass: 'btn-primary',
                            action: function () {
                                var json = {
                                    'id': $('#id').val(),
                                    'name': $('#name').val(),
                                    'tell': $('#tell').val(),
                                    'height': $('#height').val(),
                                    'babybirth': $('#babybirth').val(),
                                    'sex': $('#sex').val(),
                                    'birthindex': $('#birthindex').val(),
                                    'method': $('#method').val(),
                                    'hospital': $('#hospital').val(),
                                    'doctor': $('#doctor').val(),
                                    'intime': $('#intime').val(),
                                    'sickroom': $('#sickroom').val(),
                                    'roomNum': $('#roomNum').val(),
                                    'days': $('#days').val(),
                                    'liaison': $('#liaison').val(),
                                    'liaisontell': $('#liaisontell').val(),
                                    'relation': $('#relation').val(),
                                    'callintime': $('#callintime').val(),
                                    'remark': $('#remark').val(),
                                    'storeId': '<%=session.getAttribute("storeId")%>'
                                };
                                $.post("${ctx}/businessmanager/updateContact", json).
                                done(function (data) {
                                    getCode(data)
                                }).
                                fail(function (data) {
                                    getCode(data)
                                });
                            }
                        }, {
                            label: '关闭',
                            icon: 'fa fa-close',
                            action: function (dialogItself) {
                                dialogItself.close();
                            }
                        }]
                    });
                },
                //删除操作
                deleteRow: function (row) {
                    myConfirm("${ctx}/businessmanager/deleteContact", row)
                }
            }
        });
        uid = 10;
    });

    function findDetails(values) {

        var dialog = BootstrapDialog.show({
            type: BootstrapDialog.TYPE_DEFAULT,
            title: "<span style=\"color: #ab8ce4\"><i></i>生产联络单详细信息</span>",
            closable: false,
            draggable: true,
            cssClass: 'api-blacklist-form-add',
            message: $('<div></div>').load('${ctx}/template/businessmanager/contact.jsp'),//加载弹出页面
            size: BootstrapDialog.SIZE_WIDE,//弹出框大小。
            //数据回显
            onshown: function (dialogRef) {
                $('#conform').find('input,select').attr('readonly',true);
                $('#id').val(values.id);
                $('#name').val(values.name);
                $('#tell').val(values.tell);
                $('#height').val(values.height);
                $('#babybirth').val(values.babybirth);
                $('#sex').val(values.sex);
                $('#birthindex').val(values.birthindex);
                $('#method').val(values.method);
                $('#hospital').val(values.hospital);
                $('#doctor').val(values.doctor);
                $('#intime').val(values.intime);
                $('#sickroom').val(values.sickroom);
                $('#roomNum').val(values.roomNum);
                $('#days').val(values.days);
                $('#liaison').val(values.liaison);
                $('#liaisontell').val(values.liaisontell);
                $('#relation').val(values.relation);
                $('#callintime').val(values.callintime);
                $('#remark').val(values.remark);

            },
            buttons: [{
                id: 'btn-form-submit',

                label: '关闭',
                icon: 'fa fa-close',
                action: function (dialogItself) {
                    dialogItself.close();
                }
            }]
        });
    }
</script>
</body>
</html>
