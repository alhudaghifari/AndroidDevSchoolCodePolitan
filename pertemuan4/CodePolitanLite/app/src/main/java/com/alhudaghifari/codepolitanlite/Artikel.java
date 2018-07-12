package com.alhudaghifari.codepolitanlite;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ghifar on 11/07/18.
 */

public class Artikel implements Parcelable {

    String id;
    String slug;
    String title;
    String author_name;
    String author_image;
    String description;
    String date;
    String link;
    String thumbnail;
    String total_views;



    public Artikel() {

    }

    public Artikel(String id, String slug, String title, String author_name, String author_image, String description, String date, String link, String thumbnail, String total_views) {
        this.id = id;
        this.slug = slug;
        this.title = title;
        this.author_name = author_name;
        this.author_image = author_image;
        this.description = description;
        this.date = date;
        this.link = link;
        this.thumbnail = thumbnail;
        this.total_views = total_views;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_image() {
        return author_image;
    }

    public void setAuthor_image(String author_image) {
        this.author_image = author_image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTotal_views() {
        return total_views;
    }

    public void setTotal_views(String total_views) {
        this.total_views = total_views;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeString(this.id);
        dest.writeString(this.slug);
        dest.writeString(this.title);
        dest.writeString(this.author_name);
        dest.writeString(this.author_image);
        dest.writeString(this.description);
        dest.writeString(this.date);
        dest.writeString(this.link);
        dest.writeString(this.thumbnail);
        dest.writeString(this.total_views);
    }

    protected Artikel(Parcel in) {
        this.id = in.readString();
        this.slug = in.readString();
        this.title = in.readString();
        this.author_name = in.readString();
        this.author_image = in.readString();
        this.description = in.readString();
        this.date = in.readString();
        this.link = in.readString();
        this.thumbnail = in.readString();
        this.total_views = in.readString();
    }

    public static final Parcelable.Creator<Artikel> CREATOR = new
            Parcelable.Creator<Artikel>() {
                @Override
                public Artikel createFromParcel(Parcel source) {
                    return new Artikel(source);
                }
                @Override
                public Artikel[] newArray(int size) {
                    return new Artikel[size];
                }
            };
}
