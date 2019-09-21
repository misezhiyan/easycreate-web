<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<style type="text/css">
#dragableDiv {
	width:256px;
	height:146px;
	background-color:white;
	position:absolute;
	top:50%;
	left:50%;
	transform:translateX(-50%) translateY(-50%);
	-moz-transform:translateX(-50%) translateY(-50%);
	-webkit-transform:translateX(-50%) translateY(-50%);
	-ms-transform:translateX(-50%) translateY(-50%);
	border-radius:5px;
	box-shadow:3px 3px  10px blue;
}
</style>
<div id="dragableDiv" style="width: 200px; height: 200px; background: #000">可拖拽</div>

<!-- 可拖拽 -->
<script type="text/javascript">
	function dragable(dragableNode) {
		var drag = dragableNode[0];
		drag.onmousedown = function(event) {
			var ev = event || window.event;
			event.stopPropagation();
			var disX = ev.clientX - drag.offsetLeft;
			var disY = ev.clientY - drag.offsetTop;
			document.onmousemove = function(event) {
				var ev = event || window.event;
				Drag.style.cursor = "move";
				Drag.style.left = ev.clientX - disX + "px";
				Drag.style.top = ev.clientY - disY + "px";
			};
			drag.onmouseup = function() {
				document.onmousemove = null;
				this.style.cursor = "default";
			};
		};
	}

	window.onload = function() {
		var dragablenode = $("#dragableDiv");
		dragable(dragablenode);
	}
</script>