package org.example.Model.Items;


public abstract class Item implements Comparable<Item>{
    private static int idMaker;

    static {
        Item.idMaker = 1;
    }

    protected String id;
    protected String itemType;
    protected String name;
    protected int winningFrequency;  // частотность выпадения в розыгрыше
    protected boolean availableToSale;  // доступность к продаже
    protected boolean reservedForDrawing;  // зарезервирован для участия в розыгрыше

    public Item(String name, int winningFrequency, boolean availableToSale, boolean reservedForDrawing) {
        this.id = makeNewId();
        this.itemType = this.getClass().getSimpleName();
        this.name = name;
        this.winningFrequency = winningFrequency;
        this.availableToSale = availableToSale;
        this.reservedForDrawing = reservedForDrawing;
    }

    public Item() {
        this.id = makeNewId();
        this.itemType = this.getClass().getSimpleName();
    }

    private String makeNewId() {
        String baseIdNum = "00000000";
        String currentIdNum =baseIdNum.substring(0, baseIdNum.length() - Integer.toString(idMaker).length()) + idMaker;
        idMaker++;
        return currentIdNum;
    }

    public String getId() {
        return id;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWinningFrequency() {
        return winningFrequency;
    }

    public void setWinningFrequency(int winningFrequency) {
        this.winningFrequency = winningFrequency;
    }

    public boolean getAvailableToSale() {
        return availableToSale;
    }

    public void setAvailableToSale(boolean availableToSale) {
        this.availableToSale = availableToSale;
    }

    public boolean getReservedForDrawing() {
        return reservedForDrawing;
    }

    public void setReservedForDrawing(boolean reservedForDrawing) {
        this.reservedForDrawing = reservedForDrawing;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", itemType='" + itemType + '\'' +
                ", winningFrequency=" + winningFrequency +
                ", availableToSale=" + availableToSale +
                ", partOfDrawing=" + reservedForDrawing +
                '}';
    }

    public String getShortInfo() {
        return "Item{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", itemType='" + itemType + '\'' +
                ", winningFrequency=" + winningFrequency +
                '}';
    }

}
