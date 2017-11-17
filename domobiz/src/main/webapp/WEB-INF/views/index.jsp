<%@page import="org.ellen.domain.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="resources/css/frame.css">
<link rel="stylesheet" href="resources/css/main.css">
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
          <li style="padding-right:4.5%;">
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
            <input type="text" name="search" value="" style="padding:0; margin:0; width: 80%;">
            <input type="submit" name="search" value="검색" style="padding:0; margin:0;">
          </li>
        </ul>
      </div>
    </nav>


    <section>
      <!-- 추천이미지 -->
      <div class="mainImg">
        <ul>
          <li style="margin:0 1.5% 2% 0; "><img src="resources/img/bracelet9.jpg"></li>
          <li>
            <div class="maingImg2">
              <ul style="margin-top:0;"><img src="resources/img/ring3.jpg"></ul>
              <ul>
                <li><img src="resources/img/deck3.jpg"></li>
                <li><img src="resources/img/material4.jpg" style="margin-left:5%;"></li>
              </ul>
            </div>
          </li>
        </ul>
        <ul>
          <img src="resources/img/bracelet23.jpg" alt="" style="margin-right:1%;">
          <img src="resources/img/ring1.jpg" alt="" style="margin-right:1%;">
          <img src="resources/img/bracelet16.jpg" alt="" style="margin-right:1%;">
          <img src="resources/img/doll1.jpg" alt="">
        </ul>
      </div>


      <!-- 베너 -->
      <div align="center">
        <img src="resources/img\banner.jpg">
      </div>             <!-- width="950" height="300" -->


      <!-- 인기메뉴 -->

      <div class="popular">
          <span>인   기</span>
      </div>


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
          <a href="#" style="margin:0;"><img src="resources/img/bracelet23.jpg">
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