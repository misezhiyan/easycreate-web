<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PROGRAM CRATE PAGE</title>
<jsp:include page="../base/base.jsp"/>
<script type="text/javascript" src="/static/js/jquery.3.3.1.min.js"></script>
</head>
<body>
	创建项目:
	<form action="">
		项目名称:
		<input type="text" name="programname">
		<div id="mudle">
			<input id="addmudlebutton" type="button" value="添加模块">
			<div name="programmodle" style="display: none">
				<div>
					模块名称:
					<input type="text" value="">
					<a>创建模块</a>
				</div>
			</div>
		</div>
		<div id="datamaintaindiv">
			<input id="datamaintainbutton" type="button" value="数据结果维护">
		</div>
		
		<input type="button" value="确认创建">
	</form>
	<div style="height: 900px; width: 1900px"></div>
</body>
<script type="text/javascript">
	$('#datamaintainbutton').click(function() {
		window.local.href="";
	});
</script>
<script type="text/javascript">
	// 添加模块
	function addmudle() {
		var mudlemodle = mudlemodle
				|| $("div[name='programmodle']")[0].innerHTML;
		$(mudlemodle).insertBefore($('#addmudlebutton'));
	}
	$('#addmudlebutton').click(function() {
		addmudle();
	});
</script>
</html>