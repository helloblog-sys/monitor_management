var fnum;
var mapCoord;
var map;
var mapId;
var themeID;
var floorLayer;
var cameraFlag = false;
var radarFlag = false;
var modifyFlag = false;
var deleteFlag = false;
var smokeFlag = false;
var fireFlag = false;
var devicelayer;
var addImagelayer;
var im;
switch(buildingId){
    case 28:
        mapId = "xdqd_2801";
        themeID = '2001';
        defaultScaleLevel=16;
        tiltAngle=70;
        break;
    case 29:
        mapId = "xdqd_2901";
        themeID = '2001';
        defaultScaleLevel=16;
        tiltAngle=70;
        break;
    case 2:
        mapId = "20190929";
        themeID = '1005';
        defaultScaleLevel=6;
        tiltAngle = 60;
        break;
    case 3:
        mapId = "2019_10_13";
        themeID = '1005';
        defaultScaleLevel=11;
        tiltAngle=70;
        break;
    default:
        break;
}

map = new esmap.ESMap({
    container: document.getElementById('container'), //渲染dom
    mapDataSrc: "/assets/esmap/data", //地图数据位置
    mapThemeSrc: "/assets/esmap/data/theme", //主题数据位置
    defaultScaleLevel:defaultScaleLevel,//初始显示缩放等级,
    focusAlphaMode: true, // 对不可见图层启用透明设置 默认为true
    focusAnimateMode: true, // 开启聚焦层切换的动画显示
    focusAlpha: 0.8, // 对不聚焦图层启用透明设置，当focusAlphaMode = true时有效
    visibleFloors: 'all',
    focusFloor: 2,
    loadLabel: false, //是否显示文字POI
    loadPoi: false, //是否显示图片POI
    token: 'xdqd2801',
    themeID: themeID
});
var floorControl;
//楼层控制控件配置参数(选几楼)
var ctlOpt = new esmap.ESControlOptions({
    position: esmap.ESControlPositon.RIGHT_TOP,
    imgURL: "/assets/esmap/image/wedgets/"
});

//打开地图数据
map.openMapById(mapId);
map.showCompass = true;


//地图点击事件  获取地图坐标x,y坐标
map.on("mapClickNode", function (e) {
    mapCoord = e.hitCoord || null;
    console.log(mapCoord);
})
map.on('mapClickNode', function (event) {
    console.log(event);
    if (event.nodeType == esmap.ESNodeType.FLOOR || event.nodeType == esmap.ESNodeType.MODEL) {
        var focusFloorNum = map.focusFloorNum;
        if (cameraFlag || radarFlag || smokeFlag || fireFlag) {
            if (cameraFlag) {
                $("#deviceType").val(2);
            } else if(radarFlag){
                $("#deviceType").val(1);
            }else if(smokeFlag){
                $("#deviceType").val(3);
            }else{
                $("#deviceType").val(4);
            }
            $('#deviceFloor').val(map.focusFloorNum);
            $("#deviceAngle").val(0);
            $("#buildingId").val(buildingId);
            addImage(event.hitCoord.x, event.hitCoord.y, focusFloorNum, document.getElementById("deviceType").value);
            $('#mapPositionX').val(event.hitCoord.x);
            $('#mapPositionY').val(event.hitCoord.y);
        }
    } else if (event.nodeType == esmap.ESNodeType.IMAGE_MARKER) {
        if (modifyFlag) {
            $("#deviceName").val(event.name);
            $("#deviceId").val(event.id_);
            $('#deviceFloor').val(map.focusFloorNum);
            $("#deviceAngle").val(event.opts_.angle);
            $('#mapPositionX').val(event.hitCoord.x);
            $('#mapPositionY').val(event.hitCoord.y);
        } else if (deleteFlag) {
            toDeleteDevice(event.id_);
        }
    }
});

//初始化添加图片标注
function drawImage(x, y, focusFloorNum, name, angle, id, type) {
    devicelayer = new esmap.ESLayer(esmap.ESLayerType.IMAGE_MARKER);
    floorLayer = map.getFloor(focusFloorNum); // 所在楼层
    var url;
    switch (type) {
        case 1:
            url = '/assets/esmap/image/radar.png';
            break;
        case 2:
            url = '/assets/esmap/image/camera1.png';
            break;
        case 3:
            url = '/assets/esmap/image/smoke.png';
            break;
        case 4:
            url = '/assets/esmap/image/firealarm.png';
    }
    var im = new esmap.ESImageMarker({
        name: name,
        id: id,
        x: x,
        y: y,
        height: 1.0,
        url: url,
        size: 3,
        seeThrough: true,
        showLevel: 20,
        angle: angle, //控制标注随着地图旋转。(size需要重新设置)
        zoom: 0 //控制标注随着地图缩小
    });
    devicelayer.addMarker(im);
    floorLayer.addLayer(devicelayer);
}

//添加图片标注
function addImage(x, y, focusFloorNum, type) {
    addImagelayer.removeAll();
    var url;
    switch (type) {
        case "1":
            url = '/assets/esmap/image/radar.png';
            break;
        case "2":
            url = '/assets/esmap/image/camera1.png';
            break;
        case "3":
            url = '/assets/esmap/image/smoke.png';
            break;
        case "4":
            url = '/assets/esmap/image/firealarm.png';
    }
    im = new esmap.ESImageMarker({
        x: x,
        y: y,
        height: 1.0,
        url: url,
        size: 3,
        seeThrough: true,
        showLevel: 20,
        angle: 0, //控制标注随着地图旋转。(size需要重新设置)
        zoom: 0 //控制标注随着地图缩小
    });
    addImagelayer.addMarker(im);
}


