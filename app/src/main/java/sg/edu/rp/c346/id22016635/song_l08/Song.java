package sg.edu.rp.c346.id22016635.song_l08;

import androidx.annotation.NonNull;

public class Song {
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

    @NonNull
    @Override
    public String toString(){
        return _id + "\n" +singers + "\n" + title + "\n" + year + "\n" + stars;
    }

}
