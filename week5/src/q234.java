class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void build(int[] num) {
        ListNode head = this;
        for (int i : num) {
            head.next = new ListNode(i);
            head = head.next;
        }
    }
}

public class q234 {
    public boolean isPalindrome(ListNode head) {
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            ListNode temp = slow.next;
            if(pre != null) {
                slow.next = pre;
            }
            pre = slow;
            fast = fast.next.next;
            slow = temp;
        }
        if(fast != null) slow = slow.next;
        while(slow != null){
            if(slow.val != pre.val) return false;
            slow = slow.next;
            pre = pre.next;
        }
        return true;
    }

    public static void main(String[] args) {
        int [] num={1,2,1};
        q234 q = new q234();
        ListNode node = new ListNode(-1);
        node.build(num);
        System.out.println(q.isPalindrome(node.next));
    }
}
