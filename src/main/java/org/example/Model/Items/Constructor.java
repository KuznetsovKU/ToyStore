package org.example.Model.Items;

public class Constructor extends Item{
    public Constructor(String name, int winningFrequency, boolean availableToSale, boolean partOfDrawing) {
        super(name, winningFrequency, availableToSale, partOfDrawing);
    }

    public Constructor() {
    }

    @Override
    public int compareTo(Item other) {
        return other.getWinningFrequency() - this.getWinningFrequency();
    }

}
