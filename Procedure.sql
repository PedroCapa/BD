Use mercado;

-- Produtos que um dado utilizador colocou para a venda (Procedure)
Delimiter // 
CREATE PROCEDURE produto_Venda_utilizador(IN uti INT)
	Begin 
		select * from produto p
			where uti = p.NIF;
    END //
Delimiter //

CALL produto_Venda_utilizador(1);

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

-- Filtar os produtos de acordo com a pesquisa do utilizador
Delimiter //
CREATE PROCEDURE FiltraPesquisa(IN pesq INT)
	Begin 
	SELECT * from produto p 
		where p.Categoria = pesq OR p.nome = pesq;
    END //
Delimiter //

-- Aceder a informações pessoais de um utilizadore

Delimiter //
Create Procedure InfoUtilizador(IN nif INT)
	Begin
    SELECT * from utilizador u
		where nif = u.NIF;
    End //
Delimiter //