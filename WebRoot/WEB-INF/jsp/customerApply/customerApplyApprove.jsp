<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<%@ include file="../system/admin/top.jsp"%>
	</head>
	<body>
		<form action="t_khxx_sh_qd/${msg }.do" name="Form" id="Form" method="post">
			<input type="hidden" name="SHJG" id="SHJG" value=""/>
			<div id="zhongxin">
				<table id="table_report" class="table table-striped table-bordered table-hover">
					<tr>
						<td style="width:70px;text-align: right;padding-top: 13px;">审核编号:</td>
						<td><input type="text" name="SHBH" id="SHBH" value="${customerApply.id}" maxlength="32"/></td>
						<td style="width:70px;text-align: right;padding-top: 13px;">被审核客户编号:</td>
						<td><input type="text" name="KHBH" id="KHBH" value="${customerApply.id}" maxlength="32"/></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">客户名称:</td>
						<td><input type="text" name="KHMC" id="KHMC" value="${customerApply.id}" maxlength="32"/></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">绑定手机号:</td>
						<td><input type="text" name="BDSJH" id="BDSJH" value="${customerApply.id}" maxlength="32"/></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">身份证号码:</td>
						<td><input type="text" name="SFZH" id="SFZH" value="${customerApply.id}" maxlength="32"/></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">客户类型:</td>
						<c:if test="${customerApply.id=='1'}">
						<td><input type="text" name="YHHM6" id="YHHM6" value="代理公司总后台" maxlength="32"/></td>
						</c:if>
						<c:if test="${customerApply.id=='2'}">
						<td><input type="text" name="YHHM1" id="YHHM1" value="代理子公司总后台" maxlength="32"/></td>
						</c:if>
						<c:if test="${customerApply.id=='3'}">
						<td><input type="text" name="YHHM2" id="YHHM2" value="一级代理商" maxlength="32"/></td>
						</c:if>
						<c:if test="${customerApply.id=='4'}">
						<td><input type="text" name="YHHM3" id="YHHM3" value="二级代理商" maxlength="32"/></td>
						</c:if>
						<c:if test="${customerApply.id=='5'}">
						<td><input type="text" name="YHHM4" id="YHHM4" value="三级代理商" maxlength="32"/></td>
						</c:if>
						<c:if test="${customerApply.id=='6'}">
						<td><input type="text" name="YHHM5" id="YHHM5" value="终端客户" maxlength="32"/></td>
						</c:if>
					</tr>
					<!-- 
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">身份证地址:</td>
						<td><input type="text" name="SFZDZ" id="SFZDZ" value="${pd.SFZDZ}" maxlength="32"/></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">开户行所在省:</td>
						<td><input type="text" name="KHHSZSF" id="KHHSZSF" value="${pd.KHHSZSF}" maxlength="32"/></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">开户行所在市:</td>
						<td><input type="text" name="KHHSZCS" id="KHHSZCS" value="${pd.KHHSZCS}" maxlength="32"/></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">开户银行:</td>
						<td><input type="text" name="KHYH" id="KHYH" value="${pd.KHYH}" maxlength="32"/></td>
					</tr>
					
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">开户行名称:</td>
						<td><input type="text" name="KHHMC" id="KHHMC" value="${pd.KHHMC}" maxlength="32"/></td>
						<td style="width:120px;text-align: right;padding-top: 13px;">银行帐号:</td>
						<td><input type="text" name="YHZH" id="YHZH" value="${pd.YHZH}" maxlength="32"/></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">银行户名:</td>
						<td><input type="text" name="YHHM" id="YHHM" value="${pd.YHHM}" maxlength="32"/></td>
					</tr>
					 -->
					<tr>
						<td style="width:70px;text-align: right;padding-top: 13px;">审核意见:</td>
						<td><input type="text" name="SHYJ" id="SHYJ" value="${customerApply.id}" maxlength="32" placeholder="这里输入审核意见" title="审核意见"/></td>
						<td style="width:70px;text-align: right;padding-top: 13px;"></td>
						<td></td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">身份证正面照:</td>
						<td>
							<c:if test="${customerApply != null && customerApply.id != '' && customerApply.id != null }">
								<a href="http://120.26.206.74:8001/mpay/TP/${customerApply.id}" target="_blank"><img src="http://120.26.206.74:8001/hrtxmpay/TP/${pd.SFZ_ZMZ}" width="210"/></a>
							</c:if>
						</td>
						<td style="width:120px;text-align: right;padding-top: 13px;">手持身份证半身照:</td>
					    <td>
							<c:if test="${customerApply != null && customerApply.id != '' && customerApply.id != null }">
								<a href="http://120.26.206.74:8001/mpay/TP/${customerApply.id}" target="_blank"><img src="http://120.26.206.74:8001/hrtxmpay/TP/${pd.SFZ_ZMZ}" width="210"/></a>
							</c:if>
						</td>
					</tr>
					<tr>
						<td style="width:120px;text-align: right;padding-top: 13px;">第三方返回身份证照片:</td>
						<td>
							<c:if test="${customerApply != null && customerApply.id != '' && customerApply.id != null }">
								<a href="http://120.26.206.74:8001/mpay/TP/${customerApply.id}" target="_blank"><img src="http://120.26.206.74:8001/hrtxmpay/TP/${pd.SFZ_ZMZ}" width="210"/></a>
							</c:if>
						</td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td style="text-align: center;" colspan="10">
<!-- 							<a class="btn btn-mini btn-success" onclick="verify();">身份认证</a> -->
							<a class="btn btn-mini btn-primary" onclick="save(1);">审核通过</a>
							<a class="btn btn-mini btn-warning" onclick="save(2);">审核不通过</a>
							<a class="btn btn-mini btn-danger" onclick="javascript:history.go(-1);">返回</a>
						</td>
					</tr>
				</table>
			</div>
		</form>
	</body>
</html>