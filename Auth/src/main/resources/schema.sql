USE woo_exam;
CREATE TABLE t_member(
  member_no    INT(11) NOT NULL AUTO_INCREMENT,   -- 사용자 번호
  member_nm    VARCHAR(20),                       -- 사용자 이름
  member_eamil    VARCHAR(20),                       -- 사용자 이메일
  member_pw    VARCHAR(100),                       -- 사용자 비밀번호
  member_role   CHAR(1),                          -- 사용자 권한
  member_regdate DATETIME,            -- 사용자 가입일자
  delete_flag CHAR(1),                           -- 삭제 여부
  PRIMARY KEY (member_no)
) ;

CREATE TABLE oauth_client_details (
    client_id VARCHAR(256) PRIMARY KEY,
    resource_ids VARCHAR(256),
    client_secret VARCHAR(256),
    scope VARCHAR(256),
    authorized_grant_types VARCHAR(256),
    web_server_redirect_uri VARCHAR(256),
    authorities VARCHAR(256),
    access_token_validity INTEGER,
    refresh_token_validity INTEGER,
    additional_information VARCHAR(4096),
    autoapprove VARCHAR(256)
);

INSERT INTO oauth_client_details (client_id, client_secret, resource_ids, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove) 
VALUES ('auth_id', '{noop}auth_secret', NULL, 'admin,board,job', 'authorization_code,password,client_credentials,implicit,refresh_token', NULL, 'ROLE_MY_CLIENT', 36000, 2592000, NULL, NULL);