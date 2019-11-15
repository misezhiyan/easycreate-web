// 在操作区域中展示
function showInOpreateArea(areaName, showNode) {
	var areaNode = $('#operateArea').find('div').find('[name=' + areaName + ']');
	$(areaNode).append($(showNode));
}
// 单区域全清理
function cleanOpreateArea(areaName) {
	var areaNode = $('#operateArea').find('div').find('[name=' + areaName + ']');
	$(areaNode).empty();
}
// 全区域清理
function cleanAllOpreateArea() {
	cleanOpreateArea('opt1');
	cleanOpreateArea('opt2');
	cleanOpreateArea('opt3');
}

// 区域添加
function opreateAreaAppend(areaNameAppendTo, areaNameAppend) {
	var areaNodeAppendTo = $('#operateArea').find('div').find('[name=' + areaNameAppendTo + ']');
	$(areaNodeAppendTo).append(areaNameAppend);
}
// 转区域
function changeOpreateArea(areaNameFrom, areaNameTo) {
	var areaNodeFrom = $('#operateArea').find('div').find('[name=' + areaNameFrom + ']');
	var areaNodeTo = $('#operateArea').find('div').find('[name=' + areaNameTo + ']');

	var childrenNodes = $(areaNodeFrom).children();
	cleanOpreateArea(areaName);
	$(areaNodeTo).append(childrenNodes);
}
// 查看节点所在操作区域
function getOptAreaName(node) {
	var opt1AreaNode = $('[name=opt1]');
	var opt2AreaNode = $('[name=opt2]');
	var opt3AreaNode = $('[name=opt3]');
	var nodeExist1 = $(opt1AreaNode).find($(node));
	var nodeExist2 = $(opt2AreaNode).find($(node));
	var nodeExist3 = $(opt3AreaNode).find($(node));

	var nodeExist;
	if (nodeExist1[0])
		nodeExist = 'opt1';
	else if (nodeExist2[0])
		nodeExist = 'opt2';
	else if (nodeExist3[0])
		nodeExist = 'opt3';

	return nodeExist;
}
// 查看节点下一个操作区域
function getNextOptAreaName(optAreaName) {

	if ('opt1' == optAreaName)
		return 'opt2';
	else if ('opt2' == optAreaName)
		return 'opt3';
	else if ('opt3' == optAreaName)
		return '';
}

// 页面逻辑维护
function pageLogicMaintanance() {
	alert(1);
}
// 后台逻辑维护
function javaLogicMaintanance() {
	cleanAllOpreateArea();
	var opt1Node = $('[name=opt1]');
	// 头
	var opt1HeadNode = createOpt1Head('opt1');
	$(opt1HeadNode).find('[name=optObj]').click(function() {
		var optObj = $(this).val();
		// 列表
		var optObjList = getOptObjList(optObj);
		var optListNode = matchOptListNode(optObj, optObjList);
		$(opt1Node).append($(optListNode));
		// 创建区
		var createNode = getCreateNode(optObj);
		$(opt1Node).append($(createNode));

		$(opt1HeadNode).hide();
	});

	$(opt1Node).append(opt1HeadNode);
}
function createOpt1Head(headType) {
	if (headType == 'opt1') {
		var opt1HeadModle = opt1HeadModle || $('[name=opt1HeadModle]')[0].innerHTML;
		var opt1HeadNode = $(opt1HeadModle);
		return opt1HeadNode;
	}
}
// 隐藏操作头
function hideHead(button) {
	$(button).parent().hide();
}

