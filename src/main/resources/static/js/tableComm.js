/**
 * tableComm.js
 * 获取表数据相关功能js类
 */

var columnSetting;
var columnData = [];

/**
 * 初始化列信息
 * 
 */
function initColumns() {
	columnSetting = [
		/* 第一列:json数据属性名    第二列:实际画面中显示列名   第三列:列宽 */
		['recid','ID',					'30px'],
		[ 'year' , 'year' , 			'50px'],
		[ 'season' , 'season' , 		'50px'],
		[ 'gdept' , 'gdept' , 			'50px'],
		[ 'business' , 'business' , 	'70px'],
		[ 'itemcode' , 'itemcode' , 	'70px'],
		[ 'item' , 'item' , 			'140px'],
		[ 'samplecode' , 'samplecode' , '100px'],
		[ 'pono' , 'pono' , 			'140px'],
		[ 'powh' , 'powh' , 			'210px'],
		[ 'planetawh' , 'planetawh' , 	'200px'],
		[ 'whdelaydays' , 'whdelaydays' , '100px'],
		[ 'warehouse' , 'warehouse' , 	'100px'],
		[ 'planetawhupdated' , 'planetawhupdated' , '100px'],
		[ 'delayreason' , 'delayreason' , '100px'],
		[ 'needmerchandisingplanningconfirm' , 'needmerchandisingplanningconfirm' , '100px'],
		[ 'impactonbusiness' , 'impactonbusiness' , '100px'],
		[ 'finalanswer_airshiptruck' , 'finalanswer_airshiptruck' , '100px'],
		[ 'finalanswer_bestwhdate' , 'finalanswer_bestwhdate' , '100px'],
		[ 'finalanswer_approvedby' , 'finalanswer_approvedby' , '100px'],
		[ 'poorderqty_pcs' , 'poorderqty_pcs' , 		'100px'],
		[ 'doorderqty_pcs' , 'doorderqty_pcs' , 		'100px'],
		[ 'whreceivedqty_pcs' , 'whreceivedqty_pcs' , 	'100px'],
		[ 'shipmentqty_delaypcs' , 'shipmentqty_delaypcs' , '100px'],
		[ 'dono' , 'dono' , 							'100px'],
		[ 'planexf' , 'planexf' , 						'100px'],
		[ 'actualexf' , 'actualexf' , 					'100px'],
		[ 'transportmethod' , 'transportmethod' , 		'100px'],
		[ 'managementfactory' , 'managementfactory' , 	'100px'],
		[ 'planningsumcode' , 'planningsumcode' , 		'100px'],
		[ 'planningsum' , 'planningsum' , 				'100px'],
		[ 'salesstartdate' , 'salesstartdate' , 		'100px'],
		[ 'salesenddate' , 'salesenddate' , 			'100px'],
		[ 'logisticsdelay' , 'logisticsdelay' , 		'100px'],
		[ 'transactionpattern' , 'transactionpattern' , '100px'],
		[ 'productionsv' , 'productionsv' , 			'100px'],
		[ 'productionleader' , 'productionleader' , 	'100px'],
		[ 'productionplanning' , 'productionplanning' , '100px'],
		[ 'logistics' , 'logistics' , 					'100px'],
		[ 'dc' , 'dc' , 								'100px'],
		[ 'productionplantype' , 'productionplantype' , '100px'],
		[ 'gwhdate' , 'gwhdate' , 						'100px'],
		[ 'gwhdelayflag' , 'gwhdelayflag' , 			'100px'],
		[ 'gwhdelaydays' , 'gwhdelaydays' , 			'100px'],
		[ 'svpicupdateuser' , 'svpicupdateuser' , 		'100px'],
		[ 'svpicupdatetime' , 'svpicupdatetime' , 		'100px'],
		[ 'mdupdateuser' , 'mdupdateuser' , 			'100px'],
		[ 'mdupdatetime' , 'mdupdatetime' , 			'100px'],
		[ 'leaderupdateuser' , 'leaderupdateuser' , 	'100px'],
		[ 'leaderupdatetime' , 'leaderupdatetime' , 	'100px']
	];
	console.log(columnSetting[0][0]);
	
	for (var i=0;i<columnSetting.length;i++) {
		var row = {};
		var setting = columnSetting[i];
		row.field = setting[0];
		row.caption = setting[1];
		row.size = setting[2];
		row.sortable = true;
		row.resizable = true;
		row.editable = {type: 'text'};
		columnData.push(row);
	}
	
}

/**
 * 表数据生成
 * @param data JSON格式的数据信息。
 * @returns
 */
function showTable (data) {
	initColumns();
	$('#grid').w2grid({ 
        name: 'grid', 
        selectType: 'cell',
        show: { 
            toolbar: true,
            footer: true,
            toolbarSave: true
        },
        columns: columnData,
        toolbar: {
            items: [
                { id: 'add', type: 'button', caption: 'Add Record', icon: 'w2ui-icon-plus' }
            ],
            onClick: function (event) {
                if (event.target == 'add') {
                    w2ui.grid.add({ recid: w2ui.grid.records.length + 1 });
                }
            }
        },
        // save按钮点击处理
        onSave: function(event) {
            console.log(event);
            for (var i=0;i< event.changes.length;i++) {
            	event.changes[i].line = event.changes[i].recid;
            	rowDateToTime(event.changes[i]);
            }
            saveTableData(event.changes);
        },
        records: data
    });
}

