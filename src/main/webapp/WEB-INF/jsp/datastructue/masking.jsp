<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<style type="text/css">
#maskDiv {
	position: absolute;
	top: 0;
	left: 0;
	background-color: rgba(9, 9, 9, 0.63);
	width: 100%;
	height: 100%;
	z-index: 1000;
	display: none;
}

#maskOperationDiv {
	width: 50%;
	text-align: center;
	background: #ffffff;
	border-radius: 6px;
	margin: 100px auto;
	line-height: 30px;
	z-index: 10001;
}

#maskOperationDiv input {
	width: 100%;
	height: 40px;
	border-radius: 6px;
	margin: 3px auto;
}

#uploadDiv {
	
}

#uploadDiv input[type=file] {
	display: none;
}
</style>


<div id="maskDiv">
	<div id="maskOperationDiv">
		<input type="button" onclick="downloadModdle()" value="下载模板">
		<br>
		<div id='uploadDiv'>
			<input type="button" onclick="importDataStructure(this)" value="选择表结构文档">
			<input type="button" onclick="submitDataStructure(this)" value="提交表结构">
			<input type="file" name="file" value="导入表结构文档">
		</div>
		<input type="button" onclick="hideMaskDiv()" value="关闭蒙版">
	</div>
</div>

<script type="text/javascript" src="/static/js/jquery.download.js"></script>
<!-- 导入表结构文档 -->
<script type="text/javascript">
	function submitDataStructure(clickButton) {
		var url = webRoot + '/datastructure/submitDataStructure';
		$.ajaxUpload(url, $('[type=file]'), {
			programid : programid
		}, function(data) {
			var code = data.code;
			if(200 == code){
				alert('成功');
			}else{
				console.log(JSON.stringify(data))
				alert(data.message);
			}
		}, function(data) {
			console.log(JSON.stringify(data))
			alert('请求失败');
		});
	}
	function importDataStructure(clickButton) {
		$(clickButton).parent().find('[type=file]').click();
	}
</script>

<!-- 下载模板 -->
<script type="text/javascript">
	function downloadModdle() {
		var url = webRoot + '/datastructure/downloadModdle';
		$.download(url, {
			dbType : 'mysql',
			moddleName : 'tableStructrueModdle'
		});
	}
</script>

<!-- 模板展示隐藏 -->
<script type="text/javascript">
	function showMaskDiv() {
		$('#maskDiv').show();
	}
	function hideMaskDiv() {
		$('#maskDiv').hide();
	}
</script>