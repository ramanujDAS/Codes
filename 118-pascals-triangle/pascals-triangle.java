class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        list.add(temp);
        for (int i = 1; i < numRows; i++) {

            List<Integer> t = new ArrayList<>();
            t.add(1);
            for (int j = 1; j < i; j++) {
                t.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
            }
            t.add(1);
            list.add(t);
        }
        return list;
    }
}