create database if not exists grocerylist;

use grocerylist;

drop table if exists items;
drop table if exists glist;

create table glist (
g_id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
g_create_date DATETIME default CURRENT_TIMESTAMP,
g_name varchar(62) 
);
ALTER TABLE glist AUTO_INCREMENT = 1;
alter table glist add index (g_create_date);

-- items needs to use the myISAM engine due to a composite PK with one column being autto_incr
-- using InnoDB causes this to error.
-- an alternative would be to use a upon insert trigger to select the max item_id and add 1

create table items (
glist_id int NOT NULL ,
item_id int NOT NULL AUTO_INCREMENT ,
item_name Varchar(62) NOT NULL,
item_department Varchar(62) NOT NULL,
quantity_needed int unsigned default 0,
item_purchased boolean default FALSE,
PRIMARY KEY (glist_id,item_id),
FOREIGN KEY (glist_id) references glist(g_id) ON delete cascade
) ENGINE=MyISAM;
ALTER TABLE items AUTO_INCREMENT = 1;
