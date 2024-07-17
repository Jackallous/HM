<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2024/7/13
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String contextPath = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + contextPath + "/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
<base href="<%=basePath%>">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
    <script>
        //提交表单的事件，
        function submitFormData(){
            //获取表单对象提交
            $("#listform").submit();
        }

        function getPage(page){
            //设置当前页到查询表单
            $("#page").val(page);
            $("#listform").submit();
        }

        function deleteById(id){
            if(confirm("确定删除吗？")){
                window.location.href="${pageContext.request.contextPath}/schedule/deleteById?sid="+id;
            }
        }
    </script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head">
        <form method="post" action="${pageContext.request.contextPath}/schedule/getScheduleList" id="listform">
        <div class="padding border-bottom">
            <ul class="search" style="padding-left:10px;">
                <li>搜索：</li>
                <if condition="$iscid eq 1">
                    <li>
                        <%--                        设置的是用户请求的当前页--%>
                        <input type="hidden" name="page" id="page" value="1">
                        <select name="did" class="input" style="width:200px; line-height:17px;" onchange="changesearch()">
                            <option value="-1">请选择科室</option>
                            <c:forEach items="${dListLevelt}" var="d">
                                <option value="${d.departmentId}" ${did == d.departmentId?"selected":""}>${d.departmentName}</option>
                            </c:forEach>
                        </select>
                    </li>
                </if>
                <li>
                    <input type="date" class="input" name="date" value="${date}" />
<%--                    <input type="datetime-local" class="input" name="date" value="" />--%>
                </li>
                <li>
                    <%--                    <input type="text" placeholder="请输入医生姓名" value="${doctorQuery.dname}" name="dname" class="input" style="width:150px; line-height:17px;display:inline-block" />--%>
                    <%--                    <input type="text" placeholder="请输入医生工号" value="${doctorQuery.jobnum}" name="jobnum" class="input" style="width:150px; line-height:17px;display:inline-block" />--%>
                    <a href="javascript:void(0)" class="button border-main icon-search" onclick="submitFormData()"> 搜索</a></li>
                <li> <a class="button border-main icon-plus-square-o" href="${pageContext.request.contextPath}/addSchedule.jsp"> 添加排班</a> </li>
            </ul>
        </div>
    </form><a href="" style="float:right; display:none;">添加字段</a></div>

    <table class="table table-hover text-center">
        <tr>
            <%--                <th width="100" style="text-align:left; padding-left:20px;">工号</th>--%>
            <%--                <th width="10%">排序</th>--%>
            <%--                <th>图片</th>--%>
            <%--                <th>名称</th>--%>
            <%--                <th>属性</th>--%>
            <%--                <th>分类名称</th>--%>
            <%--                <th width="10%">更新时间</th>--%>
            <%--                <th width="310">操作</th>--%>
<%--            <th width="100" style="text-align:left; padding-left:20px;">编号</th>--%>
<%--            <th width="10%">工号</th>--%>
            <th>排班编号</th>
            <th>医生姓名</th>
            <th>日期</th>
            <th>时间</th>
            <th>科室</th>
            <th>排班状态</th>
            <th>放号数</th>
            <th>备注信息</th>
            <th width="310">操作</th>
        </tr>
        <volist name="list" id="vo">
            <c:forEach items="${pageInfo.list}" var="sche">
            <tr id="tr_${sche.scheduleId}">
                <td >${sche.scheduleId}</td>
                <td>${sche.doctor.name}</td>
                <td >${sche.date}</td>
                <td>${sche.shiftTime}</td>
                <td>${sche.department.departmentName}</td>
                <td>${sche.isAvailable}</td>
                <td>${sche.visitCount}</td>
                <td>${sche.remarks}</td>
                <td><div class="button-group"> <a class="button border-main" href="${pageContext.request.contextPath}/schedule/getScheduleById?sid=${sche.scheduleId}"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="javascript:void(0)" onclick="deleteById(${sche.scheduleId})"> <span class="icon-trash-o"></span> 删除</a></div></td>
            </tr>
            </c:forEach>
            <tr>
                <td colspan="9">
                    <div class="pagelist">
