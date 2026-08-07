class Solution {
    
    static void solve(String s ,  ArrayList<String> ans , String output ) {
        
        //base case 
        
        if(s.isEmpty()) {
            ans.add(output);
            return; 
        }
        
        for(int i = 0; i < s.length();i++) {
            char ch = s.charAt(i);
            
            String remString = s.substring(0,i) + s.substring(i + 1);
            
            solve(remString , ans , output + ch);
            
      
        }
    }
    public ArrayList<String> permutation(String s) {
        ArrayList<String> ans = new ArrayList<>();
        
        
        solve(s , ans , "");
        Collections.sort(ans);
        return ans;
        // code here
        
    }
}