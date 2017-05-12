﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="../system/admin/top.jsp"%>
		<script type="text/javascript">
			$(function(){
				var zTreeNodes = ${zTreeNodes};
				getDeptTree(zTreeNodes);// 部门树
			})
		</script>
	</head>
	<body id="wrapper">
		<div class="container-fluid" id="main-container">
			<div id="deptTree" class="menu-min">
				<ul id="tree" class="ztree"></ul>
			</div>
			<div id="main-content-new" class="clearfix">
				<div>
					<iframe src="<%=basePath %>company/queryList.do?pid=${sessionDept.id}" id="listFrame" name="listFrame"
							frameborder="0" style="margin:0 auto;width:100%;height:520px;"></iframe>
				</div>
			</div>
		</div>
	</body>
</html>