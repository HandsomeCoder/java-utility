package io.github.handsomecoder.utils.http;

import io.github.handsomecoder.utils.ObjectUtils;

import static io.github.handsomecoder.utils.ObjectUtils.isAllNotNull;
import static io.github.handsomecoder.utils.ObjectUtils.isAnyNull;

/**
 * The type Http response entity.
 */
public class HttpResponseEntity {

    private Integer statusCode;

    private String body;

    private boolean isEmpty;

    /**
     * Gets empty response.
     *
     * @return the empty response
     */
    public static HttpResponseEntity getEmptyResponse() {
        return new HttpResponseEntity(null, null);
    }

    /**
     * Instantiates a new Http response entity.
     *
     * @param statusCode the status code
     * @param body       the body
     */
    public HttpResponseEntity(Integer statusCode, String body) {
        this.isEmpty = false;

        if(isAllNotNull(statusCode, body)){
            this.isEmpty = true;
        }

        this.statusCode = statusCode;
        this.body = body;
    }

    /**
     * Gets status code.
     *
     * @return the status code
     */
    public Integer getStatusCode() {
        return statusCode;
    }

    /**
     * Gets body.
     *
     * @return the body
     */
    public String getBody() {
        return body;
    }

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    public boolean isEmpty() {
        return isEmpty;
    }
}
