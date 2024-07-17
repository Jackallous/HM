<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2024/7/7
  Time: 12:42
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
    <title>登录</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
    <style>
        .button {
            background-color: paleturquoise; /* 白色按钮 */
            border: none;
            color: black;
            padding: 20px 40px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 20px;
            cursor: pointer;
            border-radius: 20px; /* 更大的圆角 */
            box-shadow: 3px 3px 10px rgba(0,0,0,0.2); /* 添加阴影 */
            width: 340px;
            height: 60px;
            transition: background-color 0.3s, transform 0.2s;
        }
    </style>
</head>
<body>
<div class="bg"></div>
<div class="container">
    <div class="line bouncein">
        <div class="xs6 xm4 xs3-move xm4-move">
            <div style="height:150px;"></div>
            <div class="media media-y margin-big-bottom">
            </div>
            <form action="${pageContext.request.contextPath}/patient/login" method="post">
                <div class="panel loginbox">
                    <div class="text-center margin-big padding-big-top"><h1>患者登录</h1></div>
                    <h4 style="color: red;" align="center">${param.flag=="f"?"身份证或密码错误":""}</h4>
                    <div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:10px;">
                        <div class="form-group">
                            <div class="field field-icon-right">
                                <input type="text" class="input input-big" name="idcard" placeholder="登录账号" data-validate="required:请填写身份证号" />
                                <span class="icon icon-user margin-small"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="field field-icon-right">
                                <input type="password" class="input input-big" name="password" placeholder="登录密码" data-validate="required:请填写密码" />
                                <span class="icon icon-key margin-small"></span>
                            </div>
                        </div>
                    </div>
                    <div style="padding:30px;">
                        <input type="submit" class="button button-block bg-main text-big input-big" value="登录">
<%--                        <input type="submit" class="button button-block bg-main text-big input-big" value="注册">--%>
                        <br>
                        <br>
                        <br>
                        <a href="${pageContext.request.contextPath}/front/register.jsp" class="button">注册</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
