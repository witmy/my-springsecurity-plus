layui.define(['table', 'jquery', 'element'], function (exports) {
    "use strict";

    var MOD_NAME = 'pearAuth',
        $ = layui.jquery,
		element = layui.element;
		
    var pearAuth = function () {};
	
	/**
	 * 初始化
	 * */
	pearAuth.prototype.loadPermission = function (url) {
	  
	  	var data = getData(url);
	    sessionStorage.setItem("auth_cache", JSON.stringify(data));
	} 
	
	/**
	 * 清除权限
	 * */
	pearAuth.prototype.clearPermission = function () {
	    
		sessionStorage.removeItem('auth_cache')
	} 
		
	/** 同 步 请 求 获 取 数 据 */
	function getData(url) {
	
		$.ajaxSettings.async = false;
		var data = null;
	
		$.get(url, function(result) {
			data = result;
		});
	
		$.ajaxSettings.async = true;
		
		return data;
	}
	
	var doms = $("*[pear-has-permission]");

    $.each(doms,function(i,dom){
		
	     var permission =  $(dom).attr("pear-has-permission");
	
	     var b = false;
	
	     $.each(JSON.parse(sessionStorage.getItem('auth_cache')),function(i,auth){
			 
			 if(auth.code == permission){
				 
				 b = true;
				 
				 return false;
			 }
			 
		 })
		 
		 if(!b){
			 $(dom).hide();
		 }
	})
	
	exports(MOD_NAME,new pearAuth());
})