	cmainFrame();
	jzts();
	$(function() {
		if (typeof ($.cookie('menusf')) == "undefined") {
			$("#menusf").attr("checked", true);
			$("#sidebar").attr("class", "");
			//$("#sidebar").attr("class", "menu-min");
		} else {
			$("#sidebar").attr("class", "");
		}
	});
	function cmainFrame(){
		var hmain = document.getElementById("mainFrame");
		var bheight = document.documentElement.clientHeight;
		hmain .style.width = '100%';
		hmain .style.height = (bheight  - 51) + 'px';
		var bkbgjz = document.getElementById("bkbgjz");
		bkbgjz .style.height = (bheight  - 41) + 'px';	
	}
	window.onresize=function(){  
		cmainFrame();
	};
	
	// 获取部门树
	function getDeptTree(zTreeNodes) {
		var setting = {
			showLine: true
		};
		$(document).ready(function(){
			$.fn.zTree.init($("#tree"), setting, zTreeNodes);
		});
	}
