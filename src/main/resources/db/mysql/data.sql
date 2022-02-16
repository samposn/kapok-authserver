INSERT INTO `account`
    (`username`, `password`, `email`, `status`)
VALUES
    ('zhangsan', '123456', 'zhangsan@abc.com', 'NORMAL'),
    ('lisi', '123456', 'lisi@abc.com', 'NORMAL'),
    ('wangwu', '123456', 'wangwu@abc.com', 'NORMAL'),
    ('zhaoliu', '123456', 'zhaoliu@abc.com', 'NORMAL'),
    ('hongqi', '123456', 'hongqi@abc.com', 'NORMAL');

INSERT INTO oauth_client_details
    (`client_id`, `resource_ids`, `client_secret`, `scope`, `authorized_grant_types`, `web_server_redirect_uri`,
     `additional_information`, `autoapprove`)
VALUES
    ('c1', 'res1', 'secret', 'all1', 'authorization_code,password,client_credentials,implicit,refresh_token',
     'https://www.baidu.com', 'c1c1', 'true');
