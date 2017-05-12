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
						<form action="customerBankCard/queryList.do" method="post" name="listForm" id="listForm">
						<input type="hidden" name="customerId" value="${customerBankCard.customerId}">
							<table>
								<tr>
									<td>
										<a type="button" class="btn btn-mini btn-danger" href="<%=basePath%>customer/queryList.do">返回</a>
									</td>
								</tr>
							</table>
							<table id="listTable" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th class="center">序号</th>
										<th class="center">客户编号</th>
										<th class="center">开户行所在省</th>
										<th class="center">开户行所在市</th>
										<th class="center">开户银行</th>
										<th class="center">开户行名称</th>
										<th class="center">银行帐号</th>
										<th class="center">银行户名</th>
										<th class="center">是否主卡</th>
									</tr>
								</thead>
								<tbody>
								<c:choose>
									<c:when test="${not empty page.records}">
										<c:forEach items="${page.records}" var="customerBankCard" varStatus="vs">
											<tr>
												<td class='center' style="width: 30px;">${vs.index+1}</td>
												<td class='center'>${customerBankCard.customerId}</td>
												<td class='center'>${customerBankCard.province}</td>
												<td class='center'>${customerBankCard.city}</td>
												<td class='center'>${customerBankCard.deposit}</td>
												<td class='center'>${customerBankCard.bankName}</td>
												<td class='center'>${customerBankCard.cardNo}</td>
												<td class='center'>${customerBankCard.name}</td>
												<td class='center'>
													<systab:codeDictionary codeType="customerBankCardDefaultFlag" codeKey="${customerBankCard.defaultFlag}">${codeDictionary.codeValue}</systab:codeDictionary>
												</td>
<!-- 												<td class='center'> -->
<%-- 													<a class='btn btn-mini btn-info' href="<%=basePath%>customerBankCard/toUpdate.do?id=${customerBankCard.id}">修改</a> --%>
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

