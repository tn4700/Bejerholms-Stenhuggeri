use bejerholmstenhuggeri;

insert into kunde (fornavn, efternavn, adresse, tlf)
values
('Martin','Hana','Østre Ringvej 40 1. TV','20332836'),
('Thomas','Nielsen','Østre Ringvej 49 2. TV','11111111'),
('Niklas','Nielsen','Fiktivvej 152','22222222'),
('Anette','Stidsing','Eventyrvej 27','33333333');

insert into postnumre (post_nr,byNavn)
values
('4200','Slagselse'),
('4300','Holbæk'),
('4700','Næstved'),
('4684','Fensmark');

insert into ordre (ordre_nr,ordretype,ordredato,ordrestatus,leveringdato,afhentningsdato,bemærkning,leveringsadresse,kirkegård,afdeling,afdødnavn,række,nummer,plads_navne,gravType)
values
('0',true,'2013-04-30 12:50:32','1','2013-05-10 12:50:32','2013-05-15 12:50:32','Bemærkning','Østrering vej 40 1. tv','Vor Frue Kirke','10','Gunner','10','1','1',true),
('1',true,'2013-04-1 13:00:00','1','2013-05-11 13:00:00','2013-05-16 13:00:00','Bemærkning','Østre Ringvej 49 2. TV','Vor Frue Kirke','11','Gunner','10','2','1',true),
('2',true,'2013-04-2 13:00:00','1','2013-06-11 13:00:00','2013-05-17 13:00:00','Bemærkning','Fiktivvej 152','Kirkegård','12','Gunner','11','1','1',true),
('3',true,'2013-04-2 13:00:00','1','2013-06-11 13:00:00','2013-05-18 13:00:00','Bemærkning','Eventyrvej 27','Kirkegård','13','Gunner','11','2','1',true);

insert into varegrupper (grp_nr,navn)
values
(1,'Navn på varegruppe 1'),
(2,'Navn på varegruppe 2'),
(3,'Navn på varegruppe 3'),
(4,'Navn på varegruppe 4');

insert into varer (vare_nr, navn, højde, bredde, indkøbspris, salgspris, typenavn,overflade,dekoration)
values
(1,'vare 1','50','50','500','3000','typenavn 1','overflade 1',false),
(2,'vare 2','50','50','500','3000','typenavn 2','overflade 2',false),
(3,'vare 3','50','50','500','3000','typenavn 3','overflade 3',true),
(4,'vare 4','50','50','500','3000','typenavn 4','overflade 4',true);

insert into tom_linje (navn,pris,antal,kommentar)
values
('Navn1','1000','1','fiktiv vare 1'),
('Navn2','2000','1','fiktiv vare 2'),
('Navn3','3000','1','fiktiv vare 3'),
('Navn4','4000','1','fiktiv vare 4');

insert into tegntype (navn,pris_pr_tegn)
values
('Indhuggede bogstaver m/ alm. farve','65.00'),
('Indhuggede bogstaver m/ guld','90.00'),
('Indhuggede bogstaver m/ guld i ru sten','115.00'),
('Faksimile indhuggede m/ farve','98.00'),
('Faksimile indhuggede m/ guld','118.00'),
('Indhuggede bogstaver i egen sten- m/ alm. farve','75.00'),

('Indhuggede bogstaver i egen sten- m/ alm. guld','118.00'),
('Håndtegnet bogstaver/ Håndhugget','130.00'),
('Håndtegnet bogstaver/ Sandblæste','90.00'),
('Bronce bogstaver','75.00'),
('Opmaling af eksisterende bogstaver','35.00'),
('Oppudsning af Bronce bogstaver','55.00'),
('Opforgyldning af bogstaver i pol. sten','65.00'),
('Opforgyldning af bogstaver i ru sten','95.00');

insert into inskription (inskription, skrifttype)
values
('inskription','AREIAL'),
('inskription1','OLD ENGLISH'),
('inskription2','Agmena'),
('inskription3','Flexo');

