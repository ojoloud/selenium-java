package extend.basic;

public enum  TargetDates {
    JANUARY ("January 2020", 1),
    February ("February 2020", 2);

    private  String D;
    public  int num;

    TargetDates(String d, int num) {
        D = d;
        this.num = num;
    }


    public  String getD() {
        return D;
    }

    public int getNum() {
        return num;
    }
    public TargetDates getTargetDate(int dateNum) {
        TargetDates date = null;
        int i=1;
        for (TargetDates item:TargetDates.values()){
            if (item.equals(i)){
                date=item;
                break;
            }
        }
        return date;
    }
}
