
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PROGRAM MAINTANANCE PAGE</title>
<jsp:include page="../base/base.jsp" />
<script type="text/javascript" src="/static/js/jquery.3.3.1.min.js"></script>
<script type="text/javascript">
	//var programid = ${programid};
	var programid = ${programid};
</script>
<style type="text/css">
</style>
</head>
<body>

	<div id="businessLineCreateDiv">
		创建业务线${programid }:
		<div>
			<input name="businessLineName" type="text" placeholder="业务线名称">
			<br>
			<input id="businessLineCreateButton" type="button" value="创建">
		</div>
	</div>

	<br>
	<br>
	<br>
	<br>
	<div id="businessLineDisplayDiv">
		业务线维护列表
		<div name="businessLineListDiv">
			<table>
			</table>
		</div>
		<table name="businessLineModel" style="display: none">
			<tr>
				<td><input type="hidden" name="businessLineId"></td>
				<td><a href="javascript:void(0)" name="businessLineName"></a></td>
			</tr>
		</table>
	</div>

</body>
<script type="text/javascript">
	$(function() {
		refreshBusinessLineList();
	})
	function refreshBusinessLineList() {
		var businessLineListNode = $('#businessLineDisplayDiv').find('[name=businessLineListDiv]').find('table');
		var businesslineListUrl = webRoot + "/businessline/businesslineList";
		$.post(businesslineListUrl, {
			programid : programid
		}, function(data) {
			var code = data.code;
			if (200 == code) {
				$(businessLineListNode).empty();
				var businessLineModelNode = businessLineModelNode || $('[name=businessLineModel]').find('tbody').find('tr')[0].outerHTML;
				var businessLineList = data.result;
				for (var i = 0; i < businessLineList.length; i++) {
					var businessLine = businessLineList[i];
					var businessLineName = businessLine.businessLineName;
					var businessLineId = businessLine.id;

					var businessLineNode = $(businessLineModelNode);
					
					var idNode = $(businessLineNode).find('[name=businessLineId]');
					var nameNode = $(businessLineNode).find('[name=businessLineName]');
					$(idNode).val(businessLineId);
					$(nameNode).append(businessLineName);
					$(nameNode).click(function() {
						var thisBusinessLineId = $(this).parent().parent().find('[name=businessLineId]').val();
						maintananceBusinessLine(thisBusinessLineId);
					})
					$(businessLineListNode).append($(businessLineNode));
				}
			}
		}, 'json');
	}
</script>
<script type="text/javascript">
	$('#businessLineCreateButton').click(function() {
		var businessLineName = $(this).parent().find('[name=businessLineName]').val();
		var businessLineCreateUrl = webRoot + "/businessline/businesslineCreate";
		$.post(businessLineCreateUrl, {
			businessLineName : businessLineName,
			programid : programid
		}, function(data) {
			var code = data.code;
			if (code == 200) {
				refreshBusinessLineList();
			} else {
				alert(data.message);
			}
		}, 'json')
	})
</script>
<!-- 业务线维护也买你 -->
<script type="text/javascript">
	function maintananceBusinessLine(businessLineId) {
		var businessLineMaintanancePageUrl = webRoot + '/businessline/operationPage?businessLineId=' + businessLineId;
		window.open(businessLineMaintanancePageUrl);
	}
</script>
</html>