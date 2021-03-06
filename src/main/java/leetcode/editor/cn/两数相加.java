package leetcode.editor.cn;

//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 
// 👍 5701 👎 0

import java.util.Stack;

public class 两数相加{
	public static void main(String[] args) {
		Solution solution = new 两数相加().new Solution();
		ListNode p = null;
		ListNode l1 = new ListNode(2);
		p = l1;
		p.next = new ListNode(4);
		p = p.next;
		p.next = new ListNode(3);


		ListNode l2 = new ListNode(5);
		p = l2;
		p.next = new ListNode(6);
		p = p.next;
		p.next = new ListNode(4);

		System.out.println();
		ListNode l3 = solution.addTwoNumbers(l1,l2);
		while (l3 != null){
			System.out.println(l3.val);
			l3 = l3.next;
		}
	}


  public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
//algorithm submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int a1 = 0,a2 = 0,a = 1,sum = 0,qy = 0;
		ListNode l3 = new ListNode(0);
		ListNode p = l3;

    	while (l1 !=null || l2 != null){
    		if (l1 != null){
    			a1 = l1.val;
				l1 = l1.next;

			}
    		if (l2 != null){
    			a2 = l2.val;
				l2 = l2.next;
			}
			sum =  qy + a1 + a2;
			qy = 0;
			if (sum > 9){
				qy = sum / 10;
				sum =  sum % 10;
			}
    		a1 = 0;
    		a2 = 0;
			p.next = new ListNode(sum);
			p = p.next;
		}
    	if (qy != 0){
			p.next = new ListNode(qy);
			p = p.next;
		}
    	return l3.next;
    }
}
//algorithm submit region end(Prohibit modification and deletion)

}
