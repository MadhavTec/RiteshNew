package org.egov.common.persistence.repository;
import java.util.*;

public class BuyingShowTickets {
    public static long watingTime(int[] tickets, int p) {
        List<Integer> queue = new ArrayList<Integer>();
        for (int ticket : tickets) {
            queue.add(ticket);
        }
        int ctr = 0, i = 0;
	    while (queue.get(p) > 0) {
//            System.out.println("queue = " + queue + " :: i = " + i + " :: p = " + p + " :: ctr = " + ctr);
    		if (queue.get(i) == 1) {
                if (i == p) {
                    ctr++;
                    break;
                }
                if (i < p)
                    p--;
                queue.remove(i);
                if (i == queue.size()) {
                    i = 0;
                }
            } else {
                queue.set(i, queue.get(i) - 1);
                if (i < queue.size() - 1) {
                    i++;
                } else {
                    i = 0;
                }
            }
            ctr++;
		}
		return ctr;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int no = sc.nextInt();
		int tickets[] = new int[no];
		for (int i = 0; i < no; i++) {
			tickets[i] = sc.nextInt();
		}
		int pos = sc.nextInt();
		System.out.println(watingTime(tickets, pos));
	}
}