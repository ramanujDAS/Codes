class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {

       int [] maxFreq = new int[26];
       List<String> wordSubsets = new ArrayList<>();
       for(String word : words2){
         int [] currentFreq = new int[26];
         for( int i = 0; i < word.length() ;i++){
            currentFreq[word.charAt(i) - 'a']++; 
         }

         for(int i = 0 ;i< 26 ;i++){
            maxFreq[i] = maxFreq[i] < currentFreq[i] ? currentFreq[i] : maxFreq[i] ;
         }
       }

       for(String word : words1){
        int [] currentFreq = new int[26];

        for( int i = 0 ; i < word.length() ; i++){
            currentFreq[word.charAt(i) - 'a']++;
        }
        boolean flag = true;
        for( int i = 0 ; i < 26 ;i++){

            if(currentFreq[i] < maxFreq[i]){
                flag = false;
            }
         }
        if(flag)wordSubsets.add(word);
       } 

       return wordSubsets; 
    }
}