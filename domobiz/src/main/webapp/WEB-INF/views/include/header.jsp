<%@page import="org.ellen.domain.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
         <script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>
       <!-- Font Awesome Icons -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Ionicons -->
    <link href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" rel="stylesheet" type="text/css" />
 
<link rel="stylesheet" href="/resources/css/frame.css">
<link rel="stylesheet" href="/resources/css/main.css">
<link rel="stylesheet" href="/resources/css/bootstrap.min.css" media="screen">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DOMObiz(배원미)</title>
</head>
  <body>
    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="/resources/js/bootstrap.min.js"></script>

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
          <img src="/resources/img/domobiz.png" style="width: 300px;">
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