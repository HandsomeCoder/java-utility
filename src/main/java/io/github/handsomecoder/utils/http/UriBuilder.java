package io.github.handsomecoder.utils.http;

import io.github.handsomecoder.exceptions.InvalidURLSyntaxException;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import static io.github.handsomecoder.utils.ObjectUtils.isNull;

/**
 * The type Uri builder.
 *
 * @author Harsh Shah
 */
public class UriBuilder {

    private UriBuilder(){}

    private StringBuilder urlStringBuilder;

    private int numberOfQuery;

    /**
     * From uri builder.
     *
     * @param url the url
     * @return the uri builder
     */
    public static UriBuilder from(String url) {

        UriBuilder builder = new UriBuilder();
        try {
            new URI(url);
            builder.setUrlStringBuilder(new StringBuilder(url));
            builder.setNumberOfQuery(0);
        } catch (URISyntaxException e) {
            throw new InvalidURLSyntaxException(e.getMessage());
        }

        return builder;
    }

    /**
     * Add query params uri builder.
     *
     * @param queryParams the query params
     * @return the uri builder
     */
    public UriBuilder addQueryParams(Map<String, Object> queryParams){

        if(isNull(queryParams) || queryParams.isEmpty()){
            return this;
        }

        for (Map.Entry<String, Object> queryParam : queryParams.entrySet()) {
            addQueryParams(queryParam.getKey(), queryParam.getValue());
        }

        return this;
    }

    /**
     * Add query params uri builder.
     *
     * @param key   the key
     * @param value the value
     * @return the uri builder
     */
    public UriBuilder addQueryParams(String key, Object value){

        if(this.getNumberOfQuery() == 0){
            this.urlStringBuilder.append("?");
        } else {
            this.urlStringBuilder.append("&");
        }

        this.urlStringBuilder.append(key);
        this.urlStringBuilder.append("=");
        this.urlStringBuilder.append(value);

        this.addNumberOfQuery();

        return this;
    }

    /**
     * Build uri.
     *
     * @return the uri
     */
    public URI build(){
        return URI.create(this.getUrlStringBuilder().toString());
    }

    /**
     * Gets url string builder.
     *
     * @return the url string builder
     */
    public StringBuilder getUrlStringBuilder() {
        return urlStringBuilder;
    }

    /**
     * Sets url string builder.
     *
     * @param urlStringBuilder the url string builder
     */
    public void setUrlStringBuilder(StringBuilder urlStringBuilder) {
        this.urlStringBuilder = urlStringBuilder;
    }

    /**
     * Gets number of query.
     *
     * @return the number of query
     */
    public int getNumberOfQuery() {
        return numberOfQuery;
    }

    /**
     * Sets number of query.
     *
     * @param numberOfQuery the number of query
     */
    public void setNumberOfQuery(int numberOfQuery) {
        this.numberOfQuery = numberOfQuery;
    }
    private void addNumberOfQuery() {
        this.numberOfQuery++;
    }
}
