------------NAME:SHITAICHEN-----------
------------ID:1101876651-------------
drop index lion_idx;
drop index region_idx;
drop index ambulance_idx;
drop index pond_idx;

delete from user_sdo_geom_metadata where table_name = 'REGION';
delete from user_sdo_geom_metadata where table_name = 'LION';
delete from user_sdo_geom_metadata where table_name = 'POND';
delete from user_sdo_geom_metadata where table_name ='AMBULANCEAREA';

drop table lion;
drop table pond;
drop table ambulancearea;
drop table region;

