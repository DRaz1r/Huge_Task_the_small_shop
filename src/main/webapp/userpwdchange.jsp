<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>用户密码修改</title>
  <style>
    #win10-login {
      background: url("img/login.jpg") no-repeat fixed;
      width: 100%;
      height: 100%;
      background-size: 100% 100%;
      position: fixed;
      z-index: -1;
      top: 0;
      left: 0;
    }

    #win10-login-box {
      width: 300px;
      overflow: hidden;
      margin: 0 auto;
    }

    .win10-login-box-square {
      width: 105px;
      margin: 0 auto;
      border-radius: 50%;
      background-color: darkgray;
      position: relative;
      overflow: hidden;
    }

    .win10-login-box-square::after {
      content: "";
      display: block;
      padding-bottom: 100%;
    }

    .win10-login-box-square .content {
      position: absolute;
      width: 100%;
      height: 100%;
    }

    input {
      width: 90%;
      display: block;
      border: 0;
      margin: 0 auto;
      line-height: 36px;
      font-size: 20px;
      padding: 0 1em;
      border-radius: 5px;
      margin-bottom: 11px;
    }

    .login-username, .login-password {
      width: 91%;
      font-size: 13px;
      color: #999;
    }

    .login-password {
      width: calc(91% - 54px);
      -webkit-border-radius: 2px 0 0 2px;
      -moz-border-radius: 2px 0 0 2px;
      border-radius: 5px 0 0 5px;
      margin: 0px;
      float: left;
    }

    .login-submit {
      margin: 0px;
      float: left;
      -webkit-border-radius: 0 5px 5px 0;
      -moz-border-radius: 0 5px 5px 0;
      border-radius: 0 5px 5px 0;
      background-color: #009688;
      width: 90px;
      display: inline-block;
      height: 36px;
      line-height: 36px;
      padding: 0 auto;
      color: #fff;
      white-space: nowrap;
      text-align: center;
      font-size: 14px;
      border: none;
      cursor: pointer;
      opacity: .9;
      filter: alpha(opacity=90);

    }

    a{color: white}
    a:hover{color: brown}
  </style>
</head>
<body>
<div id="win10-login">
  <div style="height: 10%;min-height: 120px"></div>
  <div id="win10-login-box">
    <div class="win10-login-box-square">
      <img src="img/regist.jpg" class="content"/>
    </div>
    <p style="font-size: 24px;color: white;text-align: center">用户密码修改</p>
    <form action="UserPwdChangeServlet" method="post">

	  <!--账号-->
      <input type="text" placeholder="请输入账号" class="login-username" name="uname" id="uname">
      <!--旧密码-->
      <input type="password" placeholder="请输入旧密码" class="login-username" name="oldpwd" id="oldpwd">
      <!--新密码-->
      <input type="password" placeholder="请输入新密码" class="login-username" name="newpwd" id="newpwd">
      <!--登陆按钮-->
      <input type="submit"  value="修改密码" id="btn-login" class="login-submit"/>
    </form>
  </div><br>
  <div align="center">
    <b><a href="userlogin.jsp">用户登录</a></b>&nbsp;&nbsp;<b><a href="login.jsp">管理员登录</a></b>
  </div>
</div>
<script>
</script>
</body>
</html>