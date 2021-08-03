<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>

	<title>派车通知单 </title>
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
							<li class="active">派车通知单</li>
						</ol>
					</div>
					<div class="clearfix"></div>
				</div>--%>
						<div class="panel-body">
							<div class="table-responsive">
								<table id="sendcartab" class="table" data-paging="true" data-filtering="true" data-sorting="true">
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
		var sendcartitleList = [
			{"name":"id","title":"ID","breakpoints":"xs sm",visible:false},
			{"name":"name","title":"司机姓名"},
			{"name":"department","title":"用车部门"},
			{"name":"startTime","title":"发车时间"},
			{"name":"time","title":"制单时间"},
			{"name":"passenger","title":"乘车人员"},
			{"name":"route","title":"目的地"},
			{"name":"originator","title":"制单人"},
			{"name":"remark","title":"备注"}
		];

        //启动footable
        var ft = FooTable.init('#sendcartab',{
            "columns": sendcartitleList,
            "rows": $.get("${ctx}/businessmanager/getAllList?storeId="+'<%=session.getAttribute("storeId")%>'),
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
						message:$('<div></div>').load('${ctx}/template/businessmanager/sendcar.jsp'),//加载弹出页面
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
									/* 'id': $('#id').val(),*/
									'name': $('#name').val(),
									'department': $('#department').val(),
									'startTime': $('#startTime').val(),
									'time': $('#time').val(),
									'passenger': $('#passenger').val(),
									'route': $('#route').val(),
									'originator': $('#originator').val(),
									'remark': $('#remark').val(),
									'storeId':'<%=session.getAttribute("storeId")%>'
								};

								$("#sendform").bootstrapValidator({
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
								var bootstrapValidator = $("#sendform").data('bootstrapValidator');
								bootstrapValidator.validate();
								if(bootstrapValidator.isValid()){
									$.post("${ctx}/businessmanager/addSendCar",json).
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
						message:$('<div></div>').load('${ctx}/template/businessmanager/sendcar.jsp'),//加载弹出页面
						size : BootstrapDialog.SIZE_WIDE,//弹出框大小。
						//数据回显
						onshown: function(dialogRef){

                            $(function () {
                                $.get("${ctx}/accessDepartment/getDepartments?storeId="+'<%=session.getAttribute("storeId")%>').done(function(data){
                                    for(var i=0;i<data.length;i++){
                                        if(data[i].name==values.department){
                                            $("#department").append("<option selected='selected' value='"+data[i].name+"'>"+data[i].name+"</option>");
                                        }else{
                                            $("#department").append("<option value='"+data[i].name+"'>"+data[i].name+"</option>");
                                        }

                                    }
                                });
                            });



							$('#id').val(values.id);

							$('#name').val(values.name);
							$('#department').val(values.department);
							$('#startTime').val(values.startTime);
							$('#time').val(values.time);
							$('#passenger').val(values.passenger);
							$('#route').val(values.route);
							$('#originator').val(values.originator);
							$('#remark').val(values.remark);
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
									'department': $('#department').val(),
									'startTime': $('#startTime').val(),
									'time': $('#time').val(),
									'passenger': $('#passenger').val(),
									'route': $('#route').val(),
									'originator': $('#originator').val(),
									'remark': $('#remark').val(),
									'storeId':'<%=session.getAttribute("storeId")%>'

								};
								$.post("${ctx}/businessmanager/updateSendCar",json).
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
					myConfirm("${ctx}/businessmanager/deleteSendCar",row);
				}
			}
		});

		uid = 10;

	});





</script>

</body>
</html>
