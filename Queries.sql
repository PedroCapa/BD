Use mercado;

-- Ver todos os utilizadores
SELECT 
    *
FROM
    utilizador;

-- Ver todos os produtos
SELECT 
    *
FROM
    produto;

-- Ver todos os anuncios disponíveis
SELECT 
    *
FROM
    produto a
WHERE
    a.quantidade > 0;

-- Ver todos os produtos disponiveis para venda ordenados por tipo
SELECT 
    *
FROM
    produto p
WHERE
    p.quantidade > 0
ORDER BY p.Categoria; 

-- Ver todos os produtos colocados à venda pelo utilizador 10
SELECT 
    *
FROM
    produto p,
    utilizador u
WHERE
    u.NIF = p.Utilizador_NIF AND u.NIF = 10;
    
-- Ver todas as compras do utilizador 2
SELECT 
    *
FROM
    fatura f,
    utilizador u
WHERE
    u.NIF = f.NIF_comprador AND u.NIF = 2;

-- Ver a quantidade que foi vendida o produto 3
SELECT 
    SUM(pc.quantidade)
FROM
    produto p,
    Produto_Compra pc
WHERE
    p.Id = pc.Produto_Id && p.Id = 3;

-- Numero de vezes que o produto 3 foi vendido
SELECT 
    COUNT(p.Id)
FROM
    produto p,
    Produto_Compra pc
WHERE
    p.Id = pc.Produto_Id && p.Id = 3;

-- Quanto o cliente 3 faturou
SELECT 
    SUM(pc.Quantidade)
FROM
    utilizador u,
    produto p,
    produto_Compra pc
WHERE
    p.Id = 3 && u.NIF = p.Utilizador_NIF
        && p.Id = pc.Produto_Id;
        
-- Quanto o cliente 3 faturou num intervalo de tempo
SELECT 
    pc.Quantidade
FROM
    utilizador u,
    produto p,
    produto_Compra pc,
    Compra c,
    fatura f
WHERE
    p.Id = 3 && u.NIF = p.Utilizador_NIF
        && p.Id = pc.Produto_Id
        && pc.Compra_ID = c.Id
        && c.Fatura_ID = f.Id
        && f.data BETWEEN '2018-10-01' AND '2018-10-31';

-- Todos os utilizadores que compraram produtos de uma dada categoria
SELECT 
    u
FROM
    produto p,
    fatura f,
    produto_Compra pc,
    compra c,
    utilizador u
WHERE
    p.Categoria = 'Smartphone'
        && p.Id = pc.Produto_Id
        && pc.Compra_ID = c.Id
        && c.Fatura_ID = f.Id
        && u.NIF = f.NIF_comprador;