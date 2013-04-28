Drop database if exists bejerholmstenhuggeri;
create database bejerholmstenhuggeri;
use bejerholmstenhuggeri;

drop table if exists kunde;
create table kunde
(   
fornavn                 varchar(50),
efternavn               varchar(50),
adresse                 varchar(50),
tlf                     char(8),
primary key(tlf)
) engine = innodb;

drop table if exists postnumre;
create table postnumre
(   
postnummer              char(4),
byNavn              	varchar(25),
primary key(postnummer)
) engine = innodb;

drop table if exists ordre;
create table ordre
(
ordrenr                 int,
ordretype               int,     # Ny sten eller tilføjelse, Skal måske laves om?
ordredato				datetime,
leveringdato            datetime,   
afhentningsdato         datetime,
bemærkning              text,            # Da vi laver så han selv kan tilføje tekst som en ordre linje er den måske overflødig
arbejdstimer            int,
leveringsadresse        varchar(100),    # Adresse + post nr + by
kirkegård				varchar(25),
afdeling				int,
primary key(ordrenr)
) engine = innodb;

drop table if exists tilføjelse;
create table tilføjelse
(
værkstedstimer          int,
rensning                int,
transport              	int,
afhentning				int,
levering				int
) engine = innodb;

drop table if exists vare_linje;
create table vare_linje
(
linjeNr             	int
) engine = innodb;

drop table if exists tomLinje;
create table tomLinje
(
navn                    varchar(50),
pris                    float,
antal                   int,
kommentar               varchar(100)
)engine = innodb;

drop table if exists varer;
create table varer
(
varenummer 				int auto_increment,
navn					varchar(100),
højde                   int,
bredde                  int,
indkøbspris             float,
salgspris               float,
typenavn				varchar(20),
overflade				varchar(20),
dekoration				boolean,
primary key(varenummer)
) engine = innodb;

drop table if exists vare_grupper;
create table vare_grupper
(
grp_nr                  int auto_increment,  # Et unikt nr som repræsenterer en vare gruppe
navn                    varchar(25),    # Navet på varegruppen
primary key(grp_nr)
) engine =innodb;

drop table if exists inskription;
create table inskription
(
inskription             text
) engine = innodb;

drop table if exists tegntype;
create table tegntype
(
navn                    varchar(50),
pris_pr_tegn            float
) engine = innodb;

drop table if exists faktura;
create table faktura
(
faktura_nr              int,            # Unikt nr som står i toppen af faktura seddelen
faktureringsdato        datetime,            # Dato for oprettelse af faktura seddelen
vedrørende              varchar(100),
betalingsbetingelser    varchar(50),
sendt_dato              datetime,       # Dato for hvornår fakturaen er sendt
faktureringsadresse     varchar(50),          
fakturatype             boolean,            # Bedemand eller almindelig - skal rettes i klassediagram
betalingsstatus         boolean,        # Status = betalt eller ikke betalt
primary key(faktura_nr)
) engine = innodb;

drop table if exists kontoudtog;
create table kontoudtog
(
konto_udtog_nr          int,            # Unikt nr som står i topppen af kontoudtogs seddelen
dato                    datetime,       # Dato for oprettelse af kontoudtogs seddelen
vedrørende              varchar(100),
sendt_dato              datetime,       # Dato for hvornår Kontoudtog er sendt
primary key(konto_udtog_nr)
)engine = innodb;

drop table if exists kontoudtog_linje;
create table kontoudtog_linje
(
antal                   int,
beskrivelse             text,
pris                    float
)engine = innodb;

drop table if exists provisionsseddel;
create table provisionsseddel
(
provisionsnr            int,            # Unikt nummer som står i toppen af provisions seddelen 
dato                    datetime,       # Dato for oprettelse af provisionsseddel
vedrørende              varchar(100),   
overførelsesbetingelser varchar(100),
primary key(provisionsnr)
) engine = innodb;

drop table if exists provisionsseddel_linje;
create table provisionsseddel_linje
(
antal                   int,
beskrivelse             text,
enhedspris             	float,
pris                  	float
) engine = innodb;

drop table if exists samarbejdspartnere;
create table samarbejdspartnere
(
firmanavn               varchar(50),
adresse                 varchar(50),
tlf                     char(8),        # 8 cifre uden landekode
cvr_nr                  char(8),        # Et CVR nummer er på 8 cifre
registreringsnr			char(4),
kontonr		      		char(10),			# Reg + Kontonr
bank 					varchar(20),
primary key(cvr_nr)
) engine = innodb;

drop table if exists user;
create table user
(
brugernavn               varchar(25),
pw		                 varchar(25),
primary key(brugernavn)
) engine = innodb;

drop table if exists konstanter;
create table konstanter
(
nr               		int,
navn	                varchar(25),
procentsats				float,
primary key(nr)
) engine = innodb;


