package org.calm.November;
/**
 * ------------------------
 *
 * ------------------------
 * @author liyang
 * @date 2022/11/24
 * @version 1.0
 * ------------------------
 */
public class Day1124 {

    public static void main(String[] args) {
        String[] split = "2001:0db8:85a3:0:0:8A2E:0370:7334:".split(":", -1);
        System.out.println(split.length);

        for (String s : split) {
            System.out.print(s);
            System.out.println("  XX");
        }
    }
    public static String validIPAddress(String queryIP) {
        if (isIPv4(queryIP)) {
            return "IPv4";
        }
        if (isIPv6(queryIP)) {
            return "IPv6";
        }
        return "Neither";
    }
    static boolean isIPv4(String queryIP) {
        int len = queryIP.length();
        if (len < 7 || len > 15) {
            return false;
        }
        String[] ips = queryIP.split("\\.", -1);
        if (ips.length == 4) {
            for (String ip : ips) {
                int n = ip.length();
                if (n < 1 || n > 3) {
                    return false;
                }
                if (ip.charAt(0) == '0' && n > 1) {
                    return false;
                }
                for (int i = 0; i < n; i++) {
                    if (ip.charAt(i) < '0' || ip.charAt(i) > '9') {
                        return false;
                    }
                }
                int x = Integer.parseInt(ip);
                if (x > 255) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    static boolean isIPv6(String queryIP) {
        int len = queryIP.length();
        if (len < 15 || len > 39) {
            return false;
        }
        String[] ips = queryIP.split(".", -1);
        if (ips.length == 8) {
            for (String ip : ips) {
                int n = ip.length();
                if (n < 1 || n > 4) {
                    return false;
                }

                for (int i = 0; i < n; i++) {
                    if ( !((ip.charAt(i) >= '0' && ip.charAt(i) <= '9') ||
                            (ip.charAt(i) >= 'a' && ip.charAt(i) <= 'f') ||
                            (ip.charAt(i) >= 'A' && ip.charAt(i) <= 'F')) ) {
                        return false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
