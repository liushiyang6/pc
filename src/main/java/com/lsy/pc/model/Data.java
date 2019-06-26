/**
  * Copyright 2019 bejson.com 
  */
package com.lsy.pc.model;

/**
 * Auto-generated: 2019-06-26 17:4:40
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Data {

    private long id;
    private String type;
    private String answer_type;
    private Question question;
    private Author author;
    private String url;
    private boolean is_collapsed;
    private long created_time;
    private long updated_time;
    private String extras;
    private boolean is_copyable;
    private Relationship relationship;
    public void setId(long id) {
         this.id = id;
     }
     public long getId() {
         return id;
     }

    public void setType(String type) {
         this.type = type;
     }
     public String getType() {
         return type;
     }

    public void setAnswer_type(String answer_type) {
         this.answer_type = answer_type;
     }
     public String getAnswer_type() {
         return answer_type;
     }

    public void setQuestion(Question question) {
         this.question = question;
     }
     public Question getQuestion() {
         return question;
     }

    public void setAuthor(Author author) {
         this.author = author;
     }
     public Author getAuthor() {
         return author;
     }

    public void setUrl(String url) {
         this.url = url;
     }
     public String getUrl() {
         return url;
     }

    public void setIs_collapsed(boolean is_collapsed) {
         this.is_collapsed = is_collapsed;
     }
     public boolean getIs_collapsed() {
         return is_collapsed;
     }

    public void setCreated_time(long created_time) {
         this.created_time = created_time;
     }
     public long getCreated_time() {
         return created_time;
     }

    public void setUpdated_time(long updated_time) {
         this.updated_time = updated_time;
     }
     public long getUpdated_time() {
         return updated_time;
     }

    public void setExtras(String extras) {
         this.extras = extras;
     }
     public String getExtras() {
         return extras;
     }

    public void setIs_copyable(boolean is_copyable) {
         this.is_copyable = is_copyable;
     }
     public boolean getIs_copyable() {
         return is_copyable;
     }

    public void setRelationship(Relationship relationship) {
         this.relationship = relationship;
     }
     public Relationship getRelationship() {
         return relationship;
     }

}