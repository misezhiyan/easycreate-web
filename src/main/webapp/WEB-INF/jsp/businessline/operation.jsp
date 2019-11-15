<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PROGRAM MAINTANANCE PAGE</title>
<jsp:include page="../base/base.jsp" />
<script type="text/javascript" src="/static/js/jquery.3.3.1.min.js"></script>
<script type="text/javascript" src="/static/js/businessline/businesslineOperateParam.js"></script>
<script type="text/javascript" src="/static/js/businessline/businesslineOperatePage.js"></script>
<script type="text/javascript">
	//var businessLineId = ${businessLineId};
	var businessLineId = ${businessLineId};
</script>
<style type="text/css">
</style>
</head>
<body>
	<br>
	<div>维护业务线: ${businessLineId}</div>
	<br>
	<input type="button" onclick="pageLogicMaintanance()" value="页面逻辑维护">
	<input type="button" onclick="javaLogicMaintanance()" value="后台逻辑维护">
	<br>
	<br>

	<div id="operateArea" style="display: block; width: 100%; border: line; height: 600px; position: relative;">
		<div>
			<div name="opt1" style="height: 100%; width: 30%; border: 1px double #000; float: left; position: absolute; overflow: auto; background: #FFF;"></div>
			<div name="opt2" style="height: 100%; width: 40%; border: 1px double #000; margin-left: 30%; position: absolute; overflow: auto;"></div>
			<div name="opt3" style="height: 100%; width: 30%; border: 1px double #000; margin-left: 70%; float: right; position: absolute; overflow: auto;"></div>
		</div>
	</div>

	<div id="modle" style="display: none">
		<div name="javaLogicModle">
			<div name="opt1HeadModle">
				<div style="background: #CCC; height: 5%; width: 100%">
					抬头区--操作对象 <br>
					<input type="radio" value="snapshort" name="optObj">
					快照维护
					<input type="radio" value="interface" name="optObj">
					接口维护
				</div>
			</div>
			<div name="listTableModle">
				<table>
					<tbody></tbody>
				</table>
			</div>
			<div name="snapshortModle">
				<div name="optModle">
					<div name="createSnapshort">
						<br> <br> <br>
						<a href="javascript:void(0)" onclick="showCreateSnapshortArea(this)">创建快照</a>
						<div name="snapshortAddDiv" style="display: none">
							快照名称:
							<input name="snapshortName" type="text">
							<input type="button" onclick="addSnapshort()" value="创建快照">
						</div>
					</div>
				</div>
				<table name='snapshortListTable'>
					<tbody>
						<tr>
							<td><input name="snapShortId" type="hidden"> <a href="javascript:void(0)" onclick="showSnapshortOperateArea(this)">↓↑</a></td>
							<td><input name="snapShortName" type="text" disabled="disabled"></td>
							<td><input name="snapType" type="text" disabled="disabled"></td>
							<td><input name="createDate" type="text" disabled="disabled"></td>
						</tr>
						<tr style="display: none" snapShortId>
							<td></td>
							<td><a href="javascript:void(0)">维护快照字段</a></td>
							<td><a href="javascript:void(0)" name="refInterfaceButton">查看关联接口</a></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div name="interfaceModle">
				<div name="optModle">
					<div name="createInterface">
						<br> <br> <br>
						<a href="javascript:void(0)" onclick="showInterfaceArea(this)">创建接口</a>
						<div name="interfaceAddDiv" style="display: none">
							接口名称:
							<input name="interfaceName" type="text">
							<input type="button" onclick="addInterface()" value="创建接口">
						</div>
					</div>
				</div>
				<table name='interfaceListTable'>
					<tbody>
						<tr>
							<td><input name="interfaceId" type="hidden"> <a href="javascript:void(0)" onclick="showInterfaceOperateArea(this)">↓↑</a></td>
							<td><input name="interfaceName" type="text" disabled="disabled"></td>
							<td><input name="createDate" type="text" disabled="disabled"></td>
						</tr>
						<tr style="display: none">
							<td></td>
							<td><a href="javascript:void(0)" name="refedSnapshortOptButton">查看已关联快照</a></td>
							<td><a href="javascript:void(0)" name="refSnapshortOptButton">关联快照</a></td>
						</tr>
					</tbody>
				</table>
				<div name='refInterfaceOptModel'>
					<div name="optSnapshortidModel">
						<div>
							<br> 操作快照ID:
							<input name="optId" type="text" disabled="disabled">
							<br>
						</div>
					</div>
					<div name="refNewIntefaceModel">
						<div>
							<br>
							<a href="javascript:void(0)" onclick="showInterfaceToRef(this)">关联新接口</a>
							<br>
						</div>
					</div>
					<div name="refNewIntefaceListAreaModel">
						<table id="snapshortRefInterfaceTable">
							<thead>
								<tr>
									<th></th>
									<th>接口ID</th>
									<th>接口名称</th>
									<th>接口创建日期</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input type="checkbox" name="interfaceIdRef"></td>
									<td><input type="text" name="interfaceId" disabled="disabled"></td>
									<td><input type="text" name="interfaceName" disabled="disabled"></td>
									<td><input type="text" name="createDate" disabled="disabled"></td>
								</tr>
							</tbody>
							<tfoot>
								<tr>
									<td colspan="4"><input type="button" value="提交关联" onclick="snapsortRefInterface()"></td>
								</tr>
							</tfoot>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>