var hisMytask = {
    baseUrl: "/market/web/approveApplyTransact",
    entity: "",
    tableId: "userTable",
    toolbarId: "toolbar",
    unique: "applyCode",
    order: "asc",
    currentItem: {}
};
hisMytask.columns = function () {
	return [{
        checkbox: true
    }, {
        field: 'bossName',
        title: '老板名称'
    }, {
        field: 'shopName',
        title: '门店名称'
    }, {
        field: 'nodeIndex',
        title: '节点顺序号'
    }, {
        field: 'name',
        title: '任务名称'
    }, {
        field: 'assignUser',
        title: '上一个操作人'
    }, {
        field: 'transactUser',
        title: '下一个操作人'
    }, {
        field: 'assignUerDate',
        title: '上一个操作日期'
    }, {
        field: 'approveStartTime',
        title: '自已操作日期'
    }, {
        field: 'flowNodeResult',
        title: '指派或转交备注'
    }, {
        field: 'applyCode',
        title: '申请流水编号',
        visible: false
    }, {
        field: 'activitiCode',
        title: 'activity流程实例id',
        visible: false
    }];
};
hisMytask.queryParams = function (params) {
    var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
        limit: params.limit, //页面大小
        offset: params.offset //页码    
    };
    var data= {
    		data:temp
	}
    return data;
};

hisMytask.init = function () {

    hisMytask.table = $('#' + hisMytask.tableId).bootstrapTable({
        url: hisMytask.baseUrl+"/page", //请求后台的URL（*）
        method: 'post', //请求方式（*）
        toolbar: '#' + hisMytask.toolbarId, //工具按钮用哪个容器
        striped: true, //是否显示行间隔色
        cache: false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true, //是否显示分页（*）
        sortable: false, //是否启用排序
        sortOrder: hisMytask.order, //排序方式
        queryParams: hisMytask.queryParams,//传递参数（*）
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
        uniqueId: hisMytask.unique, //每一行的唯一标识，一般为主键列
        showToggle: true, //是否显示详细视图和列表视图的切换按钮
        cardView: false, //是否显示详细视图
        detailView: false, //是否显示父子表
        columns: hisMytask.columns()
    });
};
hisMytask.select = function (layerTips) {
    var rows = hisMytask.table.bootstrapTable('getSelections');
    if (rows.length == 1) {
        hisMytask.currentItem = rows[0];
        return true;
    } else {
        layerTips.msg("请选中一行");
        return false;
    }
};

layui.use(['form', 'layedit', 'laydate'], function () {
    hisMytask.init();
    var layerTips = parent.layer === undefined ? layui.layer : parent.layer, //获取父窗口的layer对象
        layer = layui.layer, //获取当前窗口的layer对象
        form = layui.form(),
        layedit = layui.layedit,
        laydate = layui.laydate;
 
 
});
 
 