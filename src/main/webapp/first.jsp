<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2024/7/7
  Time: 12:42
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
    <title>登录</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
    <style>
        body { /* 绿色背景 */
            font-family: Arial, sans-serif;
            text-align: center;
            /*padding-top: 50px;*/
        }
        h1 {
            color: white;
        }
        .button {
            background-color: white; /* 白色按钮 */
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
            width: 400px;
            height: 80px;
            transition: background-color 0.3s, transform 0.2s;
        }
        .button:hover {
            background-color: #ccc; /* 鼠标悬浮时变色 */
            transform: scale(1.05); /* 稍微放大按钮 */
        }
    </style>
</head>
<body>
<div class="bg"></div>
<div class="container">
    <div class="line bouncein">
        <div class="xs6 xm4 xs3-move xm4-move">
            <div style="height:150px;"></div>
            <title>医院</title>
            <h1>医院管理系统</h1>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <a href="${pageContext.request.contextPath}/login.jsp" class="button" >员工入口</a>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <a href="${pageContext.request.contextPath}/front/login.jsp" class="button">患者入口</a>
                </div>
<%--            </form>--%>
        </div>
    </div>
</div>

</body>
</html>
