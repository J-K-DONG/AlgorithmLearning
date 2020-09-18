package learning;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class trainDelivery {
    public static void train(int m){
        int goods = m;
        int distance = 1000;
        int trainCapacity = 1000;
        int fuelConsumption = 1;
        int numOfPlatform = goods / trainCapacity - 1;
        int rest = 0;
        System.out.println("number of platforms is : " + numOfPlatform);
        int[] platform = new int[numOfPlatform];
        for (int i = 0; i < numOfPlatform; i++){
            platform[i] = 1000 / ((numOfPlatform - i) * 2 + 1);
            System.out.println("第 "+ (i + 1) + " 段距离为 ：" + platform[i]);
            rest = rest + platform[i];
        }
        System.out.println("最终运到集市上的货物为 ：" + rest);
    }

    public static void bag(){
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());  // 任务个数
        String[] strings = scanner.nextLine().split(" ");  // 每个任务的计算量 单位是 MB
        int[] task = new int[num];
        int sum = 0;
        for (int i = 0; i < num; i++) {
            task[i] = Integer.parseInt(strings[i]);
            sum += task[i];
        }
        // 处理时间的二维数组
        int[][] handler = new int[num + 1][sum / 2 + 1];
        for (int i = 0; i <= num; i++)  // 遍历每个任务
            for (int j = 0; j <= sum / 2; j++) {  // 背包容量为 sum / 2
                handler[i][j] = (i == 0) ? 0 : handler[i - 1][j];
                if (i > 0 && j >= task[i - 1])  // 判断是否要放入当前任务
                    handler[i][j] = Math.max(handler[i - 1][j], handler[i - 1][j - task[i - 1]] + task[i - 1]);
            }
        System.out.print(Math.max(handler[num][sum / 2], sum - handler[num][sum / 2]));
    }


    public static void main(String[] args) {

        int[][] a = {{2, 1, 2, 3, 4},
                {1, 0, 0, 0, 0},
                {2, 3, 4, 2, 4}};
        int length = (a.length - 2) / 2;



    }



}
