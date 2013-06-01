use bejerholmstenhuggeri;

-- Test der kontrollerer at primærnøgler samt fremmednøgler korrekt registrerede.


update ordre
set ordre_nr = 00009
where ordre_nr = 00001;

update ordre
set kirkegård_id = 7
where kirkegår_id = 3;

update kunde
set tlf = 29038940
where tlf = 28931093;

update kunde
set post_nr = 5695
where post_nr = 4700;

update vare
set vare_nr = 50
where vare_nr = 20;

update vare
set grp_nr = 9
where grp_nr = 3;

update faktura
set ordre_nr = 7
where ordre_nr = 1;

update samarbejdspartner
set tlf = 28282828
where tlf = 58350001;



-- select

select navn, sum(indkøbspris), min(indkøbspris), max(indkøbspris)
from vare;


select vare_nr, navn, sum(salgspris), max(salgspris), min(salgspris)
from vare
group by vare_nr
having max(salgspris) < 850;

select * from kunde where post_nr = 4700;

Select * from kunde
where efternavn like '%sen%';


-- delete

delete from ordre 
where ordre_nr = '00007';

delete from vare
where vare_nr = 8;

--  insert 

insert into postnummer(post_nr, byNavn)
values
('8981', 'Spentrup'),
('9000', 'Ålborg');


-- update

 update kunde
set adresse = 'Christiansvej 43'
where adresse = 'Eventyrvej 27';


-- queries der udtrækker data fra mere end en tabel.

select ordre.ordre_nr, ordre.leveringdato, kunde.tlf, kunde.fornavn, kunde.efternavn 
from ordre, kunde
where ordre.tlf = kunde.tlf
group by ordre.ordre_nr;

select * 
from (varegruppe left outer join vare on varegruppe.grp_nr = vare.grp_nr);

select varegruppe.navn, vare.navn, vare.vare_nr
from (varegruppe join vare on varegruppe.grp_nr=vare.grp_nr)
where varegruppe.grp_nr = 1;


