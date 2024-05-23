-- only for test

-- create users
INSERT INTO tbl_app_user (id, password, username) VALUES (1, '$2a$10$FnO4w5MjGvd79oYcsPxBGup7nBrtLGguDqyDJoH5xTBNqMWN2DO/i', 'admin');
INSERT INTO tbl_app_user (id, password, username) VALUES (2, '$2a$10$Z19r4n1.GLjGDafxqSfGh.pLZpbIcsGu9r3nieZZ8MBY4N6f6VCFC', 'user');

-- create roles
INSERT INTO tbl_app_role (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO tbl_app_role (id, name) VALUES (2, 'ROLE_USER');

-- create permissions
INSERT INTO tbl_app_permission (id, name) VALUES (1, 'person:read');
INSERT INTO tbl_app_permission (id, name) VALUES (2, 'person:write');

-- join roles to permissions
INSERT INTO roles_permissions (app_permission_id, app_role_id) VALUES (1, 1);
INSERT INTO roles_permissions (app_permission_id, app_role_id) VALUES (1, 2);
INSERT INTO roles_permissions (app_permission_id, app_role_id) VALUES (2, 1);

-- join user to roles
INSERT INTO users_roles (app_role_id, app_user_id) VALUES (1, 1);
INSERT INTO users_roles (app_role_id, app_user_id) VALUES (2, 2);