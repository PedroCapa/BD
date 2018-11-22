Use mercado;

-- Ver todos os utilizadores do sistema
SELECT * FROM utilizador;

-- Ver todos os produtos 
SELECT * FROM produto;

-- Ver todas as compras do sistema
Select * from compra;

-- Ver todos os produtos disponíveis
SELECT * FROM produto p
	WHERE p.quantidade > 0;

-- Ver todos os produtos disponiveis para venda ordenados por categoria
SELECT * FROM produto p
	WHERE p.quantidade > 0
		ORDER BY p.Categoria;

-- Ver todos os produtos colocados à venda pelo utilizador 10
SELECT * FROM produto p, utilizador u
	WHERE u.NIF = 10 AND u.NIF = p.NIF;

-- Ver a quantidade que foi vendida o produto 1
SELECT SUM(c.quantidade) FROM produto p, compra c
	WHERE p.Id = 1 AND p.Id = c.prod;

-- Ver todas as compras do utilizador 2
SELECT * FROM utilizador u, carrinho ca
	WHERE u.NIF = 2 AND u.NIF = ca.NIF;

-- Quanto o cliente 5 faturou
SELECT SUM(c.preco) FROM utilizador u, produto p, compra c
	WHERE u.NIF = 5 AND u.NIF = p.NIF AND p.Id = c.prod;
        
-- Quanto o cliente 5 recebeu num intervalo de tempo
SELECT SUM(c.preco)
	FROM
    utilizador u,
    produto p,
    compra c,
    carrinho ca
	WHERE
    u.NIF = 5 AND u.NIF = p.NIF
        AND p.Id = c.Prod
        AND ca.Id = c.cart
        AND ca.data BETWEEN '2018-01-01' AND '2018-10-31';

-- Todos os utilizadores que compraram produtos da categoria Smartphone
SELECT u.NIF, u.Nome
FROM
    utilizador u,
    produto p,
    compra c,
    carrinho ca
WHERE
    p.Categoria = 'Smartphone'
        AND p.Id = c.prod
        AND ca.Id = c.cart
        AND u.NIF = ca.NIF;

-- Os 5 carrinhos mais caras do sistema
SELECT ca.Id, ca.NIF, SUM(c.Preco) FROM carrinho ca, compra c
	where ca.Id = c.cart
	GROUP BY ca.Id
    ORDER BY SUM(c.Preco) DESC
		LIMIT 5;

-- Os 5 utilizadores com mais produtos à venda
SELECT u.nome, count(u.NIF) from produto p, utilizador u 
	where u.NIF = p.NIF
		group by u.NIF
			Order by count(u.NIF) DESC
				LIMIT 5;

-- Top 5 clientes que mais receberam com o sistema
SELECT u.NIF, u.nome, SUM(c.Preco) from utilizador u, produto p, compra c 
	where u.NIF = p.NIF AND p.Id = c.prod
		GROUP BY u.NIF
			Order by SUM(c.Preco) DESC;
            
Create Index NIFU
	ON utilizador(NIF, nome);

Drop Index NIFU ON utilizador;

SELECT * from utilizador USE INDEX(NIFU)
	where saldo = 0;