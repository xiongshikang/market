var carId;
require([ "ready!" ], function() {
	carId = avalon.define({
		$id : "carId",
		carIdInfo: [{customerCode:'',customerIdcard:'',customerName:''}],
		addFn:function(){
			layui.use(['form'], function () {
				 form = layui.form();//获取当前窗口的layer对象
				 var customerModel = {
							customerCode:'',
							customerIdcard:'',
							customerName:''
						};
				 carId.carIdInfo.push(customerModel);
				 form.render();
			});
		},
		removeFn:function(index){
			 carId.carIdInfo.removeAt(index);
		},
		initFun:function(){
			var applyCode = $('[name="applyCode"]').val();
			doAjax("/market/web/selectApplyCustomerByApplyCode", function(data) {
				if (data.code==200) {	
					carId.carIdInfo = [];
					carId.carIdInfo = data.data;
				}
		    }, JSON.stringify({"data":applyCode}), "POST");
		}
	});
	avalon.scan(); // 扫描
});
 


