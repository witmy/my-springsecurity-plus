layui.define(['table', 'jquery', 'element'], function (exports) {
    "use strict";

    var MOD_NAME = 'pearSocial',
        $ = layui.jquery,
		element = layui.element;
		
    var pearSocial = function (opt) {
        this.option = opt;
    };

    pearSocial.prototype.render = function (opt) {
        //默认配置值
		var option = {
			elem:opt.elem
		}
		
		createSocial(option);
		
		windowMove(option);
		
		return new pearSocial(option);
    } 
	
	function createSocial(option){
		
		var social = '<div class="pear-social-entrance layui-icon layui-icon-dialogue" pear-id="'+option.elem+'"></div>';
		
		var body  = '<div class="pear-social" style="display:none;">'+
			'<div class="pear-social-side">'+
				'<div class="pear-social-avatar">'+
					'<img src="admin/images/avatar.jpg" />'+
				'</div>'+
		
				'<div class="pear-social-control">'+
					'<div pear-id="1" class="layui-this layui-icon layui-icon-dialogue"></div>'+
					'<div pear-id="2" class="layui-icon layui-icon-username"></div>'+
				    '<div pear-id="4" class="layui-icon layui-icon-app"></div>'+
				    
				'</div>'+
		
				'<div class="pear-social-setting layui-icon layui-icon-slider">'+
		
				'</div>'+
			'</div>'+
			'<div class="pear-social-list">'+
				'<div class="pear-social-list-header">'+
					'<input type="text" class="search" />'+
					'<div class="searchBtn layui-icon layui-icon-add-1"></div>'+
				'</div>'+
				'<div class="pear-social-list-body">'+
					'<div class="layui-side-scroll" style="width: 100%;">'+
						'<div pear-id="1" class="body layui-side-scroll session">'+
						
							'<div class="body-item">'+
								'<img class="body-item-avatar" src="admin/images/avatar.jpg"><span class="body-item-name">老大</span><span class="dot online"></span>'+
							'</div>'+
							'<div class="body-item">'+
								'<img class="body-item-avatar" src="admin/images/avatar.jpg"><span class="body-item-name">老二</span><span class="dot"></span>'+
							'</div>'+
							
						
						'</div>'+
						
						'<div pear-id="2" class="body layui-side-scroll list" style="display: none;">'+
						   ' <div class="body-item">'+
						    	'<img class="body-item-avatar" src="admin/images/avatar.jpg"><span class="body-item-name">新的朋友</span>'+
						    '</div>'+
							'<div class="body-split">A</div>'+
							'<div class="body-item">'+
								'<img class="body-item-avatar" src="admin/images/avatar.jpg"><span class="body-item-name">老大</span><span class="dot online"></span>'+
							'</div>'+
							'<div class="body-item">'+
								'<img class="body-item-avatar" src="admin/images/avatar.jpg"><span class="body-item-name">老大</span><span class="dot online"></span>'+
							'</div>'+
					
						'</div>'+
						
						'<div pear-id="4" class="body layui-side-scroll" style="display: none;">'+
						   ' <div class="body-item">'+
								'<img class="body-item-avatar" src="admin/images/avatar.jpg"><span class="body-item-name">老大</span>'+
							'</div>'+
						'</div>'+
					'</div>'+
					
				'</div>'+
			'</div>'+
			'<div class="pear-social-body">'+
		
				'<div class="pear-social-body-header">'+
					'<div class="title">就 眠 仪 式</div>'+
					'<div class="window-tool">'+
						'<a class="layui-icon layui-icon-subtraction window-close"></a>'+
						'<a class="layui-icon layui-icon-screen-full screen-full"></a>'+
					   '<a class="layui-icon layui-icon-close window-close"></a>'+
					'</div>'+
				'</div>'+
		
				'<div class="pear-social-body-content">'+
					
					'<div class="pear-social-body-content-chat">'+
		
						'<ul class="content">'+
							'<li class="me"><img src="admin/images/avatar.jpg" title="彩色系"><span>疾风知劲草，板荡识诚臣</span></li>'+
							'<li class="other"><img src="admin/images/avatar.jpg" title="就眠仪式"><span>勇夫安知义，智者必怀仁</span></li>'+
						'</ul>'+
					'</div>'+
				
					'<div class="pear-social-body-content-input">'+
						'<div class="pear-social-body-content-input-tool">'+
							'<a class="layui-icon layui-icon-face-smile"></a>'+
							'<a class="layui-icon layui-icon-email"></a>'+
							'<a class="layui-icon layui-icon-dialogue"></a>'+
							'<a class="layui-icon layui-icon-time"></a>'+
						'</div>'+
						'<textarea></textarea>'+
						'<button class="pear-social-body-content-input-enter">发 送</button>'+
					'</div>'+
		
				'</div>'+
		
			'</div>'+
		'</div>';
		
		
		$("#"+option.elem).html(social+body);
		
		controlEvent(option);
		
	}
	
	function controlEvent(option){
		
		$("#"+option.elem+" .pear-social .pear-social-control").on("click", "div", function() {
		
			var tool = $(this).attr("pear-id");
		
			$("#"+option.elem+" .body").css({
				display: "none"
			});
		
			$("#"+option.elem+" .body[pear-id='" + tool + "']").css({
				display: "block"
			});
			
			
			$("#"+option.elem+" .pear-social-control div").removeClass("layui-this");
			$(this).addClass("layui-this");
		})
		
	}
	
	// 记 住 原 来 的 位 置
	var top;
	
	var left;
	
	// 放 大
	$("body").on("click", ".screen-full", function() {
	
		top = $(this).parents(".pear-social").offset().top;
		left = $(this).parents(".pear-social").offset().left;
		$(this).parents(".pear-social").css({
			top: '0px'
		});
		$(this).parents(".pear-social").css({
			left: '0px'
		});
		$(this).parents(".pear-social").width("100%");
		$(this).parents(".pear-social").height("100%");
		$(this).removeClass("screen-full");
		$(this).removeClass("layui-icon-screen-full");
		$(this).addClass("screen-restore");
		$(this).addClass("layui-icon-screen-restore");
	
	})
	
	
	
	$("body").on("click", ".screen-restore", function() {
		
		$(this).parents(".pear-social").css({
			top: top
		});
		$(this).parents(".pear-social").css({
			left: left
		});
		$(this).parents(".pear-social").width("1000px");
		$(this).parents(".pear-social").height("550px");
		$(this).addClass("screen-full");
		$(this).addClass("layui-icon-screen-full");
		$(this).removeClass("screen-restore");
		$(this).removeClass("layui-icon-screen-restore");
	
	})
	
	function windowMove(option){
		 
		 var disX = 0;
		 
		 var disY = 0;
		 
		 
		 $('.pear-social-body-header').mousedown(function(ev) {
		 
		 	disX = ev.pageX - $(this).offset().left + 300; //获取鼠标到元素的left,top位置
		 	disY = ev.pageY - $(this).offset().top;
			
			var _this = $(this);
			
		 	$("#"+option.elem).mousemove(function(ev) {
		 
		 	   _this.parents('.pear-social').css('left', ev.pageX - disX); //获取移动后鼠标的位置，并重新赋值给元素
		 	   _this.parents('.pear-social').css('top', ev.pageY - disY);
		 
		 	});
		 
		 	$("#"+option.elem).mouseup(function() {
		 
		 		$("#"+option.elem).off();
		 
		 	});
		 
		 	return false;
		 });
	}
	
	$("body").on("click", ".window-close", function() {
	
		$(this).parents(".pear-social").css({
			display: "none"
		});
	})
	
	$("body").on("click", ".pear-social-entrance", function() {
	
	
	    $(this).parent().find(".pear-social").css({
			display: "block"
		});
		
	})

	
	exports(MOD_NAME,new pearSocial());
})