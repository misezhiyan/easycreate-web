<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DATAMAINTAIN PAGE</title>
<script type="text/javascript" src="/static/js/jquery.3.3.1.min.js"></script>
<script type="text/javascript">
	var programid = ${programid};
</script>
</head>
<body>
	项目编码:${programid}
	<div id="databaseDiv" style="position: fix; width: 300px; height: 50px; background-color: red">
		使用库 <select style="width: 200px"></select> <br> +
		<input type="button" value="添加库配置">
		<div></div>
	</div>
	<br> 表结构列表:
	<div id="tableListDiv"></div>

	<div id="tableCreateArea">
		<br>
		<input type="button" onclick="addTableStructure(this)" value="添加表">
		<input type="button" onclick="submitTableAdd()" value="提交表添加">
	</div>
	<div id="createMudleDiv">
		<div id="tableCreateMudleDiv" style="display: none">
			<div name="tableAddArea">
				表名:
				<input type="text" name="tableName">
				<div id="tableCreateDiv">
					<div name="fieldDiv"></div>
					<input type="button" onclick="addFieldStructure(this)" value="添加字段">
				</div>
			</div>
			<br>
		</div>
		<div id="fieldCreateMudleDiv" style="display: none">
			<div name="fieldArea">
				字段名称:
				<input type="text" name="fieldName">
				字段备注:
				<input type="text" name="fieldComment">
				字段类型:
				<input type="text" name="fieldType">
				字段长度(总长度):
				<input type="text" name="fieldLength">
				小数位数:
				<input type="text" name="lengthAfterPoint">
				<br>
			</div>
		</div>
	</div>
</body>

<script type="text/javascript">
	//添加数据结构
	function submitTableAdd() {

		var tableAddContent = getTableAddContent();

		if (undefined == tableAddContent) {
			alert("获取表结构失败");
			return;
		}

		var addDataStructureUrl = webRoot + '/datastructure/addDataStructure';
		$.post(addDataStructureUrl, {
			programid : programid,
			tableStructure : tableAddContent
		}, function(data) {
			alert(data);
		})
	}
	function getTableAddContent() {

		var tableAddAreaNodes = $('#tableCreateArea').find('[name=tableAddArea]');

		var tableListContent = "[";
		for (var i = 0; i < tableAddAreaNodes.length; i++) {

			var tableContent = "{";

			var tableAddAreaNode = tableAddAreaNodes[i];
			var tableNameNode = $(tableAddAreaNode).find('[name=tableName]');
			var tableName = $(tableNameNode).val();
			tableContent += "\"tableName\":\"" + tableName + "\"";

			var tableFieldsContent = "[";
			var fieldAreaNodes = $(tableAddAreaNode).find('[name=fieldArea]');
			for (var j = 0; j < fieldAreaNodes.length; j++) {

				var fieldContent = "";

				var fieldAreaNode = fieldAreaNodes[j];
				var fieldNameNode = $(fieldAreaNode).find('[name=fieldName]');
				var fieldCommentNode = $(fieldAreaNode).find('[name=fieldComment]');
				var fieldTypeNode = $(fieldAreaNode).find('[name=fieldType]');
				var fieldLengthNode = $(fieldAreaNode).find('[name=fieldLength]');
				var lengthAfterPointNode = $(fieldAreaNode).find('[name=lengthAfterPoint]');

				var fieldName = $(fieldNameNode).val();
				var fieldComment = $(fieldCommentNode).val();
				var fieldType = $(fieldTypeNode).val();
				var fieldLength = $(fieldLengthNode).val();
				var lengthAfterPoint = $(lengthAfterPointNode).val();

				fieldContent += "{";
				fieldContent += "\"fieldName\":\"" + fieldName + "\",";
				fieldContent += "\"fieldComment\":\"" + fieldComment + "\",";
				fieldContent += "\"fieldType\":\"" + fieldType + "\",";
				fieldContent += "\"fieldLength\":" + fieldLength + ",";
				fieldContent += "\"lengthAfterPoint\":" + lengthAfterPoint;
				fieldContent += "}";

				tableFieldsContent += fieldContent;
				if (j != fieldAreaNodes.length - 1) {
					tableFieldsContent += ",";
				}
			}
			tableFieldsContent += "]";

			tableContent += ",";
			tableContent += "\"fieldList\":";
			tableContent += tableFieldsContent;
			tableContent += "}";

			tableListContent += tableContent;
			if (i != tableAddAreaNodes.length - 1) {
				tableFieldsContent += ",";
			}
		}
		tableListContent += "]";

		return tableListContent;
	}
</script>
<script type="text/javascript">
	var tableCreateMudle = tableCreateMudle || $('#tableCreateMudleDiv')[0].innerHTML;
	function addTableStructure(addtableButton) {
		var addTableCreateMudle = $(addtableButton);
		$(tableCreateMudle).insertBefore(addTableCreateMudle);
	}
	var fieldCreateMudle = fieldCreateMudle || $('#fieldCreateMudleDiv')[0].innerHTML;
	function addFieldStructure(addFieldButton) {
		$(addFieldButton).parent().find('[name=fieldDiv]').append(fieldCreateMudle);
	}
</script>
</html>