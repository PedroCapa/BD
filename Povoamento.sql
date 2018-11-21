Use mercado;

INSERT INTO utilizador (NIF, Nome, Morada, DataNascimento, password)
	VALUES(1 , 'Lucas Silva'      , 'Rua dos Gritos'	   , '2012-01-17', 'LPS2012' ),
		  (2 , 'Luís Capa'        , 'Vila Verde'    	   , '1998-12-01', 'LFCC1998'),
		  (3 , 'Moisés Antunes'   , 'Póvoa de Lanhoso'	   , '1999-04-14', 'MAA1999' ),
		  (4 , 'Pedro Capa'       , 'Vila Verde'    	   , '1998-12-01', 'PMCC1998'),
          (5 , 'Tiago Pinheiro'   , 'Vila Verde'     	   , '1998-08-06', 'TMP1998' ),
          (6 , 'Moussa Marega'    , 'Porto'				   , '1991-04-14', 'MM1991'  ),
          (7 , 'Rodrigo Rodrigues', 'Braga'				   , '1900-01-01', 'RR1900'  ),
          (8 , 'Pedro Proença'    , 'Lisboa'			   , '1970-04-06', 'PP1970'  ),
          (9 , 'Gabriel Toledo'   , 'Aveiro'			   , '1991-05-30', 'GT1991'  ),
          (10, 'Epitacio de Melo' , 'Faro' 			       , '1995-07-04', 'EM1995'  ),
          (11, 'SAMSUNG'          , 'Leiria'               , '1938-01-01', 'S1938'   ),
          (12, 'Jonas Gonçalves'  , 'Lisboa'			   , '1986-05-08', 'JG1986'  ),
          (13, 'Lamborghini'      , 'Beja'				   , '1963-10-30', 'L1963'   ),
          (14, 'Ferrari'          , 'Évora'				   , '1939-09-13', 'F1939'   ),
          (15, 'Apple'            , 'Coimbra'			   , '1976-04-01', 'A1976'   );
          
INSERT INTO metodospagamento 
	VALUES (0, 'Cartão de Crédito'),
		   (1, 'PayPal'),
           (2, 'Multibanco'),
           (3, 'Cartão de Débito'),
           (4, 'Criptomoedas');

INSERT INTO utilizador_metodosPagamento
	VALUES (1, 3, 123456789), (1, 4, 132456798),
           (2, 0, 145234789),
           (3, 1, 543286072), (3, 2, 536195027),
           (4, 0, 838563820),
           (5, 0, 377533234), (5, 1, 928492752), (5, 2, 829201047),
           (6, 4, 289423833),
           (7, 2, 789572952),
           (8, 0, 897351386), (8, 1, 728959237), (8, 2, 837947934), (8, 3, 385782759),
           (9, 0, 478937483),
           (10, 4, 743892449),
           (11, 0, 146718467), (11, 1, 743987141), (11, 2, 638742644), (11, 3, 746144664), (11, 4, 461815891),
		   (12, 0, 111448467),
           (13, 0, 146133167), (13, 1, 743913441), (13, 2, 638456166), (13, 3, 746149669), (13, 4, 461815737),
           (14, 0, 146767887), (14, 1, 743988484), (14, 2, 638742277), (14, 3, 746148353), (14, 4, 461826272),
           (15, 0, 146715515), (15, 1, 715115141), (15, 2, 155142644), (15, 3, 745114664), (15, 4, 461819699);
           
-- Contactos
INSERT INTO telemovel
	VALUES('912345678', 1),
		  ('901000001', 2),
		  ('901000022', 3),
		  ('901000333', 4),
          ('922992299', 5),
		  ('901004444', 6),
          ('999999999', 7),
		  ('901055555', 8),
          ('987654321', 9),
          ('951668866', 10),
		  ('901666666', 11),
          ('926222652', 12),
		  ('907777777', 13),
		  ('988888888', 14),
          ('901000000', 15);

INSERT INTO email
	VALUES('lucas@gmail.com', 1),
		  ('lfcc@gmail.com', 2),
          ('ma14@hotmail.com', 3),
          ('pmcc@gmail.com', 4),
          ('tiagop@gmail.com', 5),
          ('maregolo@hotmail.com', 6),
          ('rodrirodri@rodri.com', 7),
          ('var@gmail.com', 8),
          ('fallen@gmail.com', 9),
          ('epitacio@hotmail.com', 10),
          ('galaxys7@granada.com', 11),
          ('jpisc@gmail.com', 12),
          ('carro@luxo.com', 13),
          ('viatura@dinheiro.com', 14),
          ('apple@hotmail.com', 15);

