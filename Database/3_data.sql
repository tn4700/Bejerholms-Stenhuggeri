use bejerholmstenhuggeri;

insert into postnummer (post_nr,byNavn)
values
('4200','Slagelse'),
('4300','Holbæk'),
('4700','Næstved'),
('4684','Fensmark');

insert into kunde (post_nr, fornavn, efternavn, adresse, tlf)
values
('4700','Martin','Hana','Østre Ringvej 40 1. TV','20332836'),
('4700','Thomas','Nielsen','Østre Ringvej 49 2. TV','50111211'),
('4700','Niklas','Nielsen','Gottliebvej 15','31255685'),
('4700','Anette','Stidsing','Eventyrvej 27','28931093');

insert into varegruppe (navn)
values
('Gravsten'),
('Bronce Dekorationer'),
('Granitplader'),
('Fuglebade'),
('Granitvaser');


insert into vare (grp_nr, navn, højde, bredde, indkøbspris, salgspris, typenavn,overflade,dekoration)
values
('2','fugl 181op',null,null,'116','286','O. Storm Broncedekoration',null,true),
('1','DEN BEDSTE VARE','45','36','650','3200','Lys Halmstad','poleret',false),
('1','granitplade','200','300','3000','10000','granitplade','overflade 3',false),
('2','fugl 85328v',null,null,'450','900','Strassacker Broncedekoration',null,true);

insert into ordre (tlf, ordre_nr,ordretype,ordredato,ordrestatus,leveringdato,afhentningsdato,bemærkning, bemærkning_ekstra,leveringsadresse,kirkegård,afdeling,afdødnavn,række,nummer,plads_navne,gravType)
values
('20332836','00001',true,'2013-04-30 12:50:32','1','2013-05-10 12:50:32','2013-05-15 12:50:32','Bemærkning','Bemærkning_ekstra','Østrering vej 40 1. tv','Vor Frue Kirke','10','Gunner','10','1','1',true),
('50111211','00002',true,'2013-04-1 13:00:00','1','2013-05-11 13:00:00','2013-05-16 13:00:00','Bemærkning','Bemærkning_ekstra','Østre Ringvej 49 2. TV','Vor Frue Kirke','11','Gunner','10','2','1',true),
('31255685','00003',true,'2013-04-2 13:00:00','1','2013-06-11 13:00:00','2013-05-17 13:00:00','Bemærkning','Bemærkning_ekstra','Fiktivvej 152','Kirkegård','12','Gunner','11','1','1',true),
('28931093','00004',true,'2013-04-2 13:00:00','1','2013-06-11 13:00:00','2013-05-18 13:00:00','Bemærkning','Bemærkning_ekstra','Eventyrvej 27','Kirkegård','13','Gunner','11','2','1',true);

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

insert into inskription_linje (tegn_id, skrifttype)
values
('2','ARIAL'),
('4','OLD ENGLISH'),
('7','Agmena'),
('10','Flexo');

insert into inskription(linje_nr, inskription_id, linje_type, inskription)
values
('1','1','1','Hej med dig'),('2','1','1','min mor'),('3','1','1','og du er'),('4','1','1','den bedste hej'),('5','1','1','med dig far'),
('1','2','2','Anette Mi Stidsing'),('2','2','2','* 25. 6. 1992  + 1. 1. 2013'),('3','2','1','Niklas Renner Nielsen'),('4','2','1','* 25. 6. 1992  + 1. 1. 2013'),('5','2','2','Hvil i fred'),
('1','3','1','Hej'),('2','3','1','mor'),('3','3','3',''),('4','3','3',''),('5','3','3',''),
('1','4','1','Kagemand 2000-2001'),('2','4','1','hvil i fred'),('3','4','0',''),('4','4','0',''),('5','4','0','');

insert into tom_linje (navn,pris,antal,kommentar)
values
('Navn1','1000','1','fiktiv vare 1'),
('Navn2','2000','2','fiktiv vare 2'),
('Navn3','3000','1','fiktiv vare 3'),
('Navn4','4000','1','fiktiv vare 4');


insert into vare_linje (linje_nr, vare_nr, inskription_id, tom_linje_id, ordre_nr)
values
('1','2',null,null,'00001'),
('2',null,null,'1','00001'),
('3',null,'2',null,'00001'),
('1',null,'1',null,'00004');


insert into samarbejdspartner (post_nr, firmanavn,adresse,tlf,cvr_nr,registrerings_nr,konto_nr,bank)
values
('4700','Bedemand ApS','Bedemandsvej 1 4220 Korsør','58350001','12943790','2190','0754567300','Nordea'),
('4700','Bedemand Berner','Fiktivvej 666','11112226','16276482','1232','6070123457','BankenB'),
('4700','Bedemand Berner','Fiktivvej 666','11112222','16276483','1233','6070123458','BankenC'),
('4700','Bedemand Berner','Fiktivvej 666','11112224','16276484','1234','6070123459','BankenD');

insert into faktura (bedemand_tlf, ordre_nr, faktura_nr,faktureringsdato,vedrørende,sendt_dato,faktureringsadresse,fakturatype,betalingsstatus)
values
(null, '00001', '0020332836-00001','2013-04-30 11:50:32','Martin Hana','2013-05-01 11:50:32','Østre Ringvej 40 1.TV, 4700 Næstved',true,true),
(null,'00002', '0050111211-00002','2013-04-30 12:50:32','Thomas Nielsen','2013-05-01 12:50:32','Østre Ringvej 49 2.TV, 4700 Næstved',true,false),
(null,'00003', '0031255685-00003','2013-04-30 13:50:32','Niklas Nielsen','2013-05-01 13:50:32','Østre Ringvej 40 1.TV, 4700 Næstved',true,true),
('58350001','00004', '0028931093-00004','2013-04-30 14:50:32','Anette Stidsing','2013-05-01 14:50:32','Østre Ringvej 40 1.TV, 4700 Næstved',true,false);

insert into provisionsseddel (faktura_nr, provisions_nr,dato,vedrørende,overførelsesbetingelser)
values
('0020332836-00001','00001','2013-05-01 14:20:32','1','1000'),
('0050111211-00002','00002','2013-05-02 15:20:32','1','2000'),
('0031255685-00003','00003','2013-05-03 16:20:32','1','3000'),
('0028931093-00004','00004','2013-05-04 17:20:32','1','4000');

insert into kontoudtog (provisions_nr, kontoudtog_nr,dato,vedrørende,sendt_dato)
values
('00001','00001','2013-04-30 11:50:32','Martin Hana','2013-04-30 11:20:32'),
('00002','00002','2013-04-30 12:50:32','Thomas Nielsen','2013-04-30 12:20:32'),
('00003','00003','2013-04-30 13:50:32','Niklas Nielsen','2013-04-30 13:20:32'),
('00004','00004','2013-04-30 14:50:32','Anette Stidsing','2013-04-30 14:20:32');

insert into user (brugernavn,pw)
values
('martinhana','martin10'),
('Mahias BejerHolm','Mathias20');