USE mercado;

Delimiter //
Create Trigger valorCompra BEFORE INSERT ON compra
	For Each Row
    Begin

		Declare precoProduto Decimal(16,3);
        Select getValorProduto(New.Prod) INTO precoProduto;
        
        Set New.Preco = New.Quantidade * precoProduto;
	End //
Delimiter //

Delimiter //
CREATE FUNCTION getValorProduto(idProduto INT)
RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE res INT;
    SET res = (SELECT p.Preco FROM Produto AS p WHERE p.Id = idProduto);
    
    RETURN res;
END //
Delimiter //

-- Quando se insere uma compra atualiza-se o saldo do cliente, bem como a quantidade dp produto

Delimiter //
Create Procedure atualizaSaldoQuantidade(IN prod INT, IN Uvende INT, IN Ucompra INT, IN quant INT, IN preco Decimal(16,3))
	Begin
		UPDATE utilizador u SET saldo = saldo + preco where u.NIF = Uvende;
        UPDATE utilizador u SET saldo = saldo - preco where u.NIF = Ucompra;
        UPDATE produto p SET p.quantidade = p.quantidade - quant where p.Id = prod;
    End //
Delimiter //

Delimiter //
	Create Function NIF_Utilizador_Vende(prod INT)
    Returns Int
    DETERMINISTIC
    Begin 
		Declare res INT;
        Set res = (select u.NIF from utilizador u, produto p
					where p.Id = prod AND u.NIF = p.NIF);
        
        return res;
    END //
Delimiter //

Delimiter //
	Create Function NIF_Utilizador_Compra(id INT)
    Returns Int
    DETERMINISTIC
    Begin 
		Declare res Int;
        Set res = (SELECT u.NIF from utilizador u, carrinho c 
					WHERE c.Id = id AND u.NIF = c.NIF);
        
        return res;
    END //
Delimiter //

Delimiter //
Create Trigger AtualizaSaldo AFTER INSERT ON compra
	For Each Row
    Begin
		Declare Uvende INT;
        Declare Ucompra INT;
        Declare precoProduto Decimal(16,2);
        
		Select  NIF_Utilizador_Vende(New.Prod) INTO Uvende;
        SELECT  NIF_Utilizador_Compra(New.cart) INTO Ucompra;
        SELECT  getValorProduto(New.Prod) INTO precoProduto;
        
        Set 	precoProduto = New.Quantidade * precoProduto;
        
        Call 	atualizaSaldoQuantidade(New.Prod, Uvende, Ucompra, New.Quantidade, precoProduto);
	End //
Delimiter //

-- Retirar saldo pelo transporte
Delimiter //
Create Procedure retiraCustoTrans(IN nif INT, IN preco Decimal(16,3))
	Begin
		UPDATE utilizador u SET saldo = saldo - preco where u.NIF = nif;
    End //
Delimiter //

Delimiter //
Create Trigger retiraCustoTransporte AFTER INSERT ON carrinho
	For Each ROW
    Begin
		Declare preco DECIMAL(16,3);
        Set preco = (Select t.custo from transporte t, carrinho ca
						where New.Trans = t.Designacao AND ca.Id = New.Id);
		Call retiraCustoTrans(New.NIF, preco);
    End //
Delimiter //
