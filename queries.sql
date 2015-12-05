-------------------NAME:SHITAICHEN---------
-------------------ID:1101876651----------
--------------------Q1--------------------
SELECT l.id
from lion l
where SDO_FILTER(
l.shape,SDO_GEOMETRY(2003,null,null,SDO_ELEM_INFO_ARRAY(1,1003,3),
SDO_ORDINATE_ARRAY(150,200,400,350)))= 'TRUE';






--------------------Q2---------------------
select l.id
from lion l, pond p
where SDO_WITHIN_DISTANCE(l.shape, p.shape,'distance = 150')='TRUE' AND
p.pond_id = 'P1';




--------------------Q3---------------------
select /*+INDEX(p.pond_idx,l.lion_idx)*/
distinct p.pond_id
from lion l, pond p
where l.id = 'L2' and sdo_nn(p.shape, l.shape,'sdo_num_res = 3',1) ='TRUE' order by sdo_nn_distance(1);


--------------------Q4--------------------------
select /*+ordered*/
l.id, p.pond_id
from table(sdo_join('lion','shape','pond','shape', 'mask = inside')) c,
lion l, pond p
where c.rowid1 = l.rowid and c.rowid2 = p.rowid;



--------------------------Q5----------------------
SELECT r.region_id
  FROM lion l, region r
  WHERE SDO_RELATE(l.shape,
    r.shape,
    'mask=inside') = 'TRUE'
Minus
SELECT r.region_id
  FROM region r, pond p
  WHERE SDO_RELATE(p.shape,
    r.shape,
    'mask=inside+covered') = 'TRUE';


------------------------Q6------------------------

select a.id from lion a
minus
SELECT l.id
  FROM lion l, ambulancearea a
  WHERE SDO_RELATE(l.shape, a.shape, 'mask=inside') = 'TRUE';


