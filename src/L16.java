import java.util.Arrays;

public class L16 {

    //排序+双指针法 所求为让nums[i] + nums[j] + nums[k] - target的绝对值最小。这里先设定nums[i] < nums[j] < nums[k]来方便解题
    public static int threeSumClosest(int[] nums, int target) {
        //首先由小到大排序
        Arrays.sort(nums);
        int distance = Integer.MAX_VALUE;
        //第一重循环由大到小遍历三个元素中最小的元素，即nums[i]，这样可以避免重复情况，降低时间复杂度
        for (int i = 0; i < nums.length - 2; i++) {
            int newTarget = target - nums[i];
            //双指针法，从小到大找j，从大到小找k，这样也能避免重复遍历，降低时间复杂度
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k){
                int currentDistance = nums[j] + nums[k] - newTarget;
                //三种情况
                //1 如果三数和直接等于target则直接返回
                //2 如果三数和小于target就增大nums[j]，即j++
                //3 如果三数和大于target就减小nums[k]，即k--
                if (currentDistance == 0){
                    return target;
                }
                //每次保存最新的最优解
                distance = Math.abs(currentDistance) > Math.abs(distance) ? distance : currentDistance;
                if (currentDistance > 0) {
                    k--;
                }
                else {
                    j++;
                }
            }
        }
        return distance + target;
    }


    public static void main(String[] args) {
        int[] a = new int[]{-1, 2, 1, -4};
        System.out.println(threeSumClosest(a, 1));
        System.out.println(Math.abs(-100000));
    }
}
