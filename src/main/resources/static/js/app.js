*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:Arial, Helvetica, sans-serif;
}

body{
    background:#f4f6f9;
}

.topbar{
    height:70px;
    background:#1f5d3b;
    color:white;

    display:flex;
    justify-content:space-between;
    align-items:center;

    padding:0 30px;

    box-shadow:0 2px 8px rgba(0,0,0,.2);
}

.logo{
    font-size:24px;
    font-weight:bold;
}

.usuario{
    font-size:16px;
}

.container{

    display:flex;

}

.menu{

    width:240px;
    background:white;
    min-height:calc(100vh - 70px);

    box-shadow:2px 0 8px rgba(0,0,0,.1);

    padding-top:30px;

}

.menu a{

    display:block;

    padding:18px 25px;

    color:#333;

    text-decoration:none;

    transition:.3s;

    font-size:17px;

}

.menu a:hover{

    background:#1f5d3b;

    color:white;

}

.conteudo{

    flex:1;

    padding:40px;

}

.card{

    background:white;

    border-radius:12px;

    padding:30px;

    box-shadow:0 3px 10px rgba(0,0,0,.1);

}