class Solution {
    public List<String> stringMatching(String[] words) {

       String compareString = new String();

       for( String word  : words ){
        compareString += (word);
        compareString += ("|");
       } 
       List<String> ans = new ArrayList<>();
       
       for(String word : words){
           if(compareString.indexOf(word) != compareString.lastIndexOf(word)){
                ans.add(word);
            }
       }

       return ans;
    }
}