class Twitter {

    Map<Integer, HashSet<Tweet>> tweetsByUserId;
    Map<Integer, HashSet<Integer>> followerByUserId;
    int topK = 10;
    int time = 0;

    public Twitter() {
        tweetsByUserId = new HashMap<>();
        followerByUserId = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {

        HashSet<Tweet> tweets = tweetsByUserId.getOrDefault(
                userId,
                new HashSet<>());

        Tweet tweet = new Tweet(tweetId, time);
        time++;
        tweets.add(tweet);
        tweetsByUserId.put(
                userId, tweets);
    }

    public List<Integer> getNewsFeed(int userId) {
        Queue<Tweet> pq = new PriorityQueue<>((a, b) -> a.time - b.time);

        HashSet<Integer> followers = followerByUserId.getOrDefault(userId, new HashSet<>());
        //add userIDAs well 

      for (Tweet t : tweetsByUserId.getOrDefault(userId, new HashSet<>())) {
            pq.add(t);
            if (pq.size() > 10) {
                pq.remove();
            }
        }


        for (int user : followers) {

            for (Tweet t : tweetsByUserId.getOrDefault(user, new HashSet<>())) {
                pq.add(t);
                if (pq.size() > 10)
                    pq.remove();
            }
        }
         

        List<Integer> ans = new ArrayList<>();

       while(pq.size() > 0){
          ans.add(pq.remove().id);
       }

       Collections.reverse(ans);
        return ans;

    }

    public void follow(int followerId, int followeeId) {
        HashSet<Integer> followers = followerByUserId.getOrDefault(followerId, new HashSet<>());
        followers.add(followeeId);
        followerByUserId.put(followerId, followers);

    }

    public void unfollow(int followerId, int followeeId) {
        HashSet<Integer> followers = followerByUserId.getOrDefault(followerId, new HashSet<>());

        if (followers.size() == 0)
            return;

        followers.remove(Integer.valueOf(followeeId));
    }

    public static class Tweet {
        int id;
        int time;

        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */