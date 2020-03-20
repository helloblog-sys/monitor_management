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
    <title>权限列表</title>
</head>
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i> 首页
    <span class="c-gray en">&gt;</span> 权限管理
    <span class="c-gray en">&gt;</span> 权限列表
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
        <span class="r">共有数据：<strong>${permissionList?size}</strong> 条</span>
    </div>
    <table class="table table-border table-bordered table-hover table-bg">
        <thead>
        <tr>
            <th scope="col" colspan="7">权限列表</th>
        </tr>
        <tr class="text-c">
            <th width="25"><input type="checkbox" value="" name=""></th>
            <th width="40">序号</th>
            <th width="240">权限名称</th>
            <th>权限描述</th>
            <th width="300">创建时间</th>
            <th width="70">操作</th>
        </tr>
        </thead>
        <tbody>
        <#list permissionList as permissionList>
            <tr class="text-c">
                <td><input type="checkbox" value="${permissionList.permissionId}" name="checkbox"></td>
                <td>${permissionList_index+1}</td>
                <td>${permissionList.permissionName}</td>
                <td>${permissionList.permissionStr}</td>
                <td>${permissionList.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
                <td class="f-14">
                    <a title="编辑" href="javascript:;" onclick="permission_edit('权限编辑',${permissionList.permissionId},${permissionList_index+1})"
                       style="text-decoration:none">
                        <i class="Hui-iconfont">&#xe6df;</i>
                    </a>
                    <a title="删除" href="javascript:;" onclick="permission_delete(this,${permissionList.permissionId})" class="ml-5"
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
    <form class="form form-horizontal" style="padding-top: 5%" id="form_permission">
        <input type="hidden" name="_method" value="PUT"/>
        <input type="hidden" name="permissionId" id="permissionId" value=""/>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>权限名称：</label>
            <div class="formControls col-xs-7 col-sm-7">
                <input type="text" class="input-text" value="" id="permissionName" name="permissionName">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>权限描述：</label>
            <div class="formControls col-xs-7 col-sm-7">
                <input type="text" class="input-text" value="" placeholder="请填写权限描述" id="permissionStr"
                       name="permissionStr">
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                <button class="btn btn-success radius" id="permission_save">
                <i class="icon-ok"></i> 确定
                </button>
                <button class="btn btn-success radius" style="background-color: red" id="user_cancel">
                    <i class="icon-ok"></i> 取消
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
    /*权限-添加*/
    function permission_add(title) {
        $("input").remove("[name = 'permissionId']");
        layer.open({
            type: 1,
            area: ['800px', '400px'],
            fix: false, //不固定
            maxmin: true,
            closeBtn:0,
            shade: 0.4,
            title: title,
            content: $('#permission_edit')
        });
    }

    /*权限-编辑*/
    function permission_edit(title, id, index) {
        var tid = index - 1;
        document.getElementById('permissionId').value = id;
        document.getElementById('permissionName').value = $('tbody tr:eq(' + tid + ') td:eq(2)').text();
        document.getElementById('permissionStr').value = $('tbody tr:eq(' + tid + ') td:eq(3)').text();;
        $("input").remove("[name = '_method']");
        layer.open({
            type: 1,
            area: ['800px', '400px'],
            fix: false, //不固定
            maxmin: true,
            closeBtn:0,
            shade: 0.4,
            title: title,
            content: $('#permission_edit')
        });
    }

    /*权限-单个删除*/
    function permission_delete(obj, id) {
        layer.confirm('权限删除须谨慎，确认要删除吗？', function () {
            $.ajax({
                type: 'DELETE',
                url: '/permission/' + id,
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
                    url: '/permission/batch/' + result,
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
                permissionName: {
                    required: true,
                },
                permissionStr: {
                    required: true,
                }
            },
            onkeyup: false,
            focusCleanup: true,
            success: "valid",
            submitHandler: function () {
                $.ajax({
                    url: '/permission',
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

    //取消用户编辑
    $('#user_cancel').click(function () {
        layer.close();
    })
</script>
</body>
</html>