package peter.szucs.fusemobile.data.model;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;

/**
 * Created by peterszucs on 10/11/15.
 */
public class PasswordChanging {

    @Getter
    private boolean enabled;

    @SerializedName("secure_field")
    private String secureField;


}
/*
    "password_changing": {
         "enabled": false,
         "secure_field": null
      }
 */