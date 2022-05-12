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

insert into Estado(nomeestado,siglaestado)values('São Paulo','SP');


create table Cidade(idCidade serial primary key, nomeCidade varchar(100)not null, situacao varchar(1) not null, idEstado int not null, 
constraint fk_estado foreign key(idEstado) references Estado(idEstado));
insert into Cidade(nomeCidade, situacao, idEstado)values('Fernandopolis','A',1);
insert into Cidade(nomeCidade, situacao, idEstado)values('Jales','A',1);