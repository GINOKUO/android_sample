package gino.com.myapplication;

/**
 * Created by gino_kuo on 2018/9/10.
 */

public class Member {
    private int id;
    private int image;
    private String name;
    private String url;

    public Member() {
        super();
    }

    public Member(int id, int image, String name,String Url) {
        super();
        this.id = id;
        this.image = image;
        this.name = name;
        this.url = Url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() { return  url;}

    public void setUrl() { this.url = url;}
}
