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
('00001',true,'2013-04-30 12:50:32','1','2013-05-10 12:50:32','2013-05-15 12:50:32','Bemærkning','Østrering vej 40 1. tv','Vor Frue Kirke','10','Gunner','10','1','1',true),
('00002',true,'2013-04-1 13:00:00','1','2013-05-11 13:00:00','2013-05-16 13:00:00','Bemærkning','Østre Ringvej 49 2. TV','Vor Frue Kirke','11','Gunner','10','2','1',true),
('00003',true,'2013-04-2 13:00:00','1','2013-06-11 13:00:00','2013-05-17 13:00:00','Bemærkning','Fiktivvej 152','Kirkegård','12','Gunner','11','1','1',true),
('00004',true,'2013-04-2 13:00:00','1','2013-06-11 13:00:00','2013-05-18 13:00:00','Bemærkning','Eventyrvej 27','Kirkegård','13','Gunner','11','2','1',true);


insert into vare_linje (linje_nr,vare_nr,inkription_id,tom_linje_id,ordre_nr)
values
('1','1',null,'','00001'),
('2',null,null,'','00002'),
('3',null,'1','','00003'),
('4',null,null,'','00004');

insert into tom_linje (navn,pris,antal,kommentar)
values
('Navn1','1000,75','1','fiktiv vare 1'),
('Navn2','2000,80','1','fiktiv vare 2'),
('Navn3','3000,33','1','fiktiv vare 3'),
('Navn4','4000,21','1','fiktiv vare 4');

insert into varer (vare_nr, navn, højde, bredde, indkøbspris, salgspris, typenavn,overflade,dekoration)
values
(1,'vare 1','50','50','500','3000','typenavn 1','overflade 1',false),
(2,'vare 2','50','50','500','3000','typenavn 2','overflade 2',false),
(3,'vare 3','50','50','500','3000','typenavn 3','overflade 3',true),
(4,'vare 4','50','50','500','3000','typenavn 4','overflade 4',true);

insert into varegrupper (grp_nr,navn)
values
(1,'Navn på varegruppe 1'),
(2,'Navn på varegruppe 2'),
(3,'Navn på varegruppe 3'),
(4,'Navn på varegruppe 4');

insert into inskription (inskription)
values
('AREIAL'),
('OLD ENGLISH'),
('Agmena'),
('Flexo');

insert into tegntype (navn,pris_pr_tegn)
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

insert into kontoudtog (kontoudtog_nr,dato,vedrørende,sendt_dato)
values
('0001','2013-04-30 11:50:32','Martin Hana','2013-04-30 11:20:32'),
('0002','2013-04-30 12:50:32','Thomas Nielsen','2013-04-30 12:20:32'),
('0003','2013-04-30 13:50:32','Niklas Nielsen','2013-04-30 13:20:32'),
('0004','2013-04-30 14:50:32','Anette Stidsing','2013-04-30 14:20:32');

insert into kontoudtog_linje (antal,linje_nr,beskrivelse,pris)
values
('1','1','BeskrivelseA','1000'),
('1','2','BeskrivelseB','2000'),
('1','3','BeskrivelseC','3000'),
('1','4','BeskrivelseD','4000');

insert into provisionsseddel (provisions_nr,dato,vedrørende,overførelsesbetingelser)
values
('1','2013-05-01 14:20:32','1','1000'),
('1','2013-05-02 15:20:32','1','2000'),
('1','2013-05-03 16:20:32','1','3000'),
('1','2013-05-04 17:20:32','1','4000');

insert into provisionsseddel_linje(antal,linje_nr, beskrivelse,enhedspris,pris)
values
('1','1','BeskrivelseA','100,60','100,60'),
('1','2','BeskrivelseB','200,10','200,10'),
('1','3','BeskrivelseC','300,25','300,25'),
('1','4','BeskrivelseD','400,50','400,50');


insert into samarbejdspartnere (firmanavn,adresse,tlf,cvr_nr,registrerings_nr,konto_nr,bank)
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