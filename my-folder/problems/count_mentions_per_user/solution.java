class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        PriorityQueue<List<String>> pq = new PriorityQueue<>((a,b) -> {
            int timeA = Integer.parseInt(a.get(1));
            int timeB = Integer.parseInt(b.get(1));
            if(timeA != timeB){
                return Integer.compare(timeA, timeB);
            }
            boolean aMessage = a.get(0).equals("MESSAGE");
            boolean bMessage = b.get(0).equals("MESSAGE");
            return Boolean.compare(aMessage, bMessage);
        });
        for(int i = 0; i < events.size(); i++){
            pq.add(events.get(i));
        }
        int[] ans = new int[numberOfUsers];
        PriorityQueue<int[]> offline = new PriorityQueue<int[]>((a,b) -> Integer.compare(a[1], b[1]));
        HashSet<Integer> offlineUsers = new HashSet<>();
        while(!pq.isEmpty()){
            List<String> event = pq.poll();
            if(event.get(0).equals("OFFLINE")){
                int userId = Integer.parseInt(event.get(2));
                int time = Integer.parseInt(event.get(1));
                while(!offline.isEmpty() && offline.peek()[1] <= time){
                    int[] user = offline.poll();
                    if(offlineUsers.contains(user[0])){
                        offlineUsers.remove(user[0]);
                    }
                }
                offline.add(new int[]{userId, time + 60});
                offlineUsers.add(userId);
            }
            if(event.get(0).equals("MESSAGE")){
                int time = Integer.parseInt(event.get(1));
                while(!offline.isEmpty() && offline.peek()[1] <= time){
                    int[] user = offline.poll();
                    if(offlineUsers.contains(user[0])){
                        offlineUsers.remove(user[0]);
                    }
                }
                if(event.get(2).equals("ALL")){
                    for(int i = 0; i < numberOfUsers; i++){
                        ans[i]++;
                    }
                } else if(event.get(2).equals("HERE")){
                    for(int i = 0; i < numberOfUsers; i++){
                        if(!offlineUsers.contains(i)){
                            ans[i]++;
                        }
                    }
                } else {
                    String[] ids = event.get(2).split(" ");
                    for(int i = 0; i < ids.length; i++){
                        String id = ids[i].substring(2, ids[i].length());
                        int uid = Integer.parseInt(id);
                        ans[uid]++; 
                    }
                }
            }
        }
        return ans;
    }
}