<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
</head>
<body>
	<div>
		项目ID:
		<input type="text" id="programId" hidden="true" value="${businessDataStructure.programId }">
	</div>

	<!-- 本项目字段列表 -->
	<div id="programAllFields" style="width: 100%; height: 50%;">
		数据字段列表:
		<div id="existFieldsArea">
			<table>
				<thead>
					<tr>
						<td>序号</td>
						<td>字段名</td>
						<td>字段注解</td>
						<td>字段类型</td>
						<td>字段长度</td>
						<td>小数长度</td>
						<td>创建人</td>
						<td>创建时间</td>
						<td>更新人</td>
						<td>更新时间</td>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
		<div id="addFieldsArea"></div>
		<!-- 按钮 -->
		<div>
			<input type="button" onclick="addBaseDataField()" value="添加字段">
			<input type="button" value="保存添加" onclick="saveAddFields()">
		</div>
	</div>

	<br>
	<br>

	<jsp:include page="dragable_businessmaintanance.jsp" />

	<!-- 模板 -->
	<div id="model" style="display: none">
		<div id="addFieldModel" name="field">
			字段名
			<input name="fieldName" type="text">
			字段备注
			<input name="fieldComment" type="text">
			字段类型
			<select name="fieldType">
				<option value="varchar">varchar</option>
				<option value="number">number</option>
				<option value="date">date</option>
			</select>
			字段长度
			<input name="fieldLength" type="text">
			小数长度
			<input name="lengthAfterPoint" type="text">
		</div>
		<table id="programFieldsModel">
			<tr>
				<td nowrap><input type="checkbox" name="fieldid" style></td>
				<td><input name="fieldName" type="text" disabled="true"></td>
				<td><input name="fieldComment" type="text" disabled="true"> <input name="fieldBz" type="text" hidden="true" value="${field.fieldBz }" disabled="true"></td>
				<td><input name="fieldType" type="text" disabled="true"></td>
				<td><input name="fieldLength" type="text" disabled="true"></td>
				<td><input name="lengthAfterPoint" type="text" disabled="true"></td>
				<td><input name="createBy" type="text" disabled="true"></td>
				<td><input name="createDate" type="text" disabled="true"></td>
				<td><input name="updateBy" type="text" disabled="true"></td>
				<td><input name="updateDate" type="text" disabled="true"></td>
			</tr>
		</table>
		<table id="allFieldListModel">
			<tr>
				<td nowrap><input type="checkbox" name="fieldid"></td>
				<td><input name="programName" type="text" disabled="true"> <input name="programId" type="text" hidden="true"></td>
				<td><input name="tableName" type="text" disabled="true"> <input name="tableId" type="text" hidden="true"></td>
				<td><input name="fieldName" type="text" disabled="true"></td>
				<td><input name="fieldComment" type="text" disabled="true"> <input name="fieldBz" type="text" hidden="true" value="${field.fieldBz }" disabled="true"></td>
				<td><input name="fieldType" type="text" disabled="true"></td>
				<td><input name="fieldLength" type="text" disabled="true"></td>
				<td><input name="lengthAfterPoint" type="text" disabled="true"></td>
				<td><input name="createBy" type="text" disabled="true"></td>
				<td><input name="createDate" type="text" disabled="true"></td>
				<td><input name="updateBy" type="text" disabled="true"></td>
				<td><input name="updateDate" type="text" disabled="true"></td>
			</tr>
		</table>
		<div id="fieldsByTableModel">
			<div name="oneTable">
				<label>表名</label> <label name="tableName"></label> <label name="tableId" style="display: none"></label> <label>所属项目</label> <label name="programName"></label> <label name="programId" style="display: none"></label>
				<table>
					<tr>
						<td nowrap><input type="checkbox" name="fieldid"></td>
						<td><input name="fieldName" type="text" disabled="true"></td>
						<td><input name="fieldComment" type="text" disabled="true"> <input name="fieldBz" type="text" hidden="true" value="${field.fieldBz }" disabled="true"></td>
						<td><input name="fieldType" type="text" disabled="true"></td>
						<td><input name="fieldLength" type="text" disabled="true"></td>
						<td><input name="lengthAfterPoint" type="text" disabled="true"></td>
						<td><input name="createBy" type="text" disabled="true"></td>
						<td><input name="createDate" type="text" disabled="true"></td>
						<td><input name="updateBy" type="text" disabled="true"></td>
						<td><input name="updateDate" type="text" disabled="true"></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<jsp:include page="float_businessmaintanance.jsp" />
