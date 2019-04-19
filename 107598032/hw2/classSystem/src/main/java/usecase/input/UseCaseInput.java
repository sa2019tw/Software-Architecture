package usecase.input;

public class UseCaseInput {
    private int id;
    private String name;
    private String content = "";
    private String member = "";
    private int price = 0;
    private String notice = "";
    private String remark = "";

    public UseCaseInput(int id, String name, String content, String member, int price, String notice, String remark){
        this.id = id;
        this.name = name;
        this.content = content;
        this.member = member;
        this.price = price;
        this.notice = notice;
        this.remark = remark;
    }

    public int getId() { return id; }

    public String getName() { return name; }

    public String getContent() { return content; }

    public String getMember() { return member; }

    public int getPrice() { return price; }

    public String getNotice() { return notice; }

    public String getRemark() { return remark; }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
