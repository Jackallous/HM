<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2024/7/10
  Time: 19:58
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
    <title>个人信息</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
</head>
<body>
${appointmentsForDoc}
<div class="panel admin-panel">
    <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 个人信息</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="${pageContext.request.contextPath}/consultation/createConsultation">
            <div class="form-group">
                <div class="label">
                    <label>就诊编号：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" name="aid" value="${appointmentsForDoc.appointmentId}" readonly/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>患者姓名：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" name="pname" value="${appointmentsForDoc.patient.name}" readonly/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>出诊日期：</label>
                </div>
                    <div class="field">
                        <input type="text" class="input" name="adate" value="${appointmentsForDoc.appointmentDate}" readonly/>
                        <div class="tips"></div>
                    </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>出诊时间：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" name="atime" value="${appointmentsForDoc.appointmentTime}" readonly/>
                </div>
            </div>
            <div class="form-group" style="display:none">
                <div class="label">
                    <label>病人ID：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" name="patid" value="${appointmentsForDoc.patientId}" readonly />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group" >
                <div class="label">
                    <label>医生ID：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" name="docid" value="${appointmentsForDoc.doctorId}" readonly/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>医嘱病例：</label>
                </div>
                <div class="field">
                    <textarea class="input" name="advice" style="height:80px" required>

                    </textarea>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>是否登记住院：</label>
                </div>
                <div class="field">
                    <select name="hosregis" class="input" style="width:200px; line-height:17px;" onchange="changesearch()" required>
                        <option value="0">否</option>
                        <option value="1">是</option>
                    </select>
                    <div class="tips"></div>
                </div>
            </div>

                <div class="form-group">
                    <div class="label">
                        <label>是否住院：</label>
                    </div>
                    <div class="field">
                        <select name="hosif" class="input" style="width:200px; line-height:17px;" onchange="changesearch()">
                            <option value="0">否</option>
                            <option value="1">是</option>
                        </select>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>病房号：</label>
                    </div>
                    <div class="field">
                        <input type="number" class="input" name="room" value="" required/>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>住院费用：</label>
                    </div>
                    <div class="field">
                        <input type="number" class="input" name="fee" value="" required/>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>支付状态：</label>
                    </div>
                    <div class="field">
                        <select name="pay" class="input" style="width:200px; line-height:17px;" onchange="changesearch()" required>
                            <option value="unpaid">unpaid</option>
                            <option value="partially_paid">partially_paid</option>
                            <option value="paid">paid</option>
                        </select>
                        <div class="tips"></div>
                    </div>
                </div>
                    <div class="form-group">
                        <div class="label">
                            <label>是否有保险：</label>
                        </div>
                        <div class="field">
                            <select name="insure" class="input" style="width:200px; line-height:17px;" onchange="changesearch()" required>
                                <option value="0">否</option>
                                <option value="1">是</option>
                            </select>
                            <div class="tips"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="label">
                            <label>住院状态：</label>
                        </div>
                        <div class="field">
                            <select name="hospitalstatus" class="input" style="width:200px; line-height:17px;" onchange="changesearch()" required>
                                <option value="admitted">已入院</option>
                                <option value="in_progress">进行中</option>
                                <option value="discharged">已出院</option>
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
</body></html>
