package leetcode.editor.cn;

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4569 👎 0

public class LongestSubstringWithoutRepeatingCharacters{
	public static void main(String[] args) {
		Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
		solution.lengthOfLongestSubstring("pwwkew");
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
    	String[] array = s.split("");
    	int len = array.length;
    	int max = 0,min = 0;
    	for (int i=0;i<len;i++){
    		for (int j = i;j<len;j++){
    			for (int h =j+1;h<len;h++){
					if (array[j] == array[h]){
						min = h-j;
					}
				}
    			if (max < min) max = min;
    			min = 0;
			}
		}
		System.out.println(max);
		return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
