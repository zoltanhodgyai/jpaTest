INSERT INTO PRODUCT_CATEGORY VALUES (1, 'PC');
INSERT INTO PRODUCT_CATEGORY VALUES (2, 'PC2');

INSERT INTO PRODUCT (ID, NAME, PRODUCT_CATEGORY) VALUES (1, 'NAME', 1);
INSERT INTO PRODUCT (ID, NAME, PRODUCT_CATEGORY) VALUES (2, 'NAME2', 1);
INSERT INTO PRODUCT (ID, NAME, PRODUCT_CATEGORY) VALUES (3, 'NAME3', 2);

INSERT INTO LEFT_TABLE VALUES (1, 'Left 1');
INSERT INTO LEFT_TABLE VALUES (2, 'Left 2');
INSERT INTO LEFT_TABLE VALUES (3, 'Left 3');
-- --
INSERT INTO RIGHT_TABLE VALUES (1, 'Right 1');
INSERT INTO RIGHT_TABLE VALUES (2, 'Right 2');
INSERT INTO RIGHT_TABLE VALUES (3, 'Right 3');
-- --
INSERT INTO MIDDLE (LEFTS, RIGHTS, MIDDLES) VALUES (1, 1, 'M 1');
INSERT INTO MIDDLE (LEFTS, RIGHTS, MIDDLES) VALUES (1, 2, 'M 2');
INSERT INTO MIDDLE (LEFTS, RIGHTS, MIDDLES) VALUES (2, 3, 'M 3');