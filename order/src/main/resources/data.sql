INSERT INTO order_item (id_article, quantity, price) VALUES (1, 2, 3.99);
INSERT INTO order_item (id_article, quantity, price) VALUES (2, 1, 3.99);
INSERT INTO order_item (id_article, quantity, price) VALUES (3, 2, 3.99);
INSERT INTO order_item (id_article, quantity, price) VALUES (4, 3, 3.99);
INSERT INTO order_item (id_article, quantity, price) VALUES (1, 5, 3.99);
INSERT INTO order_item (id_article, quantity, price) VALUES (4, 3, 3.99);

INSERT INTO commande (client_id, status, total) VALUES (1, 1, 11.97);
INSERT INTO commande (client_id, status, total) VALUES (2, 0, 19.95);
INSERT INTO commande (client_id, status, total) VALUES (2, 2, 31.92);

INSERT INTO commande_items (commande_id, items_id) VALUES (1, 1);
INSERT INTO commande_items (commande_id, items_id) VALUES (1, 2);
INSERT INTO commande_items (commande_id, items_id) VALUES (2, 3);
INSERT INTO commande_items (commande_id, items_id) VALUES (2, 4);
INSERT INTO commande_items (commande_id, items_id) VALUES (3, 5);
INSERT INTO commande_items (commande_id, items_id) VALUES (3, 6);