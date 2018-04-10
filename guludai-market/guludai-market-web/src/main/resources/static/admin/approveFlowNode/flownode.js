var flownode = {
    baseUrl: "/market/web/approveFlowNode",
    entity: "approveFlowNode",
    tableId: "userTable",
    toolbarId: "toolbar",
    unique: "id",
    order: "asc",
    currentItem: {}
};
flownode.columns = function () {
    return [{
        checkbox: true
    }, {
        field: 'nodeCode',
        title: '进度节点编号',
        visible: false
    }, {
        field: 'nodeName',
        title: '进度节点'
    }, {
        field: 'nodeDescription',
        title: '进度节点描述'
    }];
};
flownode.queryParams = function (params) {
    var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
        limit: params.limit, //页面大小
        offset: params.offset //页码
    };
    var data= {
    		data:temp
	}
    return data;
};

flownode.init = function () {

    flownode.table = $('#' + flownode.tableId).bootstrapTable({
        url: flownode.baseUrl+"/list", //请求后台的URL（*）
        method: 'post', //请求方式（*）
        toolbar: '#' + flownode.toolbarId, //工具按钮用哪个容器
        striped: true, //是否显示行间隔色
        cache: false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true, //是否显示分页（*）
        sortable: false, //是否启用排序
        sortOrder: flownode.order, //排序方式
        queryParams: flownode.queryParams,//传递参数（*）
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
        uniqueId: flownode.unique, //每一行的唯一标识，一般为主键列
        showToggle: true, //是否显示详细视图和列表视图的切换按钮
        cardView: false, //是否显示详细视图
        detailView: false, //是否显示父子表
        columns: flownode.columns()
    });
};
flownode.select = function (layerTips) {
    var rows = flownode.table.bootstrapTable('getSelections');
    if (rows.length == 1) {
        flownode.currentItem = rows[0];
        return true;
    } else {
        layerTips.msg("请选中一行");
        return false;
    }
};

layui.use(['form', 'layedit', 'laydate'], function () {
    flownode.init();
    var layerTips = parent.layer === undefined ? layui.layer : parent.layer, //获取父窗口的layer对象
        layer = layui.layer, //获取当前窗口的layer对象
        form = layui.form(),
        layedit = layui.layedit,
        laydate = layui.laydate;
    var addBoxIndex = -1;
    var editIndex;
    //初始化页面上面的按钮事件
    $('#btn_query').on('click', function () {
        flownode.table.bootstrapTable('refresh', flownode.queryParams());
    });

    //用户设置角色
    $('#btn_edit').on('click', function () {
        if (flownode.select(layerTips)) {
        	  var nodeCode = flownode.currentItem.nodeCode;
        	  doAjax(flownode.baseUrl + '/zTree', function(data) {
        		  if (data.code==200) {	
        			  var result = data.data;
        			  $.get(flownode.entity+'/setting', null, function (form) {
                          layer.open({
                              type: 1,
                              title: '设置用户角色',
                              content: form,
                              btn: ['保存', '取消'],
                              shade: false,
                              offset: ['0px', '0%'],
                              area: ['100%', '100%'],
                              maxmin: true,
                              yes: function (index) {
                                  //触发表单的提交事件
                                  $('form.layui-form').find('button[lay-filter=edit]').click();
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
                                  form.render();
                                  /**
                                   * 初始化ztree
                                   */
                                  initZtree(result);
                                  form.on('submit(edit)', function (data) {
                                 	 var param = {};
                                 	 param.codeStr = allCheckNode();
                                 	 param.nodeCode = nodeCode;
                                  	 doAjax(flownode.baseUrl+"/setting", function(data) {
                             				if (data.code==200) {	
                             					 layerTips.msg('修改成功');
                                               layerTips.close(index);
                                               location.reload();
                             				}else{
                             					 layerTips.msg(data.message);
                             				} 
                             			}, JSON.stringify({"data":param}), "post");
                                     });
                                      //这里可以写ajax方法提交表单
                                      return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
                                  }
                              });
                          });
        		  }
        	  },JSON.stringify({"data":nodeCode}),"post");
         }
    });
});
 
function allCheckNode(){
   var treeObj=$.fn.zTree.getZTreeObj("treeDemo"),
   nodes=treeObj.getCheckedNodes(true),
   v="";
   for(var i=0;i<nodes.length;i++){
    	v+=nodes[i].id + ",";
   }
   return v;
}

//初始zTree
function initZtree(zNodes){
	var setting = {
  			check: {
  				enable: true
  			},
  			data: {
  				simpleData: {
  					enable: true
  				}
  			}
  		};
      $.fn.zTree.init($("#treeDemo"), setting, zNodes);
}