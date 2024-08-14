<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>재고 목록</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #fce4ec; /* 부드러운 핑크색 배경 */
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: center;
            color: #ffffff; /* 헤더 텍스트 색상을 흰색으로 설정 */
            background-color: #f8a5b0; /* 부드러운 핑크색 배경 */
            padding: 20px;
            margin: 0;
        }

        form {
            display: flex;
            justify-content: center;
            margin: 20px 0;
            background-color: #ffffff; /* 폼 배경색을 흰색으로 설정하여 깔끔하게 보이도록 */
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        label {
            font-weight: bold;
            color: #f8a5b0; /* 레이블 색상을 부드러운 핑크색으로 설정 */
            margin-right: 10px;
            white-space: nowrap; /* 레이블과 입력 필드의 줄바꿈을 방지하여 정렬을 유지 */
        }

        select, input[type="text"], button {
            padding: 10px;
            border-radius: 5px;
            border: 1px solid #ddd;
            margin-right: 10px;
            font-size: 16px;
        }

        button {
            background-color: #f8a5b0; /* 버튼의 배경색을 부드러운 핑크색으로 설정 */
            color: white;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #f48fb1; /* 버튼 호버 시 배경색을 약간 어두운 핑크색으로 설정 */
        }

        table {
            width: 90%;
            max-width: 1200px;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: #ffffff; /* 테이블 배경색을 흰색으로 설정 */
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 12px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f8a5b0; /* 테이블 헤더 배경색을 부드러운 핑크색으로 설정 */
            color: white; /* 헤더 텍스트 색상을 흰색으로 설정 */
            font-weight: bold;
        }

        tr:hover {
            background-color: #fce4ec; /* 테이블 행 호버 시 배경색을 부드러운 핑크색으로 설정 */
        }

        a {
            color: #f8a5b0; /* 링크 색상을 부드러운 핑크색으로 설정 */
            text-decoration: none;
            font-weight: bold;
        }

        a:hover {
            text-decoration: underline;
        }

        .button-container {
            display: flex;
            justify-content: flex-end;
            margin: 20px;
        }

        a.button-link {
            display: inline-block;
            padding: 10px 20px;
            background-color: #f8a5b0; /* 버튼의 배경색을 부드러운 핑크색으로 설정 */
            color: white;
            border-radius: 5px;
            text-align: center;
            text-decoration: none;
            font-size: 16px;
        }

        a.button-link:hover {
            background-color: #f48fb1; /* 버튼 호버 시 배경색을 약간 어두운 핑크색으로 설정 */
        }
    </style>
</head>
<body>
    <h1>재고 목록</h1>
    <form action="list" method="get">
        <label for="column">검색 조건:</label>
        <select id="column" name="column">
            <option value="stockCategory">카테고리</option>
            <option value="stockName">이름</option>
        </select>
        <input type="text" name="keyword" placeholder="검색어 입력">
        <button type="submit">검색</button>
    </form>
    <table>
        <thead>
            <tr>
                <th>시리얼 번호</th>
                <th>카테고리</th>
                <th>이름</th>
                <th>수량</th>
                <th>입고 날짜</th> <!-- 입고 날짜 열 추가 -->
                <th>상세</th>
                <th>삭제</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${list}">
                <tr>
                    <td>${item.stockNo}</td>
                    <td>${item.stockCategory}</td>
                    <td>${item.stockName}</td>
                    <td>${item.stockQuantity}</td>
                    <td><fmt:formatDate value="${item.stockDate}" pattern="yyyy-MM-dd HH:mm" /></td> <!-- 입고 날짜 표시 -->
                    <td><a href="detail?stockNo=${item.stockNo}">상세보기</a></td>
                    <td><a href="delete?stockNo=${item.stockNo}" onclick="return confirm('정말 삭제하시겠습니까?');">삭제</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="button-container">
        <a href="insert" class="button-link">재고 등록</a>
    </div>
</body>
</html>