insert into vare_linje (linje_nr, vare_nr, inskription_id, tom_linje_id, ordre_nr)
values
('1','1',null,null,'0'),
('2',null,null,'1','1'),
('3',null,'1',null,'2'),
('4',null,null,'2','3');


insert into faktura (ordre_nr, faktura_nr,faktureringsdato,vedrørende,betalingsbetingelser,sendt_dato,faktureringsadresse,fakturatype,betalingsstatus)
values
('0', '0','2013-04-30 11:50:32','Martin Hana','Netto 7 dage','2013-05-01 11:50:32','Østre Ringvej 40 1.TV, 4700 Næstved',true,true),
('0', '1','2013-04-30 12:50:32','Thomas Nielsen','Netto 7 dage','2013-05-01 12:50:32','Østre Ringvej 49 2.TV, 4700 Næstved',true,false),
('0', '2','2013-04-30 13:50:32','Niklas Nielsen','Netto 7 dage','2013-05-01 13:50:32','Østre Ringvej 40 1.TV, 4700 Næstved',true,true),
('1', '3','2013-04-30 14:50:32','Anette Stidsing','Netto 7 dage','2013-05-01 14:50:32','Østre Ringvej 40 1.TV, 4700 Næstved',true,false);

insert into kontoudtog (kontoudtog_nr,dato,vedrørende,sendt_dato)
values
('0','2013-04-30 11:50:32','Martin Hana','2013-04-30 11:20:32'),
('1','2013-04-30 12:50:32','Thomas Nielsen','2013-04-30 12:20:32'),
('2','2013-04-30 13:50:32','Niklas Nielsen','2013-04-30 13:20:32'),
('3','2013-04-30 14:50:32','Anette Stidsing','2013-04-30 14:20:32');

insert into kontoudtog_linje (antal,linje_nr,beskrivelse,pris,kontoudtog_nr)
values
('1','0','BeskrivelseA','1000','0'),
('1','1','BeskrivelseB','2000','1'),
('1','2','BeskrivelseC','3000','2'),
('1','3','BeskrivelseD','4000','3');

insert into provisionsseddel (provisions_nr,dato,vedrørende,overførelsesbetingelser)
values
('0','2013-05-01 14:20:32','1','1000'),
('1','2013-05-02 15:20:32','1','2000'),
('2','2013-05-03 16:20:32','1','3000'),
('3','2013-05-04 17:20:32','1','4000');

insert into provisionsseddel_linje(antal,linje_nr, beskrivelse,enhedspris,pris,provisions_nr)
values
('1','0','BeskrivelseA','100.60','100.60','0'),
('1','1','BeskrivelseB','200.10','200.10','1'),
('1','2','BeskrivelseC','300.25','300.25','2'),
('1','3','BeskrivelseD','400.50','400.50','3');


insert into samarbejdspartnere (firmanavn,adresse,tlf,cvr_nr,registrerings_nr,konto_nr,bank)
values
('Bedemand ApS','Bedemandsvej 1 4220 Korsør','58350001','12943790','2190','0754567300','Nordea'),
('Bedeman Berner','Fiktivvej 666','11112222','16276482','1232','6070123457','BankenB'),
('Bedeman Berner','Fiktivvej 666','11112222','16276483','1233','6070123458','BankenC'),
('Bedeman Berner','Fiktivvej 666','11112222','16276484','1234','6070123459','BankenD');

insert into user (brugernavn,pw)
values
('martinhana','martin10'),
('thomasnielsen','thomas20'),
('niklasnielsen','niklas30'),
('anettestidsing','anette40');

insert into konstanter (nr,navn,procentsats)
values
('0','Martin Hana','15'),
('1','Thomas Nielsen','15'),
('2','Niklas Nielsen','15'),
('3','Anette Stidsing','15');