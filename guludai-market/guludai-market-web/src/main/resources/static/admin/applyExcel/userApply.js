
var userApply = {
    baseUrl: "/market/web/applyExcel",
    entity: "applyExcel/edit",
    tableId: "menuTable",
    toolbarId: "toolbar",
    unique: "account",
    order: "asc",
    currentItem: {},
    code:"account",
    parentCode:"parentAccount",
    rootValue: -1,
    explandColumn:1
};
userApply.columns = function () {
    return [
    	 {
            field: 'selectItem',
            radio: true
        },{
            field: 'name',
            title: '登陆名'
        },{
            field: 'mobile',
            title: '用户手机号'
        },{
            field: 'parentDes',
            title: '父节点描述'
        },{
            field: 'childrenDes',
            title: '子节点描述'
        },{
            field: 'applyCount',
            title: '进件数'
        },{
            field: 'dealCount',
            title: '成交数'
        },{
            field: 'refuseCount',
            title: ' 审查中件数'
        },{
            field: 'HaveInHandCount',
            title: '审查中件数'
        },{
            field: 'loanMoneySum',
            title: '审批批款金额'
        },{
            field: 'loanActualMoneySum',
            title: '实际放款金额'
        }];
};
//得到查询的参数
userApply.queryParams = function () {
    var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
    		startTime: $("#startTime").val(),
    		endTime: $("#endTime").val()
    };
  return temp;
};
userApply.init = function () {
    userApply.table = $('#'+userApply.tableId).bootstrapTreeTable({
        id: userApply.unique,// 选取记录返回的值
        code: userApply.code,// 用于设置父子关系
        parentCode: userApply.parentCode,// 用于设置父子关系
        rootCodeValue: userApply.rootValue,
        url: userApply.baseUrl+'/list', //请求后台的URL（*）
        method: 'get', //请求方式（*）
        toolbar: '#'+userApply.toolbarId, //工具按钮用哪个容器
        striped: true, //是否显示行间隔色
        cache: false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        ajaxParams: userApply.queryParams,//传递参数（*）
        expandColumn: userApply.explandColumn,//在哪一列上面显示展开按钮,从0开始
        expandAll:true,
        columns: userApply.columns()
    });
};

userApply.select = function (layerTips) {
    var rows = userApply.table.bootstrapTreeTable('getSelections');
    if (rows.length == 1) {
        userApply.currentItem = rows[0];
        return true;
    } else {
        layerTips.msg("请选中一行");
        return false;
    }
};


layui.use(['form', 'layedit', 'laydate'], function () {
    userApply.init();
    var layerTips = parent.layer === undefined ? layui.layer : parent.layer, //获取父窗口的layer对象
        layer = layui.layer, //获取当前窗口的layer对象
        form = layui.form(),
        layedit = layui.layedit;
//初始化页面上面的按钮事件
    $('#btn_query').on('click',function(){
    	  var start=$("#startTime").val();
    	   var end=$("#endTime").val();
    	 start=start.replace(/-/g,"/");
    	var startdate=new Date(start);
    	 end=end.replace(/-/g,"/");
    	var enddate=new Date(end);
    	var time=enddate.getTime()-startdate.getTime();
    	var days=parseInt(time/(1000 * 60 * 60 * 24));
    	if(days>31){
    		layui.use('layer', function(){
				layer = layui.layer; //独立版的layer无需执行这一句
					 layer.open({
					        type: 1
					        ,offset: 'auto' 
					        ,content: '<div style="padding:20px 80px">必需在一个月内，请重新选择！</div>'
					        ,btn: '确定'
					        ,btnAlign: 'c' 
					        ,shade: 0 
					        ,yes: function(){
					          layer.closeAll();
					        }
					});
			});
    	}else{
    		$(this).css("background-color","#ADADAD");
    		$(this).attr("disabled","disabled");
    		var data = {};
        	data.dataJson = JSON.stringify(userApply.queryParams());
            userApply.table.bootstrapTreeTable('refresh',data);
    		setTimeout(function(){
    			$("#btn_query").css("background-color","#009688");
    			$("#btn_query").removeAttr("disabled");
    		},2000);
    	}
    }) ;
    $('#btn_excel').on('click',function(){
            layer.confirm('确定要导出数据吗？', null, function (index) {
        			var url = "/market/web/salerExport";
        			var filename="销售人员及其销售月报";
        			var timestamp = getNowFormatDate();
        			filename = filename+"_"+timestamp;
        			var startTime = $("#startTime").val();
            		var endTime = $("#endTime").val();
            		if(startTime!='' && endTime!=''){
            			url += "?startTime="+startTime+"&endTime="+endTime;
            		}else if(startTime!=''){
            			url += "?startTime="+startTime;
            		}else if(endTime!=''){
            			url += "?endTime="+endTime;
            		}
        			download(url,filename);
                    layer.close(index);
            });
    }) ;
});

function download(url,filename) {
	showOnloadPage();
	var xhr = new XMLHttpRequest();
	xhr.open('GET', url, true); // 也可以使用POST方式，根据接口
	xhr.open('GET', url, true); // 也可以使用POST方式，根据接口
	xhr.responseType = "blob"; // 返回类型blob
	// 定义请求完成的处理函数，请求前也可以增加加载框/禁用下载按钮逻辑
	xhr.onload = function() {
		// 请求完成
		if (this.status === 200) {
			var blob = this.response;
			var reader = new FileReader();
			reader.readAsDataURL(blob);
			reader.onload = function(e) {
				var a = document.createElement('a');
				a.download = filename+'.xlsx';
				a.href = e.target.result;
				$("body").append(a);
				a.click();
				$(a).remove();
				closeOnloadPage();
			}
		}
	};
	// 发送ajax请求
	xhr.send();
}

function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
            + " " + date.getHours() + seperator2 + date.getMinutes()
            + seperator2 + date.getSeconds();
    return currentdate;
}
 
 
