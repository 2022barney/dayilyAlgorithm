//
// Created by $barney on 2022/11/8.
//

class Solution {
public:
    int countConsistentStrings(string allowed, vector<string>& words) {
        vector<int> cnt(26);
        for (char &c : allowed) {
            cnt[c - 'a']++;
        }
        int res = 0;
        for (string &word : words) {
            bool ok = true;
            for (char &c : word) {
                if (cnt[c - 'a'] == 0) {
                    ok = false;
                    break;
                }
            }
            if (ok) res++;
        }
        return res;
    }
};

