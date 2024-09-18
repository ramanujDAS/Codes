class Solution {
    public String largestNumber(int[] nums) {

        String[] list = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            list[i] = Integer.toString(nums[i]);
        }

        Arrays.sort(list, (a, b) -> (b + a).compareTo(a + b));

        if(list[0].equals("0"))return "0" ;
        String largestNumber = "";
        for (String s : list) {
            largestNumber += s;
        }

        return largestNumber;

    }
}