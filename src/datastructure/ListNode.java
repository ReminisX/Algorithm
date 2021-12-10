package datastructure;

/**
 * @author l
 */
public class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int val) {
		this.val = val; 
		this.next = null;
	}
	public ListNode(){}
	public ListNode(int[] nums){
		if(nums.length == 1){
			this.val = nums[0];
		}else{
			ListNode now = new ListNode(nums[1]);
			this.val = nums[0];
			this.next = now;
			for (int i = 2; i < nums.length; i++) {
				ListNode temp = new ListNode(nums[i]);
				now.next = temp;
				now = now.next;
			}
		}
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append(this.val);
		ListNode now = this.next;
		while(now != null){
			sb.append("->");
			sb.append(now.val);
			now = now.next;
		}
		sb.append("]");
		return sb.toString();
	}
}
