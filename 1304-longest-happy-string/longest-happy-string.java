class Solution {


    public String longestDiverseString(int a1, int b1, int c1) {

      PriorityQueue<Letter> pq = new PriorityQueue<Letter>((x,y) -> Integer.compare(y.count , x.count));
      

     if(a1 > 0)
       pq.add(new Letter('a' ,a1));

    if(b1 > 0)
      pq.add(new Letter('b' , b1));

    if(c1 > 0)
      pq.add(new Letter('c' , c1));

      StringBuilder sb = new StringBuilder();

      while(pq.size() > 0){
       Letter letter = pq.poll();
       int count = letter.count ;
       char ch = (char)letter.ch;

       if(sb.length() >= 2 &&
          sb.charAt(sb.length()-1) == ch &&
          sb.charAt(sb.length()-2) == ch){
             if(pq.size() == 0) break;;

             Letter letterT = pq.poll();

             sb.append(letterT.ch);
             if(letterT.count - 1 > 0){
                letterT.count--;
                pq.add(letterT);
             }
          }else{
             letter.count--;
             sb.append(ch);  
          }
           
         if(letter.count > 0){
           pq.add(letter);
         }   
          

          }

   return sb.toString();
      }        
    


    
    class Letter{
        char ch;
        int count ;
        public Letter(char ch , int count){
            this.ch = ch;
            this.count = count ;
        }
    }
}