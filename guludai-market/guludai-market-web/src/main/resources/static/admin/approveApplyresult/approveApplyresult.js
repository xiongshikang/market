var approveApplyresult = {
    baseUrl: "/market/web/approveApplyresult",
    entity: "approveApplyresult",
    tableId: "userTable",
    toolbarId: "toolbar",
    unique: "id",
    order: "asc",
    currentItem: {}
};
approveApplyresult.columns = function () {
    return [{
        checkbox: true 
    }, {
        field: 'bossName',
        title: '老板姓名'
    }, {
        field: 'bossWechat',
        title: '老板微信'
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
    }, {
        field: 'activitiCode',
        title: '是否被领取'
    }];
};
approveApplyresult.queryParams = function (params) {
	if (!params)
        return {
		applyCode: $("#applyCode").val()
        };
    var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
        limit: params.limit, //页面大小
        offset: params.offset, //页码
        applyCode: $("#applyCode").val()
    };
    var data= {
    		data:temp
	}
    return data;
};

approveApplyresult.init = function () {

    approveApplyresult.table = $('#' + approveApplyresult.tableId).bootstrapTable({
        url: approveApplyresult.baseUrl, //请求后台的URL（*）
        method: 'post', //请求方式（*）
        toolbar: '#' + approveApplyresult.toolbarId, //工具按钮用哪个容器
        striped: true, //是否显示行间隔色
        cache: false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true, //是否显示分页（*）
        sortable: false, //是否启用排序
        sortOrder: approveApplyresult.order, //排序方式
        queryParams: approveApplyresult.queryParams,//传递参数（*）
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
        uniqueId: approveApplyresult.unique, //每一行的唯一标识，一般为主键列
        showToggle: true, //是否显示详细视图和列表视图的切换按钮
        cardView: false, //是否显示详细视图
        detailView: false, //是否显示父子表
        columns: approveApplyresult.columns()
    });
};
approveApplyresult.select = function (layerTips) {
    var rows = approveApplyresult.table.bootstrapTable('getSelections');
    if (rows.length == 1) {
        approveApplyresult.currentItem = rows[0];
        return true;
    } else {
        layerTips.msg("请选中一行");
        return false;
    }
};

layui.use(['form', 'layedit', 'laydate'], function () {
    approveApplyresult.init();
    var editIndex;
    var layerTips = parent.layer === undefined ? layui.layer : parent.layer, //获取父窗口的layer对象
        layer = layui.layer, //获取当前窗口的layer对象
        form = layui.form(),
        layedit = layui.layedit,
        laydate = layui.laydate;
    var addBoxIndex = -1;
    //初始化页面上面的按钮事件
    $('#btn_query').on('click', function () {
        approveApplyresult.table.bootstrapTable('refresh', approveApplyresult.queryParams());
    });
 
    
    
    $('#btn_edit').on('click', function () {
        if (approveApplyresult.select(layerTips)) {
            var applyCode = approveApplyresult.currentItem.applyCode;
            var activitiCode = approveApplyresult.currentItem.activitiCode;
            var param = {"data":applyCode};
            if(activitiCode.indexOf('已被领取')>0){
            	layerTips.msg("任务已被领取，不可重复领取。");
            }else if(activitiCode.indexOf('未被领取')>0){
            	 doAjax(approveApplyresult.baseUrl+"/receiveTask", function(data) {
     				if (data.code==200) {	
     					layer.open({
     				        type: 1
     				        ,offset: 'auto' 
     				        ,content: '<div style="padding:20px 80px">成功领取任务，请在个人任务管理中查看！</div>'
     				        ,btn: '确定'
     				        ,btnAlign: 'c' 
     				        ,shade: 0 
     				        ,yes: function(){
     				          layer.closeAll();
     				         location.reload();
     				        }
     	            	});
     				}else{
     					 layerTips.msg(data.message);
     				} 
     			}, JSON.stringify(param), "POST");
            }
           
         }
    });
 
});
　