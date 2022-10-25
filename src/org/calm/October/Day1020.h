//
// Created by 李阳 on 2022/10/25.
//

#ifndef DAILYALGORITHM_DAY1020_H
#define DAILYALGORITHM_DAY1020_H

namespace std {

    class Day1020 {
    public:
        int kthGrammar(int n, int k) {
            return n==1?0:(!(k%2))^kthGrammar(n-1,(k+1)/2);
        }
    };

} // std

#endif //DAILYALGORITHM_DAY1020_H
