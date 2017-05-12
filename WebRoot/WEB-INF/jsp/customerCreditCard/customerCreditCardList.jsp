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
						<form action="customerCreditCard/queryList.do" method="post" name="listForm" id="listForm">
							<input type="hidden" name="customerId" value="${customerCreditCard.customerId}">
							<table>
								<tr>
									<td style="vertical-align:top;">
										<a type="button" class="btn btn-mini btn-danger" href="<%=basePath%>customer/queryList.do">返回</a>
									</td>
								</tr>
							</table>
							<table id="listTable" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th class="center">序号</th>
										<th class="center">客户编号</th>
										<th class="center">开户银行</th>
										<th class="center">信用卡卡号</th>
										<th class="center">信用卡户名</th>
										<th class="center">信用卡cvv2码</th>
										<th class="center">信用卡有限期</th>
									</tr>
								</thead>
								<tbody>
								<c:choose>
									<c:when test="${not empty page.records}">
										<c:forEach items="${page.records}" var="customerCreditCard" varStatus="vs">
											<tr>
												<td class='center' style="width: 30px;">${vs.index+1}</td>
												<td class='center'>${customerCreditCard.customerId}</td>
												<td class='center'>${customerCreditCard.depositBank}</td>
												<td class='center'>${customerCreditCard.cardNo}</td>
												<td class='center'>${customerCreditCard.cardName}</td>
												<td class='center'>${customerCreditCard.cardCvv}</td>
												<td class='center'>${customerCreditCard.cardMonth}</td>
<!-- 												<td class='center'> -->
<%-- 													<a class='btn btn-mini btn-info' href="<%=basePath%>brand/toUpdate.do?id=${customerCreditCard.id}">修改</a> --%>
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

