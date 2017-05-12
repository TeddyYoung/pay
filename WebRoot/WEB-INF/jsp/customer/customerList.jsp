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
						<form action="customer/queryList.do" method="post" name="listForm" id="listForm">
							
							<table id="listTable" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th class="center">序号</th>
										<th class="center">品牌</th>
										<th class="center">所属公司</th>
										<th class="center">客户编号</th>
										<th class="center">真实姓名</th>
										<th class="center">客户昵称</th>
										<th class="center">绑定手机号</th>
										<th class="center">身份证号码</th>
<!-- 										<th class="center">身份证地址</th> -->
<!-- 										<th class="center">身份证正面照ID</th> -->
<!-- 										<th class="center">身份证反面照ID</th> -->
<!-- 										<th class="center">手持身份证半身照ID</th> -->
										<th class="center">推荐人客户编号</th>
<!-- 										<th class="center">登陆密码</th> -->
<!-- 										<th class="center">支付密码</th> -->
										<th class="center">客户类型</th>
<!-- 										<th class="center">是否代理商</th> -->
										<th class="center">客户状态</th>
										<th class="center">操作</th>
									</tr>
								</thead>
								<tbody>
								<c:choose>
									<c:when test="${not empty page.records}">
										<c:forEach items="${page.records}" var="customer" varStatus="vs">
											<tr>
												<td class='center' >${vs.count}</td>
												<td class='center'>${customer.brandName}</td>
												<td class='center'>${customer.fullName}</td>
												<td class='center'>${customer.customerNo}</td>
												<td class='center'>${customer.realName}</td>
												<td class='center'>${customer.nickName}</td>
												<td class='center'>${customer.phone}</td>
												<td class='center'>${customer.idcardNo}</td>
<%-- 												<td class='center'>${customer.idcardAddress}</td> --%>
<%-- 												<td class='center'>${customer.idcardFrontPictureId}</td> --%>
<%-- 												<td class='center'>${customer.idcardBackPictureId}</td> --%>
<%-- 												<td class='center'>${customer.idcardHalfPictureId}</td> --%>
												<td class='center'>${customer.parentCustomerId}</td>
<%-- 												<td class='center'>${customer.loginPassword}</td> --%>
<%-- 												<td class='center'>${customer.payPassword}</td> --%>
												<td class='center'>
													<systab:codeDictionary codeType="customerType" codeKey="${customer.type}">${codeDictionary.codeValue}</systab:codeDictionary>
												</td>
<!-- 												<td class='center'> -->
<%-- 													<systab:codeDictionary codeType="customerIsCompany" codeKey="${customer.isCompany}">${codeDictionary.codeValue}</systab:codeDictionary> --%>
<!-- 												</td> -->
												<td class='center'>
													<systab:codeDictionary codeType="customerStatus" codeKey="${customer.status}">${codeDictionary.codeValue}</systab:codeDictionary>
												</td>
												
												
													<td class='center'>
														<a class='btn btn-mini btn-info btn-rbg' style="margin-top:0" 
																href="<%=basePath%>customerBankCard/queryList.do?customerId=${customer.id}">银行卡</a>
														<a class='btn btn-mini btn-info btn-rbg' style="margin-top:0" 
																href="<%=basePath%>customerCreditCard/queryList.do?customerId=${customer.id}">信用卡</a>
																<a class='btn btn-mini btn-info btn-rbg' style="margin-top:0" 
																href="<%=basePath%>customerRate/queryList.do?customerId=${customer.id}">费率</a>
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

