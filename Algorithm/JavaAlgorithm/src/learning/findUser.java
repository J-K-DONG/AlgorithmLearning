package learning;

public class findUser {
    public static void find3User(String[] Id){
        int[] times = {0, 0, 0};
        String[] resId = new String[3];
        for(int i = 0; i < Id.length; ++i){
            if(Id[i].equals(resId[0])){
                ++times[0];
            }
            else if(Id[i].equals(resId[1])){
                ++times[1];
            }
            else if(Id[i].equals(resId[2])){
                ++times[2];
            }
            else if(times[0] == 0){
                resId[0] = Id[i];
                ++times[0];
            }
            else if(times[1] == 0){
                resId[1] = Id[i];
                ++times[1];
            }
            else if(times[2] == 0){
                resId[2] = Id[i];
                ++times[2];
            }
            else {
                --times[0];
                --times[1];
                --times[2];
            }
            System.out.println("---------");
            for (int j = 0; j < 3; j++){
                System.out.println("目标 " + j + " 的ID是 ： "+ resId[j]);
                System.out.println("出现次数是 ：" + times[j]);
            }

            System.out.println();
        }
        System.out.println(resId[0]);
        System.out.println(resId[1]);
        System.out.println(resId[2]);
    }

    public static void main(String[] args){

        String[] Id = {"1", "1", "1", "5", "4", "2", "2", "3", "3", "3", "2"};
        find3User(Id);
    }
}
