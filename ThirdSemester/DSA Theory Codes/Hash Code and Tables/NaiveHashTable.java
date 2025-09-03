//package SirMossen;

class Country{
    private int area , population;
    private String language , name;

    //Constructor For Country Class Data input That Will store as an Object In entries
    //Array of HashTable Class
    Country(int area,int population,String name,String language){
        this.name=name;
        this.language=language;
        this.area=area;
        this.population=population;
    }

    //Making TOString So when Ever We Want to Print the Value (Object If a Country Class)
    //Placed In the Array
    public String toString(){
        StringBuilder build = new StringBuilder();
        build.append("\t\t\tData Start\n");
        build.append("============================================\n");
        build.append("Country Name is : "+name+"\n");
        build.append("National Language Of "+name+" is : "+language+"\n");
        build.append("Area Of "+name+" is : "+area+"\n");
        build.append("Total Population of "+name+" is : "+population+"\n");
        build.append("============================================\n");
        return build.toString();
    }
}

public class HashTable {
    //Creating Variable TO Store Data of Country Class Through Entry Class
    private static Entry[]entries = new Entry[11];
    private static int size;

    private static class Entry{
        Object key,value;   // instance variables (not static)

        Entry(Object key,Object value){   // normal constructor
            this.key=key;
            this.value=value;
        }
    }
    private static int hash(Object key){
        return (key.hashCode() & 0x7FFFFFFF)%entries.length;
    }
    public static Object get(Object key){
        return (entries[hash(key)]!=null)?entries[hash(key)].value:null;
    }
    public static void push(Object key,Object value){
        entries[hash(key)]=new Entry(key,value);
        size++;
    }
    public static Object remove(Object key){
        int h = hash(key);
        Object temp = (entries[h]!=null)?entries[h].value:null;
        entries[h]=null;
        size--;
        return temp;
    }
    public static int size (){return size;}
    //Implementing the Program
    public static void main(String[] args) {
        Country pk = new Country(1209,1000,"Pakistan","Urdu");
        Country in = new Country(17909,145000,"India","Hindi");
        Country cn = new Country(9596961,1412000000,"China","Mandarin");
        Country us = new Country(9833517,331000000,"USA","English");
        Country uk = new Country(243610,67000000,"UK","English");
        Country sa = new Country(2149690,36000000,"Saudi Arabia","Arabic");

        // pushing 6 countries into hashtable
        push("PK", pk);
        push("IN", in);
        push("CN", cn);
        push("US", us);
        push("UK", uk);
        push("SA", sa);

        // printing from hashtable
        System.out.println(get("PK"));
        System.out.println(get("IN"));
        System.out.println(get("CN"));
        System.out.println(get("US"));
        System.out.println(get("UK"));
        System.out.println(get("SA"));

        System.out.println("Total Entries = "+size());
    }
}
