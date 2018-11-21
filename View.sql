Use mercado;

-- Lista de Carrinhos do mês de Janeiro de 2018 (VIEW)
CREATE VIEW Carrinho_Janeiro_2018 AS
    SELECT * FROM carrinho ca
    WHERE ca.data BETWEEN '2018-01-01' AND '2018-01-31';

SELECT * from Faturas_Janeiro_2018;