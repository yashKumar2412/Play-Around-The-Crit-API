package com.patc.model;

import com.patc.enums.MoveCategory;
import com.patc.enums.Type;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MoveCatalogue {
    private Map<String, Move> moveMap;

    public MoveCatalogue() {
        moveMap = new HashMap<>();
        addAllMoves();
    }

    private void addAllMoves() {
        String seedBombName = "Seed Bomb";
        Move seedBomb = new Move(seedBombName, Type.GRASS, true, 80, MoveCategory.PHYSICAL);
        moveMap.put(seedBombName, seedBomb);

        String brickBreakName = "Brick Break";
        Move brickBreak = new Move(brickBreakName, Type.FIGHTING, true, 75, MoveCategory.PHYSICAL);
        moveMap.put(brickBreakName, brickBreak);

        String mudShotName = "Mud Shot";
        Move mudShot = new Move(mudShotName, Type.GROUND, true, 55, MoveCategory.SPECIAL);
        moveMap.put(mudShotName, mudShot);

        String flamethrowerName = "Flamethrower";
        Move flamethrower = new Move(flamethrowerName, Type.FIRE, true, 90, MoveCategory.SPECIAL);
        moveMap.put(flamethrowerName, flamethrower);

        String psychicName = "Psychic";
        Move psychic = new Move(psychicName, Type.PSYCHIC, true, 90, MoveCategory.SPECIAL);
        moveMap.put(psychicName, psychic);

        String thunderPunchName = "Thunder Punch";
        Move thunderPunch = new Move(thunderPunchName, Type.ELECTRIC, true, 75, MoveCategory.PHYSICAL);
        moveMap.put(thunderPunchName, thunderPunch);

        String waterfallName = "Waterfall";
        Move waterfall = new Move(waterfallName, Type.WATER, true, 80, MoveCategory.PHYSICAL);
        moveMap.put(waterfallName, waterfall);

        String nightSlashName = "Night Slash";
        Move nightSlash = new Move(nightSlashName, Type.DARK, true, 70, MoveCategory.PHYSICAL);
        moveMap.put(nightSlashName, nightSlash);

        String iceBeamName = "Ice Beam";
        Move iceBeam = new Move(iceBeamName, Type.ICE, true, 90, MoveCategory.SPECIAL);
        moveMap.put(iceBeamName, iceBeam);
    }

    public Map<String, Move> getMoveMap() {
        return moveMap;
    }

    public void setMoveMap(Map<String, Move> moveMap) {
        this.moveMap = moveMap;
    }

    public Move selectMove(String moveName) {
        if (moveMap.containsKey(moveName))
            return moveMap.get(moveName);

        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MoveCatalogue that = (MoveCatalogue) o;
        return Objects.equals(moveMap, that.moveMap);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(moveMap);
    }

    @Override
    public String toString() {
        return "MoveCatalogue{" +
                "moveMap=" + moveMap +
                '}';
    }
}