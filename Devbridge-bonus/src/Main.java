public class Main {
    public static void main(String[] args) {
        printBonusDatesBetween(1000, 3999);
    }
    public static void printBonusDatesBetween(int fromYear, int toYear) {
        if(toYear > 9999 || fromYear > toYear || fromYear<1000) return;
        for (int i=fromYear; i<=toYear; i++) {
            boolean magic = false;                  //If this boolean is true in the end of the cycle, the year is a palindrome
            int month = (i%10)*10 + (i/10%10);
            int day = i/100%10*10 + i/1000;

            if(month==2 && day<29) magic=true;      //Special case for February

            switch (month%2) {                      //Checking whether a month has 30 or 31 days
                case 0:
                    if(month<13 && day<31) magic=true;
                    break;
                case 1:
                    if(month<13 && day<32) magic=true;
                    break;
            }
            if(day<1 || month<1) magic=false;       //If either day or month is zero, don't print
            if(magic) System.out.println(i + "-" + String.format("%02d", month) + "-" + String.format("%02d", day));
        }
    }
}