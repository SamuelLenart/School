package sk.kosickaakademia.lenart.school;

import java.io.OutputStream;

public class Factorial {

    public static void main(String[] args) {
        int result = fakt(6);
        System.out.println("Faktorial: "+result);
    }

    private static int fakt(int v) {
        if(v==1)
            return 1;
        else
            return v*fakt(v-1);
    }
}
