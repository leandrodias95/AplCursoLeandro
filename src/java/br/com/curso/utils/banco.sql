create table estado( 
	idEstado serial primary key,
	nomeestado varchar(100) not null,
    siglaestado varchar(2) not null

);
 insert into estado(nomeestado, siglaestado) values('São Paulo','SP');
 
 select * from estado;

create table usuario(idusuario serial primary key,
					 email varchar(100) not null,
					 senha varchar(20) not null,
					 nomecompleto varchar(100) not null,
					 tipousuario varchar(20) not null);
					
					insert into usuario(email, senha, nomecompleto, tipousuario) 
					values('usuario@gmail.com', '123456', 'usuario novo', 'administrador');
                                        select * from usuario