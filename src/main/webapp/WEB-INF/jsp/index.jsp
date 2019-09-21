<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HELLOWORLD PAGE</title>
<jsp:include page="base/base.jsp"/>
<script type="text/javascript" src="/static/js/jquery.3.3.1.min.js"></script>
</head>
<body>
	创建项目:
	<input id="createProgramButton" type="button" value="创建项目">
</body>
<script type="text/javascript">
	$(document).ready(function() {
		$('#createProgramButton').click(function() {
			window.location.href = webRoot + '/program/programCreatePage';
		})
	});
	//$document.
</script>
</html>