<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DATAMAINTAIN PAGE</title>
<jsp:include page="../base/base.jsp" />
<script type="text/javascript" src="/static/js/jquery.3.3.1.min.js"></script>
<script type="text/javascript">
	//var programid = ${programid};
	var programid = ${programid};
</script>
<style type="text/css">
body {
	/* background: url(/static/pic/雪2.gif) top center no-repeat; */
	background-size: cover;
}
</style>
</head>
<body>
	项目编码:${programid}
	<!-- 
	<div id="databaseDiv" style="position: fix; width: 300px; height: 50px; background-color: red">
		使用库 <select style="width: 200px"></select> <br> +
		<input type="button" value="添加库配置">
		<div></div>
	</div>
 	-->

	<br> 表结构列表:
	<div id="tableListArea">
		<div id="tableListHeadOperation">
			<label id="expand" style="background: #BBB">+ 全部展开</label> <label id="exclose" style="background: #BBB">- 全部收起</label>
		</div>
		<div id="tableListDiv"></div>
	</div>

	<div id="tableCreateArea">
		<br>
		<input type="button" onclick="addTableStructure(this)" value="添加表">
		<input type="button" onclick="submitTableAdd()" value="提交表添加">
		<input type="button" onclick="addTableStructureByModdle()" value="按照模板导入表结构">
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

	<div id="moddle" style="display: none">
		<div name="tableDiv"></div>
	</div>

	<jsp:include page="masking.jsp" />
</body>

<!-- 按照模板导入表结构 -->
<script type="text/javascript">
	function addTableStructureByModdle() {
		showMaskDiv();
	}
</script>

<!-- 表结构展开闭合 -->
<script type="text/javascript">
	function extendCloseTable() {
		$('#expand').click(function() {
			$('#tableListDiv').find('[name=tableDiv]').find('table').show();
		})
		$('#exclose').click(function() {
			$('#tableListDiv').find('[name=tableDiv]').find('table').hide();
		})
	}
</script>
<!-- 表结构展示 -->
<script type="text/javascript">
	function programTables() {
		$.post(webRoot + '/datastructure/programTables', {
			programid : programid
		}, function(data) {
			var code = data.code;
			if (200 != code) {
				var message = data.message;
				alert(message);
				return;
			}

			var tableNodeList = $('#tableListDiv');
			var tableList = data.result;
			for (var i = 0; i < tableList.length; i++) {

				var table = tableList[i];
				var tableid = table.id;
				var tableName = table.tableName;

				var tableDivNode = document.createElement("div");
				$(tableDivNode).attr('name', 'tableDiv');

				var tableMessageNode = document.createElement("div");
				$(tableMessageNode).append('表ID:' + tableid + ', 表名:' + tableName);
				var expandNode = document.createElement("lable");
				var excloseNode = document.createElement("lable");
				var deleteNode = document.createElement("lable");
				$(expandNode).attr('name', 'expand');
				$(excloseNode).attr('name', 'exclose');
				$(expandNode).css('background', '#CCC');
				$(excloseNode).css('background', '#CCC');
				$(deleteNode).css('background', 'red');
				$(expandNode).append('展开');
				$(excloseNode).append('收起');
				$(deleteNode).append('删除');
				$(expandNode).click(function() {
					$(this).parent().parent().find('table').show();
				})
				$(excloseNode).click(function() {
					$(this).parent().parent().find('table').hide();
				})
				$(deleteNode).click(function() {
					var deleteTableUrl = webRoot + '/datastructure/deleteTable'
					$.post(deleteTableUrl, {
						programid : programid,
						tableid : tableid
					}, function(data) {
						var code = data.code;
						if (200 != code) {
							var message = data.message;
							alert(message);
							return;
						}

						$('#tableListDiv').empty();
						init();
					}, 'json')
				})
				$(tableMessageNode).append('&nbsp;');
				$(tableMessageNode).append($(expandNode));
				$(tableMessageNode).append('&nbsp;');
				$(tableMessageNode).append($(excloseNode));
				$(tableMessageNode).append('&nbsp;');
				$(tableMessageNode).append($(deleteNode));
				$(tableDivNode).append(tableMessageNode);

				var tableNode = document.createElement("table");

				var fieldList = table.fieldList;
				for (var j = 0; j < fieldList.length; j++) {

					var trNode = document.createElement("tr");

					var field = fieldList[j];

					var fieldid = field.id;
					var fieldName = field.fieldName;
					var fieldComment = field.fieldComment;
					var fieldType = field.fieldType;
					var fieldLength = field.fieldLength;
					var lengthAfterPoint = field.lengthAfterPoint;
					var createDate = field.createDate;
					var updateDate = field.updateDate;

					var fieldidTdNode = document.createElement("td");
					var fieldNameTdNode = document.createElement("td");
					var fieldCommentTdNode = document.createElement("td");
					var fieldTypeTdNode = document.createElement("td");
					var fieldLengthTdNode = document.createElement("td");
					var lengthAfterPointTdNode = document.createElement("td");
					var createDateTdNode = document.createElement("td");
					var updateDateTdNode = document.createElement("td");

					var fieldidNode = document.createElement("input");
					$(fieldidNode).attr('type', 'checkbox');
					var fieldNameNode = document.createElement("input");
					var fieldCommentNode = document.createElement("input");
					var fieldTypeNode = document.createElement("input");
					var fieldLengthNode = document.createElement("input");
					var lengthAfterPointNode = document.createElement("input");
					var createDateNode = document.createElement("input");
					var updateDateNode = document.createElement("input");

					$(fieldidNode).attr('fieldid', fieldid);
					$(fieldNameNode).val(fieldName);
					$(fieldCommentNode).val(fieldComment);
					$(fieldTypeNode).val(fieldType);
					$(fieldLengthNode).val(fieldLength);
					$(lengthAfterPointNode).val(lengthAfterPoint);
					$(createDateNode).val(createDate);
					$(updateDateNode).val(updateDate);

					$(fieldNameNode).attr('disabled', 'true');
					$(fieldCommentNode).attr('disabled', 'true');
					$(fieldTypeNode).attr('disabled', 'true');
					$(fieldLengthNode).attr('disabled', 'true');
					$(lengthAfterPointNode).attr('disabled', 'true');
					$(createDateNode).attr('disabled', 'true');
					$(updateDateNode).attr('disabled', 'true');

					$(trNode).append($(fieldidNode));
					$(trNode).append($(fieldNameNode));
					$(trNode).append($(fieldCommentNode));
					$(trNode).append($(fieldTypeNode));
					$(trNode).append($(fieldLengthNode));
					$(trNode).append($(lengthAfterPointNode));
					$(trNode).append($(createDateNode));
					$(trNode).append($(updateDateNode));

					$(tableNode).append($(trNode));
					$(tableDivNode).append(tableNode);
				}

				$(tableNodeList).append($(tableDivNode));
			}
		}, 'json')
	}
</script>
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
<script type="text/javascript">
	$(function() {
		init();
	})
	function init() {
		//展示项目表列表
		programTables();
		//启用表结构展开闭合
		extendCloseTable();
	}
</script>
</html>