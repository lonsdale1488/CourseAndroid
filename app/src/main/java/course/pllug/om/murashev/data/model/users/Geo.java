package course.pllug.om.murashev.data.model.users;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Geo {


    @SerializedName("lat")
    @Expose
    private String lat;



    @SerializedName("lng")
    @Expose
    private String lng;


    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }
    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
//    "geo": {
//            "lat": "-37.3159",
//                    "lng": "81.1496"
}
