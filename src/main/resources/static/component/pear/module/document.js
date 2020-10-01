layui.define(['jquery', 'element'], function(exports) {
	"use strict";

	var MOD_NAME = 'document',
		$ = layui.jquery,
		element = layui.element;

	var document = function(opt) {
		this.option = opt;
	};

	exports(MOD_NAME, new document());
})
