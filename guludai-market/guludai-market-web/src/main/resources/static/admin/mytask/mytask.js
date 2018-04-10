var mytask = {
    baseUrl: "/market/web/approveApplyresult",
    entity: "mytask",
    userUrl: "/market/web/user",
    tableId: "userTable",
    toolbarId: "toolbar",
    unique: "id",
    order: "asc",
    customerList:[],
    currentItem: {}
};
mytask.columns = function () {
    return [{
        checkbox: true
    }, {
        field: 'id',
        title: '任务id',
        visible: false
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
        field: 'approveStartTime',
        title: '审批开始时间'
    }, {
        field: 'approveStatus',
        title: '审批状态'
    }, {
        field: 'approveResult',
        title: '审批结果'
    }, {
        field: 'assignUser',
        title: '上一个操作人'
    },{
        field: 'createTime',
        title: '操作日期'
    },{
        field: 'flowNodeResult',
        title: '指派或转交备注'
    },{
        field: 'applyCode',
        title: '申请流水编号',
        visible: false
    }, {
        field: 'activitiCode',
        title: 'activity流程实例id',
        visible: false
    }, {
        field: 'transactUser',
        title: '指派人编号',
        visible: false
    }];
};
mytask.queryParams = function (params) {
	if (!params)
        return {
		id: $("#id").val()
        };
    var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
        limit: params.limit, //页面大小
        offset: params.offset, //页码
        id: $("#id").val()
    };
    var data= {
    		data:temp
	}
    return data;
};

mytask.init = function () {

    mytask.table = $('#' + mytask.tableId).bootstrapTable({
        url: mytask.baseUrl+"/getMyTaskList", //请求后台的URL（*）
        method: 'post', //请求方式（*）
        toolbar: '#' + mytask.toolbarId, //工具按钮用哪个容器
        striped: true, //是否显示行间隔色
        cache: false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true, //是否显示分页（*）
        sortable: false, //是否启用排序
        sortOrder: mytask.order, //排序方式
        queryParams: mytask.queryParams,//传递参数（*）
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
        uniqueId: mytask.unique, //每一行的唯一标识，一般为主键列
        showToggle: true, //是否显示详细视图和列表视图的切换按钮
        cardView: false, //是否显示详细视图
        detailView: false, //是否显示父子表
        columns: mytask.columns()
    });
};
mytask.select = function (layerTips) {
    var rows = mytask.table.bootstrapTable('getSelections');
    if (rows.length == 1) {
        mytask.currentItem = rows[0];
        return true;
    } else {
        layerTips.msg("请选中一行");
        return false;
    }
};

