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

alter table inskription
add column id int auto_increment,
add primary key(id);

#fase 2 - For hver stærk entitet oprettes en tabel, med registrering af primærnøglen.
#Alle tabeller er oprettet i 1_entiteter scriptet

#fase 3 - For hver 1:1 forbindelse tilføjes primærnøglen fra den ene tabel som 
#fremmednøgle i den anden.

alter table vare_linje
add column vare_nr int,
add foreign key(vare_nr) references varer(vare_nr),
add column inskription_id int,
add foreign key(inskription_id) references inskription(id),
add column tom_linje_id int,
add foreign key(tom_linje_id) references tom_linje(id);

alter table faktura
add column ordre_nr int,
add foreign key(ordre_nr) references ordre(ordre_nr);

alter table provisionsseddel
add column faktura_nr int,
add foreign key(faktura_nr) references faktura(faktura_nr);

alter table kontoudtog
add column faktura_nr int,
add foreign key(faktura_nr) references faktura(faktura_nr);

#fase 4 - For hver 1:n forbindelse tilføjes primærnøglen fra 1-siden som fremmednøgle 
#på n-siden.

alter table varer
add column grp_nr int,
add foreign key(grp_nr) references varegrupper(grp_nr);

alter table vare_linje
add column ordre_nr int,
add foreign key(ordre_nr) references ordre(ordre_nr),
add primary key(ordre_nr, linje_nr);

alter table inskription
add column tegn_id int,
add foreign key(tegn_id) references tegntype(id);

alter table kunde
add column post_nr char(4),
add foreign key(post_nr) references postnumre(post_nr);

alter table samarbejdspartnere
add column post_nr char(4),
add foreign key(post_nr) references postnumre(post_nr);

alter table ordre
add column tlf char(8),
add foreign key(tlf) references kunde(tlf);

alter table faktura
add column bedemand_cvr char(10),
add foreign key(bedemand_cvr) references samarbejdspartnere(cvr_nr);

alter table provisionsseddel_linje
add column provisions_nr int,
add foreign key(provisions_nr) references provisionsseddel(provisions_nr),
add primary key(provisions_nr, linje_nr);

alter table kontoudtog_linje
add column kontoudtog_nr int,
add foreign key(kontoudtog_nr) references kontoudtog(kontoudtog_nr),
add primary key(kontoudtog_nr, linje_nr);

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