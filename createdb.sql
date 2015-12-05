------NAME:SHITAICHEN---------
------ID:1101876651-----------

CREATE TABLE lion (
  id VARCHAR(20) PRIMARY KEY,
  shape SDO_GEOMETRY);


CREATE TABLE region (
  region_id CHAR(5) PRIMARY KEY,
  num_of_vertices CHAR(5),
  shape SDO_GEOMETRY);




CREATE TABLE pond (
  pond_id CHAR(10) PRIMARY KEY,
  shape SDO_GEOMETRY);





CREATE TABLE ambulancearea (
  ambulance_id CHAR(5) PRIMARY KEY,
  shape SDO_GEOMETRY);



INSERT INTO user_sdo_geom_metadata
    (TABLE_NAME,
     COLUMN_NAME,
     DIMINFO,
     SRID)
  VALUES (
  'region',
  'shape',
  SDO_DIM_ARRAY(   
    SDO_DIM_ELEMENT('X', 0, 500, 0.5),
    SDO_DIM_ELEMENT('Y', 0, 500, 0.5)
     ),
  NULL   -- SRID
);


INSERT INTO user_sdo_geom_metadata
    (TABLE_NAME,
     COLUMN_NAME,
     DIMINFO,
     SRID)
  VALUES (
  'lion',
  'shape',
  SDO_DIM_ARRAY(   
    SDO_DIM_ELEMENT('X', 0, 500, 0.5),
    SDO_DIM_ELEMENT('Y', 0, 500, 0.5)
     ),
  NULL   -- SRID
);

INSERT INTO user_sdo_geom_metadata
    (TABLE_NAME,
     COLUMN_NAME,
     DIMINFO,
     SRID)
  VALUES (
  'pond',
  'shape',
  SDO_DIM_ARRAY(   
    SDO_DIM_ELEMENT('X', 0, 500, 0.5),
    SDO_DIM_ELEMENT('Y', 0, 500, 0.5)
     ),
  NULL   -- SRID
);

INSERT INTO user_sdo_geom_metadata
    (TABLE_NAME,
     COLUMN_NAME,
     DIMINFO,
     SRID)
  VALUES (
  'ambulancearea',
  'shape',
  SDO_DIM_ARRAY(   
    SDO_DIM_ELEMENT('X', 0, 500, 0.5),
    SDO_DIM_ELEMENT('Y', 0, 500, 0.5)
     ),
  NULL   -- SRID
);

CREATE INDEX region_idx
   ON region(shape)
INDEXTYPE IS MDSYS.SPATIAL_INDEX;

CREATE INDEX lion_idx
   ON lion(shape)
INDEXTYPE IS MDSYS.SPATIAL_INDEX;

CREATE INDEX pond_idx ON pond(shape)
INDEXTYPE IS MDSYS.SPATIAL_INDEX;


CREATE INDEX ambulance_idx
   ON ambulancearea(shape)
INDEXTYPE IS MDSYS.SPATIAL_INDEX;


Insert into AMBULANCEAREA (AMBULANCE_ID,SHAPE) values ('A1   ',MDSYS.SDO_GEOMETRY(2003,NULL,NULL,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,4),MDSYS.SDO_ORDINATE_ARRAY(100,490,100,310,190,400)));
Insert into AMBULANCEAREA (AMBULANCE_ID,SHAPE) values ('A3   ',MDSYS.SDO_GEOMETRY(2003,NULL,NULL,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,4),MDSYS.SDO_ORDINATE_ARRAY(400,490,400,310,490,400)));
Insert into AMBULANCEAREA (AMBULANCE_ID,SHAPE) values ('A2   ',MDSYS.SDO_GEOMETRY(2003,NULL,NULL,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,4),MDSYS.SDO_ORDINATE_ARRAY(250,490,250,310,340,400)));
Insert into AMBULANCEAREA (AMBULANCE_ID,SHAPE) values ('A5   ',MDSYS.SDO_GEOMETRY(2003,NULL,NULL,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,4),MDSYS.SDO_ORDINATE_ARRAY(300,190,300,10,390,100)));
Insert into AMBULANCEAREA (AMBULANCE_ID,SHAPE) values ('A4   ',MDSYS.SDO_GEOMETRY(2003,NULL,NULL,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,4),MDSYS.SDO_ORDINATE_ARRAY(400,340,400,160,490,250)));

