create table user
(
id int unsigned not null primary key auto_increment,
name varchar(60) not null unique,
password varchar(20) not null,
email varchar(200) not null unique,
created datetime not null,
updated datetime not null,
);

create table portfolio
(
id int unsigned not null primary key auto_increment,
user_id int unsigned not null,
name varchar(50) not null unique,
currency enum('CAD', 'USD', 'BRL') not null,
created datetime not null,
updated datetime not null,
constraint fk_portfolio_user_id foreign key (user_id) references user (id)
);

create table portfolio_item
(
id int unsigned not null primary key auto_increment,
portfolio_id int unsigned not null,
created datetime not null,
updated datetime not null,
symbol varchar(20) not null,
shares int,
trade_date date,
cost_share decimal(4,2),
day_gain decimal(3,2),
total_gain decimal(5,2),
high_limit decimal(4,2),
low_limit decimal(4,2),
constraint fk_portfolio_item_portfolio_id foreign key (portfolio_id) references portfolio (id)
);
