package org.example.Model.Items;

public class Doll extends Item{
    public Doll(String name, int winningFrequency, boolean availableToSale, boolean partOfDrawing) {
        super(name, winningFrequency, availableToSale, partOfDrawing);
    }

    public Doll() {
    }

    @Override
    public int compareTo(Item other) {
        return other.getWinningFrequency() - this.getWinningFrequency();
    }

}
