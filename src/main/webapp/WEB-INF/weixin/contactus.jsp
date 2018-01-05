<%@ page language="java" import="java.util.*,com.sn.entity.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head> 
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta content="yes" name="apple-touch-fullscreen">
    <meta name="format-detection" content="telephone=no" />
    <meta content="email=no" name="format-detection" />
    <meta name="x5-fullscreen" content="true">
    <link rel="stylesheet" href="<%=basePath%>source/weixin/css/style.min.css">
    <!--<script src="../<%=basePath%>source/weixin/js/fontsize.js"></script>-->
    <script src="<%=basePath%>source/weixin/js/fontsize2.js"></script>
    <!--<script src="http://g.tbcdn.cn/mtb/lib-flexible/0.3.4/??flexible_css.js,flexible.js"></script>-->
    <script src="<%=basePath%>source/weixin/js/jquery-1.8.3.min.js"></script>
    <script src="<%=basePath%>source/weixin/js/functions.js"></script>
    <!--日期文件-->
    <link rel="stylesheet" href="<%=basePath%>source/weixin/css/lCalendar.css">
    <script src="<%=basePath%>source/weixin/js/lCalendar.min.js"></script>
    <title>联系我们</title>
</head>
<body class="Reg bg1">
<div class="wrap">
    <header>
        <img src="<%=basePath%>source/weixin/img/logo.png">
        <span>台州市第一人民医院</span>
    </header>
    <div class="CT">
        <div class="banner"><img src="<%=basePath%>source/weixin/img/id-banner.jpg"> </div>
        <div class="CTwrap">
            <h1>联系我们</h1>
            <div class="CT-info">
                <div class="titleimg"><img srcset="<%=basePath%>source/weixin/img/locate2.png"> </div>
                <div class="txtcenter">
                    浙江省台州市黄岩区横街路218号（318020）   
                </div>
                <div class="titleimg"><img srcset="<%=basePath%>source/weixin/img/tel2.png"> </div>
                <div class="txtcenter">预约电话：<a href="tel:0576-84016923">0576-84016923</a></div>
            </div>
        </div>
        <div id="wrap" class="my-map">
            <div id="mapContainer"></div>
        </div>
    </div>
    <script src="http://webapi.amap.com/maps?v=1.3&key=8325164e247e15eea68b59e89200988b"></script>
    <script>
        !function(){
            var infoWindow, map, level = 14,
                center = {lng: 121.264973, lat: 28.645155},
                features = [{type: "Marker", name: "台州市第一人民医院", desc: "浙江省台州市黄岩区横街路218号", color: "red", icon: "cir", offset: {x: -9, y: -31}, lnglat: {lng: 121.264973, lat: 28.645155}}];

            function loadFeatures(){
                for(var feature, data, i = 0, len = features.length, j, jl, path; i < len; i++){
                    data = features[i];
                    switch(data.type){ 
                        case "Marker":
                            feature = new AMap.Marker({ map: map, position: new AMap.LngLat(data.lnglat.lng, data.lnglat.lat),
                                zIndex: 3, extData: data, offset: new AMap.Pixel(data.offset.x, data.offset.y), title: data.name,
                                content: '<div class="icon icon-' + data.icon + ' icon-'+ data.icon +'-' + data.color +'"></div>' });
                            break;
                        case "Polyline":
                            for(j = 0, jl = data.lnglat.length, path = []; j < jl; j++){
                                path.push(new AMap.LngLat(data.lnglat[j].lng, data.lnglat[j].lat));
                            }
                            feature = new AMap.Polyline({ map: map, path: path, extData: data, zIndex: 2,
                                strokeWeight: data.strokeWeight, strokeColor: data.strokeColor, strokeOpacity: data.strokeOpacity });
                            break;
                        case "Polygon":
                            for(j = 0, jl = data.lnglat.length, path = []; j < jl; j++){
                                path.push(new AMap.LngLat(data.lnglat[j].lng, data.lnglat[j].lat));
                            }
                            feature = new AMap.Polygon({ map: map, path: path, extData: data, zIndex: 1,
                                strokeWeight: data.strokeWeight, strokeColor: data.strokeColor, strokeOpacity: data.strokeOpacity,
                                fillColor: data.fillColor, fillOpacity: data.fillOpacity });
                            break;
                        default: feature = null;
                    }
                    if(feature){ AMap.event.addListener(feature, "click", mapFeatureClick); }
                }
            }

            function mapFeatureClick(e){
                if(!infoWindow){ infoWindow = new AMap.InfoWindow({autoMove: true}); }
                var extData = e.target.getExtData();
                infoWindow.setContent("<h5>" + extData.name + "</h5><div>" + extData.desc + "</div>");
                infoWindow.open(map, e.lnglat);
            }

            map = new AMap.Map("mapContainer", {center: new AMap.LngLat(center.lng, center.lat), level: level});

            loadFeatures();

            map.on('complete', function(){
                map.plugin(["AMap.ToolBar", "AMap.OverView", "AMap.Scale"], function(){
                    map.addControl(new AMap.ToolBar);
                    map.addControl(new AMap.OverView({isOpen: true}));
                    map.addControl(new AMap.Scale);
                });
            })

        }();
    </script>
</div>
</body>
</html>