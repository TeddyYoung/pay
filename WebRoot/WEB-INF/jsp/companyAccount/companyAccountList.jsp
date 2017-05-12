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
						<form action="companyAccount/queryList.do" method="post" name="listForm" id="listForm">
							<table>
								<tr>
									<td style="vertical-align:top;"> 
									 	<select class="chzn-select" name="field2" id="field2" data-placeholder="请选择" style="vertical-align:top;width: 120px;">
											<option value="">全部</option>
											<option value="1">PC通道</option>
											<option value="2">手机通道</option>
									  	</select>
									</td>
									<td style="vertical-align:top;">
										<button class="btn btn-mini btn-light" type="submit"  title="检索">
											<i id="nav-search-icon" class="icon-search"></i>
										</button>
								</tr>
							</table>
							<table id="listTable" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th class="center">序号</th>
										<th class="center">所属客户ID</th>
										<th class="center">账户余额</th>
										<th class="center">分润余额</th>
										<th class="center">冻结余额</th>
										<th class="center">可用余额</th>
										<th class="center">账户类型</th>
										<th class="center">币种</th>
										<th class="center">操作</th>
									</tr>
								</thead>
								<tbody>
								<c:choose>
									<c:when test="${not empty page.records}">
										<c:forEach items="${page.records}" var="companyAccount" varStatus="vs">
											<tr>
												<td class='center'>${vs.count}</td>
												<td class='center'>${companyAccount.companyId}</td>
												<td class='center'>${companyAccount.balanceAmt}</td>
												<td class='center'>${companyAccount.profitAmt}</td>
												<td class='center'>${companyAccount.freezeAmt}</td>
												<td class='center'>${companyAccount.avaliableAmt}</td>
												<td class='center'>${companyAccount.type}</td>
												<td class='center'>${companyAccount.currency}</td>
												<td class='center'>
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
