# First run CREATE SCHEMA IF NOT EXISTS wealth_watch;

CREATE TABLE IF NOT EXISTS user
(
    id INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(60) NOT NULL UNIQUE,
    password VARCHAR(20) NOT NULL,
    email VARCHAR(200) NOT NULL UNIQUE,
    created DATETIME NOT NULL,
    updated DATETIME NOT NULL
);

CREATE TABLE IF NOT EXISTS portfolio
(
    id INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    user_id INT UNSIGNED NOT NULL,
    name VARCHAR(50) NOT NULL UNIQUE,
    currency ENUM('CAD', 'USD', 'BRL') NOT NULL,
    created DATETIME NOT NULL,
    updated DATETIME NOT NULL,
    CONSTRAINT fk_portfolio_user_id FOREIGN KEY (user_id) REFERENCES user (id)
);

CREATE TABLE IF NOT EXISTS portfolio_item
(
    id INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    portfolio_id INT UNSIGNED NOT NULL,
    symbol VARCHAR(20) NOT NULL,
    shares INT,
    trade_date DATE,
    cost_share DECIMAL(4,2),
    day_gain DECIMAL(3,2),
    total_gain DECIMAL(5,2),
    high_limit DECIMAL(4,2),
    low_limit DECIMAL(4,2),
    created DATETIME NOT NULL,
    updated DATETIME NOT NULL,
    CONSTRAINT fk_portfolio_item_portfolio_id FOREIGN KEY (portfolio_id) REFERENCES portfolio (id)
);
