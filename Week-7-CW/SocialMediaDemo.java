import javax.swing.text.AbstractDocument.Content;

class SocialMediaPost {
protected String content;
protected String author;
public SocialMediaPost(String content, String author) {
this.content = content;
this.author = author;
}
// TODO: Create 'share()' method that prints "Sharing: [content] by [author]"



void share() {
// ... (implementation)
System.out.println("Sharing: "+content+" by "+author);
}
}
class InstagramPost extends SocialMediaPost {
private int likes;
InstagramPost(String content, String author, int likes) {
super(content, author);
this.likes = likes;
}
// TODO: Override 'share()' to print " Instagram: [content] by @[author] - [likes] likes "
@Override
void share() {
// ... (implementation)
System.out.println("Instagram: "+content+" by "+author+" - "+likes+" likes");
}
}
class TwitterPost extends SocialMediaPost {
private int retweets;
TwitterPost(String content, String author, int retweets) {
super(content, author);
this.retweets = retweets;
}
// TODO: Override 'share()' to print "Tweet: [content] by @[author] - [retweets] retweets "
@Override
void share() {
// ... (implementation)
System.out.println("Tweet: "+content+" by "+author+" - "+retweets+" retweets");
}
}



public class SocialMediaDemo {
public static void main(String[] args) {
// TODO: Social Media Feed Simulation:
// 1. Create array of SocialMediaPost references
// 2. Add InstagramPost("Sunset vibes!", "john_doe", 245)
// 3. Add TwitterPost("Java is awesome!", "code_ninja", 89)
// 4. Add regular SocialMediaPost("Hello world!", "beginner")
// 5. Loop through and call share() on each - observe different behaviors!
SocialMediaPost[] posts= new SocialMediaPost[3];
posts[0]= new InstagramPost("This is Instagram", "Arpit1", 245);
posts[1]= new TwitterPost("This is Twitter", "Arpit2", 89);
posts[2]= new SocialMediaPost("Normal social media post", "Arpit3");
for (SocialMediaPost post : posts) {
post.share();
}

}
}