$.download = function(url, data) {
	if (url && data) {
		var form = $('<form></form>');
		form.attr('action', url + "?rand=" + Math.random());
		form.attr('method', 'post');
		for ( var item in data) {
			console.log(item);
			console.log(item);
			var input = $('<input type="text" />');
			input.attr('name', item);
			input.attr('value', data[item]);
			form.append(input);
		}
		form.appendTo('body').submit().remove();
	}
}

$.ajaxUpload = function(url, fileNode, otherdata, successcallback, failcallback) {

	var file = $(fileNode)[0].files[0];
	var formData = new FormData();
	formData.append("file", file);
	for ( var item in otherdata) {
		// var input = $('<input type="text" />');
		// input.attr('name', item);
		// input.attr('value', otherdata[item]);
		// formData.append(input);
		formData.append(item, otherdata[item]);
	}

	$.ajax({
		url : url,
		dataType : 'json',
		type : 'POST',
		async : false,
		data : formData,
		processData : false, // 使数据不做处理
		contentType : false, // 不要设置Content-Type请求头
		success : function(data) {
			successcallback(data);
		},
		error : function(data) {
			failcallback(data);
		}
	});
}