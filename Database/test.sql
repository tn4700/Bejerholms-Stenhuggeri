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

select * from postnumre join kunde on postnumre.post_nr = kunde.post_nr where kunde.tlf = 11111111;