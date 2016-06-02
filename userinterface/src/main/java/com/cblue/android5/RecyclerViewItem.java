package com.cblue.android5;

/**
 * Created by pavel on 16/5/26.
 */
public class RecyclerViewItem {

    private int imgID;
    private String msg;

    public RecyclerViewItem() {
    }

    public RecyclerViewItem(int imgID, String msg) {
        this.imgID = imgID;
        this.msg = msg;
    }

    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
