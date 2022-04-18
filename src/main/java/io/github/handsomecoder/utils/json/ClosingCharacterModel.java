package io.github.handsomecoder.utils.json;

import java.util.Objects;

/**
 * @author Harsh Shah
 */
public class ClosingCharacterModel {

    private Character character;

    private Integer index;

    public ClosingCharacterModel(Character character, Integer index) {
        this.character = character;
        this.index = index;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClosingCharacterModel)) return false;
        ClosingCharacterModel that = (ClosingCharacterModel) o;
        return getCharacter().equals(that.getCharacter()) && getIndex().equals(that.getIndex());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCharacter(), getIndex());
    }

    @Override
    public String toString() {
        return "OpeningCharacterModel{" +
                "character=" + character +
                ", index=" + index +
                '}';
    }
}

