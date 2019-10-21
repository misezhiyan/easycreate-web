<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<style type="text/css">
#maskDiv {
	position: absolute;
	top: 0;
	left: 0;
	background-color: rgba(9, 9, 9, 0.63);
	width: 100%;
	height: 100%;
	z-index: 1000;
	display: none;
}

#maskOperationDiv {
	width: 50%;
	text-align: center;
	background: #ffffff;
	border-radius: 6px;
	margin: 100px auto;
	line-height: 30px;
	z-index: 10001;
}
</style>


<div id="maskDiv">
	<div id="maskOperationDiv">
		蒙版
		<input type="button" onclick="hideMaskDiv()" value="关闭蒙版">
	</div>
</div>

<script type="text/javascript">
	function showMaskDiv() {
		$('#maskDiv').show();
	}
	function hideMaskDiv() {
		$('#maskDiv').hide();
	}
</script>