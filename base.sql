\c postgres;

drop database eval;

create database eval;

\c eval;

create table marque
(
    id serial not null primary key,
    nom varchar(30)
);

---3
create table processeur
(
    id serial not null primary key,
    marque varchar(30),
    modele varchar(30),
    generation int,
    frequence double precision
);

---6
create table typedur
(
    id serial not null primary key,
    typedur varchar(10)
);

---7
create table disquedur
(
    id serial not null primary key,
    idtype int,
    capacite double precision,
    foreign key(idtype) references typedur(id)
);

---9
create table laptop
(
    id serial not null primary key,
    idmarque int,
    reference varchar(30),
    idprocesseur int,
    ram double precision,
    iddur int,
    ecran double precision,
    prix double precision,
    foreign key(idprocesseur) references processeur(id),
    foreign key(idmarque) references marque(id),
    foreign key(iddur) references disquedur(id)
);

---10
create table lieu
(
    id serial not null primary key,
    nom varchar(50)
);

---11
create table pointdevente
(
    id serial not null primary key,
    nom varchar(50),
    idlieu int,
    foreign key(idlieu) references lieu(id)
);

---12
create table utilisateur
(
    id serial not null primary key,
    nom varchar(50),
    email varchar(50),
    mdp varchar(50)
);

---13
create table utilisateurpointdevente
(
    idutilisateur int unique,
    idpointdevente int,
    primary key(idutilisateur,idpointdevente),
    foreign key(idutilisateur) references utilisateur(id),
    foreign key(idpointdevente) references pointdevente(id)
);

---14
create table stockmagasin
(
    id serial not null primary key,
    idlaptop int,
    quantite int,
    foreign key(idlaptop) references laptop(id)
);

---15
create table stockpointdevente
(
    id serial not null primary key,
    idlaptop int,
    idpv int,
    quantite int,
    foreign key(idlaptop) references laptop(id),
    foreign key(idpv) references pointdevente(id)
);

---16
create table transfert
(
    id serial not null primary key,
    idpointdevente int,
    idlaptop int,
    quantite int,
    daty date,
    etat int,
    foreign key(idpointdevente) references pointdevente(id),
    foreign key(idlaptop) references laptop(id)
);

---17
create table reception
(
    id serial not null primary key,
    idpointdevente int,
    idlaptop int,
    daty date,
    foreign key(idpointdevente) references pointdevente(id),
    foreign key(idlaptop) references laptop(id)
);

---18
create table renvoie
(
    id serial not null primary key,
    idpointdevente int,
    idlaptop int,
    daty date,
    foreign key(idpointdevente) references pointdevente(id),
    foreign key(idlaptop) references laptop(id)
);

---19
create table vente
(
    id serial not null primary key,
    idlaptop int,
    idpointdevente int,
    daty date,
    foreign key(idpointdevente) references pointdevente(id),
    foreign key(idlaptop) references laptop(id)
);



insert into utilisateur(nom,email,mdp) values
('Rakoto Jean','jean@gmail.com','jean'),
('Christian Robert','chrisrobert@gmail.com','robert'),
('Kami Rak','kami@gmail.com','kami');

insert into lieu(nom) values
('Itaosy'),
('Andoharanofotsy'),
('Analamahitsy'),
('Ivato');

insert into pointdevente(nom,idlieu) values
('Shop Andranonahoatra Itaosy',1),
('Shop Galana Andoharanofotsy',2),
('Shop Arret Analamahitsy',3),
('Shop Aeroport Ivato',4);

insert into utilisateurpointdevente(idutilisateur,idpointdevente) values
(1,1),
(2,2),
(3,2);

insert into typeDur(typedur) values('HDD'),('SSD');

insert into disquedur(idtype,capacite) values
(1,120),
(1,180),
(1,250),
(1,320),
(1,500),
(1,1000),

(2,120),
(2,180),
(2,250),
(2,320),
(2,500),
(2,1000);

create or replace view v_pointdevente as select pointdevente.*,lieu.nom as nomlieu from pointdevente join lieu on pointdevente.idlieu=lieu.id;

create or replace view v_utilisateur as select utilisateur.*,utilisateurpointdevente.idpointdevente as idpointdevente,v_pointdevente.nom as nompointdevente,nomlieu from utilisateur join utilisateurpointdevente on utilisateur.id=utilisateurpointdevente.idutilisateur join v_pointdevente on v_pointdevente.id=utilisateurpointdevente.idpointdevente;

create or replace view v_dur as select disquedur.*,typedur from disquedur join typedur on disquedur.idtype=typedur.id;

create or replace view v_laptop as select laptop.*,marque.nom as nommarque,processeur.marque as marqueproc,modele,generation,frequence,disquedur.idtype as idtypedur,disquedur.capacite,typedur.typedur from laptop join marque on laptop.idmarque=marque.id join processeur on processeur.id=laptop.idprocesseur join disquedur on disquedur.id=laptop.iddur join typedur on typedur.id=disquedur.idtype;

create or replace view v_stockmagasin as select v_laptop.*,quantite from v_laptop join stockmagasin on v_laptop.id=stockmagasin.idlaptop;

create or replace view v_stockpv as select v_laptop.*,quantite from v_laptop join stockpointdevente on v_laptop.id=stockpointdevente.idlaptop;