Use mercado;

-- Ver todos os utilizadores 
SELECT * FROM utilizador;

-- Ver todos os produtos 
SELECT * FROM produto;

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

-- Ver a quantidade que foi vendida o produto 3
SELECT SUM(c.quantidade) FROM produto p, compra c
	WHERE p.Id = 3 AND p.Id = c.prod;

-- Ver todas as compras do utilizador 2
SELECT * FROM carrinho c, utilizador u
	WHERE u.NIF = 2 AND u.NIF = c.NIF;

-- Quanto o cliente 3 faturou
SELECT SUM(c.preco) FROM utilizador u, produto p, compra c
	WHERE u.NIF = 3 AND u.NIF = p.NIF AND p.Id = c.preco;
        
-- Quanto o cliente 3 faturou num intervalo de tempo
SELECT SUM(c.preco)
	FROM
    utilizador u,
    produto p,
    compra c,
    carrinho ca
	WHERE
    u.NIF = 3 AND u.NIF = p.Id
        AND p.Id = c.Prod
        AND ca.Id = c.cart
        AND ca.data BETWEEN '2018-10-01' AND '2018-10-31';

-- Todos os utilizadores que compraram produtos da categoria Smartphone
SELECT u 
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
SELECT ca.Id, SUM(c.Preco) FROM carrinho ca, compra c
	GROUP BY ca.Id
    ORDER BY SUM(ca.Preco) DESC
		LIMIT 5;

-- Os 5 utilizadores com mais produtos à venda
SELECT u.nome, count(u.NIF) from produto p, utilizador u 
	where u.NIF = p.NIF
		group by u.NIF
			Order by count(u.NIF) DESC
				LIMIT 5;

-- Ordem da faturação dos clientes
SELECT u.NIF, u.nome, SUM(c.Preco) from utilizador u, produto p, compra c 
	where u.NIF = p.NIF AND p.Id = c.prod
		GROUP BY u.NIF
			Order by SUM(c.Preco);


-- Lista de Carrinhos do mês de Janeiro de 2018 (VIEW)
CREATE VIEW Carrinho_Janeiro_2018 AS
    SELECT * FROM carrinho ca
    WHERE ca.data BETWEEN '2018-10-01' AND '2018-10-31';

SELECT * from Faturas_Janeiro_2018;