package course.pllug.om.murashev.model.users;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Users {



    @SerializedName("id")
    @Expose
    private long id;



    @SerializedName("name")
    @Expose
    private String name;


    @SerializedName("username")
    @Expose
    private String username;



    @SerializedName("email")
    @Expose
    private String email;


    @SerializedName("address")
    @Expose
    private Address address;

    @SerializedName("phone")
    @Expose
    private String phone;

    @SerializedName("website")
    @Expose
    private String website;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @SerializedName("company")
    @Expose
    private Company company;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }







//    {
//        "id": 1,
//            "name": "Leanne Graham",
//            "username": "Bret",
//            "email": "Sincere@april.biz",

//            "address": {
//
//                    "street": "Kulas Light",
//                    "suite": "Apt. 556",
//                    "city": "Gwenborough",
//                    "zipcode": "92998-3874",
//                    "geo": {
//                     "lat": "-37.3159",
//                    "lng": "81.1496"
//        }
//    },
//        "phone": "1-770-736-8031 x56442",
//            "website": "hildegard.org",
//            "company": {
//        "name": "Romaguera-Crona",
//                "catchPhrase": "Multi-layered client-server neural-net",
//                "bs": "harness real-time e-markets"
//    }
//    }
}