// 展示操作对象列表
function getOptObjList(optObj) {

	var optObjListUrl = webRoot;
	if (optObj == 'snapshort')
		optObjListUrl += '/snapshort/snapshortList';
	else if (optObj == 'interface')
		optObjListUrl += '/interface/interfaceList';

	var list;
	$.ajaxSettings.async = false;
	$.post(optObjListUrl, {
		businessLineId : businessLineId
	}, function(data) {
		var code = data.code;
		if (200 == code) {
			list = data.result;
		} else {
			alert(data.message);
		}
	}, 'json');
	$.ajaxSettings.async = true;

	return list;
}
function matchOptListNode(optObj, list) {

	var listTableModle = listTableModle || $('[name=listTableModle]')[0].innerHTML;
	var listBodyNode = $(listTableModle);

	if (optObj == 'snapshort') {

		var snapshortModle = snapshortModle || $('#modle').find('[name=javaLogicModle]').find('[name=snapshortModle]').find('[name=snapshortListTable]').find('tbody')[0].innerHTML;

		for (var i = 0; i < list.length; i++) {
			var snapShort = list[i];

			var snapShortId = snapShort.id;
			var snapShortName = snapShort.snapShortName;
			var snapType = snapShort.snapType;
			var createDate = snapShort.createDate;

			var snapshortModle = $(snapshortModle);

			$(snapshortModle).find('[name=snapShortId]').val(snapShortId);
			$(snapshortModle).find('[name=snapShortName]').val(snapShortName);
			$(snapshortModle).find('[name=snapType]').val(snapType);
			$(snapshortModle).find('[name=createDate]').val(createDate);
			$(snapshortModle).find('[name=refInterfaceButton]').click(function() {
				var thisSnapShortId = $(this).parent().parent().prev().find('[name=snapShortId]').val();
				var optAreaName = getOptAreaName(this);
				var nextOptAreaName = getNextOptAreaName(optAreaName);

				var interfaceList = getInterfaceListBySnapShortId(thisSnapShortId);
				var interfaceListNode = matchInterfaceListNode(thisSnapShortId, interfaceList);

				cleanOpreateArea(nextOptAreaName);
				opreateAreaAppend(nextOptAreaName, interfaceListNode);
			})

			$(snapshortModle).each(function() {
				if (undefined != $(this).attr('snapShortId')) {
					$(this).attr("snapShortId", snapShortId);
				}
			})
			$(snapshortModle).find('[snapShortId]').attr("snapShortId", snapShortId);
			$(listBodyNode).append($(snapshortModle));
		}

		operateObj.opt1.obj = 'snapshort';

	} else if (optObj == 'interface') {

		var interfaceModle = interfaceModle || $('#modle').find('[name=javaLogicModle]').find('[name=interfaceModle]').find('[name=interfaceListTable]').find('tbody')[0].innerHTML;
		for (var i = 0; i < list.length; i++) {

			var interfaceI = list[i];

			var createDate = interfaceI.createDate;
			var interfaceId = interfaceI.id;
			var interfaceName = interfaceI.interfaceName;

			var interfaceNode = $(interfaceModle);

			$(interfaceNode).find('[name=interfaceId]').val(interfaceId);
			$(interfaceNode).find('[name=interfaceName]').val(interfaceName);
			$(interfaceNode).find('[name=createDate]').val(createDate);

			$(listBodyNode).append($(interfaceNode));
		}

		operateObj.opt1.obj = 'interface';

	}

	return listBodyNode;
}

// 接口列表
function getInterfaceListBySnapShortId(snapShortId) {

	var interfaceListUrl = webRoot + '/interface/interfaceListBySnapshortid';

	$.ajaxSettings.async = false;
	$.post(interfaceListUrl, {
		snapShortId : snapShortId
	}, function(data) {
		var code = data.code;
		if (200 == code) {
			return data.result;
		} else {
			alert(data.message);
		}
	}, 'json')
	$.ajaxSettings.async = true;
}
function matchInterfaceListNode(snapShortId, interfaceList) {

	var matchInterfaceListNode = document.createElement('div');
	// 操作快照
	var optSnapshortidModel = optSnapshortidModel || $('[name=optSnapshortidModel]')[0].innerHTML;
	var optSnapshortidNode = $(optSnapshortidModel);

	$(matchInterfaceListNode).append($(optSnapshortidNode));
	$(matchInterfaceListNode).find('[name=optId]').val(snapShortId);

	if (interfaceList) {
		for (var i = 0; i < interfaceList.length; i++) {
			var interfaceI = interfaceList[i];
		}
	} else {

	}

	// 关联新接口
	var refNewIntefaceModel = refNewIntefaceModel || $('[name=interfaceModle]').find('[name=refNewIntefaceModel]')[0].innerHTML;
	var refNewIntefaceNode = $(refNewIntefaceModel);

	$(matchInterfaceListNode).append($(refNewIntefaceNode));

	operateObj.opt2.obj = 'interface';

	return matchInterfaceListNode;
}

// 获取创建区
function getCreateNode(optObj) {
	if ('snapshort' == optObj) {
		var snapshortModle = snapshortModle || $('[name=snapshortModle]').find('[name=createSnapshort]')[0].outerHTML;
		var snapshortNode = $(snapshortModle);
		return snapshortNode;
	} else if (optObj == 'interface') {
		var interfaceModle = interfaceModle || $('[name=interfaceModle]').find('[name=createInterface]')[0].outerHTML;
		var interfaceNode = $(interfaceModle);
		return interfaceNode;
	}
}

// 展示创建入照区域
function showCreateSnapshortArea(button) {
	var snapshortAddDiv = $(button).parent().find('[name=snapshortAddDiv]');
	$(snapshortAddDiv).show();
}
// 展示创建接口区域
function showInterfaceArea(button) {
	var interfaceAddDiv = $(button).parent().find('[name=interfaceAddDiv]');
	$(interfaceAddDiv).show();
}

