<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="../system/admin/top.jsp"%>
	</head>
	<body>
		<form action="<%=basePath%>brand/update.do" name="addForm" id="addForm" method="post">
			<input type="hidden" name="id" value="${brand.id}"/>
			<div id="zhongxin">
				<table id="table_report" class="table table-striped table-bordered table-hover">
					<tr>
						<td style="width:70px;text-align: right;padding-top: 13px;">订单号:</td>
						<td><input type="text" name="orderNo" value="${order.orderNo}"/></td>
						<td style="width:70px;text-align: right;padding-top: 13px;">客户编号:</td>
						<td><input type="text" name="customerId"value="${order.customerId}" /></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">通道编号:</td>
						<td><input type="text" name="channelId" value="${order.channelId}"/></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">交易费率:</td>
						<td><input type="text" name="tradeFeeRate" value="${order.tradeFeeRate}"/></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">结算费用:</td>
						<td><input type="text" name="settleFeeNormal" value="${order.settleFeeNormal}"/></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">结算上限:</td>
						<td><input type="text" name="settleMax" value="${order.settleMax}"/></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">交易金额:</td>
						<td><input type="text" name="tradeAmt" value="${order.tradeAmt}"/></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">实得金额:</td>
						<td><input type="text" name="takeAmt" value="${order.takeAmt}"/></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">交易时间:</td>
						<td><input type="text" name="tradeTime" value="${order.tradeTime}"/></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">订单状态:</td>
						<td><input type="text" name="tradeStatus" value="${order.tradeStatus}"/></td>
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