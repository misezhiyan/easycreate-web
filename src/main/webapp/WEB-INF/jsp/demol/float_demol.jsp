<!-- 漂浮窗 -->
<div id="floatDiv" style="width: 300px; height: 200px; background: #AAAAAA">
	<div style="float: right; width: 100%; background: #AA00AA">
		<div style="float: right;">
			<!-- 
			<input type="button" value="+" onclick="">
			<input type="button" value="-" onclick="">
			 -->
			<input type="button" value="X" onclick="closeFloatDiv()">
		</div>
	</div>
</div>
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

	window.onload = function() {
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