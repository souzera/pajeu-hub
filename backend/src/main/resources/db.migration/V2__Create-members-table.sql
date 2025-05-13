-- V2 (2023-10-01): Create members table
-- This migration script creates the hub_activity_members table to track player participation in activities.

CREATE TABLE IF NOT EXISTS hub_activity_members(
    id BIGSERIAL PRIMARY KEY,
    activity_id INT NOT NULL,
    player_id INT NOT NULL,
    status BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ,
    FOREIGN KEY (activity_id) REFERENCES hub_activities(id),
    FOREIGN KEY (player_id) REFERENCES hub_players(id)
);