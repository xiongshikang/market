var resultIsNo = {
    baseUrl: "/market/web/resultIsNo",
    entity: "resultIsNo",
    tableId: "userTable",
    toolbarId: "toolbar",
    unique: "id",
    order: "asc",
    currentItem: {}
};
resultIsNo.columns = function () {
    return [{
        checkbox: true
    }, {
        field: 'bossName',
        title: '老板姓名'
    }, {
    	field: 'bossMobile',
        title: '老板电话'
    }, {
        field: 'bossWechat',
        title: '老板微信'
    }, {
        field: 'companyName',
        title: '公司名称'
    }, {
        field: 'shopName',
        title: '门店名称'
    }, {
        field: 'shopAddress',
        title: '门店地址'
    }, {
        field: 'approveStartTime',
        title: '审批开始时间'
    }, {
        field: 'approveEndTime',
        title: '审批结束时间'
    }, {
        field: 'approveStatus',
        title: '审批状态'
    }, {
        field: 'approveResult',
        title: '审批结果'
    }, {
        field: 'applyTime',
        title: '申请时间'
    }, {
        field: 'flowCode',
        title: '流程编号',
        visible: false
    }, {
        field: 'applyCode',
        title: '申请流水编号',
        visible: false
    }];
};


resultIsNo.init = function () {
    resultIsNo.table = $('#' + resultIsNo.tableId).bootstrapTable({
        url: resultIsNo.baseUrl, //请求后台的URL（*）
        method: 'post', //请求方式（*）
        toolbar: '#' + resultIsNo.toolbarId, //工具按钮用哪个容器
        striped: true, //是否显示行间隔色
        cache: false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true, //是否显示分页（*）
        sortable: false, //是否启用排序
        sortOrder: resultIsNo.order, //排序方式
        //queryParams: resultIsNo.queryParams,//传递参数（*）
        sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
        pageNumber: 1, //初始化加载第一页，默认第一页
        pageSize: 10, //每页的记录行数（*）
        pageList: [10, 25, 50, 100], //可供选择的每页的行数（*）
        search: false, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
        strictSearch: false,
        showColumns: false, //是否显示所有的列
        showRefresh: true, //是否显示刷新按钮
        minimumCountColumns: 10, //最少允许的列数
        clickToSelect: true, //是否启用点击选中行
        uniqueId: resultIsNo.unique, //每一行的唯一标识，一般为主键列
        showToggle: true, //是否显示详细视图和列表视图的切换按钮
        cardView: false, //是否显示详细视图
        detailView: false, //是否显示父子表
        columns: resultIsNo.columns(),
        queryParams : function (params) {
            var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                limit: params.limit, //页面大小
                offset: params.offset, //页码
                nodeCode: $('#nodeCode').val()
            };
            var data= {
            		data:temp
        	}
            return data;
        }
    });
};
resultIsNo.select = function (layerTips) {
    var rows = resultIsNo.table.bootstrapTable('getSelections');
    if (rows.length == 1) {
        resultIsNo.currentItem = rows[0];
        return true;
    } else {
        layerTips.msg("请选中一行");
        return false;
    }
};

layui.use(['form', 'layedit', 'laydate'], function () {
    resultIsNo.init();
    var layerTips = parent.layer === undefined ? layui.layer : parent.layer, //获取父窗口的layer对象
        layer = layui.layer, //获取当前窗口的layer对象
        form = layui.form(),
        layedit = layui.layedit,
        laydate = layui.laydate;
    var addBoxIndex = -1;
    //提交申请
    $('#btn_edit1').on('click', function () {
    	$('#nodeCode').val('383207-509664-768001');
        resultIsNo.table.bootstrapTable('refresh');
    });
    //接受申请
    $('#btn_edit2').on('click', function () {
    	$('#nodeCode').val('383207-509664-768002');
        resultIsNo.table.bootstrapTable('refresh');
    });
    //电话回访
    $('#btn_edit3').on('click', function () {
    	$('#nodeCode').val('383207-509664-768003');
        resultIsNo.table.bootstrapTable('refresh');
    });
    //贷前审核
    $('#btn_edit4').on('click', function () {
    	$('#nodeCode').val('383207-509664-768004');
        resultIsNo.table.bootstrapTable('refresh');
    });
    //上门尽调
    $('#btn_edit5').on('click', function () {
    	$('#nodeCode').val('383207-509664-768005');
        resultIsNo.table.bootstrapTable('refresh');
    });
    //材料审批
    $('#btn_edit6').on('click', function () {
    	$('#nodeCode').val('383207-509664-768006');
        resultIsNo.table.bootstrapTable('refresh');
    });
   //双方签约
    $('#btn_edit7').on('click', function () {
    	$('#nodeCode').val('383207-509664-768007');
        resultIsNo.table.bootstrapTable('refresh');
    });
    
    $('#btn_edit').on('click', function () {
        if (resultIsNo.select(layerTips)) {
            var applyCode = resultIsNo.currentItem.applyCode;
            doAjax(resultIsNo.baseUrl + '/nodeList', function(data) {
 				if (data.code==200) {	
 					var result = data.data;
 					var param = {"applyCode":applyCode,"id":null};
 					doAjax('/market/web/approveApplyresult/select', function(data) {
 						if (data.code==200) {	
 							var modelData = data.data.result;
 							var userList = data.data.ls3;
 							/**
 		 					 * 显示处理
 		 					 */
 		 					view(layer,form,result,userList,modelData);
 						  }	  
 						},JSON.stringify({"data":param}), "POST");
 				  } 	  
	 			}, JSON.stringify({"data":{"applyCode":applyCode}}), "post");
         }
    });
 
});