// 展示入照行操作区
function showSnapshortOperateArea(button) {
	var snapShortOperateArea = $(button).parent().parent().next();
	var visible = snapShortOperateArea.is(':visible');
	if (visible)
		$(snapShortOperateArea).hide();
	else
		$(snapShortOperateArea).show();
}
// 展示接口行操作区
function showInterfaceOperateArea(button) {
	var interfaceOperateArea = $(button).parent().parent().next();
	var visible = interfaceOperateArea.is(':visible');
	if (visible)
		$(interfaceOperateArea).hide();
	else
		$(interfaceOperateArea).show();
}

// 展示可关联接口
function showInterfaceToRef(button, type) {
	var snapshortid = $(button).parent().parent().find('[name=optId]').val();
	var interfaceList = getOptObjList('interface');
	var refNewIntefaceListAreaNode = matchRefNewIntefaceListAreaNode(interfaceList);
	opreateAreaAppend('opt3', $(refNewIntefaceListAreaNode));
}
function matchRefNewIntefaceListAreaNode(interfaceList) {

	var refNewIntefaceListAreaModel = refNewIntefaceListAreaModel || $('[name=refNewIntefaceListAreaModel]').find('table')[0].outerHTML;

	var refNewIntefaceListAreaNode = $(refNewIntefaceListAreaModel);
	var refNewIntefaceListAreaTheadNode = $(refNewIntefaceListAreaNode).find('thead');
	var refNewIntefaceListAreaTbodyNode = $(refNewIntefaceListAreaNode).find('tbody');

	var refNewIntefaceListAreaRowModel = $(refNewIntefaceListAreaTbodyNode).find('tr')[0].outerHTML;
	$(refNewIntefaceListAreaTbodyNode).empty();
	for (var i = 0; i < interfaceList.length; i++) {
		var interfaceI = interfaceList[i];
		var interfaceId = interfaceI.id;
		var interfaceName = interfaceI.interfaceName;
		var createDate = interfaceI.createDate;

		var refNewIntefaceListAreaRowNode = $(refNewIntefaceListAreaRowModel);

		$(refNewIntefaceListAreaRowNode).find('[name=interfaceId]').val(interfaceId);
		$(refNewIntefaceListAreaRowNode).find('[name=interfaceName]').val(interfaceName);
		$(refNewIntefaceListAreaRowNode).find('[name=createDate]').val(createDate);

		var interfaceIdRefRadio = $(refNewIntefaceListAreaRowNode).find('[name=interfaceIdRef]');
		$(interfaceIdRefRadio).val(interfaceId);
		// $(interfaceIdRefRadio).onclick(function() {
		// alert($(this).val());
		// })

		$(refNewIntefaceListAreaTbodyNode).append($(refNewIntefaceListAreaRowNode));
	}

	return refNewIntefaceListAreaNode;
}

// 创建入照
function addSnapshort() {
	var snapshortName = $('[name=snapshortAddDiv]').find('[name=snapshortName]').val();
	var addSnapshortUrl = webRoot + "/snapshort/addSnapshort";
	$.post(addSnapshortUrl, {
		businessLineId : businessLineId,
		snapshortName : snapshortName
	}, function(data) {
		var code = data.code;
		if (200 == code) {
			$('[name=optObj]').find('[value=snapshort]').click();
		} else {
			alert(data.message);
		}
	}, 'json');
}
// 创建接口
function addInterface() {
	var interfaceName = $('[name=interfaceAddDiv]').find('[name=interfaceName]').val();
	var addInterfaceUrl = webRoot + "/interface/addInterface";
	$.post(addInterfaceUrl, {
		businessLineId : businessLineId,
		interfaceName : interfaceName
	}, function(data) {
		var code = data.code;
		if (200 == code) {
			$('[name=optObj]').find('[value=interface]').click();
		} else {
			alert(data.message);
		}
	}, 'json');
}
// 快照关联接口
function snapsortRefInterface() {
	var snapshortId = $('[name=optId]').val();
	var interfaceIdList = [];
	$('#snapshortRefInterfaceTable').find('[name=interfaceIdRef]').each(function() {
		var checked = $(this).is(':checked');
		if (checked) {
			interfaceIdList.push($(this).val());
		}
	})
	console.log(interfaceIdList);
	var snapsortRefInterfaceUrl = webRoot + "/snapshort/snapsortRefInterface";
	$.post(snapsortRefInterfaceUrl, {
		snapshortId : snapshortId,
		interfaceIdListStr : JSON.stringify(interfaceIdList),
		interfaceIdList : interfaceIdList
	}, function(data) {
		var code = data.code;
		if (200 == code) {
			// $('[name=optObj]').find('[value=interface]').click();
		} else {
			// alert(data.message);
		}
	}, 'json');
}