class Solution {
  public int minSwaps(String s) {
    int stacksize = 0;

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == '[')
        stacksize++;
      else {
        if (stacksize>0)
          stacksize--;
      }
    }
    return (stacksize + 1) / 2;
  }
}