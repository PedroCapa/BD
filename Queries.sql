Use mercado;

-- Ver todos os utilizadores
SELECT * FROM utilizador;

-- Ver todos os produtos
SELECT * FROM produto;

-- Ver todos os anuncios disponíveis
SELECT * FROM produto a
	WHERE a.quantidade > 0;

-- Ver todos os produtos disponiveis para venda ordenados por tipo
SELECT * FROM produto p
	WHERE p.quantidade > 0
	ORDER BY p.Categoria; 

-- Ver todos os produtos colocados à venda pelo utilizador 10
SELECT * FROM produto p, utilizador u
	WHERE u.NIF = p.Utilizador_NIF AND u.NIF = 11;
    
-- Ver todas as compras do utilizador 2
SELECT * FROM fatura f, utilizador u
	WHERE u.NIF = f.NIF_comprador AND u.NIF = 2;

-- Ver a quantidade que foi vendida o produto 3
SELECT SUM(pc.quantidade) FROM produto p, Produto_Compra pc
	WHERE p.Id = pc.Produto_Id && p.Id = 3;

-- Numero de vezes que o produto 3 foi vendido
SELECT COUNT(p.Id) FROM produto p, Produto_Compra pc
	WHERE p.Id = pc.Produto_Id && p.Id = 3;

-- Quanto o cliente 3 faturou
SELECT SUM(pc.Quantidade) FROM utilizador u, produto p, produto_Compra pc
	WHERE p.Id = 3 && u.NIF = p.Utilizador_NIF && p.Id = pc.Produto_Id;
        
-- Quanto o cliente 3 faturou num intervalo de tempo
SELECT pc.Quantidade 
	FROM
    utilizador u,
    produto p,
    produto_Compra pc,
    Compra c,
    fatura f
	WHERE
    p.Id = 3 && u.NIF = p.Utilizador_NIF
        && p.Id = pc.Produto_Id
        && pc.Compra_ID = c.Id
        && c.Fatura_ID = f.Id
        && f.data BETWEEN '2018-10-01' AND '2018-10-31';

-- Todos os utilizadores que compraram produtos de uma dada categoria
SELECT u 
FROM
    produto p,
    fatura f,
    produto_Compra pc,
    compra c,
    utilizador u
WHERE
    p.Categoria = 'Smartphone'
        && p.Id = pc.Produto_Id
        && pc.Compra_ID = c.Id
        && c.Fatura_ID = f.Id
        && u.NIF = f.NIF_comprador;

-- As 5 compras mais caras do sistema
SELECT * FROM fatura f 
	ORDER BY f.preco DESC
		LIMIT 5;

-- Os 5 utilizadores com mais produtos à venda
SELECT u.nome, count(u.NIF) from produto p, utilizador u 
	where u.NIF = p.Utilizador_NIF
		group by u.NIF
			Order by count(u.NIF) DESC
				LIMIT 5;

-- Lista de Faturas do mês de Janeiro de 2018 (VIEW)
CREATE VIEW Faturas_Janeiro_2018 AS
    SELECT * FROM faturas f
    WHERE f.data BETWEEN '2018-10-01' AND '2018-10-31';

SELECT * from Faturas_Janeiro_2018;

-- Produtos que um dado utilizador colocou para a venda (Procedure)
Delimiter // 
CREATE PROCEDURE produto_Venda_utilizador(IN uti INT)
	Begin 
		select * from produto p
			where uti = p.Utilizador_NIF;
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
	SELECT SUM(Preco) from fatura f
		where uti = f.NIF_comprador;
    END //
Delimiter //

Call gastouUtilizadorPeriodo(11, '1900-01-01', '2020-01-01');

-- Quanto um utilizador recebeu em vendas
Delimiter // 
CREATE PROCEDURE ganhouUtilizadorPeriodo(IN uti INT)
	Begin 
	select Sum(pc.quantidade * p.preco) from (
		SELECT pc.quantidade, p.preco from produto_compra pc, produto p
			where uti = f.NIF_comprador && pc.Produto_id = p.Id);
    END //
Delimiter //

Call ganhouUtilizadorPeriodo(10);

-- Registar um utilizador no sistema
Delimiter // 
CREATE PROCEDURE Registar(IN uti INT, IN nome VARCHAR(45), IN morada varchar(45), IN nascimento DATE)
	Begin 
	INSERT INTO utilizador Values(uti, nome, morada, nascimento);    
    END //
Delimiter //

Call Registar(20, 'Bob Jungles', 'Luxembugo', '1992-09-22');
Call Registar(16, 'julian alaphilippe', 'França', '1992-06-11');










-- Utilizador coloca um artigo para a venda

-- Ver mais tarde

Delimiter // 
CREATE Function AdicionarProduto(designacao VARCHAR(45), descricao VARCHAR(150), preco Int, categoria VARCHAR(30), nif Int, quantidade Int)
	Returns Int 
    DETERMINISTIC
		Begin
			Declare id Int;
            Set id = (Select (Max(id) + 1) from produto);
            Insert Into produto Values (id, designacao, descricao, preco, categoria, nif, quantidade);
		return id;
		End //
Delimiter //

SELECT AdicionarProduto('lamborghini murcielago', 'Melhor carro do mundo', 1500000, 'Automóvel', 13, 20) from produto;