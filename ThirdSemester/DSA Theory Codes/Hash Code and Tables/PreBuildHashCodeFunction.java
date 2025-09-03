//package SirMossen;

public class HashMain {
    public static void main(String[] args) {
        String str1 = "Sayeel";
        String str2 = "Syed";
        String str3 = "Abbas";
        String str4 = "Naqvi";
        String str5 = "Hussain Shah";

        // Printing hash codes for all 5 strings
        System.out.println("Hash Code of " + str1 + ": " + (str1.hashCode() & 0x7FFFFFFF));
        System.out.println("Hash Code of " + str2 + ": " + (str2.hashCode() & 0x7FFFFFFF));
        System.out.println("Hash Code of " + str3 + ": " + (str3.hashCode() & 0x7FFFFFFF));
        System.out.println("Hash Code of " + str4 + ": " + (str4.hashCode() & 0x7FFFFFFF));
        System.out.println("Hash Code of " + str5 + ": " + (str5.hashCode() & 0x7FFFFFFF));
    }
}
