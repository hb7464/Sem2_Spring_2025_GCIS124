public class Main {

    public static int sumArr(int[] x){
        int sum = 0;
        for (int i:x){
            sum+= i;
        }
        return sum;
    }
    public static void main(String[] args) {

        // int[] x = {1,2,4,5,32313,333,42,33};
        // System.out.println(x);
        // for (int i = 0; i<x.length; i++){
        //     if (i == 0){
        //         System.out.print("{"+x[i]+",");
        //     }

        //     else if (i == (x.length-1)) {
        //         System.out.print(x[i]+"}");
        //     }
        //     else{
        //         System.out.print(x[i]+",");
        //     }
        // }
        // System.out.println();
        
        // System.out.println("The sum of the above array is: "+sumArr(x));

        // // int[] z = new int[5];
        // // for(int ind:z)
        // //    ind = ind + 5;  //This doesnt work since we aren't changing the originally array
        // // for(int ind:z)
        // //    System.out.println(ind);
        // for(int ind = 0; ind < x.length; ind++)
        //    x[ind] = ind*10; //This works in replacing the original array's values
        // for(int ind:x)
        //    System.out.println(ind);


        // String[] y = new String[5];
        // for(String ind:y)
        //    System.out.println(ind); 

        int[][] arra = new int[2][2]; //a way to create empty 2d arrays
        for (int i=0; i < arra.length; i++){
            for (int j=0; j<arra[i].length; j++)
                System.out.print(arra[i][j]+"|");
            System.out.println();
        }

        int[][] tes = {{12,33},{33,44}}; //alternate way to create 2d arrays
        for (int i=0; i < tes.length; i++){
            for (int j=0; j<tes[i].length; j++)
                System.out.print(tes[i][j]+"|");
            System.out.println();
        }
    }
}    
