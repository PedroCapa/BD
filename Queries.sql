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
    
-- Ver todas as compras do utilizador 2
SELECT * FROM carrinho c, utilizador u
	WHERE u.NIF = 2 AND u.NIF = c.NIF;

-- Ver a quantidade que foi vendida o produto 3
SELECT SUM(c.quantidade) FROM produto p, compra c
	WHERE p.Id = 3 AND p.Id = c.prod;

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

-- As 5 compras mais caras do sistema
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

-- Lista de Carrinhos do mês de Janeiro de 2018 (VIEW)
CREATE VIEW Carrinho_Janeiro_2018 AS
    SELECT * FROM carrinho ca
    WHERE ca.data BETWEEN '2018-10-01' AND '2018-10-31';

SELECT * from Faturas_Janeiro_2018;

-- Produtos que um dado utilizador colocou para a venda (Procedure)
Delimiter // 
CREATE PROCEDURE produto_Venda_utilizador(IN uti INT)
	Begin 
		select * from produto p
			where uti = p.NIF;
    END //
Delimiter //

CALL produto_Venda_utilizador(1);

-- Numero de Produtos no qual a quantidade era superior a n (Function)
Delimiter // 
CREATE FUNCTION QuantidadeProdutosN(val Int)
	Returns Int
    DETERMINISTIC
    Begin 
		DECLARE res Int;
        SET res = (Select Count(Id) from produto p where p.quantidade > val);
               
        return res;
    END //
Delimiter //

SELECT Distinct QuantidadeProdutosN(1) from produto;

-- Cliente gastou num determinado periodo
Delimiter // 
CREATE PROCEDURE gastouUtilizadorPeriodo(IN uti INT, IN begin DATE, IN end DATE)
	Begin 
	SELECT SUM(c.Preco) from carrinho ca, compra c
		where uti = ca.NIF AND ca.Id = c.cart;
    END //
Delimiter //

Call gastouUtilizadorPeriodo(11, '1900-01-01', '2020-01-01');

-- Quanto um utilizador recebeu em vendas
Delimiter //
CREATE PROCEDURE ganhouUtilizadorPeriodo(IN uti INT)
	Begin 
	select Sum(c.Preco) from produto p, compra c, carrinho ca
		where uti = p.NIF AND p.Id = c.prod;
    END //
Delimiter //

Call ganhouUtilizadorPeriodo(10);

-- Registar um utilizador no sistema
Delimiter // 
CREATE PROCEDURE Registar(IN uti INT, IN nome VARCHAR(45), IN morada varchar(45), IN nascimento DATE, IN pass varchar(32))
	Begin 
	INSERT INTO utilizador (NIF, Nome, Morada, DataNascimento, Password) Values(uti, nome, morada, nascimento, pass);
    END //
Delimiter //

Call Registar(20, 'Bob Jungles', 'Luxembugo', '1992-09-22', 'BJ1992');
Call Registar(16, 'julian alaphilippe', 'França', '1992-06-11', 'JA1992');

-- Utilizador coloca um artigo para a venda

Delimiter // 
CREATE Function AdicionarProduto(designacao VARCHAR(45), descricao VARCHAR(150), preco Int, categoria VARCHAR(30), nif Int, quantidade Int)
	Returns Int 
    DETERMINISTIC
		Begin
            Insert Into produto (Designacao, Descricao, Preco, Categoria, NIF, Quantidade)
				Values (designacao, descricao, preco, categoria, nif, quantidade);
		return id;
		End //
Delimiter //

SELECT AdicionarProduto('lamborghini murcielago', 'Melhor carro do mundo', 1500000, 'Automóvel', 13, 20) from produto;