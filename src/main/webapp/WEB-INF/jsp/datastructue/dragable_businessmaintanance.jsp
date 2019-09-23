<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<style type="text/css">
#dragableDiv {
	width: 1000px;
	height: 600px;
	background-color: white;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translateX(-50%) translateY(-50%);
	-moz-transform: translateX(-50%) translateY(-50%);
	-webkit-transform: translateX(-50%) translateY(-50%);
	-ms-transform: translateX(-50%) translateY(-50%);
	border-radius: 5px;
	box-shadow: 3px 3px 10px blue;
	display: none;
	overflow-y: hidden
}

.showTypeHead {
	background-color: #AAA;
}

.showTypeHeadChoosed {
	background-color: #FFF;
}

#allFieldList>table>tbody {
	display: block;
	height: 460px;
	overflow-y: scroll
}

#allFieldList table thead {
	display: table;
	width: 100%;
	height: 40px;
	table-layout: fixed;
	font-size: 16px;
	text-align: left;
	background-color: #99CCFF
}

#tableList div table thead {
	display: table;
	width: 100%;
	height: 40px;
	table-layout: fixed;
	font-size: 16px;
	text-align: left;
	background-color: #99CCFF
}

#allFieldList table thead {
	width: calc(100% - 1em)
}

#tableList div table thead {
	width: calc(100% - 1em)
}
</style>
<div id="dragableDiv">
	<div>
		<span class="showTypeHead" showType="allFieldList">全部字段</span>
		<span class="showTypeHead" showType="fieldsByTable">按表查看字段</span>
	</div>
	<!-- 全部项目字段列表 -->
	<div id="allFieldList" style="display: none">
		数据字段列表:
		<table>
			<thead>
				<tr>
					<td>序号</td>
					<td>所属项目</td>
					<td>所属表</td>
					<td>字段名</td>
					<td>字段注释</td>
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
	<!-- 全部项目字段列表 -->
	<div id="fieldsByTable" style="display: none">
		数据字段列表:
		<div id="tableList"></div>
	</div>

	<input type="button" value="引入选中字段" onclick="importChoosed()">
</div>

<!-- 引入选中字段 -->
<script type="text/javascript">
	function importChoosed() {
		var showType = $('.showTypeHeadChoosed').attr('showType');
		var fieldList = extractFieldFrom(showType);
		
		$.post(webRoot + '/datastructure/importChoosed', {
			programid : programid,
			fieldList : JSON.stringify(fieldList)
		}, function(data) {
			var code = data.code;
			if (200 != code) {
				var message = data.message;
				alert(message);
				return;
			}

			refreshProgramFields();

			cleanFieldsByTable();
			cleanAllFieldList();
			$('.showTypeHead').removeClass('showTypeHeadChoosed');
			$('[showType=thisParam]').click();
		}, 'json')
	}
	function extractFieldFrom(showType) {

		var fieldList = [];

		if ('allFieldList' == showType) {
			$('#allFieldList').find('tbody').find('tr').each(function() {
				var fieldidNode = $(this).find('[name=fieldid]');
				var checked = $(fieldidNode).prop('checked');
				if (!checked)
					return;

				var field = {};
				var fieldid = $(fieldidNode).attr('fieldid');
				//var programName = $(this).find('[name=programName]').val();
				//var fieldName = $(this).find('[name=fieldName]').val();

				field.fieldid = fieldid;

				fieldList.push(field);
			})
		}
		if ('fieldsByTable' == showType) {

			var fieldList = [];
			
			$('#tableList').find('[name=oneTable]').find('table').find('tbody').each(function() {
				$(this).find('tr').each(function(){

					var field = {};
					
					var fieldidNode = $(this).find('[name=fieldid]')
					var fieldid = $(fieldidNode).attr('fieldid');

					field.fieldid = fieldid;
					
					fieldList.push(field);
				})
			});
		}

		return fieldList;
	}
</script>

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
				drag.style.cursor = "move";
				drag.style.left = ev.clientX - disX + "px";
				drag.style.top = ev.clientY - disY + "px";
			};
		};
		drag.onmouseup = function() {
			document.onmousemove = null;
			this.style.cursor = "default";
		};
	}

	function dragableInit() {
		var dragablenode = $("#dragableDiv");
		dragable(dragablenode);
	}
</script>

