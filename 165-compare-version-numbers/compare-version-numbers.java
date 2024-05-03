class Solution {
    public boolean allZeros(String[] v, int len) {
        for (int i = len; i < v.length; i++) {
            if (Integer.parseInt(v[i]) > 0)
                return false;
        }
        return true;
    }

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("[.]");
        String[] v2 = version2.split("[.]");
       //  System.out.println(v1.length);
        // for(String v:v1)
        // System.out.println(v);

        for (int i = 0; i < Math.min(v1.length, v2.length); i++) {
            // System.out.println(Integer.parseInt(v1[i].trim())+"
            // "+Integer.parseInt(v2[i].trim()));
            if (Integer.parseInt(v1[i].trim()) < Integer.parseInt(v2[i].trim()))
                return -1;
            if (Integer.parseInt(v1[i]) > Integer.parseInt(v2[i]))
                return 1;
        }

        if (v1.length == v2.length)
            return 0;

        if (v1.length == Math.min(v1.length, v2.length)) {
            return allZeros(v2, v1.length) ? 0 : -1;
        }
        return allZeros(v1, v2.length) ? 0 : 1;
    }
}