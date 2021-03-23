package leetcode.editor.cn;

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4840 👎 0

public class LongestSubstringWithoutRepeatingCharacters{
	public static void main(String[] args) {
		Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
		String s = "pwwkew";
		System.out.println(solution.lengthOfLongestSubstring(s));
	}
//algorithm submit region begin(Prohibit modification and deletion)
class Solution {
	public int lengthOfLongestSubstring(String s) {
		int i = 0;
		int flag = 0;
		int length = 0;
		int result = 0;
		while (i < s.length()) {
			int pos = s.indexOf(s.charAt(i),flag);//从flag位置开始检索是否有前面的值
			if (pos < i) {
				if (length > result) {
					result = length;
				}
				if (result >= s.length() - pos - 1) {
					return result;
				}
				length = i - pos - 1;
				flag = pos + 1;
			}
			length++;
			i++;
		}
		return length;
	}

/*    public int lengthOfLongestSubstring(String s) {
    	int length = s.length();
    	int max = 0;
    	int now = 0;
    	String[] array = s.split("");
    	for (int i =0; i<length; i++){
    		//String s1 = array[i];
			now = 1;
    		//boolean flag = false;
    		outer: for (int j=i+1; j<length; j++){
    			now = j - i + 1;
    			for (int k=i; k< j; k++){
    				//现有范围中有重复的
					if (array[j].equals(array[k])){
						now = j - i;
						break outer;
					}
				}
			}
    		//if (flag){
				max = Math.max(max,now);
			//}
		}
    	return max;
    }*/
}
//algorithm submit region end(Prohibit modification and deletion)

}
