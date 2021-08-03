<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>问题类别</title>

</head>
<body>
<!-- Main Content -->
<div class="page-wrapper">
    <div class="container-fluid">
        <!-- Row -->
        <div class="row">
            <div class="col-sm-12">
                <div class="panel-heading">
                    <%--<div class="pull-left">
                        <ol class="breadcrumb">
                            <li><a href="${ctx}/index">首页</a></li>
                            <li class="active">问题类别</li>
                        </ol>
                    </div>--%>
                    <div class="clearfix"></div>
                </div>
                    <div id="question-tabs">
                        <ul id="question_sort">

                        </ul>
                        <!--生活问题div开始-->
                        <div id="questiondiv">
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table id="questiontab" class="table" data-paging="true" data-paging="true"
                                           data-filtering="true" data-sorting="true">
                                        <input  id="stor_id" type="hidden" value="${stor_id}">
                                    </table>

                                    <!--Editor-->
                                    <div class="modal fade" id="ques-editor-modal" tabindex="-1" role="dialog" aria-labelledby="editor-title">

                                        <div class="modal-dialog" role="document">
                                            <form class="modal-content form-horizontal" id="editor">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                                                    <h5 class="modal-title" id="editor-title">Add Row</h5>
                                                </div>
                                                <div class="modal-body">
                                                    <div class="form-group required" hidden="hidden">
                                                        <label for="id" class="col-sm-3 control-label">ID</label>
                                                        <div class="col-sm-9">
                                                            <input type="text" class="form-control" id="id" name="id" placeholder="id" >
                                                        </div>
                                                    </div>
                                                    <div class="form-group required">
                                                        <label for="detail"   class="col-sm-3 control-label">问题内容</label>
                                                        <div class="col-sm-9">
                                                            <input type="text" class="form-control" id="detail" name="detail" placeholder="问题内容" required>
                                                        </div>
                                                    </div>

                                                    <div class="form-group required">
                                                        <label for="answer"   class="col-sm-3 control-label">答案</label>
                                                        <div class="col-sm-9">
                                                            <input type="text" class="form-control" id="answer" name="answer" placeholder="答案" required>
                                                        </div>
                                                    </div>


                                                </div>
                                                <div class="modal-footer">
                                                    <button type="submit" class="btn btn-primary">提交</button>
                                                    <button type="button" class="btn btn-default" data-dismiss="modal">
                                                        取消
                                                    </button>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                    <!--/Editor-->
                                </div>
                            </div>
                        </div>
                        <!--生活问题div结束-->

                    </div>

            </div>
        </div>
        <!-- /Row -->
    </div>
</div>
<script>

    $(function () {
        $("#question-tabs").tabs({
            collapsible: true
        });
    });
</script>

<script >
    $(function () {
        var stor_id=$("#stor_id").val();
        var questionTitle = [
            {"name":"id","visible":false},
            {"name":"detail","title":"问题内容"},
            {"name":"answer","title":"问题答案"}
        ];
        //启动模态框
        var $modal = $('#ques-editor-modal'),
                $editor = $('#editor'),
                $editorTitle = $('#editor-title')
        //启动footable
        var sortid = "<%=request.getParameter("sort_id")%>";
        if('<%=request.getParameter("sort_id")%>'==null||'<%=request.getParameter("sort_id")%>'=='null'){
            $.ajax({url:'${ctx}/businessmanager/selectSortId',async:false,success:function (data) {
                    sortid = data.id;
                }});
        }
        var ft = FooTable.init('#questiontab',{
            "columns": questionTitle,
            "rows": $.get("${ctx}/businessmanager/selectListQuestion?storeId="+'<%=session.getAttribute("storeId")%>'+
                "&sort_id="+sortid),
            //功能操作
            editing: {
                enabled: true,
                addRow: function(){
                    $editorTitle.text('添加一行新的数据');
                    $modal.modal('show');
                },
                //这里是修改时绑定数据
                editRow: function(row){
                    var values = row.val();
                    $editor.find('#id').val(values.id);
                    $editor.find('#detail').val(values.detail);
                    $editor.find('#answer').val(values.answer);

                    $modal.data('row', row);
                    $editorTitle.text('编辑信息' );
                    $modal.modal('show');
                },
                //删除操作
                deleteRow: function(row){
                    var values = row.val();
                    var id = values.id;
                    if (confirm('确定进行删除操作吗?')){
                       $.post('${ctx}/businessmanager/deleteQuestion',{"id":id},function (data) {
                           getCode(data);
                       })
                    }
                }
            }
        });
        uid = 10;

        $editor.on('submit', function(e){
            if (this.checkValidity && !this.checkValidity()) return;
            e.preventDefault();
            var row = $modal.data('row'),
                    values = {
                        detail: $editor.find('#detail').val(),
                        answer: $editor.find('#answer').val(),

                    };
            if (row instanceof FooTable.Row){
                //修改一条记录
                var json = {
                    'id': $editor.find('#id').val(),
                    "sortId":sortid,
                    "detail": $editor.find('#detail').val(),
                    "answer": $editor.find('#answer').val(),
                    "storeId":'<%=session.getAttribute("storeId")%>'
                }
                $.post('${ctx}/businessmanager/updateQuestion',json,function (data) {
                    getCode(data);
                })
            } else {
                var json = {
                    "sortId":sortid,
                    "detail": $editor.find('#detail').val(),
                    "answer": $editor.find('#answer').val(),
                    "storeId":'<%=session.getAttribute("storeId")%>'
                }
                $.post('${ctx}/businessmanager/addQuestion',json,function (data) {
                    getCode(data);
                })
            }
            $modal.modal('hide');
        });
    });
</script>
<script>
    $.ajax({
        type: "GET",
        url: "${ctx}/businessmanager/selectQuestionSortList",
        success: function (data) {
            var str = "";
            for (var i = 0; i < data.length; i++) {
                str += "<li>"+"<a href='getquestionList?sort_id="+data[i].id+"'>" + data[i].classification + "</a>"+"</li>";
            }
            $("#question_sort").append(str);
        }
    });
</script>
</body>

</html>
