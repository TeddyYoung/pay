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
						<form action="customerProfit/queryList.do" method="post" name="listForm" id="listForm">
<%-- 							<input type="hidden" name="brandId" value="${customerDefaultRate.brandId}"> --%>
							<table>
								<tr>
									<td> 
<%-- 										<a class='btn btn-mini btn-info' href="<%=basePath%>customerDefaultRate/toAdd.do?brandId=${customerDefaultRate.brandId}">新增</a> --%>
<%-- 										<a type="button" class="btn btn-mini btn-danger" href="<%=basePath%>brand/queryList.do">返回</a> --%>
									</td>
								</tr>
							</table>
							<table id="listTable" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th class="center">序号</th>
										<th class="center">收入单号</th>
										<th class="center">客户编号</th>
										<th class="center">通道编号</th>
										<th class="center">交易费率</th>
										<th class="center">客户本人费率</th>
										<th class="center">收入类型</th>
										<th class="center">交易金额</th>
										<th class="center">收入金额</th>
										<th class="center">收入日期</th>
										<th class="center">交易客户</th>
										<th class="center">订单编号</th>
									</tr>
								</thead>
								<tbody>
								<c:choose>
									<c:when test="${not empty page.records}">
										<c:forEach items="${page.records}" var="customerProfit" varStatus="vs">
											<tr>
												<td class='center'>${vs.count}</td>
												<td class='center'>${customerProfit.profitNo}</td>
												<td class='center'>${customerProfit.cutomerId}</td>
												<td class='center'>${customerProfit.channelId}</td>
												<td class='center'>${customerProfit.tradeRate}</td>
												<td class='center'>${customerProfit.customerRate}</td>
												<td class='center'>
													<systab:codeDictionary codeType="customerProfitType" codeKey="${customerProfit.type}">${codeDictionary.codeValue}</systab:codeDictionary>
												</td>
												<td class='center'>${customerProfit.tradeAmt}</td>
												<td class='center'>${customerProfit.profitAmt}</td>
												<td class='center'>${customerProfit.profitDate}</td>
												<td class='center'>${customerProfit.tradeCustomerId}</td>
												<td class='center'>${customerProfit.orderId}</td>
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

