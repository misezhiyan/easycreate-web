<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PROGRAM MAINTANANCE PAGE</title>
<jsp:include page="../base/base.jsp"/>
<script type="text/javascript" src="/static/js/jquery.3.3.1.min.js"></script>
<script type="text/javascript">
	var programid = ${programid};
</script>
<style type="text/css">
</style>
</head>
<body>
	<br>
	<input type="button" onclick="businessDataStructureMaintanance()" value="业务数据维护">
	<br>
	<input type="button" onclick="dataStructureMaitanance()" value="表结构维护">
	<br>
	<input type="button" onclick="businessLineMaintanance()" value="业务线逻辑维护">
	<br>
</body>
<script type="text/javascript">
	// 业务数据维护
	function businessDataStructureMaintanance() {
		var businessDataStructureMaintananceUrl = webRoot + '/datastructure/businessMaintanancePage?programid=' + programid;
		window.open(businessDataStructureMaintananceUrl);
	}
	// 数据表结构维护
	function dataStructureMaitanance() {
		var dataStructureMaitananceUrl = webRoot + '/datastructure/maintanancePage?programid=' + programid;
		window.open(dataStructureMaitananceUrl);
	}
	// 业务线逻辑维护
	function businessLineMaintanance() {
		var businessLineMaintananceUrl = webRoot + '/businessline/maintanancePage?programid=' + programid;
		window.open(businessLineMaintananceUrl);
	}
</script>
</html>