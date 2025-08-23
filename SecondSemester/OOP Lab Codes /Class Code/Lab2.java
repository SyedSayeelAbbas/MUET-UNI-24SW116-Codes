package SirNaveenTask;

public class Lab2 {
    public static void main(String[] args) {
        //intializing String <-is a object
        String name="Sayeel";
        //sout with concat
        System.out.println(name.concat("Abbas"));
        //After concat print name now
        System.out.println(name);
        //Concatinate will not modifie the string just for one time use with sout

        //Create a new value if save in name again with concate
        name=name.concat("Abbas");
        System.out.println(name);

        String name1="Ahmed";
        String n1="Ahmed";
        String n2=n1;
        String n3=new String("Ahmed");
        //Object refrence difference
        System.out.println("name==n1:"+(n1==name1));
        System.out.println("name==n1:"+(n1.equals(name1)));
        System.out.println("name==n1:"+(n1==n2));
        System.out.println("name==n1:"+(n1.equals(n2)));
        System.out.println("name==n1:"+(n1==n3));
        System.out.println("name==n1:"+(n1.equals(n3)));
        //For index in String
        System.out.println(name1.charAt(2));
        //Randome String Function
        String n4="Sayeel";
        String n5="Sayeel";
        System.out.println(n4.contains("S"));
        System.out.println(n5.compareTo(n4));
        //Initialzation String builder
        StringBuilder b1=new StringBuilder("Sayeel");
        b1.append("Abbas");
        System.out.println(b1);
    }
}
