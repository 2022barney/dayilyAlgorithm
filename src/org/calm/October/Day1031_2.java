package org.calm.October;

import java.util.ArrayList;
import java.util.List;

/**
 * ------------------------
 *
 * ------------------------
 * @author liyang
 * @date 2022/10/31
 * @version 1.0
 * ------------------------
 */
public class Day1031_2 {
    List<String> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) {
            return res;
        }
        // 经典回溯模板,相比于分割字符串只加入分割线一个参数以外，
        // 这里还需要添加额外的层数参数level
        backtracking(s, 0, 0);
        return res;
    }

    void backtracking(String s, int splitIndex, int level) {
        // 递归终止条件，分割的四个字符串都是合法的ip地址
        if (level == 4) {
            res.add(String.join(".", path));
            return;
        }
        for (int i = splitIndex; i < s.length(); i++) {
            // 每一次分割之后，对剩余字符长度是否合理进行判断，
            // 剪枝操作，优化运行速度
            if (s.length() - i - 1 > 3 * (3 - level)) {
                continue;
            }
            //如果分割的字符串不是合理的ip地址，跳过
            if (!isValidIp(s.substring(splitIndex, i + 1))) {
                continue;
            }

            // 把合法的ip地址段加入path存储
            path.add(s.substring(splitIndex, i + 1));
            // 每次把分割线往后移一位， 且段数level + 1
            backtracking(s, i + 1, level + 1);
            // 进行回溯操作
            path.remove(path.size() - 1);
        }
    }

        boolean isValidIp(String s) {
            // 判断是否含有前导0
            if (s.charAt(0) == '0' && s.length() > 1) {
                return false;
            }
            // 长度为4就直接舍弃
            if (s.length() > 3) {
                return false;
            }
            if (Integer.parseInt(s) > 255) {
                return false;
            }
            return true;
        }
}
