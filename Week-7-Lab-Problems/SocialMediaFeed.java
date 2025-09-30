class Post {
    String author;
    String content;
    String time;

    Post(String author, String content, String time) {
        this.author = author;
        this.content = content;
        this.time = time;
    }

    void display() {
        System.out.println(author + " posted: " + content + " at " + time);
    }
}

class InstagramPost extends Post {
    int likes;
    String hashtags;

    InstagramPost(String author, String content, String time, int likes, String hashtags) {
        super(author, content, time);
        this.likes = likes;
        this.hashtags = hashtags;
    }

    void display() {
        System.out.println("Instagram Post by " + author + ": " + content + " " + hashtags +" | Likes: " + likes + " | Time: " + time);
    }
}

class TwitterPost extends Post {
    int retweets;

    TwitterPost(String author, String content, String time, int retweets) {
        super(author, content, time);
        this.retweets = retweets;
    }

    void display() {
        System.out.println("Twitter Post by " + author + ": \"" + content + "\" (" + content.length() +" chars) | Retweets: " + retweets + " | Time: " + time);
    }
}

class LinkedInPost extends Post {
    int connections;

    LinkedInPost(String author, String content, String time, int connections) {
        super(author, content, time);
        this.connections = connections;
    }

    void display() {
        System.out.println("LinkedIn Post by " + author + "\nContent: " + content +"\nConnections Engaged: " + connections + "\nTime: " + time);
    }
}

public class SocialMediaFeed {
    public static void main(String[] args) {
        Post p1 = new InstagramPost("Arpit", "Enjoying the beach!", "10:30 AM", 120, "#BeachLife #Sunset");
        Post p2 = new TwitterPost("Arpit", "Learning Java OOP concepts today!", "11:15 AM", 45);
        Post p3 = new LinkedInPost("Arpit", "Excited to start my new internship!", "12:00 PM", 80);

        p1.display();
        p2.display();
        p3.display();
    }
}
