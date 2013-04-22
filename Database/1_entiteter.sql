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
postnr                  char(4),
bynavn                  varchar(50),

primary key(tlf)
) engine = innodb;

drop table if exists ordre;
create table ordre
(
ordrenr                 int,
ordretype               varchar(50), #Ny sten eller tilføjelse, Skal måske laves om?
leveringdato            datetime,
afhentningsdato         datetime,
bemærkning              text,        # Da vi laver så han selv kan tilføje tekst som en ordre linje er den måske overflødig
arbejdstimer            int,
leveringsadresse        varchar(100), # Adresse + post nr + by
primary key(ordrenr)
) engine = innodb;

drop table if exists kirkegaard_ordre;
create table kirkegaard_ordre
(
kirkegaard              varchar(50),
afdeling                int,
gravtype                varchar(50)
) engine = innodb;

drop table if exists vare_linje;
create table vare_linje
(
inskription             text
) engine = innodb;

drop table if exists andenlinje;
create table andenlinje
(
navn                    varchar(50),
pris                    int,
antal                   int,
kommentar               varchar(100)
)engine = innodb;

drop table if exists varer;
create table varer
(
indkøbspris             int,
højde                   int,
bredde                  int,
længde                  int,
salgspris               int
) engine = innodb;

drop table if exists vare_grupper;
create table vare_grupper
(
grp_nr                  int,
navn                    varchar(25),
primary key(grp_nr)
) engine =innodb;

drop table if exists faktura;
create table faktura
(
faktura_nr              int,
faktureringsdato        int,
vedrørende              varchar(100),
betalingsbetingelser    varchar(50),
sendt_dato              datetime,
faktureringsadresse     varchar(50),
miljøafgift             int,
type                    int, #Bedemand eller almindelig - skal rettes i klassediagram
betalingsstatus         boolean,
primary key(faktura_nr)
) engine = innodb;

drop table if exists kontoudtog;
create table kontoudtog
(
konto_udtog_nr          int,
dato                    datetime,
vedrørende              varchar(100),
sendt_dato              datetime,
primary key(konto_udtog_nr)
)engine = innodb;

drop table if exists kontoudtog_linje;
create table kontoudtog_linje
(
antal                   int,
beskrivelse             text,
pris                    int
)engine = innodb;

drop table if exists provisionsseddel;
create table provisionsseddel
(
provisionsnr            int,
dato                    datetime,
vedrørende              varchar(100),
overførelsesbetingelser varchar(100),
procent                 int,

primary key(provisionsnr)
) engine = innodb;

drop table if exists provisionsseddel_linje;
create table provisionsseddel_linje
(
antal                   int,
beskrivelse             text,
enhedspris              int,
beløb                   int
) engine = innodb;

drop table if exists samarbejdspartnere;
create table samarbejdspartnere
(
firmanavn               varchar(50),
adresse                 varchar(50),
postnr                  char(4),
bynavn                  varchar(50),
tlf                     char(8),
cvr_nr                  char(10), # Find ud af hvor langt det er
konto_oplysninger       varchar(50)
) engine = innodb;

drop table if exists skriftype;
create table skrifttype
(
navn                    varchar(50),
pris_pr_bokstav         int
) engine = innodb;

drop table if exists dekoration;
create table dekoration
(
navn                    varchar(50),
pris                    int
) engine = innodb;
