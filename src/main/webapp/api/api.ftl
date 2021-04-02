<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
    <script type="text/javascript" src="http://lib.h-ui.net/jquery.form/3.51.0/jquery.form.min.js"></script>
    <script type="text/javascript">
        window.SINGLE_TAB = "  ";
        window.ImgCollapsed = "http://tmxk.org/c/json/Collapsed.gif";
        window.ImgExpanded = "http://tmxk.org/c/json/Expanded.gif";
        window.QuoteKeys = true;

        function $id(id) {
            return document.getElementById(id);
        }

        function IsArray(obj) {
            return obj &&
                typeof obj === 'object' &&
                typeof obj.length === 'number' &&
                !(obj.propertyIsEnumerable('length'));
        }

        function Process() {
            SetTab();
            window.IsCollapsible = $id("CollapsibleView").checked;
            var json = $id("RawJson").value;
            var html = "";
            try {
                if (json == "") json = "\"\"";
                var obj = eval("[" + json + "]");
                html = ProcessObject(obj[0], 0, false, false, false);
                $id("Canvas").innerHTML = "<PRE class='CodeContainer'>" + html + "</PRE>";
            } catch (e) {
                alert("JSON数据格式不正确:\n" + e.message);
                $id("Canvas").innerHTML = "";
            }
        }

        window._dateObj = new Date();
        window._regexpObj = new RegExp();

        function ProcessObject(obj, indent, addComma, isArray, isPropertyContent) {
            var html = "";
            var comma = (addComma) ? "<span class='Comma'>,</span> " : "";
            var type = typeof obj;
            var clpsHtml = "";
            if (IsArray(obj)) {
                if (obj.length == 0) {
                    html += GetRow(indent, "<span class='ArrayBrace'>[ ]</span>" + comma, isPropertyContent);
                } else {
                    clpsHtml = window.IsCollapsible ? "<span><img src=\"" + window.ImgExpanded + "\" onClick=\"ExpImgClicked(this)\" /></span><span class='collapsible'>" : "";
                    html += GetRow(indent, "<span class='ArrayBrace'>[</span>" + clpsHtml, isPropertyContent);
                    for (var i = 0; i < obj.length; i++) {
                        html += ProcessObject(obj[i], indent + 1, i < (obj.length - 1), true, false);
                    }
                    clpsHtml = window.IsCollapsible ? "</span>" : "";
                    html += GetRow(indent, clpsHtml + "<span class='ArrayBrace'>]</span>" + comma);
                }
            } else if (type == 'object') {
                if (obj == null) {
                    html += FormatLiteral("null", "", comma, indent, isArray, "Null");
                } else if (obj.constructor == window._dateObj.constructor) {
                    html += FormatLiteral("new Date(" + obj.getTime() + ") /*" + obj.toLocaleString() + "*/", "", comma, indent, isArray, "Date");
                } else if (obj.constructor == window._regexpObj.constructor) {
                    html += FormatLiteral("new RegExp(" + obj + ")", "", comma, indent, isArray, "RegExp");
                } else {
                    var numProps = 0;
                    for (var prop in obj) numProps++;
                    if (numProps == 0) {
                        html += GetRow(indent, "<span class='ObjectBrace'>{ }</span>" + comma, isPropertyContent);
                    } else {
                        clpsHtml = window.IsCollapsible ? "<span><img src=\"" + window.ImgExpanded + "\" onClick=\"ExpImgClicked(this)\" /></span><span class='collapsible'>" : "";
                        html += GetRow(indent, "<span class='ObjectBrace'>{</span>" + clpsHtml, isPropertyContent);

                        var j = 0;

                        for (var prop in obj) {

                            var quote = window.QuoteKeys ? "\"" : "";

                            html += GetRow(indent + 1, "<span class='PropertyName'>" + quote + prop + quote + "</span>: " + ProcessObject(obj[prop], indent + 1, ++j < numProps, false, true));
                        }
                        clpsHtml = window.IsCollapsible ? "</span>" : "";
                        html += GetRow(indent, clpsHtml + "<span class='ObjectBrace'>}</span>" + comma);
                    }
                }

            } else if (type == 'number') {
                html += FormatLiteral(obj, "", comma, indent, isArray, "Number");

            } else if (type == 'boolean') {
                html += FormatLiteral(obj, "", comma, indent, isArray, "Boolean");

            } else if (type == 'function') {
                if (obj.constructor == window._regexpObj.constructor) {

                    html += FormatLiteral("new RegExp(" + obj + ")", "", comma, indent, isArray, "RegExp");
                } else {
                    obj = FormatFunction(indent, obj);
                    html += FormatLiteral(obj, "", comma, indent, isArray, "Function");
                }
            } else if (type == 'undefined') {
                html += FormatLiteral("undefined", "", comma, indent, isArray, "Null");
            } else {
                html += FormatLiteral(obj.toString().split("\\").join("\\\\").split('"').join('\\"'), "\"", comma, indent, isArray, "String");
            }
            return html;
        }

        function FormatLiteral(literal, quote, comma, indent, isArray, style) {
            if (typeof literal == 'string')
                literal = literal.split("<").join("&lt;").split(">").join("&gt;");
            var str = "<span class='" + style + "'>" + quote + literal + quote + comma + "</span>";
            if (isArray) str = GetRow(indent, str);
            return str;
        }

        function FormatFunction(indent, obj) {
            var tabs = "";
            for (var i = 0; i < indent; i++) tabs += window.TAB;
            var funcStrArray = obj.toString().split("\n");
            var str = "";
            for (var i = 0; i < funcStrArray.length; i++) {
                str += ((i == 0) ? "" : tabs) + funcStrArray[i] + "\n";
            }
            return str;
        }

        function GetRow(indent, data, isPropertyContent) {
            var tabs = "";
            for (var i = 0; i < indent && !isPropertyContent; i++) tabs += window.TAB;
            if (data != null && data.length > 0 && data.charAt(data.length - 1) != "\n")
                data = data + "\n";
            return tabs + data;
        }

        function CollapsibleViewClicked() {
            $id("CollapsibleViewDetail").style.visibility = $id("CollapsibleView").checked ? "visible" : "hidden";
            Process();
        }

        function QuoteKeysClicked() {
            window.QuoteKeys = $id("QuoteKeys").checked;
            Process();
        }

        function CollapseAllClicked() {
            EnsureIsPopulated();
            TraverseChildren($id("Canvas"), function (element) {
                if (element.className == 'collapsible') {
                    MakeContentVisible(element, false);
                }

            }, 0);
        }

        function ExpandAllClicked() {
            EnsureIsPopulated();
            TraverseChildren($id("Canvas"), function (element) {
                if (element.className == 'collapsible') {
                    MakeContentVisible(element, true);
                }

            }, 0);

        }

        function MakeContentVisible(element, visible) {
            var img = element.previousSibling.firstChild;
            if (!!img.tagName && img.tagName.toLowerCase() == "img") {
                element.style.display = visible ? 'inline' : 'none';
                element.previousSibling.firstChild.src = visible ? window.ImgExpanded : window.ImgCollapsed;
            }
        }

        function TraverseChildren(element, func, depth) {
            for (var i = 0; i < element.childNodes.length; i++) {
                TraverseChildren(element.childNodes[i], func, depth + 1);
            }
            func(element, depth);
        }

        function ExpImgClicked(img) {
            var container = img.parentNode.nextSibling;
            if (!container) return;
            var disp = "none";
            var src = window.ImgCollapsed;
            if (container.style.display == "none") {
                disp = "inline";
                src = window.ImgExpanded;
            }
            container.style.display = disp;
            img.src = src;
        }

        function CollapseLevel(level) {
            EnsureIsPopulated();
            TraverseChildren($id("Canvas"), function (element, depth) {
                if (element.className == 'collapsible') {
                    if (depth >= level) {
                        MakeContentVisible(element, false);
                    } else {
                        MakeContentVisible(element, true);
                    }
                }

            }, 0);
        }

        function TabSizeChanged() {
            Process();
        }

        function SetTab() {
            var select = $id("TabSize");
            window.TAB = MultiplyString(parseInt(select.options[select.selectedIndex].value), window.SINGLE_TAB);
        }

        function EnsureIsPopulated() {
            if (!$id("Canvas").innerHTML && !!$id("RawJson").value) Process();
        }

        function MultiplyString(num, str) {
            var sb = [];
            for (var i = 0; i < num; i++) {
                sb.push(str);
            }
            return sb.join("");
        }

        function SelectAllClicked() {
            if (!!document.selection && !!document.selection.empty) {
                document.selection.empty();

            } else if (window.getSelection) {
                var sel = window.getSelection();
                if (sel.removeAllRanges) {
                    window.getSelection().removeAllRanges();
                }
            }
            var range =
                (!!document.body && !!document.body.createTextRange)
                    ? document.body.createTextRange()
                    : document.createRange();
            if (!!range.selectNode)
                range.selectNode($id("Canvas"));
            else if (range.moveToElementText)
                range.moveToElementText($id("Canvas"));
            if (!!range.select)
                range.select($id("Canvas"));
            else
                window.getSelection().addRange(range);
        }

        function LinkToJson() {
            var val = $id("RawJson").value;
            val = escape(val.split('/n').join(' ').split('/r').join(' '));
            $id("InvisibleLinkUrl").value = val;
            $id("InvisibleLink").submit();
        }
    </script>

    <style type="text/css">
        body {
            display: flex;
            margin: 0 auto;
        }

        .left {
            display: flex;
            position: fixed;
            overflow: scroll;
            overflow-x: hidden;
            width: 12%;
            height: 100%;
        }

        .right {
            display: flex;
            position: fixed;
            width: 85%;
            height: 100%;
            left: 20%;
            justify-content: center;
            align-items: center;
        }

        .right-form {
            width: 50%;
            height: 100%;
        }

        .right-tool {
            width: 50%;
            height: 100%;
        }

        .gridtable {
            border: 1px solid #DEDEDE;
            border-collapse: collapse;
            margin-top: 50px;
        }

        .gridtable th {
            border-width: 1px;
            padding: 15px;
            font-size: 14px;
            border-style: solid;
            border-color: #DEDEDE;
            background-color: #f9f9f9;
            color: #2c3e50;
        }

        .gridtable td {
            border-width: 1px;
            padding: 15px;
            border-style: solid;
            font-size: 13px;
            border-color: #DEDEDE;
            background-color: #ffffff;
            color: #2c3e50;
        }

        .gridtable td input {
            width: 150px;
            height: 25px;
        }

        .left-ul {
            width: 100%;
            display: flex;
            flex-direction: column;
        }

        .left-li {
            padding: 10px;
            font-size: 16px;
            line-height: 1.4;
            width: 100%;
            text-align: center;
        }

        .left-li a {
            text-decoration: none;

        }

        .list-a {
            color: #2c3e50;
        }

        .list-active {
            color: #e96900;
        }

        .form-title {
            margin-top: 50px;
        }

        .form-title span {
            font-size: 18px;
            color: #04152c;
        }

        .form-title-info {
            margin-top: 20px;
        }

        .form-title-info span {
            font-size: 14px;
            color: #2c3e50;
        }

        .hr {
            margin-top: 10px;
            height: 1px;
            width: 65%;
            background-color: #eaecef;
        }

        .Canvas {
            background-color: #f5f5f5;
            width: 100%;
            height: 100%;
        }

        .text-color {
            color: #2c3e50;
        }

        .test {
            font-size: 14px;
            padding: 5px 20px;
        }

        .code {
            color: #e96900;
            padding: 5px 10px;
            margin: 0;
            font-size: 14px;
            font-weight: bold;
            background-color: rgba(27, 31, 35, .05);
            border-radius: 3px;
        }

        .f14 {
            font-size: 14px;
        }

        .li-active {
            background-color: rgba(27, 31, 35, .05);
            color: #e96900;
        }
    </style>
    <style type="text/css">
        /* CSS Document */
        div.ControlsRow, div.HeadersRow {
            font-family: Georgia;
        }

        div.Canvas {
            font-family: Lucida Console, Georgia;
            font-size: 13px;
            background-color: #ECECEC;
            color: #000000;
            border: solid 1px #CECECE;
        }

        .ObjectBrace {
            color: #00AA00;
            font-weight: bold;
        }

        .ArrayBrace {

            color: #0033FF;

            font-weight: bold;

        }

        .PropertyName {

            color: #CC0000;

            font-weight: bold;

        }

        .String {

            color: #007777;

        }

        .Number {

            color: #AA00AA;

        }

        .Boolean {

            color: #0000FF;

        }

        .Function {

            color: #AA6633;

            text-decoration: italic;

        }

        .Null {

            color: #0000FF;

        }

        .Comma {

            color: #000000;

            font-weight: bold;

        }

        PRE.CodeContainer {

            margin-top: 0px;

            margin-bottom: 0px;

        }

        PRE.CodeContainer img {

            cursor: pointer;

            border: none;

            margin-bottom: -1px;

        }

        #CollapsibleViewDetail a {
            padding-left: 10px;
            color: #428bca;
        }

        #ControlsRow {
            white-space: nowrap;
            font: 11px Georgia;

        }

        #TabSizeHolder {
            padding-left: 10px;
            padding-right: 10px;
        }

        #HeaderTitle {
            text-align: right;
            font-size: 11px;
        }

        #HeaderSubTitle {
            margin-bottom: 2px;
            margin-top: 0px
        }

        #RawJson {
            width: 99%;
            height: 120px;

        }

        A.OtherToolsLink {
            color: #555;
            text-decoration: none;
        }

        A.OtherToolsLink:hover {
            text-decoration: underline;
        }

    </style>
