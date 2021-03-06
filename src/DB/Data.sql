Insert into medsys.strength_unit (unit_name) values('mg');
Insert into medsys.strength_unit (unit_name) values('g');
Insert into medsys.strength_unit (unit_name) values('ml');
Insert into medsys.strength_unit (unit_name) values('micrograms');
Insert into medsys.strength_unit (unit_name) values('tablets');
Insert into medsys.strength_unit (unit_name) values('capsule');

insert into medsys.dose_frequency (time_unit,noof_doses) values('Daily',1);
insert into medsys.dose_frequency (time_unit,noof_doses) values('Daily',2);
insert into medsys.dose_frequency (time_unit,noof_doses) values('Daily',3);
insert into medsys.dose_frequency (time_unit,noof_doses) values('Daily',4);
insert into medsys.dose_frequency (time_unit,noof_doses) values('Daily',6);
insert into medsys.dose_frequency (time_unit,noof_doses) values('Daily',8);
insert into medsys.dose_frequency (time_unit,noof_doses) values('Daily',12);
insert into medsys.dose_frequency (time_unit,noof_doses) values('Daily',24);
insert into medsys.dose_frequency (time_unit,noof_doses) values('Weekly',1);
insert into medsys.dose_frequency (time_unit,noof_doses) values('Weekly',2);
insert into medsys.dose_frequency (time_unit,noof_doses) values('Weekly',3);
insert into medsys.dose_frequency (time_unit,noof_doses) values('Every other day',1);
insert into medsys.dose_frequency (time_unit,noof_doses) values('Monthly',1);
insert into medsys.dose_frequency (time_unit,noof_doses) values('When Needed',1);
insert into medsys.dose_frequency (time_unit,noof_doses) values('Morning',1);
insert into medsys.dose_frequency (time_unit,noof_doses) values('Night',1);
insert into medsys.dose_frequency (time_unit,noof_doses) values('Noon',1);
insert into medsys.dose_frequency (time_unit,noof_doses) values('Evening',1);
insert into medsys.dose_frequency (time_unit,noof_doses) values('Bed Time',1);

Insert into medsys.base_drug (base_drug_name) values('Amoxicillin');
Insert into medsys.base_drug (base_drug_name) values('Hexalen');
Insert into medsys.base_drug (base_drug_name) values('Paracetamol');
Insert into medsys.base_drug (base_drug_name) values('Methodone');
Insert into medsys.base_drug (base_drug_name) values('Folic Acid');
Insert into medsys.base_drug (base_drug_name) values('Norco');
Insert into medsys.base_drug (base_drug_name) values('Ibuprofen');
Insert into medsys.base_drug (base_drug_name) values('Volteran');
Insert into medsys.base_drug (base_drug_name) values('Penicillamine');
Insert into medsys.base_drug (base_drug_name) values('Vitamin D');

Insert into medsys.drug (brand_name,base_drug_id) values('Amoxil', 1);
Insert into medsys.drug (brand_name,base_drug_id) values('Amoxicot', 1);
Insert into medsys.drug (brand_name,base_drug_id) values('Amoxicot', 1);
Insert into medsys.drug (brand_name,base_drug_id) values('Hexalen', 2);
Insert into medsys.drug (brand_name,base_drug_id) values('Tylenol', 3);
Insert into medsys.drug (brand_name,base_drug_id) values('Panadol', 3);
Insert into medsys.drug (brand_name,base_drug_id) values('Calpol', 3);
Insert into medsys.drug (brand_name,base_drug_id) values('Methadose', 4);
Insert into medsys.drug (brand_name,base_drug_id) values('Dolophine', 4);
Insert into medsys.drug (brand_name,base_drug_id) values(' Methadone Diskets', 4);
Insert into medsys.drug (brand_name,base_drug_id) values(' Folvite', 5);
Insert into medsys.drug (brand_name,base_drug_id) values('Folacin-800', 5);
Insert into medsys.drug (brand_name,base_drug_id) values('FaLessa, FA-8', 5);
Insert into medsys.drug (brand_name,base_drug_id) values('Vicodin', 6);
Insert into medsys.drug (brand_name,base_drug_id) values('Hycet', 6);
Insert into medsys.drug (brand_name,base_drug_id) values('Lorcet', 6);
Insert into medsys.drug (brand_name,base_drug_id) values('Medipren', 7);
Insert into medsys.drug (brand_name,base_drug_id) values('Motrin', 7);
Insert into medsys.drug (brand_name,base_drug_id) values('Nuprin', 7);
Insert into medsys.drug (brand_name,base_drug_id) values('Voltaren', 8);
Insert into medsys.drug (brand_name,base_drug_id) values('Cataflam', 8);
Insert into medsys.drug (brand_name,base_drug_id) values('Zipsor', 8);
Insert into medsys.drug (brand_name,base_drug_id) values('Cuprimine', 9);
Insert into medsys.drug (brand_name,base_drug_id) values('Depen', 9);
Insert into medsys.drug (brand_name,base_drug_id) values('Depen Titratabs', 9);
Insert into medsys.drug (brand_name,base_drug_id) values('Vita D', 10);

