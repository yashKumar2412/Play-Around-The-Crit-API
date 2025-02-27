package com.patc.model;

import com.patc.enums.TrainerType;

import java.util.Arrays;
import java.util.Objects;

public class Trainer {
    private TrainerType type;
    private Slot[] team;

    public Trainer(TrainerType type, Slot[] team) {
        this.type = type;
        this.team = team;
    }

    public TrainerType getType() {
        return type;
    }

    public void setType(TrainerType type) {
        this.type = type;
    }

    public Slot[] getTeam() {
        return team;
    }

    public void setTeam(Slot[] team) {
        this.team = team;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Trainer trainer = (Trainer) o;
        return type == trainer.type
                && Objects.deepEquals(team, trainer.team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, Arrays.hashCode(team));
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "type=" + type +
                ", team=" + Arrays.toString(team) +
                '}';
    }
}