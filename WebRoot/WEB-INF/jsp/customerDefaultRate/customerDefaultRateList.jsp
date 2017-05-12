<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="../system/admin/top.jsp"%>
		<script type="text/javascript">
		function deleteChannel(id,brandId) {
			bootbox.confirm("确定删除吗？", function(result) {
				if(result) {
					window.location.href = "<%=basePath%>customerDefaultRate/delete.do?id=" + id + "&brandId=" + brandId;
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
						<form action="customerDefaultRate/queryList.do" method="post" name="listForm" id="listForm">
							<input type="hidden" name="brandId" value="${customerDefaultRate.brandId}">
							<table>
								<tr>
									<td> 
										<a class='btn btn-mini btn-info' href="<%=basePath%>customerDefaultRate/toAdd.do?brandId=${customerDefaultRate.brandId}">新增</a>
										<a type="button" class="btn btn-mini btn-danger" href="<%=basePath%>brand/queryList.do">返回</a>
									</td>
								</tr>
							</table>
							<table id="listTable" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th class="center">序号</th>
										<th class="center">品牌</th>
										<th class="center">客户类型</th>
										<th class="center">客户类型名称</th>
										<th class="center">所属通道</th>
										<th class="center">条件</th>
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
										<c:forEach items="${page.records}" var="customerDefaultRate" varStatus="vs">
											<tr>
												<td class='center'>${vs.count}</td>
												<td class='center'>${customerDefaultRate.brandName}</td>
												<td class='center'>${customerDefaultRate.customerType}</td>
												<td class='center'>${customerDefaultRate.customerTypeName}</td>
												<td class='center'>${customerDefaultRate.channelName}</td>
												<td class='center'>${customerDefaultRate.upgradeCondition}</td>
												<td class='center'>${customerDefaultRate.tradeRate}</td>
												<td class='center'>${customerDefaultRate.normalFee}</td>
												<td class='center'>${customerDefaultRate.nightFee}</td>
												<td class='center'>${customerDefaultRate.holidayFee}</td>
												<td class='center'>${customerDefaultRate.cashMax}</td>
												<td class='center'>
													<a class='btn btn-mini btn-info' href="<%=basePath%>customerDefaultRate/toUpdate.do?id=${customerDefaultRate.id}">修改</a>
													<a type="button" class="btn btn-mini btn-danger" onclick="deleteChannel('${customerDefaultRate.id}', '${customerDefaultRate.brandId}');">删除</a>
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