Insert into medsys.duration_unit (duration_unit) values ('Days');
Insert into medsys.duration_unit (duration_unit) values ('Hours');
Insert into medsys.duration_unit (duration_unit) values ('Weeks');
Insert into medsys.duration_unit (duration_unit) values ('Months');

Insert into medsys.patient (date_of_birth,firstname,lastname,gender,nic,phone) values('1977-05-26','Sunil','Satharasinghe',1,'778962531V','0712856984');
Insert into medsys.patient (date_of_birth,firstname,lastname,gender,nic,phone) values('1975-06-20','Analsly','Perera',1,'758726834V','07775874632');
Insert into medsys.patient (date_of_birth,firstname,lastname,gender,nic,phone) values('1980-01-28','Sudath','Silva',2,'786525865V','0715863854');
Insert into medsys.patient (date_of_birth,firstname,lastname,gender,nic,phone) values('2001-05-26','Kumara','Jayasiri',2,'015874563V','0769845762');

Insert into medsys.patient (date_of_birth,firstname,lastname,gender,nic,phone) values('1978-05-26','Ishan','Ranawaka',1,'788962531V','0777239473');
Insert into medsys.patient (date_of_birth,firstname,lastname,gender,nic,phone) values('1975-08-20','Senal','Dikkumbura',1,'7504856V','0776234738');
Insert into medsys.patient (date_of_birth,firstname,lastname,gender,nic,phone) values('1980-10-28','Imal','Gajaba',2,'80837456V','0716345234');
Insert into medsys.patient (date_of_birth,firstname,lastname,gender,nic,phone) values('2000-05-26','Susil','Kumar',2,'0023945V','0721834567');

Insert into medsys.strength (unit_id,strength_amount) values(1,100);
Insert into medsys.strength (unit_id,strength_amount) values(1,200);
Insert into medsys.strength (unit_id,strength_amount) values(1,300);
Insert into medsys.strength (unit_id,strength_amount) values(1,400);
Insert into medsys.strength (unit_id,strength_amount) values(1,500);
Insert into medsys.strength (unit_id,strength_amount) values(2,2);
Insert into medsys.strength (unit_id,strength_amount) values(2,5);
Insert into medsys.strength (unit_id,strength_amount) values(2,10);
Insert into medsys.strength (unit_id,strength_amount) values(2,3);
Insert into medsys.strength (unit_id,strength_amount) values(2,12);
Insert into medsys.strength (unit_id,strength_amount) values(3,100);
Insert into medsys.strength (unit_id,strength_amount) values(3,200);
Insert into medsys.strength (unit_id,strength_amount) values(3,300);
Insert into medsys.strength (unit_id,strength_amount) values(3,400);
Insert into medsys.strength (unit_id,strength_amount) values(3,500);
Insert into medsys.strength (unit_id,strength_amount) values(3,600);
Insert into medsys.strength (unit_id,strength_amount) values(3,700);
Insert into medsys.strength (unit_id,strength_amount) values(3,800);
Insert into medsys.strength (unit_id,strength_amount) values(3,900);
Insert into medsys.strength (unit_id,strength_amount) values(3,1000);
Insert into medsys.strength (unit_id,strength_amount) values(4,500);
Insert into medsys.strength (unit_id,strength_amount) values(4,200);
Insert into medsys.strength (unit_id,strength_amount) values(4,400);
Insert into medsys.strength (unit_id,strength_amount) values(4,1000);
Insert into medsys.strength (unit_id,strength_amount) values(4,300);
Insert into medsys.strength (unit_id,strength_amount) values(5,0);
Insert into medsys.strength (unit_id,strength_amount) values(6,0);

