<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="../system/admin/top.jsp"%>
		<script type="text/javascript">
			function deleteCompanyDefaultRate(id,brandId) {
				bootbox.confirm("确定删除吗？", function(result) {
					if(result) {
						window.location.href = "<%=basePath%>companyDefaultRate/delete.do?id=" + id + "&brandId=" + brandId;
					}
				});
			}
		</script>
	</head>
	<body>
		<div class="container-fluid" id="main-container">
			<div id="page-content" class="clearfix">
			  <div class="row-fluid">
					<div class="row-fluid">
						<form action="companyDefaultRate/queryList.do" method="post" name="listForm" id="listForm">
							<input type="hidden" name="brandId" value="${companyDefaultRate.brandId}">
							<table>
								<tr>
									<td class='center'>
										<a class='btn btn-mini btn-info' href="<%=basePath%>companyDefaultRate/toAdd.do?brandId=${companyDefaultRate.brandId}">增加</a>
										<a class="btn btn-mini btn-danger" href="<%=basePath%>brand/queryList.do">返回</a>
									</td>
								</tr>
							</table>
							<table id="listTable" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th class="center">序号</th>
										<th class="center">品牌</th>
										<th class="center">所属通道</th>
										<th class="center">公司类型</th>
										<th class="center">公司类型名称</th>
										<th class="center">交易费率</th>
										<th class="center">正常结算费用</th>
										<th class="center">晚间结算费用</th>
										<th class="center">节假日结算费用</th>
										<th class="center">结算上限</th>
										<th class="center">操作</th>
									</tr>
								</thead>
								<tbody>
								<c:choose>
									<c:when test="${not empty page.records}">
										<c:forEach items="${page.records}" var="companyDefaultRate" varStatus="vs">
											<tr>
												<td class='center' >${vs.count}</td>
												<td class='center'>${companyDefaultRate.brandName}</td>
												<td class='center'>${companyDefaultRate.channelName}</td>
												<td class='center'>${companyDefaultRate.companyType}</td>
												<td class='center'>${companyDefaultRate.companyTypeName}</td>
												<td class='center'>${companyDefaultRate.tradeRate}</td>
												<td class='center'>${companyDefaultRate.normalFee}</td>
												<td class='center'>${companyDefaultRate.nightFee}</td>
												<td class='center'>${companyDefaultRate.holidayFee}</td>
												<td class='center'>${companyDefaultRate.cashMax}</td>
												<td class='center'>
													<a class='btn btn-mini btn-info' href="<%=basePath%>companyDefaultRate/toUpdate.do?id=${companyDefaultRate.id}">修改</a>
													<a type="button" class="btn btn-mini btn-danger" onclick="deleteCompanyDefaultRate('${companyDefaultRate.id}', '${companyDefaultRate.brandId}');">删除</a>
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

