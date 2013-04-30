use bejerholmstenhuggeri;

insert into kunde (fornavn, efternavn, adresse, tlf)
values
('Martin','Hana','Østre Ringvej 40 1. TV','20332836'),
('Thomas','Nielsen','Østre Ringvej 49 2. TV','11111111'),
('Niklas','Nielsen','Fiktivvej 152','22222222'),
('Anette','Stidsing','Eventyrvej 27','33333333');

insert into postnumre (postnummer,bynavn)
values
('4700','Næstved'),
('4700','Næstved'),
('4700','Næstved'),
('4684','Fensmark');

insert into ordre (ordrenr,ordretype,ordredato,leveringdato,afhentningsdato,bemærkning,arbejdstimer,leveringsadresse,kirkegård,afdeling)
values
('1','2','2013-04-30 12:50:32','2013-05-10 12:50:32','2013-05-15 12:50:32','Bemærkning','74','Østrering vej 40 1. tv','Vor Frue Kirke','10'),
('2','1','2013-04-1 13:00:00','2013-05-11 13:00:00','2013-05-16 13:00:00','Bemærkning','74','Østre Ringvej 49 2. TV','Vor Frue Kirke','11'),
('1','1','2013-04-2 13:00:00','2013-06-11 13:00:00','2013-05-17 13:00:00','Bemærkning','74','Fiktivvej 152','Kirkegård','12'),
('2','2','2013-04-2 13:00:00','2013-06-11 13:00:00','2013-05-18 13:00:00','Bemærkning','74','Eventyrvej 27','Kirkegård','13');

insert into tilføjelse (værkstedstimer,rensning,transport,afhentning,levering)
values
('74','20','20','20','14'),
('74','20','20','20','14'),
('74','20','20','20','14'),
('74','20','20','20','14');

insert into vare_linje (linjeNr)
values
('1'),
('2'),
('3'),
('3');

insert into tomLinje (navn,pris,antal,kommentar)
values
('Navn1','1000,75','1','fiktiv vare 1'),
('Navn2','2000,80','1','fiktiv vare 2'),
('Navn3','3000,33','1','fiktiv vare 3'),
('Navn4','4000,21','1','fiktiv vare 4');

insert into varer (varenummer, kommentar, højde, bredde, længde, indkøbspris, salgspris)
values
(1,'vare 1','50','50','50','500','3000'),
(2,'vare 2','50','50','50','500','3000'),
(3,'vare 3','50','50','50','500','3000'),
(4,'vare 4','50','50','50','500','3000');

insert into vare_grupper (grp_nr,navn)
values
(1,'Navn på varegruppe 1'),
(2,'Navn på varegruppe 2'),
(3,'Navn på varegruppe 3'),
(4,'Navn på varegruppe 4');

insert into inskription (inskription,tegnpris)
values
('AREIAL','100,10'),
('OLD ENGLISH','400,25'),
('Agmena','600,50'),
('Flexo','800,75');

insert into dekoration (navn,pris)
values
('NavnA','500,50'),
('NavnB','2001,25'),
('NavnC','3002,50'),
('NavnD','4003,75');

insert into faktura (faktura_nr,faktureringsdato,vedrørende,betalingsbetingelser,sendt_dato,faktureringsadresse,fakturatype,betalingsstatus)
values
('0001','2013-04-30 11:50:32','Martin Hana','Visa/Dankort','2013-05-01 11:50:32','Østre Ringvej 40 1.TV, 4700 Næstved',true,true),
('0002','2013-04-30 12:50:32','Thomas Nielsen','Visa/Dankort','2013-05-01 12:50:32','Østre Ringvej 49 2.TV, 4700 Næstved',true,false),
('0003','2013-04-30 13:50:32','Niklas Nielsen','Kontant','2013-05-01 13:50:32','Østre Ringvej 40 1.TV, 4700 Næstved',true,true),
('0004','2013-04-30 14:50:32','Anette Stidsing','Kontant','2013-05-01 14:50:32','Østre Ringvej 40 1.TV, 4700 Næstved',true,false);

insert into kontoudtog (konto_udtog_nr,dato,vedrørende,sendt_dato)
values
('0001','2013-04-30 11:50:32','Martin Hana','2013-04-30 11:20:32'),
('0002','2013-04-30 12:50:32','Thomas Nielsen','2013-04-30 12:20:32'),
('0003','2013-04-30 13:50:32','Niklas Nielsen','2013-04-30 13:20:32'),
('0004','2013-04-30 14:50:32','Anette Stidsing','2013-04-30 14:20:32');

insert into kontoudtog_linje (antal,beskrivelse,pris)
values
('1','BeskrivelseA','1000'),
('1','BeskrivelseB','2000'),
('1','BeskrivelseC','3000'),
('1','BeskrivelseD','4000');

insert into provisionsseddel (antal,beskrivelse,enhedspris,pris)
values
('1','BeskrivelseA','1','1000'),
('1','BeskrivelseB','1','2000'),
('1','BeskrivelseC','1','3000'),
('1','BeskrivelseD','1','4000');

insert into samarbejdspartnere (firmanavn,adresse,tlf,cvr_nr,registreringsnr,kontonr,bank)
values
('Bedeman Berner','Fiktivvej 666','11112222','16276480','1231','6070123456','BankenA'),
('Bedeman Berner','Fiktivvej 666','11112222','16276480','1232','6070123457','BankenB'),
('Bedeman Berner','Fiktivvej 666','11112222','16276480','1233','6070123458','BankenC'),
('Bedeman Berner','Fiktivvej 666','11112222','16276480','1234','6070123459','BankenD');

insert into user (brugernavn,pw)
values
('martinhana','martin10'),
('thomasnielsen','thomas20'),
('niklasnielsen','niklas30'),
('anettestidsing','anette40');

insert into konstanter (nr,navn,procentsats)
values
('0001','Martin Hana','15'),
('0002','Thomas Nielsen','15'),
('0003','Niklas Nielsen','15'),
('0004','Anette Stidsing','15');