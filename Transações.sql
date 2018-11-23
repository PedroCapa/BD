USE mercado;

-- Criar uma transação que cria um carrinho e insere algumas compras neste
Start Transaction;

Insert Into carrinho
	Values (curdate(), 'TNT', 1);

Insert Into compra
	Values (2, 5, 4),
		   (30, 5, 6),
           (5, 5, 10);
COMMIT;

-- Transação que adiciona cliente e toda a informação sobre ele
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