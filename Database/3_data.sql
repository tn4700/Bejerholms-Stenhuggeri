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

insert into faktureringsadresse (adresse, post_nr)
values
('Gottliebsvej 7', '4700'),
('Hejvej 14', '4700'),
('Farligvej 13', '4700')
;

insert into varegruppe (navn)
values
('Gravsten'),
('Bronce Dekorationer'),
('Granitplader'),
('Fuglebade'),
('Granitvaser');

insert into varetype (navn)
values
('O. Storm Broncedekoration'),
('Strassacker Broncedekoration'),
('Granitplan'),
('Fuglebad'),
('Granitvase');

insert into vare (grp_nr,navn,højde,bredde,indkøbspris,salgspris,type_id,overflade,dekoration,vareStatus)
values
('1','Sort Svensk','55','32','950','3300',null,'2',true,'0'),
('1','Mørk Halmstad Hjerte','54','43','850','4600',null,'2',false,'1'),
('1','Lys Halmstad','45','36','650','3200',null,'2',true,'0'),
('1','Paradis','43','38','700','3200',null,'2',false,'0'),
('1','Orion','54','49','800','4700',null,'2',true,'0'),
('1','Orion','43','45','800','4100',null,'2',true,'0'),
('1','Lapland','52','43','850','3400',null,'1',false,'0'),
('1','Lys Multicolor','58','40','650','3200',null,'1',false,'0'),
('1','Lys Halmstad','45','34','650','3200',null,'2',false,'0'),
('1','Halmstad m/ true bånd','53','44','800','5400',null,'1',false,'0'),
('1','Halmstad','53','40','800','3200',null,'2',false,'0'),
('1','Auroa','57','40','900','3500',null,'2',false,'0'),
('1','Halmstad','58','39','8000','3300',null,'1',false,'0'),
('1','Wiscont White','58','42','750','3500',null,'1',false,'0'),
('1','Orion','57','39','800','3300',null,'1',false,'0'),
('1','Natursten m/ true bånd','65','50','350','3400',null,'1',false,'0'),
('1','Lys Multicolor','49','39','650','3200',null,'1',false,'0'),
('1','Sort Svensk','50','38','950','3800',null,'2',false,'0'),
('1','Wiscont White','51','41','750','3400',null,'1',false,'0'),
('1','Blue Pearl','53','34','900','3400',null,'2',false,'0'),
('1','Halmstad','50','38','8000','3200',null,'1',false,'0'),
('1','Natursten','42','33','150','2800',null,'1',false,'0'),
('1','Lys Halmstad','46','36','650','3200',null,'2',false,'0'),
('1','Auroa','58','37','750','3500',null,'2',true,'0'),
('1','Tolga','56','40','600','3300',null,'1',false,'0'),
('1','Halmstad','53','36','470','3200',null,'1',true,'0'),
('1','Halmstad m/true bånd','44','35','470','3200',null,'1',true,'0'),
('1','Rød Multicolor m/ true kant','60','40','650','3400',null,'1',false,'0'),
('1','Orion Urneplade','60','40','850','4500',null,'1',true,'0'),
('1','Kashmir  White','68','65','1900','10500',null,'2',false,'0'),
('1','Sort Svensk','70','68','6200','14500',null,'2',true,'0'),
('2','Fugl 181op',null,null,'116','286','1','0',true,'0'),
('2','Fugl 181op',null,null,'116','286','1','0',true,'0'),
('2','Fugl 181op',null,null,'116','286','1','0',true,'0'),
('2','Fugl 181op',null,null,'116','286','1','0',true,'0'),
('2','Fugl 181skrå',null,null,'116','286','1','0',true,'0'),
('2','Fugl 181skrå',null,null,'116','286','1','0',true,'0'),
('2','Fugl n227',null,null,'146','286','1','0',true,'0'),
('2','Blomst 2631v',null,null,'115','500','1','0',true,'0'),
('2','Blomst 373h',null,null,'69','270','1','0',true,'0'),
('2','Blomst 263v',null,null,'189','500','1','0',true,'0'),
('2','Hund 99005',null,null,'175','500','1','0',true,'0'),
('2','Fugl 85328v',null,null,'450','900','2','0',true,'0'),
('2','Fugl 85328h',null,null,'450','900','2','0',true,'0'),
('2','Fugl 85368',null,null,'450','900','2','0',true,'0'),
('2','Blomst 20137+39',null,null,'1100','2200','2','0',true,'0'),
('2','Blomst 31240',null,null,'2150','4300','2','0',true,'0'),
('2','Blomst 29214',null,null,'1200','2400','2','0',true,'0'),
('2','Blomst 31960+20',null,null,'1250','2500','2','0',true,'0'),
('2','Blomst 31960+20',null,null,'1250','2500','2','0',true,'0'),
('2','Blomst 31960+20',null,null,'1250','2500','2','0',true,'0'),
('2','Blomst 31960+28',null,null,'1925','3850','2','0',true,'0'),
('2','Blomst 20611+15',null,null,'425','850','2','0',true,'0'),
('2','Sommerfugl 20367',null,null,'775','1550','2','0',true,'0'),
('2','Hjerte 20408(a)+10',null,null,'550','1100','2','0',true,'0'),
('2','Hjerte 20408(a)+10',null,null,'550','1100','2','0',true,'0'),
('2','Hjerte 20408+10',null,null,'625','1250','2','0',true,'0'),
('2','Hjerte 20408+10',null,null,'625','1250','2','0',true,'0'),
('2','Lampe 40148',null,null,'1475','2950','2','0',true,'0'),
('3','Mørk Halmstad','134','83','1800','0','3','0',false,'0'),
('3','Wiscont White','100','97','1600','0','3','0',false,'0'),
('4','Blå Rønne','22','18','75','350','4','0',false,'0'),
('4','Vonga','25','21','75','350','4','0',false,'0'),
('4','Halmstad','22','19','75','350','4','0',false,'0'),
('4','Rød Bohus Hjerte','27','26','75','450','4','0',false,'0'),
('5','Rund Sort Svensk','0','0','360','650','5','0',false,'0'),
('5','Rund Sort Svensk','0','0','360','650','5','0',false,'0'),
('5','Rund Sort Svensk','0','0','360','650','5','0',false,'0'),
('5','Rund Sort Svensk','0','0','360','650','5','0',false,'0'),
('5','Rund Sort Svensk','0','0','360','650','5','0',false,'0'),
('5','Rød Bohus','0','0','347','650','5','0',false,'0'),
('5','Vonga','0','0','347','650','5','0',false,'0');

