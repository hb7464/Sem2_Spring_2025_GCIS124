public class Callingmonthsenum {
    public static void main(String[] args) {
        months[] month = new months[12];
        month[0] = months.January;
        month[1] = months.February;
        month[2] = months.March;
        month[3] = months.April;
        month[4] = months.May;
        month[5] = months.June;
        month[6] = months.July;
        month[7] = months.August;
        month[8] = months.September;
        month[9] = months.October;
        month[10] = months.November;
        month[11] = months.December;

        
        for (months month1 : month) {
            System.out.println(month1 + " " + month1.getdays());
        }

    }
}