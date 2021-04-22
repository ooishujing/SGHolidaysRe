package sg.edu.rp.c346.sgholidays;

public class Holiday {
    private String name;
    private int image;
    private String date;
    private String type;

    public Holiday(String name, int image, String date) {
        this.name = name;
        this.image = image;
        this.date = date;
    }



    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public String getDate() {
        return date;
    }


}
