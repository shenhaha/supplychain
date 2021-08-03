<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <title>参访客户信息登记</title>
</head>
<body>

<!-- Main Content -->
<div class="page-wrapper">
    <div class="container-fluid">
        <!-- Row -->
        <div class="row">
            <div class="col-sm-12">
                <div class="panel-heading">
                    <div class="pull-left" >
                        <ol class="breadcrumb">
                           <%-- <li><a href="${ctx}/index"></a></li>--%>
                            <li id="point1" class="active">已签约</li>
                            <input type="button" id="type1" class='btn btn-primary btn-sm' onclick="change1()" value="已签约" style="display: none">
                            <input type="button" id="type2" class='btn btn-primary btn-sm' onclick="change2()" value="已放弃">
                            <input type="button" id="type3" class='btn btn-primary btn-sm' onclick="change3()" value="追踪中" >
                        </ol>
                    </div>

                    <div class="clearfix"></div>
                </div>
                <!--预约客户开始-->
                <div id="customdiv" class="panel-wrapper collapse in">
                    <div class="panel-body">
                        <div class="table-responsive">
                            <table id="customtab" class="table" data-paging="true" data-filtering="true"
                                   data-sorting="true">
                            </table>


                        </div>
                    </div>
                </div>
                <!--预约客户结束-->
            </div>
        </div>
    </div>
    <!-- /Row -->


</div>

<script>
    var level="";
    $(document).ready(function () {
        level="追踪中";
    })
    $(function () {
        var customtitleList = [
            {"name": "id", "title": "ID", visible: false,},
            {"name": "storeId", "title": "storeId", visible: false,},
            {"name": "name", "title": "参访客户人姓名"},
            {"name": "tell", "title": "参访客户人电话"},
            {"name": "weChat", "title": "参访客户人微信"},
            {"name": "level", "title": "状态"},
            {"name": "inTime", "title": "参访时间"},
            {"name": "outTime", "title": "离馆时间"},
            {"name": "health", "title": "健康状况"},
            {"name": "temperature", "title": "体温"},
            {"name": "cough", "title": "咳嗽"},
            {"name": "excepted", "title": "异常情况"},

        ];
        //启动footable
        var ft = FooTable.init('#customtab', {
            "columns": customtitleList,
            "rows": $.get("${ctx}/businessmanager/getVisitor3?classification=3&level=" + '已签约' + "&storeId=" + '<%=session.getAttribute("storeId")%>'),
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
                        message: $('<div></div>').load('${ctx}/template/businessmanager/customvisit.jsp'),//加载弹出页面
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
                                    'weChat': $('#weChat').val(),
                                    'health': $('#health').val(),
                                    'temperature': $('#temperature').val(),
                                    'cough': $('#cough').val(),
                                    'excepted': $('#excepted').val(),
                                    'inTime': $('#inTime').val(),
                                    'outTime': $('#outTime').val(),
                                    'storeId': '<%=session.getAttribute("storeId")%>',
                                    'storeName': $('#storeName').val(),
                                    'level': $('#level').val()
                                };

                                $("#custform").bootstrapValidator({
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
                                                regexp: {
                                                    regexp: /^1[0-9]{10}$/,
                                                    message: '手机号格式不正确！'
                                                },
                                            }
                                        },
                                        number: {
                                            validators: {
                                                notEmpty: {
                                                    message: '人数不能为空！'
                                                },
                                            }
                                        }
                                    }
                                });
                                var bootstrapValidator = $("#custform").data('bootstrapValidator');
                                bootstrapValidator.validate();
                                if (bootstrapValidator.isValid()) {
                                    $.post("${ctx}/businessmanager/addVisitor?classification=3", json).done(function (data) {
                                        getCode(data)
                                    }).fail(function (data) {
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
                    //失效
                    $that.attr("disabled", "disabled");
                    // 调用add方法
                    var dialog = BootstrapDialog.show({
                        type: BootstrapDialog.TYPE_DEFAULT,
                        title: "<span style=\"color: #ab8ce4\"><i></i>修改一条数据</span>",
                        closable: false,
                        draggable: true,
                        cssClass: 'api-blacklist-form-add',
                        message: $('<div></div>').load('${ctx}/template/businessmanager/customvisit.jsp'),//加载弹出页面
                        size: BootstrapDialog.SIZE_WIDE,//弹出框大小。
                        //数据回显
                        onshown: function (dialogRef) {
                            $('#id').val(values.id);
                            $('#storeId').val(values.storeId);
                            $('#name').val(values.name);
                            $('#tell').val(values.tell);
                            $('#weChat').val(values.weChat);
                            $('#health').val(values.health);
                            $('#cough').val(values.cough);
                            $('#excepted').val(values.excepted);
                            $('#inTime').val(values.inTime);
                            $('#outTime').val(values.outTime);
                            $('#storeId').val(values.storeId);
                            $('#storeName').val(values.storeName);
                            $('#level').val(values.level);
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
                                    'weChat': $('#weChat').val(),
                                    'health': $('#health').val(),
                                    'temperature': $('#temperature').val(),
                                    'cough': $('#cough').val(),
                                    'excepted': $('#excepted').val(),
                                    'inTime': $('#inTime').val(),
                                    'outTime': $('#outTime').val(),
                                    'storeId': '<%=session.getAttribute("storeId")%>',
                                    'storeName': $('#storeName').val(),
                                    'level': $('#level').val()
                                };
                                $.post("${ctx}/businessmanager/updateVisitor", json).done(function (data) {
                                    getCode(data)
                                }).fail(function (data) {
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
                    myConfirm("${ctx}/businessmanager/deleteVisitor", row);
                }
            }
        });

        uid = 10;

    });



    function change2() {
        window.location.href = "${ctx}/businessmanager/visit5" ;
    };

    function change3() {
        window.location.href = "${ctx}/businessmanager/visit3" ;
    };
</script>

</body>

</html>
