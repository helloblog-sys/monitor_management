<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <link rel="shortcut icon" type="image/ico" href="/assets/esmap/image/favicon.ico">
    <#--<link type="text/css" rel="stylesheet" href="/assets/css/bootstrap.min.css">-->
    <link type="text/css" rel="stylesheet" href="/assets/esmap/css/common.css">
    <link type="text/css" rel="stylesheet" href="/assets/esmap/css/formstyle.css"/>
    <!--[if lt IE 9]>
    <script type="text/javascript" src="/assets/lib/html5shiv.js"></script>
    <script type="text/javascript" src="/assets/lib/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="/assets/css/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="/assets/css/H-ui.admin.css"/>
    <link type="text/css" rel="stylesheet" href="/assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/assets/lib/Hui-iconfont/1.0.8/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="/assets/skin/default/skin.css" id="skin"/>
    <link rel="stylesheet" type="text/css" href="/assets/css/style.css"/>
    <script type="text/javascript">var buildingId = ${buildingId}</script>
    <style>
        .center-group {
            position: absolute;
            right: 85px;
            top: 10%;
        }

        .btn-group-vertical .btn {
            padding: 5px 11px;
            color: rgb(200, 210, 218);
            background-color: rgb(27, 103, 141);
            border: none;
            cursor: pointer;
            border: 1px solid rgb(1, 18, 27)
        }

        .viewmode-group {
            position: absolute;
            right: 12px;
            top: 50%;
            border-radius: 6px;
            border: none;
        }

        .viewmode-group button {
            display: inline-block;
            margin-top: -190px;
            width: 38px;
            height: 38px;
            border-radius: 4px;
            border: none;
            background-image: url("/assets/esmap/image/wedgets/3D.png");
        }

        .viewmode-switch {
            position: absolute;
            right: 12px;
            top: 35%;
            border-radius: 6px;
            border: none;
        }

        .viewmode-switch button {
            display: inline-block;
            width: 38px;
            height: 38px;
            border-radius: 4px;
            border: none;
            background-image: url("/assets/esmap/image/wedgets/more.png");
        }

        .zoneinfo {
            margin-top: 20px;
        }

        .imgangel {
            position: relative;
            width: 20px;
            height: 20px;
            top: 4px;
            left: 75px;
            cursor: pointer;
            background-color: #4d9fcf;
            border-radius: 50%;
        }

        #container {
            position: relative;
            width: inherit;
            top: 0;
            height: 100%;
        }

        .f-left {
            float: left;
            width: 242px;
            margin-left: -249px;
            min-height: 200px;
        }

        .f-right {
            float: right;
            width: 100%;
            height: 100%;
            padding-bottom: 40px;
            background-color: lightseagreen;
        }

        .main {
            padding-left: 240px;
            height: 580px;
        }

        .breadcrumb {
            background-color: #f5f5f5;
            padding: 0 20px;
            position: relative;
            z-index: 99
        }
    </style>
</head>

<body>
<nav class="breadcrumb" style="margin-bottom: 0;">
    <i class="Hui-iconfont">&#xe67f;</i> 首页
    <span class="c-gray en">&gt;</span> 设备管理
    <span class="c-gray en">&gt;</span> 地图模式
    <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="Hui-iconfont">&#xe68f;</i>
    </a>
