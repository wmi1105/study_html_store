<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="resources/css/login.css">
  <link rel="stylesheet" href="resources/css/bootstrap.min.css" media="screen">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DOMObiz(배원미)</title>
<script type="text/javascript">
function login() {
	var form = document.loginForm;

	form.action = "/loginPost";
	form.method = "post";
	form.submit();
}
</script>
</head>
<body>
  <header>
    <div class="hdTop">
      <ul>
        <a href="/index">
          <img src="resources/img/domobiz.png" alt="name" style="width: 100px;">
        </a>
      </ul>
    </div>
  </header>


  <nav class="text-center">
    <div>
        <span>로 그 인</span>
    </div>
  </nav>



    <section>
      <div class="centerBox">
	      <form action="/loginPost" method="post" id="loginForm" name="loginForm" onsubmit="return false;">
	        <div class="loginBox">
	          <ul style="width:70%">
	            <li style="margin-bottom:20px;">
	              <label>아이디</label>
	              <input type="text" name="id" id="id" value="" style="margin:0;">
	            </li>
	            <li>
	              <label>비밀번호</label>
	              <input type="password" name="password" id="password" value="">
	            </li>
	          </ul>
	          <ul>
	            <a href="javascript:login();">LOGIN</a>
	          </ul>
	        </div>
        </form>
        <div class="joinBox">
          <ul style="margin-bottom:30px;">
            <label>아직 회원이 아니신가요?</label>
            <a href="/join">회원가입</a>
          </ul>
          <ul>
            <label>아이디/비번을 잊으셨나요?</label>
            <a href="#">ID/PW찾기</a>
          </ul>
        </div>
      </div>

    </section>
  </body>
</html>