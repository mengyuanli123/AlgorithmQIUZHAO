/**
 21. 合并两个有序链表
 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 示例：

 输入：1->2->4, 1->3->4
 输出：1->1->2->3->4->4
 */

public class mergeTwoLists {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode recursion(ListNode l1,ListNode l2){
        if(null==l1)
            return l2;
        else if(null==l2)
            return l1;
        else{
            if(l1.val<l2.val){
                l1.next = recursion(l1.next,l2);
                return l1;
            }else{
                l2.next = recursion(l1,l2.next);
                return l2;
            }
        }
    }

    public ListNode solutionWithoutRecursion(ListNode l1,ListNode l2){

        ListNode preHead = new ListNode(-1);
        ListNode preNode = preHead;
        while(null!=l1 && null!=l2){
            if(l1.val<l2.val){
                preNode.next = l1;
                l1 = l1.next;
            }else{
                preNode.next = l2;
                l2 = l2.next;
            }
            preNode = preNode.next;
        }
        if(null==l1)
            preNode.next = l2;
        else if(null==l2)
            preNode.next = l1;
        return preHead.next;
    }
}
