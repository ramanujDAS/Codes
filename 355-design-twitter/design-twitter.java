class Twitter {

    Map<Integer, List<Tweet>> tweetsByUserId;
    Map<Integer, List<Integer>> followerByUserId;
    int topK = 10;
    int time = 0;

    public Twitter() {
        tweetsByUserId = new HashMap<>();
        followerByUserId = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {

        List<Tweet> tweets = tweetsByUserId.getOrDefault(
                userId,
                new ArrayList<>());

        Tweet tweet = new Tweet(tweetId, time);
        time++;
        tweets.add(tweet);
        tweetsByUserId.put(
                userId, tweets);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> followers = followerByUserId.getOrDefault(userId, new ArrayList<>());
        //add userIDAs well 

        List<Tweet> totalTweets = new ArrayList<>(tweetsByUserId.getOrDefault(userId, new ArrayList<>()));

        for (int user : followers) {
            totalTweets.addAll(tweetsByUserId.getOrDefault(user, new ArrayList<>()));
        }

        Collections.sort(totalTweets, (a, b) -> (b.time - a.time));

        List<Tweet> newsFeed = totalTweets.subList(0, Math.min(
                topK, totalTweets.size()));

        List<Integer> ans = new ArrayList<>();

        for (Tweet tw : newsFeed) {
            ans.add(tw.id);
        }
        return ans;

    }

    public void follow(int followerId, int followeeId) {
        List<Integer> followers = followerByUserId.getOrDefault(followerId, new ArrayList<>());
        if(!followers.contains(Integer.valueOf(followeeId)))
             followers.add(followeeId);

        followerByUserId.put(followerId, followers);

    }

    public void unfollow(int followerId, int followeeId) {
        List<Integer> followers = followerByUserId.getOrDefault(followerId, new ArrayList<>());

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