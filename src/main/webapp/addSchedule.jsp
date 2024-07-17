<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2024/7/9
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-cn">
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
        //定义文档就绪函数
        <%--$(function (){--%>
        <%--    //默认先查询一级科室--%>
        <%--    $.getJSON("${pageContext.request.contextPath}/depart/getChildDepartList?pid=0",function(data){--%>
        <%--        var opt = "<option value=\"-1\">请选择分类</option>";--%>
        <%--        $.each(data,function(i,item){--%>
        <%--             // alert(item.departmentName);--%>
        <%--            opt += "<option value=\""+item.departmentId+"\">"+item.departmentName+"</option>";--%>
        <%--        })--%>
        <%--        //获取1级科室的下拉菜单对象，设置option选项--%>
        <%--        $("[name=pid]").html(opt);--%>
        <%--    })--%>
        <%--})--%>

        <%--function getDepartList(pid){--%>
        <%--    $.getJSON("${pageContext.request.contextPath}/depart/getChildDepartList?pid="+pid,function(data){--%>
        <%--        var opt = "<option value=\"-1\">请选择分类</option>";--%>
        <%--        $.each(data,function(i,item){--%>
        <%--            // alert(item.departmentName);--%>
        <%--            opt += "<option value=\""+item.departmentId+"\">"+item.departmentName+"</option>";--%>
        <%--        })--%>
        <%--        //获取2级科室的下拉菜单对象，设置option选项--%>
        <%--        $("[name=cid]").html(opt);--%>
        <%--    })--%>
        <%--}--%>
    </script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加内容</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="${pageContext.request.contextPath}/addSchedule">
            <div class="form-group">
                <div class="label">
                    <label>科室：</label>
                </div>
                <div class="field">
<%--                    <select name="pid" class="input w50" onchange="getDepartList(this.value)">--%>
<%--                    </select>--%>
<%--                    <select name="cid" class="input w50">--%>
<%--                    </select>--%>
                        <select name="did" class="input" style="width:200px; line-height:17px;" onchange="changesearch()">
<%--                            默认给id为6的心内科添加--%>
                            <option value="6">请选择科室</option>
                            <c:forEach items="${dListLevelt}" var="d">
                                <option value="${d.departmentId}" >${d.departmentName}</option>
                            </c:forEach>
                        </select>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>日期：</label>
                </div>
                <div class="field">
                    <input type="date" class="input w50" name="sdate" data-validate="required:请输入日期" required/>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
                </div>
            </div>
        </form>
    </div>
</div>

</body></html>