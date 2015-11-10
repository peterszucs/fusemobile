package peter.szucs.fusemobile.data.model;

import lombok.Getter;
import peter.szucs.fusemobile.R;

/**
 * Created by peterszucs on 10/11/15.
 */
public enum ErrorType {

    COMPANY_NAME_EMPTY(R.string.error_empty_input_field),
    COMPANY_NAME_INVALID(R.string.error_input_field_length);

    @Getter
    private int resourceId;

    ErrorType(int resourceId) {
        this.resourceId = resourceId;
    }
}
