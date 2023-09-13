public class Main {
    public static void main(String[] args) {
        printBonusDatesBetween(1000, 3999);
    }
    public static void printBonusDatesBetween(int fromYear, int toYear) {
        if(toYear > 9999 || fromYear > toYear || fromYear<1000) return;
        for (int i=fromYear; i<=toYear; i++) {
            boolean magic = false;
            int month = (i%10)*10 + (i/10%10);
            int day = i/100%10*10 + i/1000;

            if(month==2 && day<29) magic=true;

            switch (month%2) {
                case 0:
                    if(month<13 && day<31) magic=true;
                    break;
                case 1:
                    if(month<13 && day<32) magic=true;
                    break;
            }
            if(day<1 || month<1) magic=false;
            if(magic) System.out.println(i + "-" + String.format("%02d", month) + "-" + String.format("%02d", day));
        }
    }
}