layui.use(['form', 'layedit', 'laydate'], function () {
    mytask.init();
    var editIndex;
    var layerTips = parent.layer === undefined ? layui.layer : parent.layer, //获取父窗口的layer对象
        layer = layui.layer, //获取当前窗口的layer对象
        form = layui.form(),
        layedit = layui.layedit,
        laydate = layui.laydate;
    var addBoxIndex = -1;
    //初始化页面上面的按钮事件
    $('#btn_query').on('click', function () {
        mytask.table.bootstrapTable('refresh', mytask.queryParams());
    });
 
    $('#btn_edit').on('click', function () {
        if (mytask.select(layerTips)) {
            var applyCode = mytask.currentItem.applyCode;
            var id = mytask.currentItem.id;
            var transactUser = mytask.currentItem.transactUser;
            var name = $.trim(mytask.currentItem.name);
            var param = {"applyCode":applyCode,"id":id};
            if(name=='接受申请'){
            	acceptapplicationToDo(layer,layedit,layerTips,param,transactUser);
            }else if(name=='电话回访'){
            	callBackToDo(layer,layedit,layerTips,param,transactUser);
            }else if(name=='贷前审核'){
            	preloanreviewToDo(layer,layedit,layerTips,param,transactUser);
            }else if(name=='上门尽调'){
            	closetothedoorToDao(layer,layedit,layerTips,param,transactUser);
            }else if(name=='材料审批'){
            	materialApprovalDoTo(layer,layedit,layerTips,param,transactUser);
            }else if(name=='双方签约'){
            	bothPartiesSignedAContractToDo(layer,layedit,layerTips,param,transactUser);
            }else if(name=='资金拨款'){
            	fundsAppropriationToDo(layer,layedit,layerTips,param,transactUser);
            }
           
         }
    });
    
    $('#btn_edit2').on('click', function () {
        if (mytask.select(layerTips)) {         
            var applyCode = mytask.currentItem.applyCode;
            var id = mytask.currentItem.id;
            var activitiCode = mytask.currentItem.activitiCode;
            var flowCode = mytask.currentItem.flowCode;
            var transactUser = mytask.currentItem.transactUser;
            $.get(mytask.entity+'/edit2', null, function (form) {
                 layer.open({
                     type: 1,
                     title: '转交任务',
                     content: form,
                     btn: ['确定', '取消'],
                     shade: false,
                     offset: ['20px', '20%'],
                     area: ['800px', '600px'],
                     maxmin: true,
                     yes: function (index) {
                     	layedit.sync(editIndex);
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
                         /**
                          * 初始化管理员下拉选项
                          */
                         transferToThePerson(form);
                         $('[name="id"]').val(id);
                         $('[name="applyCode"]').val(applyCode);
                         $('[name="flowCode"]').val(flowCode);
                         $('[name="activitiCode"]').val(activitiCode);
                         $('[name="transactUser"]').val(transactUser);
                         editIndex = layedit.build('description_editor');
                         form.render();
                         form.on('submit(edit)', function (data) {
                         	 doAjax(mytask.baseUrl+"/edit2", function(data) {
                    				if (data.code==200) {	
                    					layerTips.msg('指派成功');
                                      layerTips.close(index);
                                      location.reload();
                    				}else{
                    					 layerTips.msg(data.message);
                    				} 
                    			}, JSON.stringify({"data":data.field}), "POST");
                            });
                             //这里可以写ajax方法提交表单
                             return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
                         }
                     });
                 });          
         }
    });
 
});
//办理任务人
function initUserInfo(form,id){
	 doAjax("/market/web/approveFlowNode/userList", function(data) {
			if (data.code==200) {	
				var erpList = data.data;
				 var html = "";
				 $.each(erpList,function(index,val){
					 html += "<option value='"+val.userCode+"'>"+val.userName+"</option>";
				 });
				 $('[name=taskActionUserCode]').append(html);
				 form.render(); 
			} 
		}, JSON.stringify({"data":id}), "POST");
}
//转交任务人
function transferToThePerson(form){
	 doAjax(mytask.userUrl, function(data) {
			if (data.code==200) {	
				var erpList = data.data;
				 var html = "";
				 $.each(erpList,function(index,val){
					 html += "<option value='"+val.userCode+"'>"+val.userName+"</option>";
				 });
				 $('[name=taskActionUserCode]').append(html);
				 form.render(); 
			} 
		}, null, "POST");
}

