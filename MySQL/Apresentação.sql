Use mercado;

-- Número de produtos no mercado com quantidade superior a 5 * Funtcions
SELECT Distinct QuantidadeProdutosN(5) from produto;

-- Produtos que o utilizador 11 colocou à venda * Procedure
CALL produto_Venda_utilizador(11);

-- Quantidade gasta pelo o utilizador 2 no ano 2017 * Procedure
Call gastouUtilizadorPeriodo(2, '2017-01-01', '2018-01-01');

-- Quantidade ganha pelo utilizador 2 no mercado * Procedure
Call ganhouUtilizadorPeriodo(2);

-- Ver todos os produtos da categoria Arte * Procedure
Call FiltraPesquisa('Arte');

-- Quanto um utilizador 1 recebeu em 2017 e 2018 * Procedure
Call UtilizadorRecebeuTempo(1, '2017/01/01', '2018/07/31');

-- Todas as compras que o utilizador 2 e 11 estão envolvidos * QueriesUser
Call comprasUtilizadores(2, 11);

-- Ver a quantidade que foi vendida o produto 1
SELECT SUM(c.quantidade) FROM produto p, compra c
	WHERE p.Id = 1 AND p.Id = c.prod;

-- Os 5 carrinhos mais caras do sistema
SELECT ca.Id, ca.NIF, SUM(c.Preco) FROM carrinho ca, compra c
	where ca.Id = c.cart
	GROUP BY ca.Id
    ORDER BY SUM(c.Preco) DESC
		LIMIT 5;
        
-- Todos os utilizadores que compraram produtos da categoria Smartphone
SELECT u.NIF, u.Nome
FROM
    utilizador u,
    produto p,
    compra c,
    carrinho ca
WHERE
    p.Categoria = 'Smartphone'
        AND p.Id = c.prod
        AND ca.Id = c.cart
        AND u.NIF = ca.NIF;
        
-- Criar uma transação que cria um carrinho do utilizador 1 e insere algumas compras neste
Start Transaction;

Insert Into utilizador (NIF, Nome, Morada, DataNascimento, password)
	Values (136390670, 'João Castor', 'Gualtar', '1990-08-23', 'IvanZaytsev');
    
Insert Into telemovel
	Values ('236558656', 136390670),
		   ('753779279', 136390670);
           
Insert Into email
	Values ('zaytsevIvan@gmail.com', 136390670);
    
Insert Into utilizador_metodosPagamento
	Values (136390670, 2, '34j5jsi58ugsh4h9ah94ha9f');
    
Update Utilizador u
Set u.saldo = 250.14
Where u.NIF = 136390670;

COMMIT;
rollback;

-- Vista com todos os carrinhos de 2018 * View
SELECT * from Carrinho_2018;