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