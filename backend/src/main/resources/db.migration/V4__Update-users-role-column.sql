-- V4 - include column Role to user table

ALTER TABLE auth_users ADD COLUMN role TEXT NOT NULL DEFAULT 'USER';