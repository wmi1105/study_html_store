<%@page import="org.ellen.domain.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link rel="stylesheet" href="resources/css/frame.css">
  <link rel="stylesheet" href="resources/css/category.css">
  <link rel="stylesheet" href="resources/css/bootstrap.min.css" media="screen">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DOMObiz(배원미)</title>
</head>
  <body>
    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>

    <header>
      <div class="hdTop">
        <ul>
            <li>
           <%MemberVO vo = (MemberVO)session.getAttribute("login");
            if(vo == null){%>
	            <a href="/login">로그인</a>
	            <a href="/join">회원가입</a>
	            <%}else{ %>
	            <a><%=vo.getName() %>님</a>
	            <a href="/logout">로그아웃</a>
	            <%} %>
            <a href="#">마이페이지</a>
            <a href="#">장바구니</a>
            <a href="#">주문정보</a>
            </li>
        </ul>
      </div>
      <div class="text-center">
        <a href="/index">
          <img src="resources/img/domobiz.png" alt="name" style="width: 300px;">
        </a>
      </div>
    </header>
    <nav>
      <div class="text-center">
        <ul>
          <li>
            <a href="#">신상</a>
            <a href="#">인기</a>
          </li>
          <li>
            <a href="/accessory">악세사리</a>
            <a href="#">소품</a>
            <a href="#">SAIL</a>
            <a href="#">EVENT</a>
          </li>
          <li>
            <a href="#">비즈</a>
            <a href="#">공구</a>
            <a href="#">도안</a>
          </li>
          <li style="border:0;">
            <input type="text" name="search" value="" style="padding:0; margin:0;">
            <input type="submit" name="search" value="검색" style="padding:0; margin:0;">
          </li>
        </ul>
      </div>
    </nav>
    <section>
      <div class="sideBox">
        <ul style="background-color:#838383; margin:0; padding:5px 20px;">
          <label>ACC</label>
        </ul>
        <ul>
          <li><a href="/itemList">목걸이</a>
            <ul>
              <li><a href="#">초커</a></li>
              <li><a href="#">팬던트</a></li>
              <li><a href="#">진주</a></li>
              <li><a href="#">크리스탈</a></li>
            </ul>
          </li>
          <li><a href="/itemList">귀걸이</a>
            <ul>
              <li><a href="#">고리형</a></li>
              <li><a href="#">핀형</a></li>
              <li><a href="#">진주</a></li>
              <li><a href="#">크리스탈</a></li>
            </ul>
          </li>
          <li><a href="/itemList">팔찌/발찌</a>
            <ul>
              <li><a href="#">체인</a></li>
              <li><a href="#">우레탄</a></li>
              <li><a href="#">진주</a></li>
              <li><a href="#">가죽</a></li>
            </ul>
          </li>
          <li><a href="/itemList">기타악세사리</a>
            <ul>
              <li><a href="#">차량용</a></li>
              <li><a href="#">폰고리</a></li>
              <li><a href="#">진주</a></li>
              <li><a href="#">크리스탈</a></li>
            </ul>
          </li>
        </ul>
      </div>
      <div class="newBox">
        <ul style="border-bottom:1px solid; font-size:25px; padding:20px;">NEW
        </ul>
        <ul style="background-color:#e2e3b8;">
         <li><img src="resources/img/necklace7.png"></li>
         <li style="width:50%;">
           <div>
             <ul style="margin-bottom: 10px;">
               <img src="resources/img/watch4.jpg">
               <img src="resources/img/bracelet17.jpg" style="margin:0;">
             </ul>
             <ul>
               <img src="resources/img/ring5.jpg">
               <img src="resources/img/necklace1.jpg" style="margin:0;">
             </ul>
           </div>
         </li>
        </ul>
      </div>
      <div class="ButtonTop">
        <a href="#" style="color: #636363;"><ul>
        <img src="resources/img/up.png" alt="up">TOP
        </ul></a>
      </div>
      <hr style="margin-left:17%; width:67%; border-bottom:1px solid;">

      <div class="manuImg">
       <ul>
         <a href="#" style="margin:0;"><img src="resources/img/necklace3.jpg">
           <label>menu1</label></a>
         <a href="#"><img src="resources/img/watch2.jpg">
           <label>menu2</label></a>
         <a href="#"><img src="resources/img/deck2.jpg">
           <label>menu3</label></a>
         <a href="#"><img src="resources/img/ring6.jpg">
           <label>menu4</label></a>
       </ul>
       <ul>
         <a href="#" style="margin:0;"><img src="resources/img/bracelet21.jpg">
             <label>menu1</label></a>
         <a href="#"><img src="resources/img/watch3.jpg">
             <label>menu2</label></a>
         <a href="#"><img src="resources/img/necklace2.jpg">
             <label>menu3</label></a>
         <a href="#"><img src="resources/img/deck4.jpg">
             <label>menu4</label></a>
       </ul>
      </div>
    </section>
    <footer>
      <div class="text-center">
        <ul style="margin-top:30px; margin-left:7%;  border-right:1px solid #d0d0d0;">
          <li><a href="#">고객상담</a></li>
          <li><a href="#">이용안내</a></li>
          <li><a href="#">배송안내</a></li>
          <li><a href="#">이용약관</a></li>
          <li><a href="#">개인정보취급안내</a></li>
        </ul>
        <ul style="border:0; width:60%; margin:0; padding-right:0;">
          <img src="resources/img/bottom.jpg">
        </ul>
      </div>
    </footer>
  </body>
</html>