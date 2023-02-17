class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> mymap;
        for(string s : strs){
            string curr = s;
            sort(s.begin(),s.end());
            auto it = mymap.find(s);
            if(it==mymap.end()){
                mymap[s] = {curr};
            }
            else{
                it->second.push_back(curr);
            }
        }
        vector<vector<string> >ans;
        for(auto iter = mymap.begin() ; iter != mymap.end(); iter++){
            ans.push_back(iter->second);
        }
        return ans;
    }
};