Insert into medsys.drug_package (drug_id,strength_id,quantity, min_order_level, unit_price) values (4,4,300, 30, 13);
Insert into medsys.drug_package (drug_id,strength_id,quantity, min_order_level, unit_price) values (5,7,100, 100, 5);
Insert into medsys.drug_package (drug_id,strength_id,quantity, min_order_level, unit_price) values (6,8,2020, 10, 3);
Insert into medsys.drug_package (drug_id,strength_id,quantity, min_order_level, unit_price) values (13,5,10, 10, 5);
Insert into medsys.drug_package (drug_id,strength_id,quantity, min_order_level, unit_price) values (6,5,100, 50, 12);
Insert into medsys.drug_package (drug_id,strength_id,quantity, min_order_level, unit_price) values (26,27,100,25, 5);

insert into medsys.item_supplier (notes,supplier_address,supplier_fax,supplier_name,supplier_phone) values('Main supplier', 'Union Chemist, Union place','0112456745', 'Union chemist', '0112456345') ;
insert into medsys.item_supplier (notes,supplier_address,supplier_fax,supplier_name,supplier_phone) values('Main guase supplier', 'Borella Pharmacy, Colombo 08','0112748563', 'Borella Pharmacy', '0716234857');
insert into medsys.item_supplier (notes,supplier_address,supplier_fax,supplier_name,supplier_phone) values('Secondary suppier', 'Medco , Slave Island','0117283538', 'Medco Oharma', '0777384596');
insert into medsys.item_supplier (notes,supplier_address,supplier_fax,supplier_name,supplier_phone) values('Urgent delivery', 'Med pharma','0112444987', 'Med pharma, Nugegoda', '0112776598');

insert into medsys.product_type (itemtype) values('Medicine');
insert into medsys.product_type (itemtype) values('Services');
insert into medsys.product_type (itemtype) values('Other');

Insert into medsys.unit_of_measure (unit_of_measure) values('mg');
Insert into medsys.unit_of_measure (unit_of_measure) values('g');
Insert into medsys.unit_of_measure (unit_of_measure) values('ml');
Insert into medsys.unit_of_measure (unit_of_measure) values('micrograms');
Insert into medsys.unit_of_measure (unit_of_measure) values('Packets');
Insert into medsys.unit_of_measure (unit_of_measure) values('Boxes');


Insert into medsys.item (item_description,min_order_level,quantity,item_type_id,unit_of_measure_id, unit_price) values('Sugar',100,500,1,2, 120);
Insert into medsys.item (item_description,min_order_level,quantity,item_type_id,unit_of_measure_id, unit_price) values('Dhal',20,100,1,2, 150);
Insert into medsys.item (item_description,min_order_level,quantity,item_type_id,unit_of_measure_id, unit_price) values('Sunlight',30,75,1,5, 35);
Insert into medsys.item (item_description,min_order_level,quantity,item_type_id,unit_of_measure_id, unit_price) values('Soya',40,120,1,5, 55);
Insert into medsys.item (item_description,min_order_level,quantity,item_type_id,unit_of_measure_id, unit_price) values('Panadol',50,200,1,4, 2);


66001302/02/20
GGUJHRX7NQ