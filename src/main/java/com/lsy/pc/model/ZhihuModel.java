/**
  * Copyright 2019 bejson.com 
  */
package com.lsy.pc.model;
import java.util.List;

/**
 * Auto-generated: 2019-06-26 17:4:40
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class ZhihuModel {

    private List<Data> data;
    private Paging paging;
    public void setData(List<Data> data) {
         this.data = data;
     }
     public List<Data> getData() {
         return data;
     }

    public void setPaging(Paging paging) {
         this.paging = paging;
     }
     public Paging getPaging() {
         return paging;
     }

}