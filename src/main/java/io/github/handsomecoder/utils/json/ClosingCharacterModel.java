package io.github.handsomecoder.utils.json;

import java.util.Objects;

/**
 * The type Closing character model.
 *
 * @author Harsh Shah
 */
public class ClosingCharacterModel {

    private Character character;

    private Integer index;

    /**
     * Instantiates a new Closing character model.
     *
     * @param character the character
     * @param index     the index
     */
    public ClosingCharacterModel(Character character, Integer index) {
        this.character = character;
        this.index = index;
    }

    /**
     * Gets character.
     *
     * @return the character
     */
    public Character getCharacter() {
        return character;
    }

    /**
     * Sets character.
     *
     * @param character the character
     */
    public void setCharacter(Character character) {
        this.character = character;
    }

    /**
     * Gets index.
     *
     * @return the index
     */
    public Integer getIndex() {
        return index;
    }

    /**
     * Sets index.
     *
     * @param index the index
     */
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

