class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        PriorityQueue<Long> pq1 = new PriorityQueue<>();
        for(long x : nums){
            pq1.offer(x);
            if(pq1.size() > k) pq1.poll();
        }
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        while(!pq1.isEmpty()){
            pq.offer(pq1.poll());
        }
        long sum =0;
        while(mul > 0 && !pq.isEmpty()){
            sum += pq.poll()*(long)mul;
            mul--;
        }
        while(!pq.isEmpty()){
            sum += pq.poll();
        }
        return sum;
    }
}