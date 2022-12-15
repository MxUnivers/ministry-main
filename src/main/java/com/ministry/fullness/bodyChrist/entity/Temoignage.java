package com.ministry.fullness.bodyChrist.entity;

import javax.persistence.*;

@Entity
@Table(name="temoignages")
public class Temoignage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String coverPicture ;
    private String description ;
    private String  content  ;
    private String  video  ;
    private String  audio  ;
    private Boolean visible = true ;


    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }


    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }



    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public String getTitle() {
        return title;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCoverPicture() {
        return coverPicture;
    }

    public void setCoverPicture(String coverPicture) {
        this.coverPicture = coverPicture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
