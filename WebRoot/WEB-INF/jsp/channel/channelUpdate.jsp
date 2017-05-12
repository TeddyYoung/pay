<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="../system/admin/top.jsp"%>
	</head>
	<body>
		<form action="<%=basePath%>channel/update.do" name="addForm" id="addForm" method="post">
			<input type="hidden" name="id" value="${channel.id}"/>
			<div id="zhongxin">
				<table id="table_report" class="table table-striped table-bordered table-hover">
					<tr>
						<td style="width:70px;text-align: right;padding-top: 13px;">通道编号:</td>
						<td><input type="text" name="channelNo" value="${channel.channelNo}"/></td>
						<td style="width:70px;text-align: right;padding-top: 13px;">通道名称:</td>
						<td><input type="text" name="channelName" value="${channel.channelName}"/></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">logo图片id:</td>
						<td><input type="text" name="logoPictureId" value="${channel.logoPictureId}"/></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">交易费率:</td>
						<td><input type="text" name="tradeRate" value="${channel.tradeRate}"/></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">正常结算费用:</td>
						<td><input type="text" name="normalFee" value="${channel.normalFee}"/>元</td>
						<td style="width:120px;text-align: right;padding-top: 13px;">晚间结算费用:</td>
						<td><input type="text" name="nightFee" value="${channel.nightFee}"/>元</td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">节假日结算费用:</td>
						<td><input type="text" name="holidayFee" value="${channel.holidayFee}"/>元</td>
						<td style="width:120px;text-align: right;padding-top: 13px;">结算上限:</td>
						<td><input type="text" name="cashMax" value="${channel.cashMax}"/>元</td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">通道类型:</td>
					   	<td> 
					    	<select name="type" id="type" class="chzn-select" data-placeholder="请选择通道类型"
								 style="vertical-align:top;width: 220px;" title="通道类型">
								<option value=""></option>
								<systab:codeDictionary codeType="channelType" codeKey="all">
									<option value="${codeDictionary.codeKey}" ${codeDictionary.codeKey == channel.type ? 'selected' : ''}>${codeDictionary.codeValue}</option>
								</systab:codeDictionary>
							</select>
						</td>
						<td style="width:120px;text-align: right;padding-top: 13px;">第三方结算周期:</td>
						<td><input type="text" name="settleDayThird" value="${channel.settleDayThird}"/></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">本系统结算周期:</td>
						<td><input type="text" name="settleDay" value="${channel.settleDay}"/></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">是否人工结算:</td>
					   	<td>
							<select name="settleType" id="settleType" class="chzn-select" data-placeholder="请选择"
								 style="vertical-align:top;width: 220px;" title="是否人工结算">
								<option value=""></option>
								<systab:codeDictionary codeType="indicator" codeKey="all">
									<option value="${codeDictionary.codeKey}" ${codeDictionary.codeKey == channel.settleType ? 'selected' : ''}>${codeDictionary.codeValue}</option>
								</systab:codeDictionary>
							</select>
						</td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">通道状态:</td>
					   	<td> 
					    	<select name="status" id="status" class="chzn-select" data-placeholder="请选择通道状态"
								 style="vertical-align:top;width: 220px;" title="通道状态">
								<option value=""></option>
								<systab:codeDictionary codeType="channelStatus" codeKey="all">
									<option value="${codeDictionary.codeKey}" ${codeDictionary.codeKey == channel.status ? 'selected' : ''}>${codeDictionary.codeValue}</option>
								</systab:codeDictionary>
							</select>
						</td>
						<td style="width:120px;text-align: right;padding-top: 13px;">通道简介:</td>
						<td><input type="text" name="channelDesc" value="${channel.channelDesc}"/></td>
					</tr>
					<tr>
						<td style="text-align: center;" colspan="10">
							<button type="submit" class="btn btn-mini btn-primary">保存</button>
							<button type="button" class="btn btn-mini btn-danger" onclick="javascript:history.go(-1);">返回</button>
						</td>
					</tr>
				</table>
			</div>
		</form>
	</body>
</html>