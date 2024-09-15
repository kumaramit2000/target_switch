package models;

import java.util.UUID;

@Data
public class Comments {
    String commentId;
    String Comment;

    public Comments (String comment) {
        this.commentId = UUID.randomUUID().toString();
        this.Comment = comment;
    }
}
