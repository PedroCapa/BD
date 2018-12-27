Use mercado;

-- Lista de Carrinhos do mês de Novembro de 2018
CREATE VIEW Carrinho_Novembro_2018 AS
    SELECT * FROM carrinho ca
    WHERE ca.data BETWEEN '2018-11-01' AND '2018-11-31';

SELECT * from Carrinho_Novembro_2018;

-- Lista de Carrinhos do ano de 2018
Create View Carrinho_2018 AS
	SELECT * FROM carrinho ca
    WHERE ca.data BETWEEN '2018-01-01' AND '2018-12-31';
    
SELECT * from Carrinho_2018;

-- Lista de produtos disponíveis para venda
Create VIEW ProdutosDisponiveis AS
	SELECT * from produto 
		where quantidade > 0;
        
SELECT * from ProdutosDisponiveis;