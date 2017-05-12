<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="../system/admin/top.jsp"%>
	</head>
	<body>
		<form action="<%=basePath%>companyProfit/add.do" name="addForm" id="addForm" method="post">
			<div id="zhongxin">
				<table id="table_report" class="table table-striped table-bordered table-hover">
					<tr>
						<td style="width:70px;text-align: right;padding-top: 13px;">收入单号:</td>
						<td><input type="text" name="profitNo" /></td>
						<td style="width:70px;text-align: right;padding-top: 13px;">公司编号:</td>
						<td><input type="text" name="companyId" /></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">通道编号:</td>
						<td><input type="text" name="channelId" /></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">交易费率:</td>
						<td><input type="text" name="tradeRate" /></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">公司费率:</td>
						<td><input type="text" name="companyRate" /></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">收入类型:</td>
						<td><input type="text" name="type" /></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">交易金额:</td>
						<td><input type="text" name="tradeAmt" /></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">收入金额:</td>
						<td><input type="text" name="profitAmt" /></td>
					</tr>
					<tr>
<!-- 						<td style="width:120px;text-align: right;padding-top: 13px;">收入日期:</td> -->
<!-- 						<td><input type="text" name="profitDate" /></td> -->
						<td style="width:120px;text-align: right;padding-top: 13px;">贡献人客户编号:</td>
						<td><input type="text" name="tradeCustomerId" /></td>
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