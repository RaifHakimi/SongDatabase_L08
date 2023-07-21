package sg.edu.rp.c346.id22016635.song_l08;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Song implements Serializable {
    private int _id;
    private String title;
    private String singers;
    private int year;
    private int stars;

    public Song(int _id,String title, String singers, int year, int stars){

        this._id = _id;
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.stars = stars;
    }


    public String getTitle(){
        return title;
    }

    public String getSingers(){
        return singers;
    }

    public int getYear(){
        return year;
    }

    public int getStars(){
        return stars;
    }

    public int getId(){return _id;}

    public void setTitle(String title){
        this.title = title;
    }
    public void setSingers(String singers){
        this.singers = singers;
    }
    public void setYear(int year){
        this.year = year;
    }
    public void setStars(int stars){
        this.stars = stars;
    }
    @NonNull
    @Override
    public String toString(){
        String output = "";
        if(stars == 1){
            output = "  *";
        } else if (stars == 2) {
            output = "  * *";
        } else if (stars == 3) {
            output = "  * * *";
        }else if (stars == 4){
            output = "  * * * *";
        }else if(stars == 5){
            output = "  * * * * *";
        }

        return output;
    }

}
