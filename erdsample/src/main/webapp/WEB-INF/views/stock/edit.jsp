<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>재고 수정</title>
</head>
<body>
    <h1>재고 수정</h1>
    <form action="edit" method="post">
        <input type="hidden" name="stockNo" value="${dto.stockNo}">
        
        <label for="stockCategory">카테고리:</label>
        <input type="text" id="stockCategory" name="stockCategory" value="${dto.stockCategory}" required><br><br>
        
        <label for="stockName">이름:</label>
        <input type="text" id="stockName" name="stockName" value="${dto.stockName}" required><br><br>
        
        <label for="stockQuntity">수량:</label>
        <input type="number" id="stockQuantity" name="stockQuantity" value="${dto.stockQuantity}" required><br><br>
        
        <button type="submit">수정</button>
    </form>
    <br>
    <a href="list">목록으로 돌아가기</a>
</body>
</html>
