package gmd.core.demo.client.application.navigation;

public class Dashboard {

    private String title;
    private String description;
    private String url;
    private String image;
    private boolean enabled = true;

    public Dashboard(String title, String description, String url, String image) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.image = image;
    }

    public Dashboard(String title, String url, String image) {
        this.title = title;
        this.url = url;
        this.image = image;
    }


    public Dashboard(String title, String description, String url, String image, boolean enabled) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.image = image;
        this.enabled = enabled;
    }

    public Dashboard(String url, String image) {
        this.url = url;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
