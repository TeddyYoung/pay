<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="../system/admin/top.jsp"%>
	</head>
	<body>
		<form action="<%=basePath%>companyProfit/update.do" name="updateForm" id="updateForm" method="post">
			<input type="hidden" name="id" value="${companyProfit.id}"/>
			<div id="zhongxin">
				<table id="table_report" class="table table-striped table-bordered table-hover">
					<tr>
						<td style="width:70px;text-align: right;padding-top: 13px;">收入单号:</td>
						<td><input type="text" name="profitNo" value="${companyProfit.profitNo}"/></td>
						<td style="width:70px;text-align: right;padding-top: 13px;">公司编号:</td>
						<td><input type="text" name="companyId" value="${companyProfit.companyId}"/></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">通道编号:</td>
						<td><input type="text" name="channelId" value="${companyProfit.channelId}"/></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">交易费率:</td>
						<td><input type="text" name="tradeRate" value="${companyProfit.tradeRate}"/></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">公司费率:</td>
						<td><input type="text" name="companyRate" value="${companyProfit.companyRate}"/></td>
					<td style="width:120px;text-align: right;padding-top: 13px;">收入类型:</td>	
						<td >
						<select class="type"  name="type">
						<option value ="1" ${1 == companyProfit.type?'selected':''} >分润收成</option>
  						<option value ="2" ${2 == companyProfit.type?'selected':''} >提现收成</option>
					</select>
				    </td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">交易金额:</td>
						<td><input type="text" name="tradeAmt" value="${companyProfit.tradeAmt}"/></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">收入金额:</td>
						<td><input type="text" name="profitAmt" value="${companyProfit.profitAmt}"/></td>
					</tr>
					<tr>
<!-- 						<td style="width:120px;text-align: right;padding-top: 13px;">收入日期:</td> -->
<%-- 						<td><input type="text" name="profitDate" value="${companyProfit.profitDate}"/></td> --%>
						<td style="width:120px;text-align: right;padding-top: 13px;">贡献人客户编号:</td>
						<td><input type="text" name="tradeCustomerId" value="${companyProfit.tradeCustomerId}"/></td>
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