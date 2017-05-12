<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="../system/admin/top.jsp"%>
	</head>
	<body id="wrapper">
		<div class="container-fluid" id="main-container">
			<div id="page-content" class="clearfix">
				<div class="row-fluid">
					<div class="row-fluid">
						<form action="company/queryList.do" method="post" name="listForm" id="listForm">
							<table>
								<tr>
									<td class='center'>
										<a class='btn btn-mini btn-info' href="<%=basePath%>company/toAdd.do">创建公司</a>
									</td>
								</tr>
							</table>
							<table id="listTable" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th class="center">序号</th>
										<th class="center">品牌</th>
										<th class="center">公司编号</th>
										<th class="center">公司简称</th>
										<th class="center">公司全称</th>
<!-- 										<th class="center">公司地址</th> -->
										<th class="center">法人代表</th>
										<th class="center">联系电话</th>
<!-- 										<th class="center">公司网址</th> -->
										<th class="center">公司logo</th>
<!-- 										<th class="center">上级公司类型</th> -->
										<th class="center">上级公司</th>
										<th class="center">状态</th>
										<th class="center">操作</th>
									</tr>
								</thead>
								<tbody>
								<c:choose>
									<c:when test="${not empty page.records}">
										<c:forEach items="${page.records}" var="company" varStatus="vs">
											<tr>
												<td class='center'>${vs.count}</td>
												<td class='center'>${company.brandName}</td>
												<td class='center'>${company.companyNo}</td>
												<td class='center'>${company.shortName}</td>
												<td class='center'>${company.fullName}</td>
<%-- 												<td class='center'>${company.address}</td> --%>
												<td class='center'>${company.president}</td>
												<td class='center'>${company.phone}</td>
<%-- 												<td class='center'>${company.url}</td> --%>
												<td class='center'>${company.logo}</td>
<!-- 												<td class='center'> -->
<%-- 													<systab:codeDictionary codeType="companyType" codeKey="${company.type}">${codeDictionary.codeValue}</systab:codeDictionary> --%>
<!-- 												</td> -->
												<td class='center'>${company.parentCompanyId}</td>
												<td class='center'>
													<systab:codeDictionary codeType="companyStatus" codeKey="${company.status}">${codeDictionary.codeValue}</systab:codeDictionary>
												</td>
												<td class='center'>
													<a class='btn btn-mini btn-info' href="<%=basePath%>company/toUpdate.do?id=${company.id}">修改</a>
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
