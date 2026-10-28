-- Create workouts table
CREATE TABLE workouts (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    activity_type VARCHAR(32) NOT NULL,
    duration_minutes INTEGER NOT NULL CHECK (duration_minutes > 0),
    performed_at TIMESTAMP WITH TIME ZONE NOT NULL,
    notes TEXT,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    version INTEGER NOT NULL DEFAULT 0
);

-- Index on performed_at for date range queries
CREATE INDEX idx_workouts_performed_at ON workouts (performed_at);

-- Index on activity_type for filtering
CREATE INDEX idx_workouts_activity_type ON workouts (activity_type);
