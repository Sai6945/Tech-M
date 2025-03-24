package Day5;

import java.util.*;

public class SocialMediaSystem {
    private String username;
    private HashSet<String> followers;

    public SocialMediaSystem(String username) {
        this.username = username;
        this.followers = new HashSet<>();
    }

    public void addFollower(String follower) {
        followers.add(follower);
    }

    public void displayFollowers() {
        TreeSet<String> sortedFollowers = new TreeSet<>(followers);
        System.out.println(username + "'s Followers:");
        for (String follower : sortedFollowers) {
            System.out.println(follower);
        }
    }

    public static void suggestFriends(SocialMediaSystem user1, SocialMediaSystem user2) {
        HashSet<String> mutualFollowers = new HashSet<>(user1.followers);
        mutualFollowers.retainAll(user2.followers);

        HashSet<String> uniqueToUser1 = new HashSet<>(user1.followers);
        uniqueToUser1.removeAll(user2.followers);

        HashSet<String> uniqueToUser2 = new HashSet<>(user2.followers);
        uniqueToUser2.removeAll(user1.followers);

        System.out.println("Mutual Followers: " + mutualFollowers);
        System.out.println(user1.username + " should follow: " + uniqueToUser2);
        System.out.println(user2.username + " should follow: " + uniqueToUser1);
    }

    public void traverseFollowers() {
        Iterator<String> iterator = followers.iterator();
        System.out.println("Traversing " + username + "'s followers:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args) {
        SocialMediaSystem userA = new SocialMediaSystem("Alice");
        userA.addFollower("Bob");
        userA.addFollower("Charlie");
        userA.addFollower("David");

        SocialMediaSystem userB = new SocialMediaSystem("Eve");
        userB.addFollower("Charlie");
        userB.addFollower("David");
        userB.addFollower("Frank");

        userA.displayFollowers();
        userB.displayFollowers();
        
        System.out.println("\nFriend Suggestions:");
        suggestFriends(userA, userB);
        
        System.out.println("\nTraversing Followers:");
        userA.traverseFollowers();
    }
}