<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>银联POS交易管理平台</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="renderer" content="webkit">
<link rel="stylesheet" href="static/login/bootstrap.min.css" />
<link rel="stylesheet" href="static/login/css/camera.css" />
<link rel="stylesheet" href="static/login/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="static/login/matrix-login.css" />
<link href="static/login/font-awesome.css" rel="stylesheet" />
<script type="text/javascript" src="static/js/jquery-1.5.1.min.js"></script>

</head>
<body style="background-image:url(<%=basePath%>static/login/images/banner_slide_01.jpg);background-size:cover;">
	<div style="width:100%;text-align: center;margin: 0 auto;position: absolute;">
		<div id="loginbox">
			<form action="login_login.do" method="post" name="loginForm" id="loginForm">
				<div class="control-group normal_text">
					<h3>
						<img src="<%=basePath%>static/login/logo.png" alt="Logo" />
					</h3>
				</div>
				<div class="control-group">
					<div class="controls">
						<div class="main_input_box">
							<span class="add-on bg_lg">
							<i><img height="37" src="static/login/user.png" /></i>
							</span><input type="text" name="loginname" id="loginname" placeholder="请输手机号" />
						</div>
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<div class="main_input_box">
							<span class="add-on bg_ly">
							<i><img height="37" src="static/login/suo.png" /></i>
							</span><input type="password" name="password" id="password" placeholder="请输入密码" />
						</div>
					</div>
				</div>
				<div style="text-align: -webkit-left; padding-left: 15px;">
	            	${flag}
	            </div>
				<div class="form-actions">
					<div style="width:86%;padding-left:8%;">

					  <div style="float: left; display:none">
							<i><img src="static/login/yan.png" /></i>
						</div>
						<div style="float: left; display:none" class="codediv">
							<input type="text" name="code" id="code" class="login_code" value="abcd"
								style="height:16px; padding-top:0px;" />
						</div>
						<div style="float: left; display:none">
							<i><img style="height:22px;" id="codeImg" alt="点击更换"
								title="点击更换" src="" /></i>
						</div>

						<span class="pull-right" style="padding-right:3%;"><a
							href="javascript:quxiao();" class="btn btn-success">取消</a></span> <span
							class="pull-right"><a onclick="severCheck();"
							class="flip-link btn btn-info" id="to-recover">登录</a></span>

					</div>
				</div>

			</form>


			<div class="controls">
				<div class="main_input_box">
					<font color="white"><span id="nameerr">银联POS交易管理平台 版权所有@2015</span></font>
				</div>
			</div>
		</div>
	</div>
 
<!--	<div id="templatemo_banner_slide" class="container_wapper">
		<div class="camera_wrap camera_emboss" id="camera_slide">
			<div data-src="static/login/images/banner_slide_01.jpg"></div>
			<div data-src="static/login/images/banner_slide_02.jpg"></div>
			<div data-src="static/login/images/banner_slide_03.jpg"></div>
		</div>-->
		<!-- #camera_wrap_3 -->
<!-- 	</div> -->

	<script type="text/javascript">
	
		//服务器校验
		function severCheck(){
			if(check()){
				$("#loginForm").submit();
// 				var loginname = $("#loginname").val();
// 				var password = $("#password").val();
				
// 				var code = "qq370891992fh"+loginname+",fh,"+password+"QQ8849878fh"+",fh,"+$("#code").val();
// 				$.ajax({
// 					type: "POST",
// 					url: 'login/login.do',
// 			    	data: {KEYDATA:code,tm:new Date().getTime()},
// 					dataType:'json',
// 					cache: false,
// 					success: function(data){
// 						if("success" == data.result){
// 							saveCookie();
// 							window.location.href="main/index";
// 						}else if("usererror" == data.result){
// 							$("#loginname").tips({
// 								side : 1,
// 								msg : "用户名或密码有误",
// 								bg : '#FF5080',
// 								time : 15
// 							});
// 							$("#loginname").focus();
// 						}else if("codeerror" == data.result){
// 							$("#code").tips({
// 								side : 1,
// 								msg : "验证码输入有误",
// 								bg : '#FF5080',
// 								time : 15
// 							});
// 							$("#code").focus();
// 						}else{
// 							$("#loginname").tips({
// 								side : 1,
// 								msg : "缺少参数",
// 								bg : '#FF5080',
// 								time : 15
// 							});
// 							$("#loginname").focus();
// 						}
// 					}
// 				});
			}
		}
	
		$(document).ready(function() {
			changeCode();
			$("#codeImg").bind("click", changeCode);
		});

		$(document).keyup(function(event) {
			if (event.keyCode == 13) {
				$("#to-recover").trigger("click");
			}
		});

		function genTimestamp() {
			var time = new Date();
			return time.getTime();
		}

		function changeCode() {
			$("#codeImg").attr("src", "code.do?t=" + genTimestamp());
		}

		//客户端校验
		function check() {

			if ($("#loginname").val() == "") {
				$("#loginname").tips({
					side : 2,
					msg : '手机号不得为空',
					bg : '#AE81FF',
					time : 3
				});
				
				$("#loginname").focus();
				return false;
			} else {
				if(isNaN(Number($("#loginname").val()))){
					$("#loginname").tips({
						side:3,
			            msg:'请输入手机号',
			            bg:'#AE81FF',
			            time:2
			        });
					$("#loginname").focus();
					return false;
				}
				$("#loginname").val(jQuery.trim($('#loginname').val()));
			}

			if ($("#password").val() == "") {

				$("#password").tips({
					side : 2,
					msg : '密码不得为空',
					bg : '#AE81FF',
					time : 3
				});

				$("#password").focus();
				return false;
			}
			if ($("#code").val() == "") {

				$("#code").tips({
					side : 1,
					msg : '验证码不得为空',
					bg : '#AE81FF',
					time : 3
				});

				$("#code").focus();
				return false;
			}

			$("#loginbox").tips({
				side : 1,
				msg : '正在登录 , 请稍后 ...',
				bg : '#68B500',
				time : 10
			});

			return true;
		}

		function savePaw() {
			if (!$("#saveid").attr("checked")) {
				$.cookie('loginname', '', {
					expires : -1
				});
				$.cookie('password', '', {
					expires : -1
				});
				$("#loginname").val('');
				$("#password").val('');
			}
		}

		function saveCookie() {
			if ($("#saveid").attr("checked")) {
				$.cookie('loginname', $("#loginname").val(), {
					expires : 7
				});
				$.cookie('password', $("#password").val(), {
					expires : 7
				});
			}
		}
		function quxiao() {
			$("#loginname").val('');
			$("#password").val('');
		}
		
		jQuery(function() {
			var loginname = $.cookie('loginname');
			var password = $.cookie('password');
			if (typeof(loginname) != "undefined"
					&& typeof(password) != "undefined") {
				$("#loginname").val(loginname);
				$("#password").val(password);
				$("#saveid").attr("checked", true);
				$("#code").focus();
			}
		});
	</script>
	<script>
		//TOCMAT重启之后 点击左侧列表跳转登录首页 
		if (window != top) {
			top.location.href = location.href;
		}
	</script>

	<script src="static/js/bootstrap.min.js"></script>
	<script src="static/js/jquery-1.7.2.js"></script>
	<script src="static/login/js/jquery.easing.1.3.js"></script>
	<script src="static/login/js/jquery.mobile.customized.min.js"></script>
	<script src="static/login/js/camera.min.js"></script>
	<script src="static/login/js/templatemo_script.js"></script>
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>
	<script type="text/javascript" src="static/js/jquery.cookie.js"></script>
</body>

</html>