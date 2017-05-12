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
						<form action="companyProfit/queryList.do" method="post" name="listForm" id="listForm">
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
									</td>
								</tr>
							</table>
							<table id="listTable" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th class="center">序号</th>
										<th class="center">收入单号</th>
										<th class="center">公司编号</th>
										<th class="center">通道编号</th>
										<th class="center">交易费率</th>
										<th class="center">公司费率</th>
										<th class="center">收入类型</th>
										<th class="center">交易金额</th>
										<th class="center">收入金额</th>
										<th class="center">收入日期</th>
										<th class="center">贡献人客户编号</th>
									</tr>
								</thead>
								<tbody>
								<c:choose>
									<c:when test="${not empty page.records}">
										<c:forEach items="${page.records}" var="companyProfit" varStatus="vs">
											<tr>
												<td class='center'>${vs.count}</td>
												<td class='center'>${companyProfit.profitNo}</td>
												<td class='center'>${companyProfit.companyId}</td>
												<td class='center'>${companyProfit.channelId}</td>
												<td class='center'>${companyProfit.tradeRate}</td>
												<td class='center'>${companyProfit.companyRate}</td>
												<td class='center'>${1==companyProfit.type?'分润收成':2==companyProfit.type?'提现收成':''}</td>
												<td class='center'>${companyProfit.tradeAmt}</td>
												<td class='center'>${companyProfit.profitAmt}</td>
<%-- 												<td class='center'>${companyProfit.profitDate}</td> --%>
												<td class='center'>${companyProfit.tradeCustomerId}</td>
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

