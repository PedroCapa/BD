Use mercado;

INSERT INTO utilizador 
	VALUES(1, 'Lucas Peixoto Silva', 'Rua dos Gritos nº1', '2012-01-17', "LPS2012"),
		  (2, 'Luís Filipe da Costa Capa', 'Vila Verde', '1998-12-01', "LFCC1998"),
		  (3, ' Moisés Araújo Antunes', 'Maria da Fonte', '1999-04-14', "MAA1999"),
		  (4, 'Pedro Miguel da Costa Capa', 'Vila Verde', '1998-12-01', "PMCC1998"),
          (5, 'Tiago Martins Pinheiro', 'Vila Verde', '1998-08-06', "TMP1998"),
          (6, 'Moussa Marega', 'Porto', '1991-04-14', "MM1991"),
          (7, 'Rodrigo Rodrigues', 'Braga', '1900-01-01', "RR1900"),
          (8, 'Pedro Proença', 'Lisboa', '1970-04-06', "PP1970"),
          (9, 'Gabriel Toledo', 'New York', '1991-05-30', "GT1991"),
          (10, 'Epitacio de Melo', 'New York', '1995-07-04', "EM1995"),
          (11, 'SAMSUNG', ' Seul Coreia do Sul', '1938-01-01', "S1938"),
          (12, 'Jonas Gonçalves', 'Lisboa', '1986-05-08', "JG1986"),
          (13, 'Lamborghini', 'Sant Agata Bolognese','1963-10-30', "L1963"),
          (14, 'Ferrari','	Maranello','1939-09-13', "F1939"),
          (15, 'Apple', 'California', '1976-04-01', "A1976");
          
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