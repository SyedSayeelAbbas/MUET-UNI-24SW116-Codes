public class CustomHash {
    public static int myHash(String s) {
        int initial_Hash = s.hashCode();
        int transform_Hash = initial_Hash * 87;
        int transform2_Hash = transform_Hash + 213;
        int final_Hash = transform2_Hash ^ (transform2_Hash << 16);
        return final_Hash;
    }

    public static void main(String[] args) {
        String str = "DataStructures";
        System.out.println("Final Hash: " + myHash(str));
    }
}
