class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
    int prevColor = image[sr][sc] ;
    if(color != prevColor){
        dfs(image , sr , sc , color, prevColor);
        }

    return image;    
    }

    private void dfs(int[][] image , int i , int j , int color , int prevColor){
      if(i < 0 || i >= image.length || j < 0 || j >= image[0].length){
        return ;
      }
     if(image[i][j] == prevColor)
       {
          image[i][j] = color;
          dfs(image , i+1 , j , color , prevColor);
          dfs(image , i-1 , j , color , prevColor);
          dfs(image , i , j+1 , color, prevColor);
          dfs(image , i , j-1 , color, prevColor);
       }
     
     }
}
