<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2024/7/13
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%
    String contextPath = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + contextPath + "/";
%>
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
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改医生内容</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="${pageContext.request.contextPath}/doctor/updateDoctorTitle">
            <div class="form-group">
                <div class="label">
                    <label>医生id：</label>
                </div>
                <div class="field">
<%--                    <input type="hidden" name="pid" value="${param.pid}">--%>
                    <input type="text" class="input w50"  name="docid" value="${doctor.doctorId}" readonly />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>挂号费：</label>
                </div>
                <div class="field">
<%--                    <input type="hidden" name="pid" value="${param.pid}">--%>
                    <input type="text" class="input w50"  name="docfee" value="${doctor.registrationFee}" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>职称：</label>
                </div>
                <div class="field">
                    <select name="doctitleid" class="input" style="width:200px; line-height:17px;" onchange="changesearch()">
                        <option value="-1">请选择职称</option>
                        <c:forEach items="${ptlist}" var="pt">
                            <option value="${pt.id}" ${doctor.professionalTitleId == pt.id?"selected":""}>${pt.titleName}</option>
                        </c:forEach>
                    </select>
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
</div>

</body></html>
