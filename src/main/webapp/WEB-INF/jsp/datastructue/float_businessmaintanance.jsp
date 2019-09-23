<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="floatDiv" style="width: 300px; height: 200px; background: #AAAAAA; display: none">
	<div style="float: right; width: 100%; background: #AA00AA">
		<div style="float: right;">
			<input type="button" value="X" onclick="closeFloatDiv()">
		</div>
	</div>
	<div style="margin: 30px">
		<table>
			<tr>
				<td><input type="radio" name="showType" checked="checked" showType="thisParam">只展示本项目基本业务字段</td>
			</tr>
			<tr>
				<td><input type="radio" name="showType" showType="chooseFromOtherParams">从其它业务字段中选取字段</td>
			</tr>
		</table>
	</div>
</div>
<script type="text/javascript">
	//从其它页面选取
	$('[name=showType]').click(function() {
		var showType = $(this).attr('showType');
		// 隐藏其它项目数据
		if ('thisParam' == showType) {
			$('#dragableDiv').find('table').find('tbody').empty();
			$('#dragableDiv').hide();
		} else if ('chooseFromOtherParams' == showType) {
			$('#dragableDiv').show();
		}
	})
</script>
<script type="text/javascript">
	function resetFloatPosition(floatnode) {

		// 漂浮窗宽度
		var floatnodewidth = floatnode.width();
		// 漂浮窗高度
		var floatnodeheight = floatnode.height();

		// 窗口宽度
		var width = document.body.clientWidth;
		// 窗口高度
		var height = document.body.clientHeight;

		// 滚动轴距顶部距离
		var top = document.body.scrollTop;
		// 滚动轴距左侧距离
		var left = document.body.scrollLeft;

		floatnode.css("top", top);
		floatnode.css("left", width + left - floatnodewidth);
	};

	function floatWindowInit() {

		var floatDiv = document.getElementById('floatDiv');
		$("#floatDiv").css({
			position : "absolute"
		});

		var floatnode = $("#floatDiv");
		resetFloatPosition(floatnode);
		window.onscroll = function() {
			resetFloatPosition(floatnode);
		}
	}
</script>
<script type="text/javascript">
	function closeFloatDiv() {
		$('#floatDiv').hide();
	}
</script>