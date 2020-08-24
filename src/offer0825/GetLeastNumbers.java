package offer0825;

/**
 * @author: celeste
 * @create: 2020-08-25 00:20
 * @description:
 * 题目：剑指 Offer 40. 最小的k个数
 * 描述：输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，
 * 则最小的4个数字是1、2、3、4。
 **/
public class GetLeastNumbers {
    /**
     * 最大堆做法：
     * 求最小的k个数可以使用一个最大堆，然后保存前k个，
     * 然后遍历剩下的数字，将小于最大值的数字加入最大堆，一个一个更新
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k){
        if(k==0) return new int[0];
        int[] heap = new int[k];
        for (int i = 0; i < k; i++){
            heap[i] = arr[i];
        }
        for (int i = (k - 1) / 2; i >= 0; i--){
            heapdify(heap, i, k);
        }
        for (int i = k; i < arr.length; i++){
            if (arr[i] < heap[0]){
                heap[0] = arr[i];
                heapdify(heap, 0, k);
            }
        }
        return heap;
    }

    private void heapdify(int[] heap, int i, int k) {
        while (i * 2 + 1 < k){
            int j = 2 * i + 1;
            if (j < k - 1 && heap[j] < heap[j + 1]){
                j++;
            }
            if (heap[i] < heap[j]){
                swap(heap, i, j);
                i = j;
            }else {
                break;
            }

        }
    }

    private void swap(int[] heap, int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
