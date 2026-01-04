class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

      Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        Set<String> visited = new HashSet<>();

        int step = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i <size;i++){
                String word = q.poll();
                if(word.equals(endWord))return step;

                for(int j = 0 ; j < word.length() ;j++){
                    for(int ch ='a' ; ch <='z';ch++){
                        char arr[] = word.toCharArray();
                       arr[j] = (char)ch;
                       String replacedWord = new String(arr);
                       if(set.contains(replacedWord) && !visited.contains(replacedWord)){
                         q.add(replacedWord);
                         visited.add(replacedWord);
                       }
                    }
                }
            }
            step++;
        } 
        return 0; 
    }
}