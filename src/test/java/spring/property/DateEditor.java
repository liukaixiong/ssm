package spring.property;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Liukx
 * @create 2017-12-12 17:31
 * @email liukx@elab-plus.com
 **/
public class DateEditor extends PropertyEditorSupport {

    public final SimpleDateFormat sdf = new SimpleDateFormat(
            "yyyy-MM-dd");
    public Date dt;

    public boolean isDate(String date) {
        try {
            dt = sdf.parse(date);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (isDate(text)) {
            setValue(dt);
        } else {
            setValue(null);
        }
    }


}
