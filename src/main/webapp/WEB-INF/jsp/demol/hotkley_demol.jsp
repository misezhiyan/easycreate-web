
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
	$.ready(function(){
		//启用快捷键
		document.onkeydown = HotKey;
	})
</script>