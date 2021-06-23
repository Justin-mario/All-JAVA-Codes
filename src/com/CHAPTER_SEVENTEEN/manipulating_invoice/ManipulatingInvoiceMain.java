package com.CHAPTER_SEVENTEEN.manipulating_invoice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ManipulatingInvoiceMain {

    static  ManipulatingInvoice[] invoice = {new ManipulatingInvoice ( 83, "Electric Sander", 7, 57.98 ),
            new ManipulatingInvoice ( 24, "power saw", 18, 99.99 ),
            new ManipulatingInvoice ( 7, "sledge hammer", 11, 21.50 ),
            new ManipulatingInvoice ( 77, "hammer", 76, 11.99 ),
            new ManipulatingInvoice ( 39, "lawn mower", 3, 79.50 ),
            new ManipulatingInvoice ( 68, "screw driver", 106, 6.99 ),
            new ManipulatingInvoice ( 56, "jigsaw", 21, 11.00 ),
            new ManipulatingInvoice ( 3, "wrench", 34, 7.50 ),};

    static List<ManipulatingInvoice> list = Arrays.asList ( invoice );

    public static void main(String[] args) {
        System.out.println ("Complete Invoice List\n");
        System.out.printf ("%-16s %-20s %-12s %-8s %s\n ", "Parts Number", "Parts Description", "Quantity", "Price", "Value");
        list.forEach ( System.out::println );

       sortingByPartDescription ();
       sortingByPrice ();
       mappingByPartDescriptionAndQuantity ();
       mappingByPartDescriptionAndValue ();
       selectInvoiceByValue ();
    }


    public static void sortingByPartDescription(){

        Function<ManipulatingInvoice, String> byPartDescription = ManipulatingInvoice::getPartDescription;
        Comparator<ManipulatingInvoice> lastThenFirst =
                Comparator.comparing(byPartDescription);
        System.out.printf ("%n Invoice in ascending order by part description:\n");
        System.out.printf ("%-16s %-20s %-12s %-8s %s%n ", "Parts Number", "Parts Description", "Quantity", "Price", "Value");
        list.stream ()
                .sorted (lastThenFirst)
                .forEach ( System.out::println );
    }


    public static void sortingByPrice(){

        Function<ManipulatingInvoice, Double> byPrice = ManipulatingInvoice::getPrice;
        Comparator<ManipulatingInvoice> fromLastToFirst=
                Comparator.comparing(byPrice);
        System.out.printf ("%n Invoice in ascending order by price:%n");
        System.out.printf ("%-16s %-20s %-12s %-8s %s%n ", "Parts Number", "Parts Description", "Quantity", "Price", "Value");
        list.stream ()
                .sorted (fromLastToFirst)
                .forEach ( System.out::println );
    }


    public static void mappingByPartDescriptionAndQuantity(){
        Function<ManipulatingInvoice, Integer> byQuantity = ManipulatingInvoice::getQuantity;

        Comparator<ManipulatingInvoice> lastToFirst=
                Comparator.comparing(byQuantity);
        System.out.printf ("%nMap to each Invoice Parts description and Quantity:%n");
        System.out.printf ("%n%-20s %s%n","Parts Description", "Quantity");
        list.stream()
                .sorted(lastToFirst)
                .map(ManipulatingInvoice -> String.format ("%-20s %d", ManipulatingInvoice.getPartDescription (), ManipulatingInvoice.getQuantity ()  ))
                .forEach(System.out::println);
    }


    public static void mappingByPartDescriptionAndValue(){
        Function<ManipulatingInvoice, Double> byValue = ManipulatingInvoice::getValue;

        Comparator<ManipulatingInvoice> lastToFirstOfValue=
                Comparator.comparing(byValue);
        System.out.printf ("%nMap to each Invoice Parts description and Value:%n");
        System.out.printf ("%n%-20s %s%n","Parts Description", "Value");
        list.stream()
                .sorted(lastToFirstOfValue)
                .map(ManipulatingInvoice -> String.format ("%-20s %.2f", ManipulatingInvoice.getPartDescription (), ManipulatingInvoice.getValue () ))
                .forEach(System.out::println);
    }


    public static void selectInvoiceByValue(){
        Predicate<ManipulatingInvoice> twoToFiveHundred =
                value -> (value.getValue () >= 200 && value.getValue () <= 500);
        System.out.printf( "%nValues Between 200 and 500:%n");
        System.out.printf ("%-16s %-20s %-12s %-8s %s%n ", "Parts Number", "Parts Description", "Quantity", "Price", "Value");
        list.stream()
                .filter(twoToFiveHundred)
                .sorted(Comparator.comparing(ManipulatingInvoice::getValue))
                .forEach(System.out::println);
    }


}
