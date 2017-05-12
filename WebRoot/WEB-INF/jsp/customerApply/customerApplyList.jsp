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
							<table id="listTable" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th class="center">序号</th>
										<th class="center">被审核客户编号</th>
										<th class="center">客户类型</th>
										<th class="center">审核人</th>
										<th class="center">审核结果</th>
										<th class="center">审核时间</th>
										<th class="center">审核意见</th>
										<th class="center">操作</th>
									</tr>
								</thead>
								<tbody>
								<c:choose>
									<c:when test="${not empty page.records}">
										<c:forEach items="${page.records}" var="customerApply" varStatus="vs">
											<tr>
												<td class='center' style="width: 30px;">${vs.index+1}</td>
												<td class='center'>${customerApply.customerId}</td>
												<td class='center'>${customerApply.customerType}</td>
												<td class='center'>${customerApply.approveUserId}</td>
												<td class='center'>
													<systab:codeDictionary codeType="approveResult" codeKey="${customerApply.approveResult}">${codeDictionary.codeValue}</systab:codeDictionary>
												</td>
												<td class='center'><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${customerApply.approveTime}"/></td>
												<td class='center'>${customerApply.approveOpinion}</td>
												<td class='center'>
													<a class='btn btn-mini btn-info' href="<%=basePath%>customerApply/toApprove.do?id=${customerApply.id}">审核</a>
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