Insert into LION (ID,SHAPE) values ('L14',MDSYS.SDO_GEOMETRY(2001,NULL,MDSYS.SDO_POINT_TYPE(350,50,NULL),NULL,NULL));
Insert into LION (ID,SHAPE) values ('L10',MDSYS.SDO_GEOMETRY(2001,NULL,MDSYS.SDO_POINT_TYPE(355,190,NULL),NULL,NULL));
Insert into LION (ID,SHAPE) values ('L11',MDSYS.SDO_GEOMETRY(2001,NULL,MDSYS.SDO_POINT_TYPE(30,210,NULL),NULL,NULL));
Insert into LION (ID,SHAPE) values ('L12',MDSYS.SDO_GEOMETRY(2001,NULL,MDSYS.SDO_POINT_TYPE(50,200,NULL),NULL,NULL));
Insert into LION (ID,SHAPE) values ('L13',MDSYS.SDO_GEOMETRY(2001,NULL,MDSYS.SDO_POINT_TYPE(170,230,NULL),NULL,NULL));
Insert into LION (ID,SHAPE) values ('L6',MDSYS.SDO_GEOMETRY(2001,NULL,MDSYS.SDO_POINT_TYPE(350,300,NULL),NULL,NULL));
Insert into LION (ID,SHAPE) values ('L7',MDSYS.SDO_GEOMETRY(2001,NULL,MDSYS.SDO_POINT_TYPE(35,10,NULL),NULL,NULL));
Insert into LION (ID,SHAPE) values ('L4',MDSYS.SDO_GEOMETRY(2001,NULL,MDSYS.SDO_POINT_TYPE(450,300,NULL),NULL,NULL));
Insert into LION (ID,SHAPE) values ('L5',MDSYS.SDO_GEOMETRY(2001,NULL,MDSYS.SDO_POINT_TYPE(20,20,NULL),NULL,NULL));
Insert into LION (ID,SHAPE) values ('L2',MDSYS.SDO_GEOMETRY(2001,NULL,MDSYS.SDO_POINT_TYPE(230,475,NULL),NULL,NULL));
Insert into LION (ID,SHAPE) values ('L3',MDSYS.SDO_GEOMETRY(2001,NULL,MDSYS.SDO_POINT_TYPE(370,455,NULL),NULL,NULL));
Insert into LION (ID,SHAPE) values ('L1',MDSYS.SDO_GEOMETRY(2001,NULL,MDSYS.SDO_POINT_TYPE(50,450,NULL),NULL,NULL));
Insert into LION (ID,SHAPE) values ('L8',MDSYS.SDO_GEOMETRY(2001,NULL,MDSYS.SDO_POINT_TYPE(115,350,NULL),NULL,NULL));
Insert into LION (ID,SHAPE) values ('L9',MDSYS.SDO_GEOMETRY(2001,NULL,MDSYS.SDO_POINT_TYPE(240,335,NULL),NULL,NULL));

