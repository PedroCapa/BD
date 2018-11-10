USE mercado;

-- Inserir alguns produtos na base de dados
INSERT INTO produto (idProduto, Designacao, Descricao, Preco, Categoria)
	VALUES (1, 'Mochila', 'Mochila cinzenta e nova', '29.99', 'Material escolar'),
		   (2, 'Relógio', 'Relógio Rolex em ouro', '7000', 'Acessório'),
		   (3, 'Mesa', 'Mesa Branca', '25', 'Móvel'),
           (4, 'Caderno', 'Caderno de linhas', '0.99', 'Material escolar'),
           (5, 'Quadro Mona Lisa', 'Mona Lisa, de Leonardo da Vinci', '1000000', 'Arte'),
           (6, 'Conjunto de canetas', 'Canetas de cor azul', '10.25', 'Material escolar'),
           (7, 'Casaco', 'Casaco Branco', '99.99', 'Vestuário'),
           (8, 'Camisola', 'Camisola do Futebol Clube do Porto', '79.99', 'Equipamento desportivo'),
           (9, 'Cachecol', 'Cachecol do Futebol Clube do Porto com assinatura de Marega', '19.89', 'Vestuário'),
           (10, 'Borracha', 'Borracha branca da marca STAEDTLER', '0.45', 'Material escolar'),
           (11, 'Carteira', 'Carteira Tommy Hilfiger', '150', 'Acessório'),
           (12, 'Busto Cristiano Ronaldo', 'Busto do melhor jogador do mundo de futebol', '1.99', 'Arte'),
           (13, 'Camisola', 'Camisola azul e branca', '79.99', 'Vestuário'),
           (14, 'Caneta de minas', 'Lapiseira Rotring', '0.7', 'Material escolar'),
           (15, 'Relógio Swatch', 'Relógio de luxo Swatch', '2500', 'Acessório'),
           (16, 'T-Shirt TH', 'T-Shirt Tommy Hilfiger branca', '60.99', 'Vestuário'),
           (17, 'Samsung Galaxy s8', 'Smartphone em 2ª mão', '150.99', 'Smartphone'),
           (18, 'Fones Samsung', 'Fones de ouvido Samsung', '12.29', 'Técnologia'),
           (19, 'Pintura A Última Ceia', 'Pintura Leonardo da Vinci', 'Arte'),
           (20, 'Samsung Galaxy Note9', 'Smartphone preto e novo', '999.99', 'Smartphone');
           