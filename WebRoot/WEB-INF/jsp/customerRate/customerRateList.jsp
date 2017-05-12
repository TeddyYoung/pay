<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="../system/admin/top.jsp"%>
	</head>
	<body>
		<div class="container-fluid" id="main-container">
			<div id="page-content" class="clearfix">
			  <div class="row-fluid">
					<div class="row-fluid">
						<form action="customerRate/queryList.do" method="post" name="listForm" id="listForm">
						<input type="hidden" name="customerId" value="${customerRate.customerId}">
							<table>
								<tr>
									<td style="vertical-align:top;"> 
									 	<select class="chzn-select" name="field1" id="field1" data-placeholder="请选择" style="vertical-align:top;width: 120px;">
											<option value="">请选择客户类型</option>
									  	</select>
									 	<select class="chzn-select" name="field2" id="field2" data-placeholder="请选择" style="vertical-align:top;width: 120px;">
											<option value="">请选择支付通道</option>
									  	</select>
										<button type="submit" class='btn btn-mini btn-info btn-rbg' style="margin-top:0" >查询</button>
										<a type="button" class="btn btn-mini btn-danger" href="<%=basePath%>customer/queryList.do">返回</a>
									</td>
								</tr>
							</table>
							<table id="listTable" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th class="center">序号</th>
										<th class="center">客户编号</th>
										<th class="center">通道编号</th>
										<th class="center">交易费率</th>
										<th class="center">正常结算费用</th>
										<th class="center">晚间结算费用</th>
										<th class="center">节假日结算费用</th>
										<th class="center">结算上限</th>
										<th class="center">通道帐户余额</th>
										<th class="center">通道分润余额</th>
										<th class="center">通道累计分润</th>
										<th class="center">通道累计收入</th>
										<th class="center">操作</th>
									</tr>
								</thead>
								<tbody>
								<c:choose>
									<c:when test="${not empty page.records}">
										<c:forEach items="${page.records}" var="customerRate" varStatus="vs">
											<tr>
												<td class='center'>${vs.count}</td>
												<td class='center'>${customerRate.customerId}</td>
												<td class='center'>${customerRate.channelId}</td>
												<td class='center'>${customerRate.tradeRate}</td>
												<td class='center'>${customerRate.normalFee}</td>
												<td class='center'>${customerRate.nightFee}</td>
												<td class='center'>${customerRate.holidayFee}</td>
												<td class='center'>${customerRate.cashMax}</td>
												<td class='center'>${customerRate.accountAmt}</td>
												<td class='center'>${customerRate.profitAmt}</td>
												<td class='center'>${customerRate.totalProfitAmt}</td>
												<td class='center'>${customerRate.totalAccountAmt}</td>
												<td class='center'>
													<a class='btn btn-mini btn-info' href="<%=basePath%>customerRate/toUpdate.do?id=${customerRate.id}">修改</a>
												</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<tr class="main_info">
											<td colspan="100" class="center" >没有相关数据</td>
										</tr>
									</c:otherwise>
								</c:choose>
								</tbody>
							</table>
							<div align="right">
								<%@include  file="../page.jsp" %>
							</div>
						</form>
					</div>
	  			</div>
			</div>
		</div>
	</body>
</html>

