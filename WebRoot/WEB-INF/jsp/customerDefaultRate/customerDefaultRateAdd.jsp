<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="../system/admin/top.jsp"%>
	</head>
	<body>
		<form action="<%=basePath%>customerDefaultRate/add.do" name="addForm" id="addForm" method="post">
			<input type="hidden" name="brandId" value="${brandId}" />
			<div id="zhongxin">
				<table id="table_report" class="table table-striped table-bordered table-hover">
					<tr>
						<td style="width:70px;text-align: right;padding-top: 13px;">客户类型:</td>
						<td><input type="text" name="customerType" /></td>
						<td style="width:70px;text-align: right;padding-top: 13px;">客户类型名称:</td>
						<td><input type="text" name="customerTypeName" /></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">条件:</td>
						<td><input type="text" name="upgradeCondition" /></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">所属通道:</td>
						<td>
							<select class="chzn-select" name="channelId" id="channelId" data-placeholder="请选择">
								<option value="">请选择</option>
								<c:if test="${channelList != null}">
									<c:forEach items="${channelList}" var="var">
										<option value="${var.id}">${var.channelName}</option>
									</c:forEach>
								</c:if>
							</select>
						</td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">交易费率:</td>
						<td><input type="text" name="tradeRate" /></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">正常结算费用:</td>
						<td><input type="text" name="normalFee" /></td>
					</tr>
						<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">晚间结算费用:</td>
						<td><input type="text" name="nightFee" /></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">节假日结算费用:</td>
						<td><input type="text" name="holidayFee" /></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">结算上限:</td>
						<td><input type="text" name="cashMax" /></td>
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