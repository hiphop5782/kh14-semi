<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>재고 상세 정보</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .container {
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px 40px;
            max-width: 400px;
            width: 100%;
            text-align: center;
        }

        h1 {
            color: #333;
            font-size: 22px;
            margin-bottom: 20px;
        }

        .info {
            margin: 10px 0;
            font-size: 16px;
            color: #555;
        }

        .info strong {
            color: #333;
            font-weight: bold;
        }

        .button-container {
            margin-top: 20px;
            display: flex;
            justify-content: space-between;
        }

        a {
            color: #fff;
            text-decoration: none;
            padding: 10px 20px;
            border-radius: 5px;
            background-color: #007bff;
            transition: background-color 0.3s ease;
            flex: 1;
            text-align: center;
            margin: 0 5px;
        }

        a:hover {
            background-color: #0056b3;
        }

        .back-link {
            background-color: #6c757d;
        }

        .back-link:hover {
            background-color: #5a6268;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>재고 상세 정보</h1>
        <div class="info"><strong>시리얼 번호:</strong> ${dto.stockNo}</div>
        <div class="info"><strong>카테고리:</strong> ${dto.stockCategory}</div>
        <div class="info"><strong>이름:</strong> ${dto.stockName}</div>
        <div class="info"><strong>수량:</strong> ${dto.stockQuantity}</div>

        <div class="button-container">
            <a href="edit?stockNo=${dto.stockNo}">수정</a>
            <a href="list" class="back-link">목록으로</a>
        </div>
    </div>
</body>
</html>

