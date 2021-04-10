<header>
<h1>API AWS WEBFLUX</h1>
</header>

<header> 
<ul>
<header><h2>Stack utilizada</h2>
<li><a href="">Java11</a></li>
<li><a href="">spring webflux</a></li>
<li><a href="">Spring data</a></li>
<li><a href="">junit</a></li>
<li><a href="">sl4j</a></li>
<li><a href="">reactor</li></header>
</ul>
</header>

<header>
<h1>Para executar dynamo</h1>
<p>
<h4>
Na pasta em que o jar está baixado: <a href=""> java -Djava.library.path=./DynamoDBLocal_lib -jar DynamoDBLocal.jar -sharedDb </a>.
</h4>
</p>
<p>
<h4>
para listar as tabelas criadas: aws dynamodb list-tables --endpoint-url <a href=""> http://localhost:8000</a>
</h4>
</p>
</header>