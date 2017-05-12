<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="../system/admin/top.jsp"%>
	</head>
	<body>
		<form action="<%=basePath%>companyAccount/update.do" name="updateForm" id="updateForm" method="post">
			<input type="hidden" name="id" value="${companyAccount.id}"/>
			<div id="zhongxin">
				<table id="table_report" class="table table-striped table-bordered table-hover">
					<tr>
						<td style="width:70px;text-align: right;padding-top: 13px;">所属客户ID:</td>
						<td><input type="text" name="companyId" value="${companyAccount.companyId}"/></td>
						<td style="width:70px;text-align: right;padding-top: 13px;">账户余额:</td>
						<td><input type="text" name="balanceAmt" value="${companyAccount.balanceAmt}"/></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">分润余额:</td>
						<td><input type="text" name="profitAmt" value="${companyAccount.profitAmt}"/></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">冻结余额:</td>
						<td><input type="text" name="freezeAmt" value="${companyAccount.freezeAmt}"/></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">可用余额:</td>
						<td><input type="text" name="avaliableAmt" value="${companyAccount.avaliableAmt}"/></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">账户类型:</td>
						<td><input type="text" name="type" value="${companyAccount.type}"/></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">币种:</td>
						<td><input type="text" name="currency" value="${companyAccount.currency}"/></td>
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