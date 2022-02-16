/* Account */
CREATE TABLE IF NOT EXISTS account
(
    id       BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY COMMENT '主键',
    username VARCHAR(255) COMMENT '账号',
    password VARCHAR(255) COMMENT '密码',
    email    VARCHAR(255) COMMENT '邮箱地址',
    status   VARCHAR(16) COMMENT '状态'
);

/* ClientDetails */
CREATE TABLE IF NOT EXISTS oauth_client_details
(
    client_id               VARCHAR(256) PRIMARY KEY,
    resource_ids            VARCHAR(256),
    client_secret           VARCHAR(256),
    scope                   VARCHAR(256),
    authorized_grant_types  VARCHAR(256),
    web_server_redirect_uri VARCHAR(256),
    authorities             VARCHAR(256),
    access_token_validity   INTEGER,
    refresh_token_validity  INTEGER,
    additional_information  VARCHAR(4096),
    autoapprove             VARCHAR(256)
);


/* ================================================================================================================== */
