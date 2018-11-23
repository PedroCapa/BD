USE mercado;

-- Ver info de um utilizador
Delimiter //
CREATE PROCEDURE verInfoUtilizador(IN nif INT)
BEGIN
	SELECT * FROM Utilizador AS u
		WHERE u.NIF = nif;
END //
Delimiter //

CALL verinfoutilizador(3);

-- Adicionar número de telemóvel
Delimiter //
CREATE PROCEDURE addTelemovel(IN nif INT, IN numero BIGINT)
BEGIN
	INSERT INTO Telemovel
		VALUES (numero, nif);
END //
Delimiter //

Call addTelemovel(2, 936558656);

-- Adicionar um email
Delimiter //
CREATE PROCEDURE addEmail(IN nif INT, IN email VARCHAR(32))
BEGIN
	INSERT INTO Email
		VALUES (email, nif);
END //
Delimiter //

Call addEmail(2, 'lfccapa@gmail.com');

-- Carregar a conta
Delimiter //
CREATE PROCEDURE carregaConta(IN nif INT, IN valor DECIMAL(16,3))
BEGIN
	UPDATE Utilizador u
    SET u.Saldo = u.Saldo + valor
    WHERE u.NIF = nif;
END //
Delimiter //

Call carregaConta(2, 120);

-- Aceder a todas as compras que um utilizador fez
Delimiter //
CREATE PROCEDURE comprasPessoais(IN nif INT)
BEGIN
	SELECT * FROM Compra AS c, Carrinho AS car
		WHERE car.NIF = nif AND c.Cart = car.Id;
END //
Delimiter //

Call comprasPessoais(2);

-- Todas as compras em que os dois utilizadores estão envolvidos
Delimiter //
Create Procedure comprasUtilizadores(IN user1 INT, IN user2 INT)
BEGIN
	Select Distinct c.Id, c.Preco, c.Quantidade, c.Cart, c.Prod, p.Designacao
		From Utilizador u, Carrinho car, Compra c, Produto p
			Where p.NIF = user2 
				AND c.Prod = p.Id 
				AND c.Cart = car.Id 
				AND car.NIF = user1 
				OR 
				(p.NIF = user1
				AND c.Prod = p.Id 
				AND c.Cart = car.Id 
				AND car.NIF = user2);
END //
Delimiter //

Call comprasUtilizadores(2, 11);