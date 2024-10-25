class Solution {
    public List<String> removeSubfolders(String[] folder) {

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < folder.length; i++) {
            String[] split = folder[i].split("/");
            String dir = "";
            for (String ch : split)
                dir += ch +"X";

            set.add(dir);
        }
        System.out.println(set);
        List<String> fetchFolders = new ArrayList<>();
        for( int i =0 ;i< folder.length ; i++){

             String[] split = folder[i].split("/");
             String dir ="";
             
             for(int j =0 ;j< split.length ; j++){
                dir += split[j] + "X";

                if(set.contains(dir)){
                    if(j == split.length -1)
                        fetchFolders.add(folder[i]);

                    break;    
                }
             } 
            

          }

        return fetchFolders;

    }
}