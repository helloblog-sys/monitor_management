<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,role-scalable=no"/>
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
    <title>角色列表</title>
    <style>
        p:nth-child(even){
            background: #ccc;
        }
    </style>
</head>
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i> 首页
    <span class="c-gray en">&gt;</span> 角色管理
    <span class="c-gray en">&gt;</span> 角色列表
    <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="Hui-iconfont">&#xe68f;</i>
    </a>
</nav>
<div class="page-container">
    <div class="cl pd-5 bg-1 bk-gray">
        <span class="l">
            <a href="javascript:;" onclick="roles_delete()" class="btn btn-danger radius"><i
                        class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>
            <a class="btn btn-primary radius" href="javascript:;" onclick="role_add('添加角色','role_add')"><i
                        class="Hui-iconfont">&#xe600;</i> 添加角色</a>
        </span>
        <span class="r">共有数据：<strong>${roleList?size}</strong> 条</span>
    </div>
    <table class="table table-border table-bordered table-hover table-bg">
        <thead>
        <tr>
            <th scope="col" colspan="8">角色列表</th>
        </tr>
        <tr class="text-c">
            <th width="25"><input type="checkbox" value="" name=""></th>
            <th width="40">序号</th>
            <th width="240">角色名称</th>
            <th>角色描述</th>
            <th width="100">权限</th>
            <th width="300">创建时间</th>
            <th width="70">操作</th>
        </tr>
        </thead>
        <tbody>
        <#list roleList as roleList>
            <tr class="text-c">
                <td><input type="checkbox" value="${roleList.roleId}" name="checkbox"></td>
                <td>${roleList_index+1}</td>
                <td>${roleList.roleStr}</td>
                <td>${roleList.roleName}</td>
                <td><a onclick="role_permission(${roleList.roleId},${roleList_index+1})">
                        <span class="label label-success radius">点击查看</span></a></td>
                <td>${roleList.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
                <td class="f-14">
                    <a title="编辑" href="javascript:;" onclick="role_edit('角色编辑',${roleList.roleId},${roleList_index+1})"
                       style="text-decoration:none">
                        <i class="Hui-iconfont">&#xe6df;</i>
                    </a>
                    <a title="删除" href="javascript:;" onclick="role_delete(this,${roleList.roleId})" class="ml-5"
                       style="text-decoration:none">
                        <i class="Hui-iconfont">&#xe6e2;</i>
                    </a>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
<!--新增、编辑角色模块-->
<div id="role_edit" style="display: none">
    <form class="form form-horizontal" style="padding-top: 5%;padding-bottom: 5%;width:480px" id="form_role">
        <input type="hidden" name="_method" value="PUT"/>
        <input type="hidden" name="roleId" id="roleId" value=""/>
        <div class="row cl" style="padding-left: 50px">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>角色名称：</label>
            <div class="formControls col-xs-7 col-sm-7">
                <input type="text" class="input-text" value="" id="roleName" name="roleName">
            </div>
        </div>
        <div class="row cl" style="padding-left: 50px">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>角色描述：</label>
            <div class="formControls col-xs-7 col-sm-7">
                <input type="text" class="input-text" value="" placeholder="请填写角色描述" id="roleStr"
                       name="roleStr">
            </div>
        </div>
        <div class="row cl" style="padding-left: 50px">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                <button class="btn btn-success radius" id="role_save">
                <i class="icon-ok"></i> 确定
                </button>
            </div>
        </div>
    </form>
</div>
<!--查看角色权限-->
<div id="list_role_permission" style="display: none">
    <div class="panel panel-secondary mt-20">
        <div class="panel-header"><h4 id="title"></h4></div>
        <table id="mytable"></table>
    </div>
    <div class="text-c" style="padding-top: 4%;padding-bottom: 2%">
        <a id="permission_edit" href="">
        <button class="btn btn-primary radius size-L"
        <i class="icon-ok"></i> 修改权限
        </button>
        </a>
    </div>
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
    /*角色-添加*/
    function role_add(title) {
        $("input").remove("[name = 'roleId']");
        layer.open({
            type: 1,
            area: ['500px', 'auto'],
            fix: false, //不固定
            maxmin: true,
            shade: 0.4,
            title: title,
            content: $('#role_edit'),
            cancel: function(){
                location.replace(location.href);
            }
        });
    }

    /*角色-编辑*/
    function role_edit(title, id, index) {
        var tid = index - 1;
        document.getElementById('roleId').value = id;
        document.getElementById('roleName').value = $('tbody tr:eq(' + tid + ') td:eq(2)').text();
        document.getElementById('roleStr').value = $('tbody tr:eq(' + tid + ') td:eq(3)').text();
        ;
        $("input").remove("[name = '_method']");
        layer.open({
            type: 1,
            area: ['500px', 'auto'],
            fix: false, //不固定
            maxmin: true,
            shade: 0.4,
            title: title,
            content: $('#role_edit'),
            cancel: function(){
                location.replace(location.href);
            }
        });
    }

    /*角色-单个删除*/
    function role_delete(obj, id) {
        layer.confirm('角色删除须谨慎，确认要删除吗？', function () {
            $.ajax({
                type: 'DELETE',
                url: '/role/' + id,
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

    /*角色-批量删除*/
    function roles_delete() {
        var result = [];
        var count = 0;
        $("input[name=\"checkbox\"]:checked").each(function () {
            result[count] = $(this).val();
            count++;
        });
        if (count == 0) return;
        else {
            layer.confirm('角色删除须谨慎，确认要删除这' + count + '个角色吗？', function () {
                $.ajax({
                    type: 'DELETE',
                    url: '/role/batch/' + result,
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

    //添加、更新角色信息
    $('#role_save').click(function () {
        $("#form_role").validate({
            rules: {
                roleName: {
                    required: true,
                },
                roleStr: {
                    required: true,
                }
            },
            onkeyup: false,
            focusCleanup: true,
            success: "valid",
            submitHandler: function () {
                $.ajax({
                    url: '/role',
                    dataType: "json",
                    data: $('#form_role').serialize(),
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

    //查看角色-权限信息请求
    function role_permission(roleId, index) {
        $.ajax({
            url: '/permission/' + roleId,
            dataType: "json",
            type: 'get',
            success: function (data) {
                if (data.s == 1) {
                    layer_role_permission(data.data, index, roleId);
                } else {
                    alert("提示： " + data.data);
                }
            },
            error: function () {
                alert("请检查网络连接");
            }
        });
    }

    //查看角色-权限窗口
    function layer_role_permission(data, index, roleId) {
        var tid = index - 1;

        document.getElementById("title").innerHTML = $('tbody tr:eq(' + tid + ') td:eq(2)').text() + "权限:";

        $("#mytable").append("<tr><td>&nbsp;</<td></tr>");
        for(var p in data){
            if(p%2==0){
                $("#mytable").append("<tr><td><p class='text-c' style='font-size: 18px'>"+data[p]+"</p></<td></tr>");
            }
            else{
                $("#mytable").append("<tr><td><p class='text-c' style='font-size: 18px;background-color: #DDDDDD'>"+data[p]+"</p></<td></tr>");
            }
        }
        $("#mytable").append("<tr><td>&nbsp;</<td></tr>");

        document.getElementById("permission_edit").href = "/rolePermission/" + roleId;
        layer.open({
            type: 1,
            area: ['300px', 'auto'],
            fix: false, //不固定
            maxmin: true,
            shade: 0.4,
            title: '角色权限',
            content: $('#list_role_permission'),
            cancel: function(){
                location.replace(location.href);
            }
        });
    }
</script>
</body>
</html>