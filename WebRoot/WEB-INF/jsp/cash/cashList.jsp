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
						<form action="cash/queryList.do" method="post" name="listForm" id="listForm">
							<table>
								<tr>
									<td style="vertical-align:top;">
										&nbsp;&nbsp;									
									</td>
								</tr>
							</table>
							<table id="listTable" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th class="center">序号</th>
										<th class="center">体现单号</th>
										<th class="center">客户编号</th>
										<th class="center">交易费率</th>
										<th class="center">结算费用手续费</th>
										<th class="center">结算上限</th>
										<th class="center">提现金额</th>
										<th class="center">结算方式</th>
										<th class="center">结算状态</th>
										<th class="center">申请日期</th>
										<th class="center">处理人</th>
										<th class="center">处理日期</th>
										<th class="center">开户银行</th>
										<th class="center">开户行名称</th>
										<th class="center">银行帐号</th>
										<th class="center">银行户名</th>
										<th class="center">操作</th>
									</tr>
								</thead>
								<tbody>
								<c:choose>
									<c:when test="${not empty page.records}">
										<c:forEach items="${page.records}" var="cash" varStatus="vs">
											<tr>
												<td class="center">${vs.count}</td>
												<td class='center'>${cash.cashNo}</td>
												<td class='center'>${cash.customerId}</td>
												<td class='center'>${cash.tradeRate}</td>
												<td class='center'>${cash.cashFee}</td>
												<td class='center'>${cash.cashMax}</td>
												<td class='center'>${cash.cashAmt}</td>
												<td class='center'>
													<systab:codeDictionary codeType="cashType" codeKey="${cash.cashType}">${codeDictionary.codeValue}</systab:codeDictionary>
												</td>
												<td class='center'>
													<systab:codeDictionary codeType="cashStatus" codeKey="${cash.status}">${codeDictionary.codeValue}</systab:codeDictionary>
												</td>
												<td class='center'>${cash.applyDate}</td>
												<td class='center'>${cash.dealUserId}</td>
												<td class='center'>${cash.dealDate}</td>
												<td class='center'>${cash.depositBank}</td>
												<td class='center'>${cash.bankName}</td>
												<td class='center'>${cash.accountNo}</td>
												<td class='center'>${cash.name}</td>
<!-- 												<td class='center'> -->
<%-- 													<a class='btn btn-mini btn-info' href="<%=basePath%>cash/toUpdate.do?id=${cash.id}">修改</a> --%>
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

