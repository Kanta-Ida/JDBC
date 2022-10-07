CREATE DATABASE labs;
GRANT SELECT,INSERT,UPDATE,DELETE ON labs.* TO root@'%' IDENTIFIED BY 'root';

DROP TABLE IF EXISTS labs.orders;
DROP TABLE IF EXISTS labs.products;
DROP TABLE IF EXISTS labs.employees;

CREATE TABLE  labs.employees (
  employee_id varchar(3),
  employee_name varchar(32) NOT NULL,
  PRIMARY KEY  (employee_id)
)ENGINE=InnoDB;

CREATE TABLE  labs.products (
  product_id varchar(4),
  product_name varchar(32) NOT NULL default '',
  unit varchar(2) NOT NULL NOT NULL default '',
  unit_price int(10) unsigned NOT NULL default '0',
  PRIMARY KEY  (product_id)
)ENGINE=InnoDB;

CREATE TABLE  labs.orders (
  order_id int(10) unsigned auto_increment,
  product_id varchar(4) NOT NULL default '',
  volume int(10) unsigned NOT NULL default '0',
  employee_id varchar(3) NOT NULL default '',
  PRIMARY KEY  (order_id),
  FOREIGN KEY (product_id) REFERENCES labs.products(product_id),
  FOREIGN KEY (employee_id) REFERENCES labs.employees(employee_id)
)ENGINE=InnoDB;

INSERT INTO labs.employees
(employee_id,employee_name)
VALUES
(
'101','�R�c�@��Y'
);
INSERT INTO labs.employees
(employee_id,employee_name)
VALUES
(
'102','�����@�Ԏq'
);
INSERT INTO labs.employees
(employee_id,employee_name)
VALUES
(
'103','���X�؁@���Y'
);
INSERT INTO labs.employees
(employee_id,employee_name)
VALUES
(
'104','�c���@�_'
);
INSERT INTO labs.employees
(employee_id,employee_name)
VALUES
(
'105','�R�{�@�v��'
);
INSERT INTO labs.employees
(employee_id,employee_name)
VALUES
(
'106','�L�c �a��'
);
INSERT INTO labs.employees
(employee_id,employee_name)
VALUES
(
'107','�Έ� ��'
);
INSERT INTO labs.employees
(employee_id,employee_name)
VALUES
(
'108','���� �����'
);
INSERT INTO labs.employees
(employee_id,employee_name)
VALUES
(
'109','���� ��'
);
INSERT INTO labs.employees
(employee_id,employee_name)
VALUES
(
'110','�X�{ ����'
);
INSERT INTO labs.employees
(employee_id,employee_name)
VALUES
(
'111','�ЎR ���Ђ�'
);
INSERT INTO labs.employees
(employee_id,employee_name)
VALUES
(
'112','�ݒJ �p��'
);
INSERT INTO labs.employees
(employee_id,employee_name)
VALUES
(
'113','�v�ۓc ����'
);
INSERT INTO labs.employees
(employee_id,employee_name)
VALUES
(
'114','�ēc �ޔ�'
);
INSERT INTO labs.employees
(employee_id,employee_name)
VALUES
(
'115','����@������'
);
INSERT INTO labs.employees
(employee_id,employee_name)
VALUES
(
'116','���R ��'
);
INSERT INTO labs.employees
(employee_id,employee_name)
VALUES
(
'117','���� ��'
);
INSERT INTO labs.employees
(employee_id,employee_name)
VALUES
(
'118','�{���@�C��'
);
INSERT INTO labs.employees
(employee_id,employee_name)
VALUES
(
'119','�g�� ��'
);
INSERT INTO labs.employees
(employee_id,employee_name)
VALUES
(
'120','�n�� �O'
);


--  insert labs.products

INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'B001','�{�[���y��','�{',46
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'B002','�T�C���y��','�{',70
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'B003','�}�W�b�N����','�{',84
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'B004','���M','�{',30
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'B005','�V���[�v�c','��',130
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'B006','�����S��','��',40
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'B007','�z���C�g�{�[�h�}�[�J�[','�{',84
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'B008','�u���y��','�{',56
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'B009','�C���t','��',400
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'B010','�v�N���b�v��','��',163
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'B011','�v�N���b�v��','��',124
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'B012','�v�N���b�v��','��',98
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'B013','�v�N���b�v','��',163
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'B014','�Z���e�[�v','��',75
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'B015','�X�R�b�`�e�[�v','��',280
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'B016','�͂���','�{',240
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'B017','�z�b�`�L�X','��',350
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'B018','�z�b�`�L�X�j','��',50
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'P001','�m�[�g','��',93
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'P002','�t�c�r','��',93
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'P003','���^�[�p��','��',100
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'P015','���R����','��',8
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'P016','�p�R����','��',11
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'P017','�p�Q����','��',13
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'P020','�p�P����','��',17
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'P021','�}�`�t������','��',48
);

INSERT INTO labs.orders
(product_id,volume,employee_id)
VALUES
(
'B001',30,'101'
);
INSERT INTO labs.orders
(product_id,volume,employee_id)
VALUES
(
'B002',10,'101'
);
INSERT INTO labs.orders
(product_id,volume,employee_id)
VALUES
(
'B001',40,'105'
);
INSERT INTO labs.orders
(product_id,volume,employee_id)
VALUES
(
'B003',15,'105'
);
INSERT INTO labs.orders
(product_id,volume,employee_id)
VALUES
(
'P001',5,'102'
);
INSERT INTO labs.orders
(product_id,volume,employee_id)
VALUES
(
'B005',10,'103'
);

DROP TABLE IF EXISTS labs.products2;
create table labs.products2
as select * from labs.products;

DROP TABLE IF EXISTS labs.employees2;
CREATE TABLE  labs.employees2 
as select * from labs.employees;

select * from labs.employees;
select * from labs.products;
select * from labs.orders;
select * from labs.employees2;
select * from labs.products2;