<%--                        ${pageInfo}--%>
                        <span >总记录数:${pageInfo.total}</span>
<%--                        <span >pre:${PageInfo.prePage}</span>--%>
<%--                        <span >next:${PageInfo.nextPage}</span>--%>
                        <a href="javascript:void(0)" onclick="getPage(${pageInfo.prePage})" >上一页</a>
                        <c:forEach items="${pageInfo.navigatepageNums}" var="num">
                            <%--                            ${num}--%>
                            <c:choose>
                                <c:when test="${num == pageInfo.pageNum}">
                                    <span class="current">${num}</span>
                                </c:when>
                                <c:otherwise>
                                    <a href="javascript:void(0)" onclick="getPage(${num})">${num}</a>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                        <a href="javascript:void(0)" onclick="getPage(${pageInfo.nextPage})" >下一页</a>
                        <a href="javascript:void(0)" onclick="getPage(${pageInfo.pages})" >尾页</a>
                    </div>
                </td>
            </tr>
    </table>
</div>
</form>
<script type="text/javascript">

    //搜索
    function changesearch(){

    }

    //单个删除
    function del(id,mid,iscid){
        if(confirm("您确定要删除吗?")){

        }
    }

    //全选
    $("#checkall").click(function(){
        $("input[name='id[]']").each(function(){
            if (this.checked) {
                this.checked = false;
            }
            else {
                this.checked = true;
            }
        });
    })

    //批量删除
    function DelSelect(){
        var Checkbox=false;
        $("input[name='id[]']").each(function(){
            if (this.checked==true) {
                Checkbox=true;
            }
        });
        if (Checkbox){
            var t=confirm("您确认要删除选中的内容吗？");
            if (t==false) return false;
            $("#listform").submit();
        }
        else{
            alert("请选择您要删除的内容!");
            return false;
        }
    }

    //批量排序
    function sorts(){
        var Checkbox=false;
        $("input[name='id[]']").each(function(){
            if (this.checked==true) {
                Checkbox=true;
            }
        });
        if (Checkbox){

            $("#listform").submit();
        }
        else{
            alert("请选择要操作的内容!");
            return false;
        }
    }


    //批量首页显示
    function changeishome(o){
        var Checkbox=false;
        $("input[name='id[]']").each(function(){
            if (this.checked==true) {
                Checkbox=true;
            }
        });
        if (Checkbox){

            $("#listform").submit();
        }
        else{
            alert("请选择要操作的内容!");

            return false;
        }
    }

    //批量推荐
    function changeisvouch(o){
        var Checkbox=false;
        $("input[name='id[]']").each(function(){
            if (this.checked==true) {
                Checkbox=true;
            }
        });
        if (Checkbox){


            $("#listform").submit();
        }
        else{
            alert("请选择要操作的内容!");

            return false;
        }
    }

    //批量置顶
    function changeistop(o){
        var Checkbox=false;
        $("input[name='id[]']").each(function(){
            if (this.checked==true) {
                Checkbox=true;
            }
        });
        if (Checkbox){

            $("#listform").submit();
        }
        else{
            alert("请选择要操作的内容!");

            return false;
        }
    }


    //批量移动
    function changecate(o){
        var Checkbox=false;
        $("input[name='id[]']").each(function(){
            if (this.checked==true) {
                Checkbox=true;
            }
        });
        if (Checkbox){

            $("#listform").submit();
        }
        else{
            alert("请选择要操作的内容!");

            return false;
        }
    }

    //批量复制
    function changecopy(o){
        var Checkbox=false;
        $("input[name='id[]']").each(function(){
            if (this.checked==true) {
                Checkbox=true;
            }
        });
        if (Checkbox){
            var i = 0;
            $("input[name='id[]']").each(function(){
                if (this.checked==true) {
                    i++;
                }
            });
            if(i>1){
                alert("只能选择一条信息!");
                $(o).find("option:first").prop("selected","selected");
            }else{

                $("#listform").submit();
            }
        }
        else{
            alert("请选择要复制的内容!");
            $(o).find("option:first").prop("selected","selected");
            return false;
        }
    }

</script>
</body>
</html>