<!-- 头点击 -->
<script type="text/javascript">
	$('.showTypeHead').click(function() {

		var showType = $(this).attr('showType');

		// 全部字段
		if ('allFieldList' == showType) {
			$.post(webRoot + '/datastructure/allFieldList', {}, function(data) {
				var code = data.code;
				if (200 != code) {
					var message = data.message;
					alert(message);
					return;
				}
				cleanFieldsByTable();
				cleanAllFieldList();

				var allFieldListModel = allFieldListModel || $('#allFieldListModel').find('tbody')[0].innerHTML;

				var fieldList = data.result;
				for (var i = 0; i < fieldList.length; i++) {
					var field = fieldList[i];

					var fieldid = field.id;
					var fieldName = field.fieldName;
					var fieldComment = field.fieldComment;
					var fieldLength = field.fieldLength;
					var fieldType = field.fieldType;
					var lengthAfterPoint = field.lengthAfterPoint;
					var createDate = field.createDate;
					var updateDate = field.updateDate;

					var oneFieldNode = $(allFieldListModel);
					oneFieldNode.find('[name=fieldid]').attr('fieldid', fieldid);
					oneFieldNode.find('[name=fieldid]').parent().append(i + 1);
					//$(allFieldListModel).find('[name=programName]').val(programName);
					//$(allFieldListModel).find('[name=programId]').val(programId);
					//$(allFieldListModel).find('[name=tableName]').val(tableName);
					//$(allFieldListModel).find('[name=tableId]').val(tableId);
					oneFieldNode.find('[name=fieldName]').val(fieldName);
					oneFieldNode.find('[name=fieldComment]').val(fieldComment);
					//$(allFieldListModel).find('[name=fieldBz]').val(fieldBz);
					oneFieldNode.find('[name=fieldType]').val(fieldType);
					oneFieldNode.find('[name=fieldLength]').val(fieldLength);
					oneFieldNode.find('[name=lengthAfterPoint]').val(lengthAfterPoint);
					//$(allFieldListModel).find('[name=createBy]').val(createBy);
					oneFieldNode.find('[name=createDate]').val(createDate);
					//$(allFieldListModel).find('[name=updateBy]').val(updateBy);
					oneFieldNode.find('[name=updateDate]').val(updateDate);

					$('#allFieldList').find('table').find('tbody').append($(oneFieldNode));
				}

				$('#allFieldList').show();
			}, 'json')
		}
		if ('fieldsByTable' == showType) {
			$.post(webRoot + '/datastructure/fieldsByTable', {}, function(data) {
				var code = data.code;
				if (200 != code) {
					var message = data.message;
					alert(message);
					return;
				}

				cleanAllFieldList();
				cleanFieldsByTable();

				var fieldsByTableModel = fieldsByTableModel || $('#fieldsByTableModel').find('[name=oneTable]')[0].outerHTML;
				var fieldModel = $(fieldsByTableModel).find('table').find('tbody')[0].innerHTML;

				var tableList = data.result;
				for (var i = 0; i < tableList.length; i++) {

					var fieldsByTableNode = $(fieldsByTableModel);

					$(fieldsByTableNode).find('table').find('tbody').empty();

					var table = tableList[i];

					var programId = table.programId;
					var programName = table.programName;
					var tableId = table.id;
					var tableName = table.tableName;

					var fieldList = table.fieldList;
					for (var j = 0; j < fieldList.length; j++) {

						var oneFieldNode = $(fieldModel);

						var field = fieldList[j];
						var fieldid = field.id;
						var fieldName = field.fieldName;
						var fieldComment = field.fieldComment;
						var fieldType = field.fieldType;
						var fieldLength = field.fieldLength;
						var lengthAfterPoint = field.lengthAfterPoint;
						var createDate = field.createDate;
						var updateDate = field.updateDate;

						var fieldidNode = $(oneFieldNode).find('[name=fieldid]');
						fieldidNode.parent().append(j + 1);
						fieldidNode.attr('fieldid', fieldid);
						$(oneFieldNode).find('[name=fieldName]').val(fieldName);
						$(oneFieldNode).find('[name=fieldComment]').val(fieldComment);
						//$(oneFieldNode).find('[name=fieldBz]').val(fieldBz);
						$(oneFieldNode).find('[name=fieldType]').val(fieldType);
						$(oneFieldNode).find('[name=fieldLength]').val(fieldLength);
						$(oneFieldNode).find('[name=lengthAfterPoint]').val(lengthAfterPoint);
						//$(oneFieldNode).find('[name=createBy]').val(createBy);
						$(oneFieldNode).find('[name=createDate]').val(createDate);
						//$(oneFieldNode).find('[name=updateBy]').val(updateBy);
						$(oneFieldNode).find('[name=updateDate]').val(updateDate);

						$(fieldsByTableNode).find('tbody').append($(oneFieldNode));

					}

					$('#tableList').append($(fieldsByTableNode));
				}

				$('#fieldsByTable').show();
			}, 'json')
		}

		$('.showTypeHead').removeClass('showTypeHeadChoosed');
		$(this).addClass('showTypeHeadChoosed');
	})

	function cleanAllFieldList() {
		var tbodyNode = $('#allFieldList').find('table').find('tbody');
		$(tbodyNode).empty();
		$('#allFieldList').hide();
	}
	function cleanFieldsByTable() {
		var tableListNode = $('#tableList');
		$(tableListNode).empty();
		$('#fieldsByTable').hide();
	}
</script>