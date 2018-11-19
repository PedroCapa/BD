USE mercado;

SELECT * FROM MetodosPagamento;

SELECT * FROM Transporte;

-- Ver info de um utilizador
Delimiter //
CREATE PROCEDURE verInfoUtilizador(IN nif INT)
BEGIN
	SELECT * FROM Utilizador AS u
		WHERE u.NIF = nif;
END //
Delimiter //

CALL ver_info_utilizador(3);

-- Adicionar número de telemóvel
Delimiter //
CREATE PROCEDURE addTelemovel(IN nif INT, IN numero BIGINT)
BEGIN
	INSERT INTO Telemovel
		VALUES (nif, numero);
END //
Delimiter //

-- Adicionar um email
Delimiter //
CREATE PROCEDURE addEmail(IN nif INT, IN email VARCHAR(32))
BEGIN
	INSERT INTO Email
		VALUES (nif, email);
END //
Delimiter //

-- Alterar morada utilizador
Delimiter //
CREATE PROCEDURE alterarMorada(IN nif INT, IN morada VARCHAR(45))
BEGIN
	UPDATE Utilizador u
	SET u.Morada = morada
    WHERE u.NIF = nif;
END
Delimiter //

-- Alterar password
Delimiter //
CREATE PROCEDURE alteraPassword(IN nif INT, IN pass VARCHAR(32))
BEGIN
	UPDATE Utilizador u
    SET u.password = pass
    WHERE u.NIF = nif;
END //
Delimiter //

-- Carregar a conta
Delimiter //
CREATE PROCEDURE carregaConta(IN nif INT, IN valor DECIMAL(8,2))
BEGIN
	UPDATE Utilizador u
    SET u.Saldo = u.Saldo + valor
    WHERE u.NIF = nif;
END //
Delimiter //

-- Levantar dinheiro
Delimiter //
CREATE PROCEDURE levantaDinheiro(IN nif INT, IN valor DECIMAL(8,2))
BEGIN
	UPDATE Utilizador u
    SET u.Saldo = u.Saldo - valor
    WHERE u.NIF = nif;
END //
Delimiter //

-- Aceder a todas as compras que um utilizador fez
Delimiter //
CREATE PROCEDURE faturasPessoais(IN nif INT)
BEGIN
	SELECT * FROM Compra AS c, Carrinho AS car
		WHERE car.NIF = nif AND c.Cart = car.Id;
END //
Delimiter //