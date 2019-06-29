/**
 * Copyright 2019 bejson.com
 */
package com.lsy.pc.model.json.zhihu;

/**
 * @author LSY
 * @version 1.0
 * @date 2019/6/28 14:47
 */
public class Paging {

    private boolean is_end;
    private boolean is_start;
    private String next;
    private String previous;
    private int totals;

    public boolean is_end() {
        return this.is_end;
    }

    public boolean is_start() {
        return this.is_start;
    }

    public String getNext() {
        return this.next;
    }

    public String getPrevious() {
        return this.previous;
    }

    public int getTotals() {
        return this.totals;
    }

    public void setIs_end(boolean is_end) {
        this.is_end = is_end;
    }

    public void setIs_start(boolean is_start) {
        this.is_start = is_start;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public void setTotals(int totals) {
        this.totals = totals;
    }
}