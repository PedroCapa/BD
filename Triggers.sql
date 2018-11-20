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