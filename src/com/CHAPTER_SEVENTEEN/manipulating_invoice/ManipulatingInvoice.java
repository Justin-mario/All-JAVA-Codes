package com.CHAPTER_SEVENTEEN.manipulating_invoice;

public class ManipulatingInvoice {
    private final int partNumber;
    private final String partDescription;
    private final int Quantity;
    private final Double price;

    public ManipulatingInvoice(int partNumber, String partDescription, int quantity, Double price) {
        this.partNumber = partNumber;
        this.partDescription = partDescription;
        Quantity = quantity;
        this.price = price;
    }

    public int getPartNumber() {
        return partNumber;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public int getQuantity() {
        return Quantity;
    }

    public Double getPrice() {
        return price;
    }

    public double getValue(){
        return getQuantity () * getPrice ();
    }

    @Override
    public String toString() {
        {
            return String.format("%-16d %-22s %-9d  %-8.2f %.2f",
                 getPartNumber (), getPartDescription (), getQuantity (), getPrice (), getValue ());
            }
    }
}
