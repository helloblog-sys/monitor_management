<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="Bookmark" href="/favicon.ico">
    <link rel="Shortcut Icon" href="/assets/favicon.ico"/>
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
    <!--/meta 作为公共模版分离出去-->
    <title>添加用户</title>
</head>
<body>
<article class="page-container">
    <form class="form form-horizontal" id="user_add">
        <input type="hidden" name="_method" value="PUT"/>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用户名称：</label>
            <div class="formControls col-xs-7 col-sm-8">
                <input type="text" class="input-text" value="" placeholder="请填写用户名称" id="userName" name="userName">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用户密码：</label>
            <div class="formControls col-xs-7 col-sm-8">
                <input type="password" class="input-text" value="" placeholder="请填写用户密码" id="userPassword"
                       name="userPassword">
            </div>
        </div>
        <div class="row cl" style="padding-left: 50px">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用户邮箱：</label>
            <div class="formControls col-xs-7 col-sm-7">
                <input type="text" class="input-text required" value="" placeholder="电子邮箱" id="userEmail"
                       name="userEmail">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用户角色：</label>
            <div class="formControls col-xs-7 col-sm-8"> <span class="select-box" style="width:150px;">
			<select class="select" name="roleId" size="1">
				<option value="1">超级管理员</option>
				<option value="2">普通用户</option>
			</select>
			</span></div>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                <button class="btn btn-success radius" id="user_save"
                <i class="icon-ok"></i> 确定
                </button>
            </div>
        </div>
    </form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="/assets/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="/assets/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="/assets/js/H-ui.min.js"></script>
<script type="text/javascript" src="/assets/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="/assets/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="/assets/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="/assets/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">
    $('#user_save').click(function () {
        $("#user_add").validate({
            rules: {
                userName: {
                    required: true,
                },
                userPassword: {
                    required: true,
                },
                userEmail: {
                    required: true,
                },
                roleId: {
                    required: true,
                },
            },
            onkeyup: false,
            focusCleanup: true,
            success: "valid",
            submitHandler: function () {
                $.ajax({
                    url: '/user',
                    dataType: "json",
                    data: $('#user_add').serialize(),
                    type: 'post',
                    success: function (data) {
                        if (data.s == 1) {
                            layer.msg('添加成功!', {icon: 6, time: 1000});
                            setTimeout(function () {
                                layer.close(layer.index);
                                window.parent.location.reload();
                            },1000)
                        } else {
                            alert("提示： " + data.data);
                        }
                    },
                    error: function () {
                        alert("请检查网络连接");
                    }
                });
            }
        });
    });
</script>
</body>
</html>