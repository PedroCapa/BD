Use mercado;

-- Ver todos os utilizadores
SELECT * FROM utilizador;

-- Ver todos os produtos
SELECT * FROM produto;

-- Ver todos os anuncios, mesmo aqueles que ja não estão disponíveis
SELECT * FROM anuncio;

-- Ver todos os anuncios disponíveis
SELECT * FROM anuncio a
	WHERE a.quantidade > 0;
    
-- Ver todos os anuncios criados por o utilizador 10
SELECT * from anuncio a, utilizador u 
	where u.NIF = a.Utilizador_NIF and u.NIF = 10;
    
-- Ver todas as compras do utilizador 2
SELECT * FROM compra c, utilizador u 
	where u.NIF = c.utilizador_NIF and u.NIF = 2;

-- Ver todos os produtos do anuncio 1
SELECT * from anuncio a, produto p
	WHERE a.Id = p.Anuncio_Id and a.Id = 1;

-- Numero de anuncios de cada utilizador (testar mais tarde)
SELECT Count(u.NIF), u.Nome FROM utilizador u, anuncio a
	where u.NIF = a.Utilizador_NIF
		group by u.NIF;