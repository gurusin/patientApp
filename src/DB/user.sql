INSERT INTO `med_sys_user` ( `firstname`, `lastname`, `password`, `user_type`, `username`) VALUES ( 'Nurse', 'Nurse', 'NurseView', '2', 'rosi');
INSERT INTO `med_sys_user` ( `firstname`, `lastname`, `password`, `user_type`, `username`) VALUES ( 'Janaka', 'Abeysinghe', '123Ja', 1, 'janaka');
INSERT INTO `med_sys_user` ( `firstname`, `lastname`, `password`, `user_type`, `username`) VALUES ( 'Admin', 'Admin', '1234', 1, 'admin');

Insert into medsys.item (item_description,min_order_level,quantity,item_type_id,unit_of_measure_id, unit_price) values('Sugar',100,500,1,2, 120);
Insert into medsys.item (item_description,min_order_level,quantity,item_type_id,unit_of_measure_id, unit_price) values('Dhal',20,100,1,2, 150);
Insert into medsys.item (item_description,min_order_level,quantity,item_type_id,unit_of_measure_id, unit_price) values('Sunlight',30,75,1,5, 35);
Insert into medsys.item (item_description,min_order_level,quantity,item_type_id,unit_of_measure_id, unit_price) values('Soya',40,120,1,5, 55);
Insert into medsys.item (item_description,min_order_level,quantity,item_type_id,unit_of_measure_id, unit_price) values('Panadol',50,200,1,4, 2);

Insert into medsys.patient (date_of_birth,firstname,lastname,gender,nic,phone) values('1977-05-26','Sunil','Satharasinghe',1,'778962531V','0712856984');
Insert into medsys.patient (date_of_birth,firstname,lastname,gender,nic,phone) values('1975-06-20','Analsly','Perera',1,'758726834V','07775874632');
Insert into medsys.patient (date_of_birth,firstname,lastname,gender,nic,phone) values('1980-01-28','Sudath','Silva',2,'786525865V','0715863854');
Insert into medsys.patient (date_of_birth,firstname,lastname,gender,nic,phone) values('2001-05-26','Kumara','Jayasiri',2,'015874563V','0769845762');

Insert into medsys.patient (date_of_birth,firstname,lastname,gender,nic,phone) values('1978-05-26','Ishan','Ranawaka',1,'788962531V','0777239473');
Insert into medsys.patient (date_of_birth,firstname,lastname,gender,nic,phone) values('1975-08-20','Senal','Dikkumbura',1,'7504856V','0776234738');
Insert into medsys.patient (date_of_birth,firstname,lastname,gender,nic,phone) values('1980-10-28','Imal','Gajaba',2,'80837456V','0716345234');
Insert into medsys.patient (date_of_birth,firstname,lastname,gender,nic,phone) values('2000-05-26','Susil','Kumar',2,'0023945V','0721834567');