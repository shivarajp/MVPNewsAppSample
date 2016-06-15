package com.shivarajpatil.mvpnewsapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by SYS on 31-May-2016.
 */

public class NewsDetailsModel implements Serializable {

    @SerializedName("headline")
    @Expose
    private String headline;
    @SerializedName("details")
    @Expose
    private String details;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("comment_id")
    @Expose
    private String commentId;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("replies")
    @Expose
    private Integer replies;
    @SerializedName("avatar_url")
    @Expose
    private String avatarUrl;

    /**
     * @return The headline
     */
    public String getHeadline() {
        return headline;
    }

    /**
     * @param headline The headline
     */
    public void setHeadline(String headline) {
        this.headline = headline;
    }

    /**
     * @return The details
     */
    public String getDetails() {
        return details;
    }

    /**
     * @param details The details
     */
    public void setDetails(String details) {
        this.details = details;
    }

    /**
     * @return The time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time The time
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return The commentId
     */
    public String getCommentId() {
        return commentId;
    }

    /**
     * @param commentId The comment_id
     */
    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    /**
     * @return The userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId The user_id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return The replies
     */
    public Integer getReplies() {
        return replies;
    }

    /**
     * @param replies The replies
     */
    public void setReplies(Integer replies) {
        this.replies = replies;
    }

    /**
     * @return The avatarUrl
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * @param avatarUrl The avatar_url
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

}