package com.patc.model;

import com.patc.enums.Status;
import com.patc.enums.Weather;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Battle {
    private ActiveSet user;
    private ActiveSet ai;
    private PlatformData data;
    private Weather weather;

    public Battle() {
        this.data = new PlatformData();
        this.user = new ActiveSet(data.getPokemonSetCatalogue().selectPokemonSet("Greninja Default"));
        this.ai = new ActiveSet(data.getPokemonSetCatalogue().selectPokemonSet("Greninja Default"));
        this.weather = Weather.None;
    }

    public ActiveSet getUser() {
        return user;
    }

    public void setUser(ActiveSet user) {
        this.user = user;
    }

    public ActiveSet getAi() {
        return ai;
    }

    public void setAi(ActiveSet ai) {
        this.ai = ai;
    }

    public PlatformData getData() {
        return data;
    }

    public void setData(PlatformData data) {
        this.data = data;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public void selectPokemonSet(String pokemonSetName, boolean isUser) {
        PokemonSet set = data.selectPokemonSet(pokemonSetName);
        if (isUser) {
            user = new ActiveSet(set, ai, weather, data.getTypeChart());
        } else {
            ai = new ActiveSet(set, user, weather, data.getTypeChart());
        }
    }

    public void savePokemonSet(String pokemonSetName, PokemonSet set) {
        data.savePokemonSet(pokemonSetName, set);
    }

    public void selectAbility(String abilityName, boolean isUser) {
        Ability ability = data.selectAbility(abilityName);
        if (isUser) {
            user.getSet().setAbility(ability);
        } else {
            ai.getSet().setAbility(ability);
        }
    }

    public void selectItem(String itemName, boolean isUser) {
        Item item = data.selectItem(itemName);
        if (isUser) {
            user.getSet().setHeldItem(item);
        } else {
            ai.getSet().setHeldItem(item);
        }
    }

    public void selectMove(List<String> moveNames, boolean isUser) {
        List<Move> moves = new ArrayList<>();
        for (String moveName: moveNames) {
            moves.add(data.selectMove(moveName));
        }

        if (isUser) {
            user.getSet().setMoves(moves);
        } else {
            ai.getSet().setMoves(moves);
        }
    }

    public void updateHealth(int newHealth, boolean isUser) {
        if (isUser) {
            user.setHealth(newHealth);
        } else {
            ai.setHealth(newHealth);
        }
    }

    public void updateEffectiveStats(Stats statModifiers, boolean isUser) {
        if (isUser) {
            user.calculateStats(statModifiers);
        } else {
            ai.calculateStats(statModifiers);
        }
    }

    public void updateStatus(Status newStatus, boolean isUser) {
        if (isUser) {
            user.setStatus(newStatus);
        } else {
            ai.setStatus(newStatus);
        }
    }

    public void calculateAllDamages(boolean isUser) {
        if (isUser) {
            user.calculateAllDamages(ai, weather, data.getTypeChart());
        } else {
            ai.calculateAllDamages(user, weather, data.getTypeChart());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Battle battle = (Battle) o;
        return Objects.equals(user, battle.user) && Objects.equals(ai, battle.ai) && Objects.equals(data, battle.data) && weather == battle.weather;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, ai, data, weather);
    }

    @Override
    public String toString() {
        return "Battle{" +
                "user=" + user +
                ", ai=" + ai +
                ", data=" + data +
                ", weather=" + weather +
                '}';
    }
}