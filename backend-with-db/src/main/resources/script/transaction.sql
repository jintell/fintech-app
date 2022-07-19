CREATE TABLE transaction (
      id BIGINT NOT NULL auto_increment,
      type TINYINT DEFAULT 0,
      trans_date DATETIME,
      account_number MEDIUMINT,
      currency VARCHAR(3),
      amount DECIMAL(18, 2) DEFAULT 0.00,
      merchant_name VARCHAR(100) NOT NULL,
      merchant_logo VARCHAR(255) NOT NULL,
      primary key (id)
);