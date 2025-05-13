-- V3 - include column User to player table

ALTER TABLE hub_players ADD COLUMN user_id BIGINT;
ALTER TABLE hub_players ADD CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES auth_users(id);