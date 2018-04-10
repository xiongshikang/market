
var resource = {
    baseUrl: "/market/web/resource",
    entity: "resource/edit",
    tableId: "menuTable",
    toolbarId: "toolbar",
    unique: "resourceCode",
    order: "asc",
    currentItem: {},
    code:"resourceCode",
    parentCode:"resourceParentCode",
    rootValue: -1,
    explandColumn:1
};
resource.columns = function () {
    return [
    	 {
            field: 'selectItem',
            radio: true
        },{
            field: 'resourceName',
            title: '资源名称'
        },{
            field: 'resourcePath',
            title: '资源地址'
        },{
            field: 'resourceTypeStr',
            title: '类型'
        },{
            field: 'resourceHref',
            title: '跳转地址'
        },{
            field: 'resourceIcon',
            title: '显示图标'
        },{
            field: 'resourceDescription',
            title: '备注'
        }];
};
//得到查询的参数
resource.queryParams = function () {
    var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
    		resourceName: $("#resourceName").val()
    };
    var data= {
    		data:temp
	}
    return data;
};
resource.init = function () {
    resource.table = $('#'+resource.tableId).bootstrapTreeTable({
        id: resource.unique,// 选取记录返回的值
        code: resource.code,// 用于设置父子关系
        parentCode: resource.parentCode,// 用于设置父子关系
        rootCodeValue: resource.rootValue,
        url: resource.baseUrl+'/list', //请求后台的URL（*）
        method: 'get', //请求方式（*）
        toolbar: '#'+resource.toolbarId, //工具按钮用哪个容器
        striped: true, //是否显示行间隔色
        cache: false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        ajaxParams: resource.queryParams,//传递参数（*）
        expandColumn: resource.explandColumn,//在哪一列上面显示展开按钮,从0开始
        expandAll:true,
        columns: resource.columns()
    });
};

resource.select = function (layerTips) {
    var rows = resource.table.bootstrapTreeTable('getSelections');
    if (rows.length == 1) {
        resource.currentItem = rows[0];
        return true;
    } else {
        layerTips.msg("请选中一行");
        return false;
    }
};


layui.use(['form', 'layedit', 'laydate'], function () {
    resource.init();
    var allMenu = [];
    var editIndex;
    $.get(resource.baseUrl+'/all',null,function(data){
    	data = typeof(data) == "string" ? eval("(" + data + ")") : data;
        allMenu = data.data;
    }) ;
    var layerTips = parent.layer === undefined ? layui.layer : parent.layer, //获取父窗口的layer对象
        layer = layui.layer, //获取当前窗口的layer对象
        form = layui.form(),
        layedit = layui.layedit;
//初始化页面上面的按钮事件
    $('#btn_query').on('click',function(){
        resource.table.bootstrapTreeTable('refresh',resource.queryParams());
    }) ;
    var addBoxIndex = -1;
    $('#btn_add').on('click',function(){
        if (addBoxIndex !== -1)
            return;
        var rows=  resource.table.bootstrapTreeTable('getSelections');
        var resourceCode = "-1";
        if(rows.length==1){
        	resourceCode = rows[0].id;
        }
        //本表单通过ajax加载 --以模板的形式，当然你也可以直接写在页面上读取
        $.get(resource.entity, null, function (form) {
            addBoxIndex = layer.open({
                type: 1,
                title: '添加资源',
                content: form,
                btn: ['保存', '取消'],
                shade: false,
                offset: ['0px', '0%'],
                area: ['100%', '100%'],
                maxmin: true,
                yes: function (index) {
                    layedit.sync(editIndex);
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
                    editIndex = layedit.build('description_editor');
                    form.render();
                    for(var i=0;i<allMenu.length;i++)
                        layero.find('#resourceParentCode').append('<option value="'+allMenu[i].resourceCode+'" >'+allMenu[i].resourceName+'</option>');
                    layero.find("select[name='resourceParentCode']").val(resourceCode);
                    form.render('select');
                    form.on('submit(edit)', function (data) {
                    	 doAjax(resource.baseUrl+"/add", function(data) {
              				if (data.code==200) {	
              					layerTips.msg('添加成功');
                                layerTips.close(index);
                                location.reload();
              				}else{
              					 layerTips.msg(data.message);
              				} 
              			  }, JSON.stringify({"data":data.field}), "POST");
                       });
                        //这里可以写ajax方法提交表单
                        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
                },
                end: function () {
                    addBoxIndex = -1;
                }
            });
        });
    });
    $('#btn_edit').on('click',function(){
    	 var rows= resource.table.bootstrapTreeTable('getSelections');
       if(resource.select(layerTips)) {
          var resourceCode = resource.currentItem.id; 
           doAjax(resource.baseUrl+'/select', function(data) {
 				if (data.code==200) {	
 					var result = data.data;
 	               $.get(resource.entity, null, function (form) {
 	                   layer.open({
 	                       type: 1,
 	                       title: '编辑资源',
 	                       content: form,
 	                       btn: ['保存', '取消'],
 	                       shade: false,
 	                       offset: ['0px', '0%'],
 	                       area: ['100%', '100%'],
 	                       maxmin: true,
 	                       yes: function (index) {
 	                           layedit.sync(editIndex);
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
 	                           layero.find('#description_editor').val(result.resourceDescription);
 	                           editIndex = layedit.build('description_editor');
 	                           for (var i = 0; i < allMenu.length; i++)
 	                        	  layero.find('#resourceParentCode').append('<option value="'+allMenu[i].resourceCode+'" >'+allMenu[i].resourceName+'</option>');
 	                           layero.find("select[name='resourceParentCode']").val(result['resourceParentCode']);
 	                           form.render('select');
 	                           form.render();
 	                           form.on('submit(edit)', function (data) {
 	                        	  doAjax(resource.baseUrl+"/edit", function(data) {
 	                   				if (data.code==200) {	
 	                   					layerTips.msg('修改成功');
 	                                     layerTips.close(index);
 	                                     location.reload();
 	                   				}else{
 	                   					 layerTips.msg(data.message);
 	                   				} 
 	                   			  }, JSON.stringify({"data":data.field}), "POST");
 	                               //这里可以写ajax方法提交表单
 	                               return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
 	                           });
 	                       }
 	                   });
 	               });
 				}else{
 					 layerTips.msg(data.message);
 				} 
 			  }, JSON.stringify({"data":{"resourceCode":resourceCode}}), "POST");
       }
    });
    
    
    
	 /*layer.open({
	        type: 1
	        ,offset: 'auto' 
	        ,content: '<div style="padding:20px 80px">'+ message +'</div>'
	        ,btn: '确定'
	        ,btnAlign: 'c' 
	        ,shade: 0 
	        ,yes: function(){
	          layer.closeAll();
	        }
	});*/
  
    $('#btn_del').on('click',function(){
        if (resource.select(layerTips)) {
            var resourceCode = resource.currentItem.id;
            layer.confirm('确定删除数据吗？', null, function (index) {
	            	doAjax(resource.baseUrl+"/del", function(data) {
	    				if (data.code==200) {	
	    					layerTips.msg('移除成功');
	                      layerTips.close(index);
	                      location.reload();
	    				}else{
	    					 layerTips.msg(data.message);
	    				} 
	    			  }, JSON.stringify({"data":resourceCode}), "POST");
                   layer.close(index);
            });
        }
    })  ;
});


