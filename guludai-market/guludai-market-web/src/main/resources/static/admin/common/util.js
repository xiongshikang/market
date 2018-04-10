function setFromValues(el, data) {
    for (var p in data) {
        el.find(":input[name='" + p + "']").val(data[p]);
    }
}

function doAjax(jsonurl, resultfunction, data, type,async , needCache) {
	data = data == null ? {} : data;
	type = type == null ? "GET" : type;
	async = async == null ? true : false;
	needCache = needCache == null ? false : true;
	//window.parent.showOnloadPage(); 

	
	$.ajax({
		type: type,
		url: jsonurl,
		data: data,
		contentType: "application/json",
        dataType: "json",
		async : false,
		cache : needCache,
		success: function(data) {
			try{
					data = typeof(data) == "string" ? eval("(" + data + ")") : data;
				if(typeof(data) ==  'object'){
					resultfunction(data);
					//window.parent.closeOnloadPage();
				}
			}catch(error){
				//window.parent.closeOnloadPage();
			}
		},
		headers : {  
              'Content-Type' : 'application/json;charset=utf-8'  
         }, 
		error: function(data) {
			//window.parent.closeOnloadPage();
		}
	});
} ;


function deepCopy(source) { 

    var result = {};
    
    if (source instanceof Array) {  
    	result = [];  
    }  

    for (var key in source) {

      result[key] = typeof source[key]==='object'? deepCopy(source[key]): source[key];

   } 
   return result; 
}

function showOnloadPage(){
    var showPageHtml = "";
    showPageHtml += '<div id="showOnloadPage" style="display:block;">' ;
    showPageHtml += '	<div class="mask_box" style="width:100%;height:100%;position:fixed;left:0;top:0;z-index:999;background:rgba(255,255,255,0.5);display:table;">';
    showPageHtml += '		<div style="display:table-cell;vertical-align:middle;text-align:center;margin:0 auto;">';
    showPageHtml += '			<img style="margin:0 auto;" src="static/images/jerichoload.gif"/>';
    showPageHtml += '		</div>';
    showPageHtml += '	</div>';
    showPageHtml += '</div>';
    if($('#showOnloadPage').length == 0){
    	$('body').append(showPageHtml);
    }
}

function showOnloadUrl(){
    var showPageHtml = "";
    showPageHtml += '<div id="showOnloadPageUrl" style="display:block;">' ;
    showPageHtml += '	<div class="mask_box" style="width:100%;height:100%;position:fixed;left:0;top:0;z-index:999;background:rgba(255,255,255,0.5);display:table;">';
    showPageHtml += '		<div style="display:table-cell;vertical-align:middle;text-align:center;margin:0 auto;background:white;">';
    showPageHtml += '			<img style="margin:0 auto;" src="static/jerichoload.gif"/>';
    showPageHtml += '		</div>';
    showPageHtml += '	</div>';
    showPageHtml += '</div>';
    if($('#showOnloadPageUrl').length == 0){
    	$('body').append(showPageHtml);
    }
}

function closeOnloadUrl(){
	$('#showOnloadPageUrl').remove();
}

function closeOnloadPage(){
	$('#showOnloadPage').remove();
}

