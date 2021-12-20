<!doctype html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>

    <h1>Login Clave Única</h1>
    <div>th:text="${client_id}"</div>
    <div>th:text="client_id"</div>
    <div>=====</div>
    <div>${response_type}</div>
    <div>${scope}</div>
    <div>${redirect_uri}</div>
    <div>${ state }</div>


    <form action="/login" method="post">
        <div>
        <input type="text" placeholder="Usuario">
            <input type="text" placeholder="Usuario">
        </div>
        <div>
            <input type="password" placeholder="Contraseña">
        </div>
        <div>
            <button type="submit" >Enviar</button>
        </div>
    </form>
</body>
</html>