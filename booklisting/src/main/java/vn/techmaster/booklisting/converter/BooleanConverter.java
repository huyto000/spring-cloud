package vn.techmaster.booklisting.converter;

import com.opencsv.bean.AbstractBeanField;

public class BooleanConverter extends AbstractBeanField {

  @Override
  protected Object convert(String s) {
    if ("true".equalsIgnoreCase(s)) {
      return true;
    } else {
      return false;
    }
  }

}