/**
 * 保存变更行的数据(可多行多列同时更新)
 * @param data 数据变化的行数组
 * @returns
 */
function saveTableData(data) {
	// 因开启了CSRF安全机制，post请求时需带上相关的数据
	var header = $("meta[name='_csrf_header']").attr("content");
	var token = $("meta[name='_csrf_token']").attr('content');
	//alert(header+";"+ token);
	$(document).ajaxSend(function(e,xhr,options){
		xhr.setRequestHeader(header, token);
	});
	
	$.ajax({
		 type : "POST",
        url : "updateTable",
        dataType : 'json',
        data :  JSON.stringify(data),
        contentType: "application/json",
        success : function(data) {
        	console.log(data.result);
        	//数据保存成功后更新画面，为获取他人更改后的信息
        	reloadTableView();
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
        	 alert(XMLHttpRequest.status);
        	 alert(XMLHttpRequest.readyState);
        	 alert(textStatus);
        }
	});
}

/**
 * 重新向后台请求数据并更新画面
 * @returns
 */
function reloadTableView() {
	// 因开启了CSRF安全机制，post请求时需带上相关的数据
	var header = $("meta[name='_csrf_header']").attr("content");
	var token = $("meta[name='_csrf_token']").attr('content');
	$(document).ajaxSend(function(e,xhr,options){
		xhr.setRequestHeader(header, token);
	});
	$.ajax({
		type : "POST",
        url : "getMainTable",
        dataType : 'json',
        contentType: "application/json",
        success : function(data) {
        	//alert(data);
        	// w2ui特性，data中必须要有recid属性，在此将Line的指直接赋给recid
        	for (var i=0;i<data.length; i++) {
        		data[i].recid = data[i].line;
        		rowTimeToDate(data[i]);
        	}
        	w2ui['grid'].records = data;
        	w2ui['grid'].reload();
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
        	 alert(XMLHttpRequest.status);
        	 alert(XMLHttpRequest.readyState);
        	 alert(textStatus);
        }
	});
}

/**
 * 进入页面时加载表视图功能
 * @returns
 */
function loadTableView() {
	// 因开启了CSRF安全机制，post请求时需带上相关的数据
	var header = $("meta[name='_csrf_header']").attr("content");
	var token = $("meta[name='_csrf_token']").attr('content');
	//alert(header+";"+ token);
	$(document).ajaxSend(function(e,xhr,options){
		xhr.setRequestHeader(header, token);
	});
	$.ajax({
		 type : "POST",
        url : "getMainTable",
        dataType : 'json',
        contentType: "application/json",
        success : function(data) {
        	//alert(data);
        	// w2ui特性，data中必须要有recid属性，在此将Line的指直接赋给recid
        	for (var i=0;i<data.length; i++) {
        		data[i].recid = data[i].line;
        		rowTimeToDate(data[i]);
        	}
        	showTable(data);
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
        	 alert(XMLHttpRequest.status);
        	 alert(XMLHttpRequest.readyState);
        	 alert(textStatus);
        }
	});
}

/**
 * 将数据中的timestamp列转换为时间格式
 * @param data 行数据
 * @returns
 */
function rowTimeToDate(data) {
	
	data.powh = parseTime(data.powh);
	data.planetawh = parseTime(data.planetawh);
	data.finalanswer_bestwhdate = parseTime(data.finalanswer_bestwhdate);
	data.planexf = parseTime(data.planexf);
	data.actualexf = parseTime(data.actualexf);
	data.salesstartdate = parseTime(data.salesstartdate);
	data.salesenddate = parseTime(data.salesenddate);
	data.gwhdate = parseTime(data.gwhdate);
	data.svpicupdatetime = parseTime(data.svpicupdatetime);
	data.mdupdatetime = parseTime(data.mdupdatetime);
	data.leaderupdatetime = parseTime(data.leaderupdatetime);
}

function rowDateToTime(data) {
	data.svpicupdatetime = Math.round((new Date(data.svpicupdatetime)).getTime());
}

/**
 * 时间日期格式化功能
 * @param date 日期数据
 * @returns
 */
function formatDate(date) {
	//console.log(date);
    dates = date.split("/");
    if(dates.length == 3) {
        if(dates[1].length == 1) {
            dates[1] = "0" + dates[1];
        }
        if (dates[2].length == 1) {
            dates[2] = "0" + dates[2];
        }
        date = dates.join("-");
        return date;
    } else {
        return null;
    }
}

/**
 * 时间戳格式化为时间日期
 * @param timestamp 时间戳
 * @returns
 */
function parseTime(timestamp) {
    var date = new Date(parseInt(timestamp)).toLocaleDateString();
　　//输出结果为2016/8/9
    date = formatDate(date);
　　//输出结果为2016-08-09，满足YYYY-MM-DD格式要求
    return date;
}

$(document).ready(function(){
    loadTableView();
});