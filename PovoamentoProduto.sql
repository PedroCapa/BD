USE mercado;

-- Inserir alguns produtos na base de dados
INSERT INTO produto (Designacao, Descricao, Preco, Categoria, NIF, Quantidade)
	VALUES ('Mochila', 'Mochila cinzenta e nova', '29.99', 'Material escolar', '2', '10'),
		   ('Relógio', 'Relógio Rolex em ouro', '7000', 'Acessório', '5', '1'),
		   ('Mesa', 'Mesa Branca', '25', 'Móvel', '2','1'),
           ('Caderno', 'Caderno de linhas', '0.99', 'Material escolar', '3','50'),
           ('Quadro Mona Lisa', 'Mona Lisa, de Leonardo da Vinci', '100000', 'Arte', '6','1'),
           ('Conjunto de canetas', 'Canetas de cor azul', '10.25', 'Material escolar', '8', '50'),
           ('Casaco', 'Casaco Branco', '99.99', 'Vestuário', '6', '5'),
           ('Camisola', 'Camisola do Futebol Clube do Porto', '79.99', 'Equipamento desportivo', '8','1'),
           ('Cachecol', 'Cachecol do Futebol Clube do Porto com assinatura de Marega', '19.89', 'Vestuário',  '6','5'),
           ('Borracha', 'Borracha branca da marca STAEDTLER', '0.45', 'Material escolar', '2','20'),
           ('Carteira', 'Carteira Tommy Hilfiger', '150', 'Acessório', '5', '3'),
           ('Busto Cristiano Ronaldo', 'Busto do melhor jogador do mundo de futebol', '1.99', 'Arte', '5', '1'),
           ('Camisola', 'Camisola azul e branca', '79.99', 'Vestuário', '5', '3'),
           ('Caneta de minas', 'Lapiseira Rotring', '0.7', 'Material escolar', '6', '5'),
           ('Relógio Swatch', 'Relógio de luxo Swatch', '2500', 'Acessório', '5', '1'),
           ('T-Shirt TH', 'T-Shirt Tommy Hilfiger branca', '60.99', 'Vestuário', '2','3'),
           ('Samsung Galaxy s8', 'Smartphone em 2ª mão', '150.99', 'Smartphone', '11', '1500'),
           ('Fones Samsung', 'Fones de ouvido Samsung', '12.29', 'Técnologia', '11', '150'),
           ('Pintura A Última Ceia', 'Pintura Leonardo da Vinci', '500000', 'Arte', '1', '1'),
           ('Samsung Galaxy Note9', 'Smartphone preto e novo', '999.99', 'Smartphone', '11', '100');