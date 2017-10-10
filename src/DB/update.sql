ALTER TABLE medsys.strength MODIFY COLUMN strength_amount DOUBLE NULL;

# 05th  October
insert into medsys.duration_unit (duration_unit) values('When Needed');

#10th October
update drug set brand_name = trim(brand_name);