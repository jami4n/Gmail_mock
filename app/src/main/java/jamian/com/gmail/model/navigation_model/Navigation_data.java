package jamian.com.gmail.model.navigation_model;

public class Navigation_data {

    String title;
    int imageid;
    String tag;
    int menuid;

    public Navigation_data(String title, int imageid, String tag, int menuid) {
        this.title = title;
        this.imageid = imageid;
        this.tag = tag;
        this.menuid = menuid;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getMenuid() {
        return menuid;
    }

    public void setMenuid(int menuid) {
        this.menuid = menuid;
    }
}
