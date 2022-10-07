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
'101','山田　一郎'
);
INSERT INTO labs.employees
(employee_id,employee_name)
VALUES
(
'102','佐藤　花子'
);
INSERT INTO labs.employees
(employee_id,employee_name)
VALUES
(
'103','佐々木　太郎'
);
INSERT INTO labs.employees
(employee_id,employee_name)
VALUES
(
'104','田村　浩'
);
INSERT INTO labs.employees
(employee_id,employee_name)
VALUES
(
'105','山本　久美'
);
INSERT INTO labs.employees
(employee_id,employee_name)
VALUES
(
'106','有田 和也'
);
INSERT INTO labs.employees
(employee_id,employee_name)
VALUES
(
'107','石井 勉'
);
INSERT INTO labs.employees
(employee_id,employee_name)
VALUES
(
'108','遠藤 あゆみ'
);
INSERT INTO labs.employees
(employee_id,employee_name)
VALUES
(
'109','中里 勝'
);
INSERT INTO labs.employees
(employee_id,employee_name)
VALUES
(
'110','森本 美香'
);
INSERT INTO labs.employees
(employee_id,employee_name)
VALUES
(
'111','片山 ちひろ'
);
INSERT INTO labs.employees
(employee_id,employee_name)
VALUES
(
'112','岸谷 英次'
);
INSERT INTO labs.employees
(employee_id,employee_name)
VALUES
(
'113','久保田 賢治'
);
INSERT INTO labs.employees
(employee_id,employee_name)
VALUES
(
'114','柴田 奈美'
);
INSERT INTO labs.employees
(employee_id,employee_name)
VALUES
(
'115','瀬川　しおり'
);
INSERT INTO labs.employees
(employee_id,employee_name)
VALUES
(
'116','高山 光'
);
INSERT INTO labs.employees
(employee_id,employee_name)
VALUES
(
'117','藤原 実'
);
INSERT INTO labs.employees
(employee_id,employee_name)
VALUES
(
'118','本多　修平'
);
INSERT INTO labs.employees
(employee_id,employee_name)
VALUES
(
'119','吉野 純'
);
INSERT INTO labs.employees
(employee_id,employee_name)
VALUES
(
'120','渡辺 薫'
);


--  insert labs.products

INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'B001','ボールペン','本',46
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'B002','サインペン','本',70
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'B003','マジック太字','本',84
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'B004','鉛筆','本',30
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'B005','シャープ芯','個',130
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'B006','消しゴム','個',40
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'B007','ホワイトボードマーカー','本',84
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'B008','蛍光ペン','本',56
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'B009','修正液','個',400
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'B010','Ｗクリップ大','個',163
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'B011','Ｗクリップ中','個',124
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'B012','Ｗクリップ小','個',98
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'B013','Ｗクリップ','個',163
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'B014','セロテープ','巻',75
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'B015','スコッチテープ','巻',280
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'B016','はさみ','本',240
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'B017','ホッチキス','個',350
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'B018','ホッチキス針','箱',50
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'P001','ノート','冊',93
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'P002','ＵＤＳ','冊',93
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'P003','レター用紙','冊',100
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'P015','長３封筒','枚',8
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'P016','角３封筒','枚',11
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'P017','角２封筒','枚',13
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'P020','角１封筒','枚',17
);
INSERT INTO labs.products
(product_id,product_name,unit,unit_price)
VALUES
(
'P021','マチ付き封筒','枚',48
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
