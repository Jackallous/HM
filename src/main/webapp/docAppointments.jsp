<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2024/7/9
  Time: 19:07
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
                window.location.href="${pageContext.request.contextPath}/doctor/deleteById?id="+id;
            }
        }

        function checkstate(state,aid){
            if(state!='booked'){
                alert("此记录已就诊")
            }else{
                window.location.href="${pageContext.request.contextPath}/appointment/completeApp?aid="+aid;
            }
        }
    </script>
</head>
<body>
    ${pageInfo}
    <div class="panel admin-panel">
        <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
        <form method="post" action="${pageContext.request.contextPath}/doctor/getAppointmentList" id="listform">
<%--            <div class="padding border-bottom">--%>
<%--            <ul class="search" style="padding-left:10px;">--%>
<%--                <li>搜索：</li>--%>
<%--                <if condition="$iscid eq 1">--%>
<%--                    <li>--%>
<%--&lt;%&ndash;                        设置的是用户请求的当前页&ndash;%&gt;--%>
                        <input type="hidden" name="page" id="page" value="1">
                        <input type="hidden" name="docid" id="page" value="${doctors.doctorId}">
<%--                        <select name="state" class="input" style="width:200px; line-height:17px;" onchange="changesearch()">--%>
<%--                            <option value="${state}">请选择出诊状态</option>--%>
<%--                            <option value="cancelled">cancelled</option>--%>
<%--                            <option value="booked">booked</option>--%>
<%--                            <option value="completed">completed</option>--%>
<%--                            <option value="">无</option>--%>
<%--                        </select>--%>
<%--                    </li>--%>
<%--                </if>--%>
<%--&lt;%&ndash;                <li>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <select name="pid" class="input" style="width:200px; line-height:17px;" onchange="changesearch()">&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <option value="-1">请选择职称</option>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <c:forEach items="${ptlist}" var="pt">&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <option value="${pt.id}" ${doctorQuery.pid == pt.id?"selected":""}>${pt.titleName}</option>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        </c:forEach>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    </select>&ndash;%&gt;--%>
<%--&lt;%&ndash;                </li>&ndash;%&gt;--%>
<%--                <li>--%>
<%--&lt;%&ndash;                    <input type="text" placeholder="请输入医生姓名" value="${doctorQuery.dname}" name="dname" class="input" style="width:150px; line-height:17px;display:inline-block" />&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <input type="text" placeholder="请输入医生工号" value="${doctorQuery.jobnum}" name="jobnum" class="input" style="width:150px; line-height:17px;display:inline-block" />&ndash;%&gt;--%>
<%--                    <a href="javascript:void(0)" class="button border-main icon-search" onclick="submitFormData()"> 搜索</a></li>--%>
<%--                <li>--%>
<%--&lt;%&ndash;                    <a class="button border-main icon-plus-square-o" href="${pageContext.request.contextPath}/addDoctor.jsp"> 添加内容</a> </li>&ndash;%&gt;--%>
<%--            </ul>--%>
<%--        </div>--%>
<%--        </form>--%>
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
                    <th width="100" style="text-align:left; padding-left:20px;">出诊编号</th>
                    <th width="10%">病人姓名</th>
                    <th>出诊日期</th>
                    <th>出诊时间</th>
                    <th>出诊状态</th>
                    <th>病人电话</th>
                    <th width="310">操作</th>
            </tr>
            <volist name="list" id="vo">
                <c:forEach items="${pageInfo.list}" var="docapp">
                    <tr id="tr_${docapp.appointmentId}">
                        <td >${docapp.appointmentId}</td>
                        <td>${docapp.patient.name}</td>
                        <td >${docapp.appointmentDate}</td>
                        <td>${docapp.appointmentTime}</td>
                        <td>${docapp.status}</td>
                        <td>${docapp.patient.phone}</td>
                        <td><div class="button-group">
                            <td><div class="button-group"> <a class="button border-main" href="${pageContext.request.contextPath}/appointment/completeApp?aid=${docapp.appointmentId}" ><span class="icon-edit"></span> 完成就诊</a></div></td>
                    </tr>
                </c:forEach>
                    <tr>
                        <td colspan="10">
                            <div class="pagelist">
                                <span >总记录数:${pageInfo.total}</span>
                                <a href="javascript:void(0)" onclick="getPage(${pageInfo.prePage})">上一页</a>
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
                                <a href="javascript:void(0)" onclick="getPage(${pageInfo.nextPage})">下一页</a>
                                <a href="javascript:void(0)" onclick="getPage(${pageInfo.pages})">尾页</a>
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