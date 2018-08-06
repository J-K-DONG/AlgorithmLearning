import java.util.Arrays;

/**
 * 2018��8��6������11:50:32
 * @author JK_DONG
 * TODO
 */

public class CockTailSort {
	
	public static void sort(int array[]) {
		
		int  tmp = 0;

		//��¼�Ҳ����һ�ν�����λ��
		int lastRightExchangeIndex = 0;
		 
		//��¼������һ�ν�����λ��
		int lastLeftExchangeIndex = 0;
		//�������е��ұ߽磬ÿ�αȽ�ֻ��Ҫ�ȵ�����Ϊֹ
		int rightSortBorder = array.length - 1;
		//�������е���߽磬ÿ�αȽ�ֻ��Ҫ�ȵ�����Ϊֹ
		int leftSortBorder = 0;
		
		for(int i = 0 ; i < array.length/2 ; i++) {
			
			//�����ǣ�ÿһ�ֵĳ�ʼ��true
			boolean isSorted = true;
			
			System.out.println("������ѭ��");	
			//�����֣��������ұȽϺͽ���
			for(int j = leftSortBorder ; j < rightSortBorder ; j++) {
				
				if (array[j] > array[j+1]) {
					
					tmp = array[j];	
					array[j] = array[j+1];
					array[j+1] = tmp;
					//��Ԫ�ؽ��������Բ������򣬱�Ǳ�Ϊfalse
					isSorted = false;
					lastRightExchangeIndex = j;
					
				}
			}
			
			rightSortBorder = lastRightExchangeIndex;
			if (isSorted) {
				break;
			}
			
			//ż����֮ǰ�����±��Ϊtrue
			isSorted = true;
			
			
			//ż���֣���������ȽϺͽ���
			System.out.println("���ҵ���ѭ��");
			
			for (int j = rightSortBorder ; j > leftSortBorder ; j--) {
				
				if (array[j] < array[j-1]) {
					tmp = array[j];
					
					array[j] = array[j-1];
					array[j-1] = tmp;
					//��Ԫ�ؽ��������Բ������򣬱�Ǳ�Ϊfalse
					isSorted = false;
					lastLeftExchangeIndex = j;
					
				}
			}
			
			leftSortBorder = lastLeftExchangeIndex;
			if (isSorted) {
				break;
			}
			
		}
		
	}
	
	
	
	public static void main(String[] args) {
		
		int[] array = new int[] {2,3,4,5,6,7,8,1};
		sort(array);
		System.out.println(Arrays.toString(array));
	}
	
	
	

}
