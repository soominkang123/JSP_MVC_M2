<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>회원가입 폼</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .signup-form {
            width: 320px;
            padding: 40px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .signup-form h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        .form-group {
            margin-bottom: 20px;
        }

        label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }

        input[type="text"],
        input[type="email"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        button {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 4px;
            background-color: #007bff;
            color: #fff;
            cursor: pointer;
        }

        button:hover {
            background-color: #0056b3;
        }

        .error-message {
            color: red;
            margin-top: 5px;
        }
    </style>
</head>
<body>

<form class="signup-form" id="signupForm">
    <h2>회원 가입</h2>
    <div class="form-group">
        <label for="username">사용자명</label>
        <input type="text" id="username" name="username" required>
        <div class="error-message" id="usernameError"></div>
    </div>
    <div class="form-group">
        <label for="email">이메일 주소</label>
        <input type="email" id="email" name="email" required>
        <div class="error-message" id="emailError"></div>
    </div>
    <div class="form-group">
        <label for="password">비밀번호</label>
        <input type="password" id="password" name="password" required>
        <div class="error-message" id="passwordError"></div>
    </div>
    <div class="form-group">
        <label for="confirm-password">비밀번호 확인</label>
        <input type="password" id="confirm-password" name="confirm-password" required>
        <div class="error-message" id="confirmPasswordError"></div>
    </div>
    <button type="submit">가입하기</button>
</form>

<script>
    const form = document.getElementById('signupForm');
    form.addEventListener('submit', function(event) {
        event.preventDefault();

        const username = document.getElementById('username').value;
        const email = document.getElementById('email').value;
        const password = document.getElementById('password').value;
        const confirmPassword = document.getElementById('confirm-password').value;

        // 간단한 유효성 검사 (예시)
        const usernameError = document.getElementById('usernameError');
        const emailError = document.getElementById('emailError');
        const passwordError = document.getElementById('passwordError');
        const confirmPasswordError = document.getElementById('confirmPasswordError');

        usernameError.textContent = '';
        emailError.textContent = '';
        passwordError.textContent = '';
        confirmPasswordError.textContent = '';

        if (username.length < 3) {
            usernameError.textContent = '사용자명은 최소 3글자 이상이어야 합니다.';
            return;
        }

        // 이메일 형식 검사 (간단한 형식으로만 확인)
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!emailRegex.test(email)) {
            emailError.textContent = '유효한 이메일 주소를 입력하세요.';
            return;
        }

        if (password.length < 6) {
            passwordError.textContent = '비밀번호는 최소 6글자 이상이어야 합니다.';
            return;
        }

        if (password !== confirmPassword) {
            confirmPasswordError.textContent = '비밀번호가 일치하지 않습니다.';
            return;
        }

        // 여기서 서버로 데이터 전송 등 추가 작업 수행 가능
        // 여기에 서버로 데이터를 보내는 코드를 추가하거나, 다른 필요한 로직을 수행할 수 있습니다.
        console.log('회원가입 성공!');

        // 이후 로직을 추가하여 서버로 데이터를 전송하거나 다른 작업을 수행할 수 있습니다.
    });
</script>

</body>
</html>
    