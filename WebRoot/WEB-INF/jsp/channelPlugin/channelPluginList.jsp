<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="../system/admin/top.jsp"%>
		<script type="text/javascript">
			function deleteChannel(id, channelId) {
				bootbox.confirm("确定删除吗？", function(result) {
					if(result) {
						window.location.href = "<%=basePath%>channelPlugin/delete.do?id=" + id + "&channelId=" + channelId;
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
						<form action="channelPlugin/queryList.do" method="post" name="listForm" id="listForm">
							<input type="hidden" name="channelId" value="${channelPlugin.channelId}">
							<table>
								<tr>
									<td style="vertical-align:top;">
										<a class='btn btn-mini btn-info' href="<%=basePath%>channelPlugin/toAdd.do?channelId=${channelPlugin.channelId}">新增</a>
										<a type="button" class="btn btn-mini btn-danger" href="<%=basePath%>channel/queryList.do">返回</a>
									</td>
								</tr>
							</table>
							<table id="listTable" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th class="center">序号</th>
										<th class="center">配置名称</th>
										<th class="center">配置key</th>
										<th class="center">配置值</th>
										<th class="center">操作</th>
									</tr>
								</thead>
								<tbody>
								<c:choose>
									<c:when test="${not empty page.records}">
										<c:forEach items="${page.records}" var="channelPlugin" varStatus="vs">
											<tr>
												<td class="center">${vs.count}</td>
												<td class='center'>${channelPlugin.pluginName}</td>
												<td class='center'>${channelPlugin.pluginKey}</td>
												<td class='center'>${channelPlugin.pluginValue}</td>
												<td class='center'>
													<a class='btn btn-mini btn-info' href="<%=basePath%>channelPlugin/toUpdate.do?id=${channelPlugin.id}">修改</a>
													<a type="button" class="btn btn-mini btn-danger" onclick="deleteChannel('${channelPlugin.id}', '${channelPlugin.channelId}');">删除</a>
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