Insert into REGION (REGION_ID,NUM_OF_VERTICES,SHAPE) values ('R4   ','4    ',MDSYS.SDO_GEOMETRY(2003,NULL,NULL,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,1),MDSYS.SDO_ORDINATE_ARRAY(400,0,500,0,500,100,400,100,400,0)));
Insert into REGION (REGION_ID,NUM_OF_VERTICES,SHAPE) values ('R5   ','4    ',MDSYS.SDO_GEOMETRY(2003,NULL,NULL,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,1),MDSYS.SDO_ORDINATE_ARRAY(400,100,500,100,500,250,400,200,400,100)));
Insert into REGION (REGION_ID,NUM_OF_VERTICES,SHAPE) values ('R6   ','4    ',MDSYS.SDO_GEOMETRY(2003,NULL,NULL,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,1),MDSYS.SDO_ORDINATE_ARRAY(300,150,400,100,400,200,250,250,300,150)));
Insert into REGION (REGION_ID,NUM_OF_VERTICES,SHAPE) values ('R7   ','4    ',MDSYS.SDO_GEOMETRY(2003,NULL,NULL,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,1),MDSYS.SDO_ORDINATE_ARRAY(100,100,300,150,250,250,150,250,100,100)));
Insert into REGION (REGION_ID,NUM_OF_VERTICES,SHAPE) values ('R12  ','4    ',MDSYS.SDO_GEOMETRY(2003,NULL,NULL,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,1),MDSYS.SDO_ORDINATE_ARRAY(400,200,500,250,500,350,400,350,400,200)));
Insert into REGION (REGION_ID,NUM_OF_VERTICES,SHAPE) values ('R1   ','4    ',MDSYS.SDO_GEOMETRY(2003,NULL,NULL,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,1),MDSYS.SDO_ORDINATE_ARRAY(0,0,150,0,100,100,0,100,0,0)));
Insert into REGION (REGION_ID,NUM_OF_VERTICES,SHAPE) values ('R2   ','4    ',MDSYS.SDO_GEOMETRY(2003,NULL,NULL,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,1),MDSYS.SDO_ORDINATE_ARRAY(150,0,250,0,300,150,100,100,150,0)));
Insert into REGION (REGION_ID,NUM_OF_VERTICES,SHAPE) values ('R3   ','4    ',MDSYS.SDO_GEOMETRY(2003,NULL,NULL,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,1),MDSYS.SDO_ORDINATE_ARRAY(250,0,400,0,400,100,300,150,250,0)));
Insert into REGION (REGION_ID,NUM_OF_VERTICES,SHAPE) values ('R11  ','4    ',MDSYS.SDO_GEOMETRY(2003,NULL,NULL,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,1),MDSYS.SDO_ORDINATE_ARRAY(250,250,400,200,400,350,300,350,250,250)));
Insert into REGION (REGION_ID,NUM_OF_VERTICES,SHAPE) values ('R8   ','4    ',MDSYS.SDO_GEOMETRY(2003,NULL,NULL,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,1),MDSYS.SDO_ORDINATE_ARRAY(0,100,100,100,150,250,0,250,0,100)));
Insert into REGION (REGION_ID,NUM_OF_VERTICES,SHAPE) values ('R10  ','4    ',MDSYS.SDO_GEOMETRY(2003,NULL,NULL,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,1),MDSYS.SDO_ORDINATE_ARRAY(150,250,250,250,300,350,150,400,150,250)));
Insert into REGION (REGION_ID,NUM_OF_VERTICES,SHAPE) values ('R15  ','4    ',MDSYS.SDO_GEOMETRY(2003,NULL,NULL,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,1),MDSYS.SDO_ORDINATE_ARRAY(150,400,300,350,300,500,150,500,150,400)));
Insert into REGION (REGION_ID,NUM_OF_VERTICES,SHAPE) values ('R14  ','4    ',MDSYS.SDO_GEOMETRY(2003,NULL,NULL,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,1),MDSYS.SDO_ORDINATE_ARRAY(300,350,400,350,400,500,300,500,300,350)));
Insert into REGION (REGION_ID,NUM_OF_VERTICES,SHAPE) values ('R16  ','4    ',MDSYS.SDO_GEOMETRY(2003,NULL,NULL,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,1),MDSYS.SDO_ORDINATE_ARRAY(0,350,150,400,150,500,0,500,0,350)));
Insert into REGION (REGION_ID,NUM_OF_VERTICES,SHAPE) values ('R13  ','4    ',MDSYS.SDO_GEOMETRY(2003,NULL,NULL,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,1),MDSYS.SDO_ORDINATE_ARRAY(400,350,500,350,500,500,400,500,400,350)));
Insert into REGION (REGION_ID,NUM_OF_VERTICES,SHAPE) values ('R9  ','4    ',MDSYS.SDO_GEOMETRY(2003,NULL,NULL,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,1),MDSYS.SDO_ORDINATE_ARRAY(0,250,150,250,150,400,0,350,0,250)));


Insert into POND (POND_ID,SHAPE) values ('P2        ',MDSYS.SDO_GEOMETRY(2003,NULL,NULL,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,4),MDSYS.SDO_ORDINATE_ARRAY(220,445,220,415,235,430)));
Insert into POND (POND_ID,SHAPE) values ('P3        ',MDSYS.SDO_GEOMETRY(2003,NULL,NULL,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,4),MDSYS.SDO_ORDINATE_ARRAY(370,450,370,420,385,435)));
Insert into POND (POND_ID,SHAPE) values ('P1        ',MDSYS.SDO_GEOMETRY(2003,NULL,NULL,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,4),MDSYS.SDO_ORDINATE_ARRAY(75,445,75,415,90,430)));
Insert into POND (POND_ID,SHAPE) values ('P6        ',MDSYS.SDO_GEOMETRY(2003,NULL,NULL,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,4),MDSYS.SDO_ORDINATE_ARRAY(220,335,220,305,235,320)));
Insert into POND (POND_ID,SHAPE) values ('P7        ',MDSYS.SDO_GEOMETRY(2003,NULL,NULL,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,4),MDSYS.SDO_ORDINATE_ARRAY(470,295,470,265,485,280)));
Insert into POND (POND_ID,SHAPE) values ('P4        ',MDSYS.SDO_GEOMETRY(2003,NULL,NULL,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,4),MDSYS.SDO_ORDINATE_ARRAY(75,345,75,315,90,330)));
Insert into POND (POND_ID,SHAPE) values ('P5        ',MDSYS.SDO_GEOMETRY(2003,NULL,NULL,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,4),MDSYS.SDO_ORDINATE_ARRAY(320,295,320,265,335,280)));
Insert into POND (POND_ID,SHAPE) values ('P8        ',MDSYS.SDO_GEOMETRY(2003,NULL,NULL,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,4),MDSYS.SDO_ORDINATE_ARRAY(375,190,375,160,390,175)));


COMMIT;


