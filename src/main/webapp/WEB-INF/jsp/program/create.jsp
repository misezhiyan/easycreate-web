<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PROGRAM CRATE PAGE</title>
<jsp:include page="../base/base.jsp"/>
<script type="text/javascript" src="/static/js/jquery.3.3.1.min.js"></script>
<style type="text/css">
.programMaintananceA {
	background-color: red
}
</style>
</head>
<body>
	创建项目:
	<div>
		项目名称: <input type="text" name="programname">
	</div>
	<input id="programcreatebutton" type="button" value="确认创建">
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br> 项目列表:
	<div id="programListArea">
		列表展示页面 <br>
		<div id="programListDiv">
			<a onclick="" programid="">项目名称</a> <br>
		</div>
		<div id="programModleDiv" style="display: none">
			<label>表名</label> <a>表名</a>
		</div>
	</div>

</body>
<script type="text/javascript">
	$(function() {
		showProgramList();
	})
</script>
<script type="text/javascript">
	//创建项目
	$('#programcreatebutton').click(function() {
		var programname = $('input[name="programname"]').val();
		if ('' == programname) {
			alert('项目名称不能为空');
			return;
		}
		$.post(webRoot + '/program/createProgram', {
			"programname" : programname
		}, function(data) {
			var code = data.code;
			if (200 != data.code) {
				alert(data.message);
				return;
			}
			showProgramList();
		}, 'json')
	})
	//项目列表
	function showProgramList() {
		$('#programListDiv').empty();
		var programListContent = '';
		$.post(webRoot + '/program/programList', {}, function(data) {
			var code = data.code;
			if (200 != data.code) {
				alert(data.message);
				return;
			}
			var programList = data.result;
			for (var i = 0; i < programList.length; i++) {
				var program = programList[i];
				var programid = program.id;
				var programName = program.programName;
				var newProgramNode = "<a class='programMaintananceA' onclick='programMaintanancePage(" + programid + ")'>" + programName + "</a>";
				programListContent += "<br>";
				programListContent += newProgramNode;
			}
			$('#programListDiv')[0].innerHTML = programListContent;
		}, 'json');
	}
	//进入项目维护页面
	function programMaintanancePage(programid) {
		var programMaintanancePageUrl = webRoot + '/program/programMaintanancePage?programid=' + programid;
		//window.open('你所要跳转的页面')
		window.location.href = programMaintanancePageUrl;
	}
</script>
</html>