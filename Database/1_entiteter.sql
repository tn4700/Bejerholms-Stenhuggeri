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
post_nr              char(4),
byNavn              	varchar(25),
primary key(post_nr)
) engine = innodb;

drop table if exists ordre;
create table ordre
(
ordre_nr                 int,
ordretype               boolean,
ordredato				datetime,
ordrestatus				int,
leveringdato            datetime,   
afhentningsdato         datetime,
bemærkning              text,            
leveringsadresse        varchar(100),    # Adresse + post nr + by
kirkegård				varchar(25),
afdeling				int,
afdødnavn				varchar(50),
række					int,
nummer					int,
plads_navne				int,
gravType				boolean,
primary key(ordre_nr)
) engine = innodb;

drop table if exists vare_linje;
create table vare_linje
(
linje_nr             	int
) engine = innodb;

drop table if exists tom_linje;
create table tom_linje
(
navn                    varchar(50),
pris                    float,
antal                   int,
kommentar               varchar(100)
)engine = innodb;

drop table if exists varer;
create table varer
(
vare_nr 				int auto_increment,
navn					varchar(100),
højde                   int,
bredde                  int,
indkøbspris             float,
salgspris               float,
typenavn				varchar(20),
overflade				varchar(20),
dekoration				boolean,
primary key(vare_nr)
) engine = innodb;

drop table if exists varegrupper;
create table varegrupper
(
grp_nr                  int auto_increment,  # Et unikt nr som repræsenterer en vare gruppe
navn                    varchar(25),    # Navet på varegruppen
primary key(grp_nr)
) engine =innodb;

drop table if exists inskription;
create table inskription
(
inskription             text,
skrifttype				varchar(25)
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
kontoudtog_nr          	int,            # Unikt nr som står i topppen af kontoudtogs seddelen
dato                    datetime,       # Dato for oprettelse af kontoudtogs seddelen
vedrørende              varchar(100),
sendt_dato              datetime,       # Dato for hvornår Kontoudtog er sendt
primary key(kontoudtog_nr)
)engine = innodb;

drop table if exists kontoudtog_linje;
create table kontoudtog_linje
(
antal                   int,
linje_nr				int,
beskrivelse             text,
pris                    float
)engine = innodb;

drop table if exists provisionsseddel;
create table provisionsseddel
(
provisions_nr            int,            # Unikt nummer som står i toppen af provisions seddelen 
dato                    datetime,       # Dato for oprettelse af provisionsseddel
vedrørende              varchar(100),   
overførelsesbetingelser varchar(100),
primary key(provisions_nr)
) engine = innodb;

drop table if exists provisionsseddel_linje;
create table provisionsseddel_linje
(
antal                   int,
linje_nr				int,
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
registrerings_nr			char(4),
konto_nr		      		char(10),			# Reg + Kontonr
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


