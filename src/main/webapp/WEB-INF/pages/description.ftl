<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
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
    <!--- markdown -->
    <link rel="stylesheet" href="/assets/lib/editor.md/css/editormd.css"/>
    <!-- layui -->

    <title>后台管理系统使用手册</title>
    <style>
        .main{
            width: 100%;
            position:absolute;
            top:40px;
            bottom:1px;
        }
        .context{
            width: 80%;
            height: 90%;
            margin-left: 10%;
            overflow: auto;
            border: #dedede 1px solid;
        }
    </style>
</head>
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i> 首页
    <span class="c-gray en">&gt;</span> 使用手册
    <span class="c-gray en">&gt;</span> 前台展示系统使用说明
    <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="Hui-iconfont">&#xe68f;</i>
    </a>
</nav>
<div class="main">
    <div class="context">
        <!-- 展示内容 -->
        <div id="md-show" style="display: inline;">
            <textarea>${content}</textarea>
        </div>
        <!-- markdown编辑器 -->
        <div id="md-editor">
            <textarea>${content}</textarea>
        </div>
    </div>
    <div>
        <input id="editor" type="button" name="editor" value="编辑" class="btn" style="margin-left: 10%;display: inline"/>
        <input id="submit" type="button" name="submit" value="确定" class="btn" style="margin-left: 10%;display: none"/>
        <input id="cancel" type="button" name="cancel" value="取消" class="btn" style="display: none"/>
    </div>

</div>
<!-- jquery -->
<script type="text/javascript" src="/assets/lib/jquery/1.9.1/jquery.min.js"></script>
<!-- layer -->
<script type="text/javascript" src="/assets/lib/layer/2.4/layer.js"></script>
<!-- editor.md -->
<script type="text/javascript" src="/assets/lib/editor.md/editormd.min.js"></script>
<script src="/assets/lib/editor.md/lib/marked.min.js"></script>
<script src="/assets/lib/editor.md/lib/prettify.min.js"></script>
<script src="/assets/lib/editor.md/lib/raphael.min.js"></script>
<script src="/assets/lib/editor.md/lib/underscore.min.js"></script>
<script src="/assets/lib/editor.md/lib/sequence-diagram.min.js"></script>
<script src="/assets/lib/editor.md/lib/flowchart.min.js"></script>
<script src="/assets/lib/editor.md/lib/jquery.flowchart.min.js"></script>
<script src="/assets/lib/editor.md/editormd.js"></script>
<script type="text/javascript">
    //内容展示
    var contentShow;
    $(function() {
        contentShow = editormd.markdownToHTML("md-show", {
            htmlDecode      : "style,script,iframe",  // you can filter tags decode
            emoji           : true,
            taskList        : true,
            tex             : true,  // 默认不解析
            flowChart       : true,  // 默认不解析
            sequenceDiagram : true,  // 默认不解析
        });
    });

    //初始化Markdown编辑器
    var contentEditor;
    $(function() {
        contentEditor = editormd("md-editor", {
            width: "98%",//宽度(默认100%)
            height: "98%",//高度(默认100%)
            syncScrolling : "single",//单滚动条
            path: "../../assets/lib/editor.md/lib/",
            saveHTMLToTextarea : true,
        });
        contentEditor.hide();
    });

    //编辑
    document.getElementById("editor").onclick = function(){
        contentShow.hide();
        contentEditor.show();
        contentEditor = editormd("md-editor", {
            width: "98%",//宽度(默认100%)
            height: "98%",//高度(默认100%)
            syncScrolling : "single",//单滚动条
            path: "../../assets/lib/editor.md/lib/",
            saveHTMLToTextarea : true,
        });
        document.getElementById("editor").style.display="none";
        document.getElementById("submit").style.display="inline";
        document.getElementById("cancel").style.display="inline";
    }

    //将文本持久化（确认按钮）
    document.getElementById("submit").onclick = function(){
        var mdCode = contentEditor.getMarkdown();
        var description = {
            descriptionId : ${descriptionId},
            descriptionContent : mdCode
        };
        $.ajax({
            url: '/description/update',
            dataType: "json",
            data: JSON.stringify(description),
            type: 'post',
            contentType:'application/json;charset=utf-8',
            success: function (data) {
                if (data.s == 1) {
                    layer.msg('操作成功!', {icon: 6, time: 1000});
                    setTimeout(function () {
                        layer.close(layer.index);
                        window.location.reload();
                    }, 1000)
                } else {
                    layer.msg(data.d + '!', {icon: 5, time: 1000});
                }
            },
            error: function () {
                alert("请检查网络连接");
            }
        });
    }

    //取消
    document.getElementById("cancel").onclick = function() {
        window.location.reload();
    }
</script>
</body>
</html>