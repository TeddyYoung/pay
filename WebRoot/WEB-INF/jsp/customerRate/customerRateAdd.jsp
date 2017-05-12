<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="../system/admin/top.jsp"%>
	</head>
	<body>
		<form action="<%=basePath%>brand/add.do" name="addForm" id="addForm" method="post">
			<div id="zhongxin">
				<table id="table_report" class="table table-striped table-bordered table-hover">
					<tr>
						<td style="width:70px;text-align: right;padding-top: 13px;">品牌编号:</td>
						<td><input type="text" name="brandNo" /></td>
						<td style="width:70px;text-align: right;padding-top: 13px;">品牌名称:</td>
						<td><input type="text" name="brandName" /></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">公司名称:</td>
						<td><input type="text" name="fullName" /></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">法人代表:</td>
						<td><input type="text" name="president" /></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">联系电话:</td>
						<td><input type="text" name="phone" /></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">公司地址:</td>
						<td><input type="text" name="address" /></td>
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