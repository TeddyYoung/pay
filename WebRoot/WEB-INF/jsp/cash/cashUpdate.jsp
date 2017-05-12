<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="../system/admin/top.jsp"%>
	</head>
	<body>
		<form action="<%=basePath%>cash/update.do" name="addForm" id="addForm" method="post">
			<input type="hidden" name="id" value="${cash.id}"/>
			<div id="zhongxin">
				<table id="table_report" class="table table-striped table-bordered table-hover">
					<tr>
						<td style="width:70px;text-align: right;padding-top: 13px;">提现单号:</td>
						<td><input type="text" name="cashNo" value="${cash.cashNo}"/></td>
						<td style="width:70px;text-align: right;padding-top: 13px;">客户编号:</td>
						<td><input type="text" name="customerId" value="${cash.customerId}"/></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">交易费率:</td>
						<td><input type="text" name="tradeRate" value="${cash.tradeRate}"/></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">结算费用手续费:</td>
						<td><input type="text" name="cashFee" value="${cash.cashFee}"/></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">结算上限:</td>
						<td><input type="text" name="cashMax" value="${cash.cashMax}"/></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">提现金额:</td>
						<td><input type="text" name="cashAmt" value="${cash.cashAmt}"/></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">结算方式:</td>
						<td><input type="text" name="cashType" value="${cash.cashType}"/></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">结算状态:</td>
						<td><input type="text" name="status" value="${cash.status}"/></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">申请日期:</td>
						<td><input type="text" name="applyDate" value="${cash.applyDate}"/></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">处理人:</td>
						<td><input type="text" name="dealUserId" value="${cash.dealUserId}"/></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">处理日期:</td>
						<td><input type="text" name="dealDate" value="${cash.dealDate}"/></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">开户银行:</td>
						<td><input type="text" name="depositBank" value="${cash.depositBank}"/></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">开户行名称:</td>
						<td><input type="text" name="bankName" value="${cash.bankName}"/></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">银行帐号:</td>
						<td><input type="text" name="accountNo" value="${cash.accountNo}"/></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">银行户名:</td>
						<td><input type="text" name="name" value="${cash.name}"/></td>
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