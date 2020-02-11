function getRemoteData(url,callBack, async){
	return request({},"post",url,callBack, async);
}

function request(object,method,methodURL,successFunction, async){	
	$.ajax({
        cache: true,
        type: method,
        async: async,
        datatype:"json",
        contentType: "application/json",
        url:methodURL,
        data:JSON.stringify(object),
        error: function(XMLHttpRequest, textStatus, errorThrown) {
        	 alert(XMLHttpRequest.status+"\r\n"+XMLHttpRequest.readyState+"\r\n"+textStatus);
        },
        success: successFunction
    });
}