<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<title>订单信息表 </title>
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
							<li class="active">订单信息</li>
						</ol>
					</div>
					<div class="clearfix"></div>
				</div>--%>
					<!--订单信息表开始-->
					<div id="repairdiv">
						<div class="panel-body" >
							<div class="table-responsive">
								<!--底部滚动条    开始-->
								<div id="os1" class="optiscroll column mid-80">
									<table id="ordertab" class="table" data-paging="true" data-filtering="true" data-sorting="true" style="width:200%">
									</table>
								</div>
							</div>
						</div>
					</div>
					<!--订单信息表结束-->

			</div>
		</div>
	</div>
</div>
<script >
	$(function () {
		var ordertitleList = [
			{"name":"id","title":"ID",visible:false,},
			{"name":"firstParty","title":"宝妈"},
			{"name":"cardId","title":"宝妈身份证","visible":false},
            {"name":"tell","title":"宝妈电话","visible":false},
            {"name":"fathername","title":"宝爸姓名","visible":false},
            {"name":"fathertell","title":"宝爸电话","visible":false},
            {"name":"address","title":"生产医院"},
            {"name":"bornTimes","title":"胎次","visible":false},
			{"name":"intime","title":"预产期","visible":false},
			{"name":"borndate","title":"实际生产期","visible":false},
			{"name":"days","title":"订房天数","visible":false},
			{"name":"roomType","title":"预定房型"},
			{"name":"roomNumber","title":"预定会所房间号"},
			{"name":"price","title":"总费用"},
			{"name":"bargainMoney","title":"缴纳金额"},
			{"name":"payWay","title":"支付方式"},
			{"name":"finalPaymentStatus","title":"尾款状态"},
			{"name":"operator","title":"经办人"},
			{"name":"remark","title":"备注","visible":false},
            {"name":"detail","title":"查看详细"}
		];
		function find(values) {
            var dialog = BootstrapDialog.show({
                type : BootstrapDialog.TYPE_DEFAULT,
                title : "<span style=\"color: #ab8ce4\"><i></i>查看一条数据</span>",
                closable: false,
                draggable: true,
                cssClass: 'api-blacklist-form-add',
                message:$('<div></div>').load('${ctx}/template/businessmanager/orderdetail.jsp'),//加载弹出页面
                size : BootstrapDialog.SIZE_WIDE,//弹出框大小。
                //数据回显
                onshown: function(dialogRef){
                    $(function () {
                        $.get("${ctx}/roomStyles/getRoomStylesList?storeId="+'<%=session.getAttribute("storeId")%>').done(function(data){
                            for(var i=0;i<data.length;i++){
                                if(data[i].roomStyle==values.roomType){
                                    $("#roomType").append("<option selected='selected' value='"+data[i].id+"'>"+data[i].roomStyle+"</option>");
                                }else{
                                    $("#roomType").append("<option value='"+data[i].id+"'>"+data[i].roomStyle+"</option>");
                                }

                            }
                        });
                        $.get("${ctx}/room/getRooms?storeId="+'<%=session.getAttribute("storeId")%>').done(function(data) {
                            for (var i = 0; i < data.length; i++) {
                                if(data[i].num==values.roomNumber){
                                    $("#roomNumber").append("<option selected='selected' value='"+data[i].id+"'>"+ data[i].classify +data[i].num+"</option>");
                                }else{
                                    $("#roomNumber").append("<option value='" + data[i].id + "'>" + data[i].classify + data[i].num + "</option>");
                                }
                            }

                        });
                    });
                    $('#id').val(values.id);
                    $('#firstParty').val(values.firstParty);
                    $('#cardId').val(values.cardId);
                    $('#address').val(values.address);
                    $('#tell').val(values.tell);
                    $('#fathername').val(values.fathername);
                    $('#fathertell').val(values.fathertell);
                    $('#bornTimes').val(values.bornTimes);
                    $('#intime').val(values.intime);
                    $('#borndate').val(values.borndate);
                    $('#days').val(values.days);
                    $('#roomType').val(values.roomType);
                    $('#roomNumber').val(values.roomNumber);
                    $('#price').val(values.price);
                    $('#bargainMoney').val(values.bargainMoney);
                    $('#payWay').val(values.payWay);
                    $('#finalPaymentStatus').val(values.finalPaymentStatus);
                    $('#operator').val(values.operator);
                    $('#remark').val(values.remark);
					$('#orderform').find('input,select,textarea').attr("disabled","disabled");
                },
                buttons : [{
                    id: 'btn-form-submit',
                    label: '提交',
                    icon: 'fa fa-check-circle',
                    cssClass: 'btn-primary',
                    action: function(){
                        var json = {
                            'id':$('#id').val(),
                            'firstParty':$('#firstParty').val(),
                            'cardId':$('#cardId').val(),
                            'address':$('#address').val(),
                            'tell':$('#tell').val(),
                            'fathername':$('#fathername').val(),
                            'fathertell':$('#fathertell').val(),
                            'bornTimes':$('#bornTimes').val(),
                            'medicalHistory':$('#medicalHistory').val(),
                            'intime':$('#intime').val(),
                            'borndate':$('#borndate').val(),
                            'days':$('#days').val(),
                            'roomType':$('#roomType').val(),
                            'roomNumber':$('#roomNumber').val(),
                            'price':$('#price').val(),
                            'bargainMoney':$('#bargainMoney').val(),
                            'payWay':$('#payWay').val(),
                            'finalPaymentStatus':$('#finalPaymentStatus').val(),
                            'operator':$('#operator').val(),
                            'remark':$('#remark').val(),
                        };
                        $("#orderform").bootstrapValidator({
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
                                            message: '姓名不能为空'
                                        },
                                    }
                                },
                                tell: {
                                    validators: {
                                        notEmpty: {
                                            message: '手机号不能为空！'
                                        },
                                        regexp: {
                                            regexp: /^[1][3,4,5,7,8][0-9]{9}$/,
                                            message: '手机号格式不正确！'
                                        },
                                    }
                                },

                                positionNum: {
                                    validators: {
                                        notEmpty: {
                                            message: '编号不能为空！'
                                        },
                                    }
                                },
                                email: {
                                    validators: {
                                        notEmpty: {
                                            message: '邮箱不能为空！'
                                        },
                                        regexp: {
                                            regexp: /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/,
                                            message: '邮箱格式不正确！'
                                        }
                                    }
                                },
                                cardId: {
                                    validators: {
                                        notEmpty: {
                                            message: '身份证不能为空！'
                                        },
                                    }
                                },
                                workId: {
                                    validators: {
                                        notEmpty: {
                                            message: '工作证不能为空！'
                                        },
                                    }
                                },
                                criticalPerson: {
                                    validators: {
                                        notEmpty: {
                                            message: '紧急联络人不能为空！'
                                        },
                                    }
                                },
                                criticalTell: {
                                    validators: {
                                        notEmpty: {
                                            message: '手机号不能为空！'
                                        },
                                        regexp: {
                                            regexp: /^[1][3,4,5,7,8][0-9]{9}$/,
                                            message: '紧急联络人手机号格式不正确！'
                                        },
                                    }
                                },
                            }
                        });
                        var bootstrapValidator = $("#orderform").data('bootstrapValidator');
                        bootstrapValidator.validate();
                        if (bootstrapValidator.isValid()) {
                            $.post("${ctx}/businessmanager/updateOrderCustomer", json).done(function (data) {
                                getCode(data);
                            }).fail(function (data) {
                                getCode(data)
                            });
                        }
                    }
                },
                    {
                        label : '关闭',
                        icon: 'fa fa-close',
                        action : function(dialogItself) {
                            dialogItself.close();
                        }
                    } ]
            });
        }
        window.find=find;
        //启动footable
        var ft = FooTable.init('#ordertab',{
            "columns": ordertitleList,
            "rows": $.get("${ctx}/businessmanager/getOrderCustomers?storeId="+'<%=session.getAttribute("storeId")%>',function (data) {
				$(data).each(function () {
					this.detail = "<button class='btn btn-primary btn-sm' onclick='find("+JSON.stringify(this)+")'>查看详细</button>"
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
						message:$('<div></div>').load('${ctx}/template/businessmanager/order.jsp'),//加载弹出页面
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
									'firstParty':$('#firstParty').val(),
                                    'storeId':'<%=session.getAttribute("storeId")%>',
									'cardId':$('#cardId').val(),
									'address':$('#address').val(),
									'tell':$('#tell').val(),
									'fathername':$('#fathername').val(),
									'fathertell':$('#fathertell').val(),
									'bornTimes':$('#bornTimes').val(),
									'intime':$('#intime').val(),
									'borndate':$('#borndate').val(),
									'days':$('#days').val(),
									'roomType':$('#roomType').val(),
									'roomNumber':$('#roomNumber').val(),
									'price':$('#price').val(),
									'bargainMoney':$('#bargainMoney').val(),
									'payWay':$('#payWay').val(),
									'finalPaymentStatus':$('#finalPaymentStatus').val(),
									'operator':$('#operator').val(),
									'remark':$('#remark').val(),
								};

								$("#orderform").bootstrapValidator({
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
								var bootstrapValidator = $("#orderform").data('bootstrapValidator');
								bootstrapValidator.validate();
								if(bootstrapValidator.isValid()){
									$.post("${ctx}/businessmanager/addOrderCustomer",json).
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
						message:$('<div></div>').load('${ctx}/template/businessmanager/order.jsp'),//加载弹出页面
						size : BootstrapDialog.SIZE_WIDE,//弹出框大小。
						//数据回显
						onshown: function(dialogRef){
                            $(function () {
                                $.get("${ctx}/roomStyles/getRoomStylesList?storeId="+'<%=session.getAttribute("storeId")%>').done(function(data){
                                    $("#roomType option").remove();
                                    for(var i=0;i<data.length;i++){
                                        if(data[i].roomStyle==values.roomType){
                                            $("#roomType").append("<option selected='selected' value='"+data[i].id+"'>"+data[i].roomStyle+"</option>");
                                        }else{
                                            $("#roomType").append("<option value='"+data[i].id+"'>"+data[i].roomStyle+"</option>");
                                        }

                                    }
                                    $.get("${ctx}/room/selectByRoomStyleId?roomStylesId="+$("#roomType").val()).done(function(data) {
                                        $("#roomNumber option").remove();
                                        for (var i = 0; i < data.length; i++) {
                                            if(data[i].num==values.roomNumber){
                                                $("#roomNumber").append("<option selected='selected' value='"+data[i].id+"'>"+ data[i].classify +data[i].num+"</option>");
                                            }else{
                                                $("#roomNumber").append("<option value='" + data[i].id + "'>" + data[i].classify + data[i].num + "</option>");
                                            }
                                        }

                                    });
                                });

                            });

							$('#id').val(values.id);
							$('#firstParty').val(values.firstParty);
							$('#cardId').val(values.cardId);
							$('#address').val(values.address);
							$('#tell').val(values.tell);
							$('#fathername').val(values.fathername);
							$('#fathertell').val(values.fathertell);
							$('#bornTimes').val(values.bornTimes);
                            $('#borndate').val(values.borndate);
							$('#intime').val(values.intime);
							$('#days').val(values.days);
							$('#roomType').val(values.roomType);
							$('#roomNumber').val(values.roomNumber);
							$('#price').val(values.price);
							$('#bargainMoney').val(values.bargainMoney);
							$('#payWay').val(values.payWay);
							$('#finalPaymentStatus').val(values.finalPaymentStatus);
							$('#operator').val(values.operator);
							$('#remark').val(values.remark);

						},
						buttons : [{
							id: 'btn-form-submit',
							label: '提交',
							icon: 'fa fa-check-circle',
							cssClass: 'btn-primary',
							action: function(){
								var json = {
									'id':$('#id').val(),
									'firstParty':$('#firstParty').val(),
									'cardId':$('#cardId').val(),
									'address':$('#address').val(),
									'tell':$('#tell').val(),
                                    'fathername':$('#fathername').val(),
                                    'fathertell':$('#fathertell').val(),
                                    'bornTimes':$('#bornTimes').val(),
									'medicalHistory':$('#medicalHistory').val(),
									'intime':$('#intime').val(),
									'borndate':$('#borndate').val(),
									'days':$('#days').val(),
									'roomType':$('#roomType').val(),
									'roomNumber':$('#roomNumber').val(),
									'price':$('#price').val(),
									'bargainMoney':$('#bargainMoney').val(),
									'payWay':$('#payWay').val(),
									'finalPaymentStatus':$('#finalPaymentStatus').val(),
									'operator':$('#operator').val(),
									'remark':$('#remark').val(),
								};
								$("#orderform").bootstrapValidator({
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
													message: '姓名不能为空'
												},
											}
										},
										tell: {
											validators: {
												notEmpty: {
													message: '手机号不能为空！'
												},
												regexp: {
													regexp: /^[1][3,4,5,7,8][0-9]{9}$/,
													message: '手机号格式不正确！'
												},
											}
										},

										positionNum: {
											validators: {
												notEmpty: {
													message: '编号不能为空！'
												},
											}
										},
										email: {
											validators: {
												notEmpty: {
													message: '邮箱不能为空！'
												},
												regexp: {
													regexp: /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/,
													message: '邮箱格式不正确！'
												}
											}
										},
										cardId: {
											validators: {
												notEmpty: {
													message: '身份证不能为空！'
												},
											}
										},
										workId: {
											validators: {
												notEmpty: {
													message: '工作证不能为空！'
												},
											}
										},
										criticalPerson: {
											validators: {
												notEmpty: {
													message: '紧急联络人不能为空！'
												},
											}
										},
										criticalTell: {
											validators: {
												notEmpty: {
													message: '手机号不能为空！'
												},
												regexp: {
													regexp: /^[1][3,4,5,7,8][0-9]{9}$/,
													message: '紧急联络人手机号格式不正确！'
												},
											}
										},
									}
								});
								var bootstrapValidator = $("#orderform").data('bootstrapValidator');
								bootstrapValidator.validate();
								if (bootstrapValidator.isValid()) {
									$.post("${ctx}/businessmanager/updateOrderCustomer", json).done(function (data) {
										getCode(data);
									}).fail(function (data) {
										getCode(data)
									});
								}
							}
						},
							{
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
					myConfirm("${ctx}/businessmanager/deleteOrderCustomer",row);
				}
			}
		});
		uid = 10;
	});
</script>
</body>
</html>
