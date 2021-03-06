window.AE = window.AE || {};

window.AE.Utils = {
    // The FormData interface provides a way to easily construct a set of key/value pairs representing form fields
    // and their values, which can then be easily sent in a http request
    // The FormData.entries() method returns an iterator allowing to go through all key/value pairs contained in
    // this object.
	readFormData : function readFormData($form) {
        let data = {};
        for(let val of (new FormData($form.get(0))).entries()) {
            data[val[0]] = val[1];
        }
        return data;
	},
	
    defaultErrorHandling : function defaultErrorHandling(xhr) {
        let errorMsg;
        if (xhr.status == 0) {
            errorMsg = "The server is not responding or is not reachable.";
        } else {
            errorMsg = (xhr.statusText != "")? xhr.responseText : xhr.response;
        }
        console.log(errorMsg);
        alert(errorMsg);
     },
     
     initAjax : function initAjax() {
         
         $.ajaxSetup({
             dataType : 'json',
             contentType : "application/json;charset=utf-8",
             timeout : 20000,
             error : AE.Utils.defaultErrorHandling
          });
     },
};