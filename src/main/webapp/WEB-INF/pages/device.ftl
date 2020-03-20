<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,device-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <!--[if lt IE 9]>
    <script type="text/javascript" src="/assets/lib/html5shiv.js"></script>
    <script type="text/javascript" src="/assets/lib/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="/assets/css/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="/assets/css/H-ui.admin.css"/>
    <link rel="stylesheet" type="text/css" href="/assets/lib/Hui-iconfont/1.0.8/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="/assets/skin/default/skin.css" id="skin"/>
    <link rel="stylesheet" type="text/css" href="/assets/css/style.css"/>
    <!--[if IE 6]>
    <script type="text/javascript" src="/assets/lib/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>设备列表</title>
</head>
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i> 首页
    <span class="c-gray en">&gt;</span> 设备管理
    <span class="c-gray en">&gt;</span> 设备列表
    <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="Hui-iconfont">&#xe68f;</i>
    </a>
</nav>
<div class="page-container">
    <div class="cl pd-5 bg-1 bk-gray">
        <span class="l">
            <a href="javascript:;" onclick="devices_delete()" class="btn btn-danger radius"><i
                        class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>
            <#--<a class="btn btn-primary radius" href="javascript:;" onclick="device_add('添加设备','device_add')"><i-->
                        <#--class="Hui-iconfont">&#xe600;</i> 添加设备</a>-->
            <#if '${buildingId}'!='all'>
            <a class="btn btn-primary radius" href="/device/map/${buildingId}"><i
                        class="Hui-iconfont">&#xe68d;</i> 进入地图模式</a></#if>
        </span>
        <span class="r">共有数据：<strong>${deviceList?size}</strong> 条</span>
    </div>
    <table class="table table-border table-bordered table-hover table-bg">
        <thead>
        <tr>
            <th scope="col" colspan="17">设备列表</th>
        </tr>
        <tr class="text-c">
            <th width="25"><input type="checkbox" value="" name=""></th>
            <th width="40">序号</th>
            <#--<th width="40">ID</th>-->
            <th width="200">设备名称</th>
            <th width="100">设备类型</th>
            <th width="100">设备sn</th>
            <th width="100">设备状态</th>
            <th width="200">设备位置</th>
            <th width="100">楼栋ID</th>
            <th width="100">设备楼层</th>
            <th width="100">设备角度</th>
            <th width="200">地图坐标X</th>
            <th width="200">地图坐标Y</th>
            <th width="100">设备port</th>
            <th width="100">关联sn</th>
            <th width="300">创建时间</th>
            <th width="70">操作</th>
        </tr>
        </thead>
        <tbody>
        <#list deviceList as deviceList>
            <tr class="text-c">
                <td><input type="checkbox" value="${deviceList.deviceId}" name="checkbox"></td>
                <td>${deviceList_index+1}</td>
                <#--<td>${deviceList.deviceId}</td>-->
                <td>${deviceList.deviceName}</td>
                <#if deviceList.deviceType==1>
                    <td>雷达</td>
                <#elseif deviceList.deviceType==2>
                    <td>摄像头</td></#if>
                <#--<td>${deviceList.deviceType}</td>-->
                <td>${deviceList.deviceSn}</td>
                <#if deviceList.deviceStatus==0>
                    <td>下线</td>
                <#elseif deviceList.deviceStatus==1>
                    <td>在线</td>
                <#elseif deviceList.deviceStatus==2>
                    <td>故障</td></#if>
                <#--<td>${deviceList.deviceStatus}</td>-->
                <td>${deviceList.devicePosition}</td>
                <td>${deviceList.buildingId}</td>
                <td>${deviceList.deviceFloor}</td>
                <td>${deviceList.deviceAngle}</td>
                <td>${deviceList.mapPositionX}</td>
                <td>${deviceList.mapPositionY}</td>
                <td>${deviceList.port}</td>
                <td>${deviceList.associationMmwaveSn}</td>
                <td>${deviceList.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
                <td class="f-14">
                    <a title="编辑" href="javascript:;"
                       onclick="device_edit('设备编辑',${deviceList.deviceId},${deviceList_index+1})"
                       style="text-decoration:none">
                        <i class="Hui-iconfont">&#xe6df;</i>
                    </a>
                    <a title="删除" href="javascript:;" onclick="device_delete(this,${deviceList.deviceId})" class="ml-5"
                       style="text-decoration:none">
                        <i class="Hui-iconfont">&#xe6e2;</i>
                    </a>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
<!--设备添加/编辑模块-->
<div id="device_add" style="display: none">
        <form class="form form-horizontal" style="padding-top: 2%" id="form_device">
        <input type="hidden" name="_method" value="PUT"/>
        <input type="hidden" name="deviceId" id="deviceId" value=""/>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>设备名称：</label>
            <div class="formControls col-xs-7 col-sm-7">
                <input type="text" class="input-text" value="" placeholder="请填写设备名称" id="deviceName" name="deviceName">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>设备类型：</label>
            <div class="formControls col-xs-7 col-sm-7"> <span class="select-box" style="width:150px;">
			<select class="select" id="deviceType" name="deviceType" size="1">
				<option value="1">雷达</option>
				<option value="2">摄像头</option>
			</select>
			</span></div>
            <#--<div class="formControls col-xs-7 col-sm-7">-->
                <#--<input type="text" class="input-text" value="" placeholder="请填写设备类型" id="deviceType" name="deviceType">-->
            <#--</div>-->
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>设备sn：</label>
            <div class="formControls col-xs-7 col-sm-7">
                <input type="text" class="input-text" value="" placeholder="请填写设备sn" id="deviceSn" name="deviceSn">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>设备状态：</label>
            <div class="formControls col-xs-7 col-sm-7"> <span class="select-box" style="width:150px;">
			<select class="select" id="deviceStatus" name="deviceStatus" size="1" disabled="disabled">
				<option value="0">下线</option>
				<option value="1">在线</option>
                <option value="2">故障</option>
			</select>
			</span></div>
            <#--<div class="formControls col-xs-7 col-sm-7">-->
                <#--<input type="text" class="input-text" value="" placeholder="0:下线，1:在线，2:故障" id="deviceStatus"-->
                       <#--name="deviceStatus">-->
            <#--</div>-->
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>设备位置：</label>
            <div class="formControls col-xs-7 col-sm-7">
                <input type="text" class="input-text" value="" placeholder="请填写设备位置" id="devicePosition"
                       name="devicePosition">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>楼栋ID：</label>
            <div class="formControls col-xs-7 col-sm-7">
                <input type="text" class="input-text" value="" placeholder="请填写设备位置" id="buildingId"
                       name="buildingId">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>设备楼层：</label>
            <div class="formControls col-xs-7 col-sm-7">
                <input type="text" class="input-text" value="" placeholder="请填写设备楼层" id="deviceFloor"
                       name="deviceFloor">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>设备角度：</label>
            <div class="formControls col-xs-7 col-sm-7">
                <input type="text" class="input-text" value="" placeholder="请填写设备角度" id="deviceAngle"
                       name="deviceAngle">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>设备X坐标：</label>
            <div class="formControls col-xs-7 col-sm-7">
                <input type="text" class="input-text" value="" placeholder="请填写设备X坐标" id="mapPositionX"
                       name="mapPositionX">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>设备Y坐标：</label>
            <div class="formControls col-xs-7 col-sm-7">
                <input type="text" class="input-text" value="" placeholder="请填写设备Y坐标" id="mapPositionY"
                       name="mapPositionY">
            </div>
        </div><div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>坐标缩放：</label>
            <div class="formControls col-xs-7 col-sm-7">
                <input type="text" class="input-text" value="1" placeholder="请填写坐标缩放比例" id="deviceScaling"
                       name="deviceScaling">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">设备监控前距：</label>
            <div class="formControls col-xs-7 col-sm-7">
                <input type="text" class="input-text" value="" placeholder="请填写设备监控前距（可不填）" id="monitorAhead"
                       name="monitorAhead">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">设备监控左距：</label>
            <div class="formControls col-xs-7 col-sm-7">
                <input type="text" class="input-text" value="" placeholder="请填写设备监控左距（可不填）" id="monitorLeft"
                       name="monitorLeft">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">设备监控右距：</label>
            <div class="formControls col-xs-7 col-sm-7">
                <input type="text" class="input-text" value="" placeholder="请填写设备监控右距（可不填）" id="monitorRight"
                       name="monitorRight">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">摄像头端口号：</label>
            <div class="formControls col-xs-7 col-sm-7">
                <input type="text" class="input-text" value="" placeholder="摄像头在推流服务器上的端口号（可不填）" id="port"
                       name="port">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">设备关联雷达sn：</label>
            <div class="formControls col-xs-7 col-sm-7">
                <input type="text" class="input-text" value="" placeholder="请填写于设备有重叠区域的雷达sn（可不填）"
                       id="associationMmwaveSn"
                       name="associationMmwaveSn">
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                <button class="btn btn-success radius size-L" id="device_save">
                    <i class="icon-ok"></i> 确定
                </button>
            </div>
        </div>
    </form>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="/assets/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="/assets/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="/assets/js/H-ui.min.js"></script>
<script type="text/javascript" src="/assets/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="/assets/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="/assets/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="/assets/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="/assets/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">
    /*设备-添加*/
    function device_add(title) {
        $("input").remove("[name = 'deviceId']");
        layer.open({
            type: 1,
            area: ['800px', '500px'],
            fix: false, //不固定
            maxmin: true,
            shade: 0.4,
            title: title,
            content: $('#device_add')
        });
    }

    /*设备-编辑*/
    function device_edit(title, id, index) {
        var tid = index - 1;
        document.getElementById('deviceId').value = id;
        document.getElementById('deviceName').value = $('tbody tr:eq(' + tid + ') td:eq(2)').text();
        var temp = $('tbody tr:eq(' + tid + ') td:eq(3)').text();
        if (temp === '雷达') {
            temp = '1';
        }
        else {
            temp = '2';
        }
        document.getElementById('deviceType').value = temp;
        document.getElementById('deviceSn').value = $('tbody tr:eq(' + tid + ') td:eq(4)').text();
        var tempStatus = $('tbody tr:eq(' + tid + ') td:eq(5)').text();
        if (tempStatus === '下线') {
            tempStatus = '0';
        } else if(tempStatus === '在线'){
            tempStatus = '1';
        }else{
            tempStatus = '2';
        }
        document.getElementById('deviceStatus').value = tempStatus;
        document.getElementById('devicePosition').value = $('tbody tr:eq(' + tid + ') td:eq(6)').text();
        document.getElementById('buildingId').value = $('tbody tr:eq(' + tid + ') td:eq(7)').text();
        document.getElementById('deviceFloor').value = $('tbody tr:eq(' + tid + ') td:eq(8)').text();
        document.getElementById('deviceAngle').value = $('tbody tr:eq(' + tid + ') td:eq(9)').text();
        document.getElementById('mapPositionX').value = $('tbody tr:eq(' + tid + ') td:eq(10)').text();
        document.getElementById('mapPositionY').value = $('tbody tr:eq(' + tid + ') td:eq(11)').text();
        document.getElementById('port').value = $('tbody tr:eq(' + tid + ') td:eq(12)').text();
        document.getElementById('associationMmwaveSn').value = $('tbody tr:eq(' + tid + ') td:eq(13)').text();
        $("input").remove("[name = '_method']");
        layer.open({
            type: 1,
            area: ['800px', '500px'],
            fix: false, //不固定
            maxmin: true,
            shade: 0.4,
            title: title,
            content: $('#device_add')
        });
    }

    /*设备-单个删除*/
    function device_delete(obj, id) {
        var result = [];
        result[0] = id;
        layer.confirm('设备删除须谨慎，确认要删除吗？', function () {
            $.ajax({
                type: 'DELETE',
                url: '/device/' + result,
                dataType: 'json',
                success: function (data) {
                    if (data.s == 1) {
                        $(obj).parents("tr").remove();
                        layer.msg('已删除!', {icon: 1, time: 1000});
                    } else {
                        layer.msg(data.data, {icon: 2, time: 1000});
                    }
                },
                error: function () {
                    console.log("请检查网络连接！");
                },
            });
        });
    }

    /*设备-批量删除*/
    function devices_delete() {
        var result = [];
        var count = 0;
        $("input[name=\"checkbox\"]:checked").each(function () {
            result[count] = $(this).val();
            count++;
        });
        if (count == 0) return;
        else {
            layer.confirm('设备删除须谨慎，确认要删除这' + count + '个设备吗？', function () {
                $.ajax({
                    type: 'DELETE',
                    url: '/device/' + result,
                    dataType: 'json',
                    success: function (data) {
                        if (data.s == 1) {
                            layer.msg('已删除!', {icon: 1, time: 1000});
                            setTimeout(function () {
                                layer.close(layer.index);
                                window.location.reload();
                            }, 1000)
                        } else {
                            layer.msg(data.data, {icon: 2, time: 1000});
                        }
                    },
                    error: function () {
                        console.log("请检查网络连接！");
                    },
                });
            })
        }
    }

    //添加、更新设备信息
    $('#device_save').click(function () {
        $("#form_device").validate({
            rules: {
                deviceName: {
                    required: true,
                },
                deviceType: {
                    required: true,
                }
            },
            onkeyup: false,
            focusCleanup: true,
            success: "valid",
            submitHandler: function () {
                $.ajax({
                    url: '/device',
                    dataType: "json",
                    data: $('#form_device').serialize(),
                    type: 'post',
                    success: function (data) {
                        if (data.s == 1) {
                            layer.msg('操作成功!', {icon: 6, time: 1000});
                            setTimeout(function () {
                                layer.close(layer.index);
                                window.location.reload();
                            }, 1000)
                        } else {
                            alert("提示： " + data.data);
                        }
                    },
                    error: function () {
                        alert("请检查网络连接");
                    }
                });
}
})
})
function switchToMap() {
window.location.href="/device/map/"+buildingId;
}
</script>
</body>
</html>