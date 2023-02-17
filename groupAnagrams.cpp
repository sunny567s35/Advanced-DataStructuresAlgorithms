class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
       vector<bool> visited(strs.size(),false);
        vector<vector<string>> list;
        for(int j =0 ; j < strs.size();j++){
           
            string s1 = strs[j]; 

            if(!visited[j]){
                vector<string> ana;
                visited[j] = true;
                ana.push_back(s1);
                string dum1 = s1;
                
                for(int i =j+1 ; i < strs.size();i++){
                    if(!visited[i]){
                    bool condition = false;
                        string s2 = strs[i];
                        string dum2 = s2;
                        sort(dum1.begin(),dum1.end());
                        sort(dum2.begin(),dum2.end());
                        int n1 = s1.length();
                        int n2 = s2.length();
                        if(n1!=n2){
                            continue;
                        }
                        for(int m =0 ; m < s1.length();m++){
                            
                            if(dum1[m]!=dum2[m]){
                                condition = true;
                                break;
                            }
                        
                    }
                    if(!condition){
                        ana.push_back(s2);
                        visited[i]=true;
                    }
                    else{
                        continue;
                    }
                    }
                   

                } 
            list.push_back(ana);
            
            }
        }
        return list;
    }
};