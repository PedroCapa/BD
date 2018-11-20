Use mercado;

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