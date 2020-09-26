<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="Bookmark" href="/assets/favicon.ico">
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
    <title>楼宇可视化物联系统管理后台</title>
</head>
<body>
<header class="navbar-wrapper">
    <div class="navbar navbar-fixed-top">
        <div class="container-fluid cl">
            <span class="logo navbar-logo f-l mr-10 hidden-xs">楼宇可视化物联系统管理后台</span>
            <span class="logo navbar-slogan f-l mr-10 hidden-xs">v1.0</span>
            <a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:;">&#xe667;</a>
            <nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
                <ul class="cl">
                    <li>${roleName}</li>
                    <li class="dropDown dropDown_hover">
                        <a href="#" class="dropDown_A">${userName} <i class="Hui-iconfont">&#xe6d5;</i></a>
                        <ul class="dropDown-menu menu radius box-shadow">
                            <li><a href="/logout">退出</a></li>
                        </ul>
                    </li>
                    <li id="Hui-skin" class="dropDown right dropDown_hover"><a href="javascript:;" class="dropDown_A"
                                                                               title="换肤"><i class="Hui-iconfont"
                                                                                             style="font-size:18px">&#xe62a;</i></a>
                        <ul class="dropDown-menu menu radius box-shadow">
                            <li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a></li>
                            <li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
                            <li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
                            <li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
                            <li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
                            <li><a href="javascript:;" data-val="orange" title="橙色">橙色</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</header>
<aside class="Hui-aside">
    <div class="menu_dropdown bk_2">
        <dl id="menu-admin">
            <dt><i class="Hui-iconfont">&#xe62d;</i> 用户管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a data-href="/user/all" data-title="用户列表" href="javascript:void(0)">用户列表</a></li>
                    <li><a data-href="/permission/all" data-title="权限管理" href="javascript:void(0)">权限管理</a></li>
                    <li><a data-href="/role/all" data-title="角色管理" href="javascript:void(0)">角色管理</a></li>
                </ul>
            </dd>
        </dl>
        <dl id="menu-device">
            <dt><i class="Hui-iconfont">&#xe63c;</i> 设备管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a data-href="/device/all" data-title="全部设备" href="javascript:void(0)">全部设备</a></li>
                    <li><a data-href="/device/28" data-title="28号楼" href="javascript:void(0)">28号楼</a></li>
                    <li><a data-href="/device/29" data-title="29号楼" href="javascript:void(0)">29号楼</a></li>
                    <li><a data-href="/device/2" data-title="咖啡街" href="javascript:void(0)">咖啡街</a></li>
                    <li><a data-href="/device/3" data-title="主楼四区" href="javascript:void(0)">主楼四区</a></li>
                </ul>
            </dd>
        </dl>
        <dl id="menu-alarm">
            <dt><i class="Hui-iconfont">&#xe62f;</i> 告警信息<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a data-href="" data-title="摄像头告警信息" href="javascript:void(0)">摄像头告警信息</a></li>
                    <li><a data-href="/alarm/all" data-title="雷达告警信息" href="javascript:void(0)">雷达告警信息</a></li>
                </ul>
            </dd>
        </dl>
        <dl id="menu-manual">
            <dt><i class="Hui-iconfont">&#xe720;</i> 使用手册<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a data-href="/description/1" data-title="前台展示系统使用说明" href="javascript:void(0)">前台系统使用说明</a></li>
                    <li><a data-href="/description/2" data-title="后台管理系统使用说明" href="javascript:void(0)">后台系统使用说明</a></li>
                </ul>
            </dd>
        </dl>


    </div>
</aside>
<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a>
</div>
<section class="Hui-article-box">
    <div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
        <div class="Hui-tabNav-wp">
            <ul id="min_title_list" class="acrossTab cl">
                <li class="active">
                    <span title="我的桌面" data-href="welcome.html">我的桌面</span>
                    <em></em></li>
            </ul>
        </div>
        <div class="Hui-tabNav-more btn-group"><a id="js-tabNav-prev" class="btn radius btn-default size-S"
                                                  href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a
                id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a>
        </div>
    </div>
    <div id="iframe_box" class="Hui-article">
        <div class="show_iframe">
            <div style="display:none" class="loading"></div>
            <iframe scrolling="yes" frameborder="0" src="welcome.html"></iframe>
        </div>
    </div>
</section>

<div class="contextMenu" id="Huiadminmenu">
    <ul>
        <li id="closethis">关闭当前</li>
        <li id="closeall">关闭全部</li>
    </ul>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="/assets/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="/assets/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="/assets/js/H-ui.min.js"></script>
<script type="text/javascript" src="/assets/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->
</body>
</html>