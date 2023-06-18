package org.example.Model.Items;

public class Robot extends Item{
    public Robot(String name, int winningFrequency, boolean availableToSale, boolean reservedForDrawing) {
        super(name, winningFrequency, availableToSale, reservedForDrawing);
    }

    public Robot() {
    }

    @Override
    public int compareTo(Item other) {
        return other.getWinningFrequency() - this.getWinningFrequency();
    }

}
