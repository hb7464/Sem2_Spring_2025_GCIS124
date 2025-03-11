public interface YOOOOOOOOOOOOOOOOOOOOO {
    double convert(double height, double length);

    public static void main(String[] args) {
        
        double[] conv = {3.28084,1.09361};
        YOOOOOOOOOOOOOOOOOOOOO height = new YOOOOOOOOOOOOOOOOOOOOO() {
            public double convert(double height, double length){
                return conv[0]*height;
            }
        };
        YOOOOOOOOOOOOOOOOOOOOO length = new YOOOOOOOOOOOOOOOOOOOOO() {
            public double convert(double height, double length){
                return conv[1]*length;
            }
        };

        System.out.println(height.convert(1.80, 0));
        System.out.println(length.convert(1.80, 54));
        

    }
}
