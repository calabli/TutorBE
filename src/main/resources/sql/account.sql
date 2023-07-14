CREATE TABLE accounts
(
    accountId  VARCHAR(128) NOT NULL,
    username   VARCHAR(128) NOT NULL,
    password   VARCHAR(256) NOT NULL,
    salt       VARCHAR(32) NOT NULL,
    email      VARCHAR(128),
    phone      VARCHAR(128),
    status     VARCHAR(32)  NOT NULL,
    creator    VARCHAR(32)  NOT NULL,
    owner      VARCHAR(32)  NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (accountId),
    UNIQUE KEY unique_username (username)
);