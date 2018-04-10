var user = {
    baseUrl: "/market/web/user",
    entity: "user",
    tableId: "userTable",
    toolbarId: "toolbar",
    unique: "id",
    order: "asc",
    currentItem: {}
};
user.columns = function () {
    return [{
        checkbox: true
    }, {
        field: 'userCode',
        title: '用户编号',
        visible: false
    }, {
        field: 'userName',
        title: '用户姓名'
    }, {
        field: 'password',
        title: '用户密码'
    }, {
        field: 'email',
        title: '邮箱'
    }, {
        field: 'sex',
        title: '性别',
        formatter:sexFn
    }, {
        field: 'phone',
        title: '联系电话'
    }, {
        field: 'address',
        title: '联系地址'
    }, {
        field: 'createTime',
        title: '创建时间'
    }, {
        field: 'updateTime',
        title: '修改时间'
    }];
};
user.queryParams = function (params) {
	if (!params)
        return {
		userName: $("#userName").val()
        };
    var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
        limit: params.limit, //页面大小
        offset: params.offset, //页码
        userName: $("#userName").val()
    };
    var data= {
    		data:temp
	}
    return data;
};

sexFn = function(value, row, index){
	if(value=='Y'){
		return '男';
	}else{
		return '女';
	}
};

user.init = function () {

    user.table = $('#' + user.tableId).bootstrapTable({
        url: user.baseUrl+"/page", //请求后台的URL（*）
        method: 'post', //请求方式（*）
        toolbar: '#' + user.toolbarId, //工具按钮用哪个容器
        striped: true, //是否显示行间隔色
        cache: false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true, //是否显示分页（*）
        sortable: false, //是否启用排序
        sortOrder: user.order, //排序方式
        queryParams: user.queryParams,//传递参数（*）
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
        uniqueId: user.unique, //每一行的唯一标识，一般为主键列
        showToggle: true, //是否显示详细视图和列表视图的切换按钮
        cardView: false, //是否显示详细视图
        detailView: false, //是否显示父子表
        columns: user.columns()
    });
};
user.select = function (layerTips) {
    var rows = user.table.bootstrapTable('getSelections');
    if (rows.length == 1) {
        user.currentItem = rows[0];
        return true;
    } else {
        layerTips.msg("请选中一行");
        return false;
    }
};

layui.use(['form', 'layedit', 'laydate'], function () {
    user.init();
    var layerTips = parent.layer === undefined ? layui.layer : parent.layer, //获取父窗口的layer对象
        layer = layui.layer, //获取当前窗口的layer对象
        form = layui.form(),
        layedit = layui.layedit,
        laydate = layui.laydate;
    var addBoxIndex = -1;
    //初始化页面上面的按钮事件
    $('#btn_query').on('click', function () {
        user.table.bootstrapTable('refresh', user.queryParams());
    });

    $('#btn_add').on('click', function () {
        if (addBoxIndex !== -1)
            return;
        //本表单通过ajax加载 --以模板的形式，当然你也可以直接写在页面上读取
        $.get(user.entity + '/edit', null, function (form) {
            addBoxIndex = layer.open({
                type: 1,
                title: '添加用户账号',
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
                    form.on('submit(edit)', function (data) {
                    	  doAjax(user.baseUrl+"/add", function(data) {
              				if (data.code==200) {	
              					layerTips.msg('保存成功');
                                layerTips.close(index);
                                location.reload();
              				}else{
              					 layerTips.msg(data.message);
              				} 
              			}, JSON.stringify({"data":data.field}), "post");
                        return false;  
                    });
                },
                end: function () {
                    addBoxIndex = -1;
                }
            });
        });
    });
    
    $('#btn_edit').on('click', function () {
        if (user.select(layerTips)) {
            var userCode = user.currentItem.userCode;
            doAjax(user.baseUrl + '/select', function(data) {
 				if (data.code==200) {	
 					var result = data.data;
 					$.get(user.entity+'/edit', null, function (form) {
 	                    layer.open({
 	                        type: 1,
 	                        title: '编辑用户信息',
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
 	                            setFromValues(layero, result);
 	                            form.render();
 	                            form.on('submit(edit)', function (data) {
 	                            	 doAjax(user.baseUrl+"/edit", function(data) {
 	                       				if (data.code==200) {	
 	                       					 layerTips.msg('修改成功');
 	                                         layerTips.close(index);
 	                                         location.reload();
 	                       				}else{
 	                       					 layerTips.msg(data.message);
 	                       				} 
 	                       			}, JSON.stringify({"data":data.field}), "post");
 	                               });
 	                                //这里可以写ajax方法提交表单
 	                                return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
 	                            }
 	                        });
 	                    });
 				  }	  
	 			}, JSON.stringify({"data":userCode}), "post");
         }
    });
    
  //设置权限
    $('#btn_edit2').on('click', function () {
        if (user.select(layerTips)) {
        	  var userCode = user.currentItem.userCode;
        	  doAjax(user.baseUrl + '/zTree', function(data) {
        		  if (data.code==200) {	
        			  var result = data.data;
        			  $.get(user.entity+'/setting', null, function (form) {
                          layer.open({
                              type: 1,
                              title: '设置权限',
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
                                 	 param.userCode = userCode;
                                  	 doAjax(user.baseUrl+"/settingUserResource", function(data) {
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
        	  },JSON.stringify({"data":userCode}),"post");
         }
    });

    //用户设置角色
    $('#btn_edit3').on('click', function () {
        if (user.select(layerTips)) {
        	  var userCode = user.currentItem.userCode;
        	  doAjax(user.baseUrl + '/roleZTree', function(data) {
        		  if (data.code==200) {	
        			  var result = data.data;
        			  $.get(user.entity+'/setting', null, function (form) {
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
                                 	 param.userCode = userCode;
                                  	 doAjax(user.baseUrl+"/settingUserRole", function(data) {
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
        	  },JSON.stringify({"data":userCode}),"post");
         }
    });
    
    $('#btn_del').on('click', function () {
        if (user.select(layerTips)) {
            var userCode = user.currentItem.userCode;
            layer.confirm('确定删除数据吗？', null, function (index) {
            	doAjax(user.baseUrl+"/delete", function(data) {
       				if (data.code==200) {	
       				     layerTips.msg("册除成功！");
       				     location.reload();
       				}else{
       					 layerTips.msg(data.message);
       					 location.reload();
       				} 
       			}, JSON.stringify({"data":userCode}), "POST");
                layer.close(index);
            });
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