</head>
<body>
<div class="left">
    <div class="left-ul">
        <#list list as r>
            <#if api_name == r.api>
                <div class="left-li li-active"><a class="list-a list-active"
                                                  href="${(path)!''}/${(r.api)!''}">${(r.api)!''}</a></div>
            <#else>
                <div class="left-li"><a class="list-a" href="${(path)!''}/${(r.api)!''}">${(r.api)!''}</a></div>
            </#if>

        </#list>
    </div>
</div>

<div class="right">
    <div class="right-form">
        <div class="form-title">
            <span>${(api.api)!''}</span>
        </div>
        <div class="hr">
        </div>
        <div class="form-title-info">
            <span><code class="code">${(api.url)!""}</code></span>
            <span style="display: block;margin-top: 20px;color:#999;">${(api.explain)!""}</span>
        </div>
        <table class="gridtable">
            <tr>
                <th>参数名称</th>
                <th>参数说明</th>
                <th>参数类型</th>
                <th>参数值</th>
            </tr>
            <#if api?? && api.form??>
                <#if api.form.multipart == 1>
                    <form class="form" action="${(api.url)!'#'}" method="post" enctype="multipart/form-data">
                        <#if api.getParams()??>
                            <#list api.getParams() as r>
                                <tr>
                                    <td><code class="code">${(r.name)!''}</code></td>
                                    <td>${(r.explain)!''}</td>
                                    <td>${(r.type)!''}</td>
                                    <#if r.type == "File">
                                        <td><input type="file" name="${(r.name)!''}" placeholder="选择文件"/></td>
                                    <#else>
                                        <td><input type="text" name="${(r.name)!''}" placeholder="输入值"/></td>
                                    </#if>
                                </tr>
                            </#list>
                        </#if>
                        <tr>
                            <td colspan='4' align="center"><input style="height:30px" value="调用接口" type="submit">
                        </tr>
                    </form>
                <#else>
                    <form class="form" action="${(api.url)!'#'}" method="${api.form.method}">
                        <#if api.getParams()??>
                            <#list api.getParams() as r>
                                <tr>
                                    <td><code class="code">${(r.name)!''}</code></td>
                                    <td>${(r.explain)!''}</td>
                                    <td>${(r.type)!''}</td>
                                    <#if r.type == "File">
                                        <td><input type="file" name="${(r.name)!''}" placeholder="选择文件"></td>
                                    <#else>
                                        <td><input type="text" name="${(r.name)!''}" placeholder="输入值"></td>
                                    </#if>
                                </tr>
                            </#list>
                        </#if>
                        <tr>
                            <td colspan='4' align="center"><input style="height:30px" value="调用接口" type="submit">
                        </tr>
                    </form>
                </#if>
            <#else>
                <form class="form" action="${(api.url)!'#'}">
                    <tr>
                        <td colspan='4' align="center"><input style="height:30px" value="调用接口" type="submit">
                    </tr>
                </form>
            </#if>
        </table>
        <div class="form-title">
            <span>返回值说明</span>
        </div>
        <div class="hr">
        </div>
        <div class="form-title-info">
            <span></span>
        </div>
        <div class="return_param">
            <#if api.getReturns()??>
            <#list api.getReturns() as r>
                <li style="margin-top: 10px;"><code class="code">${(r.name)!''}</code>：<span
                            class="text-color f14">${(r.explain)!''}</span></li>
            </#list>
            </#if>
        </div>
    </div>
    <div class="right-tool">
        <div class="HeadersRow">
        </div>
        <textarea style="display:none" id="RawJson"></textarea>
        <div id="ControlsRow" style="background-color: #D4D4D4;">
            <input type="Button" value="格式化" onclick="Process()"/>
            <span id="TabSizeHolder">
				    缩进量
				    <select id="TabSize" onchange="TabSizeChanged()">
				      <option value="1">1</option>
				      <option value="2" selected="true">2</option>
				      <option value="3">3</option>
				      <option value="4">4</option>
				      <option value="5">5</option>
				      <option value="6">6</option>
				    </select>
				  </span>
            <label for="QuoteKeys">
                <input type="checkbox" id="QuoteKeys" onclick="QuoteKeysClicked()" checked="true"/>
                引号
            </label>&nbsp;
            <a style="color:#428bca;" href="javascript:void(0);" onclick="SelectAllClicked()">全选</a>
            &nbsp;
            <span id="CollapsibleViewHolder">
				      <label for="CollapsibleView">
				        <input type="checkbox" id="CollapsibleView" onclick="CollapsibleViewClicked()" checked="true"/>
				        显示控制
				      </label>
				  </span>
            <span id="CollapsibleViewDetail">
				    <a href="javascript:void(0);" onclick="ExpandAllClicked()">展开</a>
				    <a href="javascript:void(0);" onclick="CollapseAllClicked()">叠起</a>
				    <a href="javascript:void(0);" onclick="CollapseLevel(3)">2级</a>
				    <a href="javascript:void(0);" onclick="CollapseLevel(4)">3级</a>
				    <a href="javascript:void(0);" onclick="CollapseLevel(5)">4级</a>
				    <a href="javascript:void(0);" onclick="CollapseLevel(6)">5级</a>
				    <a href="javascript:void(0);" onclick="CollapseLevel(7)">6级</a>
				    <a href="javascript:void(0);" onclick="CollapseLevel(8)">7级</a>
				    <a href="javascript:void(0);" onclick="CollapseLevel(9)">8级</a>
				  </span>
        </div>
        <div id="Canvas" class="Canvas"
    </div>
</div>

</div>
<script type="text/javascript">
    $(function () {
        $(".form").submit(function () {
            $(this).ajaxSubmit({
                headers:{
                    "Access-Control-Allow-Origin":"*"
                },
                success: function (data) {
                    $("#RawJson").val(JSON.stringify(data));
                    Process();
                },
                error: function (data) {
                    alert("server error Oops....");
                }
            });
            return false;
        });
    });

</script>
</body>
</html>
