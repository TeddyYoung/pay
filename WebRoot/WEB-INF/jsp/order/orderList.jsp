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
						<form action="order/queryList.do" method="post" name="listForm" id="listForm">
							<table>
								<tr>
								<td style="vertical-align: top;">
		                            	<input type="text" name="orderNo" value="${order.orderNo}" placeholder="请输入订单号"/>
	                        			<button type="submit" class='btn btn-mini btn-info btn-rbg' style="margin-top:0" >查询</button>
									</td>
								</tr>
							</table>
							<table id="listTable" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th class="center">序号</th>
										<th class="center">订单号</th>
										<th class="center">客户编号</th>
										<th class="center">通道编号</th>
										<th class="center">交易费率</th>
										<th class="center">结算费用</th>
										<th class="center">结算上限</th>
										<th class="center">交易金额</th>
										<th class="center">实得金额</th>
										<th class="center">交易时间</th>
										<th class="center">订单状态</th>
									</tr>
								</thead>
								<c:choose>
									<c:when test="${not empty page.records}">
										<c:forEach items="${page.records}" var="order" varStatus="vs">
											<tr>
													<td class="center">${vs.count}</td>
												<td class='center'>${order.orderNo}</td>
												<td class='center'>${order.customerId}</td>
												<td class='center'>${order.channelId}</td>
												<td class='center'>${order.tradeFeeRate}</td>
												<td class='center'>${order.settleFeeNormal}</td>
												<td class='center'>${order.settleMax}</td>
												<td class='center'>${order.tradeAmt}</td>
												<td class='center'>${order.takeAmt}</td>
												<td class='center'><fmt:formatDate pattern="yyyy-MM-dd"  value="${order.tradeTime}"/></td>
												<td class='center'>
													<systab:codeDictionary codeType="orderTradeStatus" codeKey="${order.tradeStatus}">${codeDictionary.codeValue}</systab:codeDictionary>
												</td>
<!-- 												<td class='center'> -->
<%-- 													<a class='btn btn-mini btn-info' href="<%=basePath%>order/toUpdate.do?id=${order.id}">修改</a> --%>
<!-- 												</td> -->
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<tr class="main_info">
											<td colspan="100" class="center" >没有相关数据</td>
										</tr>
									</c:otherwise>
								</c:choose>
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

