use bejerholmstenhuggeri;

-- test af foreign keys

update faktura
set ordre_nr = 7
where ordre_nr = 1;

update ordre
set ordre_nr = 9
where ordre_nr = 0;


-- delete, select, update, insert

select * from (faktura natural join ordre);

select kunde.post_nr,postnummer.bynavn, kunde.fornavn, kunde.efternavn, kunde.adresse, kunde.tlf from kunde join postnummer on kunde.post_nr = postnummer.post_nr where kunde.tlf = 20332836;

select kunde.fornavn, kunde.efternavn, kunde.adresse, kunde.tlf, postnummer.post_nr, postnummer.bynavn from kunde, postnummer where kunde.post_nr = postnummer.post_nr and kunde.tlf = 20332836;

select  kunde.fornavn, kunde.efternavn, kunde.adresse, kunde.tlf, kunde.post_nr, postnummer.bynavn from kunde join postnummer on postnummer.post_nr = kunde.post_nr where kunde.tlf=28931093;

select  samarbejdspartner.firmanavn, samarbejdspartner.adresse, samarbejdspartner.cvr_nr, 
samarbejdspartner.registrerings_nr, samarbejdspartner.konto_nr, samarbejdspartner.bank, samarbejdspartner.post_nr, postnummer.bynavn
                from samarbejdspartner join postnummer on postnummer.post_nr = samarbejdspartner.post_nr where samarbejdspartner.cvr_nr = 12943790;

select ordre.ordre_nr, ordre.ordretype, ordre.ordredato, ordre.ordrestatus, ordre.leveringdato, ordre.bemærkning, ordre.leveringsadresse, ordre.kirkegård,
ordre.afdeling, ordre.afdødnavn, ordre.række, ordre.nummer, ordre.plads_navne, ordre.gravtype from ordre join kunde on kunde.tlf = ordre.tlf where ordre.ordre_nr = 1;