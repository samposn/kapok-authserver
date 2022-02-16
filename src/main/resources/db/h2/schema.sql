-- used in tests that use HSQL
CREATE TABLE oauth_client_details
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

CREATE TABLE oauth_client_token
(
    token_id          VARCHAR(256),
    token             LONGVARBINARY,
    authentication_id VARCHAR(256) PRIMARY KEY,
    user_name         VARCHAR(256),
    client_id         VARCHAR(256)
);

CREATE TABLE oauth_access_token
(
    token_id          VARCHAR(256),
    token             LONGVARBINARY,
    authentication_id VARCHAR(256) PRIMARY KEY,
    user_name         VARCHAR(256),
    client_id         VARCHAR(256),
    authentication    LONGVARBINARY,
    refresh_token     VARCHAR(256)
);

CREATE TABLE oauth_refresh_token
(
    token_id       VARCHAR(256),
    token          LONGVARBINARY,
    authentication LONGVARBINARY
);

CREATE TABLE oauth_code
(
    code           VARCHAR(256),
    authentication LONGVARBINARY
);

CREATE TABLE oauth_approvals
(
    userid         VARCHAR(256),
    clientid       VARCHAR(256),
    scope          VARCHAR(256),
    status         VARCHAR(10),
    expiresat      TIMESTAMP,
    lastmodifiedat TIMESTAMP
);

-- customized oauth_client_details table
CREATE TABLE clientdetails
(
    appid                  VARCHAR(256) PRIMARY KEY,
    resourceids            VARCHAR(256),
    appsecret              VARCHAR(256),
    scope                  VARCHAR(256),
    granttypes             VARCHAR(256),
    redirecturl            VARCHAR(256),
    authorities            VARCHAR(256),
    access_token_validity  INTEGER,
    refresh_token_validity INTEGER,
    additionalinformation  VARCHAR(4096),
    autoapprovescopes      VARCHAR(256)
);