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
						<form action="brand/queryList.do" action="<%=basePath%>brand/queryList.do" method="post" name="listForm" id="listForm">
							<table>
								<tr>
									<td style="vertical-align:top;"> 
									 	<select class="chzn-select" name="status" id="status" data-placeholder="请选择" style="vertical-align:top;width: 120px;">
											<option value="">全部</option>
												<systab:codeDictionary codeType="brandStatus" codeKey="all">
												<option value="${codeDictionary.codeKey}" ${codeDictionary.codeKey == brand.status ? 'selected' : ''}>${codeDictionary.codeValue}</option>
												</systab:codeDictionary>
									  	</select>
										<input type="text" name="brandNo" value="${brand.brandNo}" placeholder="请输入品牌编号"/>
										<input type="text" name="brandName" value="${brand.brandName}" placeholder="请输入品牌名称"/>
	                        			<button type="submit" class='btn btn-mini btn-info btn-rbg' style="margin-top:0" >查询</button>
										<a class='btn btn-mini btn-info' href="<%=basePath%>brand/toAdd.do">创建品牌</a>
									</td>
								</tr>
							</table>
							<table id="listTable" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th class="center">序号</th>
										<th class="center">品牌编号</th>
										<th class="center">品牌名称</th>
										<th class="center">公司名称</th>
										<th class="center">公司地址</th>
										<th class="center">法人代表</th>
										<th class="center">联系电话</th>
										<th class="center">状态</th>
										<th class="center">操作</th>
									</tr>
								</thead>
								<tbody>
								<c:choose>
									<c:when test="${not empty page.records}">
										<c:forEach items="${page.records}" var="brand" varStatus="vs">
											<tr>
												<td class='center'>${vs.count}</td>
												<td class='center'>${brand.brandNo}</td>
												<td class='center'>${brand.brandName}</td>
												<td class='center'>${brand.fullName}</td>
												<td class='center'>${brand.address}</td>
												<td class='center'>${brand.president}</td>
												<td class='center'>${brand.phone}</td>
												<td class='center'>
												<systab:codeDictionary codeType="brandStatus" codeKey="${brand.status}">${codeDictionary.codeValue}</systab:codeDictionary>
												</td>
												<td class='center'>
													<a class='btn btn-mini btn-info' href="<%=basePath%>brand/toUpdate.do?id=${brand.id}">修改</a>
													<a class='btn btn-mini btn-info' href="<%=basePath%>customerDefaultRate/queryList.do?brandId=${brand.id}">客户费率模板</a>
													<a class='btn btn-mini btn-info' href="<%=basePath%>companyDefaultRate/queryList.do?brandId=${brand.id}">公司费率模板</a>
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

