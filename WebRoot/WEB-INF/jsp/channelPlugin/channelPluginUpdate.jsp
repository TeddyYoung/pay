<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="../system/admin/top.jsp"%>
	</head>
	<body>
		<form action="<%=basePath%>channelPlugin/update.do" name="addForm" id="addForm" method="post">
			<input type="hidden" name="id" value="${channelPlugin.id}"/>
			<input type="hidden" name="channelId" value="${channelPlugin.channelId}"/>
			<div id="zhongxin">
				<table id="table_report" class="table table-striped table-bordered table-hover">
					<tr>
					<td style="width:120px;text-align: right;padding-top: 13px;">配置名称:</td>
						<td><input type="text" name="pluginName" value="${channelPlugin.pluginName}"/></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">配置key:</td>
						<td><input type="text" name="pluginKey" value="${channelPlugin.pluginKey}"/></td>
						
					</tr>
					<tr>
						<td style="width:70px;text-align: right;padding-top: 13px;">配置值:</td>
						<td><input type="text" name="pluginValue" value="${channelPlugin.pluginValue}"/></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td style="text-align: center;" colspan="10">
							<button type="submit" class="btn btn-mini btn-primary">保存</button>
							<button type="button" class="btn btn-mini btn-danger" onclick="javascript:history.go(-1);">返回</button>
						</td>
					</tr>
				</table>
			</div>
		</form>
	</body>
</html>