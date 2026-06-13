
class Twitter {
    private static int timestamp = 0;
    private Map<Integer, List<Tweet>> userTweets;
    private Map<Integer, Set<Integer>> following;

    private class Tweet {
        int id;
        int time;
        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    public Twitter() {
        userTweets = new HashMap<>();
        following = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        userTweets.putIfAbsent(userId, new ArrayList<>());
        userTweets.get(userId).add(new Tweet(tweetId, timestamp++));
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);

        if (userTweets.containsKey(userId)) {
            pq.addAll(userTweets.get(userId));
        }
        Set<Integer> followedUsers = following.getOrDefault(userId, new HashSet<>());
        for (int followeeId : followedUsers) {
            if (userTweets.containsKey(followeeId)) {
                pq.addAll(userTweets.get(followeeId));
            }
        }

        List<Integer> feed = new ArrayList<>();
        int count = 0;
        while (!pq.isEmpty() && count < 10) {
            feed.add(pq.poll().id);
            count++;
        }
        return feed;
    }

    public void follow(int followerId, int followeeId) {
        
        if (followerId == followeeId) return;
        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}