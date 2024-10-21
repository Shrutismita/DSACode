Q:- https://practice.geeksforgeeks.org/problems/factorials-of-large-numbers2508/1#
Company Tags : ADOBE, BROWSERSTACK, MAKEMYTRIP, MAQ SOFTWARE, MICROSOFT, MORGAN STANLEY, PHILIPS, SAMSUNG
************************************************************************************************************
  class Solution {
    public static ArrayList<Integer> factorial(int N) {
         ArrayList<Integer> list = new ArrayList<>();
    list.add(1);

    for (int i = 2; i <= N; i++) {
        multiply(i, list);
    }

    Collections.reverse(list);
    return list;
}

private static void multiply(int num, ArrayList<Integer> list) {
    int carry = 0;

    for (int i = 0; i < list.size(); i++) {
        int product = list.get(i) * num + carry;
        list.set(i, product % 10);
        carry = product / 10;
    }

    while (carry > 0) {
        list.add(carry % 10);
        carry /= 10;
    }
}
}
  
