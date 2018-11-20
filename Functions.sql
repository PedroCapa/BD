Use mercado;

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
-- ver mais tarde a parte do distinct
SELECT Distinct QuantidadeProdutosN(1) from produto;