create table user
(
id int unsigned not null unique auto_increment,
name varchar(45) not null unique,
password varchar(20) not null,
primary key (id)
);

create table portfolio
(
id int unsigned not null unique auto_increment,
user_id int unsigned not null,
name varchar(50) not null unique,
currency enum('CAD', 'USD', 'BRL') not null,
primary key (id),
constraint fk_portfolio_user foreign key (user_id) references user (id)
);

create table portfolio_item
(
id int unsigned not null unique auto_increment,
portfolio_id int unsigned not null,
symbol varchar(20) not null unique,
shares int,
trade_date date,
cost_share decimal(4,2),
day_gain decimal(3,2),
total_gain decimal(5,2),
high_limit decimal(4,2),
low_limit decimal(4,2),
primary key (id),
constraint fk_portfolio_item_portfolio foreign key (portfolio_id) references portfolio (id)
);

select * from portfolio_item;