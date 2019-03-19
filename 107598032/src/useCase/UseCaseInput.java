package useCase;

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
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