function initComonts(comonts){
	var html = "";
	 $.each(comonts,function(index,val){
		 html += "<tr><td>"+val.userName+"</td><td>"+val.time+"</td><td>"+val.messageParts+"</td></tr>";
	 });
	 $('[id=tbody]').append(html);
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

function acceptapplicationToDo(layer,layedit,layerTips,param,transactUser){
	 doAjax(mytask.baseUrl + '/select', function(data) {
			if (data.code==200) {	
				var result = data.data.result;
				var comonts = data.data.ls2;
				var userList = data.data.ls3;
				$.get(mytask.entity+'/edit', null, function (form) {
                  layer.open({
                      type: 1,
                      title: '申请信息',
                      content: form,
                      btn: ['接受申请', '拒绝申请'],
                      shade: false,
                      offset: ['0px', '0%'],
                      area: ['100%', '100%'],
                      maxmin: true,
                      yes: function (index) {
                      	layedit.sync(editIndex);
	                            $('[name="yesOrNo"]').val('Y');
	                            $('form.layui-form').find('button[lay-filter=edit]').click();
                      },
                      btn2: function(){
                      	 layedit.sync(editIndex);
	                            $('[name="yesOrNo"]').val('N');
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
                          setFromValues(layero, result);
                          editIndex = layedit.build('description_editor');
                          layero.find(":input[name='transactUser']").val(transactUser);
                          /**
                           * 注备
                           */
                          comments(param.applyCode);
                          /**
                           * 初始化管理员下拉选项
                           */
                          initUserInfo(form,param.id);
                          /**
                           * 初始化批注信息
                           */
                         initComonts(comonts);
                         /**
                          * 推荐链路
                          */
                         initUserList(userList);
                          form.render();
                          /**
                           * 流水单信息
                           */
                          initResult(result);
                          tishi(result.intoPieces);
                          form.on('submit(edit)', function (data) {
                          	 doAjax(mytask.baseUrl+"/edit", function(data) {
                     				if (data.code==200) {	
                     					layerTips.msg('接受申请成功');
                                       layerTips.close(index);
                                       location.reload();
                     				}else{
                     					 layerTips.msg(data.message);
                     				} 
                     			}, JSON.stringify({"data":data.field}), "POST");
                             });
                              //这里可以写ajax方法提交表单
                              return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
                          }
                      });
                  });
			  }	  
			},JSON.stringify({"data":param}), "POST");
}
　
/**
 * 电话回访
 * @param layer
 * @param layedit
 * @param layerTips
 * @param param
 * @returns
 */
function callBackToDo(layer,layedit,layerTips,param,transactUser){
	doAjax(mytask.baseUrl + '/select', function(data) {
		if (data.code==200) {	
			var result = data.data.result;
			var comonts = data.data.ls2;
			var userList = data.data.ls3;
			$.get(mytask.entity+'/callBack', null, function (form) {
              layer.open({
                  type: 1,
                  title: '电话回访',
                  content: form,
                  btn: ['接受要请', '拒绝要请'],
                  shade: false,
                  offset: ['0px', '0%'],
                  area: ['100%', '100%'],
                  maxmin: true,
                  yes: function (index) {
                  	layedit.sync(editIndex);
                            $('[name="yesOrNo"]').val('Y');
                            $('form.layui-form').find('button[lay-filter=edit]').click();
                  },
                  btn2: function(){
                  	 layedit.sync(editIndex);
                            $('[name="yesOrNo"]').val('N');
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
                      setFromValues(layero, result);
                      editIndex = layedit.build('description_editor');
                      layero.find(":input[name='transactUser']").val(transactUser);
                      /**
                       * 注备
                       */
                      comments(param.applyCode);
                      /**
                       * 初始化管理员下拉选项
                       */
                      initUserInfo(form,param.id);
                      /**
                       * 初始化批注信息
                       */
                     initComonts(comonts);
                      form.render();
                      /**
                       * 流水单信息
                       */
                      initResult(result);
                      tishi(result.intoPieces);
                      form.on('submit(edit)', function (data) {
                      	 doAjax(mytask.baseUrl+"/edit", function(data) {
                 				if (data.code==200) {	
                 					layerTips.msg('修改成功');
                                   layerTips.close(index);
                                   location.reload();
                 				}else{
                 					 layerTips.msg(data.message);
                 				} 
                 			}, JSON.stringify({"data":data.field}), "POST");
                         });
                          //这里可以写ajax方法提交表单
                          return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
                      }
                  });
              });
		  }	  
		},JSON.stringify({"data":param}), "POST");
	
}
/**
 * 贷前审核
 * @param layer
 * @param layedit
 * @param layerTips
 * @param param
 * @returns
 */
function preloanreviewToDo(layer,layedit,layerTips,param,transactUser){
	doAjax(mytask.baseUrl + '/select', function(data) {
		if (data.code==200) {	
			var result = data.data.result;
			var comonts = data.data.ls2;
			var userList = data.data.ls3;
			$.get(mytask.entity+'/preloanreview', null, function (form) {
              layer.open({
                  type: 1,
                  title: '贷前审核',
                  content: form,
                  btn: ['通过审核', '审核失败'],
                  shade: false,
                  offset: ['0px', '0%'],
                  area: ['100%', '100%'],
                  maxmin: true,
                  yes: function (index) {
                  	layedit.sync(editIndex);
                            $('[name="yesOrNo"]').val('Y');
                            $('form.layui-form').find('button[lay-filter=edit]').click();
                  },
                  btn2: function(){
                  	 layedit.sync(editIndex);
                            $('[name="yesOrNo"]').val('N');
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
                      setFromValues(layero, result);
                      editIndex = layedit.build('description_editor');
                      layero.find(":input[name='transactUser']").val(transactUser);
                      /**
                       * 初始化省份下拉
                       */
                      initAddressInfo(layero,form,result);
                      /**
                       * 注备
                       */
                      comments(param.applyCode);
                      
                      /**
                       * 初始化管理员下拉选项
                       */
                      initUserInfo(form,param.id);
                      /**
                       * 初始化批注信息
                       */
                     initComonts(comonts);
                      /**
                       * 流水单信息
                       */
                      initResult(result);
                      tishi(result.intoPieces);
                      form.on('submit(edit)', function (data) {
                      	 doAjax(mytask.baseUrl+"/edit", function(data) {
                 				if (data.code==200) {	
                 					layerTips.msg('修改成功');
                                   layerTips.close(index);
                                   location.reload();
                 				}else{
                 					 layerTips.msg(data.message);
                 				} 
                 			}, JSON.stringify({"data":data.field}), "POST");
                         });
                          //这里可以写ajax方法提交表单
                          return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
                      }
                  });
              });
		  }	  
		},JSON.stringify({"data":param}), "POST");
	
}

/**
 * 上门尽调
 * @param layer
 * @param layedit
 * @param layerTips
 * @param param
 * @returns
 */
function closetothedoorToDao(layer,layedit,layerTips,param,transactUser){
	doAjax(mytask.baseUrl + '/select', function(data) {
		if (data.code==200) {	
			var result = data.data.result;
			var comonts = data.data.ls2;
			var userList = data.data.ls3;
			$.get(mytask.entity+'/closetothedoor', null, function (form) {
              layer.open({
                  type: 1,
                  title: '上门尽调',
                  content: form,
                  btn: ['通过尽调', '尽调失败'],
                  shade: false,
                  offset: ['0px', '0%'],
                  area: ['100%', '100%'],
                  maxmin: true,
                  yes: function (index) {
                  	layedit.sync(editIndex);
                            $('[name="yesOrNo"]').val('Y');
                            $('form.layui-form').find('button[lay-filter=edit]').click();
                  },
                  btn2: function(){
                  	 layedit.sync(editIndex);
                            $('[name="yesOrNo"]').val('N');
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
                      setFromValues(layero, result);
                      editIndex = layedit.build('description_editor');
                      layero.find(":input[name='transactUser']").val(transactUser);
                      /**
                       * 初始化门店信息
                       */
                      if(result.shopCode){
                    	  initBaseShop(layero,form,result.shopCode);
                      }else{
                    	  initAddressInfo(layero,form,result);
                      }
                     
                      /**
                       * 注备
                       */
                      comments(param.applyCode);
                      /**
                       * 初始化管理员下拉选项
                       */
                      initUserInfo(form,param.id);
                      /**
                       * 初始化批注信息
                       */
                     initComonts(comonts);
                      /**
                       * 流水单信息
                       */
                      initResult(result);
                      tishi(result.intoPieces);
                      form.render();
                      form.on('submit(edit)', function (data) {
                      	 doAjax(mytask.baseUrl+"/edit", function(data) {
                 				if (data.code==200) {	
                 					layerTips.msg('修改成功');
                                   layerTips.close(index);
                                   location.reload();
                 				}else{
                 					 layerTips.msg(data.message);
                 				} 
                 			}, JSON.stringify({"data":data.field}), "POST");
                         });
                          //这里可以写ajax方法提交表单
                          return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
                      }
                  });
              });
		  }	  
		},JSON.stringify({"data":param}), "POST");
	
}

/**
 * 材料审批
 * @param layer
 * @param layedit
 * @param layerTips
 * @param param
 * @returns
 */
function materialApprovalDoTo(layer,layedit,layerTips,param,transactUser){
	doAjax(mytask.baseUrl + '/select', function(data) {
		if (data.code==200) {	
			var result = data.data.result;
			var comonts = data.data.ls2;
			var userList = data.data.ls3;
			$.get(mytask.entity+'/materialapproval', null, function (form) {
              layer.open({
                  type: 1,
                  title: '材料审批',
                  content: form,
                  btn: ['通过审批', '审批失败'],
                  shade: false,
                  offset: ['0px', '0%'],
                  area: ['100%', '100%'],
                  maxmin: true,
                  yes: function (index) {
                  	layedit.sync(editIndex);
                            $('[name="yesOrNo"]').val('Y');
                            $('form.layui-form').find('button[lay-filter=edit]').click();
                  },
                  btn2: function(){
                  	 layedit.sync(editIndex);
                            $('[name="yesOrNo"]').val('N');
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
                      setFromValues(layero, result);
                      editIndex = layedit.build('description_editor');
                      layero.find(":input[name='transactUser']").val(transactUser);
                      /**
                       * 初始化门店信息
                       */
                      initBaseShop(layero,form,result.shopCode);
                      /**
                       * 注备
                       */
                      comments(param.applyCode);
                       
                      /**
                       * 初始化管理员下拉选项
                       */
                      initUserInfo(form,param.id);
                      /**
                       * 初始化批注信息
                       */
                     initComonts(comonts);
                      form.render();
                      /**
                       * 流水单信息
                       */
                      initResult(result);
                     
                      tishi(result.intoPieces);
                      form.on('submit(edit)', function (data) {
                    	  var ls = [];
                    	  var customerIdcards = $('[name="customerIdcard"]');
                    	  var customerNames = $('[name="customerName"]');
                    	  $('[name="customerIdcard"]').each(function(index){
                    		  var model = {
                    				  customerIdcard : '',
                    				  customerName : ''
                    		  };
                    		  model.customerIdcard = $(this).val();
                    		  model.customerName = $(customerNames[index]).val();
                    		  ls.push(model);
                    	  });
                    	  
                    	  var param = {
                    			  id:$('[name="id"]').val(),
                    			  yesOrNo:$('[name="yesOrNo"]').val(),
                    			  activitiCode:$('[name="activitiCode"]').val(),
                    			  flowCode:$('[name="flowCode"]').val(),
                    			  applyCode:$('[name="applyCode"]').val(),
                    			  taskActionUserCode:$('[name="taskActionUserCode"]').val(),
                    			  flowNodeResult:$('[name="flowNodeResult"]').val(),
                    			  companyCode:$('[name="companyCode"]').val(),
                    			  shopCode:$('[name="shopCode"]').val(),
                    			  shopName:$('[name="shopName"]').val(),
                    			  shopAddress:$('[name="shopAddress"]').val(),
                    			  provinceNo:$('[name="provinceNo"]').val(),
                    			  cityNo:$('[name="cityNo"]').val(),
                    			  townNo:$('[name="townNo"]').val(),
                    			  contacts:$('[name="contacts"]').val(),
                    			  phone:$('[name="phone"]').val(),
                    			  transactUser:$('[name="transactUser"]').val(),
                    			  approveApplyCustomerReqs:ls
                    	  };
                    	  
                      	 doAjax(mytask.baseUrl+"/edit", function(data) {
                 				if (data.code==200) {	
                 					layerTips.msg('修改成功');
                                   layerTips.close(index);
                                   location.reload();
                 				}else{
                 					 layerTips.msg(data.message);
                 				} 
                 			}, JSON.stringify({"data":param}), "POST");
                         });
                          //这里可以写ajax方法提交表单
                          return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
                      }
                  });
              });
		  }	  
		},JSON.stringify({"data":param}), "POST");
	
}
 
/**
 * 双方签约
 * @param layer
 * @param layedit
 * @param layerTips
 * @param param
 * @returns
 */
function bothPartiesSignedAContractToDo(layer,layedit,layerTips,param,transactUser){
	doAjax(mytask.baseUrl + '/select', function(data) {
		if (data.code==200) {	
			var result = data.data.result;
			var comonts = data.data.ls2;
			var userList = data.data.ls3;
			$.get(mytask.entity+'/bothpartiessignedacontract', null, function (form) {
              layer.open({
                  type: 1,
                  title: '双方签约',
                  content: form,
                  btn: ['签约完成', '签约失败'],
                  shade: false,
                  offset: ['0px', '0%'],
                  area: ['100%', '100%'],
                  maxmin: true,
                  yes: function (index) {
                  	layedit.sync(editIndex);
                            $('[name="yesOrNo"]').val('Y');
                            $('form.layui-form').find('button[lay-filter=edit]').click();
                  },
                  btn2: function(){
                  	 layedit.sync(editIndex);
                            $('[name="yesOrNo"]').val('N');
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
                      setFromValues(layero, result);
                      editIndex = layedit.build('description_editor');
                      layero.find(":input[name='transactUser']").val(transactUser);
                      /**
                       * 初始化门店信息
                       */
                      initBaseShop(layero,form,result.shopCode);
                      /**
                       * 注备
                       */
                      comments(param.applyCode);
                      
                      /**
                       * 初始化管理员下拉选项
                       */
                      initUserInfo(form,param.id);
                      /**
                       * 初始化批注信息
                       */
                     initComonts(comonts);
                      form.render();
                      /**
                       * 流水单信息
                       */
                      initResult(result);
                     
                      tishi(result.intoPieces);
                      form.on('submit(edit)', function (data) {
                    	  var ls = [];
                    	  var customerIdcards = $('[name="customerIdcard"]');
                    	  var customerNames = $('[name="customerName"]');
                    	  var customerCodes = $('[name="customerCode"]');
                    	  $('[name="customerIdcard"]').each(function(index){
                    		  var model = {
                    				  customerIdcard : '',
                    				  customerName : '',
                    				  customerCode : ''
                    		  };
                    		  model.customerIdcard = $(this).val();
                    		  model.customerName = $(customerNames[index]).val();
                    		  model.customerCode = $(customerCodes[index]).val();
                    		  ls.push(model);
                    	  });
                    	  var param = {
                    			  id:$('[name="id"]').val(),
                    			  yesOrNo:$('[name="yesOrNo"]').val(),
                    			  activitiCode:$('[name="activitiCode"]').val(),
                    			  flowCode:$('[name="flowCode"]').val(),
                    			  applyCode:$('[name="applyCode"]').val(),
                    			  taskActionUserCode:$('[name="taskActionUserCode"]').val(),
                    			  flowNodeResult:$('[name="flowNodeResult"]').val(),
                    			  companyCode:$('[name="companyCode"]').val(),
                    			  shopCode:$('[name="shopCode"]').val(),
                    			  shopName:$('[name="shopName"]').val(),
                    			  shopAddress:$('[name="shopAddress"]').val(),
                    			  provinceNo:$('[name="provinceNo"]').val(),
                    			  cityNo:$('[name="cityNo"]').val(),
                    			  townNo:$('[name="townNo"]').val(),
                    			  contacts:$('[name="contacts"]').val(),
                    			  phone:$('[name="phone"]').val(),
                    			  transactUser:$('[name="transactUser"]').val(),
                    			  approveApplyCustomerReqs:ls
                    	  };
                      	 doAjax(mytask.baseUrl+"/edit", function(data) {
                 				if (data.code==200) {	
                 					layerTips.msg('修改成功');
                                   layerTips.close(index);
                                   location.reload();
                 				}else{
                 					 layerTips.msg(data.message);
                 				} 
                 			}, JSON.stringify({"data":param}), "POST");
                         });
                          //这里可以写ajax方法提交表单
                          return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
                      }
                  });
              });
		  }	  
		},JSON.stringify({"data":param}), "POST");
	
}

/**
 * 资金拨款
 * @param layer
 * @param layedit
 * @param layerTips
 * @param param
 * @returns
 */
function fundsAppropriationToDo(layer,layedit,layerTips,param,transactUser){
	doAjax(mytask.baseUrl + '/select', function(data) {
		if (data.code==200) {	
			var result = data.data.result;
			var comonts = data.data.ls2;
			var userList = data.data.ls3;
			$.get(mytask.entity+'/fundsappropriation', null, function (form) {
              layer.open({
                  type: 1,
                  title: '资金拨款',
                  content: form,
                  btn: ['拨款完成', '拒绝拨款'],
                  shade: false,
                  offset: ['0px', '0%'],
                  area: ['100%', '100%'],
                  maxmin: true,
                  yes: function (index) {
                  	layedit.sync(editIndex);
                  	 		$('[name="yesOrNo"]').val('Y');
                            $('form.layui-form').find('button[lay-filter=edit]').click();
                  },
                  btn2: function(){
                   	 layedit.sync(editIndex);
                             $('[name="yesOrNo"]').val('N');
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
                      setFromValues(layero, result);
                      editIndex = layedit.build('description_editor');
                      layero.find(":input[name='transactUser']").val(transactUser);
                      /**
                       * 注备
                       */
                      comments(param.applyCode);
                      /**
                       * 初始化批注信息
                       */
                     initComonts(comonts);
                      form.render();
                      /**
                       * 流水单信息
                       */
                      initResult(result);
                      tishi(result.intoPieces);
                      form.on('submit(edit)', function (data) {
                      	 doAjax(mytask.baseUrl+"/edit", function(data) {
                 				if (data.code==200) {	
                 					layerTips.msg('修改成功');
                                   layerTips.close(index);
                                   location.reload();
                 				}else{
                 					 layerTips.msg(data.message);
                 				} 
                 			}, JSON.stringify({"data":data.field}), "POST");
                         });
                          //这里可以写ajax方法提交表单
                          return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
                      }
                  });
              });
		  }	  
		},JSON.stringify({"data":param}), "POST");
	
}

//初始化省份下拉
function initAddressInfo(layero,form,result){
	 doAjax("/market/web/province", function(data) {
			if (data.code==200) {	
				var provinceList = data.data;
				
				 var html = "";
				 $.each(provinceList,function(index,val){
					 html += "<option value='"+val.code+"'>"+val.name+"</option>";
				 });
				 $('[name=provinceNo]').append(html);
				
				 if(result.provinceNo){
					 layero.find(":input[name='provinceNo']").val(result.provinceNo); 
				 }
				 if(result.companyCode){
					 initCompanyList(result.companyCode,layero);
				 }else{
					 initCompanyList();
				 }
					 if(result.cityNo){
						 doAjax("/market/web/city", function(data) {
								if (data.code==200) {	
									var cityList = data.data;
									 var html = "";
									 $.each(cityList,function(index,val){
										 html += "<option value='"+val.code+"'>"+val.name+"</option>";
									 });
									 $('[name=cityNo]').empty();
									 $('[name=cityNo]').append(html);
									 layero.find(":input[name='cityNo']").val(result.cityNo);
									 if(result.townNo){
										 doAjax("/market/web/town", function(data) {
												if (data.code==200) {	
													var townList = data.data;
													 var html = "";
													 $.each(townList,function(index,val){
														 html += "<option value='"+val.code+"'>"+val.name+"</option>";
													 });
													$('[name=townNo]').empty();
													 $('[name=townNo]').append(html);
													 layero.find(":input[name='townNo']").val(result.townNo);
												} 
											}, {"data":result.cityNo}, "GET");
									 }
								} 
							}, {"data":result.provinceNo}, "GET");
					 }
					 
			} 
		}, null, "GET");
    
    
    form.on('select(provinceNo)', function(data){
          var provinceNo = data.value;
			  doAjax("/market/web/city", function(data) {
				if (data.code==200) {	
					var cityList = data.data;
					 var html = "";
					 $.each(cityList,function(index,val){
						 html += "<option value='"+val.code+"'>"+val.name+"</option>";
					 });
					$('[name=cityNo]').empty();
					 $('[name=cityNo]').append(html);
					 form.render(); 
				} 
			}, {"data":provinceNo}, "GET");
		});
    
    form.on('select(cityNo)', function(data){
        var cityNo = data.value;
			  doAjax("/market/web/town", function(data) {
				if (data.code==200) {	
					var townList = data.data;
					 var html = "";
					 $.each(townList,function(index,val){
						 html += "<option value='"+val.code+"'>"+val.name+"</option>";
					 });
					$('[name=townNo]').empty();
					 $('[name=townNo]').append(html);
					 form.render(); 
				} 
			}, {"data":cityNo}, "GET");
		});
    
}

function initCompanyList(companyCode,layero){
	 doAjax("/market/web/companyList", function(data) {
			if (data.code==200) {	
				var companyList = data.data;
				 var html = "<option value=''>请选择门店所在公司</option>";
				 $.each(companyList,function(index,val){
					 html += "<option value='"+val.companyCode+"'>"+val.companyName+"</option>";
				 });
				$('[name=companyCode]').empty();
				 $('[name=companyCode]').append(html);
				 if(companyCode){
					 layero.find(":input[name='companyCode']").val(companyCode);
				 }
				 form.render(); 
			} 
		}, null, "GET");
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
	 $('#tbody3').append(html);
}

function initBaseShop(layero,form,shopCode){
	doAjax("/market/web/shop/select", function(data) {
		if (data.code==200) {
			var shop = data.data;
			if(shop){
				$('[name="shopCode"]').val(shop.shopCode);
				$('[name="shopName"]').val(shop.shopName);
				$('[name="contacts"]').val(shop.contacts);
				$('[name="phone"]').val(shop.phone);
				$('[name="shopAddress"]').val(shop.shopAddress);
				$('[name="companyCode"]').val(shop.companyCode);
				$('[name="companyCode"]').val(shop.companyCode);
				initAddressInfo(layero,form,shop);
			}
		}
	}, JSON.stringify({"data":shopCode}), "POST");
}

function tishi(intoPiecesCode){
	 if(intoPiecesCode==400){
    	 $('#errorInfo').css("color","red");
     	 $('#errorInfo').html("流水单在还款期中");
     }else if(intoPiecesCode==500){
    	 
    	 $('#errorInfo').html("已有被拒绝并在90天内");
     }else if(intoPiecesCode==600){
    	 $('#errorInfo').css("color","red");
    	 $('#errorInfo').html("流水单已有审批中的进件");
     }else if(intoPiecesCode==700){
    	 $('#errorInfo').css("color","#A5DF00");
    	 $('#errorInfo').html("流水单已有未审批的进件");
     }else if(intoPiecesCode==200){
    	 $('#errorInfo').css("color","#01DF01");
    	 $('#errorInfo').html("流水单可以正常进件");
     }
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

//添加注备
function addComment(){
	var param = {
			activitiCode:$('[name="activitiCode"]').val(),
			applyCode:$('[name="applyCode"]').val(),
			flowCode:$('[name="flowCode"]').val(),
			comment:$('[name="comment"]').val(),
			id:$('[name="id"]').val()
	};
	doAjax("/market/web/approveApplyCommentResponse/add", function(data) {
		if (data.code==200) {
			layui.use('layer', function(){
				layer = layui.layer; //独立版的layer无需执行这一句
					 layer.open({
					        type: 1
					        ,offset: 'auto' 
					        ,content: '<div style="padding:20px 80px">注备成功！</div>'
					        ,btn: '确定'
					        ,btnAlign: 'c' 
					        ,shade: 0 
					        ,yes: function(){
					          layer.closeAll();
					        }
					});
			});
		} 
	}, JSON.stringify({"data":param}), "POST");
}