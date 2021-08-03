<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>

    <title>今日预约客户 </title>
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
            "rows": $.get("${ctx}/businessmanager/selectListappointmentToday?storeId="+'<%=session.getAttribute("storeId")%>'),
            //功能操作
            editing: {
                enabled: true,
            }
        });
        uid = 10;
    });
</script>
</body>
</html>
