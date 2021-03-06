<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="../system/admin/top.jsp"%>
	</head>
	<body>
		<form action="<%=basePath%>company/update.do" name="updateForm" id="updateForm" method="post">
			<input type="hidden" name="id" value="${company.id}"/>
			<div id="zhongxin">
				<table id="table_report" class="table table-striped table-bordered table-hover">
					<tr>
						<td style="width:70px;text-align: right;padding-top: 13px;">公司编号:</td>
						<td><input type="text" name="companyNo" value="${company.companyNo}"/></td>
						<td style="width:70px;text-align: right;padding-top: 13px;">公司简称:</td>
						<td><input type="text" name="shortName" value="${company.shortName}"/></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">公司名称:</td>
						<td><input type="text" name="fullName" value="${company.fullName}"/></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">法人代表:</td>
						<td><input type="text" name="president" value="${company.president}"/></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">联系电话:</td>
						<td><input type="text" name="phone" value="${company.phone}"/></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">公司地址:</td>
						<td><input type="text" name="address" value="${company.address}"/></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">公司网址:</td>
						<td><input type="text" name="url" value="${company.url}"/></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">公司logo:</td>
						<td><input type="text" name="logo" value="${company.logo}"/></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">公司类型:</td>
						 	<td> 
					    	<select name=type id="type" class="chzn-select" data-placeholder="请选择公司类型"
								 style="vertical-align:top;width: 220px;" title="公司类型">
								<option value=""></option>
								<systab:codeDictionary codeType="companyType" codeKey="all">
									<option value="${codeDictionary.codeKey}" ${codeDictionary.codeKey == company.type ? 'selected' : ''}>${codeDictionary.codeValue}</option>
								</systab:codeDictionary>
							</select>
						</td>
						<td style="width:120px;text-align: right;padding-top: 13px;">上级公司编号:</td>
						<td><input type="text" name="parentCompanyId" value="${company.parentCompanyId}"/></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">公司状态:</td>
						 	<td> 
					    	<select name="status" id="status" class="chzn-select" data-placeholder="请选择公司状态"
								 style="vertical-align:top;width: 220px;" title="公司状态">
								<option value=""></option>
								<systab:codeDictionary codeType="companyStatus" codeKey="all">
									<option value="${codeDictionary.codeKey}" ${codeDictionary.codeKey == company.status ? 'selected' : ''}>${codeDictionary.codeValue}</option>
								</systab:codeDictionary>
							</select>
						</td>
						<td style="width:120px;text-align: right;padding-top: 13px;">品牌id:</td>
						<td><input type="text" name="brandId" value="${company.brandId}"/></td>
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