function initData(result){
	var html = "";
	$.each(result,function(index,val){
		if(undefined==val.flowNodeResult){
			val.flowNodeResult = '';
		}
		if(val.flowNodeStatus=="Y"){
			val.flowNodeStatus = "<span style='color:green;'>同意</span>";
		}else if(val.flowNodeStatus=="N"){
			val.flowNodeStatus = "<span style='color:red;'>拒绝</span>";
		}else{
			val.flowNodeStatus = "<span style='color:#BDBDBD;'>审核中</span>";
		}
		if(undefined==val.approveTime){
			val.approveTime = '';
		}
		if(undefined==val.userName){
			val.userName = '';
		}
		html+="<tr><td>"+val.nodeName+"</td><td>"+val.flowNodeStatus+"</td><td>"+val.approveTime+"</td><td>"+val.userName+"</td><td style='color:green;'>"+val.flowNodeResult+"</td></tr>"
	});
	$('#tbody').html(html);
}
 

function view(layer,form,result,userList,modelData){
	$.get(resultIsNo.entity+'/edit', null, function (form) {
         layer.open({
             type: 1,
             title: '节点信息',
             content: form,
             btn: ['关闭'],
             shade: false,
             offset: ['0px', '0%'],
             area: ['100%', '100%'],
             maxmin: true,
             end: function (index) {
                 //触发表单的提交事件
                // $('form.layui-form').find('button[lay-filter=edit]').click();
             },
             full: function (elem) {
                 var win = window.top === window.self ? window : parent.window;
                 $(win).on('resize', function () {
                     var $this = $(this);
                     elem.width($this.width()).height($this.height()).css({
                         top: 0,
                         left: 0
                     });
                     elem.children('div.layui-layer-content').height($this.height() - 95);
                 });
             },
             success: function (layero, index) {
                 var form = layui.form();
                 setFromValues(layero, result);
                 initData(result);
                /**
                 * 推荐链路
                 */
                initUserList(userList);
                initResult(modelData);
                comments(modelData.applyCode);
                 form.render();
                 return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
               }
            });
         });
}

function initUserList(userList){
	var html = "";
	if(userList.length>0){
		 $.each(userList,function(index,val){
			 if(undefined==val.name){
				 val.name = '';
			 }
			 if(undefined==val.email){
				 val.email = '';
			 }
			 if(undefined==val.wechat){
				 val.wechat = '';
			 }
			 if(undefined==val.mobile){
				 val.mobile = '';
			 }
			 html += "<tr><td><img style='width:25px;height:25px;' src='static/images/timg.jpg'></td><td>"+val.name+"</td><td>"+val.email+"</td><td>"+val.wechat+"</td><td>"+val.mobile+"</td></tr>";
		 });
		 $('[id=tbody2]').append(html);
	}else{
		html += "<tr><td colspan=10 style='text-align: center;'>无推荐人</td></tr>";
		$('[id=tbody2]').append(html);
	}
}

function initResult(result){
	var html = "";
		html += "<tr><td>老板姓名</td><td>"+result.bossName+"</td></tr>";
		html += "<tr><td>老板微信</td><td>"+result.bossWechat+"</td></tr>";
		html += "<tr><td>联系电话</td><td>"+result.bossMobile+"</td></tr>";
		html += "<tr><td>门店名称</td><td>"+result.shopName+"</td></tr>";
		html += "<tr><td>门店地址</td><td>"+result.shopAddress+"</td></tr>";
		html += "<tr><td>申请时间</td><td>"+result.applyTime+"</td></tr>";
		html += "<tr><td>审批状态</td><td>"+result.approveStatus+"</td></tr>";
		html += "<tr><td>审批结果</td><td>"+result.approveResult+"</td></tr>";
	 $('[id=tbody3]').append(html);
}

//批注
function comments(applycode){
	doAjax("/market/web/approveApplyCommentResponse/List", function(data) {
		if (data.code==200) {
			var commentsList = data.data;
			var html = "";
			$.each(commentsList,function(index,val){
				html += "<tr><td>"+val.nodeCode+"</td><td>"+val.userCode+"</td><td>"+val.comment+"</td><td>"+val.createTime+"</td></tr>";
			});
		 $('#tbody4').append(html);
		} 
	}, JSON.stringify({"data":applycode}), "POST");
}
