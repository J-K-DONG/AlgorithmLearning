import java.util.Arrays;

class BubbleSort{

	
	public static void sort(int array[]){
		int temp = 0;
		for(int i=0; i<array.length;i++){
			for(int j=0;j<array.length-i-1;j++){
				if(array[j]>array[j+1]){
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;

				}
			}
		}
	}
	
	
	/**
	 * @param array
	 * 	�Ż�ð������
	 */
	public static void sortOptimization(int array[]){
		boolean flag = true;
		int lastExchangeIndex = 0;
		int temp=0;
		int sortedBoard = array.length-1; 
		for(int i=0; i<array.length;i++){
			flag = true;
			for(int j=0;j<sortedBoard;j++){
				if(array[j]>array[j+1]){
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					//��¼ÿһ����󽻻���λ�ã���Ϊ��һ�εı߽�
					lastExchangeIndex = j;
					flag = false;
				}
			}
			sortedBoard = lastExchangeIndex;
			//�жϱ��ִ��Ƿ��н���
			if (flag) {
				break;
			}
		}
	}

	public static void main(String[] args){
		int[] array1 = new int[]{3,2,1,5,6,7,8};
		sort(array1);
		System.out.println(Arrays.toString(array1));
		
		int[] array2 = new int[]{5,8,3,4,7,2,1};
		sortOptimization(array2);
		System.out.println(Arrays.toString(array2));
	}


}
