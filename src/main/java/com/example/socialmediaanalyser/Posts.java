package com.example.socialmediaanalyser;

public class Posts {
    //declaration of variables
    public int PostID;
    public String Content;
    public String Author;
    public int Likes;
    public int Shares;
    public String dateTime;

    //Posts (compareTo method)
    public Posts(int PostID, int Likes, int Shares) {
        this.PostID = PostID;
        this.Likes = Likes;
        this.Shares = Shares;
    }

    //posts (arraylist method - add and delete)
    public Posts(int PostID, String Content, String Author, int Likes, int Shares, String dateTime) {
        this.PostID = PostID;
        this.Content = Content;
        this.Author = Author;
        this.Likes = Likes;
        this.Shares = Shares;
        this.dateTime = dateTime;
    }

    //setter methods
    public void setPostID(int PostID) {
        this.PostID = PostID;
    }

    public void setContent(String Content) {
        this.PostID = PostID;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public void setLikes(int Likes) {
        this.Likes = Likes;
    }

    public void setShares(int Shares) {
        this.Shares = Shares;
    }

    //toString method
    @Override
    public String toString() {
        return "Post ID: " + PostID + "\n" +
                "Post Content: " + Content + "\n" +
                "Post Author: " + Author + "\n" +
                "Post Likes: " + Likes + "\n" +
                "Post Shares: " + Shares + "\n" +
                "Post Date and Time: " + dateTime + "\n" +
                "-----------------------------------" + "\n";
    }

    //sort by likes/shares
}
