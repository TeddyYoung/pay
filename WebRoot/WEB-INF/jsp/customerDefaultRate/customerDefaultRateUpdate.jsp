<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="../system/admin/top.jsp"%>
	</head>
	<body>
		<form action="<%=basePath%>customerDefaultRate/update.do" name="updateForm" id="updateForm" method="post">
			<input type="hidden" name="id" value="${customerDefaultRate.id}"/>
			<div id="zhongxin">
				<table id="table_report" class="table table-striped table-bordered table-hover">
					<tr>
						<td style="width:70px;text-align: right;padding-top: 13px;">客户类型:</td>
						<td><input type="text" name="customerType" value="${customerDefaultRate.customerType}"/></td>
						<td style="width:70px;text-align: right;padding-top: 13px;">客户类型名称:</td>
						<td><input type="text" name="customerTypeName" value="${customerDefaultRate.customerTypeName}"/></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">条件:</td>
						<td><input type="text" name="upgradeCondition" value="${customerDefaultRate.upgradeCondition}"/></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">通道编号:</td>
						<td>
							<select class="chzn-select" name="channelId" id="channelId" data-placeholder="请选择">
								<option value="">请选择</option>
								<c:if test="${channelList != null}">
									<c:forEach items="${channelList}" var="var">
										<option value="${var.id}" <c:if test="${customerDefaultRate.channelId == var.id}">selected</c:if> >${var.channelName}</option>
									</c:forEach>
								</c:if>
							</select>
						</td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">交易费率:</td>
						<td><input type="text" name="tradeRate" value="${customerDefaultRate.tradeRate}"/></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">正常结算费用:</td>
						<td><input type="text" name="normalFee" value="${customerDefaultRate.normalFee}"/></td>
					</tr>
						<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">晚间结算费用:</td>
						<td><input type="text" name="nightFee" value="${customerDefaultRate.nightFee}"/></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">节假日结算费用:</td>
						<td><input type="text" name="holidayFee" value="${customerDefaultRate.holidayFee}"/></td>
					</tr>
						<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">结算上限:</td>
						<td><input type="text" name="cashMax" value="${customerDefaultRate.cashMax}"/></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">品牌id:</td>
						<td><input type="text" name="brandId" value="${customerDefaultRate.brandId}"/></td>
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