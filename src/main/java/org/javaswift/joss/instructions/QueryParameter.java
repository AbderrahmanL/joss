package org.javaswift.joss.instructions;

import org.apache.http.NameValuePair;
import org.javaswift.joss.util.SpaceURLEncoder;

import java.io.UnsupportedEncodingException;

public class QueryParameter implements NameValuePair {

    private String name;

    private Object value;

    public QueryParameter(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getValue() {
        return this.value == null ? null : this.value.toString();
    }

    public String getQuery() {
        return getValue() == null ? null : urlEncode(getName()) + "=" + urlEncode(getValue());
    }

    private String urlEncode(String value) {
        try {
            return SpaceURLEncoder.encode(value);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
