package mybatis.model;

public class modelBook {

    
    Integer         bookid;
    String      bookname;
    String      publisher;
    String      year;
    Integer         price;
    String      dtm;
    Boolean     use_yn;
    int         authid;
    public Integer getBookid() {
        return bookid;
    }
    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }
    public String getBookname() {
        return bookname;
    }
    public void setBookname(String bookname) {
        this.bookname = bookname;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public String getDtm() {
        return dtm;
    }
    public void setDtm(String dtm) {
        this.dtm = dtm;
    }
    public Boolean getUse_yn() {
        return use_yn;
    }
    public void setUse_yn(Boolean use_yn) {
        this.use_yn = use_yn;
    }
    public int getAuthid() {
        return authid;
    }
    public void setAuthid(int authid) {
        this.authid = authid;
    }
    public modelBook(Integer bookid, String bookname, String publisher,
            String year, Integer price, String dtm, Boolean use_yn,
            int authid) {
        super();
        this.bookid = bookid;
        this.bookname = bookname;
        this.publisher = publisher;
        this.year = year;
        this.price = price;
        this.dtm = dtm;
        this.use_yn = use_yn;
        this.authid = authid;
    }
    public modelBook() {
        super();
    }
    @Override
    public String toString() {
        return "modelBook [bookid=" + bookid + ", bookname=" + bookname
                + ", publisher=" + publisher + ", year=" + year + ", price="
                + price + ", dtm=" + dtm + ", use_yn=" + use_yn + ", authid="
                + authid + "]";
    }
   
    
}
