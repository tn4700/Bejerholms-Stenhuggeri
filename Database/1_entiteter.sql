drop database if exists bejerholmstenhuggeri;
create database bejerholmstenhuggeri;
use bejerholmstenhuggeri;

drop table if exists kunde;
create table kunde
(   
fornavn                 varchar(50) not null,
efternavn               varchar(50) not null,
adresse                 varchar(50) not null,
tlf                     char(8) not null,
primary key(tlf)
) engine = innodb;

drop table if exists postnummer;
create table postnummer
(   
post_nr              	char(4) not null,
byNavn              	varchar(25) not null,
primary key(post_nr)
) engine = innodb;

drop table if exists faktureringsadresse;
create table faktureringsadresse
(   
id                      int auto_increment,      
adresse                 varchar(50) not null,
primary key(id)
) engine = innodb;

drop table if exists ordre;
create table ordre
(
ordre_nr                char(5) not null,
ordretype               boolean not null,
ordredato				datetime not null,
leveringdato            datetime,   
afhentningsdato         datetime,
bemærkning              text, 
bemærkning_ekstra		text,
kirkegård				varchar(25),
afdeling				int,
afdødnavn				varchar(50),
række					int,
nummer					int,
gravType				boolean,
primary key(ordre_nr)
) engine = innodb;

drop table if exists vare_linje;
create table vare_linje
(
linje_nr             	int not null
) engine = innodb;

drop table if exists tom_linje;
create table tom_linje
(
id						int auto_increment,
navn                    varchar(50) not null,
pris                    double not null,
antal                   int not null,
primary key(id)
)engine = innodb;

drop table if exists vare;
create table vare
(
vare_nr 				int auto_increment not null,
navn					varchar(100) not null,
højde                   int,
bredde                  int,
indkøbspris             double not null,
salgspris               double not null,
typenavn				varchar(50),
overflade				int,
dekoration				boolean,
vareStatus 				int not null, #0 på lager, 1 reserveret, 2 solgt
primary key(vare_nr)
) engine = innodb;

drop table if exists varetype;
create table varetype
(
id                  	int auto_increment not null,
navn                    varchar(50) not null,  
primary key(id)
) engine =innodb;

drop table if exists varegruppe;
create table varegruppe
(
grp_nr                  int auto_increment not null,
navn                    varchar(25) not null,  
primary key(grp_nr)
) engine =innodb;

drop table if exists inskription;
create table inskription
(
id						int auto_increment,
skrifttype				varchar(25) not null,
primary key(id)
) engine = innodb;

drop table if exists inskription_linje;
create table inskription_linje
(
linje_nr				int not null,
inskription             varchar(50),
linje_type				int not null #0 - tom, 1 - ny, 2 - gammel, 3 - plads
) engine = innodb;

drop table if exists tegntype;
create table tegntype
(
id						int auto_increment,
navn                    varchar(50) not null,
pris_pr_tegn            double not null,
primary key(id)
) engine = innodb;

drop table if exists faktura;
create table faktura
(
faktura_nr              char(16) not null,            # Unikt nr som står i toppen af faktura seddelen
faktureringsdato        datetime,            # Dato for oprettelse af faktura seddelen
sendt_dato              datetime,       # Dato for hvornår fakturaen er sendt   
fakturatype             boolean not null,            # Bedemand eller almindelig - skal rettes i klassediagram
betalingsstatus         boolean,        # Status = betalt eller ikke betalt
primary key(faktura_nr)
) engine = innodb;

drop table if exists kontoudtog;
create table kontoudtog
(
kontoudtog_nr          	char(5) not null,            # Unikt nr som står i topppen af kontoudtogs seddelen
dato                    datetime,       # Dato for oprettelse af kontoudtogs seddelen
sendt_dato              datetime,       # Dato for hvornår Kontoudtog er sendt
primary key(kontoudtog_nr)
)engine = innodb;

drop table if exists provisionsseddel;
create table provisionsseddel
(
provisions_nr           char(5) not null,      
dato                    datetime,    
primary key(provisions_nr)
) engine = innodb;

drop table if exists kirkegård;
create table kirkegård
(
id                 		int auto_increment not null,
navn                    varchar(50) not null,  
primary key(id)
) engine =innodb;

drop table if exists samarbejdspartner;
create table samarbejdspartner
(
firmanavn               varchar(50) not null,
adresse                 varchar(50) not null,
tlf                     char(8) not null,        # 8 cifre uden landekode
cvr_nr                  char(8),        # Et CVR nummer er på 8 cifre
registrerings_nr		char(4),
konto_nr		      	char(10),			# Reg + Kontonr
bank 					varchar(20),
primary key(tlf)
) engine = innodb;

drop table if exists user;
create table user
(
brugernavn               varchar(25) not null,
pw		                 varchar(25) not null,
primary key(brugernavn)
) engine = innodb;


