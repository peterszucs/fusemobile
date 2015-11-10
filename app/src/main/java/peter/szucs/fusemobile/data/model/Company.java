package peter.szucs.fusemobile.data.model;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;

/**
 * Created by peterszucs on 10/11/15.
 */
public class Company {

    @Getter
    private String name;

    @Getter
    private String logo;

    @Getter
    @SerializedName("custom_color")
    private String customColor;

    @Getter
    @SerializedName("password_changing")
    private PasswordChanging passwordChanging;

    /*
    {
     "name": "Fuse",
     "logo": "http://fusion.fusion-universal.com...”,
     "custom_color": "#ea2184",
     "password_changing": {
         "enabled": false,
         "secure_field": null
      }
    }
     */

}