</body>
<script type="text/javascript">
	function HotKey() {
		var a = window.event.keyCode;
		if (a == 119) {
			var isVisible = $('#dragableDiv').is(':visible');
			if (!isVisible)
				$('#dragableDiv').show();
			else
				$('#dragableDiv').hide();
		}
	}
</script>
<script type="text/javascript">
	$(function() {
		refreshProgramFields();
	})
	function refreshProgramFields() {

		var tbodyNode = $('#existFieldsArea').find('table').find('tbody');
		tbodyNode.empty();

		$.post(webRoot + '/datastructure/programFieldList', {
			programid : programid
		}, function(data) {
			var code = data.code;
			if (200 != code) {
				alert(data.message);
				return;
			}

			var programFieldsModel = programFieldsModel || $('#programFieldsModel').find('tr')[0].outerHTML;
			var fieldList = data.result;
			for (var i = 0; i < fieldList.length; i++) {
				var field = fieldList[i];
				var programFieldsNode = $(programFieldsModel);
				programFieldsNode.removeAttr('id');
				
				var fieldidNode = $(programFieldsNode).find('[name=fieldid]');
				fieldidNode.parent().append(i + 1);
				fieldidNode.attr('fieldid', field.id);
				$(programFieldsNode).find('[name=fieldName]').val(field.fieldName);
				$(programFieldsNode).find('[name=fieldComment]').val(field.fieldComment);
				$(programFieldsNode).find('[name=fieldType]').val(field.fieldType);
				$(programFieldsNode).find('[name=fieldLength]').val(field.fieldLength);
				$(programFieldsNode).find('[name=lengthAfterPoint]').val(field.lengthAfterPoint);
				$(programFieldsNode).find('[name=createBy]').val(field.createBy);
				$(programFieldsNode).find('[name=createDate]').val(field.createDate);
				$(programFieldsNode).find('[name=updateBy]').val(field.updateBy);
				$(programFieldsNode).find('[name=updateDate]').val(field.updateDate);

				$(tbodyNode).append($(programFieldsNode));
			}

		}, 'json')
	}
</script>
<script type="text/javascript">
	// 添加字段
	function addBaseDataField() {
		var addFieldModel = addFieldModel || $('#addFieldModel')[0].outerHTML;
		var addFieldModelNode = $(addFieldModel).removeAttr("id");
		$('#addFieldsArea').append(addFieldModelNode);
	}
	// 保存添加
	function saveAddFields() {
		var fieldList = '[';
		var fieldNodeArr = $('#addFieldsArea').find('[name=field]');
		for (var i = 0; i < fieldNodeArr.length; i++) {
			var fieldNode = fieldNodeArr[i];
			var fieldNameNode = $(fieldNode).find('[name=fieldName]');
			var fieldCommentNode = $(fieldNode).find('[name=fieldComment]');
			var fieldTypeNode = $(fieldNode).find('[name=fieldType]');
			var fieldLengthNode = $(fieldNode).find('[name=fieldLength]');
			var lengthAfterPointNode = $(fieldNode).find('[name=lengthAfterPoint]');

			var fieldName = $(fieldNameNode).val();
			var fieldComment = $(fieldCommentNode).val();
			var fieldType = $(fieldTypeNode).val();//.find("option:selected").text()
			var fieldLength = $(fieldLengthNode).val();
			var lengthAfterPoint = $(lengthAfterPointNode).val();

			fieldList += '{';
			fieldList += '\"fieldName\":\"' + fieldName + "\",";
			fieldList += '\"fieldComment\":\"' + fieldComment + "\",";
			fieldList += '\"fieldType\":\"' + fieldType + "\",";
			fieldList += '\"fieldLength\":' + fieldLength + ",";
			fieldList += '\"lengthAfterPoint\":' + lengthAfterPoint;
			fieldList += '},';
		}

		fieldList = fieldList.slice(0, fieldList.length - 1);
		fieldList += ']';

		alert(programid);
		$.post(webRoot + '/datastructure/addBasinessDataStructure', {
			programid : programid,
			fieldList : fieldList
		}, function(data) {
			var code = data.code;
			if (200 != code) {
				alert(data.message);
				return;
			}
			alert("成功");
			location.reload();
		}, 'json')
	}
</script>
<script type="text/javascript">
	window.onload = function() {
		//启动漂浮窗
		floatWindowInit();
		//启动可拖拽
		dragableInit();
		//启用快捷键
		document.onkeydown = HotKey;
	}
</script>
</html>