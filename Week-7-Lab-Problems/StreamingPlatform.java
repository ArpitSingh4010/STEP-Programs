class Content {
    String title;
    Content(String title) {
        this.title = title;
    }
    void play() {
        System.out.println("Playing: " + title);
    }
}

class Movie extends Content {
    double rating;
    int duration;
    boolean subtitles;
    Movie(String title, double rating, int duration, boolean subtitles) {
        super(title);
        this.rating = rating;
        this.duration = duration;
        this.subtitles = subtitles;
    }
    void showMovieDetails() {
        System.out.println("Movie: " + title + " | Rating: " + rating + " | Duration: " + duration + " mins | Subtitles: " + (subtitles ? "Available" : "No"));
    }
}

class TVSeries extends Content {
    int seasons;
    int episodes;
    TVSeries(String title, int seasons, int episodes) {
        super(title);
        this.seasons = seasons;
        this.episodes = episodes;
    }
    void suggestNextEpisode() {
        System.out.println("TV Series: " + title + " | Next episode available. Seasons: " + seasons + ", Episodes: " + episodes);
    }
}

class Documentary extends Content {
    String tag;
    String related;
    Documentary(String title, String tag, String related) {
        super(title);
        this.tag = tag;
        this.related = related;
    }
    void showEducationalContent() {
        System.out.println("Documentary: " + title + " | Tag: " + tag + " | Related: " + related);
    }
}

public class StreamingPlatform{
    public static void main(String[] args) {
        Content c1 = new Movie("Inception", 8.8, 148, true);
        Content c2 = new TVSeries("Breaking Bad", 5, 62);
        Content c3 = new Documentary("Planet Earth", "Nature", "Our Planet");

        Content[] watchlist = {c1, c2, c3};

        for(Content c : watchlist) {
            c.play();

            if(c instanceof Movie) {
                Movie m = (Movie) c;
                m.showMovieDetails();
            } else if(c instanceof TVSeries) {
                TVSeries t = (TVSeries) c;
                t.suggestNextEpisode();
            } else if(c instanceof Documentary) {
                Documentary d = (Documentary) c;
                d.showEducationalContent();
            }
        }
    }
}
