/**
~   Copyright [就眠仪式] [Pear Admin Layui of copyright owner]
~
~   Licensed under the Apache License, Version 2.0 (the "License");
~   you may not use this file except in compliance with the License.
~   You may obtain a copy of the License at
~
~       http://www.apache.org/licenses/LICENSE-2.0
~
~   Unless required by applicable law or agreed to in writing, software
~   distributed under the License is distributed on an "AS IS" BASIS,
~   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
~   See the License for the specific language governing permissions and
~   limitations under the License.
~ 
 */
layui.define(['table', 'jquery', 'element', 'form', 'pearAuth', 'pearTab', 'pearMenu', 'pearNotice', 'pearFrame'],
	function(exports) {
		"use strict";

		var $ = layui.jquery,
			form = layui.form,
			element = layui.element,
			pearTab = layui.pearTab,
			pearMenu = layui.pearMenu,
			pearNotice = layui.pearNotice,
			pearFrame = layui.pearFrame,
			pearAuth = layui.pearAuth;

		var bodyFrame;
		var sideMenu;
		var bodyTab;

		var pearAdmin = new function() {

			this.render = function(option) {
				this.menuRender(option);
				this.bodyRender(option);
				this.keepLoad(option);
				this.themeRender(option);
				this.noticeRender(option);
				this.permissionRender(option);
			}

			this.permissionRender = function(option) {
				if (option.auth != false) {
					pearAuth.loadPermission(option.auth);
				}
			}

			this.menuRender = function(option) {
				sideMenu = pearMenu.render({
					elem: 'sideMenu', //依赖容器
					async: true, //数据形式
					theme: option.theme,
					height: '100%',
					control: option.control ? 'control' : false, // control 
					defaultMenu: 1,
					defaultOpen: 0, //默认打开菜单
					accordion: true,
					url: option.data, //数据地址
					parseData: false, //请求后是否进行数据解析 函数
					change: option.change
				})
				sideMenu.selectItem(option.select);
			}

			this.noticeRender = function(option) {
				var option = {
					elem: 'headerNotice',
					url: option.notice,
					height: '250px',
					click: function(id, title, context, form) {
						layer.open({
							type: 1,
							title: '消息', //标题
							area: ['390px', '330px'], //宽高
							shade: 0.4, //遮罩透明度
							content: "<div style='background-color:whitesmoke;'><div class='layui-card'><div class='layui-card-body'>发件人 : " +
								form + "</div><div class='layui-card-header' >标题 : " + title +
								"</div><div class='layui-card-body' >内容 : " + context + "</div></div></div>", //支持获取DOM元素
							btn: ['确认'], //按钮组
							scrollbar: false, //屏蔽浏览器滚动条
							yes: function(index) { //layer.msg('yes');    //点击确定回调
								layer.close(index);
								showToast();
							}
						});
					}
				}
				pearNotice.render(option);
			}


			this.bodyRender = function(option) {
				if (option.muiltTab) {
					bodyTab = pearTab.render({
						elem: 'content',
						roll: true,
						tool: true,
						width: '100%',
						height: '100%',
						index: 0,
						tabMax: 20,
						data: [{
							id: '0',
							url: option.index,
							title: '首页',
							close: false
						}] //初始化数据
					});

					bodyTab.click(function(id) {

						bodyTab.positionTab();
						sideMenu.selectItem(id);
					})

					$("body").on("click", ".refresh", function() {
						$(".refresh a").removeClass("layui-icon-refresh-1");
						$(".refresh a").addClass("layui-anim");
						$(".refresh a").addClass("layui-anim-rotate");
						$(".refresh a").addClass("layui-anim-loop");
						$(".refresh a").addClass("layui-icon-loading");
						bodyTab.refresh(600);
						setTimeout(function() {
							$(".refresh a").addClass("layui-icon-refresh-1");
							$(".refresh a").removeClass("layui-anim");
							$(".refresh a").removeClass("layui-anim-rotate");
							$(".refresh a").removeClass("layui-anim-loop");
							$(".refresh a").removeClass("layui-icon-loading");
						}, 600)
					})

					sideMenu.click(function(dom, data) {

						bodyTab.addTabOnly({
							id: data.menuId,
							title: data.menuTitle,
							url: data.menuUrl,
							icon: data.menuIcon,
							close: true
						}, 300);
						compatible();
					})

				} else {
					bodyFrame = pearFrame.render({
						elem: 'content',
						title: '工作空间 / 首页',
						url: option.index,
						width: '100%',
						height: '100%'
					});

					$("body").on("click", ".refresh", function() {
						$(".refresh a").removeClass("layui-icon-refresh-1");
						$(".refresh a").addClass("layui-anim");
						$(".refresh a").addClass("layui-anim-rotate");
						$(".refresh a").addClass("layui-anim-loop");
						$(".refresh a").addClass("layui-icon-loading");
						bodyFrame.refresh(600);
						setTimeout(function() {
							$(".refresh a").addClass("layui-icon-refresh-1");
							$(".refresh a").removeClass("layui-anim");
							$(".refresh a").removeClass("layui-anim-rotate");
							$(".refresh a").removeClass("layui-anim-loop");
							$(".refresh a").removeClass("layui-icon-loading");
						}, 600)
					})

					sideMenu.click(function(dom, data) {
						compatible();
						bodyFrame.changePage(data.menuUrl, data.menuPath, true);
					})
				}
			}

			this.keepLoad = function(option) {

				compatible();
				setTimeout(function() {
					$(".loader-main").fadeOut(option.done);
				}, option.keepLoad)
			}



			this.colorSet = function(color) {

				var style = '';

				// 自 定 义 菜 单 配 色
				style +=
					'.light-theme .pear-nav-tree .layui-this a:hover,.light-theme .pear-nav-tree .layui-this,.light-theme .pear-nav-tree .layui-this a,.pear-nav-tree .layui-this a,.pear-nav-tree .layui-this{background-color: ' +
					color + '!important;}';

				// 自定义 Logo 标题演示
				style +=
					'.pear-admin .layui-logo .title{color:' +
					color + '!important;}';

				// 自 定 义 标 签 配 色
				style += '.pear-frame-title .dot,.pear-tab .layui-this .pear-tab-active{background-color: ' + color +
					'!important;}';

				// 自 定 义 快 捷 菜 单
				style += '.bottom-nav li a:hover{background-color:' +
					color + '!important;}';

				// 自 定 义 顶 部 配 色
				style += '.pear-admin .layui-header .layui-nav .layui-nav-bar{background-color: ' + color + '!important;}'

				// 自 定 义 加 载 配 色
				style += '.ball-loader>span,.signal-loader>span {background-color: ' + color + '!important;}';

				// 自 定 义 顶 部 配 色
				style += '.layui-header .layui-nav-child .layui-this a{background-color:' + color +
					'!important;color:white!important;}';

				// 自 定 义 加 载 配 色
				style += '#preloader{background-color:' + color + '!important;}';


				// 自 定 义 样 式 选 择 边 框 配 色
				style +=
					'.pearone-color .color-content li.layui-this:after, .pearone-color .color-content li:hover:after {border: ' +
					color + ' 2px solid!important;}';

				style += '.layui-nav .layui-nav-child dd.layui-this a, .layui-nav-child dd.layui-this{background-color:' + color +
					'!important}';

				style += '.pear-social-entrance {background-color:' + color + '!important}';

				style += '.pear-admin .pe-collaspe {background-color:' + color + '!important}';

				// 自 定 义 滚 动 条 样 式

				localStorage.setItem("theme-color", color);

				if ($("iframe").contents().find("#customTheme").length > 0) {

					$("iframe").contents().find("#customTheme").remove();

				}

				var theme = "<style>";
				theme += '</style>';

				$("iframe").contents().find("head").append(theme);
				$("#pearone-bg-color").html(style);
			}


			this.themeRender = function(option) {

				var color = localStorage.getItem("theme-color");
				var menu = localStorage.getItem("theme-menu");

				this.colorSet(color);
				this.menuSkin(menu);
			}


			this.menuSkin = function(theme) {
				$(".pear-admin").removeClass("light-theme");
				$(".pear-admin").removeClass("dark-theme");
				$(".pear-admin").addClass(theme);
			}
		};

		$("body").on("click", ".pearson", function() {
			pearTab.addTabOnlyByElem("content", {
				id: 111,
				title: "个人信息",
				url: "view/system/person.html",
				close: true
			})
		})

		$("body").on("click", ".collaspe,.pear-cover", function() {
			sideMenu.collaspe();
			if ($(".pear-admin").is(".pear-mini")) {
				$(".layui-icon-spread-left").addClass("layui-icon-shrink-right")
				$(".layui-icon-spread-left").removeClass("layui-icon-spread-left")
				$(".pear-admin").removeClass("pear-mini");
			} else {
				$(".layui-icon-shrink-right").addClass("layui-icon-spread-left")
				$(".layui-icon-shrink-right").removeClass("layui-icon-shrink-right")
				$(".pear-admin").addClass("pear-mini");
			}
		})

		$("body").on("click", ".fullScreen", function() {
			if ($(this).hasClass("layui-icon-screen-restore")) {
				screenFun(2).then(function() {
					$(".fullScreen").eq(0).removeClass("layui-icon-screen-restore");
				});
			} else {
				screenFun(1).then(function() {
					$(".fullScreen").eq(0).addClass("layui-icon-screen-restore");
				});
			}

		});

		function compatible() {
			if ($(window).width() <= 768) {
				sideMenu.collaspe();
				if ($(".pear-admin").is(".pear-mini")) {
					$(".layui-icon-spread-left").addClass("layui-icon-shrink-right")
					$(".layui-icon-spread-left").removeClass("layui-icon-spread-left")
					$(".pear-admin").removeClass("pear-mini");
				} else {
					$(".layui-icon-shrink-right").addClass("layui-icon-spread-left")
					$(".layui-icon-shrink-right").removeClass("layui-icon-shrink-right")
					$(".pear-admin").addClass("pear-mini");
				}
			}
		}

		function screenFun(num) {
			num = num || 1;
			num = num * 1;
			var docElm = document.documentElement;

			switch (num) {
				case 1:
					if (docElm.requestFullscreen) {
						docElm.requestFullscreen();
					} else if (docElm.mozRequestFullScreen) {
						docElm.mozRequestFullScreen();
					} else if (docElm.webkitRequestFullScreen) {
						docElm.webkitRequestFullScreen();
					} else if (docElm.msRequestFullscreen) {
						docElm.msRequestFullscreen();
					}
					break;
				case 2:
					if (document.exitFullscreen) {
						document.exitFullscreen();
					} else if (document.mozCancelFullScreen) {
						document.mozCancelFullScreen();
					} else if (document.webkitCancelFullScreen) {
						document.webkitCancelFullScreen();
					} else if (document.msExitFullscreen) {
						document.msExitFullscreen();
					}
					break;
			}

			return new Promise(function(res, rej) {
				res("返回值");
			});
		}


		$('body').on('click', '[data-select-bgcolor]', function() {
			var theme = $(this).attr('data-select-bgcolor');

			$('[data-select-bgcolor]').removeClass("layui-this");

			$(this).addClass("layui-this");

			localStorage.setItem("theme-menu", theme);

			pearAdmin.menuSkin(theme);
		});

		$('body').on('click', '.select-color-item', function() {

			$(".select-color-item").removeClass("layui-icon")
				.removeClass("layui-icon-ok");

			$(this).addClass("layui-icon").addClass("layui-icon-ok");

			var color = $(".select-color-item.layui-icon-ok").css("background-color");


			pearAdmin.colorSet(color);
		});


		$("body").on("click", ".setting", function() {

			var themeMenu = localStorage.getItem("theme-menu");
			var themeColor = localStorage.getItem("theme-color");

			var bgColorHtml = "";

			if (themeMenu == "light-theme") {

				bgColorHtml +=
					'<li  data-select-bgcolor="dark-theme">' +
					'<a href="javascript:;" data-skin="skin-blue" style="" class="clearfix full-opacity-hover">' +
					'<div><span style="display:block; width: 20%; float: left; height: 12px; background: #28333E;"></span><span style="display:block; width: 80%; float: left; height: 12px; background: white;"></span></div>' +
					'<div><span style="display:block; width: 20%; float: left; height: 40px; background: #28333E;"></span><span style="display:block; width: 80%; float: left; height: 40px; background: #f4f5f7;"></span></div>' +
					'</a>' +
					'</li>';

				bgColorHtml +=
					'<li class="layui-this"  data-select-bgcolor="light-theme">' +
					'<a href="javascript:;" data-skin="skin-blue" style="" class="clearfix full-opacity-hover">' +
					'<div><span style="display:block; width: 20%; float: left; height: 12px; background: white;"></span><span style="display:block; width: 80%; float: left; height: 12px; background: white;"></span></div>' +
					'<div><span style="display:block; width: 20%; float: left; height: 40px; background: white;"></span><span style="display:block; width: 80%; float: left; height: 40px; background: #f4f5f7;"></span></div>' +
					'</a>' +
					'</li>';

			} else {

				bgColorHtml +=
					'<li class="layui-this" data-select-bgcolor="dark-theme">' +
					'<a href="javascript:;" data-skin="skin-blue" style="" class="clearfix full-opacity-hover">' +
					'<div><span style="display:block; width: 20%; float: left; height: 12px; background: #28333E;"></span><span style="display:block; width: 80%; float: left; height: 12px; background: white;"></span></div>' +
					'<div><span style="display:block; width: 20%; float: left; height: 40px; background: #28333E;"></span><span style="display:block; width: 80%; float: left; height: 40px; background: #f4f5f7;"></span></div>' +
					'</a>' +
					'</li>';

				bgColorHtml +=
					'<li  data-select-bgcolor="light-theme">' +
					'<a href="javascript:;" data-skin="skin-blue" style="" class="clearfix full-opacity-hover">' +
					'<div><span style="display:block; width: 20%; float: left; height: 12px; background: white;"></span><span style="display:block; width: 80%; float: left; height: 12px; background: white;"></span></div>' +
					'<div><span style="display:block; width: 20%; float: left; height: 40px; background: white;"></span><span style="display:block; width: 80%; float: left; height: 40px; background: #f4f5f7;"></span></div>' +
					'</a>' +
					'</li>';

			}

			var html =
				'<div class="pearone-color">\n' +
				'<div class="color-title">整体风格</div>\n' +
				'<div class="color-content">\n' +
				'<ul>\n' + bgColorHtml + '</ul>\n' +
				'</div>\n' +
				'</div>';


			html +=
				"<div class='select-color'><div class='select-color-title'>主题色</div><div class='select-color-content'><span class='select-color-item ' style='background-color:#FF5722;'></span><span class='select-color-item layui-icon layui-icon-ok' style='background-color:#5FB878;'></span><span class='select-color-item'  style='background-color:#1E9FFF;'></span><span class='select-color-item' style='background-color:#FFB800;'></span><span class='select-color-item' style='background-color:darkgray;'></span></div></div>"

			// var muiltTab =
			// 	'<div class="layui-form-item">' +
			// 	'<div class="layui-input-inline">' +
			// 	'<input type="checkbox" checked name="switch" lay-skin="switch">' +
			// 	'</div>' +
			// 	'<label style="font-size:13.5px;" class="layui-form-label">多选项卡</label>' +
			// 	'</div>';

			// var showLogo =
			// 	'<div class="layui-form-item">' +
			// 	'<div class="layui-input-inline">' +
			// 	'<input type="checkbox" name="switch" checked lay-skin="switch">' +
			// 	'</div>' +
			// 	'<label style="font-size:13.5px;"  class="layui-form-label">菜单标题</label>' +
			// 	'</div>';


			// var menuType =
			// 	'<div class="layui-form-item">' +
			// 	'<div class="layui-input-inline">' +
			// 	'<input type="checkbox" name="switch" checked lay-skin="switch">' +
			// 	'</div>' +
			// 	'<label style="font-size:13.5px;" class="layui-form-label">系统菜单</label>' +
			// 	'</div>';

			// html +=
			// 	'<div class="layui-form" style="padding-top:20px!important;">\n' +
			// 	'<div class="pearone-color">\n' +
			// 	'<div class="color-title">更多设置</div>\n' +
			// 	'<div class="color-content">\n' +
			// 	'<ul>\n' + muiltTab + showLogo + menuType + '</ul>\n' +
			// 	'</div>\n' +
			// 	'</div></div>';



			html += '<div class="more-menu-list">' +
				'<a class="more-menu-item" href="http://www.pearadmin.cn/doc/" target="_blank">' +
				'<i class="layui-icon layui-icon-read" style="font-size: 19px;"></i> 开发文档' +
				'</a>' +
				'<a class="more-menu-item" href="https://gitee.com/mydemy/my-springsecurity-plus" target="_blank">' +
				'<i class="layui-icon layui-icon-tabs" style="font-size: 16px;"></i> 开源地址' +
				'</a>' +
				'<a class="more-menu-item" href="https://gitee.com/mydemy/my-springsecurity-plus" target="_blank">' +
				'<i class="layui-icon layui-icon-theme"></i> 官方网站' +
				'</a>' +
				'</div>';
				
			openRight(html);

		})

		function openRight(html) {
			layer.open({
				type: 1,
				offset: 'r',
				area: ['340px', '100%'],
				title: false,
				shade: 0.1,
				closeBtn: 0,
				shadeClose: false,
				anim: -1,
				skin: 'layer-anim-right',
				move: false,
				content: html,
				success: function(layero, index) {

					form.render();

					var color = localStorage.getItem("theme-color");

					if (color != "null") {

						$(".select-color-item").removeClass("layui-icon")
							.removeClass("layui-icon-ok");

						$(".select-color-item").each(function() {
							if ($(this).css("background-color") === color) {
								$(this).addClass("layui-icon").addClass("layui-icon-ok");
							}
						});
					}

					$('#layui-layer-shade' + index).click(function() {
						var $layero = $('#layui-layer' + index);
						$layero.animate({
							left: $layero.offset().left + $layero.width()
						}, 200, function() {
							layer.close(index);
						});
					})
				}
			});
		}

		exports('pearAdmin', pearAdmin);
	})
