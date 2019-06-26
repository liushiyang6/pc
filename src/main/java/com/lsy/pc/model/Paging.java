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
public class Paging {

    private boolean is_end;
    private boolean is_start;
    private String next;
    private String previous;
    private int totals;
    public void setIs_end(boolean is_end) {
         this.is_end = is_end;
     }
     public boolean getIs_end() {
         return is_end;
     }

    public void setIs_start(boolean is_start) {
         this.is_start = is_start;
     }
     public boolean getIs_start() {
         return is_start;
     }

    public void setNext(String next) {
         this.next = next;
     }
     public String getNext() {
         return next;
     }

    public void setPrevious(String previous) {
         this.previous = previous;
     }
     public String getPrevious() {
         return previous;
     }

    public void setTotals(int totals) {
         this.totals = totals;
     }
     public int getTotals() {
         return totals;
     }

}