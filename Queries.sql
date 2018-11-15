Use mercado;

-- Ver todos os utilizadores
SELECT * FROM utilizador;

-- Ver todos os produtos
SELECT * FROM produto;

-- Ver todos os anuncios disponíveis
SELECT * FROM produto a
	WHERE a.quantidade > 0;
    
-- Ver todos os produtos colocados à venda pelo utilizador 10
SELECT * from produto p, utilizador u 
	where u.NIF = p.Utilizador_NIF and u.NIF = 10;
    
-- Ver todas as compras do utilizador 2
SELECT * FROM compra c, utilizador u 
	where u.NIF = c.utilizador_NIF and u.NIF = 2;

-- Ver a quantidade que foi vendida de um produto 
SELECT * from utilizador u, produto p 
	
