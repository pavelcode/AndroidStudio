package com.cblue.a3dmgame.utils;

/**
 * Created by pavel on 16/6/12.
 */
public class PathUtils {

    //http://www.3dmgame.com/sitemap/api.php?row=<记录数>&typeid=<分类ID>&paging=1&page=n
    public static String getArtcleListPath(int row, int id, int page) {

        return "http://www.3dmgame.com/sitemap/api.php?row=" + row + "&typeid="
                + id + "&paging=1&page=" + page;

    }

    public static String getArtclePath(String type, String id) {

        return "http://www.3dmgame.com/sitemap/api.php?id="+id+"&typeid="+type;

    }


    public static String getCommentListPath(String id, String page) {

        return "http://www.3dmgame.com/sitemap/api.php?type=1&aid="+id+"&pageno="+page;

    }
    public static String getGameListPath(int row, int id, int page) {

        return "http://www.3dmgame.com/sitemap/api.php?row="+row+"&typeid="+id+"&paging=1&page="+page;

    }
    public static String getGameDetailPaht(String id,String typeid){
        return "http://www.3dmgame.com/sitemap/api.php?id="+id+"&typeid="+typeid;
    }
}
