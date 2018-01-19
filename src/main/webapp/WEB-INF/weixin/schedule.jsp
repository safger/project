<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta content="yes" name="apple-touch-fullscreen">
    <meta name="format-detection" content="telephone=no" />
    <meta content="email=no" name="format-detection" />
    <meta name="x5-fullscreen" content="true">
    <title>科室排班</title>
    <style>
        body,
        div,
        a
        {
            padding: 0;
            margin: 0;
        }
        table {
            border-collapse: collapse;
            border-spacing: 0
        }
        .BG .wrapper{
            padding: 10px;
            box-sizing: border-box;
        }
        .BG .bgtable{
            border: 1px solid #ccc;
        }
        .BG .bgtable td{
            padding-top: 5px;
            padding-bottom: 5px;
            line-height: 20px;
            font-size: 14px;
        }
        .BG .bgtable .Oline{
            font-size: 15px;
            text-align: left;
            font-weight: 600;
            line-height: 30px;
            padding-top: 5px;
            padding-bottom: 5px;
            background: #3eb034;
            color: #fff;
            border-right: 1px solid #fff;
        }
        .BG .bgtable .Oline:nth-child(3){
            border-right: 1px solid #ccc;
        }
        .BG .bgtable th{
            font-size: 18px;
            font-weight: 600;
            line-height: 30px;
            padding-top: 5px;
            padding-bottom: 5px;
            background: #edffeb;
            color: #3eb034;
            border-right: 1px solid #ccc;
            text-align: center;
        }
        .BG .bgtable .pl5{
            padding-left: 5px;
            padding-right: 5px;
            box-sizing: border-box;
        }
        .BG .bgtable td span{
            padding: 0 5px;
            display: inline-block;
            color: #333;
        }
        .BG .bgtable tr:nth-child(even){
            background: #edffeb;
        }
        .BG .quickBtn{
            width: 100%;
            padding: 10px 0;
            text-align: center;
            font-size: 0;
        }
        .BG .quickBtn a{
            display: inline-block;
            width: 18%;
            max-width: 150px;
            margin: 0 1%;
            padding: 5px 0;
            text-align: center;
            border-radius: 5px;
            line-height: 18px;
            background: #ccc;
            color: #fff;
            font-size: 14px;
            margin-bottom: 10px;
        }
        .BG .quickBtn a.selected{
            background: #008742;
        }
        .BG .quickBtn a div{
            font-size: 12px;
        }
    </style>
</head>
<body class="BG">
<div class="wrapper">
    <div class="quickBtn">
        <c:forEach items="${time}" var="tlist">
            <c:if test="${tlist.iselect==1}">
                <a href="<%=basePath%>weixin/guser/showPb.html?timeint=${tlist.value}" class="selected">${tlist.week}<div>(${tlist.dateString})</div></a>
            </c:if>
            <c:if test="${tlist.iselect==0}">
                <a href="<%=basePath%>weixin/guser/showPb.html?timeint=${tlist.value}">${tlist.week}<div>(${tlist.dateString})</div></a>
            </c:if>
        </c:forEach>
    </div>
    <table border="1" width="100%" class="bgtable">
        <tr>
            <th colspan="3">
                专家科室
            </th>
        </tr>
        <tr>
            <td class="pl5 Oline" width="26%">科室名称</td>
            <td class="pl5 Oline" width="37%">上午</td>
            <td class="pl5 Oline" width="37%">下午</td>
        </tr>
        <c:forEach items="${pbks_zj}" var="list">
            <tr>
                <td class="pl5">${list.ksmc}</td>
                <td>
                    <c:forEach items="${msYspbs_listzj}" var="mxlist">
                        <c:if test="${mxlist.ksdm==list.ksdm}" >
                            <c:if test="${mxlist.zblb==1}">
                                <span>${mxlist.ygxm}</span>
                            </c:if>
                        </c:if>
                    </c:forEach>
                </td>
                <td>
                    <c:forEach items="${msYspbs_listzj}" var="mxlist">
                        <c:if test="${mxlist.ksdm==list.ksdm}" >
                            <c:if test="${mxlist.zblb==2}">
                                <span>${mxlist.ygxm}</span>
                            </c:if>
                        </c:if>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <br>
    <table border="1" width="100%" class="bgtable">
        <tr>
            <th colspan="3">
                普通科室
            </th>
        </tr>
        <tr>
            <td class="pl5 Oline" width="26%">科室名称</td>
            <td class="pl5 Oline" width="37%">上午</td>
            <td class="pl5 Oline" width="37%">下午</td>
        </tr>
        <c:forEach items="${pbks_pt}" var="list">
            <tr>
                <td class="pl5">${list.ksmc}</td>
                <td>
                    <c:forEach items="${msYspbs_listpt}" var="mxlist">
                        <c:if test="${mxlist.ksdm==list.ksdm}" >
                            <c:if test="${mxlist.zblb==1}">
                                <span>${mxlist.ygxm}</span>
                            </c:if>
                        </c:if>
                    </c:forEach>
                </td>
                <td>
                    <c:forEach items="${msYspbs_listpt}" var="mxlist">
                        <c:if test="${mxlist.ksdm==list.ksdm}" >
                            <c:if test="${mxlist.zblb==2}">
                                <span>${mxlist.ygxm}</span>
                            </c:if>
                        </c:if>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
