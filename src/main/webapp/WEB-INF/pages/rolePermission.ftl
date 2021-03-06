<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,permission-scalable=no"/>
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
    <title>权限管理</title>
    <style>
        .high{ color: red; }
        .msg{ font-size: 13px; }
        .onError{ color: red; }
        .onSuccess{ color: green; }
    </style>
</head>
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i> 首页
    <span class="c-gray en">&gt;</span> 角色管理
    <span class="c-gray en">&gt;</span> ${roleName}权限管理
    <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="Hui-iconfont">&#xe68f;</i>
    </a>
</nav>
<div class="page-container">
    <div class="cl pd-5 bg-1 bk-gray">
        <span class="l">
            <a href="javascript:;" onclick="permissions_delete()" class="btn btn-danger radius"><i
                        class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>
            <a class="btn btn-primary radius" href="javascript:;" onclick="permission_add('添加权限','permission_add')"><i
                        class="Hui-iconfont">&#xe600;</i> 添加权限</a>
        </span>
        <span class="r">共有数据：<strong>${rolePermissionVoList?size}</strong> 条</span>
    </div>
    <table class="table table-border table-bordered table-hover table-bg">
        <thead>
        <tr>
            <th scope="col" colspan="6">${roleName}权限列表</th>
        </tr>
        <tr class="text-c">
            <th width="25"><input type="checkbox" value="" name=""></th>
            <th width="40">序号</th>
            <th width="340">权限名称</th>
            <th>权限描述</th>
            <th width="70">操作</th>
        </tr>
        </thead>
        <tbody>
        <#list rolePermissionVoList as rolePermissionVoList>
            <tr class="text-c">
                <td><input type="checkbox" value="${rolePermissionVoList.rpId}" name="checkbox"></td>
                <td>${rolePermissionVoList_index+1}</td>
                <td>${rolePermissionVoList.permission.permissionName}</td>
                <td>${rolePermissionVoList.permission.permissionStr}</td>
                <td class="f-14">
                    <a title="删除" href="javascript:;" onclick="permission_delete(this,${rolePermissionVoList.rpId})"
                       class="ml-5"
                       style="text-decoration:none">
                        <i class="Hui-iconfont">&#xe6e2;</i>
                    </a>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
<div id="permission_edit" style="display: none">
    <form class="form form-horizontal" style="padding-top: 5%;padding-bottom: 5%;width:780px" id="form_permission">
        <h4 style="padding-left:10%">请填写需要添加权限的ID</h4>
        <input type="hidden" name="roleId" id="roleId" value="${roleId}"/>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>权限ID：</label>
            <div class="formControls col-xs-7 col-sm-7">
                <input type="text" class="input-text" value="" placeholder="仅数字" id="permissionId" name="permissionId">
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                <button class="btn btn-success radius" id="permission_save">
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
<script>
    //此js为表单验证，tyd添加
    //为表单的必填文本框添加提示信息（选择form中的所有后代input元素）
    $("form :input.required").each(function () {
        var $required = $("<strong class='high'></strong>");
        $(this).parent().append($required);
    });

    //为表单元素添加失去焦点事件
    $("form :input").blur(function(){
        var $parent = $(this).parent();
        $parent.find(".msg").remove();
        //角色权限正则
        if($(this).is("#permissionId")){
            var permissionIdVal = $.trim(this.value);
            var regPermissionId = /^[0-9]{1,20}$/;
            if(permissionIdVal == "" || ( permissionIdVal != "" && !regPermissionId.test(permissionIdVal))){
                var errorMsg = " 仅数字！";
                $parent.append("<span class='msg onError'>" + errorMsg + "</span>");
            }
            else{
                var okMsg=" 输入正确";
                $parent.find(".high").remove();
                $parent.append("<span class='msg onSuccess'>" + okMsg + "</span>");
            }
        }
    }).keyup(function(){
        //triggerHandler 防止事件执行完后，浏览器自动为标签获得焦点
        $(this).triggerHandler("blur");
    }).focus(function(){
        $(this).triggerHandler("blur");
    });

    //点击确定按钮时，通过trigger()来触发文本框的失去焦点事件
    $("#permission_save").click(function(){
        //trigger 事件执行完后，浏览器会为submit按钮获得焦点
        $("form .required:input").trigger("blur");
        var numError = $("form .onError").length;
        if(numError){
            return false;
        }
    });
</script>
<script type="text/javascript">
    /*权限-添加*/
    function permission_add(title) {
        layer.open({
            type: 1,
            area: ['800px', '280px'],
            fix: false, //不固定
            maxmin: true,
            shade: 0.4,
            title: title,
            content: $('#permission_edit'),
            cancel: function(){
                location.replace(location.href);
            }
        });

    }

    /*权限-编辑*/
    function permission_edit(title, id, index) {
        var tid = index - 1;
        document.getElementById('permissionId').value = id;
        document.getElementById('permissionName').value = $('tbody tr:eq(' + tid + ') td:eq(2)').text();
        document.getElementById('permissionStr').value = $('tbody tr:eq(' + tid + ') td:eq(3)').text();
        ;
        $("input").remove("[name = '_method']");
        layer.open({
            type: 1,
            area: ['800px', '280px'],
            fix: false, //不固定
            maxmin: true,
            shade: 0.4,
            title: title,
            content: $('#permission_edit'),
            cancel: function(){
                location.replace(location.href);
            }
        });

    }

    /*权限-单个删除*/
    function permission_delete(obj, id) {
        var result = [];
        result[0]=id;
        layer.confirm('权限删除须谨慎，确认要删除吗？', function () {
            $.ajax({
                type: 'DELETE',
                url: '/rolePermission/' + result,
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
        });
    }

    /*权限-批量删除*/
    function permissions_delete() {
        var result = [];
        var count = 0;
        $("input[name=\"checkbox\"]:checked").each(function () {
            result[count] = $(this).val();
            count++;
        });
        if (count == 0) return;
        else {
            layer.confirm('权限删除须谨慎，确认要删除这' + count + '个权限吗？', function () {
                $.ajax({
                    type: 'DELETE',
                    url: '/rolePermission/' + result,
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

    //添加、更新权限信息
    $('#permission_save').click(function () {
        $("#form_permission").validate({
            rules: {
                permissionId: {
                    required: true,
                }
            },
            onkeyup: false,
            focusCleanup: true,
            success: "valid",
            submitHandler: function () {
                $.ajax({
                    url: '/rolePermission',
                    dataType: "json",
                    data: $('#form_permission').serialize(),
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
</script>
</body>
</html>