insert into kirkegård(navn)
values
('Næstved Kirkegård'),
('Slagelse Kirkegård'),
('Korsør Kirkegård'),
('Paris Kirkegård');

insert into ordre (tlf, ordre_nr,ordretype,ordredato,leveringdato,afhentningsdato,bemærkning,bemærkning_ekstra,kirkegård_id,afdeling,afdødnavn,række,nummer,gravType)
values
('20332836','00001',true,'2013-04-30 12:50:32','2013-05-10 12:50:32','2013-05-15 12:50:32','Bemærkning','Bemærkning_ekstra','1','1','Gunner','10','1',true),
('50111211','00002',true,'2013-04-1 13:00:00','2013-05-11 13:00:00','2013-05-16 13:00:00','Bemærkning','Bemærkning_ekstra','2','1','Gunner','10','2',true),
('31255685','00003',true,'2013-04-2 13:00:00','2013-06-11 13:00:00','2013-05-17 13:00:00','Bemærkning','Bemærkning_ekstra','3','1','Gunner','11','1',true),
('31255685','00007',true,'2013-04-2 13:00:00','2013-06-11 13:00:00','2013-05-17 13:00:00','Bemærkning','Bemærkning_ekstra','3','1','Gunner','11','1',true),
('28931093','00004',true,'2013-04-2 13:00:00','2013-06-11 13:00:00','2013-05-18 13:00:00','Bemærkning','Bemærkning_ekstra','4','1','Gunner','11','2',true);

insert into tegntype (navn,pris_pr_tegn)
values
('Indh. m/ alm. farve','65.00'),
('Indh. m/ guld','90.00'),
('Indh. m/ guld i ru sten','115.00'),
('Faks. indh. m/ farve','98.00'),
('Faks. indh. m/ guld','118.00'),
('Indh. i egen sten- m/ alm. farve','75.00'),
('Indh. i egen sten- m/ alm. guld','118.00'),
('Håndtegnet & Håndhugget','130.00'),
('Håndtegnet & Sandblæste','90.00'),
('Bronce bogstaver','75.00'),
('Opmaling af eksisterende','35.00'),
('Oppudsning af Bronce','55.00'),
('Opforgyldning i pol. sten','65.00'),
('Opforgyldning i ru sten','95.00');

insert into inskription(tegn_id, skrifttype)
values
('2','ARIAL'),
('4','OLD ENGLISH'),
('7','Agmena'),
('10','Flexo');

insert into inskription_linje(linje_nr, inskription_id, linje_type, inskription)
values
('1','1','1','Hej med dig'),('2','1','1','min mor'),('3','1','1','og du er'),('4','1','1','den bedste hej'),('5','1','1','med dig far'),
('1','2','2','Anette Mi Stidsing'),('2','2','2','* 25. 6. 1992  + 1. 1. 2013'),('3','2','1','Niklas Renner Nielsen'),('4','2','1','* 25. 6. 1992  + 1. 1. 2013'),('5','2','2','Hvil i fred'),
('1','3','1','Hej'),('2','3','1','mor'),('3','3','3',''),('4','3','3',''),('5','3','3',''),
('1','4','1','Kagemand 2000-2001'),('2','4','1','hvil i fred'),('3','4','0',''),('4','4','0',''),('5','4','0','');

insert into tom_linje (navn,pris,antal)
values
('Navn1','1000','1'),
('Navn2','2000','2'),
('Navn3','3000','1'),
('Navn4','4000','1');


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

insert into kontoudtog (kontoudtog_nr,dato,sendt_dato)
values
('00002','2013-04-30 12:50:32','2013-04-30 12:20:32'),
('00003','2013-04-30 13:50:32','2013-04-30 13:20:32'),
('00004','2013-04-30 14:50:32','2013-04-30 14:20:32');

insert into provisionsseddel (provisions_nr, kontoudtog_nr, dato)
values
('00002','00002','2013-05-02 15:20:32'),
('00003','00003','2013-05-03 16:20:32'),
('00004','00004','2013-05-04 17:20:32');

insert into faktura (bedemand_tlf, provisions_nr, ordre_nr, faktura_nr,faktureringsdato,sendt_dato,adresse_id,fakturatype,betalingsstatus)
values
(null, null,'00002', '0050111211-00002','2013-04-30 12:50:32','2013-05-01 12:50:32',null,false,false),
(null, null,'00003', '0031255685-00003','2013-04-30 13:50:32','2013-05-01 13:50:32',null,false,true),
('58350001', '00004','00004', '0028931093-00004','2013-04-30 14:50:32','2013-05-01 14:50:32',null,true,false);

insert into user (brugernavn,pw)
values
('martinhana','martin10'),
('Mathias Bejerholm','Mathias20'),
('test','123');