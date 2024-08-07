<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2024/7/8
  Time: 11:11
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
    <title>后台管理中心</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
    <div class="logo margin-big-left fadein-top">
<%--        <colspan>--%>
            <h1><img src="images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />欢迎你，患者${patients.patientId}</h1>
<%--        <h1>当前账户余额${patients.balance}元</h1>--%>
<%--        </colspan>--%>


    </div>
    <div class="head-l">
        <a class="button button-little bg-green" href="${pageContext.request.contextPath}/front/patientIndex.jsp" target="_blank"><span class="icon-home"></span> 前台首页</a> &nbsp; &nbsp;&nbsp;<a class="button button-little bg-red" href="${pageContext.request.contextPath}/user/logout?r=1"><span class="icon-power-off"></span> 退出登录</a>
    </div>
</div>
<div class="leftnav">
    <h2><span class="icon-pencil-square-o"></span>服务导航</h2>
    <ul>
        <li><a href="${pageContext.request.contextPath}/front/descrip.jsp" target="right"><span class="icon-caret-right"></span>医院简介</a></li>
        <li><a href="${pageContext.request.contextPath}/front/guahao.jsp" target="right"><span class="icon-caret-right"></span>按科室挂号</a></li>
        <li><a href="${pageContext.request.contextPath}/front/guahaoByDoc.jsp" target="right"><span class="icon-caret-right"></span>按医生挂号</a></li>
        <li><a href="${pageContext.request.contextPath}/front/addBalance.jsp" target="right"><span class="icon-caret-right"></span>余额充值</a></li>
        <li><a href="${pageContext.request.contextPath}/patient/getMyAppointment?patid=${patients.patientId}" target="right"><span class="icon-caret-right"></span>我的预约</a></li>
        <li><a href="${pageContext.request.contextPath}/patient/getMyConsultation?patid=${patients.patientId}" target="right"><span class="icon-caret-right"></span>我的就医记录</a></li>
        <li><a href="${pageContext.request.contextPath}/patient/getMyBill?patid=${patients.patientId}" target="right"><span class="icon-caret-right"></span>我的账单</a></li>
    </ul>
</div>
<script type="text/javascript">
    $(function(){
        $(".leftnav h2").click(function(){
            $(this).next().slideToggle(200);
            $(this).toggleClass("on");
        })
        $(".leftnav ul li a").click(function(){
            $("#a_leader_txt").text($(this).text());
            $(".leftnav ul li a").removeClass("on");
            $(this).addClass("on");
        })
    });
</script>
<ul class="bread">
    <li><a href="{:U('Index/info')}" target="right" class="icon-home"> 首页</a></li>
    <li><a href="##" id="a_leader_txt">网站信息</a></li>
    <li><b>当前语言：</b><span style="color:red;">中文</php></span>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;切换语言：<a href="##">中文</a> &nbsp;&nbsp;<a href="##">英文</a> </li>
</ul>
<div class="admin">
    <iframe scrolling="auto" rameborder="0" src="${pageContext.request.contextPath}/front/descrip.jsp" name="right" width="100%" height="100%"></iframe>
</div>
<div style="text-align:center;">
<%--    <p>来源:<a href="http://www.mycodes.net/" target="_blank">源码之家</a></p>--%>
</div>
</body>
</html>
