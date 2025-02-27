package com.patc.model;

import java.util.Arrays;
import java.util.Objects;

public class Battle {
    private Trainer user;
    private Trainer ai;
    private int generation;
    private int[] userDamage;
    private int[] aiDamage;

    public Battle(Trainer user, Trainer ai, int generation, int[] userDamage, int[] aiDamage) {
        this.user = user;
        this.ai = ai;
        this.generation = generation;
        this.userDamage = userDamage;
        this.aiDamage = aiDamage;
    }

    public Trainer getUser() {
        return user;
    }

    public void setUser(Trainer user) {
        this.user = user;
    }

    public Trainer getAi() {
        return ai;
    }

    public void setAi(Trainer ai) {
        this.ai = ai;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public int[] getUserDamage() {
        return userDamage;
    }

    public void setUserDamage(int[] userDamage) {
        this.userDamage = userDamage;
    }

    public int[] getAiDamage() {
        return aiDamage;
    }

    public void setAiDamage(int[] aiDamage) {
        this.aiDamage = aiDamage;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Battle battle = (Battle) o;
        return generation == battle.generation
                && Objects.equals(user, battle.user)
                && Objects.equals(ai, battle.ai)
                && Objects.deepEquals(userDamage, battle.userDamage)
                && Objects.deepEquals(aiDamage, battle.aiDamage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, ai, generation, Arrays.hashCode(userDamage), Arrays.hashCode(aiDamage));
    }

    @Override
    public String toString() {
        return "Battle{" +
                "user=" + user +
                ", ai=" + ai +
                ", generation=" + generation +
                ", userDamage=" + Arrays.toString(userDamage) +
                ", aiDamage=" + Arrays.toString(aiDamage) +
                '}';
    }
}