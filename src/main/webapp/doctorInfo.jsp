<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2024/7/10
  Time: 19:58
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
    <title>个人信息</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 个人信息</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="${pageContext.request.contextPath}/doctor/updateDoctor" enctype="multipart/form-data">
            <div class="form-group">
                <div class="label">
                    <label>工号：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" name="jobNumber" value="${doctors.jobNumber}" readonly/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>姓名：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" name="name" value="${doctors.name}" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>头像：</label>
                </div>
                <div class="field">
                    <input type="file" id="url1" name="myfile" class="input tips" style="width:25%; float:left;"  />
                    <img src="${pageContext.request.contextPath}/${doctors.avatar}" width="50px">
                    <input type="hidden" name="avatar" value="${doctors.avatar}">
<%--                    <input type="button" class="button bg-blue margin-left" id="image1" value="+ 浏览上传" >--%>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>手机号：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" name="phone" value="${doctors.phone}" />
                </div>
            </div>
            <div class="form-group" style="display:none">
                <div class="label">
                    <label>Email：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" name="email" value="${doctors.email}" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group" >
                <div class="label">
                    <label>挂号费：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" name="registrationFee" value="${doctors.registrationFee}" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>个人简介：</label>
                </div>
                <div class="field">
                    <textarea class="input" name="introduction" style="height:80px">
                        ${doctors.introduction}
                    </textarea>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>职称：</label>
                </div>
                <div class="field">
                    <select name="pid" class="input" style="width:200px; line-height:17px;" onchange="changesearch()">
                        <option value="-1">请选择职称</option>
                        <c:forEach items="${ptlist}" var="pt">
                            <option value="${pt.id}" ${doctors.professionalTitleId == pt.id?"selected":""}>${pt.titleName}</option>
                        </c:forEach>
                    </select>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>入职时间：</label>
                </div>
                <div class="field">
                    <input type="date" class="input" name="entryDate" value="${doctors.entryDate}" />
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