-- Transportes
INSERT INTO transporte
	VALUES ('DHL','Muito rapido e eficaz','12.50',60),
		   ('UPS','United Problem Solvers','17.50',36),
           ('FedEx','Ihe World On Time','20.00',24),
           ('TNT','','15.00',48),
           ('Yodel','Your Delivery, Your Call','10.00',72);

-- Produtos
INSERT INTO produto (Designacao, Descricao, Preco, Categoria, NIF, Quantidade)
	VALUES ('Mochila'				 , 'Mochila cinzenta e nova'		   , '29.99' , 'Material escolar'	   , '2' , '10'  ),
		   ('Relógio'				 , 'Relógio Rolex em ouro'			   , '7000'	 , 'Acessório'		 	   , '5' , '1'   ),
		   ('Mesa'					 , 'Mesa Branca'					   , '25'    , 'Móvel'			 	   , '2' , '1'   ),
           ('Caderno'				 , 'Caderno de linhas'				   , '0.99'  , 'Material escolar'	   , '3' , '50'  ),
           ('Quadro Mona Lisa'		 , 'Mona Lisa, de Leonardo da Vinci'   , '1000'  , 'Arte'			 	   , '6' , '1'   ),
           ('Conjunto de canetas'	 , 'Canetas de cor azul'			   , '10.25' , 'Material escolar'	   , '8' , '50'  ),
           ('Casaco'				 , 'Casaco Branco'					   , '99.99' , 'Vestuário'		 	   , '6' , '5'   ),
           ('Camisola'				 , 'Camisola de Portugal'			   , '79.99' , 'Equipamento desportivo', '8' , '1'   ),
           ('Cachecol'				 , 'Cachecol de FPF'				   , '19.89' , 'Vestuário'			   , '6' , '5'   ),
           ('Borracha'				 , 'Borracha branca da marca STAEDTLER', '0.45'  , 'Material escolar'	   , '2' , '20'  ),
           ('Carteira'				 , 'Carteira Tommy Hilfiger'	       , '150'	 , 'Acessório'		       , '5' , '3'   ),
           ('Busto Cristiano Ronaldo', 'Miniatura do busto original'       , '1.99'  , 'Arte'				   , '5' , '1'   ),
           ('Camisola'				 , 'Camisola azul e branca'	           , '79.99' , 'Vestuário'			   , '5' , '3'   ),
           ('Caneta de minas'		 , 'Lapiseira Rotring'			       , '0.7'   , 'Material escolar'	   , '6' , '5'   ),
           ('Relógio Swatch'		 , 'Relógio de luxo Swatch'		       , '2500'  , 'Acessório'			   , '5' , '1'   ),
           ('T-Shirt TH'			 , 'T-Shirt Tommy Hilfiger branca'	   , '60.99' , 'Vestuário'			   , '2' , '3'   ),
           ('Samsung Galaxy s8'	     , 'Smartphone em 2ª mão'			   , '150.99', 'Smartphone'			   , '11', '1500'),
           ('Fones Samsung'		   	 , 'Fones de ouvido Samsung'		   , '12.29' , 'Técnologia'		       , '11', '150' ),
           ('Pintura A Última Ceia'	 , 'Pintura Leonardo da Vinci'		   , '50000' , 'Arte'				   , '1' , '1'   ),
           ('Samsung Galaxy Note9' 	 , 'Smartphone preto e novo'  		   , '999.99', 'Smartphone'			   , '11', '100' );
	
-- Carrinho
INSERT INTO carrinho (data, trans, NIF)
	VALUES ('2018-11-15','DHL',5),
		   ('2014-01-01','DHL',1),
		   ('2017-06-05','DHL',2),
           ('2018-02-28','DHL',4);

-- Compra
INSERT INTO compra (Quantidade,Cart,Prod)
	VALUES (1 ,1,1 ),
		   (1 ,1,2 ),
		   (1 ,1,8 ),
		   (1 ,1,11),
		   (1 ,2,5 ),
           (1 ,3,20),
           (30,3,4 ),
           (10,4,10),
           (1 ,4,19),
           (1 ,4,12);

-- INSERT INTO compra (Quantidade,Cart,Prod)
-- VALUES (3,4,13);

-- SELECT * FROM compra;