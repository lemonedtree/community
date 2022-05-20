package com.community.entity;

/**
 * @author XD
 * @create 2022-05-18 15:39
 */
public class Page {
    //当前页码
    private int current = 1;
    private int limit = 10;
    //数据总数
    private int rows;
    private String path;

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if (limit >= 1 && limit <= 100) {
            this.limit = limit;
        }
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if(current >= 1) {
            this.current = current;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if(rows >= 1) {
            this.rows = rows;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    //第一页的第一个是0吗
    public int getOffset() {
        return (current - 1) * limit;
    }

    /**
     * 返回有多少页
     * @return
     */
    public int getTotal() {
        return (rows % limit == 0) ? (rows / limit) : (rows / limit - 1);
    }

    public int getFrom() {
        return current - 3 <= 1 ? 1 : current - 3;
    }

    public int getTo() {
        return current + 3 >= getTotal() ? getTotal() : current + 3;
    }
}
