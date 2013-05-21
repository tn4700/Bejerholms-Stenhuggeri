use bejerholmstenhuggeri;

#fase 1 - Svage entiteter gøres stærke ved at der tilføjes en primær nøgle.
# Har ikke lavet primærnøgler til alle linje tabellerne da dette automatisk kommer
# når vi laver fase 2 i konverteringen

alter table tegntype
add column id int auto_increment,
add primary key(id);

alter table tom_linje
add column id int auto_increment,
add primary key(id);

alter table inskription_linje
add column id int auto_increment,
add primary key(id);

#fase 2 - For hver stærk entitet oprettes en tabel, med registrering af primærnøglen.
#Alle tabeller er oprettet i 1_entiteter scriptet

#fase 3 - For hver 1:1 forbindelse tilføjes primærnøglen fra den ene tabel som 
#fremmednøgle i den anden.

alter table vare_linje
add column vare_nr int,
add foreign key(vare_nr) references vare(vare_nr),
add column inskription_id int,
add foreign key(inskription_id) references inskription_linje(id),
add column tom_linje_id int,
add foreign key(tom_linje_id) references tom_linje(id);

alter table faktura
add column ordre_nr char(5),
add foreign key(ordre_nr) references ordre(ordre_nr);

alter table provisionsseddel
add column faktura_nr char(16),
add foreign key(faktura_nr) references faktura(faktura_nr);

alter table kontoudtog
add column provisions_nr char(5),
add foreign key(provisions_nr) references provisionsseddel(provisions_nr);

#fase 4 - For hver 1:n forbindelse tilføjes primærnøglen fra 1-siden som fremmednøgle 
#på n-siden.

alter table vare
add column grp_nr int,
add foreign key(grp_nr) references varegruppe(grp_nr);

alter table vare_linje
add column ordre_nr char(5),
add foreign key(ordre_nr) references ordre(ordre_nr),
add primary key(ordre_nr, linje_nr);

alter table inskription_linje
add column tegn_id int,
add foreign key(tegn_id) references tegntype(id);

alter table inskription
add column inskription_id int,
add foreign key(inskription_id) references inskription_linje(id),
add primary key(inskription_id, linje_nr);

alter table kunde
add column post_nr char(4),
add foreign key(post_nr) references postnummer(post_nr);

alter table samarbejdspartner
add column post_nr char(4),
add foreign key(post_nr) references postnummer(post_nr);

alter table ordre
add column tlf char(8),
add foreign key(tlf) references kunde(tlf);

alter table faktura
add column bedemand_tlf char(8),
add foreign key(bedemand_tlf) references samarbejdspartner(tlf);

#fase 5 - For hver n:m forbindelse oprettes en ny tabel med primærnøglerne fra de to
#tabeller som sammensat primærnøgle og med de to primærnøgler som fremmednøgler.
#Har ingen n:m forbindelser

#fase 6 - For hver flerværdi attribut oprettes en ny tabel med primærnøglen og flerværdi
#attributten som sammensat primærnøgle. Samtidig fjernes flerværdi attributten fra 
#den oprindelige tabel.
#Har ingen flerværdi attributter

#fase 7 - Hvis der findes forbindelser hvori der indgår mere end to entiteter skal 
#der oprettes en ny tabel med primærnøglerne fra de deltagende entiteter som 
#sammensat primærnøgle.
#Har ingen forbindelser hvor der indgår mere end 2 entiteter
