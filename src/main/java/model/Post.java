package model;

import java.util.List;

public class Post {
    private final long id;
    private final String title;
    private final String body;
    private final long userId;
    private final List<String> tags;
    private final long reactions;

    /** Time of publishing in ISO format, for example "2023-04-10T09:45:00Z" */
    private final String publishedAt;

    /**
     * Optional time of deletion in ISO format, for example "2023-04-10T09:45:00Z"
     */
    private final String deletedAt;

    public Post(long id, String title, String body, long userId, List<String> tags, long reactions, String publishedAt,
            String deletedAt) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.tags = tags;
        this.reactions = reactions;
        this.publishedAt = publishedAt;
        this.deletedAt = deletedAt;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public long getUserId() {
        return userId;
    }

    public List<String> getTags() {
        return tags;
    }

    public long getReactions() {
        return reactions;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getDeletedAt() {
        return deletedAt;
    }

}