function addAngle() { //改变角度  增加旋转角度
    if (cameraFlag||radarFlag||modifyFlag||smokeFlag||fireFlag) {
        var angle = $("#deviceAngle").val();
        angle = Number(angle) + 10;
        $("#deviceAngle").val(angle);
        fnum = map.focusFloorNum;
        updateMakerAngle(angle, fnum);
    }
}

function cutAngle() { //改变角度  减少旋转角度
    if (cameraFlag||radarFlag||modifyFlag||smokeFlag||fireFlag) {
        var angle = $("#deviceAngle").val();
        angle = Number(angle) - 10;
        $("#deviceAngle").val(angle);
        fnum = map.focusFloorNum;
        updateMakerAngle(angle, fnum);
    }
}

function updateMakerAngle(angle, fnum) {
    im.rotateTo(angle);
}

// 点击添加摄像头
$("#addCamera").click(function () {
    cameraFlag = true;
    radarFlag = false;
    smokeFlag = false;
    fireFlag = false;
    modifyFlag = false;
    deleteFlag = false;
    if (addImagelayer) addImagelayer.removeAll();
    floorLayer = map.getFloor(map.focusFloorNum);
    addImagelayer = new esmap.ESLayer('imageMarker');
    floorLayer.addLayer(addImagelayer);
});
// 点击添加雷达
$("#addRadar").click(function () {
    cameraFlag = false;
    radarFlag = true;
    smokeFlag = false;
    fireFlag = false;
    modifyFlag = false;
    deleteFlag = false;
    if (addImagelayer) addImagelayer.removeAll();
    floorLayer = map.getFloor(map.focusFloorNum);
    addImagelayer = new esmap.ESLayer('imageMarker');
    floorLayer.addLayer(addImagelayer);
});
// 点击添加烟感
$("#addSmoke").click(function () {
    cameraFlag = false;
    radarFlag = false;
    smokeFlag = true;
    fireFlag = false;
    modifyFlag = false;
    deleteFlag = false;
    if (addImagelayer) addImagelayer.removeAll();
    floorLayer = map.getFloor(map.focusFloorNum);
    addImagelayer = new esmap.ESLayer('imageMarker');
    floorLayer.addLayer(addImagelayer);
});
// 点击添加火灾报警
$("#addFirealarm").click(function () {
    cameraFlag = false;
    radarFlag = false;
    smokeFlag = false;
    fireFlag = true;
    modifyFlag = false;
    deleteFlag = false;
    if (addImagelayer) addImagelayer.removeAll();
    floorLayer = map.getFloor(map.focusFloorNum);
    addImagelayer = new esmap.ESLayer('imageMarker');
    floorLayer.addLayer(addImagelayer);
});
// 点击修改信息
$('#modify').click(function () {
    cameraFlag = false;
    radarFlag = false;
    smokeFlag = false;
    fireFlag = false;
    modifyFlag = true;
    deleteFlag = false;
});
// 点击删除
$('#delete').click(function () {
    cameraFlag = false;
    radarFlag = false;
    smokeFlag = false;
    fireFlag = false;
    modifyFlag = false;
    deleteFlag = true;
});
//取消
$("#reset").click(function () {
    $('#mapPositionX').val(null);
    $('#mapPositionY').val(null);
    $("#deviceSn").val(null);
    $("#deviceFloor").val(null);
    $("#deviceAngle").val(null);

    if (addImagelayer) addImagelayer.removeAll();

    cameraFlag = false;
    radarFlag = false;
    smokeFlag = false;
    fireFlag = false;
    modifyFlag = false;
    deleteFlag = false;
});

//绑定事件
function bingEvents() {
    document.getElementById('btn3D').onclick = function () {
        if (map.viewMode == esmap.ESViewMode.MODE_2D) {
            map.viewMode = esmap.ESViewMode.MODE_3D; //2D-->3D
            document.getElementById('btn3D').style.backgroundImage = "url('/assets/esmap/image/wedgets/3D.png')";
        } else {
            map.viewMode = esmap.ESViewMode.MODE_2D; //3D-->2D
            document.getElementById('btn3D').style.backgroundImage = "url('/assets/esmap/image/wedgets/2D.png')";
        }
    }
}

//保存按钮
var submit = document.getElementById("submit");
submit.onclick = function () {
    if (modifyFlag) {
        $("input").remove("[name = '_method']");
    }
    var test = $('#putDevice').serialize();
    console.log(test);
    //提交表单
    $.ajax({
        url: "/device",
        dataType: "json",
        data: $('#putDevice').serialize(),
        type: 'post',
        success: function (data) {
            if (data.s == 1) {
                alert("提示：操作成功！");
                setTimeout(function () {
                    window.location.reload();
                }, 1000);
            }
            if (data.s == -1) {
                alert(data.data);
            }
        },
        error: function () {
            alert("请检查网络连接");
        }
    });
}

//删除确定
function toDeleteDevice(deviceId) {
    $('#delete-ok').attr("onclick", "deleteDevice(" + deviceId + ")");
    $('#deleteDevice').modal();
}

function deleteDevice(deviceId) {
    var url = "/device/" + deviceId;
    $.ajax({
        url: url,
        dataType: "json",
        type: 'DELETE',
        success: function (data) {
            if (data.s == 1) {
                alert("提示：操作成功！");
                setTimeout(function () {
                    window.location.reload();
                }, 1000);
            }
            if (data.s == -1) {
                alert(data.data);
            }
        },
        error: function () {
            alert("请检查网络连接");
        }
    });
}
