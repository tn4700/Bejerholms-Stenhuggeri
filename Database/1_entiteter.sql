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
ordretype               varchar(50),     # Ny sten eller tilføjelse, Skal måske laves om?
leveringdato            datetime,   
afhentningsdato         datetime,
bemærkning              text,            # Da vi laver så han selv kan tilføje tekst som en ordre linje er den måske overflødig
arbejdstimer            int,
leveringsadresse        varchar(100),    # Adresse + post nr + by
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
pris                    float,
antal                   int,
kommentar               varchar(100)
)engine = innodb;

drop table if exists varer;
create table varer
(
indkøbspris             float,
højde                   int,
bredde                  int,
længde                  int,
salgspris               float
) engine = innodb;

drop table if exists vare_grupper;
create table vare_grupper
(
grp_nr                  int,            # Et unikt nr som repræsenterer en vare gruppe
navn                    varchar(25),    # Navet på varegruppen
primary key(grp_nr)
) engine =innodb;

drop table if exists faktura;
create table faktura
(
faktura_nr              int,            # Unikt nr som står i toppen af faktura seddelen
faktureringsdato        int,            # Dato for oprettelse af faktura seddelen
vedrørende              varchar(100),
betalingsbetingelser    varchar(50),
sendt_dato              datetime,       # Dato for hvornår fakturaen er sendt
faktureringsadresse     varchar(50),
miljøafgift             int,            
type                    int,            # Bedemand eller almindelig - skal rettes i klassediagram
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
procent                 float,

primary key(provisionsnr)
) engine = innodb;

drop table if exists provisionsseddel_linje;
create table provisionsseddel_linje
(
antal                   int,
beskrivelse             text,
enhedspris              int,
beløb                   float
) engine = innodb;

drop table if exists samarbejdspartnere;
create table samarbejdspartnere
(
firmanavn               varchar(50),
adresse                 varchar(50),
postnr                  char(4),
bynavn                  varchar(50),
tlf                     char(8),        # 8 cifre uden landekode
cvr_nr                  char(8),        # Et CVR nummer er på 8 cifre
konto_oplysninger       varchar(50)     # Reg + Kontonr + Bank
) engine = innodb;

drop table if exists skriftype;
create table skrifttype
(
navn                    varchar(50),
pris_pr_bokstav         float
) engine = innodb;

drop table if exists dekoration;
create table dekoration
(
navn                    varchar(50),
pris                    float
) engine = innodb;