</nav>
<div class="main">
    <div class="f-left" style="max-width:700px;float:left;">
        <form id="putDevice" class="smart-green" style="overflow: scroll;height:100vh">
            <input type="hidden" name="_method" value="PUT"/>
            <input type="hidden" id="deviceId" name="deviceId"/>
            <div class="form-group">
                <label for="deviceName" class="control-label">设备名称:</label>
                <input type="text" class="form-control" id="deviceName" name="deviceName" placeholder="设备名称">
            </div>
            <div class="form-group">
                <label for="deviceType" class="control-label">设备类型:</label>
                <select class="form-control" id="deviceType" name="deviceType" style="width: 165px">
                    <option value="1">雷达</option>
                    <option value="2">摄像头</option>
                    <option value="3">烟感设备</option>
                    <option value="4">火灾报警设备</option>
                    <option value="5">灯泡</option>
                    <option value="6">人脸识别设备</option>
                </select>
                <#--<input type="text" class="form-control" id="deviceType" name="deviceType" placeholder="1:雷达，2：摄像头">-->
            </div>
            <div class="form-group">
                <label for="deviceStatus" class="control-label">设备状态:</label>
                <select class="form-control" id="deviceStatus" name="deviceStatus" style="width: 165px">
                    <option value="0">离线</option>
                    <option value="1">在线</option>
                    <option value="2">故障</option>
                </select>
                <#--<input type="text" class="form-control" id="deviceType" name="deviceStatus" value="1">-->
            </div>
            <div class="form-group">
                <label for="deviceSn" class="control-label">设备sn:</label>
                <input type="text" class="form-control" id="deviceSn" name="deviceSn" placeholder="设备sn号">
            </div>
            <div class="form-group">
                <label for="devicePositon" class="control-label">所属楼栋ID:</label>
                <input type="text" class="form-control" id="buildingId" name="buildingId" placeholder="设备位置">
            </div>
            <div class="form-group">
                <label for="devicePositon" class="control-label">设备位置:</label>
                <input type="text" class="form-control" id="devicePosition" name="devicePosition" placeholder="设备位置">
            </div>
            <div class="form-group">
                <label for="deviceFloor" class="control-label">楼层名称:</label>
                <input type="text" class="form-control" id="deviceFloor" name="deviceFloor" placeholder="楼层名称">
                </select>
            </div>
            <div class="form-group">
                <label for="deviceAngle" class="control-label">设备角度:</label>
                <input type="text" class="form-control" id="deviceAngle" name="deviceAngle" placeholder="设备角度">
                <img class="imgangel" id="add" onclick="addAngle()" src="/assets/esmap/image/camer/add.png">
                <img class="imgangel" id="cut" onclick="cutAngle()" src="/assets/esmap/image/camer/cut.png">
            </div>
            <div class="form-group">
                <label for="mapPositionX" class="control-label">设备X坐标:</label>
                <input type="text" class="form-control" id="mapPositionX" name="mapPositionX" placeholder="设备X坐标">
            </div>
            <div class="form-group">
                <label for="mapPositionX" class="control-label">设备Y坐标:</label>
                <input type="text" class="form-control" id="mapPositionY" name="mapPositionY" placeholder="设备Y坐标">
            </div>
            <#--<div class="form-group" style="">-->
                <#--<label for="monitorAhead" class="control-label">监控范围-前:</label>-->
                <#--<input type="text" class="form-control" id="monitorAhead" name="monitorAhead" placeholder="单位：m（可不填）"-->
                       <#--value="0">-->
            <#--</div>-->
            <#--<div class="form-group" style="">-->
                <#--<label for="monitorLeft" class="control-label">监控范围-左:</label>-->
                <#--<input type="text" class="form-control" id="monitorLeft" name="monitorLeft" placeholder="单位：m（可不填）">-->
            <#--</div>-->
            <#--<div class="form-group" style="">-->
                <#--<label for="monitorRight" class="control-label">监控范围-右:</label>-->
                <#--<input type="text" class="form-control" id="monitorRight" name="monitorRight" placeholder="单位：m（可不填）"-->
                       <#--value="0">-->
            <#--</div>-->
            <#--<div class="form-group" style="">-->
                <#--<label for="monitorRight" class="control-label">ip:</label>-->
                <#--<input type="text" class="form-control" id="ip" name="ip" placeholder="单位：m（可不填）">-->
            <#--</div>-->
            <div class="form-group">
                <label for="deviceScaling" class="control-label">地图缩放比例:</label>
                <input type="text" class="form-control" id="deviceScaling" name="deviceScaling" placeholder="地图缩放比例" value="1">
            </div>
            <div class="form-group">
                <label for="port" class="control-label">设备port:</label>
                <input type="text" class="form-control" id="port" name="port" placeholder="摄像头标识（可不填）" value="">
            </div>
            <div hidden class="form-group" style="">
                <label for="port" class="control-label">设备关联雷达sn：</label>
                <input type="text" class="form-control" id="associationMmwaveSn" name="associationMmwaveSn"
                       placeholder="有重叠区域的雷达sn（可不填）" value="">
            </div>
            <div class="form-group">
                <#--<button id="submit" type="submit" class="btn btn-success radius size-L">&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;</button>-->
                <#--<button type="reset" class="btn btn-default radius size-L">&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;-->
                <input type="button" class="btn btn-success radius size-L"  id="submit" value="保存"
                       style="color:rgb(67, 104, 133);font-weight:700;border-radius:3px">
            </div>
        </form>
    </div>
    <div class="f-right" style="overflow: hidden;height:100vh">
        <div style="height:108%;background:rgba(255,186,78,0.24);float:left" id="container"></div>
        <div style="position:relative;top:610px;background:#fff;height:0px;width:100%"></div>
    </div>
    <!--2D、3D按钮组  -->
    <div class="viewmode-group">
        <button id="btn3D" class="btn btn-default"></button>
    </div>

    <!--按钮组  -->
    <div class="center-group btn-group-vertical" data-toggle="buttons">
        <button id="addCamera" class="btn btn-danger radius">添加摄像头</button>
        <button id="addRadar" class="btn btn-danger radius">添加雷达设备</button>
        <button id="addSmoke" class="btn btn-danger radius">添加烟感设备</button>
        <button id="addFirealarm" class="btn btn-danger radius">添加火灾报警设备</button>
        <button id="modify" class="btn btn-danger radius">修改设备信息</button>
        <button id="delete" class="btn btn-danger radius">删除设备</button>
        <button id="reset" class="btn btn-danger radius">取消</button>
    </div>
    <!--删除设备模块-->
    <div class="modal fade" id="deleteDevice" role="dialog" aria-labelledby="gridSystemModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close" value="删除"><span
                                aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="gridSystemModalLabel">提示</h4>
                </div>
                <div class="modal-body">
                    <div class="container-fluid">
                        确定要删除该设备？删除后不可恢复！
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn " data-dismiss="modal">取 消</button>
                    <button id="delete-ok" type="button" class="btn btn-primary" data-dismiss="modal">确 定</button>
                </div>
            </div>
        </div>
    </div>
</div>

<#--<script src="/assets/esmap/js/config.js"></script>-->
<script src="/assets/esmap/js/esmap.min.js"></script>
<script src="/assets/esmap/js/jquery-2.1.4.min.js"></script>
<script src="/assets/js/bootstrap.min.js">
<script src="/assets/esmap/js/jquery.qrcode.min.js"></script>
<script src="/assets/js/devicemanager.js"></script>
<script type="text/javascript">
    map.on("loadComplete", function () {
        floorControl = new esmap.ESScrollFloorsControl(map, ctlOpt);
        bingEvents();
        for (var i = 0; i < map.floorNames.length; i++) {
            $("#deviceFloor").append('<option value="' + (i + 1) + '">' + (map.floorNames[i]) + '</option>')
        }
        $("#deviceFloor").value = 1;
        var devices = ${deviceList};
        for (i = 0; i < devices.length; i++) {
            var device = devices[i];
            drawImage(device.mapPositionX, device.mapPositionY, device.deviceFloor, device.deviceName, device.deviceAngle, device.deviceId, device.deviceType);
        }
    });
</script>
</body>
</html>