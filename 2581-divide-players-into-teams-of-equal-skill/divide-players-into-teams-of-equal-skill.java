class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length ;
        int []freq = new int[1001];
        int totalSkill =0 ;

        for(int playerSkill : skill){
            totalSkill += playerSkill ;
            freq[playerSkill]++;
        }

        if(totalSkill % (n/2) != 0) return -1;
   
        int oneTeamSkill = totalSkill / (n/2) ;
        long totalChemistry = 0 ;

        for( int playerSkill : skill){
            int player1Skill = playerSkill ;
            int player2Skill = oneTeamSkill - player1Skill;

            if(freq[player2Skill] == 0)return -1;

            freq[player2Skill]--;
            

            totalChemistry += (long)(player1Skill) * (long)(player2Skill) ;
        
        }
      return totalChemistry/2;  

    }
}