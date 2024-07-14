class Solution {
   public String countOfAtoms(String formula) {
        Deque<Map<String, Integer>> stack = new ArrayDeque<>();
        stack.push(new HashMap<>());
        int n = formula.length();
        int i = 0;

        while (i < n) {
            char c = formula.charAt(i);
            if (c == '(') {
                stack.push(new HashMap<>());
                i++;
            } else if (c == ')') {
                Map<String, Integer> top = stack.pop();
                i++;
                int countStart = i;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int count = countStart < i ? Integer.parseInt(formula.substring(countStart, i)) : 1;
                Map<String, Integer> current = stack.peek();
                for (String atom : top.keySet()) {
                    current.put(atom, current.getOrDefault(atom, 0) + top.get(atom) * count);
                }
            } else {
                int start = i;
                i++;
                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String atom = formula.substring(start, i);
                int countStart = i;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int count = countStart < i ? Integer.parseInt(formula.substring(countStart, i)) : 1;
                Map<String, Integer> current = stack.peek();
                current.put(atom, current.getOrDefault(atom, 0) + count);
            }
        }

        Map<String, Integer> countMap = stack.pop();
        TreeMap<String, Integer> sortedMap = new TreeMap<>(countMap);
        StringBuilder result = new StringBuilder();
        for (String atom : sortedMap.keySet()) {
            result.append(atom);
            int count = sortedMap.get(atom);
            if (count > 1) {
                result.append(count);
            }
        }
        return result.toString();
    }
}