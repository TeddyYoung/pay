<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="../system/admin/top.jsp"%>
		<script type="text/javascript">
			function deleteChannel(id) {
				bootbox.confirm("确定删除吗？", function(result) {
					if(result) {
						window.location.href = "<%=basePath%>channel/delete.do?id=" + id;
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
						<form action="channel/queryList.do" method="post" name="listForm" id="listForm">
							<table>
								<tr>
									<td style="vertical-align:top;">
										<a class='btn btn-mini btn-info' href="<%=basePath%>channel/toAdd.do">新增</a>
									</td>
								</tr>
							</table>
							<table id="listTable" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th class="center">序号</th>
										<th class="center">Logo</th>
										<th class="center">通道编号</th>
										<th class="center">通道名称</th>
<!-- 									<th class="center">通道简介</th> -->
										<th class="center">交易费率</th>
										<th class="center">正常结算费用</th>
<!-- 										<th class="center">晚间结算费用</th> -->
<!-- 										<th class="center">节假日结算费用</th> -->
										<th class="center">结算上限</th>
										<th class="center">状态</th>
<!-- 										<th class="center">第三方结算周期</th> -->
<!-- 										<th class="center">本系统结算周期</th> -->
										<th class="center">是否人工结算</th>
										<th class="center">类型</th>
										<th class="center">操作</th>
									</tr>
								</thead>
								<tbody>
								<c:choose>
									<c:when test="${not empty page.records}">
										<c:forEach items="${page.records}" var="channel" varStatus="vs">
											<tr>
												<td class="center">${vs.count}</td>
												<td class='center'>${channel.logoPictureId}</td>
												<td class='center'>${channel.channelNo}</td>
												<td class='center'>${channel.channelName}</td>
<%-- 												<td class='center'>${channel.channelDesc}</td> --%>
												<td class='center'>${channel.tradeRate}</td>
												<td class='center'>${channel.normalFee}</td>
<%-- 												<td class='center'>${channel.nightFee}</td> --%>
<%-- 												<td class='center'>${channel.holidayFee}</td> --%>
												<td class='center'>${channel.cashMax}</td>
												<td class='center'>
													<systab:codeDictionary codeType="channelStatus" codeKey="${channel.status}">${codeDictionary.codeValue}</systab:codeDictionary>
												</td>
<%-- 												<td class='center'>${channel.settleDayThird}</td> --%>
<%-- 												<td class='center'>${channel.settleDay}</td> --%>
												<td class='center'>
													<systab:codeDictionary codeType="indicator" codeKey="${channel.settleType}">${codeDictionary.codeValue}</systab:codeDictionary>
												</td>
												<td class='center'>
													<systab:codeDictionary codeType="channelType" codeKey="${channel.type}">${codeDictionary.codeValue}</systab:codeDictionary>
												</td>
												<td class='center'>
										
													<a class='btn btn-mini btn-info' href="<%=basePath%>channel/toUpdate.do?id=${channel.id}">修改</a>
													<a type="button" class="btn btn-mini btn-danger" onclick="deleteChannel('${channel.id}');">删除</a>
																<a class='btn btn-mini btn-info' href="<%=basePath%>channelPlugin/queryList.do?channelId=${channel.id}">配置</a>
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

